package main.java.by.epam.trainingcenter.commands.special;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.exercise.Exercise;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.ExerciseService;
import by.epam.trainingcenter.commands.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.epam.trainingcenter.utils.MessageManager.INVALID_INPUT_DATA_MESSAGE_KEY;

/**
 * Command to add exercise to training program.
 *
 * @see Exercise
 * @see by.epam.trainingcenter.entities.TrainingProgram
 * @see ActionCommand
 * @see ExerciseService
 */
public class AddExerciseToTrainingProgramCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(AddExerciseToTrainingProgramCommand.class);

    /**
     * Implementation of command to add exercise to training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        try {
            String exerciseIdValue = request.getParameter(EXERCISE_ID_PARAMETER);
            String dayNumberValue = request.getParameter(DAY_NUMBER_PARAMETER);
            String setsCountValue = request.getParameter(SETS_COUNT_PARAMETER);
            String repeatsCountValue = request.getParameter(REPEATS_COUNT_PARAMETER);
            HttpSession session = request.getSession();
            TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
            ExerciseService exerciseService = new ExerciseService();
            boolean isOperationSuccessful = exerciseService.addExerciseInTrainingProgram(exerciseIdValue, dayNumberValue, setsCountValue, repeatsCountValue, daysAndExercises);
            if (!isOperationSuccessful) {
                return new Page(Page.EDIT_TRAINING_PROGRAM_PAGE_PATH, false, INVALID_INPUT_DATA_MESSAGE_KEY);
            }

            return new Page(Page.EDIT_TRAINING_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}
