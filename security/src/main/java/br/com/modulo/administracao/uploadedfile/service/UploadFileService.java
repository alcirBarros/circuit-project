package br.com.modulo.administracao.uploadedfile.service;

import br.com.configuracao.util.CPFValidator;
import br.com.modulo.administracao.aluno.model.Aluno;
import br.com.modulo.administracao.aluno.model.Responsavel;
import br.com.modulo.administracao.uploadedfile.model.InconsistenciaEnum;
import br.com.modulo.administracao.uploadedfile.model.RegistroImportacao;
import br.com.modulo.administracao.aluno.service.AlunoService;
import br.com.modulo.administracao.responsavel.service.ResponsavelService;
import br.com.modulo.administracao.uploadedfile.model.Registro;
import com.exception.BusinessException;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileService {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private ResponsavelService responsavelService;

    public void processar(Registro registro) {
        List<RegistroImportacao> registroImportacaoList = registro.getRegistroImportacaoList();

        for (RegistroImportacao registroImportacao : registroImportacaoList) {
            try {
                Responsavel responsavel = responsavelService.carregarResponsavel(registroImportacao);
                responsavel = responsavelService.salvar(responsavel);
                System.out.println(responsavel.getDisplay());
            } catch (BusinessException bx) {
                System.out.println(bx.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<RegistroImportacao> converterRegistro(File file) {
        try {
            FileInputStream arquivo = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet planilha = workbook.getSheetAt(0);

            Iterator<Row> linhas = planilha.iterator();
            List<RegistroImportacao> registroList = new ArrayList<>();

            while (linhas.hasNext()) {
                Row linha = linhas.next();
                Iterator<Cell> cellIterator = linha.cellIterator();
                RegistroImportacao registroImportacao = converterTo(cellIterator);
                if (validaRegistro(registroImportacao)) {
                    registroImportacao = inconsistencia(registroImportacao);
                    registroList.add(registroImportacao);
                }
            }
            return registroList;
        } catch (Exception e) {
            throw new BusinessException("Arquivo de importação não selecionado.");
        }
    }

    private RegistroImportacao inconsistencia(RegistroImportacao registroImportacao) {
        String nomeAluno = registroImportacao.getNomeAluno();
        String cpfResponsavel = registroImportacao.getCpfResponsavel();

        if (CPFValidator.validatorCPF(cpfResponsavel)) {
            registroImportacao.setInconsistenciaEnum(InconsistenciaEnum.CPF);
        }

        Aluno aluno = alunoService.carregar(registroImportacao);
        if (aluno == null || nomeAluno.trim().equals("")) {
            registroImportacao.setInconsistenciaEnum(InconsistenciaEnum.ALUNO_NAO_CADASTRADO);
        }
        return registroImportacao;
    }

    private boolean validaRegistro(RegistroImportacao registroImportacao) {
        boolean result = true;
        if ((registroImportacao.getNomeAluno() != null && registroImportacao.getNomeAluno().equals("Nome")) || RegistroImportacao.isNULL(registroImportacao)) {
            result = false;
        }
        return result;
    }

    private RegistroImportacao converterTo(Iterator<Cell> cellIterator) {
        RegistroImportacao registroImportacao = new RegistroImportacao();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            switch (cell.getColumnIndex()) {
                case 0:
                    registroImportacao.setNomeAluno(cell.getStringCellValue());
                    break;
                case 1:
                    registroImportacao.setNomeResponsavel(cell.getStringCellValue());
                    break;
                case 2:
                    registroImportacao.setCpfResponsavel(cell.getStringCellValue());
                    break;
            }
        }
        return registroImportacao;
    }
}
