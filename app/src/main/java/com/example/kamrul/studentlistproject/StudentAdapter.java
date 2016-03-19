package com.example.kamrul.studentlistproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kamrul on 3/17/2016.
 */
public class StudentAdapter extends ArrayAdapter<Student> {
    private ArrayList<Student> studentArrayList;
    private Context context;

    public StudentAdapter(Context context,ArrayList<Student> studentArrayList) {
        super(context, R.layout.demolayout,studentArrayList);
        this.studentArrayList = studentArrayList;
        this.context = context;
        this.studentArrayList=studentArrayList;
    }
    static class ViewHolder{
        TextView idTV;
        TextView nameTV;
        TextView emailTV;
        TextView phoneTV;
        TextView addressTV;
        TextView passwordTV;
        ImageView imgView;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
    ViewHolder viewHolder;
        if (view==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.demolayout, null);
            viewHolder = new ViewHolder();
            viewHolder.idTV = (TextView) view.findViewById(R.id.showId);
            viewHolder.nameTV = (TextView) view.findViewById(R.id.showName);
            viewHolder.emailTV = (TextView) view.findViewById(R.id.showEmail);
            viewHolder.phoneTV = (TextView) view.findViewById(R.id.showPhone);
            viewHolder.addressTV = (TextView) view.findViewById(R.id.showAddress);
            viewHolder.passwordTV = (TextView) view.findViewById(R.id.showPassword);
            viewHolder.imgView = (ImageView) view.findViewById(R.id.showImg);
            view.setTag(viewHolder);

        }else {
            viewHolder =(ViewHolder)view.getTag();
        }
        viewHolder.idTV.setText("ID : "+Integer.toString(studentArrayList.get(position).getId()));
        viewHolder.nameTV.setText("NAME : "+studentArrayList.get(position).getName());
        viewHolder.emailTV.setText("EMAIL : "+studentArrayList.get(position).getEmail());
        viewHolder.phoneTV.setText("PHONE : "+studentArrayList.get(position).getPhone());
        viewHolder.addressTV.setText("ADDRESS : "+studentArrayList.get(position).getAddress());
        viewHolder.passwordTV.setText("PASSWORD : "+studentArrayList.get(position).getPassword());

        viewHolder.imgView.setImageResource(studentArrayList.get(position).getImageId());



        return view;
    }
}
