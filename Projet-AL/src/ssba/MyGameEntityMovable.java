package ssba;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import soldier.core.Unit;
import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.core.SpriteManagerDefaultImpl;
import gameframework.moves_rules.MoveStrategyKeyboard;

public class MyGameEntityMovable extends GameMovable implements Drawable, GameEntity, Overlappable {
	Unit _team;
	public Unit get_team() {
		return _team;
	}

	public void set_team(Unit _team) {
		this._team = _team;
	}

//	GameMovableDriverDefaultImpl _driver;
//	MoveStrategyKeyboard _moveStrategy;

	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 16;
	protected boolean movable = true;
	protected boolean vulnerable = false;
	protected int vulnerableTimer = 0;


	/**
	 * @param team
	 * @param driver
	 * @param moveStrategy
	 */
	// TODO gestion des sprites
	public MyGameEntityMovable(Canvas defaultCanvas, Unit team/*, GameMovableDriverDefaultImpl driver,
			MoveStrategyKeyboard moveStrategy*/) {
		this._team = team;
		
//		this._driver = driver;
//		this._moveStrategy = moveStrategy;
		
		spriteManager = new SpriteManagerDefaultImpl("images/ghost.gif",
				defaultCanvas, RENDERING_SIZE, 6);
		spriteManager.setTypes(
				//
				"right", "left", "up",
				"down",//
				"invulnerable-right", "invulnerable-left", "invulnerable-up",
				"invulnerable-down", //
				"unused", "static", "unused");
		System.out.println("mgemju");
	}

	
	@Override
	public Rectangle getBoundingBox() {
		// TODO Auto-generated method stub
		return (new Rectangle(0, 0, RENDERING_SIZE, RENDERING_SIZE));
	}


	private boolean isVulnerable() {
		return (vulnerableTimer <= 0);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();
		movable = true;
		if (!isVulnerable()) {
			spriteType += "invulnerable-";
		}

		if (tmp.getX() == 1) {
			spriteType += "right";
		} else if (tmp.getX() == -1) {
			spriteType += "left";
		} else if (tmp.getY() == 1) {
			spriteType += "down";
		} else if (tmp.getY() == -1) {
			spriteType += "up";
		} else {
			spriteType = "static";
			spriteManager.reset();
			movable = false;
		}
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());
	}


	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		if (movable) {
			spriteManager.increment();
			if (!isVulnerable()) {
				vulnerableTimer--;
			}
		}

	}

}
