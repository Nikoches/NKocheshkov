package ru.job4j.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Iterator;
import java.util.List;
public class StoreXML {
    private File target;
    public StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> list) {

    }

    public void convertObjectToXml(List<Entry> entry) {
        try {
            Iterator<Entry> it = entry.iterator();
            Entry ww = it.next();
            JAXBContext context = JAXBContext.newInstance(Entry.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(ww, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public void getone(){
        try {
            Entry entry = new Entry(2);
            File file = new File("C:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(entry, file);
            jaxbMarshaller.marshal(entry, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
