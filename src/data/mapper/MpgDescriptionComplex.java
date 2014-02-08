package data.mapper;

public class MpgDescriptionComplex implements Mappable {

	@Override
	public String add() {
		return "INSERT INTO descriptioncomplexe VALUES(NULL, ?, ?)";
	}

	@Override
	public String del() {
		return "DELETE FROM descriptioncomplexe WHERE iddescription = ?";
	}

	@Override
	public String sel() {
		return "SELECT * FROM descriptioncomplexe WHERE iddescription = ?";
	}

	@Override
	public String upd() {
		return "UPDATE descriptioncomplexe SET description = ? WHERE descriptioncomplexe.iddescription = ?";
	}

	@Override
	public String getAll() {
		return "SELECT * FROM descriptioncomplexe";
	}
	
	public String search()
	{
		return "SELECT * FROM descriptioncomplexe WHERE libelledescription LIKE %?% OR description LIKE %?%";
	}

}
