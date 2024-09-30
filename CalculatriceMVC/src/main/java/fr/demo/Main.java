package fr.demo;

import javafx.application.Application;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Affichage d'une boîte de dialogue pour choisir entre Swing et JavaFX
        Object[] options = {"JavaFX", "Swing"};
        int choix = JOptionPane.showOptionDialog(
                null,
                "Choisissez l'interface à utiliser :",
                "Sélection de l'interface",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choix == 0) {
            // Lance JavaFX
            Application.launch(JavaFXLauncher.class, args);
        } else if (choix == 1) {
            // Lance Swing
            CalculatriceModel model = new CalculatriceModel();
            CalculatriceViewSwing view = new CalculatriceViewSwing();
            new CalculatriceController(model, view);
            view.setVisible(true);
        } else {
            System.exit(0);
        }
    }
}
