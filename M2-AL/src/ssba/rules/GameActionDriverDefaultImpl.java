package ssba.rules;


public class GameActionDriverDefaultImpl implements GameActionDriver{
	
	protected ActionStrategy actionStrategy;

	public GameActionDriverDefaultImpl() {
		actionStrategy = new ActionStrategyDefaultImpl();
	}

	public void setStrategy(ActionStrategy strat) {
		actionStrategy = strat;
	}

	@Override
	public boolean getAttack() {
		boolean attack = actionStrategy.getIsAttacking();
		return attack;
	}
	
	public void finishAttack(){
		actionStrategy.setAttack();
	}
}
