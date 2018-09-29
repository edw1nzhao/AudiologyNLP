package main.java.com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        app = App.getInstance();
        user = app.getUser();

        try {

            Scanner scan = new Scanner(new File("out.txt")).useDelimiter("\\s+");
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
            app.replaceSceneContent("/main/resources/fxml/Main.fxml");
        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
