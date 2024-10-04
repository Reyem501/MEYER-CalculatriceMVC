package fr.demo;

public class CalculatriceController {

    private final CalculatriceViewInterface view;
    private String operateur = "";
    private double firstNb = 0;

    public CalculatriceController(CalculatriceModel model, CalculatriceViewInterface view) {

        this.view = view;

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
            double number = Double.parseDouble(view.getEcranText());
            try {
                double result = model.racine(number);

                // Arrondir le résultat à 2 décimales
                result = Math.round(result * 1_000_000.0) / 1_000_000.0;

                // Vérification pour afficher un nb entier ou un nb flottant
                if (result == (long) result) {
                    view.setEcranText(String.valueOf((long) result));
                } else {
                    view.setEcranText(String.valueOf(result));
                }
            } catch (ArithmeticException e) {
                // Gestion racine d'un nombre négatif)
                view.setEcranText("Erreur : racine d'un nombre négatif");
            }
        });
        view.addEgalListener(() -> {
            double secondNb = Double.parseDouble(view.getEcranText());

            try {
                double result = model.calculer(firstNb, secondNb, operateur);

                // Arrondir le résultat à 2 décimales
                result = Math.round(result * 100.0) / 100.0;

                // Vérification pour afficher un nb entier ou un nb flottant
                if (result == (long) result) {
                    view.setEcranText(String.valueOf((long) result));
                } else {
                    view.setEcranText(String.valueOf(result));
                }
            } catch (ArithmeticException e) {
                // Gestion erreurs mathématiques
                view.setEcranText("Erreur");
            }
        });
        view.addClearListener(() -> view.setEcranText(""));
        view.addSigneListener(() -> {
            String currentText = view.getEcranText();
            if (!currentText.isEmpty()) {
                double currentValue = Double.parseDouble(currentText);
                currentValue *= -1;  // Permet d'inverser le signe
                view.setEcranText(String.valueOf(currentValue));
            }
        });
    }

    private void setOperateur(String operateur) {
        firstNb = Double.parseDouble(view.getEcranText());
        this.operateur = operateur;
        view.setEcranText("");
    }
}
