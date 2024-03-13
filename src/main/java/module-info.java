module com.di.practica4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.di.practica4 to javafx.fxml;
    exports com.di.practica4;
}