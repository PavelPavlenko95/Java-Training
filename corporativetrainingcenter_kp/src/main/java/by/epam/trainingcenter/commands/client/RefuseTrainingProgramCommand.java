package main.java.by.epam.trainingcenter.commands.client;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.TrainingProgramService;
import by.epam.trainingcenter.commands.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.trainingcenter.commands.Page.DESCRIBE_TRAINING_PROGRAM_PAGE_PATH;
import static by.epam.trainingcenter.utils.MessageManager.REFUSE_TRAINING_PROGRAM_FAILED_MESSAGE_KEY;
import static by.epam.trainingcenter.utils.MessageManager.REFUSE_TRAINING_PROGRAM_SUCCESS_MESSAGE_KEY;

/**
 * Command to refuse training program.
 *
 * @see ActionCommand
 * @see by.epam.trainingcenter.entities.TrainingProgram
 */
public class RefuseTrainingProgramCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(RefuseTrainingProgramCommand.class);

    /**
     * Implementation of command to refuse training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            String trainingProgramIdValue = request.getParameter(TRAINING_PROGRAM_ID_PARAMETER);
            int trainingProgramId = Integer.parseInt(trainingProgramIdValue);
            TrainingProgramService trainingProgramService = new TrainingProgramService();
            boolean isOperationSuccessful = trainingProgramService.refuseTrainingProgram(trainingProgramId);
            if (!isOperationSuccessful) {
                return new Page(DESCRIBE_TRAINING_PROGRAM_PAGE_PATH, false, REFUSE_TRAINING_PROGRAM_FAILED_MESSAGE_KEY);
            }

            HttpSession session = request.getSession();
            session.setAttribute(IS_RECORD_INSERTED, true);
            session.removeAttribute(TRAINING_PROGRAM_ATTRIBUTE);

            return new Page(Page.MAIN_PAGE_PATH, false, REFUSE_TRAINING_PROGRAM_SUCCESS_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}
