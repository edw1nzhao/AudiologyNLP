package main.java.com.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayRecord implements Initializable{

    public ImageView imageview;
    public TextField nameTextField;
    public TextArea TestTextArea;
    public TextArea DiagnosisTextArea;
    public TextArea RecomendTextArea;
    public TextField DOB;
    public TextField gender;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final Image image = new Image(main.java.com.controllers.DisplayRecord.class.getResourceAsStream("patientExample.png"));
        imageview.setImage(image);


        nameTextField.setText("John Doe");
        DOB.setText("05/28/2010");
        gender.setText("Male");
        TestTextArea.setText("1. Tympanometry/Immittance" + "\n" +
                             "2. Distortion Product Otoacoustic Emission" + "\n" +
                             "3. Auditory Brainstem Response(ABR)");
        DiagnosisTextArea.setText("Test results indicate that John Doe has a mild loss in" + "\n" +
                            "the right ear. Further evaluation is needed to determine if " + "\n" +
                            "it is conductive or sensorineural");
        RecomendTextArea.setText("1. It is Recommended that John Doe follow up with Dr." + "\n" +
                                 "2. Repeat testing in 1 month. Scheduled for 5/16/14");
    }

    public void saveButtonClicked(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/main/java/com/core/PatientInformation.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Patient Information");
        stage.show();
    }
}
