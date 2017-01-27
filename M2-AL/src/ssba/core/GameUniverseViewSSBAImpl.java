package ssba.core;

import java.awt.Canvas;

import gameframework.core.BackgroundImage;
import gameframework.core.GameUniverse;
import gameframework.core.GameUniverseViewPortDefaultImpl;

public class GameUniverseViewSSBAImpl extends GameUniverseViewPortDefaultImpl {
	protected BackgroundImage background;

	public GameUniverseViewSSBAImpl(Canvas canvas, GameUniverse universe) {
		super(canvas, universe);
	}

	@Override
	protected String backgroundImage() {
		return "images/sky.png";
	}
}
