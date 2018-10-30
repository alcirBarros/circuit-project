package br.com.configuracao.scoped;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.config.SingletonBeanRegistry;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    void registerScope(String scopeName, Scope scope);
    
}
