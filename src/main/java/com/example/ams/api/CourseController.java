package com.example.ams.api;

import com.example.ams.annotation.UserLoginToken;
import com.example.ams.mapper.CourseMapper;
import com.example.ams.model.Course;
import com.example.ams.model.RespBean;
import com.example.ams.service.CourseService;
import com.example.ams.service.Impl.TokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    TokenService tokenService;

    @UserLoginToken
    @GetMapping("/list")
    public RespBean getCourseList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer size){
        Map<String ,Object> map=new HashMap<>();
        try{
            Course course=new Course();
            String name=request.getParameter("name");
            if(name!=null&&name!=""&&name.length()>0) course.setName(name);
            PageHelper.startPage(page,size);
            PageInfo<Course> pageInfo=new PageInfo<>(courseService.getAllCourse(course));
            map.put("courseList",pageInfo);
            return  RespBean.ok("sucess",map);
        }
        catch (Exception e){
            return RespBean.error(e.toString());
        }
    }

    @UserLoginToken
    @PostMapping("/create")
    public RespBean addCourse(@RequestBody Course course) {
        if(course.getName().length()<=0)return RespBean.error("课程名称不能为空");
        int r =courseService.addCourse(course);
        if(r>0)return RespBean.ok("sucess");
        else
            return RespBean.error("失败");
    }

    @UserLoginToken
    @PutMapping("/edit")
    public RespBean editCourse(@RequestBody Course course){
        if(course.getName().length()<=0)return RespBean.error("课程名称不能为空");
        int r =courseService.editCourse(course);
        if(r>0)return RespBean.ok("sucess");
        else
            return RespBean.error("失败");
    }

    @UserLoginToken
    @DeleteMapping("/{id}")
    public RespBean deleteCourse(@PathVariable("id") Integer id){

        int r =courseService.deleteCourse(id);
        if(r>0)return RespBean.ok("sucess");
        else
            return RespBean.error("失败");

    }

}
