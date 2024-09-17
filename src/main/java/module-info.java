module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.demo4 to javafx.fxml;
    exports com.example.demo4;
}

