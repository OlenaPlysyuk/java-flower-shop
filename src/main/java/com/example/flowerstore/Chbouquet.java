package com.example.flowerstore;
import com.example.flowerstore.florist.Accessories;
import com.example.flowerstore.florist.Bouquet;
import database.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.example.flowerstore.florist.Flower;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Chbouquet implements Initializable {
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
    private Label label;
    @FXML
    TableView<Bouquet> bouquetTableView;
    @FXML
    TableColumn<Bouquet,String> nameB = new TableColumn<>();
    @FXML
    TableColumn<Bouquet,Integer> priceB = new TableColumn<>();
    @FXML
    TableColumn<Bouquet,String> descB = new TableColumn<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameB.setCellValueFactory(new PropertyValueFactory<Bouquet, String>("name"));
        priceB.setCellValueFactory(new PropertyValueFactory<Bouquet, Integer>("price"));
        descB.setCellValueFactory(new PropertyValueFactory<Bouquet, String>("description"));
    }
    public void Ch(ActionEvent event) throws IOException, InterruptedException
    {
        label.setText("  ");
        Select select = new Select();
        select.SelectBouquets();
        int bouquet = Integer.parseInt(textField.getText());
        int id = select.FindUser();
        Insert insert = new Insert();
        insert.insertUserBouquets(id,bouquet);
        System.out.println("Thank you for buying!");
        label.setText("Thank you for buying!");
        Thread.sleep(2000);
        root = FXMLLoader.load(getClass().getResource("actmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Purchase way menu");
        stage.setScene(scene);
        stage.show();
    }
    public void GetData(ActionEvent event) throws IOException
    {
        Select select = new Select();
        ObservableList<Bouquet> bouquets = select.SelectBouquets();
        bouquetTableView.setItems(bouquets);
    }

}
