package br.com.modulo.administracao.uploadedfile.controller;

import br.com.configuracao.util.ArquivoUtil;
import br.com.modulo.administracao.uploadedfile.model.RegistroImportacao;
import br.com.modulo.administracao.uploadedfile.service.UploadFileService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class UploadedFileMb {

    @Autowired
    private UploadFileService uploadFileService;

    private List<File> fileList = new ArrayList<>();
    private StreamedContent streamedContent;
    private File arquivo;

    @PostConstruct
    public void init() {
        fileList = new ArrayList<>(ArquivoUtil.listar());
    }

    public void inserir() {
    }

    public void salvar() {
        System.out.println("br.com.modulo.administracao.uploadedfile.controller.uploadedFile.salvar()");
        List<RegistroImportacao> registroImportacaoList = uploadFileService.processar(arquivo);
        fileList = new ArrayList<>(ArquivoUtil.listar());
    }

    public void alterar() {

    }

    public void visualizar() {
    }

    public void excluir() {

    }

    public void cancelar() {
    }

    public void adicionar() {

    }

    public void upload(FileUploadEvent event) {
        try {
            UploadedFile uploadedFile = event.getFile();
            arquivo = ArquivoUtil.escrever(uploadedFile.getFileName(), uploadedFile.getContents());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload completo", "O arquivo " + arquivo.getName() + " foi salvo!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }

    public void descarregar(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        streamedContent = new DefaultStreamedContent(inputStream, Files.probeContentType(file.toPath()), file.getName());
    }

    //Get/s e Set/s
    public List<File> getFileList() {
        return fileList;
    }

    public StreamedContent getStreamedContent() {
        return streamedContent;
    }

}
