import java.sql.*;
import java.util.*;

public class StudentDAO {
    Connection conn = DBConnection.getConnection();

    public void addStudent(Student s) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?)");
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getCourse());
            ps.executeUpdate();
            System.out.println("Student Added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) +
                                   " | " + rs.getInt(3) + " | " + rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
