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
        String xsl = "<?xml version=\"1.0\"?>\n" +
                "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" +
                "<xsl:template match=\"/\">\n" +
                "<entrys>" +
                "   <xsl:for-each select=\"entrys/values\">\n" +
                "       <entry>" +
                "           <xsl:attribute name=\"href\">" +
                "               <xsl:value-of select=\"field\"/>" +
                "           </xsl:attribute>" +
                "       </entry>\n" +
                "   </xsl:for-each>\n" +
                " </entrys>\n" +
                "</xsl:template>\n" +
                "</xsl:stylesheet>\n";
        TransformerFactory factory = TransformerFactory.newInstance();
        byte[] bFile = Files.readAllBytes(Paths.get("C:\\projects/file.xml"));
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new ByteArrayInputStream(xsl.getBytes()))
        );
        transformer.transform(new StreamSource(
                        new ByteArrayInputStream(bFile)),
                new StreamResult(new File("C:\\projects/file1.xml"))
        );
    }
}
