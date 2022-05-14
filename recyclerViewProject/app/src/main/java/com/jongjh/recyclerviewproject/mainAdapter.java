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

public class mainAdapter extends RecyclerView.Adapter<mainAdapter.ViewHolder> {

    private ArrayList<String> imgData = null;
    private ArrayList<String> nameData = null;
    private ArrayList<String> cntData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView textName;
        TextView textCnt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.deviceImg);
            textName = itemView.findViewById(R.id.deviceName);
            textCnt = itemView.findViewById(R.id.deviceCnt);

        }
    }

    mainAdapter(ArrayList<String> imgList, ArrayList<String> nameList, ArrayList<String> cntList){
        imgData = imgList;
        nameData = nameList;
        cntData = cntList;
    }

    @NonNull
    @Override
    public mainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.main_item,parent,false);
        mainAdapter.ViewHolder vh = new mainAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull mainAdapter.ViewHolder holder, int position) {
        String img = imgData.get(position);
        String name = nameData.get(position);
        String cnt = cntData.get(position);

        holder.imgView.setImageResource(getResId(img,R.drawable.class));
        holder.textName.setText(name);
        holder.textCnt.setText(cnt);
    }

    @Override
    public int getItemCount() {
        return cntData.size();
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
