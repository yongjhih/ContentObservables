package rx.android.content;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

public class ContentObservable {

    public ContentObservable() {
    }

    private Context context;

    public ContentObservable from(Context context) {
        this.context = context;
        return this;
    }

    private Handler handler;
    public ContentObservable with(Handler handler) {
        this.handler = handler;
        return this;
    }

    private Uri uri;
    public ContentObservable on(Uri uri) {
        this.uri = uri;
        return this;
    }

    private boolean descendants = true;
    /**
     * @param descendants default true
     */
    public ContentObservable descendants(boolean descendants) {
        this.descendants = descendants;
        return this;
    }

    public ContentObservable subscribe(ContentObserver observer) {
        context.getContentResolver().registerContentObserver(uri, descendants, observer);
        return this;
    }

    public ContentObservable subscribe(LambdaContentObserver.Action1<Boolean> onChange) {
        if (handler == null) throw new IllegalStateException();
        context.getContentResolver().registerContentObserver(uri, descendants, new LambdaContentObserver(handler).onChange(onChange));
        return this;
    }

    public ContentObservable subscribe(LambdaContentObserver.Action2<Boolean, Uri> onChange) {
        if (handler == null) throw new IllegalStateException();
        context.getContentResolver().registerContentObserver(uri, descendants, new LambdaContentObserver(handler).onChange(onChange));
        return this;
    }
}
