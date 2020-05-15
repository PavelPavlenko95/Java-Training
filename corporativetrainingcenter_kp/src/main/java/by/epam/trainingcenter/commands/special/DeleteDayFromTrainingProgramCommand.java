package main.java.by.epam.trainingcenter.commands.special;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.exercise.Exercise;
import by.epam.trainingcenter.service.TrainingProgramService;
import by.epam.trainingcenter.commands.Page;
import by.epam.trainingcenter.utils.TrainingProgramDataValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.epam.trainingcenter.utils.MessageManager.DAY_CAN_NOT_BE_DELETED_MESSAGE_KEY;

/**
 * Command to delete day from training program.
 *
 * @see by.epam.trainingcenter.entities.TrainingProgram
 * @see ActionCommand
 */
public class DeleteDayFromTrainingProgramCommand implements ActionCommand {

    /**
     * Implementation of command to delete day from training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        String dayNumberValue = request.getParameter(DAY_NUMBER_PARAMETER);
        HttpSession session = request.getSession();
        TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
        TrainingProgramDataValidator trainingProgramDataValidator = new TrainingProgramDataValidator();
        boolean isDataValid = trainingProgramDataValidator.checkDaysCountForDeleteOperation(daysAndExercises);
        if (!isDataValid) {
            return new Page(Page.EDIT_TRAINING_PROGRAM_PAGE_PATH, false, DAY_CAN_NOT_BE_DELETED_MESSAGE_KEY);
        }

        TrainingProgramService trainingProgramService = new TrainingProgramService();
        TreeMap<Integer, List<Exercise>> changedDaysAndExercises = trainingProgramService.deleteDayFromTrainingProgram(dayNumberValue, daysAndExercises);

        session.setAttribute(DAYS_AND_EXERCISES_ATTRIBUTE, changedDaysAndExercises);

        return new Page(Page.EDIT_TRAINING_PROGRAM_PAGE_PATH, false);
    }
}
