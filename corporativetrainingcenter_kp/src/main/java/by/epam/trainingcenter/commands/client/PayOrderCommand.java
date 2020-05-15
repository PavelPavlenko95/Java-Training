package main.java.by.epam.trainingcenter.commands.client;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.entities.order.Order;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.OrderService;
import by.epam.trainingcenter.commands.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.trainingcenter.utils.MessageManager.ORDER_WAS_NOT_PAYED_MESSAGE_KEY;
import static by.epam.trainingcenter.utils.MessageManager.ORDER_WAS_PAYED_MESSAGE_KEY;

/**
 * Command to pay order.
 *
 * @see Order
 * @see OrderService
 * @see ActionCommand
 */
public class PayOrderCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(PayOrderCommand.class);

    /**
     * Implementation of command to pay order.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            Order order = (Order) session.getAttribute(ORDER_ATTRIBUTE);
            OrderService orderService = new OrderService();
            boolean isOperationSuccessful = orderService.payOrder(order);
            if (!isOperationSuccessful) {
                return new Page(Page.MAIN_PAGE_PATH, false, ORDER_WAS_NOT_PAYED_MESSAGE_KEY);
            }

            session.removeAttribute(ORDER_ATTRIBUTE);
            session.setAttribute(IS_RECORD_INSERTED, true);

            return new Page(Page.MAIN_PAGE_PATH, false, ORDER_WAS_PAYED_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}