package main.java.by.epam.trainingcenter.commands.common;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.user.User;
import by.epam.trainingcenter.commands.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Command for user log out.
 *
 * @see ActionCommand
 * @see HttpServletRequest
 */
public class LogoutCommand implements ActionCommand {

    /**
     * Implementation of commands that user use to sign out
     *
     * @param request HttpServletRequest object
     * @return page
     */
    public Page execute(HttpServletRequest request) {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        String login = user.getLogin();

        session.invalidate();

        return new Page(Page.MAIN_PAGE_PATH, true);
    }
}
