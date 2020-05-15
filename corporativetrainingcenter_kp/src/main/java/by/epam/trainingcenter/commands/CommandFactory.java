package main.java.by.epam.trainingcenter.commands;

import by.epam.trainingcenter.commands.common.EmptyCommand;
import by.epam.trainingcenter.utils.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.epam.trainingcenter.commands.ActionCommand.COMMAND_PARAMETER;
import static by.epam.trainingcenter.commands.ActionCommand.MESSAGE_ATTRIBUTE;
import static by.epam.trainingcenter.utils.MessageManager.COMMAND_ERROR_MESSAGE_KEY;

/**
 * Factory class for creation commands.
 *
 * @see ActionCommand
 */
public class CommandFactory {

    private static final Logger LOGGER = Logger.getLogger(CommandFactory.class);

    /**
     * This method define commands and return it's instance.
     *
     * @param request the HttpServletRequest request.
     * @return the defined commands.
     */
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand currentCommand = new EmptyCommand();

        String action = request.getParameter(COMMAND_PARAMETER);
        if (action == null || action.isEmpty()) {
            LOGGER.info(String.format("Command - %s, is empty.", action));
            return currentCommand;
        }
        try {
            String commandTypeValue = action.toUpperCase();
            CommandType currentType = CommandType.valueOf(commandTypeValue);
            currentCommand = currentType.getCurrentCommand();
        } catch (IllegalArgumentException exception) {
            LOGGER.warn(String.format("Command - %s, cause exception.", action) + exception);
            String message = String.format("%s %s", action, MessageManager.getProperty(COMMAND_ERROR_MESSAGE_KEY));
            request.setAttribute(MESSAGE_ATTRIBUTE, message);
        }
        return currentCommand;
    }

}
