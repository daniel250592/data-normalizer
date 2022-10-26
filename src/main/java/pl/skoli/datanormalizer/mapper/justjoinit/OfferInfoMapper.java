package pl.skoli.datanormalizer.mapper.justjoinit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.skoli.datanormalizer.dto.OfferInfo;
import pl.skoli.datanormalizer.dto.enums.Seniority;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.JustJoinItDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class OfferInfoMapper {

    static final OfferInfoMapper INSTANCE = new OfferInfoMapper();

    public OfferInfo getOfferInfo(final JustJoinItDto justJoinItDto) {
        return OfferInfo.builder()
                .title(justJoinItDto.getTitle())
                .company(justJoinItDto.getCompanyName())
                .city(justJoinItDto.getCity())
                .seniority(Seniority.parseSeniority(justJoinItDto.getExperienceLevel()))
                .build();
    }
}
