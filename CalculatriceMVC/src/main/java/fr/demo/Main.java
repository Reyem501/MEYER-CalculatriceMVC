package fr.demo;

public class Main {
    public static void main(String[] args) {

        CalculatriceModel model = new CalculatriceModel();
        CalculatriceView view = new CalculatriceView();
        CalculatriceController controller = new CalculatriceController(model, view);
        view.setVisible(true);
    }
}
