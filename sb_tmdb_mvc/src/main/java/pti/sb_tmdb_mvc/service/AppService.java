package pti.sb_tmdb_mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pti.sb_tmdb_mvc.db.Database;
import pti.sb_tmdb_mvc.dto.CountryResultDto;
import pti.sb_tmdb_mvc.dto.GenreDto;
import pti.sb_tmdb_mvc.dto.GenreListDto;
import pti.sb_tmdb_mvc.dto.MovieDto;
import pti.sb_tmdb_mvc.dto.MovieListDto;
import pti.sb_tmdb_mvc.dto.ReleaseResultDto;
import pti.sb_tmdb_mvc.dto.ReleasedMovieDto;
import pti.sb_tmdb_mvc.dto.UserDto;
import pti.sb_tmdb_mvc.model.CountryResult;
import pti.sb_tmdb_mvc.model.Genre;
import pti.sb_tmdb_mvc.model.Movie;
import pti.sb_tmdb_mvc.model.ReleaseResult;
import pti.sb_tmdb_mvc.model.ReleasedMovie;
import pti.sb_tmdb_mvc.model.TMDBGenreResult;
import pti.sb_tmdb_mvc.model.TMDBMovieResult;
import pti.sb_tmdb_mvc.model.User;

@Service
public class AppService {
	
	private static final String TMDB_API_KEY= "c1fa0cf3eda97ff6dbd2a15bf9e29f75";
	
	private Database db;
	
	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}

	public MovieDto getMovieById(int movieId) {
		
		MovieDto movieDto = null;
		
		RestTemplate rt = new RestTemplate();
		Movie movie = rt.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + TMDB_API_KEY, Movie.class);
		
		
		movieDto = convertMovieToMovieDto( movie);
		return movieDto;
	}
	
	private MovieDto convertMovieToMovieDto(Movie movie) {
		
		MovieDto movieDto = null;
		
		movieDto = new MovieDto(
					movie.getId(),
					movie.getOriginal_title(),
					movie.getOverview(),
					movie.getGenre_ids()
				);
		
		return movieDto;
	}


	public MovieDto getMovieByTitle(String movieTitle) {

		MovieDto movieDto = null;
		
		RestTemplate rt = new RestTemplate();
		TMDBMovieResult movieResult = rt.getForObject(
				"https://api.themoviedb.org/3/search/movie?query=" + 
						movieTitle + "&api_key=c1fa0cf3eda97ff6dbd2a15bf9e29f75",
				TMDBMovieResult.class);
		
		
		List<Movie> movies = movieResult.getResults();
		if(movies.size() > 0) {
			
			Movie movie = movieResult.getResults().get(0);
			movieDto = convertMovieToMovieDto(movie);
		}
		
		return movieDto;
	}

	public GenreListDto getGenres() {
		
		GenreListDto genreListDto = null;
		
		RestTemplate rt = new RestTemplate();
		TMDBGenreResult genreResult = rt.getForObject(
				"https://api.themoviedb.org/3/genre/movie/list?api_key=c1fa0cf3eda97ff6dbd2a15bf9e29f75",
				TMDBGenreResult.class);
		
		
		List<GenreDto> genreDtos = new ArrayList<>();
		List<Genre> genres = genreResult.getGenres();
		for(int index = 0; index < genres.size(); index++) {
			
			Genre currentGenre = genres.get(index);
			GenreDto genreDto = new GenreDto(
						currentGenre.getId(),
						currentGenre.getName()
					);
			genreDtos.add(genreDto);
		}
		
		genreListDto = new GenreListDto(genreDtos);
		genreListDto.orderGenresById();
		
		return genreListDto;
	}

	public UserDto getUserById(int userId) {
		
		UserDto userDto = null;
		
		User user = db.getUserById(userId);
		
		List<MovieDto> movieDtos = new ArrayList<>();
		
		for(int i = 0; i < user.getSeenMovieIds().size();i++) {
			RestTemplate rt = new RestTemplate();
			Movie movie = rt.getForObject(
					"https://api.themoviedb.org/3/movie/" + user.getSeenMovieIds().get(i) + "?api_key=" + TMDB_API_KEY, Movie.class);
			
			
			MovieDto movieDto = convertMovieToMovieDto( movie);
			movieDtos.add(movieDto);
		}
		
		
		userDto = new UserDto( 
				user.getId(),
				user.getName(),
				user.getAge(),
				movieDtos);


		return userDto;
	}

	public MovieListDto getFirstTenMovieByTitle(String mTitle) {
	
		
		
		
		RestTemplate rt = new RestTemplate();
		TMDBMovieResult movieResult = rt.getForObject(
				"https://api.themoviedb.org/3/search/movie?query=" + 
						mTitle + "&api_key=c1fa0cf3eda97ff6dbd2a15bf9e29f75",
				TMDBMovieResult.class);
		
		List<MovieDto> movieList = new ArrayList<>();
		MovieDto movieDto = null;
		List<Movie> movies = movieResult.getResults();
		Movie movie = null;
		
		if(movies.size() > 0) {
			
			if(movies.size() < 10) {
				for(int index = 0; index < movies.size(); index++) {
					movie = movieResult.getResults().get(index);
					movieDto = convertMovieToMovieDto(movie);
					movieList.add(movieDto);
				}
				
			}else {
				
				for(int index = 0; index < 10; index++) {
					movie = movieResult.getResults().get(index);
					movieDto = convertMovieToMovieDto(movie);
					movieList.add(movieDto);
				}
				
			}
			
		}
		MovieListDto movieListDto = new MovieListDto(movieList);

		return movieListDto;
	}

	public UserDto mergeUserById(int userId, int movieId) {
		
		UserDto userDto = getUserById(userId);
		MovieDto movieDto = getMovieById(movieId);
		
		userDto.getSeenMovies().add(movieDto);
		
		db.mergeSeenMovies(userId,movieId);
	
		return userDto;
	}

	public ReleasedMovieDto getReleaseResult(int movieId) {

		ReleasedMovieDto releasedMovieDto = null;
		
		RestTemplate rt = new RestTemplate();
		ReleasedMovie rm= rt.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "/release_dates?api_key=c1fa0cf3eda97ff6dbd2a15bf9e29f75",
						ReleasedMovie.class);
		
		List<CountryResult> countryResultList = rm.getResults();
		List<CountryResultDto> countryResultDtoList = new ArrayList<>();
		for(int index_coutryResultList = 0 ; index_coutryResultList < countryResultList.size(); index_coutryResultList ++) {
			
		 
			CountryResult currentCountryResult = countryResultList.get( index_coutryResultList);
			
			
			List<ReleaseResult> releseResultList =  currentCountryResult.getRelease_dates();
			List<ReleaseResultDto> releaseResultDtoList = new ArrayList<>();
			
			for(int index_releaseResultList = 0; index_releaseResultList < releseResultList .size(); index_releaseResultList++) {
				
				ReleaseResult releaseResult =  releseResultList.get(index_releaseResultList);
				
				ReleaseResultDto releaseResultDto = new ReleaseResultDto(
						releaseResult.getRelease_date(),
						releaseResult.getType()
						);
				releaseResultDtoList.add(releaseResultDto);
			
			}
			
			CountryResultDto countryResultDto = new CountryResultDto( 
					currentCountryResult.getIso_31_66_1(),
					releaseResultDtoList);
			
			countryResultDtoList.add(countryResultDto);
		}
		
		releasedMovieDto = new ReleasedMovieDto(
				movieId,
				countryResultDtoList);
		
		return releasedMovieDto;
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
}
