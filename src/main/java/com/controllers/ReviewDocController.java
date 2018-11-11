package main.java.com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import main.java.com.App;
import main.java.com.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;

public class ReviewDocController implements Initializable {
    private static App app;
    private static User user;
    private Path file;

    @FXML
    private Label textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        app = App.getInstance();
        user = app.getUser();
        file = Paths.get("out.txt");
//        try {
//
////            Scanner scan = new Scanner(file).useDelimiter("\\s+");
////            while (scan.hasNextLine()) {
////                textArea.appendText(scan.nextLine() + "\n");
////            }
////
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }
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
            app.replaceSceneContent("/main/resources/fxml/EditDoc.fxml", 700, 550);
        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    //helper method for reading files entirely into textarea
    static String readFile(Path filename)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(filename);
        return new String(encoded);
    }
}
