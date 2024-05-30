package com.tng.tntierverwaltung;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    //region Konstanten
    private static SceneManager instance;
    // endregion

    //region Attribute
    private Stage mainStage;
    //endregion

    //region Konstruktoren
    private SceneManager() {
    }
    //endregion

    //region Methoden
    public static synchronized SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void setAndConfigureMainStage(Stage stage) {
        mainStage = stage;
        mainStage.setTitle("Tn Animal Shelter");
        switchScene("AnimalOverview.fxml");
    }

    public void switchScene(String resourceFilePath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(resourceFilePath));
            Scene scene = new Scene(fxmlLoader.load());
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion
}
