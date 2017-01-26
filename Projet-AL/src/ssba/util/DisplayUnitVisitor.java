package ssba.util;

import soldier.core.UnitGroup;
import soldier.core.UnitInfantry;
import soldier.core.UnitRider;
import soldier.core.UnitVisitor;

/**
 * Display unit entities
 * @author Nathalie
 *
 */
public class DisplayUnitVisitor implements UnitVisitor{

	@Override
	public void visit(UnitGroup g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnitRider ur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnitInfantry ui) {
		// TODO Auto-generated method stub
		
	}
//	protected SpriteManager spriteManager;
//	private Canvas defaultCanvas;
//	public static final int RENDERING_SIZE = 16;
//
//	public DisplayUnitVisitor(Canvas canvas) {
//		this.defaultCanvas = canvas;
//	}
//	
//	@Override
//	public void visit(UnitGroup g) {
//		System.out.println("UG :");;
//		for (Iterator<Unit> it = g.subUnits(); it.hasNext(); it.next().accept(this))
//			;
//	}
//
//	@Override
//	public void visit(UnitRider ur) {
//		spriteManager = new SpriteManagerDefaultImpl(ur.getPathSprite(), defaultCanvas, RENDERING_SIZE, 6);
//		spriteManager.setTypes(
//				"intro", "stand", "walk", "run", "jump", // movements 
//				"down", 
//				"holdin", "kick", //grab+punch // actions
//				"damage", //
//				"win", "dying");
//		System.out.println("UR visité : " + ur.getPathSprite());;
//	}
//
//	@Override
//	public void visit(UnitInfantry ui) {
//		spriteManager = new SpriteManagerDefaultImpl(ui.getPathSprite(), defaultCanvas, RENDERING_SIZE, 6);		
//		spriteManager.setTypes(
//				"intro", "stand", "walk", "run", "jump", // movements 
//				"down", 
//				"holdin", "kick", //grab+punch // actions
//				"damage", //
//				"win", "dying");
//		System.out.println("UI visité : " +ui.getPathSprite());;
//	}

}
