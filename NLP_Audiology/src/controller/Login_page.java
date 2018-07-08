package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

import java.io.IOException;

public class Login_page extends Application {
    @FXML
    private Pane pane;
    @FXML
    private TextField ID;
    @FXML
    private TextField password;

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../layout/Login.fxml"));
        stage = primaryStage;
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    public void loginButtonAction(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/layout/Main.fxml"));
        stage.close();
        stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Main Page");
        stage.show();
    }
}
