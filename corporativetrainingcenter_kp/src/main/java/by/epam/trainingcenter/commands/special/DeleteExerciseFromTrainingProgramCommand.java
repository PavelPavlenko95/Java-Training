package main.java.by.epam.trainingcenter.commands.special;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.exercise.Exercise;
import by.epam.trainingcenter.service.ExerciseService;
import by.epam.trainingcenter.commands.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.epam.trainingcenter.commands.Page.EDIT_TRAINING_PROGRAM_PAGE_PATH;

/**
 * Command to delete exercise from training program.
 *
 * @see by.epam.trainingcenter.entities.TrainingProgram
 * @see by.epam.trainingcenter.entities.exercise.Exercise
 * @see by.epam.trainingcenter.service.ExerciseService
 * @see ActionCommand
 */
public class DeleteExerciseFromTrainingProgramCommand implements ActionCommand {

    /**
     * Implementation of command to delete exercise from training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        String exerciseIdValue = request.getParameter(EXERCISE_ID_PARAMETER);
        String dayNumberValue = request.getParameter(DAY_NUMBER_PARAMETER);
        HttpSession session = request.getSession();
        TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
        ExerciseService exerciseService = new ExerciseService();
        exerciseService.deleteExerciseFromTrainingProgram(exerciseIdValue, dayNumberValue, daysAndExercises);

        return new Page(EDIT_TRAINING_PROGRAM_PAGE_PATH, false);
    }
}
