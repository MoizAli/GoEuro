package goeuro.de.com.goeurotest;


import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import de.psdev.stabbedandroid.ForApplication;
import de.psdev.stabbedandroid.StabbedApplication;
import goeuro.de.com.goeurotest.events.DefaultEventBus;

public final class GoEuroApp extends StabbedApplication {


    @Inject
    @ForApplication
    protected DefaultEventBus mEventBusUtil;

    @Override
    public void onCreate() {
        super.onCreate();

        // register event bus
        mEventBusUtil.getEventBusImplementation().configureLogSubscriberExceptions(false);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new ApplicationModule(this));
    }
}