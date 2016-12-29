package com.example.enclaveit.version1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.enclaveit.version1.R;
import com.example.enclaveit.version1.model.bean.RssItem;

import java.util.List;

public class RssAdapter extends BaseAdapter {

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
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.itemTitle.setText(items.get(position).getTitle());
		holder.itemDescription.setText(items.get(position).getDescription());
		return convertView;
	}

	public static class ViewHolder {
		TextView itemTitle;
		TextView itemDescription;
	}
}
