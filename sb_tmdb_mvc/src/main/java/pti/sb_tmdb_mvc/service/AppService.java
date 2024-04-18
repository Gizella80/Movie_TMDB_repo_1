package pti.sb_tmdb_mvc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pti.sb_tmdb_mvc.dto.MovieDto;
import pti.sb_tmdb_mvc.model.Movie;

@Service
public class AppService {
	
	private static final String TMDB_API_KEY= "c1fa0cf3eda97ff6dbd2a15bf9e29f75";

	public MovieDto getMovieById(int movieId) {
		
		MovieDto movieDto = null;
		
		RestTemplate rt = new RestTemplate();
		Movie movie = rt.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + TMDB_API_KEY, Movie.class);
		
		
		movieDto = new MovieDto(
				movie.getId(),
				movie.getOriginal_title(),
				movie.getOverview());
		
		return movieDto;
	}

}
