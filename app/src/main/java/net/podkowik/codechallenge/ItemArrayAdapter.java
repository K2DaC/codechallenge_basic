package net.podkowik.codechallenge;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cpodkowik on 19.07.17.
 */

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

    private int listItemLayout;
    private ArrayList<Item> itemList;
    private View.OnClickListener onClickListener;

    public ItemArrayAdapter(int layoutId, ArrayList<Item> itemList, View.OnClickListener onClickListener) {
        this.listItemLayout = layoutId;
        this.itemList = itemList;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view, onClickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        item.setText(itemList.get(listPosition).getName());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView item;

        public ViewHolder(View itemView, View.OnClickListener onClickListener) {
            super(itemView);
            itemView.setOnClickListener(onClickListener);
            item = (TextView) itemView.findViewById(R.id.row_item);
        }

    }
}
