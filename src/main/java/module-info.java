module com.tng.tntierverwaltung {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;


    opens com.tng.tntierverwaltung to javafx.fxml;
    exports com.tng.tntierverwaltung;
    exports com.tng.tntierverwaltung.model;
    exports com.tng.tntierverwaltung.gui;
    opens com.tng.tntierverwaltung.gui to javafx.fxml;
}