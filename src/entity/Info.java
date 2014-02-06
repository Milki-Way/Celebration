package entity;


import java.util.ArrayList;



public class Info implements IEntity{
	//this class is a fake Infos CLASS
	private String libelle;
	private DescriptionComplex descplx;
	private int id;
	
	//Constructeur
		public Info () {
			id =-1;
		}

	// constructeur param	
	public Info(int id, String libelle, DescriptionComplex d) {
	
		this.id = id;
		this.libelle = libelle;
		descplx = d;
	}
	
	public Info(String libelle, DescriptionComplex d)
	{
		this();
		this.libelle = libelle;
		this.descplx = d;
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
	 * @return the descplx
	 */
	public DescriptionComplex getDescplx() {
		return descplx;
	}

	/**
	 * @param descplx the descplx to set
	 */
	public void setDescplx(DescriptionComplex descplx) {
		this.descplx = descplx;
	}
	

}
