package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller// 보통 웹요청을 처리하는 클래스에 붙인다.
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")  // HTTP Get요청을 처리. Controller가 있을 때만 GetMapping을 할 수 있다.
    @ResponseBody
    public String list() {
        List<Question> questions = questionRepository.findAll();

        String questionList = questions
                .stream()
                .map(q -> "<li>%d / %s</li>".formatted(q.getId(), q.getSubject()))
                .collect(Collectors.joining("\n"));

        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>질문 목록</title>
                </head>
                <body>
                    <h1>질문 목록</h1>
                    <ul>
                        %s
                    </ul>
                </body>
                </html>
                """.formatted(questionList);
    }

}
