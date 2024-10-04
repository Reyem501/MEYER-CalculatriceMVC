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


        // Configuration du GridPane pour organiser les boutons
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Positionnement des boutons dans le GridPane
        gridPane.add(ecran, 0, 0, 4, 1);

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
        gridPane.add(point, 2, 5);
        gridPane.add(signe, 0, 5);
        gridPane.add(addition, 3, 1);
        gridPane.add(soustraction, 3, 2);
        gridPane.add(multiplication, 3, 3);
        gridPane.add(division, 3, 4);
        gridPane.add(puissance, 3, 5);
        gridPane.add(racine, 3, 6);


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
