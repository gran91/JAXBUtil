/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kles.model;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Jeremy.CHAUT
 */
public class Column {

    private String idLng;
    private String name;
    private int id;
    private boolean hidden;
    private final ResourceBundle res = ResourceBundle.getBundle("resources/language", Locale.ENGLISH);

    public Column() {
    }

    public Column(int id, String idLng) {
        build(id, idLng, res.getString(idLng), false);
    }

    public Column(int id, String idLng, String name) {
        build(id, idLng, name, false);
    }

    public Column(int id, String idLng, boolean hide) {
        build(id, idLng, res.getString(idLng), false);
    }

    public Column(int id, String idLng, String name, boolean hide) {
        build(id, idLng, name, hide);
    }

    private void build(int id, String idLng, String name, boolean hide) {
        this.id = id;
        this.idLng = idLng;
        this.name = name;
        this.hidden = hide;
    }

    public String getIdLng() {
        return idLng;
    }

    public void setIdLng(String id) {
        this.idLng = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
