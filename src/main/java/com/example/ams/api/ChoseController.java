package com.example.ams.api;

import com.example.ams.annotation.UserLoginToken;
import com.example.ams.model.Clazz;
import com.example.ams.model.RespBean;
import com.example.ams.model.Semester;
import com.example.ams.service.ClazzService;
import com.example.ams.service.CourseService;
import com.example.ams.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("chose")
public class ChoseController {


    @Autowired
    ClazzService clazzService;

    @Autowired
    SemesterService semesterService;
    @Autowired
    CourseService courseService;

    @UserLoginToken
    @GetMapping("/index")
    public RespBean index(HttpServletRequest request){
        try {
            if(request.getParameter("class_Id")==null||request.getParameter("class_Id")==""||request.getParameter("class_Id").length()<=0)
                return RespBean.error("请输入班级");
            Clazz clazz=new Clazz();
            clazz.setId(Integer.parseInt(request.getParameter("class_Id")));
            if(clazz.getId()<=0)return RespBean.error("班级输入有误");
            List<Semester> semesters=semesterService.getAllSemester(new Semester());
            Map<String ,Object> map=new HashMap<>();
            int i=0;
            for (Semester s :semesters) {
                i++;
                map.put("data"+i,courseService.getCourseBySemsterAndClass(s.getId(),clazz.getId()));
            }
           return RespBean.ok("成功",map);
        }catch (Exception e){
            return RespBean.error(e.toString());
        }
    }

    @UserLoginToken
    @GetMapping("/list")
    public RespBean getSemesterList(@RequestBody Semester semester){
        return  RespBean.ok("");
    }

    @UserLoginToken
    @PostMapping("/create")
    public  RespBean addSemester(@RequestBody Semester semester){
        return  RespBean.ok("");
    }

    @UserLoginToken
    @PutMapping("/edit")
    public  RespBean editSemester(@RequestBody Semester semester){
        return  RespBean.ok("");
    }

    @UserLoginToken
    @DeleteMapping("/{id}")
    public RespBean deleteSemester(@PathVariable("id") Integer id){
        return  RespBean.ok("");
    }

}
