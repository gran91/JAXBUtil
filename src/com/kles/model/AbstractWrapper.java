package com.kles.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
public class AbstractWrapper {

    private List<AbstractDataModel> customers;

    @XmlElement(name = "customer")
    public List<AbstractDataModel> getData() {
        return this.customers;
    }

    public void setData(List<AbstractDataModel> customers) {
        this.customers = customers;
    }
}
