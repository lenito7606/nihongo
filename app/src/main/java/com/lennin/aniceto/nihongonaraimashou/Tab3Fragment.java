package com.lennin.aniceto.nihongonaraimashou;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lenni on 04/09/2017.
 */

public class Tab3Fragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab3Fragment";
    Button btn_a;
    Button btn_b;
    Button btn_c;
    Button btn_d;
    Button btn_e;
    Button btn_f;
    Button btn_g;
    Button btn_h;
    Button btn_i;
    Button btn_j;
    Button btn_k;
    Button btn_l;
    Button btn_m;
    Button btn_n;
    Button btn_o;
    Button btn_p;
    Button btn_q;
    Button btn_r;
    Button btn_s;
    Button btn_t;
    Button btn_u;
    Button btn_v;
    Button btn_w;
    Button btn_x;
    Button btn_y;
    Button btn_one;
    Button btn_two;
    Button btn_three;
    Button btn_four;
    Button btn_five;
    Button btn_six;
    Button btn_seven;
    Button btn_eight;
    Button btn_nine;
    Button btn_ten;
    Button btn_eleven;
    Button btn_twelve;
    Button btn_thirteen;
    Button btn_fourteen;
    Button btn_fifteen;
    Button btn_sixteen;
    Button btn_seventeen;
    Button btn_eighteen;
    Button btn_nineteen;
    Button btn_twenty;
    Button btn_twentyone;
    Button btn_twentytwo;
    Button btn_twentythree;
    Button btn_twentyfour;
    Button btn_twentyfive;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment,container,false);
        btn_a=view.findViewById(R.id.a);
        btn_b=view.findViewById(R.id.b);
        btn_c=view.findViewById(R.id.c);
        btn_d=view.findViewById(R.id.d);
        btn_e=view.findViewById(R.id.e);
        btn_f=view.findViewById(R.id.f);
        btn_g=view.findViewById(R.id.g);
        btn_h=view.findViewById(R.id.h);
        btn_i=view.findViewById(R.id.i);
        btn_j=view.findViewById(R.id.j);
        btn_k=view.findViewById(R.id.k);
        btn_l=view.findViewById(R.id.l);
        btn_m=view.findViewById(R.id.m);
        btn_n=view.findViewById(R.id.n);
        btn_o=view.findViewById(R.id.o);
        btn_p=view.findViewById(R.id.p);
        btn_q=view.findViewById(R.id.q);
        btn_r=view.findViewById(R.id.r);
        btn_s=view.findViewById(R.id.s);
        btn_t=view.findViewById(R.id.t);
        btn_u=view.findViewById(R.id.u);
        btn_v=view.findViewById(R.id.v);
        btn_w=view.findViewById(R.id.w);
        btn_x=view.findViewById(R.id.x);
        btn_y=view.findViewById(R.id.y);
        btn_one=view.findViewById(R.id.one);
        btn_two=view.findViewById(R.id.two);
        btn_three=view.findViewById(R.id.three);
        btn_four=view.findViewById(R.id.four);
        btn_five=view.findViewById(R.id.five);
        btn_six=view.findViewById(R.id.six);
        btn_seven=view.findViewById(R.id.seven);
        btn_eight=view.findViewById(R.id.eight);
        btn_nine=view.findViewById(R.id.nine);
        btn_ten=view.findViewById(R.id.ten);
        btn_eleven=view.findViewById(R.id.eleven);
        btn_twelve=view.findViewById(R.id.twelve);
        btn_thirteen=view.findViewById(R.id.thirteen);
        btn_fourteen=view.findViewById(R.id.fourteen);
        btn_fifteen=view.findViewById(R.id.fifteen);
        btn_sixteen=view.findViewById(R.id.sixteen);
        btn_seventeen=view.findViewById(R.id.seventeen);
        btn_eighteen=view.findViewById(R.id.eighteen);
        btn_nineteen=view.findViewById(R.id.nineteen);
        btn_twenty=view.findViewById(R.id.twenty);
        btn_twentyone=view.findViewById(R.id.twentyone);
        btn_twentytwo=view.findViewById(R.id.twentytwo);
        btn_twentythree=view.findViewById(R.id.twentythree);
        btn_twentyfour=view.findViewById(R.id.twentyfour);
        btn_twentyfive=view.findViewById(R.id.twentyfive);
        btn_a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiIchiActivity.class);
                startActivity(i);
            }
        });
        btn_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiNiActivity.class);
                startActivity(i);
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiSanActivity.class);
                startActivity(i);
            }
        });
        btn_d.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiYonActivity.class);
                startActivity(i);
            }
        });
        btn_e.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiGoActivity.class);
                startActivity(i);
            }
        });
        btn_f.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiRokuActivity.class);
                startActivity(i);
            }
        });
        btn_g.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiNanaActivity.class);
                startActivity(i);
            }
        });
        btn_h.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiHachiActivity.class);
                startActivity(i);
            }
        });
        btn_i.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiKyuuActivity.class);
                startActivity(i);
            }
        });
        btn_j.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiJuuActivity.class);
                startActivity(i);
            }
        });
        btn_k.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiHitoActivity.class);
                startActivity(i);
            }
        });
        btn_l.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiMeiActivity.class);
                startActivity(i);
            }
        });
        btn_m.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiHouActivity.class);
                startActivity(i);
            }
        });
        btn_n.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiHonActivity.class);
                startActivity(i);
            }
        });
        btn_o.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiNichiActivity.class);
                startActivity(i);
            }
        });
        btn_p.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiNanActivity.class);
                startActivity(i);
            }
        });
        btn_q.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiDaiActivity.class);
                startActivity(i);
            }
        });
        btn_r.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiGakuActivity.class);
                startActivity(i);
            }
        });
        btn_s.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiKaiActivity.class);
                startActivity(i);
            }
        });
        btn_t.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiShaActivity.class);
                startActivity(i);
            }
        });
        btn_u.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiKouActivity.class);
                startActivity(i);
            }
        });
        btn_v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiRaiActivity.class);
                startActivity(i);
            }
        });
        btn_w.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiJiActivity.class);
                startActivity(i);
            }
        });
        btn_x.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiKurumaActivity.class);
                startActivity(i);
            }
        });
        btn_y.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiHyakuActivity.class);
                startActivity(i);
            }
        });
        btn_one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiSenActivity.class);
                startActivity(i);
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiManActivity.class);
                startActivity(i);
            }
        });
        btn_three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiEnActivity.class);
                startActivity(i);
            }
        });
        btn_four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiTokiActivity.class);
                startActivity(i);
            }
        });
        btn_five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiBunActivity.class);
                startActivity(i);
            }
        });
        btn_six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiYouActivity.class);
                startActivity(i);
            }
        });
        btn_seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiTsukiActivity.class);
                startActivity(i);
            }
        });
        btn_eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiHiActivity.class);
                startActivity(i);
            }
        });
        btn_nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiMizuActivity.class);
                startActivity(i);
            }
        });
        btn_ten.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiMokuActivity.class);
                startActivity(i);
            }
        });
        btn_eleven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiKinActivity.class);
                startActivity(i);
            }
        });
        btn_twelve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiTsuchiActivity.class);
                startActivity(i);
            }
        });
        btn_thirteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiTomoActivity.class);
                startActivity(i);
            }
        });
        btn_fourteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiNenActivity.class);
                startActivity(i);
            }
        });
        btn_fifteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiImaActivity.class);
                startActivity(i);
            }
        });
        btn_sixteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiGogoActivity.class);
                startActivity(i);
            }
        });
        btn_seventeen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiKenActivity.class);
                startActivity(i);
            }
        });
        btn_eighteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiKuniActivity.class);
                startActivity(i);
            }
        });
        btn_nineteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiMaeActivity.class);
                startActivity(i);
            }
        });
        btn_twenty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiShuActivity.class);
                startActivity(i);
            }
        });
        btn_twentyone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiNakaActivity.class);
                startActivity(i);
            }
        });
        btn_twentytwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiUeActivity.class);
                startActivity(i);
            }
        });
        btn_twentythree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiShitaActivity.class);
                startActivity(i);
            }
        });
        btn_twentyfour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiHidariActivity.class);
                startActivity(i);
            }
        });
        btn_twentyfive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KanjiMigiActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}





