package fr.demo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculatriceModel {

    private BigDecimal resultat;
    private final MathContext mathContext = new MathContext(15); // Définir une précision générale

    // Calculer en fonction de l'opérateur
    public BigDecimal calculer(BigDecimal a, BigDecimal b, String operateur) throws ArithmeticException {
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
    public BigDecimal addition(BigDecimal a, BigDecimal b) throws ArithmeticException {
        BigDecimal result = a.add(b, mathContext);
        return checkForOverflow(result);
    }

    // Soustraction
    public BigDecimal soustraction(BigDecimal a, BigDecimal b) {
        return a.subtract(b, mathContext);
    }

    // Multiplication
    public BigDecimal multiplication(BigDecimal a, BigDecimal b) throws ArithmeticException {
        BigDecimal result = a.multiply(b, mathContext);
        return checkForOverflow(result);
    }

    // Division (avec gestion de la division par zéro)
    public BigDecimal division(BigDecimal a, BigDecimal b) throws ArithmeticException {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Erreur : Division par zéro");
        }
        return a.divide(b, 15, RoundingMode.HALF_UP); // Division avec arrondi à 15 décimales
    }

    // Puissance d'un chiffre
    public BigDecimal puissance(BigDecimal base, BigDecimal exposant) {
        return BigDecimal.valueOf(Math.pow(base.doubleValue(), exposant.doubleValue()));
    }

    // Racine d'un chiffre
    public BigDecimal racine(BigDecimal a) {
        if (a.compareTo(BigDecimal.ZERO) < 0) {
            throw new ArithmeticException("Erreur : Racine carrée d'un nombre négatif");
        }
        return BigDecimal.valueOf(Math.sqrt(a.doubleValue()));
    }

    // Vérification d'un dépassement de capacité
    private BigDecimal checkForOverflow(BigDecimal result) throws ArithmeticException {
        if (result.abs().compareTo(new BigDecimal(Double.MAX_VALUE)) > 0) {
            throw new ArithmeticException("Erreur : Résultat trop long");
        }
        return result;
    }

    // Getter pour le résultat
    public BigDecimal getResultat() {
        return resultat;
    }

    // Setter pour le résultat
    public void setResultat(BigDecimal resultat) {
        this.resultat = resultat;
    }
}
