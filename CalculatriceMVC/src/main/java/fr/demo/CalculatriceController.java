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
            double result = switch (operateur) {
                case "+" -> model.addition(firstNb, secondNb);
                case "-" -> model.soustraction(firstNb, secondNb);
                case "*" -> model.multiplication(firstNb, secondNb);
                case "/" -> model.division(firstNb, secondNb);
                default -> 0;
            };

            // Vérification pour afficher un nb entier ou un nb flottant
            if (result == (long) result) {
                view.setEcranText(String.valueOf((long) result));
            } else {
                view.setEcranText(String.valueOf(result));
            }        });

        view.addClearListener(() -> view.setEcranText("")); // Listener du bouton clear
    }

    private void setOperateur(String operateur) {
        firstNb = Double.parseDouble(view.getEcranText());
        this.operateur = operateur;
        view.setEcranText("");
    }
}
