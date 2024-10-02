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
            default -> throw new IllegalArgumentException("Opérateur inconnu : " + operateur);
        };
    }

    // Addition
    public double addition(double a, double b) {
        return a + b;
    }

    // Soustraction
    public double soustraction(double a, double b) {
        return a - b;
    }

    // Multiplication
    public double multiplication(double a, double b) {
        return a * b;
    }

    // Division (avec gestion de la division par zéro)
    public double division(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Erreur : Division par zéro");
        }
        return a / b;
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

