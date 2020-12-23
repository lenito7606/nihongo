package com.lennin.aniceto.nihongonaraimashou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class Lesson4_Vocab_Fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    public Lesson4_Vocab_Fragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[]{"to wake up", "to sleep", "to work", "to take a rest", "to study", "to take a break", "to finish", "now", "suffix for time", "suffix for minutes", "half past (30mins)", "what time", "how many minutes", "am", "pm", "morning", "noon", "night/evening", "the day before yesterday", "yesterday", "today", "tomorrow", "the day after tomorrow", "this morning", "tonight", "every morning", "every night", "every day", "english language", "study (noun)", "day off", "lecture", "visit for study", "from~", "up to~/until~", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "What day of the week"};

        children = new String[][]{
                {"okimasu おきます"},
                {"nemasu ねます"},
                {"hatarakimasu はたらきます"},
                {"yasumimasu やすみます"},
                {"benkyou shimasu べんきょうします"},
                {"kyuukei shimasu きゅうけいします"},
                {"owarimasu おわります"},
                {"ima いま"},
                {"-ji ーじ"},
                {"-fun/pun ーふん/ーぷん"},
                {"han はん"},
                {"nanji なんじ"},
                {"nanpun なんぷん"},
                {"gozen　ごぜん"},
                {"gogo ごご"},
                {"asa あさ"},
                {"hiru ひる"},
                {"ban/yoru ばん/よる"},
                {"ototoi おととい"},
                {"kinou きのう"},
                {"kyou きょう"},
                {"ashita あした"},
                {"asatte あさって"},
                {"kesa けさ"},
                {"konban こんばん"},
                {"maiasa まいあさ"},
                {"maiban まいばん"},
                {"mainichi まいにち"},
                {"eigo えいご"},
                {"benykou べんきょう"},
                {"yasumi やすみ"},
                {"kougi こうぎ"},
                {"kengaku けんがく"},
                {"kara から"},
                {"made まで"},
                {"nichiyoubi にちようび"},
                {"getsuyoubi げつようび"},
                {"kayoubi かようび"},
                {"suiyoubi すいようび"},
                {"mokuyoubi もくようび"},
                {"kinyoubi きんようび"},
                {"doyoubi どようび"},
                {"nanyoubi なんようび"},




        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lesson4_vocab, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expListView4);
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