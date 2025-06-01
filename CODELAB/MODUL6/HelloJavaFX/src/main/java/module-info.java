module com.example.hellojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hellojavafx to javafx.fxml;
    exports com.example.hellojavafx;
}