package entity;

import adt.HashSetInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mevicca
 */
public class GameMap {

    private double score = 0;
    private Snake snake;
    private Food food;
    private Buff goodBuff;
    private Buff badBuff;
    public static Theme currentTheme;
    public static Media currentMedia;
    public static GameMode currentMode;

    private Coordinate[] lShapeObstacle;

    public GameMap(){
        
    }
    
    public GameMap(Theme currentTheme, Media currentMedia, GameMode currentMode) {
        food = new Food();
        snake = new Snake();
        goodBuff = new Buff();
        badBuff = new Buff();
        this.currentTheme = currentTheme;
        this.currentMedia = currentMedia;
        this.currentMode = currentMode;
    }

    public Buff getGoodBuff() {
        return goodBuff;
    }

    public void setGoodBuff(Buff goodBuff) {
        this.goodBuff = goodBuff;
    }

    public Buff getBadBuff() {
        return badBuff;
    }

    public void setBadBuff(Buff badBuff) {
        this.badBuff = badBuff;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Theme getCurrentTheme(){
        return currentTheme;
    }
    public Coordinate[] getlShapeObstacle() {
        return lShapeObstacle;
    }

    public void setlShapeObstacle(Coordinate[] lShapeObstacle) {
        this.lShapeObstacle = lShapeObstacle;
    }

    public HashSetInterface<Coordinate> addMarks(String directionStr, HashSetInterface<Coordinate> loseObj, double rate) {
        Coordinate[] currentCoordinate = snake.getCoordinate();//snake
        Coordinate foodCoor = food.getCoordinate(0);//assume food length=1
        Coordinate goodBuffCoor = goodBuff.getCoordinate(0);

        //checking the snake eat
        if (currentCoordinate[0].getX() == foodCoor.getX() && currentCoordinate[0].getY() == foodCoor.getY()) {
            Coordinate lastCoor = new Coordinate();
            switch (directionStr) {
                case "Right": {
                    lastCoor = new Coordinate(currentCoordinate[snake.getLength() - 1].getX() - 25, currentCoordinate[snake.getLength() - 1].getY());
                    break;
                }
                case "Left": {
                    lastCoor = new Coordinate(currentCoordinate[snake.getLength() - 1].getX() + 25, currentCoordinate[snake.getLength() - 1].getY());
                    break;
                }
                case "Up": {
                    lastCoor = new Coordinate(currentCoordinate[snake.getLength() - 1].getX(), currentCoordinate[snake.getLength() - 1].getY() + 25);
                    break;
                }
                case "Down": {
                    lastCoor = new Coordinate(currentCoordinate[snake.getLength() - 1].getX(), currentCoordinate[snake.getLength() - 1].getY() - 25);
                    break;
                }
                default: {
                    break;
                }
            }

            snake.setCoordinate(lastCoor, snake.getLength());
            
            if(snake.getLength()+1 == snake.getCoordinate().length){//compare with the current
                snake.setLength(snake.getLength()+1);
            }
            
            loseObj.add(lastCoor);
            food.clear();
            score += (1 * rate);
        }

        if (currentCoordinate[0].getX() == goodBuffCoor.getX() && currentCoordinate[0].getY() == goodBuffCoor.getY()) {
            goodBuff.setCoordinate(new Coordinate[]{});
            goodBuff.clear();
            score += (goodBuff.getPoint() * rate);
        }
        return loseObj;
    }

    public void deductMarks(double rate) {
        Coordinate[] currentCoordinate = snake.getCoordinate();//snake
        Coordinate badBuffCoor = badBuff.getCoordinate(0);

        //checking the snake eat
        if (currentCoordinate[0].getX() == badBuffCoor.getX() && currentCoordinate[0].getY() == badBuffCoor.getY()) {
            badBuff.setCoordinate(new Coordinate[]{});
            badBuff.clear();
            double currentMark = score - (badBuff.getPoint() * rate);
            score = (currentMark < 0 ? 0 : currentMark);
        }
    }

}
