package com.home24.task.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Alaeddine Khoudi .
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
