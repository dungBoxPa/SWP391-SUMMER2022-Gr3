/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Activity {
    private int     activity_id;
    private String  act_description;
    private String  act_name;

    public Activity() {
    }

    public Activity(int activity_id, String act_description, String act_name) {
        this.activity_id = activity_id;
        this.act_description = act_description;
        this.act_name = act_name;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public String getAct_description() {
        return act_description;
    }

    public void setAct_description(String act_description) {
        this.act_description = act_description;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    @Override
    public String toString() {
        return "Activity{" + "activity_id=" + activity_id + ", act_description=" + act_description + ", act_name=" + act_name + '}';
    }
    
    
}
