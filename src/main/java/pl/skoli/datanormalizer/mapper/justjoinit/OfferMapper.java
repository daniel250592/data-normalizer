package pl.skoli.datanormalizer.mapper.justjoinit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.skoli.datanormalizer.dto.Offer;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.JustJoinItDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class OfferMapper {

    static final OfferMapper INSTANCE = new OfferMapper();
    private final OfferInfoMapper offerInfoMapper = OfferInfoMapper.INSTANCE;
    private final SalaryMapper salaryMapper = SalaryMapper.INSTANCE;
    private final TechnologiesMapper technologiesMapper = TechnologiesMapper.INSTANCE;

    public Offer mapToOffer(final JustJoinItDto justJoinItDto) {

        return Offer.builder()
                .offerInfo(offerInfoMapper.getOfferInfo(justJoinItDto))
                .salaryList(salaryMapper.getSalary(justJoinItDto))
                .technologies(technologiesMapper.gerTechnologies(justJoinItDto))
                .build();
    }
}
