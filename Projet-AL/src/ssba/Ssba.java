/**
 * @author Nathalie Craeye
 * @author David Lejeune 
 * @date 20/01/2017
 * Étudiants Master GL
 * Université de Bordeaux
 */
package ssba;

import gameframework.core.GameDefaultImpl;
import gameframework.core.GameLevel;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.moves_rules.MoveStrategyKeyboard;

import java.util.ArrayList;

import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.UnitGroup;


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

	public static void main(String[] args) {
		// creer 1 Factory (dont le thème est choisi par le user)
				AgeAbstractFactory age1 = new AgeMiddleFactory();
		
		// creer n team (UnitGroup) par la facto (nb de joueurs) : 1
				Unit team1 = createTeam(age1, "Team1::"); 
		
		// creer n uplet de control keys (GameMovableDriver-MoveStrategyKeyboard) : 1
//				GameMovableDriverDefaultImpl driver = new GameMovableDriverDefaultImpl();
//				MoveStrategyKeyboard keyStr = new MoveStrategyKeyboard();
		
		// relier le uplet à une team : MyGameEntityMovable implements Drawable, GameEntity, Overlappable = Unit var + GameMovable var
		// non abstrait car pour l'instant on a tous la mm façon de marcher : oneStepMoveAddedBehavior ?
//				MyGameEntityMovable pokemonS = new MyGameEntityMovable(team1, driver, keyStr);
//				ArrayList<MyGameEntityMovable> groupesDeJeu = new ArrayList<>();
//				groupesDeJeu.add(pokemonS);
				
				ArrayList<Unit> groupesDeJeu = new ArrayList<>();
				groupesDeJeu.add(team1);

		// préparer le jeu
		GameDefaultImpl g = new GameDefaultImpl();		
		// préparer les niveaux
		ArrayList<GameLevel> levels = new ArrayList<>();
		
		levels.add(new LevelOne(g, groupesDeJeu)); //param nb de ?(Unit, MGEM, ) à fabriquer
		g.setLevels(levels);
		
		// lancer les niveaux dans l'ordre avec gestion de fin de niveau
		g.start();
	}

}
