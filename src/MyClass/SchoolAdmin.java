/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyClass;

import java.io.Serializable;

/**
 *
 * @author meone
 */
public class SchoolAdmin extends User implements Serializable{
    private String schoolName, staffID, position;

    public SchoolAdmin(String schoolName, String staffID, String position, String username, String password, String fullname, String email, String phone) {
        super(username, password, fullname, email, phone);
        this.schoolName = schoolName;
        this.staffID = staffID;
        this.position = position;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    
}
