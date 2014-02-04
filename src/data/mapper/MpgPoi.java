package data.mapper;

public class MpgPoi implements Mappable{

	@Override
	public String add() {
		
		return "INSERT INTO poi VALUES(NULL,?, ?, ?, ?)";
	}

	@Override
	public String del() {
		
		return "DELETE FROM poi WHERE idpoi = ?";
	}

	@Override
	public String sel() {
		
		return "SELECT * FROM poi WHERE idpoi = ?";
	}

	@Override
	public String upd() {
		 return "UPDATE poi SET libellepoi = ?, xpoi = ?, ypoi = ? WHERE poi.idpoi = ?";
		
		
	}

	@Override
	public String getAll() {
		
		return "SELECT * FROM poi";
	}

}
