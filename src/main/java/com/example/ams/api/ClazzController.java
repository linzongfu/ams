package com.example.ams.api;

import com.example.ams.annotation.UserLoginToken;
import com.example.ams.model.Clazz;
import com.example.ams.model.RespBean;
import com.example.ams.model.Specialty;
import com.example.ams.model.User;
import com.example.ams.service.ClazzService;
import com.example.ams.service.GradeService;
import com.example.ams.service.Impl.TokenService;
import com.example.ams.service.SpecialtyService;
import com.example.ams.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("clazz")
public class ClazzController {

    @Autowired
    ClazzService clazzService;

    @Autowired
    GradeService gradeService;

    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @UserLoginToken
    @GetMapping("/index")
    public RespBean index(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size){

        Map<String,Object> map=new HashMap<>();
        try{
            map.put("gradeList",gradeService.getAllGrade());
            map.put("specialtyList",specialtyService.getAllSpecialty(new Specialty()));
            User user=new User();
            user.setType(3);
            map.put("teacherList",userService.getAllUser(user));
            PageHelper.startPage(page,size);
            return  RespBean.ok("成功",map);
        }catch ( Exception e){
            return  RespBean.error(e.toString());
        }
    }



    @UserLoginToken
    @GetMapping("/list")
    public RespBean getClazzList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){


        try{
           Clazz clazz=new Clazz();

           if(request.getParameter("graId")!=null&&request.getParameter("graId")!=""&&request.getParameter("graId").length()>0)clazz.setGradeId(Integer.parseInt(request.getParameter("graId")));
           if(request.getParameter("speId")!=null&&request.getParameter("speId")!=""&&request.getParameter("speId").length()>0)clazz.setSpecialtyId(Integer.parseInt(request.getParameter("speId")));
           if(request.getParameter("search_word")!=null&&request.getParameter("search_word")!=""&&request.getParameter("search_word").length()>0)clazz.setName(request.getParameter("search_word"));
          PageHelper.startPage(page,size);
          PageInfo<Clazz> pageInfo=new PageInfo<>(clazzService.getAllClazz(clazz));
          Map<String ,Object> map=new HashMap<>();
          map.put("clazzList",pageInfo);
          return RespBean.ok("sucess",map);
        }catch (Exception e){
            return  RespBean.error(e.getCause().getMessage().toString());
        }
    }

    @UserLoginToken
    @PostMapping("/create")
    public RespBean addClazz(@RequestBody Clazz clazz){
        if(clazz.getSpecialtyId()==null||clazz.getGradeId()==null||clazz.getTeacherId()==null||clazz.getTeacherId()=="")
            return RespBean.error("参数不能为空");
        if(clazz.getName()==null||clazz.getName()=="")
            return  RespBean.error("请输入班级名称");
        int r=clazzService.addClazz(clazz);
        if(r>0)return RespBean.ok("添加成功");
        else return  RespBean.error("添加失败");
    }

    @UserLoginToken
    @PutMapping("/edit")
    public RespBean editClazz(@RequestBody Clazz clazz){
        if(clazz.getSpecialtyId()==null||clazz.getGradeId()==null||clazz.getTeacherId()==null||clazz.getTeacherId()=="")
            return RespBean.error("参数不能为空");
        if(clazz.getName()==null||clazz.getName()=="")
            return  RespBean.error("请输入班级名称");
        int r=clazzService.editClass(clazz);
        if(r>0)return RespBean.ok("编辑成功");
        else return  RespBean.error("编辑失败");

    }

    @UserLoginToken
    @DeleteMapping("/{id}")
    public RespBean deleteClass(@PathVariable("id") Integer id){
        int r=clazzService.deleteClass(id);
        if(r>0)return RespBean.ok("删除成功");
        else return  RespBean.error("删除失败");
    }


}
