package raghav.akash.dialogtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DialogTestActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dialog_test);
    TopDialog topDialog = new TopDialog();
    topDialog.show(getFragmentManager(), "topDialog");
  }
}
