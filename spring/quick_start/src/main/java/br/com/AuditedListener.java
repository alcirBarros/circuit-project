package br.com;

import java.util.Date;
import org.hibernate.envers.RevisionListener;

public class AuditedListener implements RevisionListener{

    @Override
    public void newRevision(Object object) {
        
        AuditedEnvers auditedEnvers = (AuditedEnvers)object;
        auditedEnvers.setNome("---------");
        auditedEnvers.setTimestamp(new Date().getTime());
        
    }
    
}
