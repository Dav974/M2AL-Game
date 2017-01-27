package ssba.rules;


public class GameActionDriverDefaultImpl implements GameActionDriver{
	
	protected ActionStrategyDefaultImpl actionStrategy;
	
	public GameActionDriverDefaultImpl(char keyAction) {
		actionStrategy = new ActionStrategyDefaultImpl(keyAction);
	}

	public void setStrategy(ActionStrategyDefaultImpl strat) {
		actionStrategy = strat;
	}

	public ActionStrategyDefaultImpl getActionStrategy(){
		return actionStrategy;
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
