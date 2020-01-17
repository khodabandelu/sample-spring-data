package org.mak.sample.springdata.jpa.generic.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @param <T>
 * @author aa.azizkhani
 */
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 4295229462159851306L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private T id;

    @Column(name = "createdby", updatable = false)
    private String createdBy;

    @Column(name = "updatedby")
    private String updatedBy;

    @Column(name = "createddate", updatable = false)
    private Date createdDate = new Date();

    @Column(name = "updateddate")
    private Date updatedDate = new Date();

    @Column(name = "ip")
    private String ip = "127.0.0.1";

    public BaseEntity(T id) {
        super();
        this.setId(id);
    }

}
