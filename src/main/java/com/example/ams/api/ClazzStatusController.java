package com.example.ams.api;


import com.example.ams.annotation.UserLoginToken;
import com.example.ams.model.Clazz;
import com.example.ams.model.RespBean;
import com.example.ams.model.User;
import com.example.ams.service.AchievementService;
import com.example.ams.service.ClazzService;
import com.example.ams.service.CourseService;
import com.example.ams.service.UserService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("status")
public class ClazzStatusController {
    @Autowired
    UserService userService;

    @Autowired
    ClazzService clazzService;

    @Autowired
    AchievementService achievementService;

    @Autowired
    CourseService courseService;


    @UserLoginToken
    @GetMapping("index")
    public RespBean index(HttpServletRequest request){
        Clazz clazz=new Clazz();
        Map<String,Object> map=new HashMap<>();
        try{
            Integer semester_id;
            if (request.getParameter("class_id")==null||request.getParameter("class_id").isEmpty())return RespBean.error("班级不能为空");
            clazz=clazzService.getClazzById(Integer.parseInt(request.getParameter("class_id")));
            if (request.getParameter("semester")==null||request.getParameter("semester").isEmpty()){
               semester_id=clazz.getSemesterId();
            }else{
                semester_id=clazz.getSemesterId()+Integer.parseInt(request.getParameter("semester"))-1;
            }
            List<User> studentList=userService.getUserByClazz(clazz.getId());
            for (User s :studentList){
                s.stuAchievement=achievementService.usualPerformance(s.getNumber(),semester_id,clazz.getId());
            }
            map.put("studnet",studentList);
            map.put("course",courseService.getCourseBySemsterAndClass(semester_id,clazz.getId()));
            return RespBean.ok("sucess",map);
        }
        catch (Exception e){
            return RespBean.error(e.toString());
        }
    }

}
