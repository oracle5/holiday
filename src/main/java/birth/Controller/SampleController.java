package birth.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/zzh")
public class SampleController {
    @RequestMapping("/hello")
    @ResponseBody
    public  String hello(){
        return "hello";
    }

    @RequestMapping("/happyNewYeah")
    public  String happy(){
        return "happy";
    }

    @RequestMapping("/setContentPage")
    public  String setContent(){
        return "setContent";
    }

    @RequestMapping("/leaveMsg")
    public String leaveMsg(@RequestParam("name") String name, @RequestParam("content") String content, HttpServletRequest request){
        HttpSession session=request.getSession();
        System.out.println("name:"+name);
        System.out.println("content:"+content);
        if(name!=null&&name.equals("zzh")){
            //先移除上一次的内容
            session.removeAttribute(name);
            //重新设置内容
            session.setAttribute(name,content);
            session.setMaxInactiveInterval(-1);
            return "setContent";
        }else {
            //先移除上一次的内容
            session.removeAttribute(name);
            session.removeAttribute("zzh");
            String con="新的一年，愿你将遇之人皆为挚友，愿你去往之地皆为热土。天高地阔，万事胜意。人海沧沧，顺遂无忧";
            //重新设置内容
            session.setAttribute(name,con);
            session.setMaxInactiveInterval(-1);
            return "error";
        }

    }
}
