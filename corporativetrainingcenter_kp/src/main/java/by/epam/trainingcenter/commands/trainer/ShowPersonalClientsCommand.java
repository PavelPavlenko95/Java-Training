package main.java.by.epam.trainingcenter.commands.trainer;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.user.User;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.UserService;
import by.epam.trainingcenter.commands.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.trainingcenter.commands.Page.PERSONAL_CLIENTS_PAGE_PATH;
import static by.epam.trainingcenter.utils.MessageManager.INFORMATION_NOT_FOUND_MESSAGE_KEY;

/**
 * Command to show all personal clients.
 *
 * @see by.epam.trainingcenter.entities.user.User
 * @see ActionCommand
 */
public class ShowPersonalClientsCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(ShowPersonalClientsCommand.class);

    /**
     * Implementation of command to show all personal clients.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            User trainer = (User) session.getAttribute(USER_ATTRIBUTE);
            int trainerId = trainer.getId();

            UserService userService = new UserService();
            List<User> clients = userService.findPersonalClients(trainerId);
            if (clients.isEmpty()) {
                return new Page(Page.MAIN_PAGE_PATH, false, INFORMATION_NOT_FOUND_MESSAGE_KEY);
            }

            request.setAttribute(LIST_ATTRIBUTE, clients);

            return new Page(PERSONAL_CLIENTS_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}