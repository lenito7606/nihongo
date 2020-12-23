package com.lennin.aniceto.nihongonaraimashou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class Lesson7_Vocab_Fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    public Lesson7_Vocab_Fragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[]{"to cut", "to repair", "to make a phone call", " to give", "to receive", "to teach", "to learn", "to lend", "to borrow", "to send", "chopsticks", "hand", "knife", "fork", "spoon", "scissors", "screwdriver", "wrench", "cutting pliers", "money", "present", "report", "family", "someone else father", "my father", "someone else mother", "my mother", "someone else older brother", "my older brother", "someone else older sister", "my older sister", "someone else younger brother", "my younger brother", "someone else younger sister", "my younger sister", "someone else wife", "my wife", "my husband", "someone else husband", "child/children", "english language", "suffix for language", "already", "not yet", "soon/from now on"};

        children = new String[][]{
                {"きります"},
                {"しゅうりします"},
                {"でんわをかけます"},
                {"あげます"},
                {"もらいます"},
                {"おしえます"},
                {"ならいます"},
                {"かします"},
                {"かります"},
                {"おくります"},
                {"はし"},
                {"て"},
                {"ナイフ"},
                {"フォーク"},
                {"スプーン"},
                {"はさみ"},
                {"ドライバー"},
                {"スパナ"},
                {"ペンチ"},
                {"おかね"},
                {"プレゼント"},
                {"レポート"},
                {"かぞく"},
                {"おとうさん"},
                {"ちち"},
                {"おかあさん"},
                {"はは"},
                {"おにいさん"},
                {"あに"},
                {"おねえさん"},
                {"あね"},
                {"おとうとさん"},
                {"おとうと"},
                {"いもうとさん"},
                {"いもうと"},
                {"おくさん"},
                {"かない"},
                {"しゅじん"},
                {"ごしゅじん"},
                {"こども"},
                {"えいご"},
                {"～ご"},
                {"もう"},
                {"まだ"},
                {"これから"},

        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lesson7_vocab, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expListView7);
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