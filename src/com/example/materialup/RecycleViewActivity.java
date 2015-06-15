package com.example.materialup;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.materialup.RecyclerAdapter.onItemClickListener;

public class RecycleViewActivity extends AppCompatActivity implements onItemClickListener{

	private RecyclerView recyclerView;
	private LinearLayoutManager mLayoutManager;
	private RecyclerAdapter adapter;
	private Toolbar toolbar;
	private CollapsingToolbarLayout collapsingToolbarLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycle_view);
		
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
		if(toolbar!=null){
			toolbar.setTitle("RecyclerView");
			setSupportActionBar(toolbar);
			collapsingToolbarLayout.setTitle("RecyclerView");
			getSupportActionBar().setDisplayShowHomeEnabled(true);
			
		}
		
		recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		
			recyclerView.setHasFixedSize(true);

	        // Setting the LayoutManager.
	        mLayoutManager = new LinearLayoutManager(this);
	        recyclerView.setLayoutManager(mLayoutManager);
	        adapter =  new RecyclerAdapter();
	        recyclerView.setAdapter(adapter);
	        adapter.SetOnItemClickListener(this);
	        recyclerView.setItemAnimator(new DefaultItemAnimator());
	}

	@Override
	public void onItemClick(View v, int position) {
		
		Snackbar.make(recyclerView, "Item "+position+" Click Performed ", Snackbar.LENGTH_LONG)
		.show();
	}
}
