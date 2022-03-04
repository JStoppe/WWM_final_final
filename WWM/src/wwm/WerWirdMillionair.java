package wwm;

import java.awt.EventQueue;
import view.MainFrame;

public class WerWirdMillionair {

	public static void main(String[] args) {		

        EventQueue.invokeLater(() -> {
            new MainFrame().createAndShowGUI();
        });
	}
}
