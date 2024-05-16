package com.example.flowerstore;
import database.Delete;
import database.Insert;
import database.Select;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
public class Menu {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToSceneDelivery(ActionEvent event) throws  IOException {
        Select select = new Select();
        if(select.existUserData())
        {
            root = FXMLLoader.load(getClass().getResource("actmenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Action menu");
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            root = FXMLLoader.load(getClass().getResource("del.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Delivery");
            stage.setScene(scene);
            stage.show();
        }
    }
    public void switchToSceneActMenu(ActionEvent event) throws  IOException {

        root = FXMLLoader.load(getClass().getResource("actmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Action menu");
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
}
