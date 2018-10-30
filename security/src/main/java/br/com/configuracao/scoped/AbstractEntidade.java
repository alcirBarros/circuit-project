package br.com.configuracao.scoped;

import java.io.Serializable;
import java.util.Random;

public abstract class AbstractEntidade implements Entidade, Serializable {

    private static final long serialVersionUID = 4963221767794543431L;
    private int randomId = new Random().nextInt(Integer.MAX_VALUE);

    public int getRandomId() {
        return randomId;
    }

    public void setRandomId(int randomId) {
        this.randomId = randomId;
    }
    
    @Override
    public Serializable getId() {
        return null;
    }

    @Override
    public String getDisplay() {
        return null;
    }
}
