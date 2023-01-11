package de.congstar.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface PageUrl {

    /**
     * Konfigurationsparameter für die zu verwendende URL.
     */
    String value();
}
