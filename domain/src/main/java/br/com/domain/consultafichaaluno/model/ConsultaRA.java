//package br.com.domain.consultafichaaluno.model;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class ConsultaRA extends br.gov.sp.educacao.ensemble.ConsultaRA implements Serializable {
//
//    private Integer id;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    @Override
//    public String getInRA() {
//        return inRA;
//    }
//
//    @Override
//    public void setInRA(String inRA) {
//        this.inRA = inRA;
//    }
//
//    @Override
//    public String getInDigitoRA() {
//        return inDigitoRA;
//    }
//
//    @Override
//    public void setInDigitoRA(String inDigitoRA) {
//        this.inDigitoRA = inDigitoRA;
//    }
//
//    @Override
//    public String getInUF() {
//        return inUF;
//    }
//
//    @Override
//    public void setInUF(String inUF) {
//        this.inUF = inUF;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 11 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final ConsultaRA other = (ConsultaRA) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }
//}
