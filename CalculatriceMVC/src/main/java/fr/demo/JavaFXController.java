package fr.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class JavaFXController {

    private final CalculatriceViewJavaFX view;
    private String operateur = "";
    private double firstNb = 0;

    public JavaFXController(CalculatriceModel model, CalculatriceViewJavaFX view) {
        this.view = view;

        // Écouteurs pour les boutons de chiffres
        for (Button bouton : view.getChiffres()) {
            bouton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String chiffre = bouton.getText();
                    view.getEcran().setText(view.getEcran().getText() + chiffre);
                }
            });
        }

        // Écouteurs pour les boutons d'opération
        view.getAddition().setOnAction(new OperateurListener("+"));
        view.getSoustraction().setOnAction(new OperateurListener("-"));
        view.getMultiplication().setOnAction(new OperateurListener("*"));
        view.getDivision().setOnAction(new OperateurListener("/"));

// Écouteur pour le bouton égal
        view.getEgal().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operateur.isEmpty()) {
                    // Si aucun opérateur n'a été sélectionné, afficher simplement le nombre actuel
                    view.getEcran().setText(view.getEcran().getText());
                } else {
                    // Si un opérateur a été sélectionné, effectuer le calcul
                    double secondNb = Double.parseDouble(view.getEcran().getText());
                    try {
                        switch (operateur) {
                            case "+":
                                model.setResultat(model.addition(firstNb, secondNb));
                                break;
                            case "-":
                                model.setResultat(model.soustraction(firstNb, secondNb));
                                break;
                            case "*":
                                model.setResultat(model.multiplication(firstNb, secondNb));
                                break;
                            case "/":
                                model.setResultat(model.division(firstNb, secondNb));
                                break;
                        }
                        double resultat = model.getResultat();
                        if (resultat == (int) resultat) {
                            // Si le résultat est un entier, l'afficher sans virgule
                            view.getEcran().setText(String.valueOf((int) resultat));
                        } else {
                            // Sinon, afficher le résultat avec les décimales
                            view.getEcran().setText(String.valueOf(resultat));
                        }
                    } catch (ArithmeticException ex) {
                        view.getEcran().setText("Erreur : Division par zéro");
                    }
                }
            }
        });


        // Écouteur pour le bouton clear
        view.getClear().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getEcran().setText("");
            }
        });
    }

    private class OperateurListener implements EventHandler<ActionEvent> {
        private final String operateurSelectionne;

        public OperateurListener(String operateur) {
            this.operateurSelectionne = operateur;
        }

        @Override
        public void handle(ActionEvent event) {
            firstNb = Double.parseDouble(view.getEcran().getText());
            operateur = operateurSelectionne;
            view.getEcran().setText("");
        }
    }
}