package ssba.rule;

import java.awt.Point;
import java.util.Vector;

import pacman.entity.Ghost;
import pacman.entity.TeleportPairOfPoints;
import ssba.entity.Entity;
import gameframework.core.GameUniverse;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;

public class EntityOverlapRules extends OverlapRulesApplierDefaultImpl {

	protected GameUniverse universe;
	protected Vector<Ghost> vGhosts = new Vector<Ghost>();

	protected Point entity1StartPos;
	protected Point entity2StartPos;

	public EntityOverlapRules(Point entity1Pos, Point entity2Pos,
			ObservableValue<Integer> life, ObservableValue<Integer> score,
			ObservableValue<Boolean> endOfGame) {
		entity1StartPos = (Point) entity1Pos.clone();
		entity2StartPos = (Point) entity2Pos.clone();
	}

	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}

	public void overlapRule(Entity e1, Entity e2) {
		System.out.println("JE SUIS LAAAAAA");
		System.out.println(e1.attack());
	}

	public void overlapRule(Entity entity, TeleportPairOfPoints teleport) {
		entity.setPosition(teleport.getDestination());
	}


}
