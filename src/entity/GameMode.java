package entity;

public class GameMode {

    private String type;
    private int difficulty;
    private double rateMultiply;

    public GameMode() {
    }

    public GameMode(String type, int difficulty, double rateMultiply) {
        this.type = type;
        this.difficulty = difficulty;
        this.rateMultiply = rateMultiply;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public double getRateMultiply() {
        return rateMultiply;
    }

    public void setRateMultiply(double rateMultiply) {
        this.rateMultiply = rateMultiply;
    }

    @Override
    public String toString() {
        return "GameMode{" + ", type=" + type + ", difficulty=" + difficulty + ", rateMultiply=" + rateMultiply + '}';
    }

}
