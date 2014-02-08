package data.mapper;

public class MpgRoute implements Mappable {

	@Override
	public String add() {
			return "INSERT INTO parcours VALUES(NULL, ?, ?)";
	}

	@Override
	public String del() {
	
		return "DELETE FROM parcours WHERE idparcours = ?";
	}

	@Override
	public String sel() {
		
		return "SELECT * FROM parcours where idparcours = ?";
	}

	@Override
	public String upd() {
		
		return "UPDATE parcours SET libelleparcours = ? WHERE parcours.idparcours = ?";
	}

	@Override
	public String getAll() {
		return "SELECT * FROM parcours";
	}
	
	public String search()
	{
		return "SELECT * FROM parcours WHERE libelleparcours LIKE %?%";
	}

}
