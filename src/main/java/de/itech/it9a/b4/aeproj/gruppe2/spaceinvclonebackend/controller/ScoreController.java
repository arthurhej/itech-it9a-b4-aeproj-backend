package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.controller;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.config.AppConfig;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

public class ScoreController {

	private final AppConfig appConf = new AppConfig();
	
	private final MongoOperations mongoOps = appConf.mongoTemplate();
	
	private void insertScore(Score score) {
		mongoOps.insert(score);
	}
	
	private List<Score> findAll() {
		return mongoOps.findAll(Score.class);
	}
	
	private void removeScore(Score score) {
		mongoOps.remove(score);
	}
}
