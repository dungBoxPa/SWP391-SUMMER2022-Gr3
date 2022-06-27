/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Kinder_Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ClassDAO extends DBContext {

    private Connection connection;
    private PreparedStatement st;
    private ResultSet rs;

    public Kinder_Class getTeacherClass(int id){
        ClassDAO cd = new ClassDAO();
        List<Kinder_Class> list = cd.getAllClass();
        for (Kinder_Class kinder_Class : list) {
            if(kinder_Class.getTeacher_id() == id){
                return kinder_Class;
            }
        }
        return null;
    }
    
    public List<Kinder_Class> getAllClass() {
        List<Kinder_Class> list = new ArrayList<>();
        String sql = "select * from class";
        try {
            connection = new DBContext().getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Kinder_Class c = new Kinder_Class();
                c.setClass_id(rs.getInt("class_id"));
                c.setClass_name(rs.getString("class_name"));
                c.setGrade(rs.getInt("grade"));
                c.setClass_description(rs.getString("class_description"));
                c.setTeacher_id(rs.getInt("teacher_id"));
                list.add(c);
            }
            return list;

        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String[] args) {
        ClassDAO cd = new ClassDAO();
        List<Kinder_Class> list = cd.getAllClass();
        for (Kinder_Class class1 : list) {
            System.out.println(class1.toString());
        }
        System.out.println(cd.getTeacherClass(1));
    }
}
