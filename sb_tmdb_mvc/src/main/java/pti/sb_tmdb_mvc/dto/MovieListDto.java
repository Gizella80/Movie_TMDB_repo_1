package pti.sb_tmdb_mvc.dto;

import java.util.List;

public class MovieListDto {
	
	private List<MovieDto> movieDtos;

	public MovieListDto(List<MovieDto> movieDtos) {
		super();
		this.movieDtos = movieDtos;
	}

	public List<MovieDto> getMovieDtos() {
		return movieDtos;
	}

	public void setMovieDtos(List<MovieDto> movieDtos) {
		this.movieDtos = movieDtos;
	}

	@Override
	public String toString() {
		return "MovieListDto [movieDtos=" + movieDtos + "]";
	}
	
	

}
