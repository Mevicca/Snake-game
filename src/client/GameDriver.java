package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entity.GameMap;
import entity.PanelEnum;
import entity.Snake;
import entity.DirectionEnum;
import entity.Coordinate;
import entity.Food;
import adt.HashSet;
import adt.SortedListInterface;
import entity.Buff;
import entity.GameHistory;
import entity.GameMode;
import entity.Player;
import entity.Theme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import adt.HashSetInterface;
import entity.Media;

/**
 *
 * @author Mevicca
 */
public class GameDriver extends JPanel implements KeyListener, ActionListener {

    int temp = 0;

    private ImageIcon titleImage;
    private LocalDateTime startTime;
    private LocalDateTime startPauseTime = null;
    private static int pauseDuration = 0;

    //used to control the BACKGROUND IMAGE and MUSIC 
    private boolean isGameOver = false;
    private boolean havePlayBefore = false;//the music player had been played
    private boolean isPause = false;//the game is pause
    private boolean wasUpdated = false;//was update the current game in the file and background
    private boolean pressedF1 = false;
    private boolean pressedF2 = false;
    private boolean inRankList = false;//the new record has been stored into the rank list

    private Clip clip;
    private Duration differenceTime;

    private GameMap gamemap;
    private Coordinate generateCoor = new Coordinate();

    private ImageIcon rightMouth;
    private ImageIcon leftMouth;
    private ImageIcon downMouth;
    private ImageIcon upMouth;
    private ImageIcon body;
    private ImageIcon foodImage;
    private ImageIcon goodBuffImage;
    private ImageIcon badBuffImage;

    private int moves = 0;
    private DirectionEnum direction;
    private String directionStr = "";
    private Timer timer;
    private int delay = 100;

    private Player currentPlayer;

    HashSetInterface<Coordinate> loseObj;

    //add parameter
    public GameDriver(Player currentPlayer, GameMode currentMode, Theme currentSetting, Media currentMedia) {
        this.currentPlayer = currentPlayer;
        gamemap.currentTheme = currentSetting;
        gamemap.currentMedia = currentMedia;
        gamemap.currentMode = currentMode;

        gamemap = new GameMap(gamemap.currentTheme, currentMedia, currentMode);
        directionStr = direction.Right.name();
        popGameStart();
        playMusic(currentMedia.getPath());
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        startTime = LocalDateTime.now();
        timer = new Timer(delay, this);
        timer.start();
    }

