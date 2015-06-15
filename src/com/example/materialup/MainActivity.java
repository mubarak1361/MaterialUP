package com.example.materialup;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.Builder;
import android.support.v7.graphics.Palette.Swatch;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
	
	private ImageView imgMaterial;
	private Builder palette;
	private Bitmap bitmap;
	private TextView txtVibrant,txtLightVibrant,txtDarkVibrant,txtMuted,txtLightMuted,txtDarkMuted;
	private Swatch vibrantSwatch,vibrantLightSwatch,vibrantDarkSwatch,mutedSwatch,mutedLightSwatch,mutedDarkSwatch;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMaterial  = (ImageView) findViewById(R.id.img_material);
        
        txtVibrant = (TextView) findViewById(R.id.txt_vibrant);
        txtLightVibrant= (TextView) findViewById(R.id.txt_light_vibrant);
        txtDarkVibrant = (TextView) findViewById(R.id.txt_dark_vibrant);
       
        txtMuted = (TextView) findViewById(R.id.txt_muted);
        txtLightMuted = (TextView) findViewById(R.id.txt_light_muted);
        txtDarkMuted = (TextView) findViewById(R.id.txt_dark_muted);
        
        bitmap =  BitmapFactory.decodeResource(getResources(), R.drawable.material);
        imgMaterial.setImageBitmap(bitmap);
        palette = Palette.from(bitmap);
        vibrantSwatch = palette.generate().getVibrantSwatch();
		vibrantLightSwatch = palette.generate().getLightVibrantSwatch();
		vibrantDarkSwatch = palette.generate().getDarkVibrantSwatch();
		
		mutedSwatch = palette.generate().getMutedSwatch();
		mutedLightSwatch = palette.generate().getLightMutedSwatch();
		mutedDarkSwatch = palette.generate().getDarkMutedSwatch();
        		
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(vibrantSwatch.getRgb()));
        try{
        txtVibrant.setBackgroundColor(vibrantSwatch.getRgb());
        txtLightVibrant.setBackgroundColor(vibrantLightSwatch.getRgb());
        txtDarkVibrant.setBackgroundColor(vibrantDarkSwatch.getRgb());
        
        txtMuted.setBackgroundColor(mutedSwatch.getRgb());
        txtLightMuted.setBackgroundColor(mutedLightSwatch.getRgb());
        txtDarkMuted.setBackgroundColor(mutedDarkSwatch.getRgb());
        }
        catch(Exception e){
        	Log.e("Exception", e.getMessage());
        }
        
        
    
    }

	@Override
	public void onClick(View v) {
		
	}
}
