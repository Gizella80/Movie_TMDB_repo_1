package pti.sb_tmdb_mvc.dto;

import java.util.List;

public class GenreListDto {

	private List<GenreDto> genres;

	public GenreListDto(List<GenreDto> genres) {
		super();
		this.genres = genres;
	}

	public List<GenreDto> getGenres() {
		return genres;
	}

	public void setGenres(List<GenreDto> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "GenreListDto [genres=" + genres + "]";
	}
	
	public void orderGenresById() {
		
		for(int currentIndex = 0; currentIndex < this.genres.size(); currentIndex++) {
			
			GenreDto currentGenreDto = this.genres.get(currentIndex);
			for(int nextIndex = currentIndex+1; nextIndex < this.genres.size(); nextIndex++) {
				
				GenreDto nextGenreDto = this.genres.get(nextIndex);
				if(currentGenreDto.getId() > nextGenreDto.getId()) {
					
					this.genres.set(currentIndex, nextGenreDto);
					this.genres.set(nextIndex, currentGenreDto);
					currentIndex = -1;
					break;
				}
			}
		}
	}
	
}
