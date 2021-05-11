package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.controller;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.config.AppConfig;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

public class ScoreController {

	private final AppConfig appConf = new AppConfig();
	
	private final MongoOperations mongoOps = appConf.mongoTemplate();
	
	public void insertScore(Score score) {
		mongoOps.insert(score);
	}
	
	public Score findById(long id){
		return mongoOps.findById(id, Score.class);
	}
	
	public List<Score> findAll() {
		return mongoOps.findAll(Score.class);
	}
	
//	public List<Score> findTopTen(List<Score> allScores) {
//		allScores.sort(Score.score);
//	}
	
	public void removeScore(Score score) {
		mongoOps.remove(score);
	}
}
