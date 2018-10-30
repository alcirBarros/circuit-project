package br.com.modulo.administracao.uploadedfile.service;

import br.com.modulo.administracao.uploadedfile.model.RegistroImportacao;
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
import org.springframework.stereotype.Service;

@Service
public class UploadFileService {

    public List<RegistroImportacao> processar(File file) {
        List<RegistroImportacao> registroImportacaoList = planilha(file);
        return registroImportacaoList;
    }

    private RegistroImportacao converterTo(List linha) {
        try {
            String nomeAluno = linha.get(0).toString();
            String nomeResponsavel = linha.get(1).toString();
            String cpfresponsavel = linha.get(2).toString();

            RegistroImportacao registro = new RegistroImportacao();
            registro.setNomeAluno(nomeAluno);
            registro.setNomeResponsavel(nomeResponsavel);
            registro.setCpfResponsavel(cpfresponsavel);

            return registro;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<RegistroImportacao> planilha(File file) {
        try {
            FileInputStream arquivo = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet planilha = workbook.getSheetAt(0);
            Iterator<Row> linhas = planilha.iterator();
            List<RegistroImportacao> registroList = new ArrayList<>();

            while (linhas.hasNext()) {
                Row linha = linhas.next();
                Iterator<Cell> cellIterator = linha.cellIterator();
                List<Object> registro = new ArrayList();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            registro.add(cell.getStringCellValue());
                            break;
                        default:
                    }
                }
                if (!registro.isEmpty() && registro.size() > 2 && registro.size() < 5) {
                    RegistroImportacao registroImportacao = converterTo(registro);
                    registroList.add(registroImportacao);
                }
            }
            return registroList;
        } catch (Exception e) {
            throw new BusinessException("Arquivo de importação não selecionado.");
        }
    }
}
