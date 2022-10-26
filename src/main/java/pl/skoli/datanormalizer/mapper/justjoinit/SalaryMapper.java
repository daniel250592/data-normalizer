package pl.skoli.datanormalizer.mapper.justjoinit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.skoli.datanormalizer.dto.Salary;
import pl.skoli.datanormalizer.dto.enums.ContractType;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.EmploymentTypes;
import pl.skoli.datanormalizer.receiver.justjoinit.dto.JustJoinItDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class SalaryMapper {

    static final SalaryMapper INSTANCE = new SalaryMapper();

    public List<Salary> getSalary(final JustJoinItDto justJoinItDto) {

        return justJoinItDto.getEmploymentTypes().stream()
                .map(parseSalary())
                .collect(Collectors.toList());
    }

    private Function<EmploymentTypes, Salary> parseSalary() {
        return type -> {
            if (type.getSalary() != null) {
                return Salary.builder()
                        .from(type.getSalary().getFrom())
                        .to(type.getSalary().getTo())
                        .currency(type.getSalary().getCurrency())
                        .contractType(ContractType.parseContract(type.getType()))
                        .build();
            } else {
                return defaultSalary();

            }
        };
    }

    private Salary defaultSalary() {
        return Salary.builder()
                .from(0)
                .to(0)
                .currency("Not defined")
                .contractType(ContractType.UNKNOWN)
                .build();
    }
}
