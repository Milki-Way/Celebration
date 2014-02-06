package data.mapper;

public class MpgImageDesc implements Mappable{

	@Override
	public String getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String del() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sel() {
		return "SELECT * FROM images INNER JOIN descriptioncomplexe ON descriptioncomplex.id = images.descriptioncomplex.id WHERE descriptioncompex.id = ?";
				//renvois une requête SQL qui sélectionne toutes les images avec l'id d'une description complexe";
	}			

	@Override
	public String upd() {
		// TODO Auto-generated method stub
		return null;
	}

}
