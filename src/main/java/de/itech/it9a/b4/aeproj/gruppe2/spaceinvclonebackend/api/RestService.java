package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.controller.ScoreController;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

@RestController
public class RestService {
	
	private ScoreController scoreController;
	
	public RestService() {
		this.scoreController = new ScoreController();
	}
	
	@GetMapping("/scores")
	private List<Score> newScore(){
	}
}
