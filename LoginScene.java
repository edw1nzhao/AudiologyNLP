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


public class LoginScene extends GridPane {
    private static final int SCREENWIDTH = 900;
    private static final int SCREENHEIGHT = 600;
    private Button loginBtn = new Button("Sign in");
    private final Text actionText = new Text();
    private PasswordField passField = new PasswordField();

    public LoginScene() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(15));

        // MenuBar menuBar = new MenuBar();
        // menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        // grid.setTop(menuBar);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 25));
        add(scenetitle, 0, 0, 2, 1);

        Label username = new Label("User Name:");
        add(username, 0, 1);

        TextField loginField = new TextField();
        add(loginField, 1, 1);

        Label password = new Label("Password:");
        add(password, 0, 2);

        add(passField, 1, 2);

        HBox hbLogin = new HBox(10);
        hbLogin.setAlignment(Pos.BOTTOM_RIGHT);
        hbLogin.getChildren().add(loginBtn);
        add(hbLogin, 1, 4);

        add(actionText, 1, 6);
    }

    public Text getActionText() {
        return this.actionText;
    }

    public PasswordField getPassField() {
        return this.passField;
    }

    public Button getLoginBtn() {
        return this.loginBtn ;
    }
}