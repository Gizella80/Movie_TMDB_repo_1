package pti.sb_tmdb_mvc.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Transient
	private List<Integer> seenMovieIds;

	
		
	public User() {
		this.seenMovieIds = new ArrayList<>();
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

	public List<Integer> getSeenMovieIds() {
		return seenMovieIds;
	}

	public void setSeenMovieIds(List<Integer> seenMovieIds) {
		this.seenMovieIds = seenMovieIds;
	}
	public void addMovieId(int movieId) {
		
		seenMovieIds.add(movieId);
	
	
	}
	

}
