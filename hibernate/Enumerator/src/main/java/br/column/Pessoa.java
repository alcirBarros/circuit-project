package br.column;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "clm_column")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = -1126242111171968609L;

    @Id
    @GeneratedValue
    @Column(name = "clm_id", nullable = false)
    private Integer id;

    @Type(type = "br.com.client.entity.type.AssociacaoType", parameters = {
        @Parameter(name = "enumClassName", value = "br.com.client.enumerators.SituacaoSistemaEnum") ,
	@Parameter(name = "recreateEnumMthd", value = "recreateEnum") ,
	@Parameter(name = "recreateStringMthd", value = "recreateString")})
    @Column(name = "TP_ASSOCIACAO", nullable = false)
    private SexoEnum sexoEnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SexoEnum getSexoEnum() {
        return sexoEnum;
    }

    public void setSexoEnum(SexoEnum sexoEnum) {
        this.sexoEnum = sexoEnum;
    }
}
