package entity;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mevicca
 */
public class Buff extends Role{
    private int buffID;
    private String buffName;
    private int point;

    public Buff(){
        
    }
    
    public Buff(int buffID, String buffName, int point) {
        this.buffID = buffID;
        this.buffName = buffName;
        this.point = point;
    }

    public Buff(int buffID, String buffName, int point, Coordinate[] coordinate) {
        super(coordinate);
        this.buffID = buffID;
        this.buffName = buffName;
        this.point = point;
    }
    
    public int getBuffID() {
        return buffID;
    }
    
    public void setBuffID(int buffID) {
        this.buffID = buffID;
    }

    public String getBuffName() {
        return buffName;
    }

    public void setBuffName(String buffName) {
        this.buffName = buffName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    
    
}
