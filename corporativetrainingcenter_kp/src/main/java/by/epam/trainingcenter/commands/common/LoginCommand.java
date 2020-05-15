package main.java.by.epam.trainingcenter.commands.common;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.user.User;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.UserService;
import by.epam.trainingcenter.commands.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.trainingcenter.utils.MessageManager.LOGIN_ERROR_MESSAGE_KEY;

/**
 * Command for user log in.
 *
 * @see ActionCommand
 * @see HttpServletRequest
 * @see UserService
 */
public class LoginCommand implements ActionCommand {

    private final static Logger LOGGER = Logger.getLogger(LoginCommand.class);

    /**
     * Implementation of commands that user use to log in.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            String login = request.getParameter(LOGIN_PARAMETER);
            String password = request.getParameter(PASSWORD_PARAMETER);
            UserService userService = new UserService();
            User user = userService.login(login, password);

            if (user == null) {
                return new Page(Page.LOGIN_PAGE_PATH, false, LOGIN_ERROR_MESSAGE_KEY);
            }

            HttpSession currentSession = request.getSession();
            currentSession.setAttribute(USER_ATTRIBUTE, user);

            return new Page(Page.MAIN_PAGE_PATH, true);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}
