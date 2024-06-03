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

public class Actions {
    //making static classes
    public static class NewMenuItemClickHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            //for the start just printing
            System.out.println("New Menu Item Clicked!");
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
        @Override
        public void handle(ActionEvent event){
            System.out.println("Save Menu Item clicked!");
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


