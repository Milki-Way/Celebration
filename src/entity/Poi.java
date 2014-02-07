package entity;

import geography.IDrawable;

import java.awt.Graphics;

import tools.Coordinate;

public class Poi implements IDrawable, IEntity{
	
	private DescriptionComplex description;
	private String libelle;	
	private Coordinate coords;
	private int id;
		
	//Constructeur
	public Poi() {
			id =-1;
		}
	
	//Constructeur Param
	public Poi(int id, String libelle, Coordinate coords, DescriptionComplex description){
		this.id = id;
		this.libelle = libelle;
		this.coords = coords;
		this.description = description; 
	}
	
	public Poi(String libelle, Coordinate coords, DescriptionComplex description){
		this.id = -1;
		this.libelle = libelle;
		this.coords = coords;
		this.description = description; 
	}
	
	public Poi(String libelle, Double x, Double y, DescriptionComplex description){
		this(libelle, new Coordinate(x,y), description);
	}
	
	public Poi(int id, String libelle, Double x, Double y, DescriptionComplex description){
		this(id, libelle, new Coordinate(x,y), description);
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

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Coordinate getCoords() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the description
	 */
	public DescriptionComplex getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(DescriptionComplex description) {
		this.description = description;
	}

	/**
	 * @param coords the coords to set
	 */
	public void setCoords(Coordinate coords) {
		this.coords = coords;
	}
}
