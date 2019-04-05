package com.example.ams.api;

import com.example.ams.annotation.UserLoginToken;
import com.example.ams.model.Semester;
import com.example.ams.service.Impl.TokenService;
import com.example.ams.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("semester")
public class SemesterController {
    @Autowired
    TokenService tokenService;

    @Autowired
    SemesterService semesterService;

    @UserLoginToken
    @GetMapping("/list")
    public List<Semester> getSemesterList(@RequestBody Semester semester){
        return  semesterService.getAllSemester(semester);
    }

    @UserLoginToken
    @PostMapping("/create")
    public  int addSemester(@RequestBody Semester semester){
        return  semesterService.addSemester(semester);
    }

    @UserLoginToken
    @PutMapping("/edit")
    public  int editSemester(@RequestBody Semester semester){
        return  semesterService.editSemester(semester);
    }

    @UserLoginToken
    @DeleteMapping("/{id}")
    public int deleteSemester(@PathVariable("id") Integer id){
        return  semesterService.deleteSemester(id);
    }
}
