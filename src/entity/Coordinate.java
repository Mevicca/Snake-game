package entity;

import adt.HashSet;
import java.util.Random;
import adt.HashSetInterface;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate() {

    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate generateRandomCoordinate() {
        Random random = new Random();
        int coordinateX;
        int coordinateY;

        do {
            coordinateX = random.nextInt(850 / 25) * 25; // because 25coord = 1 unit in maps
            coordinateY = random.nextInt(555 / 25) * 25;
        } while (coordinateX < 50 || coordinateY < 100);

        return new Coordinate(coordinateX, coordinateY);
    }

    public Coordinate[] generateLShapeObstacle(int noOfObstacle) {
        HashSetInterface<Coordinate> coordExist = new HashSet<>();

        Coordinate[] obstacle = new Coordinate[]{
            new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0),
            new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0),
            new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0),
            new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0)
        };

        for (int index = 0; index < noOfObstacle; index++) {
            if (index == 0) {
                Param param = generateOneObstacle(coordExist);
                for (int i = 0; i < 8; i++) {
                    obstacle[i] = param.coord[i];
                }
            } else {
                Param param = generateOneObstacle(coordExist);
                for (int i = 8; i < 16; i++) {
                    obstacle[i] = param.coord[i - 8];
                }
            }
            //validate
        }
        return obstacle;
    }

    private class Param {

        Coordinate[] coord;
        HashSetInterface coordExist;

        public Param(Coordinate[] coord, HashSetInterface coordExist) {
            this.coord = coord;
            this.coordExist = coordExist;
        }

    }

    public Param generateOneObstacle(HashSetInterface<Coordinate> coordExist) {
        boolean isDuplicate = false;
        //generate it before the game starting
        Coordinate[] obstacle = new Coordinate[]{
            new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0),
            new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0)
        };

        do {
            do {
                obstacle[0] = generateRandomCoordinate();
            } while (obstacle[0].getX() < 150 || obstacle[0].getY() < 150
                    || obstacle[0].getX() > 475 || obstacle[0].getY() > 600);//AVOID OUT OF THE GAME

            Random random = new Random();
            int pattern = random.nextInt(3);

            //add validation to aviod out of the frame
            switch (pattern) {
                case 0:
                    //right
                    for (int i = 1; i < 5; i++) {//vertical
                        obstacle[i].setX(obstacle[i - 1].getX() + 25);
                        obstacle[i].setY(obstacle[0].getY());
                    }
                    for (int i = 5; i < 8; i++) {//horizontal
                        obstacle[i].setY(obstacle[i - 1].getY() - 25);
                        obstacle[i].setX(obstacle[4].getX());
                    }
                    break;
                case 1:
                    //left
                    for (int i = 1; i < 5; i++) {
                        obstacle[i].setX(obstacle[i - 1].getX() - 25);
                        obstacle[i].setY(obstacle[0].getY());
                    }
                    for (int i = 5; i < 8; i++) {
                        obstacle[i].setY(obstacle[i - 1].getY() - 25);
                        obstacle[i].setX(obstacle[4].getX());
                    }
                    break;
                case 2:
                    //down
                    for (int i = 1; i < 5; i++) {
                        obstacle[i].setY(obstacle[i - 1].getY() + 25);
                        obstacle[i].setX(obstacle[0].getX());
                    }
                    for (int i = 5; i < 8; i++) {
                        obstacle[i].setX(obstacle[i - 1].getX() - 25);
                        obstacle[i].setY(obstacle[4].getY());
                    }
                    break;
                case 3:
                    for (int i = 1; i < 5; i++) {
                        obstacle[i].setY(obstacle[i - 1].getY() - 25);
                        obstacle[i].setX(obstacle[0].getX());
                    }
                    for (int i = 5; i < 8; i++) {
                        obstacle[i].setX(obstacle[i - 1].getX() - 25);
                        obstacle[i].setY(obstacle[4].getY());
                    }
                    break;
                default:
                    break;
            }

            if (coordExist != null) {
                for (Coordinate obstacleCoor : obstacle) {
                    isDuplicate = coordExist.contains(obstacleCoor);
                }
            }
        } while (isDuplicate);

        if (coordExist.add(obstacle)) {
            return new Param(obstacle, coordExist);
        }

        return new Param(null, coordExist);

    }

    @Override
    public boolean equals(Object obj) {
        Coordinate cmpObj = (Coordinate) obj;
        if (cmpObj.getX() == x && cmpObj.getY() == y) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    public String toString() {
        return x + "," + y + "\n";
    }

}
