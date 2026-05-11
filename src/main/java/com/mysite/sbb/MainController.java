package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // 보통 웹요청을 처리하는 클래스에 붙인다.
public class MainController {
    @GetMapping("/sbb")  // HTTP Get요청을 처리. Controller가 있을 때만 GetMapping을 할 수 있다.
    @ResponseBody
    public String index() {
        return "SBB";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "안녕하세요.";
    }

    @GetMapping("/")  // 리다이렉션
    public String root() {
        return "redirect:/question/list";
    }
}
