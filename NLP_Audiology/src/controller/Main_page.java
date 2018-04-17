package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main_page extends Application {
    @FXML
    public ListView listview;
    @FXML
    public TextField searchBar;

    @FXML
    private AnchorPane anchorPane;

    public static void main(String[] args) {
        //launch(args);
//        ListView<String> list = new ListView<String>();
//        ObservableList<String> items = FXCollections.observableArrayList (
//                "Single", "Double", "Suite", "Family App");
//        list.setItems(items);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    public void addReportButtonAction(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/layout/PatientInformation.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Patient Info Page");
        stage.show();
    }

    public void exitButtonAction(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/layout/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.show();
    }
}
