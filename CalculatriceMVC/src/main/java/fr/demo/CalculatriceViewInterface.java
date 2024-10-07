package fr.demo;

public interface CalculatriceViewInterface {

    void setEcranText(String text);

    String getEcranText();

    void addChiffreListener(int chiffre, Runnable listener);
    void addOperationListener(String operation, Runnable listener);
    void addPIListener(Runnable listener);
    void addEgalListener(Runnable listener);
    void addClearListener(Runnable listener);
    void addPointListener(Runnable listener);
    void addSigneListener(Runnable listener);
    void addArrondirListener(Runnable listener);
}
