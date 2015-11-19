package com.cascada.annotations;

import java.lang.annotation.*;

/**
 * Created by Jbernard on 11/19/2015.
 */

    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Layout {
        String value();
    }

