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
public class Food extends Role{
    private int foodID;
    private String foodName;
    private int point;

    public Food(int foodID, String foodName, int point, Coordinate[] coordinate) {
        super(coordinate);
        this.foodID = foodID;
        this.foodName = foodName;
        this.point = point;
    }
    
    public Food(){
        
    }
    
    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    
}
