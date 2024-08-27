/*
 * @ (#) Main.java       1.0     8/27/2024
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


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Thêm khóa học");
            System.out.println("2. Lấy danh sách các khóa học");
            System.out.println("3. Xóa khóa học");
            System.out.println("4. Tìm khóa học theo mã");
            System.out.println("5. Tìm khóa học theo tên");
            System.out.println("6. Tìm khóa học theo khoa");
            System.out.println("7. Sắp xếp khóa học theo tên");
            System.out.println("8. Tìm khóa học có số tín chỉ lớn nhất");
            System.out.println("9. Tìm khoa có nhiều khóa học nhất");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã khóa học: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên khóa học: ");
                    String title = scanner.nextLine();
                    System.out.print("Nhập số tín chỉ: ");
                    int credit = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Nhập khoa phụ trách: ");
                    String department = scanner.nextLine();
                    Course course = new Course(id, title, credit, department);
                    courseList.addCourse(course);
                    break;
                case 2:
                    printCourses(courseList.getCourses());
                    break;
                case 3:
                    System.out.print("Nhập mã khóa học cần xóa: ");
                    String removeId = scanner.nextLine();
                    courseList.removeCourse(removeId);
                    break;
                case 4:
                    System.out.print("Nhập mã khóa học cần tìm: ");
                    String findId = scanner.nextLine();
                    Course foundCourse = courseList.findCourseById(findId);
                    if (foundCourse != null) {
                        System.out.println("Thông tin khóa học: " + foundCourse);
                    } else {
                        System.out.println("Không tìm thấy khóa học.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên khóa học cần tìm: ");
                    String findTitle = scanner.nextLine();
                    List<Course> foundCoursesByTitle = courseList.findCoursesByTitle(findTitle);
                    if (foundCoursesByTitle != null) {
                        printCourses(foundCoursesByTitle);
                    } else {
                        System.out.println("Không tìm thấy khóa học.");
                    }
                    break;
                case 6:
                    System.out.print("Nhập khoa phụ trách cần tìm: ");
                    String findDepartment = scanner.nextLine();
                    List<Course> foundCoursesByDepartment = courseList.findCoursesByDepartment(findDepartment);
                    if (foundCoursesByDepartment != null) {
                        printCourses(foundCoursesByDepartment);
                    } else {
                        System.out.println("Không tìm thấy khóa học.");
                    }
                    break;
                case 7:
                    List<Course> sortedCourses = courseList.sortCoursesByTitle();
                    printCourses(sortedCourses);
                    break;
                case 8:
                    List<Course> maxCreditCourses = courseList.findCoursesWithMaxCredits();
                    printCourses(maxCreditCourses);
                    break;
                case 9:
                    String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
                    System.out.println("Khoa có nhiều khóa học nhất: " + departmentWithMostCourses);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    private static void printCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("Danh sách khóa học trống.");
        } else {
            System.out.printf("%-10s %-20s %-10s %-20s%n", "ID", "Tên khóa học", "Số tín chỉ", "Khoa phụ trách");
            for (Course course : courses) {
                System.out.printf("%-10s %-20s %-10d %-20s%n", course.getId(), course.getTitle(), course.getCredit(), course.getDepartment());
            }
        }
    }
}
