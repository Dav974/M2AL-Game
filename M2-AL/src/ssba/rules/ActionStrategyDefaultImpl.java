package ssba.rules;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ActionStrategyDefaultImpl extends KeyAdapter implements ActionStrategy {
	protected static boolean atk = false;
	protected static boolean parry = false;

	private boolean block = true;
	protected char keyAction;
	public ActionStrategyDefaultImpl(char key){
		this.keyAction = key;
	}

	public boolean getIsAttacking() {
		return this.atk;
	}
	public void setAttack(boolean state) {
		this.atk = state;
	}

	@Override
	public void keyPressed(KeyEvent event){
		if(this.block){
			this.block = false;
			if (event.getKeyChar() == keyAction)
				this.atk = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		this.atk = false;
		this.block = true;
	}
	
	@Override
	public boolean getIsDamaging() {
		return this.parry;
	}
	
	@Override
	public void setParry(boolean state) {
		this.parry = state;
	}
}
