package entity;



public class Info {
	//this class is a fake Infos CLASS
	private String libelle;
	private int id;
	
	//Constructeur
		public Info () {
			id =-1;
		}

	// constructeur param
		
		public Info (String libelle, int id) {
		
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
