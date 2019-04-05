package com.example.ams.api;

import com.example.ams.annotation.UserLoginToken;
import com.example.ams.model.RespBean;
import com.example.ams.model.User;
import com.example.ams.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    UserService userService;

    @UserLoginToken
    @GetMapping("index")
    public RespBean index(HttpServletRequest request, @RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer size){
        Map<String,Object> map=new HashMap<String ,Object>();
        try{
            User user=new User();
            int type=0;
            PageHelper.startPage(page,size);
            if(request.getParameter("name")!=null&&request.getParameter("name")!=""&&request.getParameter("name").length()>0) user.setName(request.getParameter("name"));
            if(request.getParameter("number")!=null&&request.getParameter("number")!=""&&request.getParameter("number").length()>0) user.setNumber(request.getParameter("number"));
            if(request.getParameter("class_id")!=null&&request.getParameter("class_id")!=""&&request.getParameter("class_id").length()>0) user.setClass_id(Integer.parseInt(request.getParameter("class_id")));
            user.setType(2);
            System.out.println(user.getClass_id());
            PageInfo<User> pageInfo=new PageInfo<>(userService.getAllUser(user));
            map.put("userList",pageInfo);
            return  RespBean.ok("sucess",map);
        }catch (Exception e){
            return RespBean.error(e.toString());
        }
    }
}
