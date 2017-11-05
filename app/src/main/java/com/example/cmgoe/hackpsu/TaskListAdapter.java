package com.example.cmgoe.hackpsu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Task;

/**
 * Created by cmgoe on 11/5/2017.
 */

public class TaskListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Task> mDataSource;

    public TaskListAdapter(Context context, ArrayList<Task> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_design, parent, false);

        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(R.id.task_list_subtitle);

        // Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(R.id.task_list_title);

        // Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(R.id.task_tags);

        Task task = (Task) getItem(position);

        titleTextView.setText(task.getShortDesc());
        subtitleTextView.setText(task.getDescription());
        detailTextView.setText(task.getTags().toString());

        //Picasso.with(mContext).load(design.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        return rowView;
    }

}
