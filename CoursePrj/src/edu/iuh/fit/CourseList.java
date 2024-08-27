/*
 * @ (#) CourseList.java       1.0     8/27/2024
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CourseList {
    private List<Course> courses;

    public CourseList() {
        this.courses = new ArrayList<>();
    }

    // Phương thức thêm một khóa học vào danh sách
    public void addCourse(Course course) {
        for (Course c : courses) {
            if (c.getId().equals(course.getId())) {
                System.out.println("Error: Course ID already exists.");
                return;
            }
        }
        this.courses.add(course);
    }

    // Phương thức lấy danh sách các khóa học
    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    // Phương thức xóa một khóa học khỏi danh sách
    public void removeCourse(String courseId) {
        boolean removed = courses.removeIf(course -> course.getId().equals(courseId));
        if (!removed) {
            System.out.println("Error: Course ID not found.");
        }
    }

    // Phương thức tìm kiếm một khóa học theo mã khóa học
    public Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    // Phương thức tìm kiếm các khóa học theo tên khóa học (tìm tương đối)
    public List<Course> findCoursesByTitle(String title) {
        List<Course> result = courses.stream()
                .filter(course -> course.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
        return result.isEmpty() ? null : result;
    }

    // Phương thức tìm kiếm các khóa học theo khoa phụ trách
    public List<Course> findCoursesByDepartment(String department) {
        List<Course> result = courses.stream()
                .filter(course -> course.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
        return result.isEmpty() ? null : result;
    }

    // Phương thức sắp xếp các khóa học theo tên khóa học
    public List<Course> sortCoursesByTitle() {
        return courses.stream()
                .sorted(Comparator.comparing(Course::getTitle))
                .collect(Collectors.toList());
    }

    // Phương thức tìm các khóa học có số tín chỉ lớn nhất
    public List<Course> findCoursesWithMaxCredits() {
        int maxCredits = courses.stream()
                .mapToInt(Course::getCredit)
                .max()
                .orElse(0);
        return courses.stream()
                .filter(course -> course.getCredit() == maxCredits)
                .collect(Collectors.toList());
    }

    // Phương thức tìm khoa phụ trách có nhiều khóa học nhất
    public String findDepartmentWithMostCourses() {
        return courses.stream()
                .collect(Collectors.groupingBy(Course::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(e -> e.getValue()))
                .map(e -> e.getKey())
                .orElse(null);
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "courses=" + courses +
                '}';
    }
}