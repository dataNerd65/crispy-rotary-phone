package org.example;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

public class HEvents implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event){
        //for the start just printing
        System.out.println("Menu Item Clicked!");
    }
    public static void main(String[] args){

    }

}

