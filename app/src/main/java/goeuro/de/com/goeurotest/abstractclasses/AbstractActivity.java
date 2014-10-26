package goeuro.de.com.goeurotest.abstractclasses;

import java.util.Arrays;
import java.util.List;

import de.psdev.stabbedandroid.StabbedActivity;
import goeuro.de.com.goeurotest.ActivityModule;


public abstract class AbstractActivity extends StabbedActivity{

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new ActivityModule(this));
    }
}
