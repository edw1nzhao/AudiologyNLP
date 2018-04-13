import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AudiologyNLP extends Application {
    private static final int SCREENWIDTH = 900;
    private static final int SCREENHEIGHT = 600;



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AudiologyNLP");


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15));

        // MenuBar menuBar = new MenuBar();
        // menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        // grid.setTop(menuBar);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 25));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label username = new Label("User Name:");
        grid.add(username, 0, 1);

        TextField loginField = new TextField();
        grid.add(loginField, 1, 1);

        Label password = new Label("Password:");
        grid.add(password, 0, 2);

        PasswordField passField = new PasswordField();
        grid.add(passField, 1, 2);

        Button loginBtn = new Button("Sign in");
        HBox hbLogin = new HBox(10);
        hbLogin.setAlignment(Pos.BOTTOM_RIGHT);
        hbLogin.getChildren().add(loginBtn);
        grid.add(hbLogin, 1, 4);

        final Text actionText = new Text();
        grid.add(actionText, 1, 6);

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (passField.getText().equals("asdf")) {
                    actionText.setFill(Color.FIREBRICK);
                    actionText.setText("Incorrect Password");
                } else {
                }
            }
        });

        Scene scene = new Scene(grid, SCREENWIDTH, SCREENHEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}