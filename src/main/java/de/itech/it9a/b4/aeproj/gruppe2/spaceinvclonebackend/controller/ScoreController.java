package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.config.AppConfig;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

/**
 * Communication between Database and Restful Service
 */
public class ScoreController {

    private final AppConfig appConf = new AppConfig();

    /**
     * "Toolbox" to execute transactions on the mongo database.
     * Needs a config class to work with a specific database.
     */
    private MongoOperations mongoOps = appConf.mongoTemplate();

    /**
     * sets the required mongo template
     * 
     * @param mt
     */
    public void setMongoOps(MongoTemplate mt) {

        this.mongoOps = mt;
    }

    /**
     * requests the insertion of a new score into the database
     * 
     * @param score
     */
    public void insertScore(Score score) {

        mongoOps.insert(score);
    }

    /**
     * initiates search for a specific score id
     * 
     * @param id
     * @return single Score object
     */
    public Score findById(String id) {

        return mongoOps.findById(id, Score.class);
    }

    /**
     * gets all available Scores
     * 
     * @return all Score objects
     */
    public List<Score> findAll() {

        return mongoOps.findAll(Score.class);
    }

    /**
     * gets all scores and sorts them desc by points
     * 
     * @return top ten scores by points
     */
    public List<Score> findTopTen() {

        List<Score> allScores = findAll();
        allScores.sort(Comparator.comparingLong(Score::getPoints).reversed());

        if (allScores.size() < 10) {
            return allScores.subList(0, allScores.size() - 1);
        } else {
            return allScores.subList(0, 9);
        }
    }

    /**
     * removes specific score
     * 
     * @param score
     */
    public void removeScore(Score score) {

        mongoOps.remove(score);
    }

}
