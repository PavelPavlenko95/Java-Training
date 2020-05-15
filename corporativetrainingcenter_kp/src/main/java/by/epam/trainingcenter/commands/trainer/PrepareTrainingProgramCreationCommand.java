package main.java.by.epam.trainingcenter.commands.trainer;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.UserService;
import by.epam.trainingcenter.commands.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static by.epam.trainingcenter.commands.Page.CREATE_TRAINING_PROGRAM_PAGE_PATH;
import static by.epam.trainingcenter.commands.Page.MAIN_PAGE_PATH;
import static by.epam.trainingcenter.utils.MessageManager.NO_CLIENT_FOR_TRAINING_PROGRAM_CREATION_MESSAGE_KEY;

/**
 * Command to prepare page for creation training program.
 *
 * @see by.epam.trainingcenter.entities.TrainingProgram
 * @see ActionCommand
 * @see by.epam.trainingcenter.service.UserService
 */
public class PrepareTrainingProgramCreationCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(PrepareTrainingProgramCreationCommand.class);

    /**
     * Implementation of command to prepare page for creation training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            UserService userService = new UserService();
            Map<Integer, String> clientsIdAndName = userService.findClientsForTrainingProgramCreation();
            if (clientsIdAndName.isEmpty()) {
                return new Page(MAIN_PAGE_PATH, false, NO_CLIENT_FOR_TRAINING_PROGRAM_CREATION_MESSAGE_KEY);
            }

            HttpSession session = request.getSession();
            session.setAttribute(LIST_ATTRIBUTE, clientsIdAndName);

            return new Page(CREATE_TRAINING_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}