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

        // Listener du bouton =
        view.addEgalListener(() -> {
            double secondNb = Double.parseDouble(view.getEcranText());

            try {
                double result = model.calculer(firstNb, secondNb, operateur);

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

        view.addClearListener(() -> view.setEcranText("")); // Listener du bouton clear
    }

    private void setOperateur(String operateur) {
        firstNb = Double.parseDouble(view.getEcranText());
        this.operateur = operateur;
        view.setEcranText("");
    }
}
