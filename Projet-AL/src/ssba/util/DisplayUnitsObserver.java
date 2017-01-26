package ssba.util;
import observer_util.Observer;
import soldier.core.Unit;

public class DisplayUnitsObserver implements Observer<Unit>{

		private int unitToDraw = 0;

		@Override
		public void update(Unit unit) {
			
			if (!unit.alive()) {
				++unitToDraw;
				unit.removeObserver(this);
			}
		}

		public int getNumberOfDeadUnits() {
			return unitToDraw;
		}
	}