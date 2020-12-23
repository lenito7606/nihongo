package com.lennin.aniceto.nihongonaraimashou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class Lesson5_Vocab_Fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    public Lesson5_Vocab_Fragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[]{"to go", "to come", "to go home/to return", "factory", "railway station", "bank", "hospital", "department store", "supermarket", "bookshop", "dormitory", "suffix for month", "what month", "first of the month", "second/two days", "third/three days", "fourth/four days", "fifth/five days", "sixth/six days", "seventh/seven days", "eighth/eight days", "ninth/nine days", "tenth/ten days", "fourteenth/fourteen days", "twentieth/twenty days", "twenty fourth/twenty four days", "-th day of the month/days", "which day of the month/how many days", "when", "last week", "this week", "next week", "last month", "this month", "next month", "last year", "this year", "next year", "birthday", "bicycle", "airplane", "ship", "electric train", "bus", "taxi", "subway", "bullet train", "by foot", "friend", "sweetheart", "alone", "-th platform"};

        children = new String[][]{
                {"ikimasu いきます"},
                {"kimasu きます"},
                {"kaerimasu かえります"},
                {"koujou こうじょう"},
                {"eki えき"},
                {"ginkou ぎんこう"},
                {"byouin びょういん"},
                {"depa-to デパート"},
                {"su-pa-　スーパー"},
                {"honya ほんや"},
                {"ryou りょう"},
                {"-gatsu がつ"},
                {"nan gatsu なんがつ"},
                {"tsuitachi　ついたち"},
                {"futsuka ふつか"},
                {"mikka みっか"},
                {"yokka よっか"},
                {"itsuka いつか"},
                {"muika むいか"},
                {"nanoka なのか"},
                {"youka ようか"},
                {"kokonoka ここのか"},
                {"tooka とおか"},
                {"juuyokka じゅうよっか"},
                {"hatsuka はつか"},
                {"nijuu yokka にじゅうよっか"},
                {"-nichi にち"},
                {"nan nichi なんにち"},
                {"itsu いつ"},
                {"senshuu せんしゅう"},
                {"konshuu こんしゅう"},
                {"raishuu らいしゅう"},
                {"sengetsu　せんげつ"},
                {"kongetsu こんげつ"},
                {"raigetsu らいげつ"},
                {"kyonen きょうねん"},
                {"kotoshi ことし"},
                {"rainen らいねん"},
                {"tanjoubi たんじょうび"},
                {"jitensha じてんしゃ"},
                {"hikouki ひこうき"},
                {"fune ふね"},
                {"densha でんしゃ"},
                {"busu バス"},
                {"takushi- タクシー"},
                {"chikatetsu ちかてつ"},
                {"shinkansen しんかんせん"},
                {"aruite あるいて"},
                {"tomodachi　ともだち"},
                {"koibito こいびと"},
                {"hitori de ひとりで"},
                {"-bansen ばんぜん"},




        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lesson5_vocab, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expListView5);
        lv.setAdapter(new ExpandableListAdapter(groups, children));
        lv.setGroupIndicator(null);

    }

    public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private final LayoutInflater inf;
        private String[] groups;
        private String[][] children;

        public ExpandableListAdapter(String[] groups, String[][] children) {
            this.groups = groups;
            this.children = children;
            inf = LayoutInflater.from(getActivity());
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_item, parent, false);
                holder = new ViewHolder();

                holder.text = (TextView) convertView.findViewById(R.id.lblListItem);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getChild(groupPosition, childPosition).toString());

            return convertView;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_group, parent, false);

                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.lblListHeader);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getGroup(groupPosition).toString());

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private class ViewHolder {
            TextView text;
        }
    }
}