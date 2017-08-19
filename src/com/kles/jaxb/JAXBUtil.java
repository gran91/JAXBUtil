package com.kles.jaxb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.StringWriter;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author jchau
 */
public class JAXBUtil {

    public static Object convertToObject(File source, Class... type) throws JAXBException {
        String result;
        StringWriter sw = new StringWriter();
        JAXBContext carContext = JAXBContext.newInstance(type);
        Unmarshaller carMarshaller = carContext.createUnmarshaller();
        return carMarshaller.unmarshal(source);
    }

    public static String convertToXml(Object source, Class... type) throws JAXBException {
        String result;
        StringWriter sw = new StringWriter();
        JAXBContext carContext = JAXBContext.newInstance(type);
        Marshaller m = carContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(source, sw);
        result = sw.toString();
        return result;
    }

    public static File convertToFile(Object source, File f, Class... type) throws JAXBException {
        JAXBContext carContext = JAXBContext.newInstance(type);
        Marshaller m = carContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(source, f);
        return f;
    }

    /**
     * Unmarshal XML to Wrapper and return List value.
     * @param <T>
     * @param unmarshaller
     * @param clazz
     * @param xmlLocation
     * @return 
     * @throws javax.xml.bind.JAXBException
     */
    public static <T> List<T> unmarshalList(Unmarshaller unmarshaller,
            Class<T> clazz, String xmlLocation) throws JAXBException {
        StreamSource xml = new StreamSource(xmlLocation);
        Wrapper<T> wrapper = (Wrapper<T>) unmarshaller.unmarshal(xml, Wrapper.class).getValue();
        return wrapper.getItems();
    }

    /**
     * Wrap List in Wrapper, then leverage JAXBElement to supply root element
     * information.
     */
    public static void marshalList(Marshaller marshaller, List<?> list, String name) throws JAXBException {
        QName qName = new QName(name);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName,
                Wrapper.class, wrapper);
        marshaller.marshal(jaxbElement, System.out);
    }

    public static void marshalList(Marshaller marshaller, List<?> list, String name, File f)
            throws JAXBException {
        QName qName = new QName(name);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName,
                Wrapper.class, wrapper);
        marshaller.marshal(jaxbElement, f);
    }

}
