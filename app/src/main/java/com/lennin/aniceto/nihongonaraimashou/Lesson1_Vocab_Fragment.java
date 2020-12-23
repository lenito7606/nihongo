package com.lennin.aniceto.nihongonaraimashou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class Lesson1_Vocab_Fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    public Lesson1_Vocab_Fragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[]{"I", "We", "You", "That person", "Every body/ ladies and gentlemen", "Teacher/Instructor", "Trainee", "student", "university student", "company", "company employee", "bank", "bank employee", "Mr./Mrs./Miss", "Who", "Yes", "No", "Electricity/electric light", "Machinery", "Automobile/Car", "Speacialty/Specialization of study", "Years old(suffix)", "how old", "Japan", "India", "Indonesia", "Korea", "China", "Philippines", "Thailand", "Malaysia", "(suffix for nationality)", "where", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        children = new String[][]{
                {"watashi わたし"},
                {"watashi-tachi　わたしたち"},
                {"anata　あなた"},
                {"ano hito　あのひと"},
                {"minasan　みんなさん"},
                {"sensei　せんせい"},
                {"kenshuusei　けんしゅうせい"},
                {"gakusei がくせい"},
                {"daigakusei だいがくせい"},
                {"kaisha かいしゃ"},
                {"kaishain かいしゃいん"},
                {"ginkou ぎんこう"},
                {"ginkouin ぎんこういん"},
                {"san　さん"},
                {"dare　だれ(donata（どなた）polite of dare)"},
                {"hai　はい"},
                {"iie　いいえ"},
                {"denki　でんき"},
                {"kikai　きかい"},
                {"jidousha　じどうしゃ"},
                {"senmon　せんもん"},
                {"-saiさい e.g. nisai"},
                {"nansaiなんさい/oikutsuおいくつ polite of nansai"},
                {"nihon　にほん"},
                {"indo　インド"},
                {"indoneshia　インドネシア"},
                {"kankoku　かんこく"},
                {"chuugoku　ちゅうごく"},
                {"firipin　フィリピン"},
                {"tai　タイ"},
                {"mareshia　マレーシア"},
                {"-jinじん e.g. firipinjin"},
                {"doko　どこ"},
                {"ichi　いち"},
                {"ni　に"},
                {"san　さん"},
                {"yon/shi　よん/し"},
                {"go　ご"},
                {"roku　ろく"},
                {"nana/shichi　なな/しち"},
                {"hachi　はち"},
                {"kyuu/ku　きゅう/く"},
                {"juu　じゅう"},


        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lesson1_vocab, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expListView);
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