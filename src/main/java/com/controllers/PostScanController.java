package main.java.com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import main.java.com.App;
import main.java.com.model.User;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;

public class PostScanController implements Initializable {
    private static App app;
    private static User user;
    private File file;

    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        app = App.getInstance();
        user = app.getUser();
        file = new File("out.txt");
        try {

            Scanner scan = new Scanner(file).useDelimiter("\\s+");
            while (scan.hasNextLine()) {
                textArea.appendText(scan.nextLine() + "\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }


    @FXML
    protected void processHome() {
        try {
            app.replaceSceneContent("/main/resources/fxml/Main.fxml", 700, 550);
        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    protected void edit() {
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(textArea.getText());
            bw.flush();
            bw.close();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("File Edited");

            // alert.setHeaderText("Results:");
            alert.setContentText("File Successfully Edited And Saved");
            alert.showAndWait();

        } catch(IOException e) {
            System.out.println(e);
        }

        try {
            app.replaceSceneContent("/main/resources/fxml/NewPatient.fxml", 700, 550);
        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
