package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.controller.ScoreController;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

@RestController
public class RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestService.class);

    private ScoreController scoreController;

    public RestService() {

        scoreController = new ScoreController();
    }

    @GetMapping("/scores")
    public List<Score> newScore() {

        try {
            return scoreController.findAll();
        } catch (Exception e) {
            LOGGER.warn("error reading scores", e);
            return new ArrayList<>();
        }
    }

    @PutMapping("/scores")
    public void insertScore(@RequestBody Score score) {

        try {
            scoreController.insertScore(score);
        } catch (Exception e) {
            LOGGER.warn("error inserting new score: ", e);
        }
    }

    @DeleteMapping("/scores/{id}")
    public void removeScore(@PathVariable String id) {

        try {
            Score score = scoreController.findById(id);
            scoreController.removeScore(score);
        } catch (Exception e) {
            LOGGER.warn("error deleting score " + id, e);
        }
    }
}
