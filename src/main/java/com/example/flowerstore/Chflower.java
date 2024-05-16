package com.example.flowerstore;
import com.example.flowerstore.florist.Accessories;
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

public class Chflower implements Initializable {
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
    TableView<Flower> flowerTableView;
    @FXML
    TableColumn<Flower,String> nameC = new TableColumn<>();
    @FXML
    TableColumn<Flower,String> colorC = new TableColumn<>();
    @FXML
    TableColumn<Flower,String> scentC = new TableColumn<>();
    @FXML
    TableColumn<Flower,String> sizeC = new TableColumn<>();
    @FXML
    TableColumn<Flower,String> descriptionC = new TableColumn<>();
    @FXML
    TableColumn<Flower,String> producerC = new TableColumn<>();
    @FXML
    TableColumn<Flower,String> countryC = new TableColumn<>();
    @FXML
    TableColumn<Flower,Integer> priceC = new TableColumn<>();
    @FXML
    TableColumn<Flower,Integer> countC = new TableColumn<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        nameC.setCellValueFactory(new PropertyValueFactory<Flower,String>("name"));
        colorC.setCellValueFactory(new PropertyValueFactory<Flower,String>("color"));
        scentC.setCellValueFactory(new PropertyValueFactory<Flower,String>("scent"));
        sizeC.setCellValueFactory(new PropertyValueFactory<Flower,String>("size"));
        descriptionC.setCellValueFactory(new PropertyValueFactory<Flower,String>("description"));
        producerC.setCellValueFactory(new PropertyValueFactory<Flower,String>("producer"));
        countryC.setCellValueFactory(new PropertyValueFactory<Flower,String>("countryOfOrigin"));
        priceC.setCellValueFactory(new PropertyValueFactory<Flower,Integer>("price"));
        countC.setCellValueFactory(new PropertyValueFactory<Flower,Integer>("count"));
    }
    public void Make(ActionEvent event) throws IOException, InterruptedException {
        label.setText("  ");
        Select select = new Select();
        int flower = Integer.parseInt(textField.getText());
        int count = Integer.parseInt(textField2.getText());
        int price = select.FlowerPrice(flower);
        int id = select.FindUser();
        Insert insert = new Insert();
        insert.insertUserFlowers(id,flower,count,price*count);
        System.out.println("Price:" + price*count);
        System.out.println("Thank you for buying!");
        label.setText("Your sum is " + price * count + "uah.Thank you for buying");
        Thread.sleep(2000);
        root = FXMLLoader.load(getClass().getResource("actmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Purchase way menu");
        stage.setScene(scene);
        stage.show();
    }
    public void GetFlowers(ActionEvent event) throws IOException
    {
        Select select = new Select();
        ObservableList<Flower> flowers = select.SelectFlowers();
        flowerTableView.setItems(flowers);
    }
}
