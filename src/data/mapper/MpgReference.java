package data.mapper;

public class MpgReference implements Mappable{

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
		return "SELECT * FROM reference WHERE idrefdescription = ?";
		//Renvois toutes les lignes de Reference contenant l'id de la description
	}

	@Override
	public String upd() {
		// TODO Auto-generated method stub
		return null;
	}

}
