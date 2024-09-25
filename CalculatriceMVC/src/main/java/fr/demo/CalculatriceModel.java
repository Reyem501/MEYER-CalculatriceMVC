package fr.demo;

public class CalculatriceModel {

    private double resultat;

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

    // Division
    public double division(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Erreur : Division par zéro"); // Vérification de la division par 0
        }
        return a / b;
    }

    // Getter
    public double getResultat() {
        return resultat;
    }

    // Setter
    public void setResultat(double resultat) {
        this.resultat = resultat;
    }
}
