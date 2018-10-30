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
                    registroList.add(registroImportacao);
                }
            }
            return registroList;
        } catch (Exception e) {
            throw new BusinessException("Arquivo de importação não selecionado.");
        }
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
