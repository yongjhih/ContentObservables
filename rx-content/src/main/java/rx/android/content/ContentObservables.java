package rx.android.content;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

public class ContentObservables {

    public ContentObservables() {
    }

    private Context context;

    public ContentObservables from(Context context) {
        this.context = context;
        return this;
    }

    private Handler handler;
    public ContentObservables with(Handler handler) {
        this.handler = handler;
        return this;
    }

    private Uri uri;
    public ContentObservables on(Uri uri) {
        this.uri = uri;
        return this;
    }

    private boolean descendants = true;
    /**
     * @param descendants default true
     */
    public ContentObservables descendants(boolean descendants) {
        this.descendants = descendants;
        return this;
    }

    public ContentObservables subscribe(ContentObserver observer) {
        context.getContentResolver().registerContentObserver(uri, descendants, observer);
        return this;
    }

    public ContentObservables subscribe(LambdaContentObserver.Action1<Boolean> onChange) {
        if (handler == null) throw new IllegalStateException();
        context.getContentResolver().registerContentObserver(uri, descendants, new LambdaContentObserver(handler).onChange(onChange));
        return this;
    }

    public ContentObservables subscribe(LambdaContentObserver.Action2<Boolean, Uri> onChange) {
        if (handler == null) throw new IllegalStateException();
        context.getContentResolver().registerContentObserver(uri, descendants, new LambdaContentObserver(handler).onChange(onChange));
        return this;
    }
}
