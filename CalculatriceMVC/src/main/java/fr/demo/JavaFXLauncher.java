package fr.demo;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXLauncher extends Application {

    @Override
    public void start(Stage primaryStage) {

        CalculatriceViewJavaFX view = new CalculatriceViewJavaFX();
        CalculatriceModel model = new CalculatriceModel();
        new CalculatriceController(model, view);
        view.show();
    }
}
