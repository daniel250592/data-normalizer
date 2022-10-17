package pl.skoli.datanormalizer.receiver.justjoinit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EmploymentTypes {

    private String type;
    private SalaryDto salary;
}
