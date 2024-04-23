package pti.sb_tmdb_mvc.dto;

import java.util.List;



public class ReleasedMovieDto {
	
	
		private int movieId;
		private List<CountryResultDto> results;
		
		
		public ReleasedMovieDto(int movieId, List<CountryResultDto> results) {
			super();
			this.movieId = movieId;
			this.results = results;
		}


		public int getMovieId() {
			return movieId;
		}


		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}


		public List<CountryResultDto> getResults() {
			return results;
		}


		public void setResults(List<CountryResultDto> results) {
			this.results = results;
		}


		@Override
		public String toString() {
			return "ReleasedMovieDto [movieId=" + movieId + ", results=" + results + "]";
		}
		
		
}
