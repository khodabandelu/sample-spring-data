package org.mak.sample.springdata.jpa.generic.config.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HibernateFilter {
    public String name() default "defaultFilter";
    boolean enabled() default true;
    Class<?> c();
    FilterParam[] parameters() default {};
}
