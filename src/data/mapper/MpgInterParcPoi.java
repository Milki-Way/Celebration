package data.mapper;

public class MpgInterParcPoi implements Mappable{

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
		return "SELECT * FROM poi INNER JOIN inter ON poi.idpoi = inter.idpoiinter WHERE inter.idparcours = ?";
//"Une requete SQL qui renvois tous les POI de la table POI via la table Inter avec INNER JOIN et WHERE idparcours = ? pour sélectionner dans la table inter.";
	}

	@Override
	public String upd() {
		// TODO Auto-generated method stub
		return null;
	}

}
