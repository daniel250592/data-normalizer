package pl.skoli.datanormalizer.dto.enums;

public enum ContractType {

    B2B,
    PERMANENT_CONTRACT, UNKNOWN;

    public static ContractType parseContract(final String type) {
        //TODO Implement parsing proper values
        return B2B;
    }
}
