package goeuro.de.com.goeurotest;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.psdev.stabbedandroid.ForApplication;
import goeuro.de.com.goeurotest.events.DefaultEventBus;

/**
 * Application-wide dependencies. A module for Android-specific
 * dependencies which require a {@link android.content.Context} or {@link android.app.Application} to create.
 * <p/>
 * https://github.com/square/dagger/tree/master/examples/android-activity-graphs
 */
@Module(library = true, injects = {
    // application
        GoEuroApp.class
}, includes = {
    // sub modules
})
public final class ApplicationModule {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationModule.class);

    private final Application mApplication;

    public ApplicationModule(final Application application) {
        mApplication = application;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link de.psdev.stabbedandroid.ForApplication @ForApplication} to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication
    public Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    @ForApplication
    public Resources provideResources() {
        return mApplication.getResources();
    }

    @Provides
    @Singleton
    @ForApplication
    public DefaultEventBus provideEventBus() {
        return DefaultEventBus.getInstance();
    }
}