package tools;

public interface Observable {
	public void addObservateur(Observer obs);
	public void updateObservateur();
	public void delObservateur();
}
