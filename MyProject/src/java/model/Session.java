/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Hiếu Shin FPT
 */
public class Session {
    private int sessionId;
    private int slot;
    private Date date;
    private Room room;
    private Classes classes;
    private Course course;
    private List<Attendance> attendance;

    public Session() {
    }

    public Session(int sessionId, int slot, Date date, Room room, Classes classes, Course course, List<Attendance> attendance) {
        this.sessionId = sessionId;
        this.slot = slot;
        this.date = date;
        this.room = room;
        this.classes = classes;
        this.course = course;
        this.attendance = attendance;
    }

    
    
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }
}
