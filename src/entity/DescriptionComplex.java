package entity;



import java.awt.image.BufferedImage;
import java.util.ArrayList;



public class DescriptionComplex implements IEntity {
	private String description;
	private int id;
	private ArrayList<String> linkList = new ArrayList<String>();
	private ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>();
	private ArrayList<IEntity> refs = new ArrayList<IEntity>();
	
	//Constructeur
		public DescriptionComplex (String description, ArrayList<BufferedImage> imageList, ArrayList<String> linkList, ArrayList<IEntity> refs) {
			id =-1;
			this.description = description;
			this.imageList = imageList;
			this.linkList = linkList;
			this.refs = refs;
		}
		
	// Constructeur param
		public DescriptionComplex (int id, String description, ArrayList<BufferedImage> imageList, ArrayList<String> linkList, ArrayList<IEntity> refs){
			this.id = id;
			this.description = description;
			this.imageList = imageList;
			this.linkList = linkList;
			this.refs = refs;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	public ArrayList<String> getLinkList() {
		return linkList;
	}
	public void setLink(ArrayList<String> linkList) {
		this.linkList = linkList;
	}
	
	public ArrayList<BufferedImage> getImageList() {
		return imageList;
	}

	public void setImage(ArrayList<BufferedImage> imageList) {
		this.imageList = imageList;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void displayDescription()
	{
		System.out.println(this.description); 
	}
	public void displayLink()
	{
		for (int i = 0; i<linkList.size(); i++){
			System.out.println(this.linkList.get(i));
		}
		 
	}
	public void displayImage()
	{
		for (int i = 0; i<imageList.size(); i++){
			System.out.println(this.imageList.get(i));
		} 
	}

	/**
	 * @return the refs
	 */
	public ArrayList<IEntity> getRefs() {
		return refs;
	}

	/**
	 * @param refs the refs to set
	 */
	public void setRefs(ArrayList<IEntity> refs) {
		this.refs = refs;
	}
}

