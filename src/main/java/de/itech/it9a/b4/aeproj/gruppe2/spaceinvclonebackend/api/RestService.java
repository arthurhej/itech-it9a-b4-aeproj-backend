package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.controller.ScoreController;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

@RestController
@RequestMapping("/api")
public class RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestService.class);

    private ScoreController scoreController;

    public RestService() {

        scoreController = new ScoreController();
    }

    /**
     * reads all scores in the database. catches exceptions if facing an error.
     * 
     * @return List w/ all scores
     */
    @GetMapping("/scores")
    public List<Score> findAllScores() {

        try {

            return scoreController.findAll();
        } catch (Exception e) {

            LOGGER.warn("error occured while reading scores", e);
            return new ArrayList<>();
        }
    }

    /**
     * reads top ten scores in the database. catches exceptions if facing an error.
     * 
     * @return
     */
    @GetMapping("/topten")
    public List<Score> findTopTen() {

        try {

            return scoreController.findTopTen();
        } catch (Exception e) {

            LOGGER.warn("error occured while reading top ten scores", e);
            return new ArrayList<>();
        }
    }

    /**
     * inserts one new score object. catches exceptions if facing an error.
     * 
     * @param score
     */
    @PutMapping("/scores")
    public void insertScore(@Valid @RequestBody Score score) {

        try {

            scoreController.insertScore(score);
        } catch (Exception e) {

            LOGGER.warn("error inserting new score: ", e);
        }
    }

    /**
     * removes a specific score by id. catches exceptions if facing an error.
     * 
     * @param id
     */
    @DeleteMapping("/scores/{id}")
    public void removeScore(@PathVariable String id) {

        try {

            Score score = scoreController.findById(id);
            scoreController.removeScore(score);
        } catch (Exception e) {

            LOGGER.warn("error deleting score " + id, e);
        }
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public void badRequestHandler(HttpServletResponse response) throws IOException {

        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
