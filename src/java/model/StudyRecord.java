/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Windows 10 TIMT
 */
public class StudyRecord {

    private int studyRecord_id, class_id, kinder_id, study_year;

    public StudyRecord() {
    }

    public StudyRecord(int studyRecord_id, int class_id, int kinder_id, int study_year) {
        this.studyRecord_id = studyRecord_id;
        this.class_id = class_id;
        this.kinder_id = kinder_id;
        this.study_year = study_year;
    }

    public int getStudyRecord_id() {
        return studyRecord_id;
    }

    public void setStudyRecord_id(int studyRecord_id) {
        this.studyRecord_id = studyRecord_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getKinder_id() {
        return kinder_id;
    }

    public void setKinder_id(int kinder_id) {
        this.kinder_id = kinder_id;
    }

    public int getStudy_year() {
        return study_year;
    }

    public void setStudy_year(int study_year) {
        this.study_year = study_year;
    }

    @Override
    public String toString() {
        return "StudyRecord{" + "studyRecord_id=" + studyRecord_id + ", class_id=" + class_id + ", kinder_id=" + kinder_id + ", study_year=" + study_year + '}';
    }

}
