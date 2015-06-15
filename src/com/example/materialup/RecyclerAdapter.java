package com.example.materialup;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends
		RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
	
	 private static onItemClickListener itemClickListener;
	
	public static interface onItemClickListener{
		public void onItemClick(View v,int position);
	}

	public RecyclerAdapter() {
	}

	@Override
	public int getItemCount() {
		return 100;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.txtViewTitle.setText("Test" + position);
		holder.imgViewIcon.setImageResource(R.drawable.ic_launcher);

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

		View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.recycler_item, viewGroup, false);

		return new ViewHolder(itemLayoutView);
	}

	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		public TextView txtViewTitle;
		public ImageView imgViewIcon;
		private CardView cardView;

		public ViewHolder(View view) {
			super(view);
			cardView = (CardView) itemView.findViewById(R.id.card_view);
			cardView.setCardElevation(20f);
			txtViewTitle = (TextView) view.findViewById(R.id.txt_name);
			imgViewIcon = (ImageView) view.findViewById(R.id.img_icon);
			view.setOnClickListener(this);

		}

		@Override
		public void onClick(View v) {
			if(itemClickListener != null){
				itemClickListener.onItemClick(v, getAdapterPosition());
			}
			
		}
	}
	 public void SetOnItemClickListener(final onItemClickListener mItemClickListener) {
	        RecyclerAdapter.itemClickListener = mItemClickListener;
	    }
}
