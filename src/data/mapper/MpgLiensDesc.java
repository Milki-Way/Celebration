package data.mapper;

public class MpgLiensDesc implements Mappable{

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
		return "SELECT * FROM liens WHERE id = ?";
				//"une requête SQL qui sélectionne les entrées de la table Liens pour id";
	}

	@Override
	public String upd() {
		// TODO Auto-generated method stub
		return null;
	}

}
