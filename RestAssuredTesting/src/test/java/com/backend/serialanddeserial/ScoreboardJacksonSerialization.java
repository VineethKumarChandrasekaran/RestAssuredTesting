package com.backend.serialanddeserial;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
@JsonPropertyOrder(
		value = {
				"playername",
				"wicket",
				"score",
				"century"
		}
		)

@JsonIgnoreProperties(
		value = {
				"wicket"
		})
class CricketScore {   // POJO Class - Plain Old Java Object
    private String playername;
    private long score;
    @JsonProperty(value = "cen_tury")
    private int century;
    private int wicket;

    public CricketScore() {} // Public no-arg constructor for deserialization

    public CricketScore(String playername, long score, int century, int wicket) {
        this.playername = playername;
        this.score = score;
        this.century = century;
        this.wicket = wicket;
    }

    // Getters and Setters
    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public int getCentury() {
        return century;
    }

    public void setCentury(int century) {
        this.century = century;
    }

    public int getWicket() {
        return wicket;
    }

    public void setWicket(int wicket) {
        this.wicket = wicket;
    }
}

public class ScoreboardJacksonSerialization {
    public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

    	CricketScore cobj = new CricketScore("Vineeth", 12000, 25, 170);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("fos.json"), cobj);
            System.out.println("JSON file created successfully.");
    }
}
