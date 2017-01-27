/**
 * @author Nathalie Craeye
 * @author David Lejeune 
 * @date 20/01/2017
 * Étudiants Master GL
 * Université de Bordeaux
 */
package ssba;

import gameframework.core.GameLevel;

import java.util.ArrayList;

import ssba.core.GameSSBAImpl;


public class Main {

	public static void main(String[] args) {
		GameSSBAImpl g = new GameSSBAImpl();
		ArrayList<GameLevel> levels = new ArrayList<>();

		levels.add(new LevelOne(g)); // only one level is available
		
		g.setLevels(levels);
		g.start();

	}

}
