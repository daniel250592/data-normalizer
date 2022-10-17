package pl.skoli.datanormalizer.receiver.pracujpl.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import pl.skoli.datanormalizer.receiver.pracujpl.dto.PracujPlDto;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class PracujPl {

    private static final String URL = "https://www.pracuj.pl/praca/joboffers/wholepoland?kw=java&pn=1&rop=100&sc=4";


    public List<PracujPlDto> fetchData() {

        try (var httpClient = HttpClients.createDefault()) {
            var request = new HttpGet(URL);

            try (var response = httpClient.execute(request);) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    var result = EntityUtils.toString(entity);

                    var objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                    return objectMapper.readValue(result, new TypeReference<List<PracujPlDto>>() {
                    });
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }
}
