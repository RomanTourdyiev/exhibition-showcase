package com.exhibits.showcase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.exhibits.model.Exhibit;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tourdyiev Roman on 4/21/19.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<Exhibit> exhibits;

    public RVAdapter(List<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exhibit, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder viewHolder, int i) {

        int position = viewHolder.getAdapterPosition();
        viewHolder.title.setText(exhibits.get(position).getTitle());
        viewHolder.imagesContainer.removeAllViews();
        String[] images = exhibits.get(position).getImages();
        for (int j = 0; j < images.length; j++) {
            ImageView imageView = new ImageView(viewHolder.itemView.getContext());
            imageView.setAdjustViewBounds(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(
                    viewHolder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.small_padding),
                    viewHolder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.small_padding),
                    viewHolder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.small_padding),
                    viewHolder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.small_padding)
            );
            imageView.setLayoutParams(layoutParams);
            Glide.with(viewHolder.itemView.getContext()).load(images[j]).into(imageView);
            viewHolder.imagesContainer.addView(imageView);
        }

    }

    @Override
    public int getItemCount() {
        return exhibits.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected LinearLayout imagesContainer;

        ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            imagesContainer = view.findViewById(R.id.images_container);
        }

    }
}
