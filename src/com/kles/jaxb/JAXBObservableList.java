/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kles.jaxb;

import javafx.collections.ObservableList;

/**
 *
 * @author jchau
 */
public class JAXBObservableList {

    private ObservableList list;
    private Class[] type;

    public JAXBObservableList() {
    }

    public JAXBObservableList(ObservableList list, Class... type) {
        this.list = list;
        this.type = type;
    }

    public ObservableList getList() {
        return list;
    }

    public void setList(ObservableList list) {
        this.list = list;
    }

    public Class[] getType() {
        return type;
    }

    public void setType(Class[] type) {
        this.type = type;
    }
    
    
}
