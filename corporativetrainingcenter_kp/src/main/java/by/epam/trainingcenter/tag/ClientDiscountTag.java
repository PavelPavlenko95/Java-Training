package main.java.by.epam.trainingcenter.tag;

import by.epam.trainingcenter.exceptions.ServiceException;
import by.epam.trainingcenter.service.DiscountService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Class describes information tag.
 *
 */
public class ClientDiscountTag extends TagSupport {

    private String id;

    /**
     * Sets id.
     *
     * @param id the id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method starts tag.
     *
     * @return int constant SKIP_BODY.
     * @throws JspException object if execution of method is failed.
     */
    @Override
    public int doStartTag() throws JspException {
        try {
            DiscountService discountService = new DiscountService();
            int clientId = Integer.parseInt(id);
            int discount = discountService.getDiscount(clientId);
            JspWriter jspWriter = pageContext.getOut();
            jspWriter.write(String.format("%d%%):", discount));
        } catch (IOException | ServiceException exception) {
            throw new JspException("Menu tag failed.",exception);
        }
        return SKIP_BODY;
    }
}
