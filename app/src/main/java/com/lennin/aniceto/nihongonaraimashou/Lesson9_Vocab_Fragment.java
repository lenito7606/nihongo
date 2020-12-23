package com.lennin.aniceto.nihongonaraimashou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class Lesson9_Vocab_Fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    public Lesson9_Vocab_Fragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[]{"to understand", "to have", "like", "dislike", "good at", "poor at", "hiragana script", "katakana script", "roman alphabet", "chinese characters", "dish (cooked food)", "fruit", "drinks", "pork meat", "chicken meat", "beef meat", "orange", "banana", "music", "song", "dance", "guitar", "sports", "soccer", "tennis", "time", "many", "a little/a few", "well", "almost", "not at all", "of course", "why", "because", "illness/sickness", "medicine", "head", "stomach", "have a headache", "have a fever", "have caught a cold", "to take day off from company"};

        children = new String[][]{
                {"わかります"},
                {"あります"},
                {"すき　「な」"},
                {"きらい　「な」"},
                {"じょうず　「な」"},
                {"へた　「な」"},
                {"ひらがな"},
                {"かたかな"},
                {"ローマじ"},
                {"かんじ"},
                {"りょうり"},
                {"くだもの"},
                {"のみもの"},
                {"ぶたにく"},
                {"とりにく"},
                {"きゅうにく"},
                {"みかん"},
                {"バナナ"},
                {"おんがく"},
                {"うた"},
                {"ダンス"},
                {"キター"},
                {"スポーツ"},
                {"サッカー"},
                {"テニス"},
                {"じかん"},
                {"たくさん"},
                {"すこし"},
                {"よく"},
                {"だいたい"},
                {"ぜんぜん"},
                {"もちろん"},
                {"どうして／なぜ"},
                {"から"},
                {"びょうき"},
                {"くすり"},
                {"あたま"},
                {"おなか"},
                {"あたま　が　いたい"},
                {"ねつ　が　あります"},
                {"かぜ　を　ひきました"},
                {"かいしゃ　を　やすみます"},


        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lesson9_vocab, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expListView9);
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