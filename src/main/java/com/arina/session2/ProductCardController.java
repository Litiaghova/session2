package com.arina.session2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProductCardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackHello;

    @FXML
    private Button BackMenu;

    @FXML
    private Button ButtonBuy;

    @FXML
    private AnchorPane panel1;

    @FXML
    void initialize() {

        ButtonBuy.setOnAction(event -> {
            String url = "https://yandex.ru/";
            String os = System.getProperty("os.name").toLowerCase();
            Runtime rt = Runtime.getRuntime();

            try{

                if (os.indexOf( "win" ) >= 0) {

                    rt.exec( "rundll32 url.dll,FileProtocolHandler " + url);

                } else if (os.indexOf( "mac" ) >= 0) {

                    rt.exec( "open " + url);

                } else if (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0) {


                    String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror",
                            "netscape","opera","links","lynx"};
                    StringBuffer cmd = new StringBuffer();
                    for (int i=0; i<browsers.length; i++)
                        cmd.append( (i==0  ? "" : " || " ) + browsers[i] +" \"" + url + "\" ");

                    rt.exec(new String[] { "sh", "-c", cmd.toString() });

                } else {
                    return;
                }
            }catch (Exception e){
                return;
            }
            return;
        });

        BackHello.setOnAction(event -> {
            BackHello.getScene().getWindow().hide();

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

        BackMenu.setOnAction(event -> {
            BackMenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/arina/session2/ViewingProducts.fxml"));
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
}

