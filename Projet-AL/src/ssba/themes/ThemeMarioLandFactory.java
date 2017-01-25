package ssba.themes;

import soldier.core.Unit;
import soldier.core.Weapon;
import soldier.weapon.WeaponGun;
import soldier.weapon.WeaponShield;

import ssba.ThemeAbstractFactory;
import ssba.entity.Luigi;
import ssba.entity.Peach;

public class ThemeMarioLandFactory implements ThemeAbstractFactory{
	@Override
	public Unit infantryUnit(String name) {
		//return new UnitRobot(name);
		return new Peach(name);
	}

	@Override
	public Unit riderUnit(String name) {
		//return new UnitBikerMan(name);
		return new Luigi(name);
	}

	@Override
	public Weapon attackWeapon() {
		return new WeaponGun();
	}

	@Override
	public Weapon defenseWeapon() {
		return new WeaponShield();
	}
}
