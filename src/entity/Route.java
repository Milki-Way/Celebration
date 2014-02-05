package entity;


public class Route {
	//this class is a fake Route CLASS
	
	private int id;
	private String libelle;
	
	//Constructeur
	public Route () {
		id =-1;
	}

	//Constructeur Param
	public Route(int id, String libelle){
		this.id = id;
		this.libelle = libelle;
	
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

	
}
