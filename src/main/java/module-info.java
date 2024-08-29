module com.example.caliculator_ioc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.caliculator_ioc to javafx.fxml;
    exports com.example.caliculator_ioc;
}