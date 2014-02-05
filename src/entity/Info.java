package entity;

import geography.IReferenceable;

import java.util.ArrayList;



public class Info implements Identifiable{
	//this class is a fake Infos CLASS
	private String libelle;
	private DescriptionComplex descplx;
	private IReferenceable ref;
	private int id;
	
	//Constructeur
		public Info () {
			id =-1;
		}

	// constructeur param	
	public Info(int id, String libelle, DescriptionComplex d, IReferenceable r) {
	
		this.id = id;
		this.libelle = libelle;
		descplx = d;
		ref =r;
	}
	
	public Info(String libelle, DescriptionComplex d, IReferenceable r)
	{
		this();
		this.libelle = libelle;
		this.descplx = d;
		ref = r;
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
