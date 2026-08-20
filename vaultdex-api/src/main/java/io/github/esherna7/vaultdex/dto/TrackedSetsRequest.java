package io.github.esherna7.vaultdex.dto;

public record TrackedSetsRequest (
    String setCode
){

    public static TrackedSetsRequest of(String setCode) {
        return new TrackedSetsRequest(setCode);
    }
}
