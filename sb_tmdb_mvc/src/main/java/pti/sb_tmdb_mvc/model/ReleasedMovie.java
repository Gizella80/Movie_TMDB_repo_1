package pti.sb_tmdb_mvc.model;

import java.util.List;

public class ReleasedMovie {
	
	private int id;

	private List<CountryResult> results;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CountryResult> getResults() {
		return results;
	}

	public void setResults(List<CountryResult> results) {
		this.results = results;
	}
	
	

}
