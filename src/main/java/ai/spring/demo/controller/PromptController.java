package ai.spring.demo.controller;

import ai.spring.demo.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptController {

    @Autowired
    private PromptService promptService;

    @RequestMapping("/ai/v1/chat")
    public String getChatMessage(@RequestParam(name = "message") String message) {
        return promptService.getChatMessage(message);
    }


}
