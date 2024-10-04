package fr.demo;

public class CalculatriceModel {

    private double resultat;

    // Calculer en fonction de l'opérateur
    public double calculer(double a, double b, String operateur) throws ArithmeticException {
        return switch (operateur) {
            case "+" -> addition(a, b);
            case "-" -> soustraction(a, b);
            case "*" -> multiplication(a, b);
            case "/" -> division(a, b);
            case "^" -> puissance(a, b);
            default -> throw new IllegalArgumentException("Opérateur inconnu : " + operateur);
        };
    }

    // Addition
    public double addition(double a, double b) throws ArithmeticException {
        double result = a + b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Erreur : Résultat trop long");
        }
        return result;
    }

    // Soustraction
    public double soustraction(double a, double b) {
        return a - b;
    }

    // Multiplication
    public double multiplication(double a, double b) throws ArithmeticException {
        double result = a * b;

        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Erreur : Résultat trop long");
        }
        return result;
    }

    // Division (avec gestion de la division par zéro)
    public double division(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Erreur : Division par zéro");
        }
        return a / b;
    }

    // Puissance d'un chiffre
    public double puissance(double base, double exposant) {
        double result = Math.pow(base, exposant);

        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Erreur : Résultat trop long");
        }
        return result;
    }

    // Racine d'un chiffre
    public double racine(double a) {
        if (a < 0) {
            throw new ArithmeticException("Erreur : Racine carrée d'un nombre négatif");
        }
        return Math.sqrt(a);
    }


    // Getter pour le résultat
    public double getResultat() {
        return resultat;
    }

    // Setter pour le résultat
    public void setResultat(double resultat) {
        this.resultat = resultat;
    }
}

