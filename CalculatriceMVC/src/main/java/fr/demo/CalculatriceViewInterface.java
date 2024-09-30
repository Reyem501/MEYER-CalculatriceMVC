package fr.demo;

public interface CalculatriceViewInterface {

    void setEcranText(String text);

    String getEcranText();

    void addChiffreListener(int chiffre, Runnable listener);
    void addOperationListener(String operation, Runnable listener);
    void addEgalListener(Runnable listener);
    void addClearListener(Runnable listener);
}
