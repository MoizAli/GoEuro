package goeuro.de.com.goeurotest.events;

import android.util.Log;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;
import de.greenrobot.event.NoSubscriberEvent;
import de.greenrobot.event.SubscriberExceptionEvent;
import goeuro.de.com.goeurotest.BuildConfig;


public final class DefaultEventBus {


    private static final Object LOCK = new Object();

    private static DefaultEventBus instance;

    private DefaultEventBus() {
    }

    /**
     * Gets the single instance of {@link DefaultEventBus}.
     *
     * @return single instance of {@link DefaultEventBus}
     */
    public static DefaultEventBus getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new DefaultEventBus();
                }
            }
        }

        return instance;
    }

    /**
     * Registers given {@link Object} to {@link de.greenrobot.event.EventBus}.
     *
     * @param subscriber the subscriber {@link Object}
     */
    public void register(final Object subscriber) {
        try {
            if (!EventBus.getDefault().isRegistered(subscriber)) {
                EventBus.getDefault().register(subscriber);
                Log.e("Register '{}'", subscriber.getClass().getSimpleName());
            }
        } catch (final EventBusException exception) {
            Log.e("Error",exception.getMessage());
        }
    }

    /**
     * Unregister given {@link Object} from {@link de.greenrobot.event.EventBus}.
     *
     * @param subscriber the subscriber {@link Object}
     */
    public void unregister(final Object subscriber) {
        if (EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().unregister(subscriber);
            Log.e("Unregister '{}'", subscriber.getClass().getSimpleName());
        }
    }

    /**
     * Default {@link de.greenrobot.event.SubscriberExceptionEvent} subscriber method.
     *
     * @param event the {@link de.greenrobot.event.SubscriberExceptionEvent}
     */
    public void subscriberException(final SubscriberExceptionEvent event) {
        if (BuildConfig.DEBUG) {
            Log.e("'{}' in event '{}' in class '{}'" + event.causingSubscriber.getClass().getSimpleName() +
                    event.causingEvent.getClass().getCanonicalName(), event.throwable.toString(), event.throwable);
        }
    }

    /**
     * Default {@link de.greenrobot.event.NoSubscriberEvent} subscriber method
     *
     * @param event the {@link de.greenrobot.event.SubscriberExceptionEvent}
     */
    public void noSubscriberException(final NoSubscriberEvent event) {
        if (BuildConfig.DEBUG) {
            Log.e("NoSubscriberEvent for event '{}'", event.originalEvent.getClass().getCanonicalName());
        }
    }

    /**
     * Returns the concrete {@link de.greenrobot.event.EventBus} implementation
     *
     * @return the {@link de.greenrobot.event.EventBus}
     */
    public EventBus getEventBusImplementation() {
        return EventBus.getDefault();
    }

    /**
     * Returns a sticky post event and remove it from event bus
     *
     * @param eventType the event type class
     * @param <T>       the class type
     * @return the instance
     */
    public <T> T getStickyEventAndRemoveIt(final Class<T> eventType) {
        final T stickyEvent = getEventBusImplementation().getStickyEvent(eventType);
        if (stickyEvent != null) {
            getEventBusImplementation().removeStickyEvent(stickyEvent);
        }

        return stickyEvent;
    }

    /**
     * Posts given {@link Object} to subscribers on {@link de.greenrobot.event.EventBus}
     *
     * @param event the event to post
     */
    public void post(final Object event) {
        EventBus.getDefault().post(event);
    }

    /**
     * Posts given {@link Object} to subscribers on {@link de.greenrobot.event.EventBus} as sticky message
     *
     * @param event the event to post
     */
    public void postSticky(final Object event) {
        EventBus.getDefault().postSticky(event);
    }
}
