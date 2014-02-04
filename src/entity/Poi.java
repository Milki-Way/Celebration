package entity;

public class Poi {
	//this class is a fake POI CLASS
	private String libelle;	
	private int x;
	private int y;
	private int id;
	
	//Constructeur
	public Poi () {
		id =-1;
	}
		
	//Constructeur Param
	public Poi (String libelle, int x, int y, int id) {
		this.id = id;
		this.libelle = libelle;
		this.x = x;
		this.y = y;
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	
	
}
