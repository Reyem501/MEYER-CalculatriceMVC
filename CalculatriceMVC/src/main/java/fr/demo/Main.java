package fr.demo;

import javafx.application.Application;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Afficher une boîte de dialogue pour permettre à l'utilisateur de choisir entre Swing et JavaFX
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
            // L'utilisateur choisit JavaFX
            Application.launch(CalculatriceViewJavaFX.class, args);
        } else if (choix == 1) {
            // L'utilisateur choisit Swing
            CalculatriceModel model = new CalculatriceModel();
            CalculatriceViewSwing view = new CalculatriceViewSwing();
            SwingController controller = new SwingController(model, view);
            view.setVisible(true);
        } else {
            System.exit(0);
        }
    }
}
