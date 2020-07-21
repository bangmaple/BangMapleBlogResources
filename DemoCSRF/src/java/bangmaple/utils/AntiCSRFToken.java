/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangmaple.utils;

import java.security.SecureRandom;

/**
 *
 * @author bangmaple
 */
public class AntiCSRFToken {

    private static final String DICT = "abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int DICT_SIZE = DICT.length();

    public static String getToken() {
        final SecureRandom random = new SecureRandom();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DICT_SIZE / 2; i++) {
            sb.append(DICT.charAt(random.nextInt(DICT_SIZE)));
        }
        return sb.toString();
    }
}
