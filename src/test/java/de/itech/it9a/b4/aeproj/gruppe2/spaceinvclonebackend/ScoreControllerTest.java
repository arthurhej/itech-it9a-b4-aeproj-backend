package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.controller.ScoreController;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

/**
 * Unit tests for {@link ScoreController}
 */
@ExtendWith(MockitoExtension.class)
class ScoreControllerTest {

    @Mock
    private MongoTemplate mt;

    private ScoreController sc;

    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.openMocks(this);
        sc = new ScoreController();
        sc.setMongoOps(mt);
    }

    @Test
    public void testScoreControllerInsert() throws Exception {

        List<Score> scoreList = List.of(new Score("Nullnummer", 0L), new Score("Höchsten Long", Long.MAX_VALUE),
                new Score("negative Zahl", -1L), new Score("null", null), new Score("Hier ist einfach bisschen länger", 1L),
                new Score(null, 1L));

        for (Score score : scoreList) {
            sc.insertScore(score);
            verify(mt).insert(Mockito.eq(score));
        }

    }

}
