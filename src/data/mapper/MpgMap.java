package data.mapper;

public class MpgMap implements Mappable{

	@Override
	public String add() {		
		return "INSERT INTO carte VALUES(NULL, ?, ?, ?, ?)";
	}

	@Override
	public String del() {
		return "DELETE FROM carte WHERE idcarte = ?;";
	}

	@Override
	public String sel() {
		return "SELECT * FROM carte WHERE idcarte = ?";
	}

	@Override
	public String upd() {		
		return "UPDATE carte SET libellecarte = ?, descriptifcarte = ?, xcarte = ?, ycarte = ? WHERE carte.idcarte = ?";

	}

	@Override
	public String getAll() {
		return "SELECT * FROM carte;";
	}
	
}
