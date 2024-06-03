package org.example;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
//import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Actions {
    //making static classes
    public static class NewMenuItemClickHandler implements EventHandler<ActionEvent>{
        private TextArea textArea;
        private Actions.SaveMenuItemClicker saveMenuItemClicker;

        public NewMenuItemClickHandler(TextArea textArea, Actions.SaveMenuItemClicker saveMenuItemClicker){
            this.textArea = textArea;
            this.saveMenuItemClicker = saveMenuItemClicker;
        }
        @Override
        public void handle(ActionEvent event){
            //for the start just printing
            System.out.println("New Menu Item Clicked!");
            saveMenuItemClicker.handle(event);
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
        public SaveMenuItemClicker(TextArea textArea){
            this.textArea = textArea;
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
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
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


