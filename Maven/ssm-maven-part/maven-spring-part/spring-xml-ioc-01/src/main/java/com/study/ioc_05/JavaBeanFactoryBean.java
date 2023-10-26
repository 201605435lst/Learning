package com.study.ioc_05;
import org.springframework.beans.factory.FactoryBean;
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {
    @Override
    public JavaBean getObject() {
        return new JavaBean();
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
