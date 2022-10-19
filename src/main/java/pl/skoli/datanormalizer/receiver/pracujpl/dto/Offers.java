package pl.skoli.datanormalizer.receiver.pracujpl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offers {

    private String offerUrl;
    private List<String> cities;
    private String label;
}
