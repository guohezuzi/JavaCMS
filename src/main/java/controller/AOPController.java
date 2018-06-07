package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: guohezuzi
 * \* Date: 18-2-5
 * \* Time: 下午2:19
 * \* Description:所有页面都需要的Controller
 * \
 */
@Controller
public class AOPController {
    /**对所有功能完成后返回首页的方法的控制器*/
    @RequestMapping(value = "/back",method = GET)
    public String backHome(){
        return "redirect:/";
    }
}
