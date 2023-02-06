package com.devedroy.mydoc.views.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devedroy.mydoc.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerDemoAdapter extends RecyclerView.Adapter<RecyclerDemoAdapter.ViewHolder> {
    List<DemoData> mDemoData = new ArrayList();
    Context context;

    public RecyclerDemoAdapter(Context context, List<DemoData> myListData) {
        this.mDemoData = myListData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerDemoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View myView = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDemoAdapter.ViewHolder holder, int position) {
        holder.nameTextView.setText(mDemoData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDemoData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
//        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.rvText);
//            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            public TextView textView = itemView.findViewById(R.id.rvText);
//        }
//    }
}
