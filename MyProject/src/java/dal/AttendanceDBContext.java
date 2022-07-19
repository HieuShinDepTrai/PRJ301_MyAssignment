/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Session;
import model.User;

/**
 *
 * @author Hiếu Shin FPT
 */
public class AttendanceDBContext extends DBContext {

    public ArrayList<Attendance> getAttendancesBySession(int sessionId) {

        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "SELECT [user].[id]\n"
                    + "	  ,[user].[name]\n"
                    + "	  ,[user].[birthday]\n"
                    + "	  ,[user].[email]\n"
                    + "   ,[sessionid]\n"
                    + "   ,[status]\n"
                    + "  FROM [attendance] INNER JOIN [user] ON [attendance].[userid] = [user].[id]\n"
                    + "  WHERE [sessionid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sessionId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                User user = new User();
                user.setUserId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setEmail(rs.getString("email"));
                a.setUsers(user);
                a.setSessionId(rs.getInt("sessionid"));
                a.setStatus(rs.getBoolean("status"));
                attendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendances;
    }

    public void insert(Attendance attendance) {
        try {
            String sql = "INSERT INTO [attendance]\n"
                    + "           ([userid]\n"
                    + "           ,[sessionid]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, attendance.getUsers().getUserId());
            stm.setInt(2, attendance.getSessionId());
            stm.setBoolean(3, attendance.isStatus());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertManny(ArrayList<Attendance> list) {
        if(list!=null && !list.isEmpty()){
            deleteBySession(list.get(0).getSessionId());
        }
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [attendance]\n"
                    + "           ([userid]\n"
                    + "           ,[sessionid]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            for (Attendance attendance : list) {
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setInt(1, attendance.getUsers().getUserId());
                stm.setInt(2, attendance.getSessionId());
                stm.setBoolean(3, attendance.isStatus());
                stm.executeUpdate();
                 System.out.println(attendance.getUsers().getUserId() + "-" + attendance.isStatus());
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Attendance attendance) {
        try {
            String sql = "DELETE FROM [attendance]\n"
                    + "      WHERE [attendance].[sessionid] = ? AND [attendance].[userid] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, attendance.getSessionId());
            stm.setInt(2, attendance.getUsers().getUserId());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteBySession(int sessionId) {
        try {
            String sql = "DELETE FROM [attendance]\n"
                    + "      WHERE [attendance].[sessionid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sessionId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
