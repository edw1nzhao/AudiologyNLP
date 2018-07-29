package main.java.com;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.java.com.model.User;
import main.java.com.security.Auth;

public class App extends Application {
    private Stage stage;
    private User loggedUser;

    private static App instance;
    private static final FileChooser fc = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();

    public App() {
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            gotoLogin();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUser() {
        return loggedUser;
    }

    public boolean userLogin(String userId, String password){
        if (Auth.validate(userId, password)) {
            loggedUser = User.of(userId);
            gotoMain();
            return true;
        } else {
            return false;
        }
    }

    public void userLogout(){
        loggedUser = null;
        gotoLogin();
    }

    private void gotoMain() {
        try {
            replaceSceneContent("/main/resources/fxml/Main.fxml");
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoLogin() {
        try {
            replaceSceneContent("/main/resources/fxml/Login.fxml");
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadFile() {
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF", "*.pdf*"));
        File file = fc.showOpenDialog(stage);
        
        if (file != null) {
            // DO SOMETHING
        }

    }

    public Parent replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxml));
        Parent page = loader.load();

        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 700, 550);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }
}