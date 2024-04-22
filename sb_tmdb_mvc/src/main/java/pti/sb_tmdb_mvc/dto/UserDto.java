package pti.sb_tmdb_mvc.dto;

import java.util.List;

public class UserDto {
	
	private int id;
	private String name;
	private int age;
	
	private List<MovieDto> seenMovies;

	public UserDto(int id, String name, int age, List<MovieDto> seenMovies) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.seenMovies = seenMovies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<MovieDto> getSeenMovies() {
		return seenMovies;
	}

	public void setSeenMovies(List<MovieDto> seenMovies) {
		this.seenMovies = seenMovies;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", age=" + age + ", seenMovies=" + seenMovies + "]";
	}
	
	

}
