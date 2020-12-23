package com.lennin.aniceto.nihongonaraimashou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class Lesson8_Vocab_Fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    public Lesson8_Vocab_Fragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[]{"beautiful/clean", "handsome", "kind", "famous", "healthy", "quiet", "lively", "noisy", "big/large", "small/little", "new", "old (refer to things)", "good", "bad", "hot", "cold (weather)", "cold (temperature)", "difficult", "easy", "expensive/high", "cheap", "low", "interesting", "boring", "delicious", "bad taste", "far", "near", "white", "black", "red", "blue", "yellow", "green", "examination", "homework", "food", "cheery blossom", "flower", "town/city", "mountain", "mt. fuji", "place", "how", "what kind", "which one", "cool", "warm", "heavy", "light", "rainy", "cloudy", "sunny", "wide", "narrow", "hard/tough", "and", "not so", "very",};

        children = new String[][]{
                {"きれい　「な」"},
                {"ハンサム　「な」"},
                {"しんせつ　「な」"},
                {"ゆうめい　「な」"},
                {"げんき　「な」"},
                {"しずか　「な」"},
                {"にぎやか　「な」"},
                {"うるさい"},
                {"おおきい"},
                {"ちいさい"},
                {"あたらしい"},
                {"ふるい"},
                {"いい／よい"},
                {"わるい"},
                {"あつい"},
                {"さむい"},
                {"つめたい"},
                {"むずかしい"},
                {"かんたん　「な」"},
                {"たかい"},
                {"やすい"},
                {"ひくい"},
                {"おもしろい"},
                {"つまらない"},
                {"おいしい"},
                {"まずい"},
                {"とおい"},
                {"ちかい"},
                {"しろい"},
                {"くろい"},
                {"あかい"},
                {"あおい"},
                {"きいろい"},
                {"みどり"},
                {"しけん"},
                {"しゅくだい"},
                {"たべもの"},
                {"さくら"},
                {"はな"},
                {"まち"},
                {"やま"},
                {"ふじさん"},
                {"ところ"},
                {"どう"},
                {"どんな"},
                {"どれ"},
                {"すずしい"},
                {"あたたかい"},
                {"おもい"},
                {"かるい"},
                {"あめ"},
                {"くもり"},
                {"はれ"},
                {"ひろい"},
                {"せまい"},
                {"たいへん"},
                {"そして"},
                {"あまり"},
                {"とても"},

        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lesson8_vocab, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expListView8);
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