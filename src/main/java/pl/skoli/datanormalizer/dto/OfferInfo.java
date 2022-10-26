package pl.skoli.datanormalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.skoli.datanormalizer.dto.enums.Seniority;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferInfo implements Serializable {

    private String title;
    private String company;
    private String city;
    private Seniority seniority;
//    private final LocalDateTime fetchDate = LocalDateTime.now();

}
