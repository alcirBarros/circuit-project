package br.com.configuracao.scoped;

public enum TipoScopedEnum {
    VIEWSPROD("view");

    private final String scoped;

    private TipoScopedEnum(String scoped) {
        this.scoped = scoped;
    }

    public String getScoped() {
        return scoped;
    }    
}
