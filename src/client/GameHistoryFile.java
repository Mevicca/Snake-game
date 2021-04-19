package client;

import entity.GameHistory;
import ADT.ArrayList;
import ADT.ListInterface;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.OutputStream;
import java.time.LocalDateTime;

public class GameHistoryFile {

    private static ListInterface<GameHistory> gameList = new ArrayList<GameHistory>();
    public static String fileName = "gameHistory.bin";

    public static void appendToBinary(String fileName, GameHistory nGame, boolean append) {
        File file = new File(fileName);
        ObjectOutputStream out = null;

        try {
            if (!file.exists() || !append) {
                out = new ObjectOutputStream(new FileOutputStream(fileName));
            } else {
                out = new AppendableObjectOutputStream(new FileOutputStream(fileName, append));
            }
            out.writeObject(nGame);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Successful");
    }

    public static void readFromBinaryFile(String fileName) {
        File file = new File(fileName);
        gameList.clear();

        if (file.exists()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(fileName));

                while (true) {
                    GameHistory game = (GameHistory) ois.readObject();
                    gameList.add(game);
                }
            } catch (EOFException e) {
                //catch end of file
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {

        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
        }
    }

    public int autoSetGameID() {
        readFromBinaryFile(fileName);
        int setID = 0;
        setID = 1000 + gameList.length();
        System.out.println(setID);
        return setID;
    }

    public void setHistory(String pName, String type, LocalDateTime startTime, LocalDateTime endTime, int score) {
        GameHistory newGame = new GameHistory(autoSetGameID(), pName, type, startTime, endTime, score);
        appendToBinary(fileName, newGame, true);
    }
}
