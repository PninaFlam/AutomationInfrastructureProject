/**
 * The Retry3TimesExtension annotation is used to apply the RetryExtension extension
 * to classes or methods in JUnit Jupiter tests with a retry count of 3 times.
 */
package org.example.Annotations;

import org.example.lifeCycle.RetryExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(RetryExtension.class)
public @interface Retry3TimesExtension {
}
