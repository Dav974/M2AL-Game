package ssba.rules;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ActionStrategyDefaultImpl extends KeyAdapter implements ActionStrategy {
	protected static boolean atk = false;
	protected static boolean parry = false;

	private boolean mutex = true;
	
	public ActionStrategyDefaultImpl(){}
	
	public boolean getIsAttacking() {
		return atk;
	}
	public void setAttack(boolean state) {
		this.atk = state;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		if(mutex == true){
			mutex = false;
			int keycode = event.getKeyCode();
			switch (keycode) {
			case KeyEvent.VK_F:
				this.atk = true;
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		this.atk = false;
		mutex = true;
	}
	
	@Override
	public boolean getIsDamaging() {
		return parry;
	}
	
	@Override
	public void setParry(boolean state) {
		this.parry = state;
	}
}
