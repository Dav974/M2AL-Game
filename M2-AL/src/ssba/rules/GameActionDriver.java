package ssba.rules;

public interface GameActionDriver {
	public boolean getAttack();
	public void finishAttack();
	public boolean getParry();
	public void finishParry();
}
