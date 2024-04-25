package pti.sb_tmdb_mvc.dto;

import java.util.List;



public class CountryResultDto {

	
	private String countryCode;
	private List<ReleaseResultDto> releaseResultDtoList;
	
	public CountryResultDto(String countryCode, List<ReleaseResultDto> releaseResultDtoList) {
		super();
		this.countryCode = countryCode;
		this.releaseResultDtoList = releaseResultDtoList;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<ReleaseResultDto> getReleaseResultDtoList() {
		return releaseResultDtoList;
	}

	public void setReleaseResultDtoList(List<ReleaseResultDto> releaseResultDtoList) {
		this.releaseResultDtoList = releaseResultDtoList;
	}

	@Override
	public String toString() {
		return "CountryResultDto [countryCode=" + countryCode + ", releaseResultDtoList=" + releaseResultDtoList + "]";
	}
	
	
	
	
	
	
	
	
	
}
