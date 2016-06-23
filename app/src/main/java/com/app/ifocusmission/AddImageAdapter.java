package com.app.ifocusmission;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.app.ifcousmission.R;

public class AddImageAdapter extends BaseAdapter
{
	 Context mycontext = null;
	    int galitembg = 0;
	    
	    public int[] IMAGE_IDS = { R.drawable.ic_launcher, R.drawable.ic_launcher,
	        R.drawable.ic_launcher, R.drawable.ic_launcher,
	        R.drawable.ic_launcher, R.drawable.ic_launcher,
	        R.drawable.ic_launcher, R.drawable.ic_launcher,
	        R.drawable.ic_launcher, R.drawable.ic_launcher};
	    
	    public AddImageAdapter(Context c) 
	    {
	        mycontext = c;
	       TypedArray typArray = mycontext.obtainStyledAttributes(R.styleable.Theme);
	       galitembg = typArray.getResourceId(R.styleable.ActionBar_background, 0);
	      typArray.recycle();
	    }

	 @Override
	 public int getCount()
	 {
	  return IMAGE_IDS.length;
	 }

	 @Override
	 public Object getItem(int position) 
	 {
	  return position;
	 }

	 @Override
	 public long getItemId(int position) 
	 {
	  return position;
	 }

	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) 
	 {
	  ImageView imageview = new ImageView(mycontext);
	        imageview.setImageResource(IMAGE_IDS[position]);
	        imageview.setScaleType(ImageView.ScaleType.FIT_XY);
	        return imageview;
	 }

	}