package de.hsba.bi.studentOrganisationPortal.web;

import de.hsba.bi.studentOrganisationPortal.course.Course;
import de.hsba.bi.studentOrganisationPortal.course.CourseEntry;
import de.hsba.bi.studentOrganisationPortal.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("course", courseService.getAll());
        return "course/index";
    }

    @PostMapping
    public String create(String name) {
        Course course = courseService.createCourse(name);
        return "redirect:/courses/" + course.getId();
    }

    @GetMapping(path = "/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("course", courseService.getCourse(id));
        return "courses/show";
    }

    @PostMapping(path = "/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        courseService.delete(id);
        return "redirect:/courses/";
    }
}
