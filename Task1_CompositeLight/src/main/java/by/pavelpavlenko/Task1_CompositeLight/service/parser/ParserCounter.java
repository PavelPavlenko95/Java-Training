package by.pavelpavlenko.Task1_CompositeLight.service.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final  class ParserCounter {

    private ParserCounter() {
    }

    public static final Logger LOGGER = LogManager.getLogger("by.pavelpavlenko.Task1_CompositeLight.Parser");

    private static int counter = 0;

    public static void incrementCounter() {
        counter++;
        LOGGER.debug("Creating parser " + ParserCounter.counter + ". Successful.");

    }

    public static int checkCounter() {
        return counter;
    }


}