package br.com.modulo.administracao.uploadedfile.controller;

import br.com.configuracao.util.ArquivoUtil;
import br.com.modulo.administracao.uploadedfile.model.Registro;
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
@Scope("view")
public class UploadedFileMb {

    @Autowired
    private UploadFileService uploadFileService;

    private List<File> fileList = new ArrayList<>();
    private StreamedContent streamedContent;

    private Registro registro = new Registro();

    @PostConstruct
    public void init() {
        fileList = new ArrayList<>(ArquivoUtil.listar());
    }

    public void inserir() {
    }

    public void salvar() {
        System.out.println("br.com.modulo.administracao.uploadedfile.controller.uploadedFile.salvar()");
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

    public void processar() {
        try {
            uploadFileService.processar(registro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload completo", "O arquivo foi salvo!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }

    public void upload(FileUploadEvent event) {
        try {
            UploadedFile uploadedFile = event.getFile();
            File arquivo = ArquivoUtil.escrever(uploadedFile.getFileName(), uploadedFile.getContents());
            registro.setArquivo(arquivo);
            List<RegistroImportacao> processar = uploadFileService.converterRegistro(arquivo);
            registro.setRegistroImportacaoList(processar);
            fileList = new ArrayList<>(ArquivoUtil.listar());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload completo", "O arquivo " + arquivo.getName() + " foi salvo!"));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }

    public void descarregar(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        streamedContent = new DefaultStreamedContent(inputStream, Files.probeContentType(file.toPath()), file.getName());
    }

    public void excluir(File file) throws IOException {
        ArquivoUtil.excluir(file.getName());
        fileList = new ArrayList<>(ArquivoUtil.listar());
    }

    //Get/s e Set/s
    public List<File> getFileList() {
        return fileList;
    }

    public StreamedContent getStreamedContent() {
        return streamedContent;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
}
