package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;

public class Score {

    @Id
    private String id;

    @NotNull
    @Pattern(regexp = "\\w{5}")
    private String name;

    @NotNull
    @Positive
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
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((points == null) ? 0 : points.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Score other = (Score) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (points == null) {
            if (other.points != null)
                return false;
        } else if (!points.equals(other.points))
            return false;
        return true;
    }

    @Override
    public String toString() {

        return "Score [id=" + id + ", name=" + name + ", points=" + points + "]";
    }

}
