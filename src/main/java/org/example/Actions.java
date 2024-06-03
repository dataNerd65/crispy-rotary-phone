package org.example;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

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
        @Override
        public void handle(ActionEvent event){
            System.out.println("Open menu item clicked!");
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

