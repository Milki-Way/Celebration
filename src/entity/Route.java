package entity;

import java.util.ArrayList;


public class Route implements Identifiable{	
	private int id;
	private String libelle;
	private ArrayList<Poi> poiList;
	private DescriptionComplex descmplx;
	
	//Constructeur
	public Route () {
		id =-1;
		libelle="Nouveau parcours(vide)";
		poiList = new ArrayList<Poi>();
	}

	//Constructeur Param
	public Route(int id, String libelle, DescriptionComplex d){
		this.id = id;
		this.libelle = libelle;
		this.poiList = new ArrayList<Poi>();
		descmplx = d;
	}
	
	//Constructeur Param
	public Route(int id, String libelle, DescriptionComplex d , Poi... pois){
		this(id, libelle, d);
		for(Poi p : pois)
			addPoi(p);
	}
	
	public Route(String libelle, DescriptionComplex d){
		this.id = -1;
		this.libelle = libelle;
		this.poiList = new ArrayList<Poi>();
		descmplx = d;
	}
	
	public Route(String libelle, DescriptionComplex d, Poi... pois){
		this(libelle, d);
		for(Poi p : pois)
			addPoi(p);
		
	}
	
	public Route(String libelle, ArrayList<Poi> pois, DescriptionComplex d){
		this(libelle, d);
		this.poiList = pois;
	}
	
	public Route(int id, String libelle, ArrayList<Poi> pois, DescriptionComplex d){
		this(id, libelle, d);
		this.poiList = pois;
	}
	
	
	//Add a poi into poiList
	public void addPoi(Poi p)
	{
		this.poiList.add(p);
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
	 * @return the poiList
	 */
	public ArrayList<Poi> getPoiList() {
		return poiList;
	}

	/**
	 * @param poiList the poiList to set
	 */
	public void setPoiList(ArrayList<Poi> poiList) {
		this.poiList = poiList;
	}

	/**
	 * @return the descmplx
	 */
	public DescriptionComplex getDescmplx() {
		return descmplx;
	}

	/**
	 * @param descmplx the descmplx to set
	 */
	public void setDescmplx(DescriptionComplex descmplx) {
		this.descmplx = descmplx;
	}

	
}
