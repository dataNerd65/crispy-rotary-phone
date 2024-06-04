package org.example;

//Creating a class of MyApp that inherits from Javafx.application.Application

//Importing the necessary libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;
import javafx.stage.Popup;
//import javafx.geometry.Side;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyCombination;

public class Main extends Application{

    private TextArea textArea;

    @Override
    public void start(Stage stage) {
        textArea = new TextArea();
        //Trying css referencing
        textArea.getStyleClass().add("text-area");
        //Menu for file operations (new, open, save, print)
        //Creating MenuBar to hold all your menus
        MenuBar menuBar = new MenuBar();
        //creating menu for file operations
        Menu fileMenu = new Menu("File");

        //Menu for edit ops
        Menu editMenu = new Menu("Edit");

        //Menu for format ops
        Menu formatMenu = new Menu("Format");

        //creating menuItems for file operations and their onclick events
        //Also instantiating the class Actions.java with its static classes that handle the respective actions

        Actions.SaveMenuItemClicker saveMenuItemClicker = new Actions.SaveMenuItemClicker(textArea);
        MenuItem newMenuItem = new MenuItem("New");
        //here
        newMenuItem.setOnAction(new Actions.NewMenuItemClickHandler(textArea, saveMenuItemClicker));

        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setOnAction(new Actions.OpenMenuItemClickHandler(textArea));

        MenuItem saveMenuItem = new MenuItem("Save");
        saveMenuItem.setOnAction(new Actions.SaveMenuItemClicker(textArea));
        saveMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));

        MenuItem printMenuItem = new MenuItem("Print");
        printMenuItem.setOnAction(new Actions.PrintMenuItemClicker());

        //creating menuItems for editMenu
        MenuItem copyMenuItem = new MenuItem("Copy");
        MenuItem pasteMenuItem = new MenuItem("Paste");
        MenuItem cutMenuItem = new MenuItem("Cut");
        MenuItem selectAllMenuItem = new MenuItem("Select All");

        //Creating MenuButtons for each category of formatting operations
        MenuButton fontMenuButton = new MenuButton("Font");
        MenuButton textStyleMenuButton = new MenuButton("Style");
        MenuButton lineSpacingMenuButton = new MenuButton("LineSpacing");
        MenuButton numberingMenuButton = new MenuButton("Numbering");

        // Creating MenuItems for each operation in the font category
        MenuItem fontStyleMenuItem = new MenuItem("FontStyle");
        MenuItem fontSizeMenuItem = new MenuItem("FontSize");
        MenuItem fontColorMenuItem = new MenuItem("FontColor");

        //Adding MenuItems to the Font MenuButton
        fontMenuButton.getItems().addAll(fontStyleMenuItem, fontSizeMenuItem, fontColorMenuItem);

        //Creating MenuItems for each operation in the Text Style category
        MenuItem boldMenuItem = new MenuItem("Bold");
        MenuItem italicMenuItem = new MenuItem("Italic");
        MenuItem underlineMenuItem = new MenuItem("Underline");

        //Adding MenuItems to the Text Style MenuButton
        textStyleMenuButton.getItems().addAll(boldMenuItem, italicMenuItem, underlineMenuItem);

        //Creating MenuItems for each operation in the numbering category
        MenuItem bulletPointsMenuItem = new MenuItem("Bullets");
        MenuItem numberedListMenuItem = new MenuItem("Numbering");

        //Adding menuItems to the Numbering MenuButton
        numberingMenuButton.getItems().addAll(bulletPointsMenuItem, numberedListMenuItem);

        //creating a HBox to hold the MenuButtons
        HBox formattingMenu = new HBox();
        formattingMenu.getChildren().addAll(fontMenuButton, textStyleMenuButton, lineSpacingMenuButton, numberingMenuButton);

        //creating a popup for the formatting menu
        Popup formattingPopup = new Popup();

        //Setting auto hide to true
        formattingPopup.setAutoHide(true);

        //Adding HBox to the popup
        formattingPopup.getContent().add(formattingMenu);

        //realized that one cannot set the action for the format menu but do it on a menu item

        //Creating a menu item for the format menu
        MenuItem formatMenuItem = new MenuItem("Format Options");

        //Setting the action for the format menu item
        formatMenuItem.setOnAction(e -> {
            //Show the pop up below menu bar
            System.out.println("Format menu item clicked");
            System.out.println("Menubar height: " + menuBar.getHeight());
            formattingPopup.show(menuBar.getScene().getWindow(),
                                 menuBar.localToScreen(menuBar.getBoundsInLocal()).getMinX(),
                                 menuBar.localToScreen(menuBar.getBoundsInLocal()).getMaxY());
        });

        //Adding MenuItems to fileMenu
        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, printMenuItem);

        //Adding MenuItems to editMenu
        editMenu.getItems().addAll(copyMenuItem, pasteMenuItem, cutMenuItem, selectAllMenuItem);

        //Adding Menu to MenuBar for file ops
        menuBar.getMenus().add(fileMenu);

        //Adding Menu to MenuBar for edit
        menuBar.getMenus().add(editMenu);

        //Adding Menu to MenuBar for format
        menuBar.getMenus().add(formatMenu);

        //Creating a BorderPane with the MenuBar at the top
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(textArea);

        //Menu for edit operations(copy paste, cut, select all)

        //Menu for format operations (change font)
        formatMenu.getItems().add(formatMenuItem);

        Scene scene = new Scene(borderPane, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(scene.getStylesheets());
        System.out.println(textArea.getStyleClass());

    }
    public static void main(String args[]){
        launch(args);
        System.out.println("I will implement an app myself to actually run and master java well.");
    }
}








