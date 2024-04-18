package pti.sb_tmdb_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pti.sb_tmdb_mvc.dto.MovieDto;
import pti.sb_tmdb_mvc.service.AppService;

@Controller
public class AppController {
	
	private AppService service;
	
	
	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
		
	}
	
	@GetMapping("/movie/{movieid}")
	public String showMovie(Model model,
			@PathVariable("movieid") int movieId)
			 {
		
		MovieDto dto = service.getMovieById(movieId);
		
		model.addAttribute("moviedto", dto);
		
		return "movie.html";
	}

}
