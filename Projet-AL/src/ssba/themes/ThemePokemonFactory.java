package ssba.themes;

import soldier.core.Unit;
import soldier.core.Weapon;
import soldier.weapon.WeaponGun;
import soldier.weapon.WeaponShield;

import ssba.ThemeAbstractFactory;
import ssba.entity.Pika;
import ssba.entity.Rondoudou;

public class ThemePokemonFactory implements ThemeAbstractFactory{

	@Override
	public Unit infantryUnit(String name) {
		return new Pika(name);
	}

	@Override
	public Unit riderUnit(String name) {
		return new Rondoudou(name);	
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
