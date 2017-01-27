package ssba.entity_creation;

import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public class ArmyFactory {
	public AgeAbstractFactory ageFact;

	public ArmyFactory(){
		ageFact = null;
	}

	public UnitGroup createArmy(String name, int infanteryNumber, int riderNumber){
		UnitGroup units = new UnitGroup(name);
		for (int i = 0; i < infanteryNumber; i++) {
			units.addUnit(ageFact.infantryUnit(name+" Infantery n"+i));
		}
		for (int i = 0; i < riderNumber; i++) {
			units.addUnit(ageFact.riderUnit(name+" Rider n"+i));
		}
		return units;
	}
}