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
		return actionStrategy.getIsAttacking();
	}

	public void finishAttack(){
		actionStrategy.setAttack(false);
	}

	@Override
	public boolean getParry() {
		return actionStrategy.getIsDamaging();
	}

	@Override
	public void finishParry() {
		actionStrategy.setParry(false);		
	}
}
