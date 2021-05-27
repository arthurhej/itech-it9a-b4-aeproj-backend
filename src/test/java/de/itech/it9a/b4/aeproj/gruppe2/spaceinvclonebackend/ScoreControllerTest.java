package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testFindTopTen() throws Exception {

        List<Score> mockReturnList = List.of(new Score("Tes01", 1L), new Score("Tes02", 2L), new Score("Tes03", 3L), new Score("Tes04", 4L),
                new Score("Tes05", 5L), new Score("Tes06", 6L), new Score("Tes07", 7L), new Score("Tes08", 8L), new Score("Tes09", 9L),
                new Score("Tes10", 10L), new Score("Tes11", 11L), new Score("Tes12", 12L), new Score("Tes13", 13L), new Score("Tes14", 14L),
                new Score("Tes15", 15L));

        // MongoOperations mongoOpsMock = Mockito.mock(MongoOperations.class);

        Mockito.when(mt.findAll(Score.class)).thenReturn(mockReturnList);
        List<Score> sortedScoreList = sc.findTopTen();

        assertEquals(15L, sortedScoreList.get(0).getPoints());
        assertEquals("Tes15", sortedScoreList.get(0).getName());
    }

}
