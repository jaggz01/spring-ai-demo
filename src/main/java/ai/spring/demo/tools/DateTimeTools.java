package ai.spring.demo.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class DateTimeTools {

    @Tool(name = "Get Current Date Time in user zone",
            description = "Returns the current datetime of the user in the current zone they are in")
    public String getZonedCurrentDateTime() {
        log.info("Called Current Zoned Date Time");
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }
}
