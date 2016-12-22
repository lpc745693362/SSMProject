package com.lpc.other.thread.three;

/**
 * Created by liupengcheng1 on 2016/12/21.
 */
public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    public synchronized static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (usernameRef.equals("b")) {
                Thread.sleep(1000);
            }
            passwordRef = password;
            System.out.println("username = " + usernameRef + " password = " + passwordRef);
        } catch (Exception e) {
            System.out.println("e is ============ " + e);
        }
    }
}
