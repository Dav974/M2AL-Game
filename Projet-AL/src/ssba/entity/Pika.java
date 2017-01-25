package ssba.entity;

import soldier.core.BreakingRuleException;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;
import soldier.units.BehaviorSoldierHealthBased;

public class Pika extends UnitInfantry {
	String pathSprite = "images/pac2.gif";
	
	public Pika(String soldierName) {
		super(soldierName, new BehaviorSoldierHealthBased(100, 100));
	}
	
	public String getPathSprite() {
		return pathSprite;
	}

	/**
	 * Pika can have at most four equipments
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons()>3) throw new BreakingRuleException();
		super.addEquipment(w);
	}

}
