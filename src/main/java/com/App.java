package main.java.com;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.model.User;
import main.java.com.security.Auth;

/**
 * Main Application. This class handles navigation and user session.
 * @author Tarun Tyagi
 */
public class App extends Application {
    private Stage stage;
    private User loggedUser;

    private static App instance;

    public App() {
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    /**
     * @param args the command line arguments
     */
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

    public boolean userLogging(String userId, String password){
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

    private Parent replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxml));
        Parent page = (Parent) loader.load();

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