package com.example.ams.api;

import com.alibaba.fastjson.JSON;
import com.example.ams.model.RespBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ams.annotation.UserLoginToken;
import com.example.ams.config.STATUS;
import com.example.ams.model.User;
import com.example.ams.service.Impl.TokenService;
import com.example.ams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByNumber(user);
        if(userForBase==null){
            jsonObject.put("code",STATUS.USER_NO_CODE);
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("code",STATUS.USER_FAILL_CODE);
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("code", STATUS.SUCCESS_CODE );
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return  "你已通过验证";
    }


    @UserLoginToken
    @GetMapping("/list")
    public RespBean getUserList(HttpServletRequest request, @RequestParam(defaultValue = "1" ) Integer page,
                                           @RequestParam(defaultValue = "10") Integer size){
        Map<String,Object> map=new HashMap<>();
        try{
            User user=new User();
            int type=0;

            PageHelper.startPage(page,size);
            if(request.getParameter("name")!=null&&request.getParameter("name")!=""&&request.getParameter("name").length()>0) user.setName(request.getParameter("name"));
            if(request.getParameter("number")!=null&&request.getParameter("number")!=""&&request.getParameter("number").length()>0) user.setNumber(request.getParameter("number"));
            if(request.getParameter("type")!=null&&request.getParameter("type")!=""&&request.getParameter("type").length()>0)
                type= Integer.parseInt(request.getParameter("type"));
            if(type==1||type==2||type==3)
                user.setType(type);

            PageInfo<User> pageInfo=new PageInfo<>(userService.getAllUser(user));
            map.put("userList",pageInfo);
            return RespBean.ok("sucess",map);
        }catch (Exception e){
            return RespBean.error(e.toString());
        }
    }

    @UserLoginToken
    @PostMapping("/create")
    public RespBean addUser(@RequestBody User user){
        if(userService.addUser(user)>0){
            return RespBean.ok("成功");
        }
        return RespBean.error("请重试");
    }

    @UserLoginToken
    @PutMapping("/edit")
    public RespBean editUser(@RequestBody User user){
        if(userService.editUser(user)>0){
            return RespBean.ok("成功");
        }
        return RespBean.error("请重试");
    }

    @UserLoginToken
    @DeleteMapping("/{id}")
    public RespBean deleteUser(@PathVariable("id") Integer id){
        System.out.println(id);
        if(userService.delete(id)>0){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("请重试");
    }
}
