package br.com.configuracao.scoped;

import java.io.Serializable;

public interface Entidade extends Serializable{
    public Serializable getId();
    public String getDisplay();
}
