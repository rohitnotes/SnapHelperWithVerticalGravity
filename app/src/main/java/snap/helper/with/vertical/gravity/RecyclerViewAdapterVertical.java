package snap.helper.with.vertical.gravity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class RecyclerViewAdapterVertical  extends RecyclerView.Adapter<RecyclerViewAdapterVertical.ItemViewHolder>
{
    private Context activity_context;
    private ArrayList<RecyclerViewItemModel> recyclerViewItemModelArrayList;

    public RecyclerViewAdapterVertical(Context context,ArrayList<RecyclerViewItemModel> recyclerViewItemModelArrayList)
    {
        this.activity_context = context;
        this.recyclerViewItemModelArrayList = recyclerViewItemModelArrayList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(activity_context).inflate(R.layout.recycler_view_item_row_vertical, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, final int position) {

        RecyclerViewItemModel currentItem = recyclerViewItemModelArrayList.get(position);
        ((ItemViewHolder)itemViewHolder).setData(currentItem);
    }

    @Override
    public int getItemCount() {
        return recyclerViewItemModelArrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView itemImageView;
        private TextView itemTextView;

        public ItemViewHolder(View itemView)
        {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.image_view);
            itemTextView = itemView.findViewById(R.id.text_view);
        }

        public void setData(RecyclerViewItemModel recyclerViewItemModel)
        {
            itemTextView.setText(recyclerViewItemModel.getName());
            itemImageView.setImageResource(recyclerViewItemModel.getDrawable());
        }
    }
}
