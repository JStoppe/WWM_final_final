package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RightPanel;

public class ActionsListenerButton implements ActionListener{

	RightPanel rp;
	int buttonNumber;
	
	public ActionsListenerButton(RightPanel rp, int buttonNumber) {
		this.rp = rp;
		this.buttonNumber = buttonNumber;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(rp.getRightAnswer() == buttonNumber) {
			rp.displayNextQuestion();
		}
	}

}
