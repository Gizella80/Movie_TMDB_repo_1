package pti.sb_tmdb_mvc.dto;

import java.util.List;



public class ReleasedMovieDto {
	
	
		private int movieId;
		private List<CountryResultDto> countryResultDtoList;
		
		public ReleasedMovieDto(int movieId, List<CountryResultDto> countryResultDtoList) {
			super();
			this.movieId = movieId;
			this.countryResultDtoList = countryResultDtoList;
		}
		
		public int getMovieId() {
			return movieId;
		}
		
		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}
		
		public List<CountryResultDto> getCountryResultDtoList() {
			return countryResultDtoList;
		}
		
		public void setCountryResultDtoList(List<CountryResultDto> countryResultDtoList) {
			this.countryResultDtoList = countryResultDtoList;
		}
		
		@Override
		public String toString() {
			return "ReleasedMovieDto [movieId=" + movieId + ", countryResultDtoList=" + countryResultDtoList + "]";
		}
		
		
		
		
}
