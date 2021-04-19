package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 霆翔
 */

public class Media<T> {
    private String name;
    private String path;


    public Media(){
    }
    
    public Media (String name, String path){
        this.name = name;
        this.path = path;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath(){
        return path;
    }
     
    public void setPath(String path){
        this.path = path;
    }
    
    public boolean equals(Object keyword){
        return name.equals(keyword);
    }
}
