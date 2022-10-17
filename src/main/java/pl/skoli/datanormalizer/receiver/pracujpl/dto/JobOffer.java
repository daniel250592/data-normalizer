package pl.skoli.datanormalizer.receiver.pracujpl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobOffer {

    private String jobTitle;
    private String employer;
    private String lastPublicated;
    private String expirationDate;
    private String salary;
    private String employmentLevel;
    private String remoteWork;
    private List<String> typesOfContract;
    private List<String> workSchedules;
    private List<String> workModes;
}
