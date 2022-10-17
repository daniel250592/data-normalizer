package pl.skoli.datanormalizer.receiver.pracujpl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PracujPlDto {

    private List<JobOffer> offers;
}
