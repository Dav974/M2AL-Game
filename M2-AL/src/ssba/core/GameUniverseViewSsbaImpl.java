package ssba.core;

import java.awt.Canvas;

import gameframework.core.BackgroundImage;
import gameframework.core.GameUniverse;
import gameframework.core.GameUniverseViewPortDefaultImpl;

public class GameUniverseViewSsbaImpl extends GameUniverseViewPortDefaultImpl {
	protected BackgroundImage background;

	public GameUniverseViewSsbaImpl(Canvas canvas, GameUniverse universe) {
		super(canvas, universe);
	}

	@Override
	protected String backgroundImage() {
		return "images/sky.png";
	}
}
