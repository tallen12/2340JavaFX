/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx2340;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

/**
 * Class to what may one day become the character creator. 
 * Basically just returns a list view object with some sliders in the cells.
 * Uses a lot of copy pasted code from stackoverflow to get working,
 * but I understand enough to make it better for the next iteration. 
 * @author Tyler Allen
 */
public class CharacterCreator extends ListView<String>{
    //Definition for custm cell with sliders and labels 
    static class XCell extends ListCell<String> {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        Slider slider = new Slider();
        String lastItem;
        private Object primaryStage;

        public XCell() {
            super();
            hbox.getChildren().addAll(label, pane, slider);
            HBox.setHgrow(pane, Priority.ALWAYS);
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                lastItem = null;
                setGraphic(null);
            } else {
                lastItem = item;
                label.setText(item!=null ? item : "<null>");
                setGraphic(hbox);
            }
        }
    }
    CharacterCreator(ObservableList<String> list){
        super(list);
        this.setCellFactory((ListView<String> param) -> new XCell());
    }
    

}
