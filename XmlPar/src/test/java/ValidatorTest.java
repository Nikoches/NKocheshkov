import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import javax.xml.transform.stream.StreamSource;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class ValidatorTest {
    private final String[] paramsForNull = {"empty.xml", "xsd_valid.xsd", "xslt_scheme.xslt", "rr.xml"};
    private final String[] paramsForValidataion = {"src/test/resources/xml_example.xml", "src/test/resources/xsd_valid.xsd", "xslt_scheme.xslt", "rr.xml"};
    private final String[] paramsForNotValid = {"notvalid.xml", "xsd_valid.xsd", "xslt_scheme.xslt", "rr.xml"};


    @DisplayName("Single test for null")
    @Test
    public void checkNonExistingDocuments() {
        ArgsParser parser = new ArgsParser(paramsForNull);
        XmlCheck xmlCheck = new XmlCheck(parser);
        assertFalse(xmlCheck.documentExistCheck());
    }
    @Test
    public void checkNotValid() {
        ArgsParser parser = new ArgsParser(paramsForNotValid);
        XmlCheck xmlCheck = new XmlCheck(parser);
        assertFalse(xmlCheck.validateXsd(new StreamSource(new File(parser.getRes("SourceXml")))));
    }
    @Test
    public void checkValid() {
        ArgsParser parser = new ArgsParser(paramsForValidataion);
        XmlCheck xmlCheck = new XmlCheck(parser);
        assertTrue(xmlCheck.validateXsd(new StreamSource(new File(parser.getRes("SourceXml")))));
    }
}
