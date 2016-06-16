package rx.android.content;

import android.database.ContentObserver;
import android.os.Handler;
import android.net.Uri;

public class LambdaContentObserver extends ContentObserver {

    private Handler handler;

    public LambdaContentObserver(Handler handler) {
        super(handler);

        this.handler = handler;
    }

    public interface Action1<T> {
        void call(T t);
    }

    public interface Action2<T, T2> {
        void call(T t, T2 t2);
    }

    Action1<Boolean> onChange;
    Action2<Boolean, Uri> onChange2;

    @Override
    public void onChange(boolean selfChange) {
        if (onChange == null) return;

        onChange.call(selfChange);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        if (onChange2 == null) return;

        onChange2.call(selfChange, uri);
    }

    public LambdaContentObserver onChange(Action1<Boolean> onChange) {
        this.onChange = onChange;
        return this;
    }

    public LambdaContentObserver onChange(Action2<Boolean, Uri> onChange) {
        this.onChange2 = onChange;
        return this;
    }
}
