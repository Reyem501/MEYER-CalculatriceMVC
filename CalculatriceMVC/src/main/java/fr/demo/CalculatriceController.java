package fr.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatriceController {

    private final CalculatriceViewInterface view;
    private String operateur = "";
    private BigDecimal firstNb = BigDecimal.ZERO;
    private final CalculatriceModel model;

    public CalculatriceController(CalculatriceModel model, CalculatriceViewInterface view) {

        this.view = view;
        this.model = model;

        // Listeners pour les boutons de chiffres
        for (int i = 0; i < 10; i++) {
            int chiffre = i;
            view.addChiffreListener(chiffre, () -> {    // Listeners des boutons de chiffre
                String text = view.getEcranText();
                view.setEcranText(text + chiffre);
            });
        }

        // Listeners des boutons d'opération
        view.addOperationListener("+", () -> setOperateur("+"));
        view.addOperationListener("-", () -> setOperateur("-"));
        view.addOperationListener("*", () -> setOperateur("*"));
        view.addOperationListener("/", () -> setOperateur("/"));

        view.addPointListener(() -> {
            String text = view.getEcranText();
            if (text.isEmpty()) {
                view.setEcranText("0.");   // Si l'utilisateur clique sur la virgule sans chiffre
            } else if (!text.contains(".")) {   // Permet d'ajouter une virgule seulement s'il n'y en a pas
                view.setEcranText(text + ".");
            }
        });

        view.addOperationListener("^", () -> setOperateur("^"));

        view.addOperationListener("√", () -> {
            BigDecimal number = new BigDecimal(view.getEcranText());
            try {
                BigDecimal result = model.racine(number);

                // Afficher le résultat sans zéros inutiles
                view.setEcranText(result.stripTrailingZeros().toPlainString());
            } catch (ArithmeticException e) {
                // Gestion racine d'un nombre négatif
                view.setEcranText("Erreur : nombre négatif");
            }
        });

        view.addPIListener(() -> view.setEcranText(String.valueOf(Math.PI)));

        view.addArrondirListener(() -> {
            String text = view.getEcranText();
            try {
                BigDecimal result = new BigDecimal(text);
                BigDecimal arrondiResult = result.setScale(6, RoundingMode.HALF_UP);  // Arrondi à 6 décimales
                view.setEcranText(arrondiResult.stripTrailingZeros().toPlainString());
            } catch (NumberFormatException e) {
                view.setEcranText("Erreur");
            }
        });

        view.addClearListener(() -> view.setEcranText(""));

        view.addSigneListener(() -> {
            String currentText = view.getEcranText();
            if (!currentText.isEmpty()) {
                BigDecimal currentValue = new BigDecimal(currentText);
                currentValue = currentValue.negate();  // Inverser le signe
                view.setEcranText(currentValue.stripTrailingZeros().toPlainString());
            }
        });

        view.addEgalListener(() -> {
            BigDecimal secondNb = new BigDecimal(view.getEcranText());

            try {
                BigDecimal result = model.calculer(firstNb, secondNb, operateur);

                // Afficher le résultat sans zéros inutiles
                view.setEcranText(result.stripTrailingZeros().toPlainString());
            } catch (ArithmeticException e) {
                // Gestion des erreurs mathématiques
                view.setEcranText("Erreur");
            }
        });
    }

    // Méthode pour définir l'opérateur et sauvegarder le premier nombre
    private void setOperateur(String operateur) {
        firstNb = new BigDecimal(view.getEcranText());  // Stocker le premier nombre en BigDecimal
        this.operateur = operateur;
        view.setEcranText("");
    }
}
