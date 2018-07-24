package com.home24.task.di.component;


import com.home24.task.di.PerActivity;
import com.home24.task.di.module.ActivityModule;
import com.home24.task.ui.review.ReviewActivity;
import com.home24.task.ui.select.SelectActivity;
import com.home24.task.ui.splash.SplashActivity;
import com.home24.task.ui.start.StartActivity;

import dagger.Component;

/**
 * Created by Alaeddine Khoudi .
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(SplashActivity activity);

  void inject(StartActivity activity);

  void inject(SelectActivity activity);

  void inject(ReviewActivity activity);
}
