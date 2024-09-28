/*
package fr.demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatriceController {

    private final CalculatriceViewSwing view;
    private String operateur = "";
    private double firstNb = 0;

    public CalculatriceController(CalculatriceModel model, CalculatriceViewSwing view) {
        this.view = view;

        // Ecouteurs sur les boutons de chiffre
        for (JButton bouton : view.getChiffres()) {
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String chiffre = bouton.getText();
                    view.getEcran().setText(view.getEcran().getText() + chiffre);
                }
            });
        }

        // Ecouteurs sur les boutons d'opération
        view.getAddition().addActionListener(new OperateurListener("+"));
        view.getSoustraction().addActionListener(new OperateurListener("-"));
        view.getMultiplication().addActionListener(new OperateurListener("*"));
        view.getDivision().addActionListener(new OperateurListener("/"));

        // Ecouteur du bouton égal
        view.getEgal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    // Pour afficher les résultats entier sans .0
                    double resultat = model.getResultat();
                    if (resultat == (int) resultat) {
                        view.getEcran().setText(String.valueOf((int) resultat));  // Affiche en tant qu'entier
                    } else {
                        view.getEcran().setText(String.valueOf(resultat));  // Affiche le résultat avec les décimales
                    }
                } catch (ArithmeticException ex) {
                    view.getEcran().setText("Erreur : Division par zéro");
                }
            }
        });

        // Écouteur pour le bouton de réinitialisation
        view.getClear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getEcran().setText("");
            }
        });
    }

    // Gestion des opérations
    private class OperateurListener implements ActionListener {
        private final String operateurSelectionne;

        public OperateurListener(String operateur) {
            this.operateurSelectionne = operateur;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            firstNb = Double.parseDouble(view.getEcran().getText());
            operateur = operateurSelectionne;
            view.getEcran().setText("");
        }
    }
}
*/

package fr.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CalculatriceController {

    private final CalculatriceViewJavaFX view;
    private String operateur = "";
    private double firstNb = 0;

    public CalculatriceController(CalculatriceModel model, CalculatriceViewJavaFX view) {
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
