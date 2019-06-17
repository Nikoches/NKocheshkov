package ru.job4j.magnit;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXSQT {
    public static void main (String args[]) throws TransformerException, IOException {
        byte[] exFile = Files.readAllBytes(Paths.get("C:\\projects/example.xml"));
        TransformerFactory factory = TransformerFactory.newInstance();
        byte[] bFile = Files.readAllBytes(Paths.get("C:\\projects/file.xml"));
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new ByteArrayInputStream(exFile))
        );
        transformer.transform(new StreamSource(
                        new ByteArrayInputStream(bFile)),
                new StreamResult(new File("C:\\projects/file1.xml"))
        );
    }
}
