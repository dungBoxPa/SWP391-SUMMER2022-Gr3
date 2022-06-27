/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Schedule {
    private int     schedule_id;
    private int     class_id;
    private int     activity_id;
    private int     slot_id;
    private String  schedule_date;

    public Schedule() {
    }

    public Schedule(int schedule_id, int class_id, int activity_id, int slot_id, String schedule_date) {
        this.schedule_id = schedule_id;
        this.class_id = class_id;
        this.activity_id = activity_id;
        this.slot_id = slot_id;
        this.schedule_date = schedule_date;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    @Override
    public String toString() {
        return "Schedule{" + "schedule_id=" + schedule_id + ", class_id=" + class_id + ", activity_id=" + activity_id + ", slot_id=" + slot_id + ", schedule_date=" + schedule_date + '}';
    }
    
    
}
