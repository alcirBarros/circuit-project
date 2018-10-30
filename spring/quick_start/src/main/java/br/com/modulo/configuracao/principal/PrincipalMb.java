package br.com.modulo.configuracao.principal;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class PrincipalMb implements Serializable {

    private MenuModel model;

    @PostConstruct
    private void init() {
        System.out.println("Init PrincipalMb.java");
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

        DefaultMenuItem item = new DefaultMenuItem("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);

        model.addElement(firstSubmenu);

        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuView.save}");
//        item.setUpdate("messages");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.addElement(item);

        model.addElement(secondSubmenu);
    }

    public void carregarTela() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Principal", "PrimeFaces Rocks."));
    }

    public MenuModel getModel() {
        return model;
    }
}
