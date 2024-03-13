import javax.swing.UIManager;

import gui.AlistamentoGUI;

public class AlistamentoApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AlistamentoGUI().setVisible(true);
    }
}
