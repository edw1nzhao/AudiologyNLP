package main.java.com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.java.com.App;
import main.java.com.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;

public class NewPatientController implements Initializable {
    private static App app;
    private static User user;

    @FXML
    private Label FilePath;
    @Override public void initialize(URL location, ResourceBundle resources) {
        app = App.getInstance();
        user = app.getUser();
    }

    /*
        Edit here for file upload
    */
    @FXML
    protected void processLoadFile() {
        String fp = app.loadFile();
        FilePath.setText(fp);
    }

    @FXML
    protected void processHome() {
        try {
            app.replaceSceneContent("/main/resources/fxml/Main.fxml");
        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    protected void processAddPatient() {
        try {
            app.replaceSceneContent("/main/resources/fxml/NewPatient.fxml");
        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /*
        replace line 68, test.png in command to user input file name
     */
    @FXML
    protected void processScan() {
        try {
            app.replaceSceneContent("/main/resources/fxml/PostScan.fxml");
        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            Process p = Runtime.getRuntime().exec("tesseract test.png out");
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String readline;
            while ((readline = reader.readLine()) != null) {
                System.out.println(readline);
            }
            System.out.println("out.txt created");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}