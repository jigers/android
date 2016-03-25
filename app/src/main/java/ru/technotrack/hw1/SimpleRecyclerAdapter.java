package ru.technotrack.hw1;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private final WeakReference<LayoutInflater> mInflater;
    private TextGenerator textGenerator = new TextGenerator();

    public SimpleRecyclerAdapter(LayoutInflater inflater) {
        mInflater = new WeakReference<>(inflater);
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = mInflater.get();
        if (inflater != null) {
            if (viewType == 0) {
                return new SimpleViewHolder(inflater.inflate(R.layout.item_layout_even, parent, false));
            } else {
                return new SimpleViewHolder(inflater.inflate(R.layout.item_layout_odd, parent, false));
            }
        }
        else {
            Log.d("HW1.logs", "Failed to get inflater onCreateViewHolder");
            throw new RuntimeException("Some error happens.");
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position + 1) % 2;
    }


    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        Log.d("HW1.logs","displaying number: " + Integer.toString(position + 11));
        holder.setText(textGenerator.generate(position + 1));
    }

    @Override
    public int getItemCount() {
        return 1000000;
    }
}
