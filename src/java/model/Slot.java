/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Slot {
    private int slot_id; 
    private float start_hour; 
    private float end_hour; 

    public Slot() {
    }

    public Slot(int slot_id, float start_hour, float end_hour) {
        this.slot_id = slot_id;
        this.start_hour = start_hour;
        this.end_hour = end_hour;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public float getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(float start_hour) {
        this.start_hour = start_hour;
    }

    public float getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(float end_hour) {
        this.end_hour = end_hour;
    }

    @Override
    public String toString() {
        return "Table_Slot{" + "slot_id=" + slot_id + ", start_hour=" + start_hour + ", end_hour=" + end_hour + '}';
    }
    
    
}
