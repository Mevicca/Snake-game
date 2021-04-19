package entity;

import ADT.ArrayList;
import ADT.ListInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the temp late in the editor.
 */
/**
 *
 * @author Mevicca
 */
public class Role {

    private ListInterface<Coordinate> coord = new ArrayList<>(150);

    public Role() {

    }

    public Role(Coordinate[] coordinate) {
        coord.clear();
        setCoordinate(coordinate);
    }

    public Coordinate[] getCoordinate() {
        Object[] obj = coord.toArray();
        Coordinate[] coordArray = new Coordinate[coord.length()];
        for (int i = 0; i < coordArray.length; i++) {
            if (obj[i] == null) {
                break;
            }
            coordArray[i] = Coordinate.class.cast(obj[i]);
        }
        return coordArray;
    }

    public Coordinate getCoordinate(int index) {
        if (coord.length() == 0) {
            return null;
        }
        return coord.getEntry(index);
    }

    public void setCoordinate(Coordinate[] coordinate) {
        for (var c : coordinate) {
            coord.add(c);
        };
    }

    public void setCoordinate(Coordinate coordinate, int index) {
        if (index == coord.length()) {
            coord.add(coordinate);
        } else {
            coord.setEntry(index, coordinate);
        }
    }

    public int getLength() {
        return coord.length();
    }

    public void clear() {
        coord.clear();
    }
}
