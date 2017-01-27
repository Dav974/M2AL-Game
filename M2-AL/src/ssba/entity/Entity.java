package ssba.entity;

import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Movable;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import soldier.core.UnitSimple;
import soldier.units.UnitCenturion;
import ssba.core.SpriteManagerRectangleImpl;
import ssba.rules.GameActionDriver;
import ssba.rules.GameActionDriverDefaultImpl;

public class Entity extends GameMovable implements Drawable, GameEntity,
Overlappable, Movable {
	public final static int MAX_SPRITE_NUMBER = 6;
	public final static int MAX_TYPE_NUMBER = 6;

	protected final SpriteManager spriteManager;
	public static int RENDERING_SIZE_WIDTH;
	public static int RENDERING_SIZE_HEIGHT;

	protected String spritePath;
	protected UnitSimple unit;
	public static boolean isAttacking = false;
	public static boolean isDamaging = false;

	GameActionDriver actionDriver = new GameActionDriverDefaultImpl();

	public Entity(Canvas defaultCanvas, String spritePath, int renderingSizeWidth, int renderingSizeHeight) {
		this.spritePath = spritePath;
		unit = new UnitCenturion("bob");

		RENDERING_SIZE_WIDTH = renderingSizeWidth;
		RENDERING_SIZE_HEIGHT = renderingSizeHeight;
		spriteManager = new SpriteManagerRectangleImpl(spritePath,
				defaultCanvas, RENDERING_SIZE_WIDTH, RENDERING_SIZE_HEIGHT, MAX_SPRITE_NUMBER, MAX_TYPE_NUMBER);
		spriteManager.setTypes(
				"right", 
				"left", 
				"static", 
				"attack",
				"damage",
				"jump");
	}

	public void draw(Graphics g) {
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();
		boolean atk = actionDriver.getAttack();
		boolean par = actionDriver.getParry();

		if (tmp.getX() == 1) {
			spriteType += "right";
		} else if (tmp.getX() == -1) {
			spriteType += "left";
		} else if (tmp.getY() == 1) {
			//spriteType += "down";
			spriteType += "static";
		} else if (tmp.getY() == -1) {
			//spriteType += "up";
			spriteType += "jump";
		}
		else {
			spriteType = "static";
		}
		if (atk) {
			spriteType = "attack";
			setIsAttacking(true);
			actionDriver.finishAttack();
		}
		else if (par) {
			spriteType = "damage";
			setIsDamaging(true);
			System.out.println("entity : "+getIsDamaging());
			actionDriver.finishParry();			
		}
		spriteManager.reset();
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());

	}

	public boolean getIsAttacking(){
		return isAttacking;
	}

	public void setIsAttacking(boolean b){
		isAttacking = b;
	}

	public boolean getIsDamaging(){
		return isDamaging;
	}

	public void setIsDamaging(boolean b){
		isDamaging = b;
	}

	public float attack(){
		return unit.strike();
	}

	public float getHealth(){
		return unit.getHealthPoints();
	}

	public void parry(float dmg){
		unit.parry(dmg);
	}

	public String getName(){
		return unit.getName();
	}

	public Rectangle getBoundingBox() {
		return (new Rectangle(0, 0, RENDERING_SIZE_WIDTH, RENDERING_SIZE_HEIGHT));
	}


	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
	}
}
