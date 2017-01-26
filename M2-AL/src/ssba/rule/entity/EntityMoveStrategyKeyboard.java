package ssba.rule.entity;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import gameframework.moves_rules.MoveStrategy;
import gameframework.moves_rules.SpeedVector;
import gameframework.moves_rules.SpeedVectorDefaultImpl;

/**
 * {@link MoveStrategy} which listens to the keyboard and answers new
 * {@link SpeedVector speed vectors} based on what the user typed.
 */
public class EntityMoveStrategyKeyboard extends KeyAdapter implements MoveStrategy {
	protected SpeedVector speedVector = new SpeedVectorDefaultImpl(new Point(0,
			0));
	protected boolean isAttacking = false;

	public SpeedVector getSpeedVector() {
		return speedVector;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int keycode = event.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_D: // droite
			speedVector.setDirection(new Point(1, 0));
			break;
		case KeyEvent.VK_Q: // gauche
			speedVector.setDirection(new Point(-1, 0));
			break;
		case KeyEvent.VK_Z: // haut
			speedVector.setDirection(new Point(0, -1));
			break;
		case KeyEvent.VK_S: // bas
			speedVector.setDirection(new Point(0, 1));
			break;
		case KeyEvent.VK_F:
			isAttacking = true;
			break;
		}
	}

}