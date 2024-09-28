package fr.demo;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class CalculatriceViewJavaFX extends Application {

    private TextField ecran;
    private Button[] chiffres;
    private Button addition, soustraction, multiplication, division, egal, clear;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MEYER - CalculatriceMVC avec JavaFX");

        // Création de l'écran d'affichage
        ecran = new TextField();
        ecran.setEditable(false);
        ecran.setStyle("-fx-font-size: 30; -fx-alignment: center-right;");

        // Création des boutons numériques
        chiffres = new Button[10];
        for (int i = 0; i < 10; i++) {
            chiffres[i] = new Button(String.valueOf(i));
            chiffres[i].setMinSize(70, 50);
        }

        // Création des boutons d'opérations
        addition = new Button("+");
        soustraction = new Button("-");
        multiplication = new Button("*");
        division = new Button("/");
        egal = new Button("=");
        clear = new Button("C");

        // Configuration du GridPane pour organiser les boutons
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Positionnement des boutons dans le GridPane
        gridPane.add(ecran, 0, 0, 4, 1); // L'écran occupe 4 colonnes

        int buttonIndex = 1;
        for (int row = 1; row < 4; row++) {
            for (int col = 0; col < 3; col++) {
                gridPane.add(chiffres[buttonIndex], col, row);
                buttonIndex++;
            }
        }

        gridPane.add(chiffres[0], 0, 4);
        gridPane.add(egal, 1, 4);
        gridPane.add(clear, 2, 4);
        gridPane.add(addition, 3, 1);
        gridPane.add(soustraction, 3, 2);
        gridPane.add(multiplication, 3, 3);
        gridPane.add(division, 3, 4);

        // Création de la scène
        Scene scene = new Scene(gridPane, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Instanciation du modèle et du contrôleur
        CalculatriceModel model = new CalculatriceModel();
        JavaFXController controller = new JavaFXController(model, this); // "this" passe la vue
    }


    public TextField getEcran() {
        return ecran;
    }

    public Button[] getChiffres() {
        return chiffres;
    }

    public Button getAddition() {
        return addition;
    }

    public Button getSoustraction() {
        return soustraction;
    }

    public Button getMultiplication() {
        return multiplication;
    }

    public Button getDivision() {
        return division;
    }

    public Button getEgal() {
        return egal;
    }

    public Button getClear() {
        return clear;
    }
}
