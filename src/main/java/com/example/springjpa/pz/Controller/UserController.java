package com.example.springjpa.pz.Controller;

import com.example.springjpa.pz.pojo.Users;
import com.example.springjpa.pz.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
@Controller
public class UserController {
    @Autowired
    private Userservice userservice;

  @RequestMapping("/list")
  public String list(Model  mv) {//不带分页，要用的话把每个页面上fenye方法换成select
      System.out.print("wwwwwwwwww");
      List<Users> list=userservice.getUserList();
      System.out.println(list.size()+"sss");
      mv.addAttribute("list",list);
      return "list";
  }

    @RequestMapping("/toAdd")
    public String toAdd() {
      return "useradd";
    }

    @RequestMapping("/add")
    public String add(Users user) {
        userservice.save(user);
        return "redirect:/fenye";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        Users user=userservice.findUserById(id);
        model.addAttribute("user", user);
        return "userEdit";
    }

    @RequestMapping("/edit")
    public String edit(Users user) {
        userservice.edit(user);
        return "redirect:/fenye";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        userservice.delete(id);
        return "redirect:/fenye";
    }

    //分页
    @RequestMapping("fenye")
    public ModelAndView categorylist(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                     @RequestParam(value = "limit", defaultValue = "2") Integer limit) {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "id");
        Pageable pageable = new PageRequest(start, limit, sort);
        Page<Users> page = userservice.findAll(pageable);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");
        mav.addObject("page", page);
        return mav;
    }
}
