package main.java.by.epam.trainingcenter.commands.special;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.TrainingProgram;
import by.epam.trainingcenter.commands.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Command to edit diet in training program.
 *
 * @see ActionCommand
 * @see by.epam.trainingcenter.entities.TrainingProgram
 */
public class EditDietInTrainingProgramCommand implements ActionCommand {

    /**
     * Implementation of command to edit diet in training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        String diet = request.getParameter(DIET_PARAMETER);

        HttpSession session = request.getSession();
        TrainingProgram trainingProgram = (TrainingProgram) session.getAttribute(TRAINING_PROGRAM_ATTRIBUTE);
        trainingProgram.setDiet(diet);

        return new Page(Page.EDIT_TRAINING_PROGRAM_PAGE_PATH, false);
    }
}
