package controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientInfo_page implements Initializable {
    @FXML
    public ListView<String> recordList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> records = FXCollections.observableArrayList();
        records.add("05012018_record_1");
        records.add("02112014_record_2");
        records.add("12222013_record_3");
        records.add("07012010_record_4");
        recordList.setItems(records);

        recordList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + recordList.getSelectionModel().getSelectedItem());
            }
        });

    }

    public void backButtonAction(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/layout/Main.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Main Page");
        stage.show();
    }

    public void addReportButtonAction(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/layout/NewDocument.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Upload New Document Page");
        stage.show();
    }
}
