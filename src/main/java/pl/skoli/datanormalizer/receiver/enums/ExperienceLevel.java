package pl.skoli.datanormalizer.receiver.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
public enum ExperienceLevel {
    INTERN("intern"),
    JUNIOR("junior"),
    MID("mid"),
    SENIOR("senior");

    String description;
}
