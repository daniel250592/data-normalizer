package pl.skoli.datanormalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    private OfferInfo offerInfo;
    private List<Salary> salary;
    private Technologies technologies;
}
