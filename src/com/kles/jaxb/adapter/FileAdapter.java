/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kles.jaxb.adapter;

import java.io.File;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Jeremy.CHAUT
 */
public class FileAdapter extends XmlAdapter<String, File> {

    @Override
    public File unmarshal(String v) throws Exception {
        return new File(v);
    }

    @Override
    public String marshal(File v) throws Exception {
        return v.getAbsolutePath();
    }
}
