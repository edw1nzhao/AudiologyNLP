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
    private LoginScene login;
    private MainScene main;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        Scene scene = startApp();
        stage.setTitle("AudiologyNLP");


        // login = new Scene(grid, SCREENWIDTH, SCREENHEIGHT);
        stage.setScene(scene);
        stage.show();

        stage.setHeight(SCREENHEIGHT);
        stage.setWidth(SCREENWIDTH);
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

//     public VBox addVBox(); {
//         VBox vbox = new VBox();
//         vbox.setPadding(new Insets(10));
//         vbox.setSpacing(8);

//         Text title = new Text("Data");
//         title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//         vbox.getChildren().add(title);

//         Hyperlink options[] = new Hyperlink[] {
//             new Hyperlink("Sales"),
//             new Hyperlink("Marketing"),
//             new Hyperlink("Distribution"),
//             new Hyperlink("Costs")};

//         for (int i=0; i<4; i++) {
//             VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
//             vbox.getChildren().add(options[i]);
//         }

//     return vbox;
// }


    public static void main(String[] args) {
        launch(args);
    }



}