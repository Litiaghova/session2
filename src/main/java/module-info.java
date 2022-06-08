module com.example.arina {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires java.sql;

    opens com.arina.session2 to javafx.fxml;
    exports com.arina.session2;
    exports com.arina.session2.db;
    opens com.arina.session2.db to javafx.fxml;
    exports com.arina.session2.tableadmin;
    opens com.arina.session2.tableadmin to javafx.fxml;
}