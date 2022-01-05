// Generated by view binder compiler. Do not edit!
package com.example.prkuliah.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.prkuliah.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDashboardBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final CardView cView1;

  @NonNull
  public final CardView cView2;

  @NonNull
  public final CardView cView3;

  @NonNull
  public final CardView cView4;

  @NonNull
  public final CardView cView5;

  @NonNull
  public final CardView cView6;

  @NonNull
  public final FrameLayout fmViewDashboard;

  @NonNull
  public final ImageView imgAddEvent;

  @NonNull
  public final ImageView imgNavigation;

  @NonNull
  public final GridLayout mainGrid2;

  @NonNull
  public final RecyclerView rvListEvent;

  private ActivityDashboardBinding(@NonNull ScrollView rootView, @NonNull CardView cView1,
      @NonNull CardView cView2, @NonNull CardView cView3, @NonNull CardView cView4,
      @NonNull CardView cView5, @NonNull CardView cView6, @NonNull FrameLayout fmViewDashboard,
      @NonNull ImageView imgAddEvent, @NonNull ImageView imgNavigation,
      @NonNull GridLayout mainGrid2, @NonNull RecyclerView rvListEvent) {
    this.rootView = rootView;
    this.cView1 = cView1;
    this.cView2 = cView2;
    this.cView3 = cView3;
    this.cView4 = cView4;
    this.cView5 = cView5;
    this.cView6 = cView6;
    this.fmViewDashboard = fmViewDashboard;
    this.imgAddEvent = imgAddEvent;
    this.imgNavigation = imgNavigation;
    this.mainGrid2 = mainGrid2;
    this.rvListEvent = rvListEvent;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cView1;
      CardView cView1 = ViewBindings.findChildViewById(rootView, id);
      if (cView1 == null) {
        break missingId;
      }

      id = R.id.cView2;
      CardView cView2 = ViewBindings.findChildViewById(rootView, id);
      if (cView2 == null) {
        break missingId;
      }

      id = R.id.cView3;
      CardView cView3 = ViewBindings.findChildViewById(rootView, id);
      if (cView3 == null) {
        break missingId;
      }

      id = R.id.cView4;
      CardView cView4 = ViewBindings.findChildViewById(rootView, id);
      if (cView4 == null) {
        break missingId;
      }

      id = R.id.cView5;
      CardView cView5 = ViewBindings.findChildViewById(rootView, id);
      if (cView5 == null) {
        break missingId;
      }

      id = R.id.cView6;
      CardView cView6 = ViewBindings.findChildViewById(rootView, id);
      if (cView6 == null) {
        break missingId;
      }

      id = R.id.fmViewDashboard;
      FrameLayout fmViewDashboard = ViewBindings.findChildViewById(rootView, id);
      if (fmViewDashboard == null) {
        break missingId;
      }

      id = R.id.imgAddEvent;
      ImageView imgAddEvent = ViewBindings.findChildViewById(rootView, id);
      if (imgAddEvent == null) {
        break missingId;
      }

      id = R.id.imgNavigation;
      ImageView imgNavigation = ViewBindings.findChildViewById(rootView, id);
      if (imgNavigation == null) {
        break missingId;
      }

      id = R.id.mainGrid2;
      GridLayout mainGrid2 = ViewBindings.findChildViewById(rootView, id);
      if (mainGrid2 == null) {
        break missingId;
      }

      id = R.id.rvListEvent;
      RecyclerView rvListEvent = ViewBindings.findChildViewById(rootView, id);
      if (rvListEvent == null) {
        break missingId;
      }

      return new ActivityDashboardBinding((ScrollView) rootView, cView1, cView2, cView3, cView4,
          cView5, cView6, fmViewDashboard, imgAddEvent, imgNavigation, mainGrid2, rvListEvent);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}