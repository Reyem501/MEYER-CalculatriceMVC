package fr.demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingController {

    private final CalculatriceViewSwing view;
    private String operateur = "";
    private double firstNb = 0;

    public SwingController(CalculatriceModel model, CalculatriceViewSwing view) {
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

