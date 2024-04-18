package pti.sb_tmdb_mvc.dto;

public class MovieDto {
	
	
	private int id;
	private String originalTitle;
	private String overview;
	
	
	public MovieDto(int id, String originalTitle, String overview) {
		super();
		this.id = id;
		this.originalTitle = originalTitle;
		this.overview = overview;
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


	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", originalTitle=" + originalTitle + ", overview=" + overview + "]";
	}
	
	
	
	
	
}
