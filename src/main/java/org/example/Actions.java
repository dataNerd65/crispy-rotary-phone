package org.example;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
//import javafx.scene.control.MenuItem;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Actions {
    //making static classes
    public static class NewMenuItemClickHandler implements EventHandler<ActionEvent>{
        private TextArea textArea;
        private SaveMenuItemClicker saveMenuItemClicker;
        private File currentFile;
        private boolean isModified;

        public NewMenuItemClickHandler(TextArea textArea, SaveMenuItemClicker saveMenuItemClicker){
            this.textArea = textArea;
            this.saveMenuItemClicker = saveMenuItemClicker;
            this.isModified = false;

            //Adding a ChangeListener to the TextArea's text property
            this.textArea.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                    if (!newValue.isEmpty()){
                        isModified = true;
                    }

                }
            });
        }
        public void setModified(boolean isModified){
            this.isModified = isModified;
        }
        @Override
        public void handle(ActionEvent event) {
            if (isModified){
                if (currentFile != null && currentFile.exists()) {
                    try {
                        Files.write(Paths.get(currentFile.toURI()), textArea.getText().getBytes());
                        isModified = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("You have unsaved changes");
                    alert.setContentText("Do you want to save your changes?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        saveMenuItemClicker.handle(event);
                        currentFile = saveMenuItemClicker.getCurrentFile();
                        isModified = false;

                    }
                }
            }
            textArea.setText("");
        }

    }

    public static class OpenMenuItemClickHandler implements EventHandler<ActionEvent>{
        private TextArea textArea;
        
        public OpenMenuItemClickHandler(TextArea textArea) {
            this.textArea = textArea;

        }
        @Override
        public void handle(ActionEvent event){
            System.out.println("Open menu item clicked!");
            FileChooser fileChooser = new FileChooser();
            Window window = textArea.getScene().getWindow();
            File file = fileChooser.showOpenDialog(window);
            if(file != null){
                try {
                    String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
                    textArea.setText(content);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
                
            }
        }

    public static  class SaveMenuItemClicker implements EventHandler<ActionEvent>{
        private TextArea textArea;
        private File currentFile;
        private NewMenuItemClickHandler newMenuItemClickHandler;

        public SaveMenuItemClicker(TextArea textArea, NewMenuItemClickHandler newMenuItemClickHandler){
            this.textArea = textArea;
            this.newMenuItemClickHandler = newMenuItemClickHandler;
        }

        @Override
        public void handle(ActionEvent event){
            System.out.println("Save Menu Item clicked!");
            if (textArea.getText().isEmpty()){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning Dialog!");
                alert.setHeaderText(null);
                alert.setContentText("Cannot save an empty workspace!");

                alert.showAndWait();
                return;
            }
            FileChooser fileChooser = new FileChooser();
            Window window = textArea.getScene().getWindow();
            File file = fileChooser.showSaveDialog(window);

            if (file != null){
                try{
                    Files.write(Paths.get(file.toURI()), textArea.getText().getBytes());
                    currentFile = file;
                    newMenuItemClickHandler.setModified(false);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

        }
        public File getCurrentFile(){
            return currentFile;
        }

    }
    public static class PrintMenuItemClicker implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            System.out.println("Print MenuItem Clicked!");
        }
    }



    public static void main(String[] args){

    }

}


