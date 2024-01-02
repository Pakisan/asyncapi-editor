package com.github.pakisan.asyncapieditor.views.modals.createnewspecification.dto;

public record CreateNewSpecification(
        String specificationName,
        String specificationDescription,
        SpecificationVersion specificationVersion,
        SpecificationTemplate specificationTemplate
) {
}
