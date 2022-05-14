package com.jongjh.recyclerviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.ViewHolder> {

    private ArrayList<String> imgData = null;
    private ArrayList<String> nameData = null;
    private ArrayList<String> stateData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView textName;
        TextView textState;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.deviceImg);
            textName = itemView.findViewById(R.id.deviceName);
            textState = itemView.findViewById(R.id.deviceState);

        }
    }
    historyAdapter(ArrayList<String> imgList, ArrayList<String> nameList, ArrayList<String> stateList){
        imgData = imgList;
        nameData = nameList;
        stateData = stateList;
    }

    @NonNull
    @Override
    public historyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.history_item,parent,false);
        historyAdapter.ViewHolder vh = new historyAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull historyAdapter.ViewHolder holder, int position) {
        String img = imgData.get(position);
        String name = nameData.get(position);
        String cnt = stateData.get(position);

        holder.imgView.setImageResource(getResId(img,R.drawable.class));
        holder.textName.setText(name);
        holder.textState.setText(cnt);
    }

    @Override
    public int getItemCount() {
        return nameData.size();
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
