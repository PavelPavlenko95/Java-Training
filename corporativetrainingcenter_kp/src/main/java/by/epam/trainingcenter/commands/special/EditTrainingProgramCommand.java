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

/**
 * Command to edit training program.
 *
 * @see by.epam.trainingcenter.entities.TrainingProgram
 * @see by.epam.trainingcenter.entities.exercise.Exercise
 * @see ActionCommand
 */
public class EditTrainingProgramCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(EditTrainingProgramCommand.class);

    /**
     * Implementation of commands to edit training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            ExerciseService exerciseService = new ExerciseService();
            List<Exercise> exercises = exerciseService.findAllExercisesIdAndName();

            HttpSession session = request.getSession();
            session.setAttribute(EXERCISES_ATTRIBUTE, exercises);

            return new Page(Page.EDIT_TRAINING_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            ;
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}
