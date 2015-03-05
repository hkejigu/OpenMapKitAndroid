package org.redcross.openmapkit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by SpatialDeveloper on 3/5/15.
 */
public class TagListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private Map<String, String> mTagMap;

    private ArrayList<String> mTagKeys;

    private ViewHolder mViewHolder;

    public TagListAdapter(Activity activity, Map<String, String> tagMap) {

        mTagMap = tagMap;

        //to allow us to look up
        Set<String> keys = tagMap.keySet();
        mTagKeys = new ArrayList<>();
        for(String key: keys) {
            mTagKeys.add(key);
        }

        mInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Implementing Adapter inherited abstract methods
     */
    public int getCount() {

        return mTagMap.size();
    }

    /**
     * Implementing Adapter inherited abstract methods
     */
    public Object getItem(int arg0) {

        return null;
    }

    /**
     * Implementing Adapter inherited abstract methods
     */
    public long getItemId(int position) {

        return 0;
    }

    /**
     * Implementing Adapter inherited abstract methods
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        //create the view for an individual list view item ...

        View view = convertView;

        if(convertView == null) {

            view = mInflater.inflate(R.layout.taglistviewitem, null);

            mViewHolder = new ViewHolder();

            mViewHolder.textViewTagKey = (TextView)view.findViewById(R.id.textViewTagKey); //left side tag key

            mViewHolder.textViewTagValue = (TextView)view.findViewById(R.id.textViewTagValue); //left side tag value

            view.setTag(mViewHolder);
        }
        else {

            mViewHolder = (ViewHolder)view.getTag();
        }


        //get key for current position
        String currentTagKey = mTagKeys.get(position);

        //use the key to fetch item
        String currentTagValue = mTagMap.get(currentTagKey);

        //set tag key text
        mViewHolder.textViewTagKey.setText(currentTagKey);

        //set tag value text
        mViewHolder.textViewTagValue.setText(currentTagValue);

        /*
        //get the current Invasive Species object in the list
        InvasiveSpecies currentInvasiveSpecies = this.menuItems.get(position);


        //set title (e.g. use common name)
        String title = currentInvasiveSpecies.getCommonName();

        mViewHolder.textViewTitle.setText(title);


        //set subtitle (e.g. use scientific name)
        String subTitle = currentInvasiveSpecies.getScientificName();

        mViewHolder.textViewSubtitle.setText(subTitle);


        //set image
        String imageName = currentInvasiveSpecies.getImageName();

        String uri = "drawable/" + imageName;

        int imageResource = view.getContext().getApplicationContext().getResources().getIdentifier(uri, null, view.getContext().getApplicationContext().getPackageName());

        Drawable image = view.getContext().getResources().getDrawable(imageResource);

        mViewHolder.imageViewIcon.setImageDrawable(image);
        */

        return view;
    }

    static class ViewHolder{

        TextView textViewTagKey;

        TextView textViewTagValue;
    }
}


