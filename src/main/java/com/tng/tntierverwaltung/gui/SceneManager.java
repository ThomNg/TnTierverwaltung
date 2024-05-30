package com.tng.tntierverwaltung.gui;

import com.tng.tntierverwaltung.Main;
import com.tng.tntierverwaltung.model.Tier;
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

    public void switchToDetailWithTier(Tier selectedTier) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AnimalDetails.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            AnimalDetailsController controller = fxmlLoader.getController();
            controller.setSelectedTier(selectedTier);

            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion
}
