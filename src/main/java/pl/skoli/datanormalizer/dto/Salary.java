package pl.skoli.datanormalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.skoli.datanormalizer.dto.enums.ContractType;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salary implements Serializable {

    private Integer minimum;
    private Integer maximum;
    private String currency;
    private ContractType contractType;
}
