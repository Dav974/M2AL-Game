package ssba.rule.entity;

import java.awt.Point;

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
		if(e2.getIsAttacking() == true){			
			System.out.println("e2 : "+e2.getIsAttacking());
			battle(e2,e1);
		}
		if(e1.getIsAttacking() == true){			
			System.out.println("e1 : "+e1.getIsAttacking());
			battle(e1,e2);
		}

	}
	
	public void battle(Entity e1, Entity e2){
		System.out.println(e1.getName()+" is attacking and make "+e1.attack()+" dmg");
		e2.parry(e1.attack());
		System.out.println(e2.getName()+" have hp : "+e2.getHealth());
		System.out.println();
		checkAlive(e2);
		e1.setIsAttacking(false);
	}
	
	public void checkAlive(Entity e){
		if(e.getHealth() <= 0){
			System.out.println(e.getName()+" is dead, RIP (noob)");
			universe.removeGameEntity(e);
		}
	}
	
	public void overlapRule(Entity entity, TeleportPairOfPoints teleport) {
		entity.setPosition(teleport.getDestination());
	}


}
