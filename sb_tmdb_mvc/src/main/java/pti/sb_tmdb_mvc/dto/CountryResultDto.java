package pti.sb_tmdb_mvc.dto;

import java.util.List;



public class CountryResultDto {

	
	private String iso_31_66_1;
	private List<ReleaseResultDto> release_dates;
	
	
	
	public CountryResultDto(String iso_31_66_1, List<ReleaseResultDto> release_dates) {
		super();
		this.iso_31_66_1 = iso_31_66_1;
		this.release_dates = release_dates;
	}
	public String getIso_31_66_1() {
		return iso_31_66_1;
	}
	public void setIso_31_66_1(String iso_31_66_1) {
		this.iso_31_66_1 = iso_31_66_1;
	}
	public List<ReleaseResultDto> getRelease_dates() {
		return release_dates;
	}
	public void setRelease_dates(List<ReleaseResultDto> release_dates) {
		this.release_dates = release_dates;
	}
	@Override
	public String toString() {
		return "CountryListDto [iso_31_66_1=" + iso_31_66_1 + ", release_dates=" + release_dates + "]";
	}
	
	
	
	
	
}
