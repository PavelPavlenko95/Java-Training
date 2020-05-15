package main.java.by.epam.trainingcenter.commands.special;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.TrainingProgram;
import by.epam.trainingcenter.entities.exercise.Exercise;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.TrainingProgramService;
import by.epam.trainingcenter.commands.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.epam.trainingcenter.commands.Page.DESCRIBE_TRAINING_PROGRAM_PAGE_PATH;
import static by.epam.trainingcenter.utils.MessageManager.INFORMATION_NOT_FOUND_MESSAGE_KEY;

/**
 * Command to show client's training program.
 *
 * @see by.epam.trainingcenter.entities.TrainingProgram
 * @see by.epam.trainingcenter.service.TrainingProgramService
 * @see ActionCommand
 */
public class ShowClientTrainingProgramCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(ShowClientTrainingProgramCommand.class);

    /**
     * Implementation of commands to show client's training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            String clientIdValue = request.getParameter(CLIENT_ID_PARAMETER);
            int clientId = Integer.parseInt(clientIdValue);
            TrainingProgramService trainingProgramService = new TrainingProgramService();
            TrainingProgram trainingProgram = trainingProgramService.findTrainingProgramById(clientId);

            if (trainingProgram == null) {
                return new Page(Page.MAIN_PAGE_PATH, false, INFORMATION_NOT_FOUND_MESSAGE_KEY);
            }

            HttpSession session = request.getSession();
            session.setAttribute(TRAINING_PROGRAM_ATTRIBUTE, trainingProgram);

            int trainingProgramId = trainingProgram.getId();
            String authorName = trainingProgramService.findTrainingProgramAuthorName(trainingProgramId);
            session.setAttribute(NAME_ATTRIBUTE, authorName);

            TreeMap<Integer, List<Exercise>> daysAndExercises = trainingProgramService.showExercisesFromTrainingProgram(trainingProgramId);
            session.setAttribute(DAYS_AND_EXERCISES_ATTRIBUTE, daysAndExercises);


            return new Page(DESCRIBE_TRAINING_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}
