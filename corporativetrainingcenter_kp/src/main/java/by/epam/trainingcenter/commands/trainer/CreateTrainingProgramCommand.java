package main.java.by.epam.trainingcenter.commands.trainer;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.TrainingProgram;
import by.epam.trainingcenter.entities.exercise.Exercise;
import by.epam.trainingcenter.entities.user.User;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.ExerciseService;
import by.epam.trainingcenter.service.TrainingProgramService;
import by.epam.trainingcenter.commands.Page;
import by.epam.trainingcenter.utils.TrainingProgramDataValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.epam.trainingcenter.commands.Page.CREATE_TRAINING_PROGRAM_PAGE_PATH;
import static by.epam.trainingcenter.commands.Page.EDIT_TRAINING_PROGRAM_PAGE_PATH;
import static by.epam.trainingcenter.utils.MessageManager.INVALID_INPUT_DATA_MESSAGE_KEY;

/**
 * Command to create training program.
 *
 * @see by.epam.trainingcenter.entities.TrainingProgram
 * @see ActionCommand
 */
public class CreateTrainingProgramCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(CreateTrainingProgramCommand.class);

    /**
     * Implementation of command to create training program in database.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(USER_ATTRIBUTE);
            int authorId = user.getId();

            String clientIdValue = request.getParameter(CLIENT_ID_PARAMETER);
            String startDateValue = request.getParameter(START_DATE_PARAMETER);
            String endDateValue = request.getParameter(END_DATE_PARAMETER);
            String diet = request.getParameter(DIET_PARAMETER);
            String daysCountValue = request.getParameter(DAYS_COUNT_PARAMETER);
            TrainingProgramDataValidator trainingProgramDataValidator = new TrainingProgramDataValidator();
            boolean isDataValid = trainingProgramDataValidator.checkTrainingProgramData(clientIdValue, startDateValue, endDateValue, diet, daysCountValue);
            if (!isDataValid) {
                return new Page(CREATE_TRAINING_PROGRAM_PAGE_PATH, false, INVALID_INPUT_DATA_MESSAGE_KEY);
            }

            TrainingProgramService trainingProgramService = new TrainingProgramService();
            TrainingProgram trainingProgram = trainingProgramService.createTrainingProgram(authorId, clientIdValue, diet, startDateValue, endDateValue);
            session.setAttribute(TRAINING_PROGRAM_ATTRIBUTE, trainingProgram);

            ExerciseService exerciseService = new ExerciseService();
            List<Exercise> exercises = exerciseService.findAllExercisesIdAndName();
            session.setAttribute(EXERCISES_ATTRIBUTE, exercises);


            TreeMap<Integer, List<Exercise>> daysAndExercises = trainingProgramService.getDaysAndExerciseFromTrainingProgram(daysCountValue);
            session.setAttribute(DAYS_AND_EXERCISES_ATTRIBUTE, daysAndExercises);

            return new Page(EDIT_TRAINING_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}
