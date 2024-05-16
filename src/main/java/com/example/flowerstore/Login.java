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
public class Login {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField textField;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private TextField textField5;
    @FXML
    private Label label;
    public void Login(ActionEvent event) throws  IOException {
        label.setText("  ");
        String email = textField.getText();
        String login = textField2.getText();
        String password = textField3.getText();
        String password2 = textField4.getText();
        Select select = new Select();
        Insert insert = new Insert();
        if(password.equals(password2))
        {
            if(select.isUser(login,password))
            {
                Delete delete = new Delete();
                delete.deleteActUser();
                insert.insertActUser(email,login,password);
                root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Purchase way menu");
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                label.setText("Cannot found this akk in BD");
            }
        }
    }
}
