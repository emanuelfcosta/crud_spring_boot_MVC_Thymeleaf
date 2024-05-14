package br.com.emanuelcosta.demo.controller;

import br.com.emanuelcosta.demo.entities.Student;
import br.com.emanuelcosta.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/students")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService theStudentService){
        studentService = theStudentService;
    }
    @GetMapping("/list")
    public String listStudents(Model theModel){
        List<Student> theStudents = studentService.findAll();

        theModel.addAttribute("students",theStudents);

        return "students/list-students";

    }

    @GetMapping("/showFormAddStudent")
    public String showFormForAddStudent(Model theModel){
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "students/student-form";

    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent){
        studentService.insert(theStudent);

        return "redirect:/students/list";
    }

    @GetMapping("/showFormUpdateStudent")
    public String showFormForUpdate(@RequestParam("studentId") long theId, Model theModel){

        Student theStudent = studentService.findById(theId);

        theModel.addAttribute("student",theStudent);


        return "students/student-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") long theId){

        studentService.delete(theId);

        return "redirect:/students/list";


    }
}
