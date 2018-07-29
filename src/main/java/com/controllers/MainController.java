package main.java.com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.java.com.App;
import main.java.com.model.User;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainController implements Initializable {
    private static App app;
    private static User user;

    @Override public void initialize(URL location, ResourceBundle resources) {
        app = App.getInstance();
        user = app.getUser();
    }

    @FXML protected void processLogout() {
        app.userLogout();
    }

    @FXML protected void processAddPatient() {
        try {
            app.replaceSceneContent("/main/resources/fxml/NewPatient.fxml");
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

//    @FXML public TextField searchBar;
//    @FXML public ListView<String> patientList;
//    @FXML private AnchorPane anchorPane;
//
//
//    public void addReportButtonAction(ActionEvent event) throws IOException {
//        ((Node)(event.getSource())).getScene().getWindow().hide();
//        Parent parent = FXMLLoader.load(getClass().getResource("fxml/NewDocument.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//        stage.setTitle("Upload New Document");
//        stage.show();
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        ObservableList<String> patients = FXCollections.observableArrayList();
//        patients.add("John Doe");
//        patients.add("Edwin Zhao");
//        patients.add("Kun Kim");
//        patients.add("Joonhyuk Chun");
//        patientList.setItems(patients);
//    }
//
//    public void viewPatientButtonAction(ActionEvent event) throws IOException {
//        ((Node)(event.getSource())).getScene().getWindow().hide();
//        Parent parent = FXMLLoader.load(getClass().getResource("fxml/PatientInformation.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//        stage.setTitle("Patient Information");
//        stage.show();
//    }
//}

