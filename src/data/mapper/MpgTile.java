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

	public String sel(String zoom, String column, String row) {
		return String.format("SELECT * FROM tiles WHERE zoom_level = %s AND tile_column = %s AND tile_row = %s", zoom, column, row);
	}

	@Override
	public String upd() {
		return "";
	}

	@Override
	public String getAll() {
		return "SELECT * FROM tiles";
	}

	@Override
	public String sel() {
		return "";
	}

}