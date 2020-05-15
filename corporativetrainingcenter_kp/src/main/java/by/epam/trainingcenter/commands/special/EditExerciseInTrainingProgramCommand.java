package main.java.by.epam.trainingcenter.commands.special;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.exercise.Exercise;
import by.epam.trainingcenter.service.ExerciseService;
import by.epam.trainingcenter.commands.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static by.epam.trainingcenter.commands.Page.EDIT_TRAINING_PROGRAM_PAGE_PATH;
import static by.epam.trainingcenter.utils.MessageManager.INVALID_INPUT_DATA_MESSAGE_KEY;


/**
 * Command to edit exercise in training program.
 *
 * @see by.epam.trainingcenter.entities.exercise.Exercise
 * @see by.epam.trainingcenter.entities.TrainingProgram
 * @see by.epam.trainingcenter.commands.ActionCommand
 */
public class EditExerciseInTrainingProgramCommand implements ActionCommand {

    /**
     * Implementation of command to edit exercise in training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        String exerciseIdValue = request.getParameter(EXERCISE_ID_PARAMETER);
        String dayNumberValue = request.getParameter(DAY_NUMBER_PARAMETER);
        String setsCountValue = request.getParameter(SETS_COUNT_PARAMETER);
        String repeatsCountValue = request.getParameter(REPEATS_COUNT_PARAMETER);

        HttpSession session = request.getSession();
        Map<Integer, List<Exercise>> daysAndExercises = (Map<Integer, List<Exercise>>) session.getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);

        ExerciseService exerciseService = new ExerciseService();
        boolean isOperationSuccessful = exerciseService.editExercise(exerciseIdValue, dayNumberValue, setsCountValue, repeatsCountValue, daysAndExercises);
        if (!isOperationSuccessful) {
            return new Page(EDIT_TRAINING_PROGRAM_PAGE_PATH, false, INVALID_INPUT_DATA_MESSAGE_KEY);
        }

        return new Page(EDIT_TRAINING_PROGRAM_PAGE_PATH, false);
    }
}

