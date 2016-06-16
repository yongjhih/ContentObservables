package android.content.observables.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.jakewharton.rxbinding.widget.RxTextView;
import rx.Subscription;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

public class SampleActivity extends Activity {

  CompositeSubscription subscriptions = new CompositeSubscription();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sample_activity);
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    subscriptions.unsubscribe();
  }
}
