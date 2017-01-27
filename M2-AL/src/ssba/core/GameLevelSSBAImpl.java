package ssba.core;

import java.util.Date;

import gameframework.core.Game;
import gameframework.core.GameLevel;
import gameframework.core.GameUniverse;
import gameframework.core.GameUniverseViewPort;
import gameframework.core.ObservableValue;

public abstract class GameLevelSSBAImpl extends Thread implements GameLevel {
	private static final int MINIMUM_DELAY_BETWEEN_GAME_CYCLES = 100;

	protected final Game g;
	protected GameUniverse universe;
	protected GameUniverseViewPort gameBoard;

	protected ObservableValue<Integer> score[];
	protected ObservableValue<Integer> life[];
	protected ObservableValue<Boolean> endOfGame;

	boolean stopGameLoop;

	protected abstract void init();

	public GameLevelSSBAImpl(Game g) {
		this.g = g;
		this.score = g.score();
		this.life = g.life();
	}

	// start of class Thread which calls the run method (see below) 
	@Override
	public void start() {  
		endOfGame = g.endOfGame();
		init();
		super.start();
		try {
			super.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		stopGameLoop = false;
		// main game loop 
		long start;
		while (!stopGameLoop && !this.isInterrupted()) {
			start = new Date().getTime();
			gameBoard.paint();
			universe.allOneStepMoves();
			universe.processAllOverlaps();
			try {
				long sleepTime = MINIMUM_DELAY_BETWEEN_GAME_CYCLES
						- (new Date().getTime() - start);
				if (sleepTime > 0) {
					Thread.sleep(sleepTime);
				}
			} catch (Exception e) {
			}
		}
	}

	public void end() {
		stopGameLoop = true;
	}

	protected void overlap_handler() {
	}

}
