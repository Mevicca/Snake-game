package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *
 */
public class Player {

    private String playerName;
    private String password;
    private int totalNumberOfGame;
    private int highestMark;

    public Player(String playerName, String password) {
        this.playerName = playerName;
        this.password = password;
        this.totalNumberOfGame = 0;
        this.highestMark = 0;
    }

    public Player(String playerName, String password, int totalNumberOfGame, int highestMark) {
        this.playerName = playerName;
        this.password = password;
        this.totalNumberOfGame = totalNumberOfGame;
        this.highestMark = highestMark;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalNumberOfGame() {
        return totalNumberOfGame;
    }

    public void setTotalNumberOfGame(int totalNumberOfGame) {
        this.totalNumberOfGame = totalNumberOfGame;
    }

    public int getHighestMark() {
        return highestMark;
    }

    public void setHighestMark(int highestMark) {
        this.highestMark = highestMark;
    }

    @Override
    public boolean equals(Object obj) {
        Player cmpObj = (Player) obj;

        if (cmpObj.getPlayerName().equals(playerName) && cmpObj.getPassword().equals(password)) {
            return true;
        }
        return false; //represent cannot find value
    }

}
