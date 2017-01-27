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
