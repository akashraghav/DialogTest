package raghav.akash.dialogtest;

import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created on 11/7/17.
 *
 * @author raghav
 */

public class TopDialog extends DialogFragment {

  RelativeLayout container;
  TextView text1;
  TextView text2;
  Button toggleBtn;
  boolean isText1Visible;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setStyle(DialogFragment.STYLE_NO_TITLE, R.style.TopDialog);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_simple_overlay, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    container = (RelativeLayout) view.findViewById(R.id.container);

    text1 = new TextView(getActivity());
    RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    params1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
    params1.topMargin = 50;
    text1.setLayoutParams(params1);
    text1.setGravity(Gravity.CENTER);
    text1.setTextColor(getResources().getColor(android.R.color.white));
    text1.setText("This is text one.");

    text2 = new TextView(getActivity());
    RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    params2.addRule(RelativeLayout.CENTER_IN_PARENT);
    text2.setLayoutParams(params2);
    text2.setGravity(Gravity.CENTER);
    text2.setTextColor(getResources().getColor(android.R.color.white));
    text2.setText("This is text two.");

    toggleBtn = new Button(getActivity());
    RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    params3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    params3.addRule(RelativeLayout.CENTER_HORIZONTAL);
    params3.bottomMargin = 30;
    toggleBtn.setLayoutParams(params3);
    toggleBtn.setText("Toggle");

    isText1Visible = true;

    toggleBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        getDialog().getWindow().getDecorView().invalidate();
        getDialog().getWindow().getDecorView().postInvalidate();
        getDialog().getWindow().getDecorView().refreshDrawableState();
        if (isText1Visible) {
          container.removeView(text1);
          container.addView(text2);
          isText1Visible = false;
        } else {
          container.removeView(text2);
          container.addView(text1);
          isText1Visible = true;
        }
      }
    });

    container.addView(text1);
    container.addView(toggleBtn);
  }

  /**
   * Make dialog background transparent
   */
  @Override
  public void onStart() {
    super.onStart();
    Window window = getDialog().getWindow();
    if (window != null) {
      window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }
  }

}