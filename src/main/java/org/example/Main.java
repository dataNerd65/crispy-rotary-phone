package org.example;

//Creating a class of MyApp that inherits from Javafx.application.Application

//Importing the necessary libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextArea;

public class Main extends Application{

    private TextArea textArea;

    @Override
    public void start(Stage stage) {
       textArea = new TextArea();
        //Menu for file operations (new, open, save, print)
        //Creating MenuBar to hold all your menus
        MenuBar menuBar = new MenuBar();
        //creating menu for file operations
        Menu fileMenu = new Menu("File");

        //Menu for edit ops
        Menu editMenu = new Menu("Edit");

        //creating menuItems for file operations
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem printMenuItem = new MenuItem("Print");

        //creating menuItems for editMenu
        MenuItem copyMenuItem = new MenuItem("Copy");
        MenuItem pasteMenuItem = new MenuItem("Paste");
        MenuItem cutMenuItem = new MenuItem("Cut");
        MenuItem selectAllMenuItem = new MenuItem("Select All");


        //Adding MenuItems to fileMenu
        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, printMenuItem);

        //Adding MenuItems to editMenu
        editMenu.getItems().addAll(copyMenuItem, pasteMenuItem, cutMenuItem, selectAllMenuItem);

        //Adding Menu to MenuBar for file ops
        menuBar.getMenus().add(fileMenu);

        //Adding Menu to MenuBar for edit
        menuBar.getMenus().add(editMenu);

        //Creating a BorderPane with the MenuBar at the top
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(textArea);

        //


        //Menu for edit operations(copy paste, cut, select all)

        //Menu for format operations (change font)


        Scene scene = new Scene(borderPane, 800, 600);
        stage.setScene(scene);
        stage.show();



    }
    public static void main(String args[]){
        launch(args);
        System.out.println("I will implement an app myself to actually run and master java well.");
    }
}








