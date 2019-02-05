package br.column;

public enum SexoEnum {
    
    FEMININO("F", "Feminino"),
    MASCULINO("M", "Masculino");

    private final String value;
    private final String descricao;

    private SexoEnum(String value, String descricao) {
        this.value = value;
        this.descricao = descricao;
    }

    public String getValue() {
        return value;
    }

    public String getDescricao() {
        return descricao;
    }
}
