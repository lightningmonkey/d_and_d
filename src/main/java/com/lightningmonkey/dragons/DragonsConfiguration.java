package com.lightningmonkey.dragons;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;

public class DragonsConfiguration extends Configuration {
    @JsonProperty
    @NotEmpty
    private String characterTable;
}