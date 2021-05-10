package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.config.AppConfig;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

@SpringBootApplication
public class SpaceInvCloneBackendApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpaceInvCloneBackendApplication.class, args);
		
		AppConfig appConf = new AppConfig();
		
		MongoOperations mongoOps = appConf.mongoTemplate();
		
		Score test = new Score("Das ist ein TestName", 419L);
		
		mongoOps.insert(test);
	}

}
