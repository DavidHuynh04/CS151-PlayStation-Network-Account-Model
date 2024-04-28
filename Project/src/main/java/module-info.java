module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project to javafx.fxml;
    exports com.example.project.Model;
    exports com.example.project.View;
    opens com.example.project.View to javafx.fxml;
    exports com.example.project.Controller;
    opens com.example.project.Controller to javafx.fxml;
}