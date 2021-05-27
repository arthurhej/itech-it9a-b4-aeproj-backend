package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.utilities;

import java.util.Comparator;
import java.util.List;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;

public class SortUtils {

    public static List<Score> myShortSort(List<Score> listOfScores) {

        listOfScores.sort(Comparator.comparingLong(Score::getPoints).reversed());
        return listOfScores;
    }
}
