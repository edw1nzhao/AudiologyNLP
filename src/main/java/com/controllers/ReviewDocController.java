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

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class ReviewDocController implements Initializable {
    private static App app;
    private static User user;
    private Path file;
    private String output = "";

    @FXML private Label content;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        app = App.getInstance();
        user = app.getUser();
        file = Paths.get("out.txt");

        //Loading the tokenizer model
        try {
            InputStream inputStreamTokenizer = new
                    FileInputStream("./models/en-token.bin");
            TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);

            //Instantiating the TokenizerME class
            TokenizerME tokenizer = new TokenizerME(tokenModel);

            //read the input text as a single string

            FileReader in = new FileReader("./out.txt");
            BufferedReader br = new BufferedReader(in);

            String line = br.readLine();
            String sentence = line;
            while (line != null) {
                sentence += line;
                line = br.readLine();
            }

            //Tokenizing the sentence in to a string array
            String tokens[] = tokenizer.tokenize(sentence);

            //Loading the name finder model
            InputStream inputStreamNameFinder = new FileInputStream("./models/en"
                    + "-ner-person.bin");
            TokenNameFinderModel name_model = new TokenNameFinderModel(inputStreamNameFinder);

            NameFinderME nameFinder = new NameFinderME(name_model);
            Span nameSpans[] = nameFinder.find(tokens);

            //Printing the names and their spans in a sentence

            output += "NAMES: ";
            for (Span s : nameSpans) {
                //print out the name as well as its location
                output += (s.toString() + "  " + tokens[s.getStart()] + "\n");

                //only print out name
                //System.out.println(tokens[s.getStart()]);
            }

            //loading the date finder model
            InputStream inputStreamNameFinder2 = new FileInputStream("./models/en"
                    + "-ner-date.bin");
            TokenNameFinderModel date_model = new TokenNameFinderModel(inputStreamNameFinder2);

            NameFinderME dateFinder = new NameFinderME(date_model);
            Span dateSpans[] = dateFinder.find(tokens);
            output += "\n";
            //Printing the names and their spans in a sentence
            output += ("DATES: ");
            for (Span s : dateSpans) {
                output += (s.toString() + "  " + tokens[s.getStart()] + "\n");
            }

            //loading the location finder model
            InputStream inputStreamNameFinder3 = new FileInputStream("./models/en"
                    + "-ner-location.bin");
            TokenNameFinderModel location_model = new TokenNameFinderModel(inputStreamNameFinder3);

            NameFinderME locationFinder = new NameFinderME(location_model);
            Span locationSpans[] = locationFinder.find(tokens);

            output+= "\n";
            //Printing the names and their spans in a sentence
            output += ("LOCATIONS: ");
            for (Span s : locationSpans) {
                output += (s.toString() + "  " + tokens[s.getStart()] + "\n");
            }

            //loading the organization finder model
            InputStream inputStreamNameFinder4 = new FileInputStream("./models/en"
                    + "-ner-organization.bin");
            TokenNameFinderModel org_model = new TokenNameFinderModel(inputStreamNameFinder4);

            NameFinderME orgFinder = new NameFinderME(org_model);
            Span orgSpans[] = orgFinder.find(tokens);

            output += "\n";
            //Printing the names and their spans in a sentence
            output += ("Organizations: ");
            for (Span s : orgSpans) {
                output += (s.toString() + "  " + tokens[s.getStart()] + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        output += "HEARING STATUS: OK";

        content.setText(output);

//        try {
////            Scanner scan = new Scanner(file).useDelimiter("\\s+");
////            while (scan.hasNextLine()) {
////                textArea.appendText(scan.nextLine() + "\n");
////            }
////
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
