package wwm;

import java.awt.EventQueue;

import view.MainFrame;
//import wwm.GUI;
//import view.MyFrame;


public class WerWirdMillionair {

	public static void main(String[] args) {		
//		new GUI();
//		new MyFrame();	
		
        EventQueue.invokeLater(() -> {
            new MainFrame().createAndShowGUI();
        });
	}
}
