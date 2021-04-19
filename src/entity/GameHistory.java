package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GameHistory implements Comparable<GameHistory>, Serializable {

    private int gameID;
    private String pName;
    private String type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int score;

    public GameHistory() {
    }

    public GameHistory(int gameID, String pName, String type, LocalDateTime startTime, LocalDateTime endTime, int score) {
        this.gameID = gameID;
        this.pName = pName;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.score = score;
    }

    public GameHistory(String pName, String type, LocalDateTime startTime, LocalDateTime endTime, int score) {
        this.pName = pName;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.score = score;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return gameID + "      " + pName + "   " + type + "    " + startTime + "   " + endTime + "     " + score;
    }

    public int compareTo(GameHistory game) {

        if (this.score == game.score) {
            return 0;
        } else if (this.score > game.score) {
            return -1;
        } else {
            return 1;
        }
    }
}
