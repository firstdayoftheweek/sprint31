package kz.spring.tech.studentsmanagement.controller;

import kz.spring.tech.studentsmanagement.db.DBManager;
import kz.spring.tech.studentsmanagement.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String indexPage(Model model) {
        ArrayList<Student> allStudents = DBManager.getStudents();
        model.addAttribute("allStudents", allStudents);
        return "index";
    }

    @GetMapping(value = "/add")
    public String addStudentPage() {
        return "addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam(name = "username") String name, @RequestParam(name = "surname") String surname, @RequestParam(name = "exam") int exam) {
        Long size = (long) DBManager.getStudents().size()+1;
        String mark = "";
        if (exam >= 50 && exam <= 59) {
            mark = "D";
        } else if (exam >= 60 && exam <= 74) {
            mark = "C";
        } else if (exam >= 75 && exam <= 89) {
            mark = "B";
        } else if (exam >= 90) {
            mark = "A";
        } else {
            mark = "F";
        }
        DBManager.addStudent(new Student(size, name, surname, exam, mark));
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable(name = "id") Long id, Model model) {
        Student currentStudent = DBManager.getStudentById(id);
        model.addAttribute("currentStudent", currentStudent);
        return "details";
    }
}
