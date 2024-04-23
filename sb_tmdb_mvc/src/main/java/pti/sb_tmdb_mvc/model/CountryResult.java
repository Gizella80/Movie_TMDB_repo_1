package pti.sb_tmdb_mvc.model;

import java.util.List;

public class CountryResult {
	
	private String iso_31_66_1;
	private List<ReleaseResult> release_dates;
	
	
	public String getIso_31_66_1() {
		return iso_31_66_1;
	}
	
	public void setIso_31_66_1(String iso_31_66_1) {
		this.iso_31_66_1 = iso_31_66_1;
	}
	
	public List<ReleaseResult> getRelease_dates() {
		return release_dates;
	}
	
	public void setRelease_dates(List<ReleaseResult> release_dates) {
		this.release_dates = release_dates;
	}
	
	
	
}
