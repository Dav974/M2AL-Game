package ssba.rule.entity;

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
	//règle de retrait des pv si collision
	public void overlapRule(Entity e1, Entity e2) {
		System.out.println("FIGHT !");
		System.out.println("PV J2: "+e2.getHealth());
		System.out.println("ATK J1: "+e1.attack());
		e2.parry(e1.attack());
		System.out.println("PV J2: "+e2.getHealth());
		System.out.println("PV J1: "+e1.getHealth());
		checkAlive(e2);
	}
	
	public void checkAlive(Entity e){
		if(e.getHealth() <= 0){
			universe.removeGameEntity(e);
		}
	}
	
	public void overlapRule(Entity entity, TeleportPairOfPoints teleport) {
		entity.setPosition(teleport.getDestination());
	}


}
