package com.example.courseapi;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private List<Course> courses = new ArrayList<>();

    public CourseServiceImpl() {
        courses.add(new Course(1, "Java", "Anupama"));
        courses.add(new Course(2, "Python", "Sasmita"));
        courses.add(new Course(3, "Database", "Sudiksha"));
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course updateCourse(int id, Course updatedCourse) {
        for (Course course : courses) {
            if (course.getId() == id) {
                course.setName(updatedCourse.getName());
                course.setInstructor(updatedCourse.getInstructor());
                return course;
            }
        }
        return null;
    }

    @Override
    public boolean deleteCourse(int id) {
        return courses.removeIf(course -> course.getId() == id);
    }
}

