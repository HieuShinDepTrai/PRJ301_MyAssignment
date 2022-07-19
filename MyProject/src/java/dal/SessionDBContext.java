/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Classes;
import model.Course;
import model.Room;
import model.Session;

/**
 *
 * @author Hiếu Shin FPT
 */
public class SessionDBContext extends DBContext {

    public ArrayList<Session> ListAllSessions() {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "SELECT [session].[id], "
                    + "[slot], "
                    + "[date], "
                    + "[roomid], "
                    + "[classid], "
                    + "[courseid]\n"
                    + "FROM [user] INNER JOIN [attendance]\n"
                    + "ON [user].[id] = [attendance].[userid] \n"
                    + "INNER JOIN [session]\n"
                    + "ON [attendance].[sessionid] = [session].[id]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                session.setSessionId(rs.getInt("id"));
                session.setSlot(rs.getInt("slot"));
                session.setDate(rs.getDate("date"));
                Room r = new Room();
                r.setRoomId(rs.getInt("roomid"));
                session.setRoom(r);
                Classes classes = new Classes();
                classes.setClassId(rs.getInt("classid"));
                session.setClasses(classes);
                Course course = new Course();
                course.setCourseId(rs.getInt("courseid"));
                session.setCourse(course);

                sessions.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    public Session getSessions(int sessionId, int classId) {
        AttendanceDBContext attendanceDBContext = new AttendanceDBContext();
        try {
            String sql = "SELECT distinct [session].[id] as sid\n"
                    + "	  ,[session].[slot]\n"
                    + "	  ,[session].[date]\n"
                    + "	  ,[class].[id] as cid\n"
                    + "	  ,[class].[name] as cname\n"
                    + "	  ,[course].[id] as coid\n"
                    + "	  ,[course].[name] as coname\n"
                    + "	  ,[room].[id] as rid\n"
                    + "	  ,[room].[name] as rname\n"
                    + "  FROM [attendance] INNER JOIN [session] \n"
                    + "  ON [attendance].[sessionid] = [session].[id]\n"
                    + "  INNER JOIN [user] ON [user].[id] = [attendance].[userid]\n"
                    + "  INNER JOIN [class] ON [class].[id] = [session].[classid]\n"
                    + "  INNER JOIN [course] ON [course].[id] = [session].[courseid]\n"
                    + "  INNER JOIN [room] ON [room].[id] = [session].[roomid]\n"
                    + "  WHERE  [session].[id] = ? AND [classid] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sessionId);
            stm.setInt(2, classId);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                session.setSessionId(rs.getInt("sid"));
                session.setSlot(rs.getInt("slot"));
                session.setDate(rs.getDate("date"));
                Room room = new Room();
                room.setRoomId(rs.getInt("rid"));
                room.setRoomName(rs.getString("rname"));
                session.setRoom(room);
                Classes classes = new Classes();
                classes.setClassId(rs.getInt("cid"));
                classes.setClassName(rs.getString("cname"));
                session.setClasses(classes);
                Course course = new Course();
                course.setCourseId(rs.getInt("coid"));
                course.setCourseName(rs.getString("coname"));
                session.setCourse(course);

                ArrayList<Attendance> attendances = attendanceDBContext.getAttendancesBySession(sessionId);
                session.setAttendance(attendances);
                return session;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Session> getSessionsByUserID(Integer userId, Date date) {
        String sql = "select distinct [s].*, \n"
                + "[r].[name] as [rname],\n"
                + "[c].[name] as [cname], \n"
                + "[co].[name] as [coname],\n"
                + "[a].[status] as [astatus]\n"
                + "from [enroll] as [e], [session] as [s], [room] as [r], [class] as [c], [course] as [co], attendance as [a]\n"
                + "where [e].[userid] = ?\n"
                + "and [e].[classid] = [s].[classid]\n"
                + "and [s].[date] between ? and ?\n"
                + "and [s].[roomid] = [r].[id]\n"
                + "and [s].[classid] = [c].[id]\n"
                + "and [s].[courseid] = [co].[id]\n"
                + "and [a].[sessionid] = [s].[id]";

        ArrayList<Session> sessions = new ArrayList<>();

        try ( PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setDate(2, date);
            ps.setDate(3, new Date(date.getTime() + 1000 * 60 * 60 * 24 * 7));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Session session = new Session();
                session.setSessionId(rs.getInt("id"));
                session.setSlot(rs.getInt("slot"));
                session.setDate(rs.getDate("date"));
                Room room = new Room();
                room.setRoomId(rs.getInt("roomid"));
                room.setRoomName(rs.getString("rname"));
                session.setRoom(room);
                Classes classes = new Classes();
                classes.setClassId(rs.getInt("classid"));
                classes.setClassName(rs.getString("cname"));
                session.setClasses(classes);
                Course course = new Course();
                course.setCourseId(rs.getInt("courseid"));
                course.setCourseName(rs.getString("coname"));
                session.setCourse(course);

                sessions.add(session);
            }

        } catch (Exception e) {
            return null;
        }

        return sessions;
    }
}
