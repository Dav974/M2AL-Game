package ssba.rules;

public interface ActionStrategy {
	public boolean getIsAttacking();
	public void setAttack(boolean state);
	
	public boolean getIsDamaging();
	public void setParry(boolean state);
}
