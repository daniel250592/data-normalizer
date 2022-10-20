package pl.skoli.datanormalizer.dto.enums;

public enum Seniority {
    JUNIOR,
    MID,
    SENIOR;

    public static Seniority parseSeniority(String experienceLevel) {

        //TODO write implementation which will be responsible for parsing seniority level
        return JUNIOR;
    }
}
