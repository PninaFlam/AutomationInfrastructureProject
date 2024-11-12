/**
 * The DriverAndLoggerExtension annotation is used to apply the TestWatcherProject and Extension extensions
 * to classes or methods in JUnit Jupiter tests.
 */
package org.example.Annotations;

import org.example.lifeCycle.Extension;
import org.example.lifeCycle.TestWatcherProject;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({TestWatcherProject.class, Extension.class})
public @interface DriverAndLoggerExtension {
}
