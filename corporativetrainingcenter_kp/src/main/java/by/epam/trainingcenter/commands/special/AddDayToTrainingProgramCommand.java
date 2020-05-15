package main.java.by.epam.trainingcenter.commands.special;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.exercise.Exercise;
import by.epam.trainingcenter.service.TrainingProgramService;
import by.epam.trainingcenter.commands.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.epam.trainingcenter.utils.MessageManager.DAY_ADD_FAILED_MESSAGE_KEY;

/**
 * Command to add day into training program.
 *
 * @see by.epam.trainingcenter.entities.TrainingProgram
 * @see ActionCommand
 */
public class AddDayToTrainingProgramCommand implements ActionCommand {

    /**
     * Implementation of command to add day into training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
        TrainingProgramService trainingProgramService = new TrainingProgramService();
        boolean isOperationSuccessful = trainingProgramService.addDayInTrainingProgram(daysAndExercises);
        if (!isOperationSuccessful) {
            return new Page(Page.EDIT_TRAINING_PROGRAM_PAGE_PATH, false, DAY_ADD_FAILED_MESSAGE_KEY);
        }

        return new Page(Page.EDIT_TRAINING_PROGRAM_PAGE_PATH, false);
    }
}
