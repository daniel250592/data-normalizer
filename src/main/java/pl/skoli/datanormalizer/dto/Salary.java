package pl.skoli.datanormalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.skoli.datanormalizer.dto.enums.ContractType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    private Integer from;
    private Integer to;
    private String currency;
    private ContractType contractType;
}
