package pl.skoli.datanormalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer implements Serializable {

    private OfferInfo offerInfo;
    private List<Salary> salaryList;
    private Technologies technologies;
}
