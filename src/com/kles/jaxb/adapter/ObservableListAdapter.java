/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kles.jaxb.adapter;

import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author JCHAUT
 */
public class ObservableListAdapter<T> extends XmlAdapter<LinkedList<T>, ObservableList<T>> {
        @Override
        public ObservableList<T> unmarshal(LinkedList<T> v) throws Exception {
            return FXCollections.observableList(v);
        }

        @Override
        public LinkedList<T> marshal(ObservableList<T> v) throws Exception {
            LinkedList<T> list = new LinkedList<T>();
            list.addAll(v);
            return list; // Or whatever the correct method is
        }
}
