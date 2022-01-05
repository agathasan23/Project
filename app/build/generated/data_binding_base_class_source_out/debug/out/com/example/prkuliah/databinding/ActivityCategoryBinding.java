// Generated by view binder compiler. Do not edit!
package com.example.prkuliah.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.prkuliah.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCategoryBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imgBackCategory;

  @NonNull
  public final RecyclerView rvListEvent;

  @NonNull
  public final TextView tvCategory;

  private ActivityCategoryBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView imgBackCategory, @NonNull RecyclerView rvListEvent,
      @NonNull TextView tvCategory) {
    this.rootView = rootView;
    this.imgBackCategory = imgBackCategory;
    this.rvListEvent = rvListEvent;
    this.tvCategory = tvCategory;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCategoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_category, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCategoryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgBackCategory;
      ImageView imgBackCategory = ViewBindings.findChildViewById(rootView, id);
      if (imgBackCategory == null) {
        break missingId;
      }

      id = R.id.rvListEvent;
      RecyclerView rvListEvent = ViewBindings.findChildViewById(rootView, id);
      if (rvListEvent == null) {
        break missingId;
      }

      id = R.id.tvCategory;
      TextView tvCategory = ViewBindings.findChildViewById(rootView, id);
      if (tvCategory == null) {
        break missingId;
      }

      return new ActivityCategoryBinding((LinearLayout) rootView, imgBackCategory, rvListEvent,
          tvCategory);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