    public void popGameStart() {
        JOptionPane gameStart = new JOptionPane("Game Start", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = gameStart.createDialog(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                Timer time = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });
                time.start();
            }
        });
        dialog.setVisible(true);
    }

    public boolean validateDuplicate(Coordinate coor) {
        Coordinate[] lShapeObstacle = gamemap.getlShapeObstacle();
        Coordinate goodBuff = gamemap.getGoodBuff().getCoordinate(0);
        Coordinate badBuff = gamemap.getBadBuff().getCoordinate(0);

        //check the food
        for (int i = 0; i < lShapeObstacle.length; i++) { //check the L shape obstacle
            if (coor.getX() == lShapeObstacle[i].getX() && coor.getY() == lShapeObstacle[i].getY()) {
                return false;//represent duplicate
            }
        }

        if (goodBuff != null && coor.getX() == goodBuff.getX() && coor.getY() == goodBuff.getY()) {
            return false;//represent duplicate
        }

        if (badBuff != null && coor.getX() == badBuff.getX() && coor.getY() == badBuff.getY()) {
            return false;//represent duplicate
        }

        return true;
    }

    public void drawSnake(Graphics g) {
        Coordinate[] currentCoordinate = gamemap.getSnake().getCoordinate();
        for (int a = 0; a < currentCoordinate.length; a++) {
            if (a == 0) {
                switch (directionStr) {
                    case "Right":
                        rightMouth = new ImageIcon(gamemap.currentTheme.getrMouth());
                        rightMouth.paintIcon(this, g, currentCoordinate[0].getX(), currentCoordinate[0].getY());
                        break;
                    case "Left":
                        leftMouth = new ImageIcon(gamemap.currentTheme.getlMouth());
                        leftMouth.paintIcon(this, g, currentCoordinate[0].getX(), currentCoordinate[0].getY());
                        break;
                    case "Down":
                        downMouth = new ImageIcon(gamemap.currentTheme.getdMouth());
                        downMouth.paintIcon(this, g, currentCoordinate[0].getX(), currentCoordinate[0].getY());
                        break;
                    case "Up":
                        upMouth = new ImageIcon(gamemap.currentTheme.getuMouth());
                        upMouth.paintIcon(this, g, currentCoordinate[0].getX(), currentCoordinate[0].getY());
                        break;
                    default:
                        rightMouth = new ImageIcon(gamemap.currentTheme.getrMouth());
                        rightMouth.paintIcon(this, g, currentCoordinate[0].getX(), currentCoordinate[0].getY());
                        break;
                }
            } else {
                body = new ImageIcon(gamemap.currentTheme.getsBody());
                body.paintIcon(this, g, currentCoordinate[a].getX(), currentCoordinate[a].getY());
            }
        }
    }

    public void drawFood(Graphics g) {
        foodImage = new ImageIcon(gamemap.currentTheme.getEnemy());
        //assume one food
        Coordinate foodCoor = gamemap.getFood().getLength() > 0 ? gamemap.getFood().getCoordinate(0) : null;
        //can't overwrite the wall
        if (foodCoor == null) {
            boolean isNotDouble = true;
            do {
                foodCoor = generateCoor.generateRandomCoordinate();
                isNotDouble = validateDuplicate(foodCoor);
            } while (!isNotDouble);

            gamemap.getFood().setCoordinate(new Coordinate[]{foodCoor});
        }
        foodImage.paintIcon(this, g, foodCoor.getX(), foodCoor.getY());
    }

    public void drawObstacle(Graphics g) {
        Coordinate[] lShapeObstacle = gamemap.getlShapeObstacle();
        ImageIcon icon = new ImageIcon("src/resources/greyBricks.jpg");
        //paint the obstacle
        if (lShapeObstacle != null) {
            for (int a = 0; a < lShapeObstacle.length; a++) {
                if (lShapeObstacle[a].getX() != 0 || lShapeObstacle[a].getY() != 0) {
                    icon.paintIcon(this, g, lShapeObstacle[a].getX(), lShapeObstacle[a].getY());
                }
            }
        }
    }

    public void drawBuff(Graphics g) {
        goodBuffImage = new ImageIcon("src/resources/apple.png");
        badBuffImage = new ImageIcon("src/resources/boom.png");

        Coordinate goodBuffCoor = gamemap.getGoodBuff().getLength() > 0 ? gamemap.getGoodBuff().getCoordinate(0) : null;
        Coordinate badBuffCoor = gamemap.getBadBuff().getLength() > 0 ? gamemap.getBadBuff().getCoordinate(0) : null;
        //can't overwrite the wall
        if (goodBuffCoor == null) {
            boolean isNotDouble = true;
            do {
                goodBuffCoor = generateCoor.generateRandomCoordinate();
                isNotDouble = validateDuplicate(goodBuffCoor);
            } while (!isNotDouble);

            gamemap.getGoodBuff().setCoordinate(new Coordinate[]{goodBuffCoor});
        }
        if (badBuffCoor == null) {
            boolean isNotDouble = true;
            do {
                badBuffCoor = generateCoor.generateRandomCoordinate();
                isNotDouble = validateDuplicate(badBuffCoor);
            } while (!isNotDouble);

            gamemap.getBadBuff().setCoordinate(new Coordinate[]{badBuffCoor});
        }

        goodBuffImage.paintIcon(this, g, goodBuffCoor.getX(), goodBuffCoor.getY());
        badBuffImage.paintIcon(this, g, badBuffCoor.getX(), badBuffCoor.getY());

    }

    public void gameOver(Graphics g) {
        LeaderboardDriver board = new LeaderboardDriver();
        SortedListInterface<GameHistory> rankList = board.getRankList(gamemap.currentMode.getType());
        inRankList = false;//create new record or not
        GameHistory currentGame = new GameHistory();

        //invoke the gameover if it is first time, bcz the gameOver always inifinity loop in the paint method
        //Use to update into the gamehistoryfile
        if (!wasUpdated) {
            GameHistoryFile file = new GameHistoryFile();
            currentGame = new GameHistory(currentPlayer.getPlayerName(), gamemap.currentMode.getType(), startTime, LocalDateTime.now(), (int) gamemap.getScore());
            file.setHistory(currentGame.getpName(), currentGame.getType(), currentGame.getStartTime(), currentGame.getEndTime(), currentGame.getScore());
        }

        //if the rankList get from the binary file more than 0
        //only loop 10 times or less than 10
        //invoke the message and return menu if the current Game score is higher than one of the record in the list
        if (rankList.getLength() > 0) {
            int size = rankList.getLength() > 10 ? 10 : rankList.getLength();
            for (int i = 1; i <= size; i++) {
                GameHistory rank = rankList.getEntry(i);
                if ((currentGame.getScore() > rank.getScore()) && (!isGameOver))//represent create new record
                {
                    //RESET
                    isGameOver = true;
                    directionStr = "";
                    pauseDuration = 0;
                    loseObj.clear();
                    stopMusic(0);
                    inRankList = true;
                    if (!wasUpdated) {
                        PlayerFile playerFileControl = new PlayerFile();
                        playerFileControl.update(currentPlayer.getTotalNumberOfGame() + 1, (int) gamemap.getScore(), currentPlayer, "player.txt");

                        wasUpdated = true;
                    }

                    JOptionPane.showMessageDialog(null,
                            board.displayStatus(currentPlayer.getPlayerName(), i, gamemap.currentMode.getType()),
                            "Congrat", JOptionPane.INFORMATION_MESSAGE);

                    Main menu = new Main();
                    menu.changePane(PanelEnum.Leaderboard);
                    break;
                }
            }
        }
        //if the player did not create new record in leaderboard but higher than the previous marks and also under NORMAL mode
        //will invoke the fireworks
        if (!inRankList && (gamemap.getScore() > currentPlayer.getHighestMark()) && gamemap.currentMode.getType().equals("NORMAL")) {
            currentPlayer.setHighestMark((int) gamemap.getScore());

            //return another background if the highest score achieve
            ImageIcon gameOverImg = new ImageIcon("src/resources/firework.jpg");
            gameOverImg.paintIcon(this, g, 260, 200);

            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 30));
            g.drawString("CONGRATULATION", 300, 250);
            g.drawString("HIGHEST MARK : " + currentPlayer.getHighestMark(), 300, 300);

            g.setFont(new Font("arial", Font.BOLD, 20));
            g.drawString("Space to RESTART", 350, 350);
            g.drawString("B to back menu", 350, 370);

            if (!wasUpdated) {
                PlayerFile playerFileControl = new PlayerFile();
                playerFileControl.update(currentPlayer.getTotalNumberOfGame() + 1, (int) gamemap.getScore(), currentPlayer, "player.txt");

                wasUpdated = true;
            }

        } else {
            //not achieve the previous highest mark and also did not go inside the leaderboard
            ImageIcon gameOverImg = new ImageIcon("src/resources/bomb.jpg");
            gameOverImg.paintIcon(this, g, 260, 200);

            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 50));
            g.drawString("GAME OVER", 300, 300);

            g.setFont(new Font("arial", Font.BOLD, 20));
            g.drawString("Space to RESTART", 350, 350);
            g.drawString("B to back menu", 350, 370);

            if (!wasUpdated) {
                PlayerFile playerFileControl = new PlayerFile();
                playerFileControl.update(currentPlayer.getTotalNumberOfGame() + 1, currentPlayer.getHighestMark(), currentPlayer, "player.txt");
                wasUpdated = true;
            }
        }
        //reset the mode if the game is OVER
        isGameOver = true;
        directionStr = "";
        pauseDuration = 0;
        startTime = null;
        loseObj.clear();
    }

    public void pause(Graphics g) {
        //while press F1 OR F2
        ImageIcon pauseImg = new ImageIcon("src/resources/pause.jpg");
        pauseImg.paintIcon(this, g, 250, 200);

        g.setColor(Color.lightGray);

        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("Press F1 to CONTINUE", 350, 400);

    }

    public void checkCrashing(Graphics g) {
        try {
            Coordinate head = gamemap.getSnake().getCoordinate(0);
            //crashing the bricks & itself
            if (loseObj != null && loseObj.contains(head) || (isGameOver)) {
                gameOver(g);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void initialize() {
        //initialize the food, buff, snake and also the obstacle
        Snake snake = gamemap.getSnake();
        loseObj = new HashSet<Coordinate>();

        Coordinate[] initCoordinates = new Coordinate[]{
            new Coordinate(100, 100),
            new Coordinate(75, 100),
            new Coordinate(50, 100)
        };

        //buff
        gamemap.setGoodBuff(new Buff(1, "Fruit", 3, new Coordinate[]{}));
        gamemap.setBadBuff(new Buff(2, "Bomb", 2, new Coordinate[]{}));

        //food
        gamemap.setFood(new Food(1, "Healthy food", 3, new Coordinate[]{}));

        //snake
        snake.setCoordinate(initCoordinates);
        snake.setLength(3);
        gamemap.setSnake(snake);

        //obstacle
        Coordinate[] lShapeObstacle = generateCoor.generateLShapeObstacle(gamemap.currentMode.getDifficulty());
        gamemap.setlShapeObstacle(lShapeObstacle);
        loseObj.add(lShapeObstacle);

        //add to the hashset
        loseObj.add(initCoordinates[1]);
        loseObj.add(initCoordinates[2]);

        //restore to "havent update" variable
        wasUpdated = false;

        directionStr = direction.Right.name();

    }

    public void drawBackground(Graphics g) {
        //draw title background
        ImageIcon background = new ImageIcon("src/resources/bricks.jpg");
        background.paintIcon(this, g, 0, 0);

        //draw title image border
        g.setColor(Color.DARK_GRAY);
        g.drawRect(360, 9, 210, 58);

        //draw the title image
        titleImage = new ImageIcon("src/resources/logo.png");
        titleImage.paintIcon(this, g, 360, 11);

        //draw border
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 552);

        //draw background
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 550);

        //draw instruction
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("F1 - Pause", 25, 40);
        g.drawString("F2 - Back to Menu", 25, 55);

        //time
        g.setColor(Color.WHITE);
        g.setFont(new Font("sans serif", Font.BOLD, 14));

        g.drawString("Length :" + gamemap.getSnake().getLength(), 780, 10);
        if (!isGameOver) {
            differenceTime = Duration.between(startTime, LocalDateTime.now());
        }

        //control the time
        if (gamemap.currentMode.getType() == "NORMAL") {
            g.drawString("Highest mark before: " + currentPlayer.getHighestMark(), 720, 25);
            String str = isPause ? "Time used : -" : ("Time used: " + (differenceTime.toSeconds() - pauseDuration));
            g.drawString(str, 780, 40);

        } else {
            String str = isPause ? "Time remaining : -" : ("Time remaining: " + (60 - differenceTime.toSeconds() + pauseDuration));
            g.drawString(str, 720, 40);
        }

        //current scores in real time
        g.drawString("Scores: " + gamemap.getScore(), 780, 55);
    }

    @Override
    public void paint(Graphics g) {
        if (moves == 0) {//initialize
            initialize();
        }

        if (!isPause) {//NOT F1 or F2 mode
            if (isGameOver && !havePlayBefore) {//currently Game over and the music havent play before
                stopMusic(0);
                playMusic("src/resources/bombSound.wav");
                stopMusic(3);
                havePlayBefore = true;
            }

            Coordinate[] currentCoordinate = gamemap.getSnake().getCoordinate();
            for (int i = 1; i < currentCoordinate.length; i++) {
                if (currentCoordinate[i] == null) {
                    break;
                }
                loseObj.add(currentCoordinate[i]);
            }

            drawBackground(g);
            drawSnake(g);
            drawFood(g);
            drawBuff(g);
            drawObstacle(g);
            gamemap.addMarks(directionStr, loseObj, gamemap.currentMode.getRateMultiply());
            gamemap.deductMarks(gamemap.currentMode.getRateMultiply());
            checkCrashing(g);

            //set 1 minute
            if (gamemap.currentMode.getType() == "TIME" && differenceTime.toSeconds() - pauseDuration >= 60) {
                gameOver(g);
            }
        } else if (pressedF2) {//press F2 "go to menu" and stop at the window "are you sure to back menu"
            stopMusic(0);
            drawBackground(g);
        } else {//press F1
            pause(g);
            stopMusic(0);
        }
        g.dispose();

    }

    public void playMusic(String musiclocation) {
        File musicPath = new File(musiclocation);

        try {
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

                if (!isGameOver) {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            } else {
                throw new Exception("Can't find the file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMusic(int seconds) {
        try {
            if (clip != null) {
                Thread.sleep(seconds * 1000);
                clip.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        isPause = !isPause;
        if (!isPause) {//continue game
            pauseDuration += Duration.between(startPauseTime, LocalDateTime.now()).toSeconds();
            startPauseTime = null;
            moves++;
            playMusic(gamemap.currentMedia.getPath());
        } else {
            //pause game
            startPauseTime = LocalDateTime.now();
        }
    }

    //control snake movement
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        Snake snake = gamemap.getSnake();

        Coordinate[] coor = new Coordinate[150];
        //the game is continue run(NOT pause and game over) and make sure snake was initialize
        if (snake.getLength() != 0 && !isPause && !isGameOver) {
            for(int i=0;i<snake.getLength();i++){
                coor[i] = snake.getCoordinate(i);
            }
            //remove all the snake coordinates in the hashset for improve performance rather than clear all
            for (int i = 1; i < coor.length; i++) {
                if (coor[i] == null) {
                    break;
                }
                if (loseObj != null && !loseObj.remove(coor[i])) {
                    System.out.println(loseObj.getAllKey());
                }
            }

            try {
                //set the snake movement
                switch (directionStr) {
                    case "Right": {
                        for (int i = snake.getLength() - 2; i >= 0; i--) {
                            coor[i + 1].setY(coor[i].getY());
                        }
                        for (int i = snake.getLength() - 1; i >= 0; i--) {
                            if (i == 0) {
                                coor[i].setX(coor[i].getX() + 25);
                            } else {
                                coor[i].setX(coor[i - 1].getX());
                            }
                            if (coor[i].getX() > 850) {
                                coor[i].setX(25);
                            }
                        }
                        break;
                    }
                    case "Left": {
                        if (snake.getLength() != 0) {
                            for (int i = snake.getLength() - 2; i >= 0; i--) {
                                coor[i + 1].setY(coor[i].getY());
                            }
                            for (int i = snake.getLength() - 1; i >= 0; i--) {
                                if (i == 0) {
                                    coor[i].setX(coor[i].getX() - 25);
                                } else {
                                    coor[i].setX(coor[i - 1].getX());
                                }
                                if (coor[i].getX() < 20) {
                                    coor[i].setX(850);
                                }
                            }
                        }
                        break;
                    }
                    case "Down": {
                        for (int i = snake.getLength() - 2; i >= 0; i--) {
                            coor[i + 1].setX(coor[i].getX());
                        }
                        for (int i = snake.getLength() - 1; i >= 0; i--) {
                            if (i == 0) {
                                coor[i].setY(coor[i].getY() + 25);
                            } else {
                                coor[i].setY(coor[i - 1].getY());
                            }
                            if (coor[i].getY() > 600) {
                                coor[i].setY(75);
                            }
                        }
                        break;
                    }
                    case "Up": {
                        for (int i = snake.getLength() - 2; i >= 0; i--) {
                            coor[i + 1].setX(coor[i].getX());
                        }
                        for (int i = snake.getLength() - 1; i >= 0; i--) {
                            if (i == 0) {
                                coor[i].setY(coor[i].getY() - 25);
                            } else {
                                coor[i].setY(coor[i - 1].getY());
                            }
                            if (coor[i].getY() < 75) {
                                coor[i].setY(600);
                            }
                        }
                        break;
                    }
                    default:
                        break;
                }
                moves++;
            } catch (Exception ex) {
                System.out.println(ex.toString() + "\nSystem Error. Ready for returning to menu.");
                ex.printStackTrace();
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!isGameOver) {
            //game is currently running, and the player press the key
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT: {
                    if (directionStr != direction.Left.name()) {
                        directionStr = direction.Right.name();
                    }
                    moves++;
                    break;
                }
                case KeyEvent.VK_LEFT: {
                    if (directionStr != direction.Right.name()) {
                        directionStr = direction.Left.name();
                    }
                    moves++;
                    break;
                }
                case KeyEvent.VK_UP: {
                    if (directionStr != direction.Down.name()) {
                        directionStr = direction.Up.name();
                    }
                    moves++;
                    break;
                }
                case KeyEvent.VK_DOWN: {
                    if (directionStr != direction.Up.name()) {
                        directionStr = direction.Down.name();
                    }
                    moves++;
                    break;
                }
                case KeyEvent.VK_F1: {
                    if (!pressedF2) {//not pressed F2 before
                        pressedF1 = !pressedF1;
                        pause();
                    } else {
                        pause();
                    }
                    break;
                }
                case KeyEvent.VK_F2: {
                    if (!pressedF1) {//not pressed F1 before
                        pressedF2 = !pressedF2;
                        pause();
                        int reply = JOptionPane.showConfirmDialog(null, "Are you sure back to menu without save ?", "BACK TO MENU", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            new Main().changePane(PanelEnum.Menu);
                        } else {
                            pause();
                            pressedF2 = false;
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) { //currently gameover
            isGameOver = false;
            moves = 0;
            gamemap.setSnake(new Snake());
            startTime = LocalDateTime.now();
            gamemap.setScore(0);
            playMusic(gamemap.currentMedia.getPath());
            havePlayBefore = false;

        } else if (!isPause && e.getKeyCode() == KeyEvent.VK_B) {//currently gameover and not the pause mode
            new Main().changePane(PanelEnum.Menu);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Key Released not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
