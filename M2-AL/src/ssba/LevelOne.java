package ssba;

import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.MoveStrategyKeyboard;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;

import java.awt.Canvas;
import java.awt.Point;

import pacman.entity.Jail;
import pacman.entity.SuperPacgum;
import pacman.entity.TeleportPairOfPoints;
import pacman.entity.Wall;
import pacman.rule.PacmanMoveBlockers;
import ssba.core.GameLevelSSBAImpl;
import ssba.core.GameUniverseViewSSBAImpl;
import ssba.entity.Entity;
import ssba.rule.entity.EntityMoveStrategyKeyboard;
import ssba.rule.entity.EntityOverlapRules;
import ssba.rules.ActionStrategyDefaultImpl;
import ssba.rules.GameActionDriverDefaultImpl;

public class LevelOne extends GameLevelSSBAImpl {
	Canvas canvas;

	// 0 : Pacgums; 1 : Walls; 2 : SuperPacgums; 3 : Doors; 4 : Jail; 5 : empty
	// Note: teleportation points are not indicated since they are defined by
	// directed pairs of positions.
	static int[][] tab = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public static final int SPRITE_SIZE = 16;

	@Override
	protected void init() {
		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();

		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		moveBlockerChecker.setMoveBlockerRules(new PacmanMoveBlockers());

		EntityOverlapRules overlapRules = new EntityOverlapRules(new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE),
				new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE), life[0], score[0], endOfGame);
		overlapProcessor.setOverlapRules(overlapRules);

		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);

		overlapRules.setUniverse(universe);

		gameBoard = new GameUniverseViewSSBAImpl(canvas, universe);

		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);

		@SuppressWarnings("unused")
		int totalNbGums = 0;

		// Filling up the universe with basic non movable entities and inclusion in the universe
		for (int i = 0; i < 31; ++i) {
			for (int j = 0; j < 28; ++j) {
				if (tab[i][j] == 1) {
					universe.addGameEntity(new Wall(canvas, j * SPRITE_SIZE, i * SPRITE_SIZE));
				}
				if (tab[i][j] == 2) {
					universe.addGameEntity(new SuperPacgum(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
					totalNbGums++;
				}
				if (tab[i][j] == 4) {
					universe.addGameEntity(new Jail(new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				}
			}
		}

		// Two teleport points definition and inclusion in the universe
		// (west side to east side)
		universe.addGameEntity(new TeleportPairOfPoints(new Point(0 * SPRITE_SIZE, 14 * SPRITE_SIZE), new Point(
				25 * SPRITE_SIZE, 14 * SPRITE_SIZE)));
		// (east side to west side)
		universe.addGameEntity(new TeleportPairOfPoints(new Point(27 * SPRITE_SIZE, 14 * SPRITE_SIZE), new Point(
				2 * SPRITE_SIZE, 14 * SPRITE_SIZE)));


		GameMovableDriverDefaultImpl moveDriver1 = new GameMovableDriverDefaultImpl();
		GameActionDriverDefaultImpl actionDriver1 = new GameActionDriverDefaultImpl('e');
		GameMovableDriverDefaultImpl moveDriver2 = new GameMovableDriverDefaultImpl();
		GameActionDriverDefaultImpl actionDriver2 = new GameActionDriverDefaultImpl('i');


		// Entity 1 definition and inclusion in the universe

		EntityMoveStrategyKeyboard moveKey1 = new EntityMoveStrategyKeyboard();
		ActionStrategyDefaultImpl actionKeyAct1 = actionDriver1.getActionStrategy();

		moveDriver1.setStrategy(moveKey1);
		moveDriver1.setmoveBlockerChecker(moveBlockerChecker);
		actionDriver1.setStrategy(actionKeyAct1);
		canvas.addKeyListener(moveKey1);
		canvas.addKeyListener(actionKeyAct1);


		// Entity 2 definition and inclusion in the universe

		MoveStrategyKeyboard moveKeyStr2 = new MoveStrategyKeyboard();
		ActionStrategyDefaultImpl actionKeyAct2 = actionDriver2.getActionStrategy();

		moveDriver2.setStrategy(moveKeyStr2);
		moveDriver2.setmoveBlockerChecker(moveBlockerChecker);
		//actionDriver2.setStrategy(actionKeyAct2);
		canvas.addKeyListener(moveKeyStr2);
		canvas.addKeyListener(actionKeyAct2);

		// Entities creations
		Entity Pikachu = new Entity(canvas, "images/pac1.gif", "Bob", actionDriver1);
		Entity Link = new Entity(canvas, "images/ghost.gif", "Mar", actionDriver2);

		Pikachu.setDriver(moveDriver1);
		Pikachu.setPosition(new Point(6 * SPRITE_SIZE, 10 * SPRITE_SIZE));
		universe.addGameEntity(Pikachu);

		Link.setDriver(moveDriver2);
		Link.setPosition(new Point(18 * SPRITE_SIZE, 10 * SPRITE_SIZE));
		universe.addGameEntity(Link);
	}

	public LevelOne(Game g) {
		super(g);
		canvas = g.getCanvas();
	}

}
