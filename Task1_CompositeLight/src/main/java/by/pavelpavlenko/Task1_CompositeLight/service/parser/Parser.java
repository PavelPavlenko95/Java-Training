package by.pavelpavlenko.Task1_CompositeLight.service.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public abstract class Parser {

    public static final Logger LOGGER = LogManager.getLogger("by.pavelpavlenko.Task1_CompositeLight.Parser");

    public abstract List handleRequest(String text);

    public Parser() {
        ParserCounter.incrementCounter();
    }

}
