/*
package fr.demo;

public class Main {
    public static void main(String[] args) {

        CalculatriceModel model = new CalculatriceModel();
        CalculatriceViewSwing view = new CalculatriceViewSwing();
        CalculatriceController controller = new CalculatriceController(model, view);
        view.setVisible(true);
    }
}
*/

package fr.demo;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        Application.launch(CalculatriceViewJavaFX.class, args);
    }
}
