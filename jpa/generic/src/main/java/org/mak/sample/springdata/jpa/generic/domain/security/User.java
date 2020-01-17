package org.mak.sample.springdata.jpa.generic.domain.security;

import lombok.*;
import org.mak.sample.springdata.jpa.generic.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "core_user")
public class User extends BaseEntity<String> {

    @Column(unique = true, length = 50, nullable = false)
    private String username;

    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;

}
