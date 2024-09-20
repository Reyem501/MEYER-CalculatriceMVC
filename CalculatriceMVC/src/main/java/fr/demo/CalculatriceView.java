package fr.demo;

import javax.swing.*;
import java.awt.*;

public class CalculatriceView extends JFrame {

    private JTextField ecran;
    private JButton[] chiffres;
    private JButton addition, soustraction, multiplication, division, egal, clear;

    public CalculatriceView() {
        setTitle("MEYER - CalculatriceMVC");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ecran = new JTextField();
        ecran.setHorizontalAlignment(JTextField.RIGHT);
        ecran.setEditable(false);

        chiffres = new JButton[10];
        for (int i = 0; i < 10; i++) {
            chiffres[i] = new JButton(String.valueOf(i));
        }

        addition = new JButton("+");
        soustraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        egal = new JButton("=");
        clear = new JButton("C");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        for (int i = 1; i < 10; i++) {
            panel.add(chiffres[i]);
        }
        panel.add(addition);
        panel.add(soustraction);
        panel.add(multiplication);
        panel.add(division);
        panel.add(chiffres[0]);
        panel.add(egal);
        panel.add(clear);

        this.setLayout(new BorderLayout());
        this.add(ecran, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
    }

    public JTextField getEcran() {
        return ecran;
    }

    public JButton[] getChiffres() {
        return chiffres;
    }

    public JButton getAddition() {
        return addition;
    }

    public JButton getSoustraction() {
        return soustraction;
    }

    public JButton getMultiplication() {
        return multiplication;
    }

    public JButton getDivision() {
        return division;
    }

    public JButton getEgal() {
        return egal;
    }

    public JButton getClear() {
        return clear;
    }
}
