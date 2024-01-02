package com.github.pakisan.asyncapieditor.views.modals.createnewspecification.dto;

public enum SpecificationVersion {

    V3_0_0("3.0.0");

    private final String version;

    SpecificationVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return version;
    }

}
