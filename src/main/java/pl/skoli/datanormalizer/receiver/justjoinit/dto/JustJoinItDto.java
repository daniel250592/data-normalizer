package pl.skoli.datanormalizer.receiver.justjoinit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import pl.skoli.datanormalizer.deserialization.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class JustJoinItDto {

    private String title;
    private String city;
    @JsonProperty("workplace_type")
    private String workplaceType;
    @JsonProperty("company_name")
    private String companyName;
    @JsonProperty("company_url")
    private String companyUrl;
    @JsonProperty("experience_level")
    private String experienceLevel;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("published_at")
    private LocalDateTime publishedAt;
    private boolean remote;
    @JsonProperty("employment_types")
    private List<EmploymentTypes> employmentTypes;
    private List<Skill> skills;
}
