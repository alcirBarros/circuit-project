package br.com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@Table(name = "aud_audted", schema = "hibernate_db_aud")
@RevisionEntity(AuditedListener.class)
public class AuditedEnvers extends DefaultRevisionEntity {

    @Column(name = "aud_nome_operador", nullable = false)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
