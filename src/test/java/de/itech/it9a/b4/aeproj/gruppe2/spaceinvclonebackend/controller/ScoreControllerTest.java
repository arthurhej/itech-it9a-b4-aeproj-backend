package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
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
    void testInsertScoreCallsDbInsert() {

        Score score = new Score("Otto", 1L);

        sc.insertScore(score);
        verify(mt).insert(Mockito.eq(score));
    }

    @Test
    void testFindByIdIsCalledInDb() {

        Score score = new Score("Otto", 1L);
        score.setId("123456");

        sc.findById(score.getId());
        verify(mt).findById(score.getId(), Score.class);
    }

    @Test
    void testFindAllIsCalledInDb() {

        sc.findAll();
        verify(mt).findAll(Score.class);
    }

    @Test
    void testRemoveScoreCallsDbRemove() {

        Score score = new Score("Otto", 1L);

        sc.removeScore(score);
        verify(mt).remove(Mockito.eq(score));
    }

    @Test
    void testFindTopTenWithListSizeBigger10() {

        List<Score> mockReturnList = Arrays.asList(new Score("Test1", 1L), new Score("Test2", 2L), new Score("Test3", 3L),
                new Score("Test4", 4L), new Score("Test5", 5L), new Score("Test6", 6L), new Score("Test7", 7L), new Score("Test8", 8L),
                new Score("Test9", 9L), new Score("Test10", 10L), new Score("Test11", 11L), new Score("Test12", 12L),
                new Score("Test13", 13L), new Score("Test14", 14L), new Score("Test15", 15L));

        Mockito.when(mt.findAll(Score.class)).thenReturn(mockReturnList);
        List<Score> sortedScoreList = sc.findTopTen();

        long scoreValue = 15L;
        assertEquals(10, sortedScoreList.size());
        for (Score score : sortedScoreList) {
            assertEquals("Test" + scoreValue, score.getName());
            assertEquals(scoreValue, score.getPoints());
            scoreValue--;
        }
    }

    @Test
    void testFindTopTenWithListSizeSmallerTen() {

        List<Score> mockReturnList = Arrays.asList(new Score("Test1", 1L), new Score("Test2", 2L), new Score("Test3", 3L),
                new Score("Test4", 4L), new Score("Test5", 5L));

        Mockito.when(mt.findAll(Score.class)).thenReturn(mockReturnList);
        List<Score> sortedScoreList = sc.findTopTen();

        long scoreValue = 5L;
        assertEquals(5, sortedScoreList.size());
        for (Score score : sortedScoreList) {
            assertEquals("Test" + scoreValue, score.getName());
            assertEquals(scoreValue, score.getPoints());
            scoreValue--;
        }
    }

    @Test
    void testFindTopTenWithListSizeZero() {

        Mockito.when(mt.findAll(Score.class)).thenReturn(new ArrayList<>());
        List<Score> sortedScoreList = sc.findTopTen();

        assertEquals(0, sortedScoreList.size());
    }
}
