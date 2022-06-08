package com.arina.session2;

import com.arina.session2.animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Введите в поля (Логин, пароль) Ваши данные \nили создайте новый аккаунт нажав \nна кнопку - Зарегистрироваться");
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button go;

    @FXML
    private Label idHellowText;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button registration;

    @FXML
    private TextField role;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {
        go.setOnAction(event -> {
            String logintext = login.getText().trim();
            String loginpassword = password.getText().trim();
            String loginrole = role.getText().trim();

            if (!logintext.equals("") && !loginpassword.equals("") && !loginrole.equals("")){
                String result = loginUser (logintext, loginpassword, loginrole);
                if (result.equals("Администратор")){
                    openNewScene("/com/arina/session2/tableadmin/AdminWindow.fxml");
                } else if (result.equals("Пользователь")){
                    openNewScene("/com/arina/session2/ViewingProducts.fxml");
                }

            }
            else System.out.println("Ошибка, заполните данные"); // Иначе вывести текст "Ошибка, заполните данные"
        });

        registration.setOnAction(event -> {
            openNewScene("/com/arina/session2/RegistrationWindow.fxml");
        });
    }

    public String loginUser(String logintext, String loginpassword, String loginrole) {
        User user = new User();

        user.setName(logintext);
        user.setPassword(loginpassword);
        user.setRole(loginrole);

        System.out.println("Ваш логин - " + logintext);
        System.out.println("Ваш пароль - " + loginpassword);
        System.out.println("Ваша роль - " + loginrole);

        if (loginrole.equals("admin")){
            System.out.println("Такие данные найдены! (Администратор)");
            return "Администратор" ;
        }
        else if(loginrole.equals("user")){
            System.out.println("Такие данные найдены! (Пользователь)");
            return "Пользователь";

        }

        else {
            Shake userLoginAnimation = new Shake(login);
            Shake userPasswordAnimation = new Shake(password);
            Shake userRoleAnimation = new Shake(role);
            userLoginAnimation.playAnimation();
            userPasswordAnimation.playAnimation();
            userRoleAnimation.playAnimation();

            System.out.println("Такие данные не найдены!");
            return "Данные не найдены";
        }
    }

    public void openNewScene(String window){
        registration.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

