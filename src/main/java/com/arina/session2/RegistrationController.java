package com.arina.session2;

import com.arina.session2.db.DBHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackHelloWindow;

    @FXML
    private ImageView ImageBackHelloWindow;

    @FXML
    private TextField loginRegistration;

    @FXML
    private TextField passwordRegistration;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField roleRegistration;

    @FXML
    void initialize() {
        registrationButton.setOnAction(event -> {
            registrationNewUser();

        });

        BackHelloWindow.setOnAction(event -> {
            BackHelloWindow.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/arina/session2/hello-view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();

            stage.setScene(new Scene(root));
            stage.show();
        });
    }
    private void registrationNewUser() {

        DBHandler dbHandler = new DBHandler();
        String name = loginRegistration.getText();
        String password = passwordRegistration.getText();
        String role = roleRegistration.getText();

        User user = new User(name,password,role);
        dbHandler.signUpUser(user);
        System.out.println("Регистрация прошла успешно!");
    }
}
