package com.example.enclaveit.version3.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enclaveit.version3.R;
import com.example.enclaveit.version3.model.bean.RssItem;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class RssAdapter extends BaseAdapter{

	private final List<RssItem> items;
	private final Context context;

	public RssAdapter(Context context, List<RssItem> items) {
		this.items = items;
		this.context = context;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.row_list_view, null);
			holder = new ViewHolder();
			holder.itemTitle = (TextView) convertView.findViewById(R.id.title);
			holder.itemDescription = (TextView) convertView.findViewById(R.id.description);
			holder.itemPic = (ImageView) convertView.findViewById(R.id.image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.itemTitle.setText(items.get(position).getTitle());
		holder.itemDescription.setText(items.get(position).getDescription());
		ImageAsyncTask imageAsyncTask = new ImageAsyncTask(holder.itemPic,items.get(position).getUrlPicture());
		imageAsyncTask.execute();
		return convertView;
	}

	public static class ViewHolder {
		TextView itemTitle;
		TextView itemDescription;
		ImageView itemPic;
	}

	class ImageAsyncTask extends AsyncTask<Object,Void,Bitmap>{

		private ImageView imv;
		private String path;

		public ImageAsyncTask(ImageView img,String url){
			this.imv = img;
			this.path = url;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(Bitmap bitmap) {
			super.onPostExecute(bitmap);
			imv.setImageBitmap(bitmap);
		}

		@Override
		protected Bitmap doInBackground(Object... objects) {
			try{
				Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(path).getContent());
				return bitmap;
			}catch (Exception ex){
				Log.d("Error",ex.getMessage().toString());
			}
			return null;
		}
		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}
	}
}
