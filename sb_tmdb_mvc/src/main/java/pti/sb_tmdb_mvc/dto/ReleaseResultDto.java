package pti.sb_tmdb_mvc.dto;

public class ReleaseResultDto {
	
	private String release_date;
	private int type;
	
	public ReleaseResultDto(String release_date, int type) {
		super();
		this.release_date = release_date;
		this.type = type;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ReleaseResultDto [release_date=" + release_date + ", type=" + type + "]";
	}
	
	
}
