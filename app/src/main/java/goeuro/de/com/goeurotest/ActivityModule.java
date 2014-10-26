package goeuro.de.com.goeurotest;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.psdev.stabbedandroid.ForActivity;
import de.psdev.stabbedandroid.StabbedActivity;

/**
 * This module represents objects which exist only for the scope of a single activity. We can
 * safely create singletons using the activity instance because the entire object graph will only
 * ever exist inside of that activity.
 */
@Module(complete =  false, library = true, addsTo = ApplicationModule.class, injects = {
        // activities
        MyActivity.class,

        // fragments

        // views
})
public final class ActivityModule {

    private final StabbedActivity mActivity;

    public ActivityModule(final StabbedActivity activity) {
        mActivity = activity;
    }

    /**
     * Allow the activity context to be injected but require that it be annotated with
     * {@link de.psdev.stabbedandroid.ForActivity @ForActivity} to explicitly differentiate it from application context.
     */
    @Provides
    @Singleton
    @ForActivity
    Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @Singleton
    @ForActivity
    Resources provideResources() {
        return mActivity.getResources();
    }

    @Provides
    @Singleton
    LayoutInflater provideLayoutInflater() {
        return mActivity.getLayoutInflater();
    }

    @Provides
    @Singleton
    @ForActivity
    FragmentManager provideFragmentManager() {
        return mActivity.getFragmentManager();
    }

}