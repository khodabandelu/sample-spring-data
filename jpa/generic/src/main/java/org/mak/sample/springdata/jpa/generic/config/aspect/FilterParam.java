package org.mak.sample.springdata.jpa.generic.config.aspect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface FilterParam {
    String name();

//    String type();

}
