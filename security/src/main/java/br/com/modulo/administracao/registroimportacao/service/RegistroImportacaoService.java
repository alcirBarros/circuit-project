package br.com.modulo.administracao.registroimportacao.service;

import br.com.configuracao.util.CPFValidator;
import br.com.modulo.administracao.aluno.model.Aluno;
import br.com.modulo.administracao.aluno.model.Responsavel;
import br.com.modulo.administracao.aluno.service.AlunoService;
import br.com.modulo.administracao.pessoa.dao.RegistroImportacaoDAO;
import br.com.modulo.administracao.registroimportacao.model.InconsistenciaEnum;
import br.com.modulo.administracao.registroimportacao.model.Registro;
import br.com.modulo.administracao.registroimportacao.model.RegistroImportacao;
import br.com.modulo.administracao.registroimportacao.model.UploadedRegistro;
import br.com.modulo.administracao.responsavel.service.ResponsavelService;
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
public class RegistroImportacaoService {

    @Autowired
    private RegistroImportacaoDAO registroImportacaoDAO;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private ResponsavelService responsavelService;

    public void salvar(Registro registro) {
        registroImportacaoDAO.salvar(registro);
    }

    public Registro alterar(Registro registro) {
        return registroImportacaoDAO.alterar(registro);
    }

    public List<Registro> listar() {
        return registroImportacaoDAO.listar();
    }

    public void processar(Registro registro) {
        List<RegistroImportacao> registroImportacaoList = registro.getRegistroImportacaoList();

        for (RegistroImportacao registroImportacao : registroImportacaoList) {
            try {
                if (registroImportacao.getInconsistenciaEnum().getValue().equals(InconsistenciaEnum.SEM_INCONSISTENCIA.getValue())) {
                    Responsavel responsavel = responsavelService.carregarResponsavel(registroImportacao);
                    responsavel = responsavelService.salvar(responsavel);
                    System.out.println(responsavel.getDisplay());
                }
            } catch (BusinessException bx) {
                System.out.println(bx.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<RegistroImportacao> converterRegistro(List<UploadedRegistro> uploadedRegistroList) {
        try {
            List<RegistroImportacao> registroList = new ArrayList<>();
            for (UploadedRegistro uploadedRegistro : uploadedRegistroList) {
                File file = uploadedRegistro.getUploaded().getArquivo();
                FileInputStream arquivo = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
                XSSFSheet planilha = workbook.getSheetAt(0);
                Iterator<Row> linhas = planilha.iterator();
                while (linhas.hasNext()) {
                    Row linha = linhas.next();
                    if (linha.getRowNum() > 0) {
                        Iterator<Cell> cellIterator = linha.cellIterator();
                        RegistroImportacao registroImportacao = converterTo(cellIterator);
                        registroImportacao = inconsistencia(registroImportacao);
                        if (validaRegistro(registroImportacao)) {
                            registroList.add(registroImportacao);
                        }
                    }
                }
            }
            return registroList;
        } catch (Exception e) {
            throw new BusinessException("Arquivo de importação não selecionado.");
        }
    }

    private RegistroImportacao inconsistencia(RegistroImportacao registroImportacao) {
        try {
            String nomeAluno = registroImportacao.getNomeAluno();
            String nomeResponsavel = registroImportacao.getNomeResponsavel();
            String cpfResponsavel = registroImportacao.getCpfResponsavel();

            if (CPFValidator.validatorCPF(cpfResponsavel)) {
                registroImportacao.setInconsistenciaEnum(InconsistenciaEnum.CPF);
            }

            Aluno aluno = alunoService.carregar(registroImportacao);
            if (aluno == null || nomeAluno.trim().equals("")) {
                registroImportacao.setInconsistenciaEnum(InconsistenciaEnum.ALUNO_NAO_CADASTRADO);
            }
            if (nomeResponsavel == null || nomeResponsavel.trim().equals("")) {
                registroImportacao.setInconsistenciaEnum(InconsistenciaEnum.RESPOVESAL_NAO_INFORMADO);
            }
            return registroImportacao;
        } catch (Exception e) {
            registroImportacao.setInconsistenciaEnum(InconsistenciaEnum.EXCEPTION);
            return registroImportacao;
        }
    }

    private boolean validaRegistro(RegistroImportacao registroImportacao) {
        boolean result = true;
        if (RegistroImportacao.isNULL(registroImportacao)) {
            result = false;
        }
        return result;
    }

    private RegistroImportacao converterTo(Iterator<Cell> cellIterator) {
        RegistroImportacao registroImportacao = new RegistroImportacao();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            String trim = cell.getStringCellValue().trim();
            switch (cell.getColumnIndex()) {
                case 0:
                    registroImportacao.setNomeAluno(trim);
                    break;
                case 1:
                    registroImportacao.setNomeResponsavel(trim);
                    break;
                case 2:
                    registroImportacao.setCpfResponsavel(trim);
                    break;
            }
        }
        return registroImportacao;
    }
}
