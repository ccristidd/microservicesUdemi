package com.tutorial.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MarkerAnnotation {
 //this is an empty annootation. Marker Annotation provides high level instructions to the JVM
}
