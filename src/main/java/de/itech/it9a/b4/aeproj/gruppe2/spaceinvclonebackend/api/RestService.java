package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.api;

import java.util.List;

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

    private ScoreController scoreController;

    public RestService() {

        scoreController = new ScoreController();
    }

    @GetMapping("/scores")
    public List<Score> newScore() {

        return scoreController.findAll();
    }

    @PutMapping("/scores")
    public void insertScore(@RequestBody Score score) {

        scoreController.insertScore(score);
    }

    @DeleteMapping("/scores/{id}")
    public void removeScore(@PathVariable String id) {

        Score score = scoreController.findById(id);
        scoreController.removeScore(score);
    }
}
