package frank.springbootstudy.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public Object logon(){
         Map<String ,String> map = new HashMap<>();
         map.put("man","jjj");
         map.put("rea","hkhk");
         return map;
    }
}
