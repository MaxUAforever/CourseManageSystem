package com.squirrel.courses.service.course;

import com.squirrel.courses.dataaccess.dao.course.ICourseDAO;
import com.squirrel.courses.dataaccess.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService{

    private ICourseDAO courseDAO;

    /*@Autowired
    public void setCourseDAO(ICourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }*/

    public CourseService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("database/SpringModule.xml");
        courseDAO = (ICourseDAO) context.getBean("courseDAO");
    }

    @Override
    public boolean addCourse(Course course) {
        return courseDAO.addCourse(course);
    }

    @Override
    public boolean editCourse(Course course) {
        return courseDAO.editCourse(course);
    }

    @Override
    public boolean deleteCourse(int id) {
        return courseDAO.deleteCourse(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDAO.findAllCourses();
    }

    @Override
    public List<String> getAllThemes() {
        return courseDAO.findCoursesThemes();
    }

    @Override
    public List<Course> getLecturerCourses(String lecturer) {
        return courseDAO.findCoursesByLecturer(lecturer);
    }

    @Override
    public List<String> getLecturerCourseThemes(String lecturer) {
        return courseDAO.findCoursesThemesByLecturer(lecturer);
    }

    @Override
    public List<Course> getCoursesByTheme(String theme) {
        return courseDAO.findCoursesByTheme(theme);
    }

    @Override
    public List<Course> getCoursesByLecturer(String lecturer) {
        return courseDAO.findCoursesByLecturer(lecturer);
    }
}
