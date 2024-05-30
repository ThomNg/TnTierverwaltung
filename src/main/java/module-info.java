module com.tng.tntierverwaltung {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tng.tntierverwaltung to javafx.fxml;
    exports com.tng.tntierverwaltung;
}