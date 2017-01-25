package ssba;

import soldier.core.Unit;
import soldier.core.Weapon;

public interface ThemeAbstractFactory {
	Unit infantryUnit(String name);

	Unit riderUnit(String name);

	Weapon attackWeapon();

	Weapon defenseWeapon();
}