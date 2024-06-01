package org.example;

//Creating a class of MyApp that inherits from Javafx.application.Application
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextArea;

public class Main extends Application{

    private TextArea textArea;

    @Override
    public void start(Stage stage) throws Exception {
        textArea = new TextArea();
        //Menu for file operations (new, open, save, print)

        //Menu for edit operations(copy paste, cut, select all)

        //Menu for format operations (change font)


        Scene scene = new Scene(textArea, 800, 600);
        stage.setScene(scene);
        stage.show();



    }
    public static void main(String args[]){
        launch(args);
        System.out.println("I will implement an app myself to actually run and master java well.");
    }
}








