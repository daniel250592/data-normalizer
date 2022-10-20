package pl.skoli.datanormalizer.receiver.solidjobs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SolidJobOuterDto {

    private String info;
    private String money;
    private String link;

}
