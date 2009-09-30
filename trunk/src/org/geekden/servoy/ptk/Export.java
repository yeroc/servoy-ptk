package org.geekden.servoy.ptk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Export
{
  static final String NULL = "@^$#@$%@JAVA-ANNOTATIONS-SUCK!@#%@";
  
  String[] parameters() default {};
  String sample() default NULL;
  String tooltip() default NULL;
}
