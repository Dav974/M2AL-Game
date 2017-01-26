package ssba.entity;

import soldier.core.BreakingRuleException;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;
import soldier.units.BehaviorSoldierHealthBased;

public class Luigi extends UnitInfantry{
	String pathSprite = "images/luigi_sprites.png";

	public Luigi(String soldierName) {
		super(soldierName, new BehaviorSoldierHealthBased(50, 100));
	}
	
	public String getPathSprite() {
		System.out.println("getPathSprite of Luigi");
		return pathSprite;
	}

	/**
	 * Luigi can have at most four equipments
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons()>3) throw new BreakingRuleException();
		super.addEquipment(w);
	}

}
