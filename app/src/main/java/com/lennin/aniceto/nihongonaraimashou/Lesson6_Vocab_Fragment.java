package com.lennin.aniceto.nihongonaraimashou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class Lesson6_Vocab_Fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    public Lesson6_Vocab_Fragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[]{"to eat", "to drink", "to smoke a cigarette", " to write/draw/paint", "to read", "to listen", "to see/look at/ to watch", "to buy", "to take a photograph", "to do practical training", "to play tennis", "to do", "to meet a friend", "a meal/cooked rice", "breakfast", "lunch", "dinner", "bread", "egg", "meat", "fish", "vegetable", "apple", "milk", "green tea", "coffee", "black tea", "juice", "beer", "japanese rice wine", "water", "necktie", "shirt", "shoes", "(cassette) tape", "film", "picture", "movie", "together/with me", "after that/and then"};

        children = new String[][]{
                {"たべます"},
                {"のみます"},
                {"たばこをすいます"},
                {"かきます"},
                {"よみます"},
                {"ききます"},
                {"みます"},
                {"かいます"},
                {"しゃしんをとります"},
                {"じっしゅうします"},
                {"テニスをします"},
                {"します"},
                {"ともだちにあいます"},
                {"ごはん"},
                {"あさごはん"},
                {"ひるごはん"},
                {"ばんごはん"},
                {"パン"},
                {"たまご"},
                {"にく"},
                {"さかな"},
                {"やさい"},
                {"りんご"},
                {"ぎゅうにゅう/ミルク"},
                {"おちゃ"},
                {"コーヒー"},
                {"こうちゃ"},
                {"ジュース"},
                {"ビール"},
                {"さけ"},
                {"みず"},
                {"ネクタイ"},
                {"シャツ"},
                {"くつ"},
                {"カセットテープ"},
                {"フィルム"},
                {"しゃしん"},
                {"えいが"},
                {"いっしょに"},
                {"それから"}

        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lesson6_vocab, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expListView6);
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