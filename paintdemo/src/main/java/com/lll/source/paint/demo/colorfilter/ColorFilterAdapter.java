package com.lll.source.paint.demo.colorfilter;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lll.source.paint.demo.R;
import com.lll.source.paint.demo.utils.ColorFilter;

import java.util.List;

public class ColorFilterAdapter extends RecyclerView.Adapter<ColorFilterAdapter.MyViewHolder> {


    private LayoutInflater mInflater;
    private List<Pair<String, float[]>> filters;

    public ColorFilterAdapter(LayoutInflater mInflater, List<Pair<String, float[]>> filters) {
        this.mInflater = mInflater;
        this.filters = filters;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder;
        viewHolder = new MyViewHolder(mInflater.inflate(R.layout.colorfilter_list_item, parent, false));
        return viewHolder;
    }


    @Override
    public int getItemCount() {
        return filters.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ColorFilter.imageViewColorFilter(holder.imageView, filters.get(position).second);
        holder.mTitle.setText(filters.get(position).first);
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView mTitle;

        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.img);
            mTitle = view.findViewById(R.id.tv_text);
        }
    }
}
