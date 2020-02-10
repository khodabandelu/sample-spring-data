package org.mak.sample.springdata.jpa.generic.dto.security;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseSearch implements Serializable {
    private String search;
}
