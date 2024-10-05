package fr.demo;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatriceViewJavaFX extends Stage implements CalculatriceViewInterface {

    private TextField ecran;
    private Button[] chiffres;
    private Button addition, soustraction, multiplication, division, egal, clear, point, signe, puissance, racine;

    // Construction de la vue JavaFX
    public CalculatriceViewJavaFX() {

        this.setTitle("MEYER - CalculatriceMVC avec JavaFX");

        // Création de l'écran d'affichage
        ecran = new TextField();
        ecran.setEditable(false);
        ecran.setStyle("-fx-font-size: 30; -fx-alignment: center-right;");

        // Création des boutons de chiffre
        chiffres = new Button[10];
        for (int i = 0; i < 10; i++) {
            chiffres[i] = new Button(String.valueOf(i));
            chiffres[i].setMinSize(70, 50);
            chiffres[i].setStyle("-fx-font-size: 20px;");  // Définit la taille de la police à 20px

        }

        // Création des boutons d'opération
        addition = new Button("+");
        soustraction = new Button("-");
        multiplication = new Button("*");
        division = new Button("/");
        egal = new Button("=");
        clear = new Button("C");
        point = new Button(".");
        signe = new Button("±");
        puissance = new Button("^");
        racine = new Button("√");

        // Configuration du la GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Ajout des boutons dans la GridPane
        gridPane.add(ecran, 0, 0, 4, 1);

        puissance.setStyle("-fx-font-size: 20px;");
        gridPane.add(puissance, 0, 1);
        signe.setStyle("-fx-font-size: 20px;");
        gridPane.add(signe, 1, 1);
        racine.setStyle("-fx-font-size: 20px;");
        gridPane.add(racine, 2, 1);
        division.setStyle("-fx-font-size: 20px;");
        gridPane.add(division, 3, 1);

        gridPane.add(chiffres[7], 0, 2);
        gridPane.add(chiffres[8], 1, 2);
        gridPane.add(chiffres[9], 2, 2);
        multiplication.setStyle("-fx-font-size: 20px;");
        gridPane.add(multiplication, 3, 2);

        gridPane.add(chiffres[4], 0, 3);
        gridPane.add(chiffres[5], 1, 3);
        gridPane.add(chiffres[6], 2, 3);
        soustraction.setStyle("-fx-font-size: 20px;");
        gridPane.add(soustraction, 3, 3);

        gridPane.add(chiffres[1], 0, 4);
        gridPane.add(chiffres[2], 1, 4);
        gridPane.add(chiffres[3], 2, 4);
        addition.setStyle("-fx-font-size: 20px;");
        gridPane.add(addition, 3, 4);

        gridPane.add(chiffres[0], 0, 5);
        point.setStyle("-fx-font-size: 20px;");
        gridPane.add(point, 1, 5);

        clear.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 20;");  // bouton clear en rouge
        gridPane.add(clear, 2, 5);
        egal.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 20;"); // bouton egal en vert
        gridPane.add(egal, 3, 5);

        // Création de la scène
        Scene scene = new Scene(gridPane, 400, 600);
        this.setScene(scene);
    }


    @Override
    public void setEcranText(String text) {
        ecran.setText(text);
    }

    @Override
    public String getEcranText() {
        return ecran.getText();
    }

    @Override
    public void addChiffreListener(int chiffre, Runnable listener) {
        chiffres[chiffre].setOnAction(e -> listener.run());
    }

    @Override
    public void addOperationListener(String operation, Runnable listener) {
        switch (operation) {
            case "+":
                addition.setOnAction(e -> listener.run());
                break;
            case "-":
                soustraction.setOnAction(e -> listener.run());
                break;
            case "*":
                multiplication.setOnAction(e -> listener.run());
                break;
            case "/":
                division.setOnAction(e -> listener.run());
                break;
            case "^":
                puissance.setOnAction(e -> listener.run());
                break;
            case "√":
                racine.setOnAction(e -> listener.run());
                break;
        }
    }

    @Override
    public void addEgalListener(Runnable listener) {
        egal.setOnAction(e -> listener.run());
    }

    @Override
    public void addClearListener(Runnable listener) {
        clear.setOnAction(e -> listener.run());
    }

    @Override
    public void addPointListener(Runnable listener) {
        point.setOnAction(e -> listener.run());
    }

    @Override
    public void addSigneListener(Runnable listener) {
        signe.setOnAction(e -> listener.run());
    }
}
