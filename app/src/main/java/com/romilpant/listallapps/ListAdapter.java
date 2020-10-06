package com.romilpant.listallapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    public LayoutInflater layoutInflater;
    public List<AppList> installedApps;

    public ListAdapter(Context context, List<AppList> customList) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        installedApps = customList;
    }

    @Override
    public int getCount() {
        return installedApps.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);

            listViewHolder.appIcon = (ImageView) convertView.findViewById(R.id.icon);
            listViewHolder.appName = (TextView) convertView.findViewById(R.id.app_name);
            listViewHolder.appPackage = (TextView) convertView.findViewById(R.id.app_package);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ViewHolder) convertView.getTag();
        }

        listViewHolder.appIcon.setImageDrawable(installedApps.get(position).getAppIcon());
        listViewHolder.appName.setText(installedApps.get(position).getAppName());
        listViewHolder.appPackage.setText(installedApps.get(position).getAppPackage());

        return convertView;
    }

    class ViewHolder {
        ImageView appIcon;
        TextView appName;
        TextView appPackage;
    }
}
