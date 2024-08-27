/*
 * @ (#) Course.java       1.0     8/27/2024
 *
 * Copuright (c) 2024 IUH, All rights reserved
 */

package edu.iuh.fit;

/*
 *@description:
 *@author: Thang Nguyen
 *@Date: 8/27/2024
 *version:  1.0
 */
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course(String id, String title, int credit, String department) {
        if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Invalid course ID");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Course title cannot be empty");
        }
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", credit=" + credit +
                ", department='" + department + '\'' +
                '}';
    }
}