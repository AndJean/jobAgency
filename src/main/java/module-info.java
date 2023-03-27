module com.example.jobagency {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.jobagency to javafx.fxml;
    exports com.example.jobagency;
}