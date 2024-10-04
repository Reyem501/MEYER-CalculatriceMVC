package fr.demo;

import javax.swing.*;
import java.awt.*;

public class CalculatriceViewSwing extends JFrame implements CalculatriceViewInterface {

    private JTextField ecran;
    private JButton[] chiffres;
    private JButton addition, soustraction, multiplication, division, egal, clear, point, signe, puissance, racine;

    // Construction de la view Swing
    public CalculatriceViewSwing() {
        setTitle("MEYER - CalculatriceMVC avec Swing");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ecran = new JTextField();
        ecran.setEditable(false);
        ecran.setFont(new Font("Arial", Font.BOLD, 30));
        ecran.setPreferredSize(new Dimension(400, 80));

        // Création des boutons de chiffre
        chiffres = new JButton[10];
        for (int i = 0; i < 10; i++) {
            chiffres[i] = new JButton(String.valueOf(i));
        }

        // Création des boutons d'opération
        addition = new JButton("+");
        soustraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        egal = new JButton("=");
        clear = new JButton("C");
        point = new JButton(".");
        signe = new JButton("±");
        puissance = new JButton("^");
        racine = new JButton("√");


        // Création du JPanel
        JPanel panel = new JPanel(new GridLayout(5, 4, 10, 10));
        for (int i = 1; i < 10; i++) {
            panel.add(chiffres[i]);
        }

        panel.add(addition);
        panel.add(soustraction);
        panel.add(multiplication);
        panel.add(division);
        panel.add(chiffres[0]);
        panel.add(signe);
        panel.add(egal);
        panel.add(clear);
        panel.add(point);
        panel.add(puissance);
        panel.add(racine);


        this.setLayout(new BorderLayout());
        this.add(ecran, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void setEcranText(String text) {
        ecran.setText(text);
    }

    @Override
    public String getEcranText() {
        return ecran.getText();
    }

    @Override
    public void addChiffreListener(int chiffre, Runnable listener) {
        chiffres[chiffre].addActionListener(e -> listener.run());
    }

    @Override
    public void addOperationListener(String operation, Runnable listener) {
        switch (operation) {
            case "+":
                addition.addActionListener(e -> listener.run());
                break;
            case "-":
                soustraction.addActionListener(e -> listener.run());
                break;
            case "*":
                multiplication.addActionListener(e -> listener.run());
                break;
            case "/":
                division.addActionListener(e -> listener.run());
                break;
            case "^":
                puissance.addActionListener(e -> listener.run());
                break;
            case "√":
                racine.addActionListener(e -> listener.run());
                break;
        }
    }


    @Override
    public void addEgalListener(Runnable listener) {
        egal.addActionListener(e -> listener.run());
    }

    @Override
    public void addClearListener(Runnable listener) {
        clear.addActionListener(e -> listener.run());
    }

    @Override
    public void addPointListener(Runnable listener) {
        point.addActionListener(e -> listener.run());
    }

    @Override
    public void addSigneListener(Runnable listener) {
        signe.addActionListener(e -> listener.run());
    }
}
