/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.Serializable;

public class Task implements Serializable {
    private String name;
    private boolean complete = false;
    private String description;
    public Task (String name, String description){
        this.name = name;
        this.description = description;
    }
    public String getName (){
        return name;
    }
    public void setCompleted (){
        complete = true;
    }
    public int getCompleted (){
        if (complete){
            return 1;
        }
        else{
            return 0;
        }
    }
    public String toString (){
        return name;
    }
    public String getDescription(){
        return description;
    }
    
}
