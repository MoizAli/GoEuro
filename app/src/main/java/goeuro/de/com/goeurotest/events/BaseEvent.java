package goeuro.de.com.goeurotest.events;

import javax.annotation.Nullable;

public abstract class BaseEvent<T> {

    protected final boolean mSuccessful;

    @Nullable
    protected final Exception mException;

    @Nullable
    protected T mContent;

    protected BaseEvent(final boolean successful) {
        this(successful, null);
    }

    protected BaseEvent(final T content) {
        this(content != null, null);
        mContent = content;
    }

    protected BaseEvent(final Exception exception) {
        this(false, exception);
    }

    protected BaseEvent(final boolean successful, @Nullable final Exception exception) {
        mSuccessful = successful;
        mException = exception;
    }

    public boolean isSuccessful() {
        return mSuccessful;
    }

    @Nullable
    public Exception getException() {
        return mException;
    }

    @Nullable
    public T getContent() {
        return mContent;
    }
}
