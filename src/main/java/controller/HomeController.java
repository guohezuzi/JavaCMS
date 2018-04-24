package controller;

import data.SongRepository;
import data.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: guohezuzi
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

    @RequestMapping(value = "admin_login", method = POST)
    public String adminLogin(Model model, String name, String password) {
        String right_password = userRepository.findPassByName(name);
        if (right_password!=null && right_password.equals(password)) {
            model.addAttribute("songList", songRepository.showAllSong());
            model.addAttribute("isLogin",true);
            return "admin";
        }
        else {
            model.addAttribute("isLogin",false);
            return "forward:/index";
        }
    }
}
