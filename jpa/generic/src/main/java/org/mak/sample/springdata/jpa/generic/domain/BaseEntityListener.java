package org.mak.sample.springdata.jpa.generic.domain;

import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;


@Component
public class BaseEntityListener {

    @PrePersist
    @PreUpdate
    private void initializeCreatedAt(Object object) {

        if (object instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) object;
            entity.setCreatedDate(new Date());
            entity.setUpdatedDate(new Date());
        }
    }

}
