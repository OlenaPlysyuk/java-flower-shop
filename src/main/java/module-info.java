module com.example.flowerstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;


    opens com.example.flowerstore to javafx.fxml;
    exports com.example.flowerstore;
    opens com.example.flowerstore.florist to javafx.fxml;
    exports com.example.flowerstore.florist;


}