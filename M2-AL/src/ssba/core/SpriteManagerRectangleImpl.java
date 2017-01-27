package ssba.core;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import gameframework.core.DrawableImage;
import gameframework.core.SpriteManager;

/**
 * This implementation of {@link SpriteManager} assumes that sprite types are in
 * rows whereas increments of a type are in columns
 * 
 */
public class SpriteManagerRectangleImpl implements SpriteManager {

	private final DrawableImage image;
	private Map<String, Integer> types;
	private final int spriteSizeWidth;
	private final int spriteSizeHeight;
	private int spriteNumber = 0;
	private final int maxSpriteNumber;
	@SuppressWarnings("unused")
	private final int maxTypeNumber;

	private int currentRow;
	private final int renderingSizeWidth;
	private final int renderingSizeHeight;

	public SpriteManagerRectangleImpl(String filename, Canvas canvas,
			int renderingSizeWidth, int renderingSizeHeight, int maxSpriteNumber, int maxTypeNumber) {
		this.renderingSizeWidth = renderingSizeWidth;
		this.renderingSizeHeight = renderingSizeHeight;
		image = new DrawableImage(filename, canvas);
		this.maxSpriteNumber = maxSpriteNumber;
		this.maxTypeNumber = maxTypeNumber;
		this.spriteSizeWidth = image.getImage().getWidth(null) / maxSpriteNumber;
		this.spriteSizeHeight = image.getImage().getHeight(null) / maxTypeNumber;
	}

	@Override
	public void setTypes(String... types) {
		int i = 0;
		this.types = new HashMap<String, Integer>(types.length);
		for (String type : types) {
			this.types.put(type, i);
			i++;
		}
	}

	@Override
	public void draw(Graphics g, Point position) {
		// Destination image coordinates
		int dx1 = (int) position.getX();
		int dy1 = (int) position.getY();
		int dx2 = dx1 + renderingSizeWidth;
		int dy2 = dy1 + renderingSizeHeight;

		// Source image coordinates
		int sx1 = spriteNumber * spriteSizeWidth;
		int sy1 = currentRow * spriteSizeHeight;
		int sx2 = sx1 + spriteSizeWidth;
		int sy2 = sy1 + spriteSizeHeight;
		g.drawImage(image.getImage(), dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,
				null);
	}

	@Override
	public void setType(String type) {
		if (!types.containsKey(type)) {
			throw new IllegalArgumentException(type
					+ " is not a valid type for this sprite manager.");
		}
		this.currentRow = types.get(type);
	}

	@Override
	public void increment() {
		spriteNumber = (spriteNumber + 1) % maxSpriteNumber;
	}

	@Override
	public void reset() {
		spriteNumber = 0;
	}

	@Override
	public void setIncrement(int increment) {
		this.spriteNumber = increment;
	}
}
