package main.java.by.epam.trainingcenter.commands.special;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.order.Order;
import by.epam.trainingcenter.entities.user.User;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.OrderService;
import by.epam.trainingcenter.commands.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.epam.trainingcenter.commands.Page.SHOW_CLIENT_ORDERS_PAGE_PATH;
import static by.epam.trainingcenter.utils.MessageManager.INFORMATION_NOT_FOUND_MESSAGE_KEY;

/**
 * Command to show client order.
 *
 * @see User
 * @see ActionCommand
 * @see OrderService
 */
public class ShowClientOrdersCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(ShowClientOrdersCommand.class);

    /**
     * Implementation of commands to find orders of client.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        try {
            String clientIdValue = request.getParameter(CLIENT_ID_PARAMETER);
            int clientId = Integer.parseInt(clientIdValue);
            OrderService orderService = new OrderService();
            List<Order> orderList = orderService.findAllClientOrder(clientId);

            if (orderList.isEmpty()) {
                return new Page(Page.MAIN_PAGE_PATH, false, INFORMATION_NOT_FOUND_MESSAGE_KEY);
            }

            request.setAttribute(LIST_ATTRIBUTE, orderList);

            return new Page(SHOW_CLIENT_ORDERS_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}
