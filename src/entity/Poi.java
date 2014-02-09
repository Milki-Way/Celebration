package entity;

import java.awt.Graphics;

import tools.Coordinate;

public class Poi implements IEntity{
	
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
	
	public Poi(String libelle, double x, double y, DescriptionComplex description){
		this(libelle, new Coordinate(x,y), description);
	}
	
	public Poi(int id, String libelle, double x, double y, DescriptionComplex description){
		this(id, libelle, new Coordinate(x,y), description);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public DescriptionComplex getDescription() {
		return description;
	}

	public void setDescription(DescriptionComplex description) {
		this.description = description;
	}

	public void setCoords(Coordinate coords) {
		this.coords = coords;
	}
	
	public Coordinate getCoords() {
		if(this.coords == null)
			this.coords = new Coordinate(0,0);
		return this.coords;
	}
	
	public String toString(){
		return this.libelle+"["+this.getCoords().getColumnDouble()+","+this.coords.getRowDouble()+"]";
	}
	
	public boolean equals(Poi poi){
		if(this.coords.getColumnDouble() == poi.getCoords().getColumnDouble() && this.coords.getRowDouble() == poi.getCoords().getRowDouble() && this.libelle.equals(poi.libelle)){
			return true;
		} else {
			return false;
		}
	}
}
