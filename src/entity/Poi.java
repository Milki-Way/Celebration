package display;

import tools.DescriptionComplex;
import geography.IDrawable;
import geography.IReferenceable;

public class Poi implements IReferenceable, IDrawable{
	
	private DescriptionComplex description;
	private String libelle;	
	private int x;
	private int y;
	private int id;
		
	//Constructeur
	public Poi() {
			id =-1;
		}
	
	//Constructeur Param
	public Poi(int id, String libelle, int x, int y, DescriptionComplex description){
		this.id = id;
		this.libelle = libelle;
		this.x = x;
		this.y = y;
		this.description = description; 
	}
	
	public void displayPoi(){
		description.displayDescription(); 
		description.displayLink(); 
		description.displayImage(); 
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
