package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model;

import org.springframework.data.annotation.Id;

public class Score {

    @Id
    private String id;
    private String name;
    private Long points;

    public Score(String name, Long points) {

        this.name = name;
        this.points = points;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Long getPoints() {

        return points;
    }

    public void setPoints(Long points) {

        this.points = points;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    @Override
    public String toString() {

        return "Score [id=" + id + ", name=" + name + ", points=" + points + "]";
    }

}
