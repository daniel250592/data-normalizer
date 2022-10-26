package pl.skoli.datanormalizer.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skoli.datanormalizer.dto.Offer;
import pl.skoli.datanormalizer.interfaces.ScraperService;
import pl.skoli.datanormalizer.mapper.justjoinit.JustJoinItMapper;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.JustJoinItDto;

import java.util.List;
import java.util.Map;

import static pl.skoli.datanormalizer.constants.Constants.JUST_JOIN_IT;

//@Component
@RestController
@RequiredArgsConstructor
public class ScheduledTask {

    private final Map<String, ScraperService> scraperServiceMap;
    private final JustJoinItMapper justJoinIt = JustJoinItMapper.INSTANCE;
    private final RabbitTemplate rabbitTemplate;

    //    @Scheduled(fixedDelay = 3600)
    @GetMapping("/sent")
    public String collectDataAndSend() throws JsonProcessingException {

        List<JustJoinItDto> justJoinItDtoList = scraperServiceMap.get(JUST_JOIN_IT).fetchData();
        List<Offer> offers = justJoinIt.mapToFinalDto(justJoinItDtoList);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(offers);


        rabbitTemplate.convertAndSend("offers", s);

        return "send";

    }


}
