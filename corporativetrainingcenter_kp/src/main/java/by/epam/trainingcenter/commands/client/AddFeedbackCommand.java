package main.java.by.epam.trainingcenter.commands.client;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.OrderService;
import by.epam.trainingcenter.commands.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.trainingcenter.commands.Page.ADD_FEEDBACK_PAGE_PATH;
import static by.epam.trainingcenter.utils.MessageManager.FEEDBACK_WAS_ADDED_MESSAGE_KEY;
import static by.epam.trainingcenter.utils.MessageManager.FEEDBACK_WAS_NOT_ADDED_MESSAGE_KEY;

/**
 * Command to add feedback about order.
 *
 * @see by.epam.trainingcenter.entities.order.Order
 * @see OrderService
 */
public class AddFeedbackCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(AddFeedbackCommand.class);

    /**
     * Implementation of command to add feedback about order.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            int orderId = (int) session.getAttribute(ORDER_ID_ATTRIBUTE);
            String feedback = request.getParameter(FEEDBACK_PARAMETER);

            OrderService orderService = new OrderService();
            boolean isOperationSuccessful = orderService.addFeedback(feedback, orderId);

            if (!isOperationSuccessful) {
                return new Page(ADD_FEEDBACK_PAGE_PATH, false, FEEDBACK_WAS_NOT_ADDED_MESSAGE_KEY);
            }

            session.setAttribute(IS_RECORD_INSERTED, true);

            return new Page(Page.MAIN_PAGE_PATH, false, FEEDBACK_WAS_ADDED_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new Page(Page.ERROR_PAGE_PATH, true);
        }
    }
}