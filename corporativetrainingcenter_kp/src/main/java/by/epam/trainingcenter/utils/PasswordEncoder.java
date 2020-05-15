package main.java.by.epam.trainingcenter.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Util class for encoding user password.
 *
 * @see by.epam.trainingcenter.entities.user.User
 * @see DigestUtils
 */
public class PasswordEncoder {

    /**
     * Encode password using sha256 algorithm.
     *
     * @param password the user's password.
     * @return the encoded user's password.
     */
    public static String encode(String password) {

        return DigestUtils.sha256Hex(password);
    }

}