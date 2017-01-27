package ssba.rules;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ActionStrategyDefaultImpl extends KeyAdapter implements ActionStrategy {
	protected static boolean atk = false;
	private boolean block = true;
	protected char keyAction;
	public ActionStrategyDefaultImpl(char key){
		keyAction = key;
	}
	
	public boolean getIsAttacking() {
		return atk;
	}
	public void setAttack() {
		atk = false;
	}
	
	@Override
	public void keyPressed(KeyEvent event){
		if(block == true){
			block = false;
			if (event.getKeyChar() == keyAction)
				atk = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		atk = false;
		block = true;
	}
}
