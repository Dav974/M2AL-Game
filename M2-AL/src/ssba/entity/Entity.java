package ssba.entity;

import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Movable;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.core.SpriteManagerDefaultImpl;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import observer_util.Observable;
import observer_util.Observer;
import soldier.core.UnitGroup;
import soldier.core.UnitSimple;
import soldier.units.UnitCenturion;
import ssba.rules.GameActionDriver;
import ssba.rules.GameActionDriverDefaultImpl;

public class Entity extends GameMovable implements Drawable, GameEntity,
Overlappable, Movable {
	
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 16;
	protected String spritePath;
	protected UnitGroup unit;
	protected boolean isAttacking = false;
	protected GameActionDriver gameActionDriver;

	public Entity(Canvas defaultCanvas, String spritePath, String unitName, GameActionDriver gameActionDriver) {
		this.spritePath = spritePath;
		this.gameActionDriver = gameActionDriver;
		spriteManager = new SpriteManagerDefaultImpl(spritePath,
				defaultCanvas, RENDERING_SIZE, 6);
		spriteManager.setTypes(
				//
				"right", "left", "up",
				"down",//
				"invulnerable-right", "invulnerable-left", "invulnerable-up",
				"invulnerable-down", //
				"unused", "static", "unused");
	}
	boolean atk;
	public void draw(Graphics g) {
		//setIsAttacking(false);
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();
		atk = gameActionDriver.getAttack();
		if (tmp.getX() == 1) {
			spriteType += "right";
		} else if (tmp.getX() == -1) {
			spriteType += "left";
		} else if (tmp.getY() == 1) {
			spriteType += "down";
		} else if (tmp.getY() == -1) {
			spriteType += "up";
		}
		else {
			spriteType = "static";
			spriteManager.reset();
		}
		if (atk) {
			System.out.println(this.getName()+" "+atk);
			setIsAttacking(true);
			gameActionDriver.finishAttack();
		}

		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());

	}
	
	public boolean getIsAttacking(){
		return isAttacking;
	}
	
	public void setIsAttacking(boolean b){
		isAttacking = b;
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
		return (new Rectangle(0, 0, RENDERING_SIZE, RENDERING_SIZE));
	}


	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}

/*	@Override
	public void addObserver(Observer<Entity> ob) {
		this.addObserver(ob);
	}

	@Override
	public void removeObserver(Observer<Entity> ob) {
		if(this.getHealth() >= 0){
			this.removeObserver(ob);
		}
	}

	@Override
	public void notifyObservers(Entity s) {
	}*/
}
