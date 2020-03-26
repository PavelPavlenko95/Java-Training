package by.pavelpavlenko.xml.service.parser.factory;

import by.pavelpavlenko.xml.exception.XMLFileException;
import by.pavelpavlenko.xml.service.parser.AbstractPortalParser;
import by.pavelpavlenko.xml.service.parser.PortalDomParser;
import by.pavelpavlenko.xml.service.parser.PortalSaxParser;
import by.pavelpavlenko.xml.service.parser.PortalStaxParser;

public class PortalParserFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractPortalParser parseXML(String typeParser) throws XMLFileException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new PortalDomParser();
            case STAX:
                return new PortalStaxParser();
            case SAX:
                return new PortalSaxParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
