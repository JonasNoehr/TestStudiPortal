package de.hsba.bi.studentOrganisationPortal.course;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) { this.repository = repository; }

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        Course course = new Course();
        course.setName("Mathe");
        addCourseEntry(course, new CourseEntry("Mathe"));

        repository.save(course);
    }

    public Course createCourse(String name) {
        Course course = new Course();
        course.setName(name);
        return repository.save(course);
    }

    public Course getCourse(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void addCourseEntry(Course course, CourseEntry entry) {
        entry.setCourse(course);
        course.getEntries().add(entry);
    }

    public Collection<Course> getAll() {return repository.findAll();}

    public void delete(Long id) { repository.deleteById(id);}
}
