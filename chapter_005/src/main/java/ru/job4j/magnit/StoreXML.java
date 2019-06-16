package ru.job4j.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class StoreXML {
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    public File convertObjectToXml(List<Entry> entry) {
        try {
            JAXBContext context = JAXBContext.newInstance(Entrys.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal( new Entrys(entry), target);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return target;
    }
}
