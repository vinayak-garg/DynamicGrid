package org.askerov.dynamicgrid.example;

/**
 * Author: alex askerov
 * Date: 9/9/13
 * Time: 10:52 PM
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.askerov.dynamicgrid.BaseDynamicGridAdapter;

import java.util.List;

/**
 * Author: alex askerov
 * Date: 9/7/13
 * Time: 10:56 PM
 */
public class CheeseDynamicAdapter extends BaseDynamicGridAdapter {
    private final int SIZE;

    public CheeseDynamicAdapter(Context context, List<?> items, int columnCount, int itemSize) {
        super(context, items, columnCount);
        SIZE = itemSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CheeseViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_grid, null);
            holder = new CheeseViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (CheeseViewHolder) convertView.getTag();
        }
        holder.build(getItem(position).toString());
        return convertView;
    }

    private class CheeseViewHolder {
        private TextView titleText;
        private ImageView image;

        private CheeseViewHolder(View view) {
            titleText = (TextView) view.findViewById(R.id.item_title);
            image = (ImageView) view.findViewById(R.id.item_img);
            //RelativeLayout layout = (RelativeLayout)view.findViewById(R.id.item_layout);
            image.getLayoutParams().width = SIZE;
            image.getLayoutParams().height = SIZE;
        }

        void build(String title) {
            titleText.setText(title);
            image.setImageResource(R.drawable.ic_launcher);
        }
    }
}