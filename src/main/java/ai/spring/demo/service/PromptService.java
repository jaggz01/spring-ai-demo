package ai.spring.demo.service;

import ai.spring.demo.tools.DateTimeTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PromptService {

    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Autowired
    private DateTimeTools dateTimeTools;

    public String getChatMessage(String message) {
        return ollamaChatModel.call(new Prompt(message,
                OllamaOptions.builder()
                        .model(OllamaModel.LLAMA3_2)
                        .toolCallbacks(ToolCallbacks.from(dateTimeTools))
                        .build())).getResult().getOutput().getText();
    }
}
