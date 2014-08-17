package com.oostudy.android.drawermenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.oostudy.android.R;

public class DrawerMenuFragment extends Fragment {


    private static final String TAG = DrawerMenuFragment.class.getSimpleName();

    private ListView mDrawerListView;

    private OnDrawerMenuSelectedListener mOnDrawerMenuSelectedListener;


    /**
     * OnDrawerMenuSelectedListener
     */
    public interface OnDrawerMenuSelectedListener {

        void onMenuItemSelected();

    }
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof OnDrawerMenuSelectedListener) {
            mOnDrawerMenuSelectedListener = (OnDrawerMenuSelectedListener) activity;
        } else {
            Log.e(TAG, "Attached to activity which is not instance of OnDrawerMenuSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drawer_menu, container, false);
        mDrawerListView = (ListView)rootView.findViewById(R.id.drawer_list_view);
        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        createDrawerMenus();
    }


    private void createDrawerMenus() {
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                createMenuItemData(),
                R.layout.view_drawer_menu_item,
                new String[] {"MENU_ITEM_NAME",    "MENU_ITEM_SUMMARY"},
                new int[]    {R.id.menu_item_name, R.id.menu_item_summary}
                );
        mDrawerListView.setAdapter(adapter);
        mDrawerListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

            }

        });
    }

    private List<Map<String, Object>> createMenuItemData() {
        String[] itemNames = getResources().getStringArray(R.array.drawer_menu_item_names);
        String[] itemSummarys = getResources().getStringArray(R.array.drawer_menu_item_summarys);
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>(itemNames.length);
        for (int i = 0; i < itemNames.length; i++) {
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("MENU_ITEM_NAME", itemNames[i]);
            map.put("MENU_ITEM_SUMMARY", itemSummarys[i]);
            data.add(map);
        }

        return data;
    }

}