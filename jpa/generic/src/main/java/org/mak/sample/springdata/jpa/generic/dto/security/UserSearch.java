package org.mak.sample.springdata.jpa.generic.dto.security;

import lombok.Data;

@Data
public class UserSearch extends BaseSearch {
    private String username;
    private String password;
}
