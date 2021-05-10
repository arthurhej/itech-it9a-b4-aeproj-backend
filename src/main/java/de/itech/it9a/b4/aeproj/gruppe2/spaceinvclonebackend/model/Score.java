package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model;

import org.springframework.data.annotation.Id;

public class Score {

	@Id
	private String id;
	private String name;
	private long score;
	
	public Score(String name, long score){
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	
}
