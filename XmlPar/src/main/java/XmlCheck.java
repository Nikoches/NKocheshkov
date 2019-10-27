import org.apache.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;

public class XmlCheck {
    private static final Logger LOGGER = Logger.getLogger(XmlCheck.class);
    private ArgsParser argsParser;
    private Source xslt;
    private Source xml = null;
    private Transformer transformer;

    /**
     * Getting parser;
     *
     * @param argsParser Parsing parametres from console
     */
    public XmlCheck(ArgsParser argsParser) {
        this.argsParser = argsParser;
    }

    public static void main(String[] args) {
        XmlCheck xmlCheck = new XmlCheck(new ArgsParser(args));
        if (xmlCheck.documentExistCheck()) {
            xmlCheck.xsltTransformAndValidate();
        }

    }

    /**
     * Main method to produce final xml;
     */
    public boolean documentExistCheck() {
        /*
         *   Getting original xlst;
         */
        try {
            xslt = new StreamSource(new File(argsParser.getRes("SourceXslt")));
            if (!new File(argsParser.getRes("SourceXslt")).exists()) {
                throw new FileNotFoundException();
            }
        } catch (Exception ex) {
            LOGGER.error("XLST NOT founded", ex);
            return false;
        }
        /*
         * Getting original xml and validate him;
         */
        try {
            xml = new StreamSource(new File(argsParser.getRes("SourceXml")));
            if (!new File(argsParser.getRes("SourceXml")).exists()) {
                throw new FileNotFoundException();
            }
            LOGGER.info("XML founded!");
        } catch (Exception ex) {
            LOGGER.error("XML NOT founded", ex);
            return false;
        }
        if (!validateXsd(xml)) {
            LOGGER.error("XML not valid , program exit.");
            return false;
        }
        /*
         * Getting original xsd;
         */
        try {
            if (!new File(argsParser.getRes("SourceXsd")).exists()) {
                throw new FileNotFoundException();
            }
        } catch (Exception ex) {
            LOGGER.error("XSD NOT founded", ex);
            return false;
        }
        return true;
    }

    /**
     * Final transformation to xml;
     */
    protected boolean xsltTransformAndValidate() {
        try {
            transformer = TransformerFactory.newInstance().newTransformer(xslt);
            transformer.transform(xml, new StreamResult(new File(argsParser.getRes("resultXml"))));
        } catch (Exception ex) {
            LOGGER.error("Transformer  exception", ex);
            return false;
        }
        LOGGER.info("Transformation Complete.");
        if (!validateXsd(new StreamSource(new File(argsParser.getRes("resultXml"))))) {
            LOGGER.error("Final XML not valid");
            return false;
        } else {
            LOGGER.info("Transformation over.");
        }
        return true;
    }

    /**
     * Validation of xml;
     *
     * @param value is xml document which need to validate;
     */
    protected boolean validateXsd(Source value) {
        File schemaFile = new File(argsParser.getRes("SourceXsd"));
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(schemaFile)
                    .newValidator()
                    .validate(value);
            LOGGER.info(value.getSystemId() + " XML is Valid");
        } catch (Exception e) {
            LOGGER.error(value.getSystemId() + " XML is NOT valid!", e);
            return false;
        }
        return true;
    }
}
