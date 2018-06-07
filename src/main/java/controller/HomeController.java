package controller;

import data.SongRepository;
import data.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: guohezuzi
 * \* Date: 18-2-2
 * \* Time: 下午11:54
 * \* Description:主页视图控制器
 * \
 */
@Controller
@RequestMapping("/")
public class HomeController {
    private final SongRepository songRepository;
    private final UserRepositoryImpl userRepository;

    @Autowired
    public HomeController(SongRepository songRepository, UserRepositoryImpl userRepository) {
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = {"/","index"},method = {GET,POST})
    public String home(Model model) {
        //model.addAttribute("count",userRepository.getCount());
        model.addAttribute("songList", songRepository.showThirtySong(0));
        return "index";
    }

    /**管理员界面跳转*/
    @RequestMapping(value = "admin", method = {GET,POST})
    public String admin(Model model, HttpServletRequest res) {
        Cookie[] cookies=res.getCookies();
        for (Cookie c :
                cookies) {
            if (c.getName().equals("isLogin")){
                model.addAttribute("songList", songRepository.showAllSong());
                return "admin";
            }
        }
        return "index";
    }

   /* //传统jsp验证方法
    @RequestMapping(value = "admin_login", method = POST)
    public ModelAndView adminLogin(@RequestParam("name") String name, @RequestParam("password") String password) {
        ModelAndView modelAndView=new ModelAndView("/index");
        String right_password = userRepository.findPassByName(name);
        if (right_password!=null && right_password.equals(password)) {//测试
            modelAndView.addObject("songList", songRepository.showAllSong());
            modelAndView.addObject("name",name);
            modelAndView.addObject("password",password);
            modelAndView.setViewName("admin");
            return modelAndView;
        }
        else if(right_password==null){
            modelAndView.addObject("message","用户名填写错误");
            return modelAndView;
        }
        else if(!right_password.equals(password)){
            modelAndView.addObject("message","密码填写错误");
            return modelAndView;
        }
        else {
            return modelAndView;
        }
    }*/

    /**ajax验证方法 异步请求 减少不必要的请求  安全问题!!!*/
    @RequestMapping(value = "loginVerify", method = POST)
    @ResponseBody
    public ModelMap adminVerify(@RequestParam("name") String name, @RequestParam("password") String password) {
        ModelMap modelMap=new ModelMap();
        String right_password = userRepository.findPassByName(name);
        if (right_password!=null && right_password.equals(password)) {
            modelMap.addAttribute("isLogin",true);
            modelMap.addAttribute("name",name);
            return modelMap;
        }
        else if(right_password==null){
            modelMap.addAttribute("isLogin",false);
            modelMap.addAttribute("error_type","admin_name");
            modelMap.addAttribute("error_message","用户名填写错误");
            return modelMap;
        }
        else if(!right_password.equals(password)){
            modelMap.addAttribute("error_type","admin_password");
            modelMap.addAttribute("isLogin",false);
            modelMap.addAttribute("error_message","密码填写错误");
            return modelMap;
        }
        else {
            return modelMap;
        }
    }

    /**登录跳转 貌似很多网站直接都是js处理页面跳转逻辑,cookie(待求证) 安全问题如何解决?*/
    @RequestMapping(value = "adminLogin",method = POST)
    public String adminLogin(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletResponse res){
        String rightPassword = userRepository.findPassByName(name);
        if (rightPassword!=null && rightPassword.equals(password)) {
            //设置cookie session
            Cookie cookie=new Cookie("isLogin","true");
            cookie.setMaxAge(6000);
            res.addCookie(cookie);
            return "redirect:admin";
        }
        return "forward:/index";
    }
}
