package com.infiniteapps.stickynotes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class StickyAdapter extends RecyclerView.Adapter<StickyAdapter.StickyViewHolder>{

    private Context mContext;
    private ArrayList<String> mListData;

    public StickyAdapter(Context mContext, ArrayList<String> mListData) {
        this.mContext = mContext;
        this.mListData = mListData;
    }


    public class StickyViewHolder extends RecyclerView.ViewHolder{

        public TextView stickyName;
        public TextView stickyDescription;
        public CheckBox stickyPinButton;


        public StickyViewHolder(@NonNull View itemView) {

            super(itemView);
            stickyName = itemView.findViewById(R.id.stickyName);
            stickyDescription = itemView.findViewById(R.id.stickyDescription);
            stickyPinButton = itemView.findViewById(R.id.stickyPinButton);
        }
    }

    @NonNull
    @Override
    public StickyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflatedView = LayoutInflater.from(mContext).inflate(R.layout.list_item,viewGroup,false);
        return new StickyViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull StickyViewHolder viewHolder, int position) {
        String name = mListData.get(position).substring(0,6);
        String desc = mListData.get(position);
        boolean checked = !viewHolder.stickyPinButton.isChecked();

        viewHolder.stickyPinButton.setChecked(checked);
        viewHolder.stickyName.setText(name);
        viewHolder.stickyDescription.setText(desc);
    }

    @Override
    public int getItemCount() {
        return mListData.size();

    }
}
