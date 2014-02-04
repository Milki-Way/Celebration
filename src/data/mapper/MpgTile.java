package data.mapper;

public class MpgTile implements Mappable {

	@Override
	public String add() {
			return "INSERT INTO tiles VALUES(?, ?, ?, ?)";
	}

	@Override
	public String del() {
		return "";
	}

	@Override
	public String sel() {
		return "SELECT * FROM tiles WHERE zoom_level = ? AND tile_column = ? AND tile_row = ?";
	}

	@Override
	public String upd() {
		return "";
	}

	@Override
	public String getAll() {
		return "SELECT * FROM tiles";
	}

}