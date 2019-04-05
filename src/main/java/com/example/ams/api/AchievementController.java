package com.example.ams.api;

import com.example.ams.annotation.UserLoginToken;
import com.example.ams.model.*;
import com.example.ams.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("achi")
public class AchievementController {
    @Autowired
    UserService userService;
    @Autowired
    ClazzService clazzService;
    @Autowired
    CourseService courseService;
    @Autowired
    SemesterService semesterService;
    @Autowired
    ClazzCourseService clazzCourseService;
    @Autowired
    AchievementService achievementService;


    @UserLoginToken
    @GetMapping("/index")
    public RespBean index(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        User student;
        Clazz clazz;
        try{
            if (request.getParameter("number")==null||request.getParameter("number").isEmpty())return RespBean.error("学号不能为空");
            if (request.getParameter("class_id")==null||request.getParameter("class_id").isEmpty())return RespBean.error("班级不能为空");
            student=userService.findByNumber(request.getParameter("number"));
            if(student.getClass_id()!=Integer.parseInt(request.getParameter("class_id")))return RespBean.ok("信息错误");
            clazz=clazzService.getClazzById(student.getClass_id());
            LocalDate endDay=LocalDate.now();
            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDate startDay=LocalDate.parse(clazz.getCreateAt(),dtf);
            Period period = Period.between(startDay ,endDay);
            Integer semester=(period.getYears()*12+period.getMonths())/6+clazz.getSemesterId();
            //指定班级和学生来获取课程信息，，用于添加本学期课程
            map.put("resut",courseService.getCourseBySemsterAndClass(semester,clazz.getId()));
            map.put("semester",semesterService.getSemestetById((semester)));
            map.put("clazz",clazz);
            //获取成绩列表  从第一学期到当前学期

            int i ,t=1;
            for(i=clazz.getSemesterId();i<semester;i++){
                if(i>clazz.getSemesterId()+7)break;
                map.put("semester"+t,achievementService.usualPerformance(student.getNumber(),i,clazz.getId()));
                t++;
            }
            map.put("achievement",achievementService.Statistical(student.getNumber(),clazz.getId()));
            return RespBean.ok("d",map);
        }catch (Exception e){
            return RespBean.error(e.toString());
        }
    }

    @UserLoginToken
    @GetMapping("/list")
    public RespBean list(){return RespBean.ok("ss");}

    @UserLoginToken
    @PostMapping("/create")
    public RespBean addStudent(@RequestBody Achievement achievement){
        try {
            if (achievement.getSemesterId() == 0) return RespBean.error("请刷新后重试");
            if (achievement.getCourseId() == 0) return RespBean.error("semesterId");

            User user = userService.findByNumber(achievement.getStudentid());
            clazzCourse cC = clazzCourseService.getCCbyoptin(user.getClass_id(), achievement.getCourseId(), achievement.getSemesterId());
            achievement.setCcid(cC.getId());
            Map<String, Object> map = new HashMap<>();
            List<Achievement> list = achievementService.exitAchivement(achievement.getStudentid(), cC.getId());
            if (list.size() > 0) {
                achievement.setId(list.get(0).getId());
                int t = achievementService.editAchievement(achievement);
                if (t > 0) return RespBean.ok("修改成绩成功");
            } else {
                int t = achievementService.addAchievement(achievement);
                if (t > 0) return RespBean.ok("添加成绩成功");
            }
            return RespBean.error("请登陆后重试");
        }catch (Exception e){
            return RespBean.error(e.toString());
        }
            //先判断是否存在 根据学期Id 班级id 获取cci
            //更具ccid 和课程number 查找
            //无记录  添加  有记录 修改
    }
    @UserLoginToken
    @PutMapping("/edit")
    public RespBean editUser(@RequestBody User user){

        return RespBean.error("请重试");
    }

    @UserLoginToken
    @DeleteMapping("/{id}")
    public RespBean deleteUser(@PathVariable("id") Integer id){
        return RespBean.error("请重试");
    }
}
