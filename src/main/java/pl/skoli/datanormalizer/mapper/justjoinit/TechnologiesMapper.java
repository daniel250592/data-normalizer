package pl.skoli.datanormalizer.mapper.justjoinit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.skoli.datanormalizer.dto.Technologies;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.JustJoinItDto;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.Skill;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class TechnologiesMapper {

    static final TechnologiesMapper INSTANCE = new TechnologiesMapper();

    public Technologies gerTechnologies(final JustJoinItDto justJoinItDto) {
        return new Technologies(justJoinItDto.getSkills().stream()
                .map(Skill::getName)
                .collect(Collectors.toList()));
    }
}
