package pl.skoli.datanormalizer.dto.enums;

public enum Seniority {
    JUNIOR(new String[]{"junior", "intern", "początkujący"}),
    MID(new String[]{"mid", "regular"}),
    SENIOR(new String[]{"senior", "architect", "architekt", "lead"}),
    UNKNOWN(new String[]{""});

    private final String[] options;

    Seniority(String[] options) {
        this.options = options;
    }

    private static boolean isContain(final String[] roles, final String role) {
        String searchedRole = role.toLowerCase();
        for (String patternRole : roles) {
            if (searchedRole.contains(patternRole)) {
                return true;
            }
        }
        return false;
    }

    public static Seniority parseSeniority(final String experienceLevel) {

        if (isContain(JUNIOR.options, experienceLevel)) {
            return JUNIOR;
        } else if (isContain(MID.options, experienceLevel)) {
            return MID;
        } else if (isContain(SENIOR.options, experienceLevel)) {
            return SENIOR;
        }
        return UNKNOWN;
    }
}
