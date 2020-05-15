package main.java.by.epam.trainingcenter.commands.trainer;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.TrainingProgram;
import by.epam.trainingcenter.entities.exercise.Exercise;
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

import static by.epam.trainingcenter.commands.Page.DESCRIBE_TRAINING_PROGRAM_PAGE_PATH;
import static by.epam.trainingcenter.commands.Page.EDIT_TRAINING_PROGRAM_PAGE_PATH;
import static by.epam.trainingcenter.utils.MessageManager.*;

/**
 * Command to save training program.
 *
 * @see ActionCommand
 * @see by.epam.trainingcenter.entities.TrainingProgram
 */
public class FinishTrainingProgramCreationCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(FinishTrainingProgramCreationCommand.class);

    /**
     * Implementation of command to save training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();

            TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
            TrainingProgramDataValidator trainingProgramDataValidator = new TrainingProgramDataValidator();
            boolean isDaysAndExercisesCountValid = trainingProgramDataValidator.checkDaysAndExercisesCount(daysAndExercises);
            if (!isDaysAndExercisesCountValid) {
                return new Page(EDIT_TRAINING_PROGRAM_PAGE_PATH, false, TRAINING_PROGRAM_DAYS_AND_EXERCISES_NOT_VALID_MESSAGE_KEY);
            }

            TrainingProgram trainingProgram = (TrainingProgram) session.getAttribute(TRAINING_PROGRAM_ATTRIBUTE);
            TrainingProgramService trainingProgramService = new TrainingProgramService();
            int trainingProgramId = trainingProgramService.saveTrainingProgram(trainingProgram);
            trainingProgram.setId(trainingProgramId);

            ExerciseService exerciseService = new ExerciseService();
            boolean isResultSuccessful = exerciseService.addExercisesToTrainingProgram(trainingProgramId, daysAndExercises, false);

            if (!isResultSuccessful) {
                return new Page(EDIT_TRAINING_PROGRAM_PAGE_PATH, false, TRAINING_PROGRAM_NOT_SAVED_MESSAGE_KEY);
            }

            session.removeAttribute(EXERCISES_ATTRIBUTE);
            session.removeAttribute(LIST_ATTRIBUTE);
            session.setAttribute(IS_RECORD_INSERTED, true);

            return new Page(DESCRIBE_TRAINING_PROGRAM_PAGE_PATH, false, TRAINING_PROGRAM_SAVED_SUCCESSFUL_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}
