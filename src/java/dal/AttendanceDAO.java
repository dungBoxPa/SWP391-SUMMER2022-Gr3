package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendence;
import model.Kindergartner;

/**
 *
 * @author Windows 10 TIMT
 */
public class AttendanceDAO {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public List<Kindergartner> getAllCheckInKidsOfADay(int classID, String date) {
        StudentDAO dao = new StudentDAO();
        AttendanceDAO dao1 = new AttendanceDAO();
        List<Attendence> list = dao1.getAllAttendanceOfInputDay(date);
        List<Kindergartner> liststu = dao.getKidsByClass(classID);
        List<Kindergartner> output = new ArrayList<>();
        for (Attendence attendence : list) {
            for (Kindergartner kindergartner : liststu) {
                if (attendence.getStudent_id() == kindergartner.getKinder_id() && attendence.getStatus() == 1) {
                    output.add(kindergartner);
                }
            }
        }
        return output;
    }

    public void insertAttendanceInfor(Attendence att) {
        String sql = "insert into Attendance values (?,?,?,?)";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, att.getStudent_id());
            ps.setString(2, att.getCheck_date());
            ps.setInt(3, att.getStatus());
            ps.setInt(4, att.getTeacher_id());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAttendanceInfor(Attendence att) {
        String sql = "update attendance set status = ? where student_id = ? and check_date = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, att.getStatus());
            ps.setInt(2, att.getStudent_id());
            ps.setString(3, att.getCheck_date());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Attendence checkAttendance(Attendence a) {
        String sql = "select * from attendance where student_id = ? and check_date = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, a.getStudent_id());
            ps.setString(2, a.getCheck_date());
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Attendence(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
        } catch (Exception ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Attendence> getAllAttendanceOfDay() {
        String sql = "select * from attendance";
        List<Attendence> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attendence(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Attendence> getAllAttendanceOfInputDay(String checkDay) {
        String sql = "select * from attendance where check_date = ?";
        List<Attendence> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, checkDay);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attendence(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        AttendanceDAO att = new AttendanceDAO();
        List<Kindergartner> list = att.getAllCheckInKidsOfADay(1, "2022/06/20");
        for (Kindergartner a : list) {
            System.out.println(a.toString());
        }
        List<Attendence> lista = att.getAllAttendanceOfInputDay("2022/06/20");
        for (Attendence attendence : lista) {
            System.out.println(attendence.toString());
        }
        String date = java.time.LocalDate.now().toString();
        Attendence a = att.checkAttendance(new Attendence(1, date, 0, 1));
        System.out.println(a);
    }
}
