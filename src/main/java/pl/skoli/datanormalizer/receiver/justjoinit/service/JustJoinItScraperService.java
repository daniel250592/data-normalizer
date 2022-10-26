package pl.skoli.datanormalizer.receiver.justjoinit.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import pl.skoli.datanormalizer.interfaces.ScraperService;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.JustJoinItDto;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static pl.skoli.datanormalizer.constants.Constants.JUST_JOIN_IT;

@Component(JUST_JOIN_IT)
@RequiredArgsConstructor
@Log4j2
public class JustJoinItScraperService implements ScraperService<JustJoinItDto> {


    private static final String URL = "https://justjoin.it/api/offers/search?categories[]=Java";

    public List<JustJoinItDto> fetchData() {

        try (var httpClient = HttpClients.createDefault()) {
            var request = new HttpGet(URL);

            try (var response = httpClient.execute(request)) {
                var entity = response.getEntity();
                if (entity != null) {
                    var result = EntityUtils.toString(entity);

                    return new ObjectMapper().readValue(result, new TypeReference<List<JustJoinItDto>>() {
                    });
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }
}
