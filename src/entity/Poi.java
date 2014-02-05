package entity;

import geography.IDrawable;
import geography.IReferenceable;

import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JLabel;

import tools.Coordinate;

public class Poi implements IReferenceable, IDrawable{
	
	private DescriptionComplex description;
	private String libelle;	
	private Coordinate coords;
	private int id;
	private Icon icon;
		
	//Constructeur
	public Poi() {
			id =-1;
		}
	
	//Constructeur Param
	public Poi(int id, String libelle, Coordinate coords, DescriptionComplex description, Icon icon){
		this.id = id;
		this.libelle = libelle;
		this.coords = coords;
		this.description = description;
		this.icon = icon;
	}
	
	public Poi(int id, String libelle, int x, int y, DescriptionComplex description, Icon icon){
		this(id, libelle, new Coordinate(x,y), description, icon);
	}
	
	public Poi(int id, String libelle, Coordinate coords, Icon icon){
		this(id, libelle, coords, new DescriptionComplex("Aucune description pour le moment", -1), icon);
	}
	
	public Poi(int id, String libelle, int x, int y, Icon icon){
		this(id, libelle, new Coordinate(x,y), new DescriptionComplex("Aucune description pour le moment", -1), icon);
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
		return this.coords;
	}
	
	@Override
	public void setCoords(Coordinate coords) {
		this.coords = coords;
	}
}
