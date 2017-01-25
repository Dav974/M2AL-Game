package ssba.entity;

import soldier.core.BreakingRuleException;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;
import soldier.units.BehaviorSoldierHealthBased;

public class Peach extends UnitInfantry {
	String pathSprite = "images/ghost.gif";

	public Peach(String soldierName) {
		super(soldierName, new BehaviorSoldierHealthBased(100, 50));
	}
	
	public String getPathSprite() {
		return pathSprite;
	}

	/**
	 * Princess Peach can have at most four equipments
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons()>3) throw new BreakingRuleException();
		super.addEquipment(w);
	}

}
