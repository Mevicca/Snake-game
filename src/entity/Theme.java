package entity;

import java.util.Objects;

public class Theme{
    private String colorChoice;
    private String rMouth;
    private String lMouth;
    private String dMouth;
    private String uMouth;
    private String sBody;
    private String enemy;

    public Theme(String colorChoice, String rMouth, String lMouth, String dMouth, String uMouth, String sBody, String enemy) {
        this.colorChoice = colorChoice;
        this.rMouth = rMouth;
        this.lMouth = lMouth;
        this.dMouth = dMouth;
        this.uMouth = uMouth;
        this.sBody = sBody;
        this.enemy = enemy;
    }

    public String getColorChoice() {
        return colorChoice;
    }

    public void setColorChoice(String colorChoice) {
        this.colorChoice = colorChoice;
    }    

    public String getrMouth() {
        return rMouth;
    }

    public void setrMouth(String rMouth) {
        this.rMouth = rMouth;
    }

    public String getlMouth() {
        return lMouth;
    }

    public void setlMouth(String lMouth) {
        this.lMouth = lMouth;
    }

    public String getdMouth() {
        return dMouth;
    }

    public void setdMouth(String dMouth) {
        this.dMouth = dMouth;
    }

    public String getuMouth() {
        return uMouth;
    }

    public void setuMouth(String uMouth) {
        this.uMouth = uMouth;
    }

    public String getsBody() {
        return sBody;
    }

    public void setsBody(String sBody) {
        this.sBody = sBody;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    @Override
    public String toString() {
        return "Settings{" + "colorChoice=" + colorChoice + ", rMouth=" + rMouth + ", lMouth=" + lMouth + ", dMouth=" + dMouth + ", uMouth=" + uMouth + ", sBody=" + sBody + ", enemy=" + enemy + '}';
    }

    @Override
    public boolean equals(Object color) {
        return color.equals(colorChoice);
    }
}