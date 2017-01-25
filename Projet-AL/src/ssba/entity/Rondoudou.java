package ssba.entity;

import soldier.core.BreakingRuleException;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;
import soldier.units.BehaviorSoldierHealthBased;

public class Rondoudou extends UnitInfantry {
	String pathSprite = "images/jygglypuff_sprites.png";

	public Rondoudou(String soldierName) {
		super(soldierName, new BehaviorSoldierHealthBased(50, 100));
	}
	
	public String getPathSprite() {
		return pathSprite;
	}

	/**
	 * Rondoudou can have at most four equipments
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons()>3) throw new BreakingRuleException();
		super.addEquipment(w);
	}

}
