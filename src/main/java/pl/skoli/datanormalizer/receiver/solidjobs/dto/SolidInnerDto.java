package pl.skoli.datanormalizer.receiver.solidjobs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolidInnerDto {

    private String title;
    private String city;
    private String companyName;
    private Boolean remote;
    private String skills;
    private String url;
    private String salary;
    private String contractType;
}
