package by.pavelpavlenko.xml.service.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXSD
{
    public static void main(String[] args)
    {
        boolean answer = validateXMLSchema("D:\\gitrep\\Task3_XML_XSD_PARSING\\src\\main\\resources\\schema.xsd", "D:\\gitrep\\Task3_XML_XSD_PARSING\\src\\main\\resources\\trainingPortal.xml");
        System.out.println("Result:" + answer);
    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath)
    {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}
