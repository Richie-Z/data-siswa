/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Richie
 */
public class UserSession {
    private static String u_username;
    public static String getU_username() {
        return u_username;
    }
    public static void setU_username(String u_username) {
        UserSession.u_username = u_username;
    }
}
