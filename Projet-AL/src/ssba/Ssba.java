/**
 * @author Nathalie Craeye
 * @author David Lejeune 
 * @date 20/01/2017
 * Ã‰tudiants Master GL
 * UniversitÃ© de Bordeaux
 */
package ssba;

import gameframework.core.GameDefaultImpl;
import gameframework.core.GameLevel;

import java.util.ArrayList;

import soldier.ages.*;
import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.UnitGroup;
import ssba.themes.ThemeMarioLandFactory;
import ssba.themes.ThemePokemonFactory;


public class Ssba {

	public static Unit createTeam(AgeAbstractFactory fact, String prefix)  {
		UnitGroup sg = new UnitGroup(prefix + "Animals");
		UnitGroup bl  = new UnitGroup(prefix + "Worms");
		bl.addUnit(fact.infantryUnit(prefix + "nicky"));
		bl.addUnit(fact.infantryUnit(prefix + "tomy"));
		sg.addUnit(bl);
		bl.addEquipment(fact.attackWeapon());
		bl.addEquipment(fact.defenseWeapon());
		bl.addEquipment(fact.attackWeapon());
		return sg;
	}

	public static Unit createTeam(ThemeAbstractFactory facto, String prefix)  {
		UnitGroup sg = new UnitGroup(prefix + "Animals");
		UnitGroup bl  = new UnitGroup(prefix + "Worms");
		bl.addUnit(facto.infantryUnit(prefix + "nicky"));
		bl.addUnit(facto.infantryUnit(prefix + "tomy"));
		sg.addUnit(bl);
		bl.addEquipment(facto.attackWeapon());
		bl.addEquipment(facto.defenseWeapon());
		bl.addEquipment(facto.attackWeapon());
		return sg;
	}

	public static void main(String[] args) {
		// creer 1 Factory (dont le thème sera choisi par le user)
		AgeAbstractFactory age1 = new AgeMiddleFactory();
		AgeAbstractFactory age2 = new AgeFutureFactory();
		
		ThemeAbstractFactory theme1 = new ThemePokemonFactory();
		ThemeAbstractFactory theme2 = new ThemeMarioLandFactory();

		// creer n (= nb de joueurs) teams (UnitGroup) par la facto : 1
		Unit team1 = createTeam(age1, "Team1::"); 
		Unit team2 = createTeam(age2, "Team2::"); 

		Unit equipe1 = createTeam(theme1, "Team theme 1::"); 
		Unit equipe2 = createTeam(theme2, "Team theme 2::"); 

		ArrayList<Unit> groupesDeJeu = new ArrayList<>();
		groupesDeJeu.add(team1);
		groupesDeJeu.add(team2);
		groupesDeJeu.add(equipe1);
		groupesDeJeu.add(equipe2);

		// préparer le jeu
		GameDefaultImpl g = new GameDefaultImpl();
		
		// préparer les niveaux
		ArrayList<GameLevel> levels = new ArrayList<>();
		levels.add(new LevelOne(g, groupesDeJeu));
		g.setLevels(levels);

		// lancer les niveaux dans l'ordre avec gestion de fin de niveau
		g.start();
	}
}
