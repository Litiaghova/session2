package com.arina.session2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void Admin() {
            System.out.println("Работает тест от HelloControllerTest");
            HelloController hc1 = new HelloController();
            String login = "Заданный логин";
            String password = "Заданный пароль";
            String role = "admin";
            String result = "Администратор";
            assertEquals(result,hc1.loginUser(login,password,role));
        }

    @Test
    void User() {
        System.out.println("Работает тест от HelloControllerTest");
        HelloController hc2 = new HelloController();
        String login = "Заданный логин";
        String password = "Заданный пароль";
        String role = "user";
        String result = "Пользователь";
        assertEquals(result,hc2.loginUser(login,password,role));
    }
}
