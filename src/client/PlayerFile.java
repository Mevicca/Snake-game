/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedList;
import adt.LinkedListInterface;
import entity.Player;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Mevicca
 */
public class PlayerFile {

    public LinkedList<Player> reader(String fileName) {
        LinkedList<Player> playerList = new LinkedList<>();
        BufferedReader reader = null;
        try {
            String currentLine;
            reader = new BufferedReader(new FileReader(fileName));

            while ((currentLine = reader.readLine()) != null) {
                //read from file and write to List
                String[] playerDetails = currentLine.split("\\s"); // separate the string by white space(\\s)
                String name = playerDetails[0];
                String pw = playerDetails[1];
                int numOfGame = Integer.parseInt(playerDetails[2]);
                int highestMarks = Integer.parseInt(playerDetails[3]);
                Player player = new Player(name, pw, numOfGame, highestMarks);
                playerList.add(player);
            }

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return playerList;
    }

    public LinkedList<Player> update(int numOfGames, int highestMark,Player obj, String fileName) {
        LinkedList<Player> playerList = reader("player.txt");
        try {
            int index = playerList.getIndex(obj); //which player
            if (index == -1) {
                throw new Exception("Error 404");
            } else {
                Player playerFound = playerList.getEntry(index);
                playerFound.setTotalNumberOfGame(numOfGames);
                playerFound.setHighestMark(highestMark);
                playerList.replace(index, playerFound);
            }
            UpdateTextFiles(fileName, playerList);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return playerList;
    }

    private LinkedList<Player> UpdateTextFiles(String fileName, LinkedList<Player> playerList) {
        BufferedWriter writer = null;
        BufferedReader reader = null;
        String currentLine;

        try {
            PrintWriter writer1 = new PrintWriter(fileName);
            writer1.print("");
            writer1.close();
            reader = new BufferedReader(new FileReader(fileName));
            writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i = 0; i < playerList.getLength(); i++) {
                Player player = playerList.getEntry(i);
                writer.write(player.getPlayerName() + " " + player.getPassword() + " " + player.getTotalNumberOfGame() + " " + player.getHighestMark());
                writer.newLine();

            }
            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
        return playerList;
    }
}
