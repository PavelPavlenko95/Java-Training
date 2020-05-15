package main.java.by.epam.trainingcenter.commands.common;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.UserService;
import by.epam.trainingcenter.commands.Page;
import by.epam.trainingcenter.utils.PasswordEncoder;
import by.epam.trainingcenter.utils.UserDataValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.trainingcenter.utils.MessageManager.*;

/**
 * Command for user registration.
 *
 * @see ActionCommand
 * @see by.epam.trainingcenter.entities.user.User
 */
public class RegisterCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);

    /**
     * Implementation of command that user register.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            String login = request.getParameter(LOGIN_PARAMETER);
            String password = request.getParameter(PASSWORD_PARAMETER);
            String firstName = request.getParameter(FIRST_NAME_PARAMETER);
            String lastName = request.getParameter(LAST_NAME_PARAMETER);

            UserService userService = new UserService();
            boolean isLoginNotUnique = userService.checkUserLoginForUnique(login);
            if (isLoginNotUnique) {
                return new Page(Page.REGISTER_PAGE_PATH, false, LOGIN_NOT_AVAILABLE_MESSAGE_KEY);
            }

            UserDataValidator userDataValidator = new UserDataValidator();
            boolean isUserDataValid = userDataValidator.checkData(login, password, firstName, lastName);
            if (!isUserDataValid) {
                return new Page(Page.REGISTER_PAGE_PATH, false, INVALID_INPUT_DATA_MESSAGE_KEY);
            }

            password = PasswordEncoder.encode(password);
            boolean isOperationSuccessful = userService.register(login, password, firstName, lastName);
            if (!isOperationSuccessful) {
                return new Page(Page.REGISTER_PAGE_PATH, false, REGISTRATION_FAILED_MESSAGE_KEY);
            }

            HttpSession session = request.getSession();
            session.setAttribute(IS_RECORD_INSERTED, true);

            return new Page(Page.LOGIN_PAGE_PATH, false, REGISTRATION_SUCCESSFUL_MESSAGE_KEY);

        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}

