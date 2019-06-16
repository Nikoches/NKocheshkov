package ru.job4j.magnit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParsing extends DefaultHandler {
    String thisElement = "";
    int sum = 0;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("field")) {
            sum = sum + (Integer.valueOf(new String(ch, start, length)));
            System.out.println(Integer.valueOf(new String(ch, start, length)));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...\n sum = "+sum);
    }
}
