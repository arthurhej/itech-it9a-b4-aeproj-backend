package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.utilities;

import static de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.utilities.SortUtils.myShortSort;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.utilities.SortUtils;

/**
 * Unit tests for {@link SortUtils}
 */
@SpringBootTest
class SortUtilsTest {

    @Test
    void testMyShortSortSortsCorrectly() {

        List<Score> mockReturnList = Arrays.asList(new Score("Test1", 1L), new Score("Test2", 2L), new Score("Test3", 3L),
                new Score("Test4", 4L), new Score("Test5", 5L), new Score("Test6", 6L), new Score("Test7", 7L), new Score("Test8", 8L),
                new Score("Test9", 9L), new Score("Test10", 10L));

        long scoreValue = 10L;
        List<Score> sortedScoreList = myShortSort(mockReturnList);

        for (Score score : sortedScoreList) {
            assertEquals("Test" + scoreValue, score.getName());
            assertEquals(scoreValue, score.getPoints());
            scoreValue--;
        }
    }
}
