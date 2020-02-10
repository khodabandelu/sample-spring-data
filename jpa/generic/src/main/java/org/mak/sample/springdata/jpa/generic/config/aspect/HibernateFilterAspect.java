package org.mak.sample.springdata.jpa.generic.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Aspect
@Component
public class HibernateFilterAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    EntityManager em;

    public Session getSession() {
        return em.unwrap(Session.class);
    }

    public void applyAuthorizeFilter() {
        Filter filter = getSession().enableFilter("defaultFilter");
        filter.setParameter("username", "ali");
    }

    public void disableDefaultFilter(String filtername) {
        getSession().disableFilter(filtername);
    }

    public void defaultFilterEnabled( Boolean enabled) {
        if (enabled) {
            applyAuthorizeFilter();
        } else {
            disableDefaultFilter("defaultFilter");
        }
    }


    public Map<String, Object> getParams(JoinPoint joinPoint, HibernateFilter hibernateFilter) {
        FilterDefs filterDefs = hibernateFilter.c().getAnnotation(FilterDefs.class);
        FilterDef filterDef = hibernateFilter.c().getAnnotation(FilterDef.class);
        Set<String> paramDefs = new HashSet<>();
        for (FilterDef filter : filterDefs.value()) {
            if (filter.name().equals(hibernateFilter.name())) {
                for (ParamDef param : filter.parameters()) {
                    paramDefs.add(param.name());
                }
            }
        }
        if (filterDef.name().equals(hibernateFilter.name())) {
            for (ParamDef param : filterDef.parameters()) {
                paramDefs.add(param.name());
            }
        }
        return getParamsFromMethod(joinPoint, paramDefs);
    }

    public Map<String, Object> getParamsFromMethod(JoinPoint joinPoint, Set<String> paramNames) {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < codeSignature.getParameterNames().length; i++) {
            String pName = codeSignature.getParameterNames()[i];
            if (paramNames.contains(pName)) {
                params.put(pName, joinPoint.getArgs()[i]);
            }
        }
        return params;
    }

    public void enableFilter(JoinPoint joinPoint, HibernateFilter hibernateFilter) {
        Map<String, Object> params = getParams(joinPoint, hibernateFilter);
        Filter filter = getSession().enableFilter(hibernateFilter.name());
        if (hibernateFilter.name().equals("authorizeFilter") && params.size() == 0) {
            filter.setParameter("userId", "mehdi");
        }else{
            params.forEach((name, value) -> {
                filter.setParameter(name, value);
            });
        }
    }

    @Before(value = "@annotation(hibernateFilter)")
    public void beforeaa(JoinPoint joinPoint, HibernateFilter hibernateFilter) {
        logger.info("Before invoke DefaultFilter of {}", joinPoint);
        if (hibernateFilter.enabled()) enableFilter(joinPoint, hibernateFilter);
    }

    @After(value = "@annotation(hibernateFilter)")
    public void afteraaa(JoinPoint joinPoint, HibernateFilter hibernateFilter) {
        logger.info("After invoke DefaultFilter of {}", joinPoint);
        if (hibernateFilter.enabled()) disableDefaultFilter(hibernateFilter.name());
    }

}