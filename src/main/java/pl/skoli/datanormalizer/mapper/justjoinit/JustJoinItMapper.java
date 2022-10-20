package pl.skoli.datanormalizer.mapper.justjoinit;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.skoli.datanormalizer.dto.Offer;
import pl.skoli.datanormalizer.dto.OfferInfo;
import pl.skoli.datanormalizer.dto.Salary;
import pl.skoli.datanormalizer.dto.Technologies;
import pl.skoli.datanormalizer.dto.enums.ContractType;
import pl.skoli.datanormalizer.dto.enums.Seniority;
import pl.skoli.datanormalizer.dto.interfaces.ScraperService;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.JustJoinItDto;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.Skill;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JustJoinItMapper {

    @Qualifier("justJoinItScraperService")
    private final ScraperService scraperService;

    @PostConstruct
    public void call() {
        List<Offer> data = getData();
        System.out.println();
    }

    public List<Offer> getData() {
        List<JustJoinItDto> scrapedData = (List<JustJoinItDto>) scraperService.fetchData();

        List<Offer> collect = scrapedData.stream()
                .map(this::mapToOffer)
                .collect(Collectors.toList());
        return collect;
    }

    private Offer mapToOffer(JustJoinItDto justJoinItDto) {

        return Offer.builder()
                .offerInfo(getOfferInfo(justJoinItDto))
                .salary(getSalary(justJoinItDto))
                .technologies(gerTechnologies(justJoinItDto))
                .build();
    }

    private OfferInfo getOfferInfo(final JustJoinItDto justJoinItDto) {
        return OfferInfo.builder()
                .title(justJoinItDto.getTitle())
                .company(justJoinItDto.getCompanyName())
                .city(justJoinItDto.getCity())
                .seniority(Seniority.parseSeniority(justJoinItDto.getExperienceLevel()))
                .build();
    }

    private List<Salary> getSalary(final JustJoinItDto justJoinItDto) {

        return justJoinItDto.getEmploymentTypes().stream()
                .map(type -> {
                    if (type.getSalary() != null) {
                        return Salary.builder()
                                .from(type.getSalary().getFrom())
                                .to(type.getSalary().getTo())
                                .currency(type.getSalary().getCurrency())
                                .contractType(ContractType.parseContract(type.getType()))
                                .build();
                    } else {
                        return Salary.builder()
                                .from(0)
                                .to(0)
                                .currency("Not defined")
                                .contractType(ContractType.UNKNOWN)
                                .build();

                    }
                })
                .collect(Collectors.toList());


    }

    private Technologies gerTechnologies(final JustJoinItDto justJoinItDto) {

        return new Technologies(justJoinItDto.getSkills().stream()
                .map(Skill::getName)
                .collect(Collectors.toList()));
    }
}
