/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Feedback;
import model.Kindergartner;
import model.StudyRecord;

/**
 *
 * @author Windows 10 TIMT
 */
public class StudentDAO {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public List<Kindergartner> getAllStudent() {
        List<Kindergartner> list = new ArrayList<>();
        String sql = "select * from kindergartner";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Kindergartner k = new Kindergartner(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7));
                list.add(k);
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Kindergartner getKidInfoById(int id) {
        StudentDAO dao = new StudentDAO();
        List<Kindergartner> list = dao.getAllStudent();
        for (Kindergartner kindergartner : list) {
            if (kindergartner.getKinder_id() == id) {
                return kindergartner;
            }
        }
        return null;
    }

    public Account getParentById(int id) {
        AccountDAO ad = new AccountDAO();
        List<Account> list = ad.getAllParentInfor();
        for (Account parent : list) {
            if (parent.getAccount_id() == id) {
                return parent;
            }
        }
        return null;
    }
    public List<Kindergartner> getKidbyParent(int id) {
        StudentDAO dao = new StudentDAO();
        Account a = new Account();
        List<Kindergartner> list = dao.getAllStudent();
        List<Kindergartner> kidparentlist = new ArrayList<>(); 
        for (Kindergartner kindergartner : list) {
            if (kindergartner.getParent_id() == id) {
                kidparentlist.add(kindergartner);
            }
        }
        return kidparentlist;
    }
   

    public List<StudyRecord> getAllStudyRecord() {
        String sql = "select * from Study_Record";
        List<StudyRecord> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudyRecord k = new StudyRecord(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
                list.add(k);
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Kindergartner> getKidsByClass(int class_id) {
        StudentDAO dao = new StudentDAO();
//        LocalDate current_date = LocalDate.now();
//        int currentYear = current_date.getYear();
        List<StudyRecord> list = dao.getAllStudyRecord();
        List<Kindergartner> listNew = new ArrayList<>();
        for (StudyRecord st : list) {
            if (st.getClass_id()== class_id) {
                listNew.add(dao.getKidInfoById(st.getKinder_id()));
            }
        }
        return listNew;
    }

    public Feedback getFbByKidID(int kid_id) {
        String sql = "select * from feedback where kid_id = ?";

        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, kid_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Feedback fb = new Feedback(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                return fb;
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertFBtoDB(Feedback fb) {
        String sql = "insert into Feedback(feedback_id, kid_id, teacher_id, fb_content, rating, fb_date) "
                + "values(?,?,?,?,?)";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, fb.getKid_id());
            ps.setInt(2, fb.getTeacher_id());
            ps.setString(3, fb.getFb_content());
            ps.setDouble(4, fb.getRating());
            ps.setString(5, fb.getTakenDate());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        List<StudyRecord> list = dao.getAllStudyRecord();
        for (StudyRecord s : list) {
            System.out.println(s.toString());
        }
        
        List<Kindergartner> list1 = dao.getKidsByClass(1);
        for (Kindergartner kindergartner : list1) {
            System.out.println(kindergartner.toString());
        }
        
        List<Kindergartner> list2 = dao.getKidbyParent(4);
        for (Kindergartner kindergartner : list2) {
            System.out.println(kindergartner.toString());
        }
    }

}
