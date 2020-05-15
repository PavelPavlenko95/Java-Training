package main.java.by.epam.trainingcenter.commands.common;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.commands.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * Empty command is using for stab. Redirect to main page if command wasn't identify.
 *
 * @see ActionCommand
 * @see HttpServletRequest
 */
public class EmptyCommand implements ActionCommand {

    /**
     * Implementation of commands. Redirect to main page.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    public Page execute(HttpServletRequest request) {
        return new Page(Page.MAIN_PAGE_PATH, false);
    }
}
