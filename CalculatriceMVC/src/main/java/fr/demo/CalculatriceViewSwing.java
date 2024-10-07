package fr.demo;

import javax.swing.*;
import java.awt.*;

public class CalculatriceViewSwing extends JFrame implements CalculatriceViewInterface {

    private JTextField ecran;
    private JButton[] chiffres;
    private JButton addition, soustraction, multiplication, division, PI, egal, clear, point, signe, puissance, racine, arrondir;

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
            chiffres[i].setFont(new Font("Arial", Font.PLAIN, 20));
        }

        // Création des boutons d'opération
        addition = new JButton("+");
        soustraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        PI = new JButton("π");
        egal = new JButton("=");
        clear = new JButton("C");
        point = new JButton(".");
        signe = new JButton("±");
        puissance = new JButton("^");
        racine = new JButton("√");
        arrondir = new JButton("Arr");

        // Création du JPanel avec un GridLayout 6x4
        JPanel panel = new JPanel(new GridLayout(6, 4, 10, 10));

        // Ajout des boutons dans le panel
        puissance.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(puissance);
        signe.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(signe);
        racine.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(racine);
        division.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(division);

        panel.add(chiffres[7]);
        panel.add(chiffres[8]);
        panel.add(chiffres[9]);
        multiplication.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(multiplication);

        panel.add(chiffres[4]);
        panel.add(chiffres[5]);
        panel.add(chiffres[6]);
        soustraction.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(soustraction);

        panel.add(chiffres[1]);
        panel.add(chiffres[2]);
        panel.add(chiffres[3]);
        addition.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(addition);

        panel.add(chiffres[0]);
        PI.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(PI);
        point.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(point);
        arrondir.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(arrondir);

        clear.setBackground(Color.RED); // bouton clear en rouge
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(clear);

        egal.setBackground(Color.GREEN);    // bouton egal en vert
        egal.setForeground(Color.WHITE);
        egal.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(egal);

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
    public void addPIListener(Runnable listener) {
        PI.addActionListener(e -> listener.run());
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

    @Override
    public void addArrondirListener(Runnable listener) {
        arrondir.addActionListener(e -> listener.run());
    }
}
