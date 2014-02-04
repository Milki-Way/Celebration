package data.mapper;



public class MpgInfos implements Mappable{

	@Override
	public String add() {
		return "INSERT INTO news VALUES (NULL, ?, ?)";
	}

	@Override
	public String del() {
		
		return "DELETE FROM news WHERE idnews = ?";
	}

	@Override
	public String sel() {
		
		return "SELECT * FROM news WHERE libellenews = ?";
	}

	@Override
	public String upd() {	
		return "UPDATE news SET libellenews = ? WHERE news.idnews = ?";
	}

	@Override
	public String getAll() {
		return "SELECT * FROM news";
	}

}
