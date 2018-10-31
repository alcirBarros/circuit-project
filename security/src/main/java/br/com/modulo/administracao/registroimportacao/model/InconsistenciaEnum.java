package br.com.modulo.administracao.registroimportacao.model;

public enum InconsistenciaEnum {

    CPF("CPF invalido."),
    ALUNO_NAO_CADASTRADO("Aluno não cadastrado."),
    RESPOVESAL_NAO_INFORMADO("Responsável não informado."),
    SEM_INCONSISTENCIA("Sem Inconsistência."),
    EXCEPTION("Exception.");

    private final String value;

    private InconsistenciaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
