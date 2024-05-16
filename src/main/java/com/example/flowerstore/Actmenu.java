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

public class Actmenu {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToSceneMake(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mbouquet.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Make a bouquet");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSceneChooseB(ActionEvent event) throws  IOException {

        root = FXMLLoader.load(getClass().getResource("chbouquet.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Choose a bouquet");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToFlower(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("flower.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Choose flowers");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPurchase(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Purchase menu");
        stage.setScene(scene);
        stage.show();
    }
}
