package ai.spring.demo.service;

import ai.spring.demo.tools.DateTimeTools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PromptService {

    private final OllamaChatModel ollamaChatModel;
    private final DateTimeTools dateTimeTools;

    @Value("${ollama.model:llama3.2}")
    private OllamaModel OLLAMA_MODEL;

    public String getChatMessage(String message) {
        return ollamaChatModel
                .call(new Prompt(message,
                OllamaOptions.builder()
                        .model(OLLAMA_MODEL)
                        .toolCallbacks(ToolCallbacks.from(dateTimeTools))
                        .build()))
                .getResult().getOutput().getText();
    }
}
