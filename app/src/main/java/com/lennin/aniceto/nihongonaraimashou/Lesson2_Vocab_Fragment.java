package com.lennin.aniceto.nihongonaraimashou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class Lesson2_Vocab_Fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    public Lesson2_Vocab_Fragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[]{"this(thing here)", "that(thing near you)", "that(thing over there)", "this(here)", "that(near you)", "that(over there)", "book", "magazine", "dictionary", "notebook", "paper", "newspaper", "letter", "pencil", "ball pen", "mechanical pencil", "cigarette", "match", "lighter", "ashtray", "key", "watch/clock", "bag", "box", "tape recorder", "telephone", "chair", "desk", "window", "door", "radio", "television", "camera", "name", "work (noun)", "what"};

        children = new String[][]{
                {"kore これ"},
                {"sore それ"},
                {"are あれ"},
                {"kono この"},
                {"sono その"},
                {"ano あの"},
                {"hon ほん"},
                {"zasshi ざっし"},
                {"jisho じしょ"},
                {"no-to ノート"},
                {"kami かみ"},
                {"shinbun しんぶん"},
                {"tegami てがみ"},
                {"enpitsu えんぴつ"},
                {"bo-rupen ボールペン"},
                {"sha-pu penshiru シャープペンシル"},
                {"tabako たばこ"},
                {"matchi マッチ"},
                {"raita- ライター"},
                {"haizara はいざら"},
                {"kagi かぎ"},
                {"tokei とけい"},
                {"kaban かばん"},
                {"hako はこ"},
                {"te-pu reko-da- テープレコーダー"},
                {"denwa でんわ"},
                {"isu いす"},
                {"tsukue つくえ"},
                {"mado まど"},
                {"doa ドア"},
                {"rajio ラジオ"},
                {"terebi テレビ"},
                {"kamera カメラ"},
                {"namae なまえ"},
                {"shigoto しごと"},
                {"nan/nani なん／なに"},

        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lesson2_vocab, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expListView2);
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