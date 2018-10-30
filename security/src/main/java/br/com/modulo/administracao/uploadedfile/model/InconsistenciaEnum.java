package br.com.modulo.administracao.uploadedfile.model;

public enum InconsistenciaEnum {
    
    CPF("CPF invalido."),
    ALUNO_NAO_CADASTRADO("Aluno não cadastrado."),
    SEM_INCONSISTENCIA("Sem Inconsistência.");
    
    private final String value;

    private InconsistenciaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }    
}
