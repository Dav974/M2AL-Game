package ssba.entity;

import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.core.SpriteManagerDefaultImpl;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import soldier.core.UnitSimple;
import soldier.units.UnitCenturion;

public class Entity extends GameMovable implements Drawable, GameEntity,
Overlappable{
	
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 16;
	protected String spritePath;
	UnitSimple unit;
	
	public Entity(Canvas defaultCanvas, String spritePath) {
		this.spritePath = spritePath;
		unit = new UnitCenturion("bob");
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

	public void draw(Graphics g) {
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();

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
		}
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());

	}

	public float attack(){
		return unit.strike();
	}
	
	public Rectangle getBoundingBox() {
		return (new Rectangle(0, 0, RENDERING_SIZE, RENDERING_SIZE));
	}


	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}
}
