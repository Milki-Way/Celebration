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
		return "SELECT * FROM imagedescription INNER JOIN descriptioncomplexe ON descriptioncomplexe.iddescription = imagedescription.idrefdescription WHERE descriptioncomplexe.iddescription = ?";
				//renvois une requ�te SQL qui s�lectionne toutes les images avec l'id d'une description complexe";
	}			

	@Override
	public String upd() {
		// TODO Auto-generated method stub
		return null;
	}

}
