package entity;



public class DescriptionComplex {
	//this class is a fake DescriptionComplex  CLASS
	private String description;
	private int id;
	
	//Constructeur
		public DescriptionComplex () {
			id =-1;
		}
		
	
	// Constructeur param
		public DescriptionComplex (String description, int id){
			this.id = id;
			this.description = description;
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

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
