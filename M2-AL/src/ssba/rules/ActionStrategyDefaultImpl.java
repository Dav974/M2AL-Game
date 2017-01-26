package ssba.rules;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ActionStrategyDefaultImpl extends KeyAdapter implements ActionStrategy {
	protected static boolean atk = false;
	private boolean mutex = true;
	public ActionStrategyDefaultImpl(){
	}
	public boolean getIsAttacking() {
		return atk;
	}
	public void setAttack() {
		this.atk = false;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		if(mutex == true){
			mutex = false;
			int keycode = event.getKeyCode();
			switch (keycode) {
			case KeyEvent.VK_F:
				atk = true;
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		atk = false;
		mutex = true;
	}
}
