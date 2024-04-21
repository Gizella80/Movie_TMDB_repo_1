package pti.sb_tmdb_mvc.dto;

import java.util.List;

public class MovieDto {
	
	
	private int id;
	private String originalTitle;
	private String overview;
	private List<Integer> genre_ids;
	
	
	


	public MovieDto(int id, String originalTitle, String overview, List<Integer> genre_ids) {
		super();
		this.id = id;
		this.originalTitle = originalTitle;
		this.overview = overview;
		this.genre_ids = genre_ids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public List<Integer> getGenre_ids() {
		return genre_ids;
	}

	public void setGenre_ids(List<Integer> genre_ids) {
		this.genre_ids = genre_ids;
	}

	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", originalTitle=" + originalTitle + ", overview=" + overview + ", genre_ids="
				+ genre_ids + "]";
	}


	
	
	
	
	
	
}
