package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // 보통 웹요청을 처리하는 클래스에 붙인다.
public class MainController {
    @GetMapping("/")  // HTTP Get요청을 처리. Controller가 있을 때만 GetMapping을 할 수 있다.
    public void index() {
        System.out.println("index() 메서드 호출!");
    }

    @GetMapping("/hello")
    public void hello() {
        System.out.println("hello() 메서드 호출!");
    }
}
