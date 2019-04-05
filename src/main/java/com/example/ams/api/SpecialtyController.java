package com.example.ams.api;

import com.example.ams.annotation.UserLoginToken;
import com.example.ams.model.RespBean;
import com.example.ams.model.Specialty;
import com.example.ams.service.Impl.TokenService;
import com.example.ams.service.SpecialtyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("specialty")
public class SpecialtyController {

    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    TokenService tokenService;

    @UserLoginToken
    @GetMapping("/list")
    public RespBean getUserList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>();
        try {

            Specialty specialty = new Specialty();
            if (request.getParameter("name") != null && request.getParameter("name") != "" && request.getParameter("name").length() > 0)
                specialty.setName(request.getParameter("name"));
           System.out.println(specialty.getName());
            PageHelper.startPage(page, size);
            PageInfo<Specialty> pageInfo = new PageInfo<>(specialtyService.getAllSpecialty(specialty));
            map.put("specialtyList", pageInfo);
            return  RespBean.ok( "sucess",map);
        } catch (Exception e) {
            return RespBean.error(e.toString());
        }
    }

    @UserLoginToken
    @PostMapping("/create")
    public RespBean addSpecialty(@RequestBody Specialty specialty) {
        if(specialty.getName().length()<=0)return RespBean.error("专业名称不能为空");
        if(specialtyService.addSpecialty(specialty)>0){
            return RespBean.ok("成功");
        }
        return RespBean.error("请重试");
    }

    @UserLoginToken
    @PutMapping("/edit")
    public RespBean editSpecialty(@RequestBody Specialty specialty) {
        if(specialtyService.editSpecialty(specialty)>0){
            return RespBean.ok("成功");
        }
        return RespBean.error("请重试");
    }

    @UserLoginToken
    @DeleteMapping("/{id}")
    public RespBean deleteSpecialty(@PathVariable("id") Integer id) {
        try {
            if(specialtyService.deleteSpecialty(id)>0){
                return RespBean.ok("成功");
            }else
                return RespBean.error("请重试");
        }catch (Exception e){
            return  RespBean.error("请重试");
        }
    }
}
