package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.utilities;

import java.util.Comparator;
import java.util.List;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

/**
 * Utility class with specific methods
 */
public class SortUtils {

    /**
     * receives a list of scores, sorts it by points (descending) and returns the list
     * 
     * @param listOfScores
     * @return sorted List
     */
    public static List<Score> myShortSort(List<Score> listOfScores) {

        listOfScores.sort(Comparator.comparingLong(Score::getPoints).reversed());
        return listOfScores;
    }
}
