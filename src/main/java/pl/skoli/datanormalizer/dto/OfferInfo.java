package pl.skoli.datanormalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.skoli.datanormalizer.dto.enums.Seniority;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferInfo {

    private String title;
    private String company;
    private String city;
    private Seniority seniority;
    private final LocalDateTime fetchDate = LocalDateTime.now();

}
