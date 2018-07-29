package NLP_Audiology.src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Screen;

import javafx.geometry.Rectangle2D;

public class AudiologyNLP extends Application {
    private static final int SCREENWIDTH = 900;
    private static final int SCREENHEIGHT = 600;
    private LoginScene login;
    private MainScene main;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        Scene scene = startApp();
        stage.setTitle("Audiology NLP");

        stage.setScene(scene);
        stage.show();

        stage.setHeight(SCREENHEIGHT);
        stage.setWidth(SCREENWIDTH);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);
    }


    public Scene startApp() {
        login = new LoginScene();
        Button loginBtn = login.getLoginBtn();

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (login.getPassField().getText().equals("asdf")) {
                    main = new MainScene();
                    stage.setScene(new Scene(main));
                } else {
                    login.getActionText().setFill(Color.FIREBRICK);
                    login.getActionText().setText("Incorrect Password");
                }
            }
        });

        return new Scene(login);
    }

    public static void main(String[] args) {
        launch(args);
    }
}