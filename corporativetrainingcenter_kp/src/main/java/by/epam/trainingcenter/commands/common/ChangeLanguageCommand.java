package main.java.by.epam.trainingcenter.commands.common;

import by.epam.trainingcenter.commands.ActionCommand;
import by.epam.trainingcenter.commands.Page;
import by.epam.trainingcenter.utils.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

import static by.epam.trainingcenter.utils.MessageManager.DEFAULT_LOCALE;

/**
 * Command to change language.
 *
 */
public class ChangeLanguageCommand implements ActionCommand {

    private static final String RU_LANGUAGE = "ru";
    private static final String US_LANGUAGE = "en";
    private static final String BY_LANGUAGE = "by";

    private static final String RU_COUNTRY = "RU";
    private static final String US_COUNTRY = "US";
    private static final String BY_COUNTRY = "BY";

    /**
     * Implementation of commands to change language.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {

        String localeValue = request.getParameter(LOCALE_PARAMETER);
        Locale locale;
        switch (localeValue) {
            case RU_LANGUAGE: {
                locale = new Locale(RU_LANGUAGE, RU_COUNTRY);
                break;
            }
            case US_LANGUAGE: {
                locale = new Locale(US_LANGUAGE, US_COUNTRY);
                break;
            }
            case BY_LANGUAGE: {
                locale = new Locale(BY_LANGUAGE, BY_COUNTRY);
                break;
            }
            default: {
                locale = DEFAULT_LOCALE;
                break;
            }
        }
        Config.set(request.getSession(), Config.FMT_LOCALE, locale);
        MessageManager.changeLocale(locale);

        return new Page(Page.MAIN_PAGE_PATH, true);
    }
}
