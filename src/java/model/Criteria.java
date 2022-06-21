/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Criteria {
    private int criteria_id;
    private String content;

    public Criteria() {
    }

    public Criteria(int criteria_id, String content) {
        this.criteria_id = criteria_id;
        this.content = content;
    }

    public int getCriteria_id() {
        return criteria_id;
    }

    public void setCriteria_id(int criteria_id) {
        this.criteria_id = criteria_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Criteria{" + "criteria_id=" + criteria_id + ", content=" + content + '}';
    }
    
    
}
