package pl.skoli.datanormalizer.mapper.justjoinit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.skoli.datanormalizer.dto.Offer;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.JustJoinItDto;

import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JustJoinItMapper {

    public static final JustJoinItMapper INSTANCE = new JustJoinItMapper();
    static final OfferMapper offerMapper = OfferMapper.INSTANCE;

    public List<Offer> mapToFinalDto(List<JustJoinItDto> justJoinItDtoList) {

        return justJoinItDtoList.stream()
                .map(offerMapper::mapToOffer)
                .collect(Collectors.toList());
    }
}
