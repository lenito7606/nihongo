package com.lennin.aniceto.nihongonaraimashou;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lenni on 04/09/2017.
 */

public class Tab1Fragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab1Fragment";
    Button btn_a, btn_i, btn_e, btn_o, btn_u, btn_ka, btn_ke, btn_ki, btn_ko, btn_ku, btn_sa, btn_shi, btn_su, btn_se, btn_so, btn_ta, btn_chi, btn_tsu, btn_te, btn_to;
    Button btn_na, btn_ni, btn_nu, btn_ne, btn_no, btn_ha, btn_hi, btn_fu, btn_he, btn_ho, btn_ma, btn_mi, btn_mu, btn_me, btn_mo, btn_ya, btn_yu, btn_yo, btn_ra;
    Button btn_ri, btn_ru, btn_re, btn_ro, btn_wa, btn_wo, btn_n, btn_ga, btn_gi, btn_gu, btn_ge, btn_go, btn_za, btn_ji, btn_zu, btn_ze, btn_zo, btn_da, btn_ji2, btn_zu2, btn_de, btn_do;
    Button btn_ba, btn_bi, btn_bu, btn_be, btn_bo, btn_pa, btn_pi, btn_pu, btn_pe, btn_po, btn_kya, btn_kyu, btn_kyo, btn_sha, btn_shu, btn_sho, btn_cha, btn_chu, btn_cho;
    Button btn_nya, btn_nyu, btn_nyo, btn_hya, btn_hyu, btn_hyo, btn_mya, btn_myu, btn_myo, btn_rya, btn_ryu, btn_ryo, btn_gya, btn_gyu, btn_gyo;
    Button btn_ja, btn_ju, btn_jo, btn_bya, btn_byu, btn_byo, btn_pya, btn_pyu, btn_pyo;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);
        btn_a=view.findViewById(R.id.a);
        btn_e=view.findViewById(R.id.e);
        btn_i=view.findViewById(R.id.i);
        btn_o=view.findViewById(R.id.o);
        btn_u=view.findViewById(R.id.u);
        btn_ka=view.findViewById(R.id.ka);
        btn_ke=view.findViewById(R.id.ke);
        btn_ki=view.findViewById(R.id.ki);
        btn_ko=view.findViewById(R.id.ko);
        btn_ku=view.findViewById(R.id.ku);
        btn_sa=view.findViewById(R.id.sa);
        btn_shi=view.findViewById(R.id.shi);
        btn_su=view.findViewById(R.id.su);
        btn_se=view.findViewById(R.id.se);
        btn_so=view.findViewById(R.id.so);
        btn_ta=view.findViewById(R.id.ta);
        btn_chi=view.findViewById(R.id.chi);
        btn_tsu=view.findViewById(R.id.tsu);
        btn_te=view.findViewById(R.id.te);
        btn_to=view.findViewById(R.id.to);
        btn_na=view.findViewById(R.id.na);
        btn_ni=view.findViewById(R.id.ni);
        btn_nu=view.findViewById(R.id.nu);
        btn_ne=view.findViewById(R.id.ne);
        btn_no=view.findViewById(R.id.no);
        btn_ha=view.findViewById(R.id.ha);
        btn_hi=view.findViewById(R.id.hi);
        btn_fu=view.findViewById(R.id.fu);
        btn_he=view.findViewById(R.id.he);
        btn_ho=view.findViewById(R.id.ho);
        btn_ma=view.findViewById(R.id.ma);
        btn_mi=view.findViewById(R.id.mi);
        btn_mu=view.findViewById(R.id.mu);
        btn_me=view.findViewById(R.id.me);
        btn_mo=view.findViewById(R.id.mo);
        btn_ya=view.findViewById(R.id.ya);
        btn_yu=view.findViewById(R.id.yu);
        btn_yo=view.findViewById(R.id.yo);
        btn_ra=view.findViewById(R.id.ra);
        btn_ri=view.findViewById(R.id.ri);
        btn_ru=view.findViewById(R.id.ru);
        btn_re=view.findViewById(R.id.re);
        btn_ro=view.findViewById(R.id.ro);
        btn_wa=view.findViewById(R.id.wa);
        btn_wo=view.findViewById(R.id.wo);
        btn_n=view.findViewById(R.id.n);
        btn_ga=view.findViewById(R.id.ga);
        btn_gi=view.findViewById(R.id.gi);
        btn_gu=view.findViewById(R.id.gu);
        btn_ge=view.findViewById(R.id.ge);
        btn_go=view.findViewById(R.id.go);
        btn_za=view.findViewById(R.id.za);
        btn_ji=view.findViewById(R.id.ji);
        btn_zu=view.findViewById(R.id.zu);
        btn_ze=view.findViewById(R.id.ze);
        btn_zo=view.findViewById(R.id.zo);
        btn_da=view.findViewById(R.id.da);
        btn_ji2=view.findViewById(R.id.ji2);
        btn_zu2=view.findViewById(R.id.zu2);
        btn_de=view.findViewById(R.id.de);
        btn_do=view.findViewById(R.id.do2);
        btn_ba=view.findViewById(R.id.ba);
        btn_bi=view.findViewById(R.id.bi);
        btn_bu=view.findViewById(R.id.bu);
        btn_be=view.findViewById(R.id.be);
        btn_bo=view.findViewById(R.id.bo);
        btn_pa=view.findViewById(R.id.pa);
        btn_pi=view.findViewById(R.id.pi);
        btn_pu=view.findViewById(R.id.pu);
        btn_pe=view.findViewById(R.id.pe);
        btn_po=view.findViewById(R.id.po);
        btn_kya=view.findViewById(R.id.kya);
        btn_kyu=view.findViewById(R.id.kyu);
        btn_kyo=view.findViewById(R.id.kyo);
        btn_sha=view.findViewById(R.id.sha);
        btn_shu=view.findViewById(R.id.shu);
        btn_sho=view.findViewById(R.id.sho);
        btn_cha=view.findViewById(R.id.cha);
        btn_chu=view.findViewById(R.id.chu);
        btn_cho=view.findViewById(R.id.cho);
        btn_nya=view.findViewById(R.id.nya);
        btn_nyu=view.findViewById(R.id.nyu);
        btn_nyo=view.findViewById(R.id.nyo);
        btn_hya=view.findViewById(R.id.hya);
        btn_hyu=view.findViewById(R.id.hyu);
        btn_hyo=view.findViewById(R.id.hyo);
        btn_mya=view.findViewById(R.id.mya);
        btn_myu=view.findViewById(R.id.myu);
        btn_myo=view.findViewById(R.id.myo);
        btn_rya=view.findViewById(R.id.rya);
        btn_ryu=view.findViewById(R.id.ryu);
        btn_ryo=view.findViewById(R.id.ryo);
        btn_gya=view.findViewById(R.id.gya);
        btn_gyu=view.findViewById(R.id.gyu);
        btn_gyo=view.findViewById(R.id.gyo);
        btn_ja=view.findViewById(R.id.ja);
        btn_ju=view.findViewById(R.id.ju);
        btn_jo=view.findViewById(R.id.jo);
        btn_bya=view.findViewById(R.id.bya);
        btn_byu=view.findViewById(R.id.byu);
        btn_byo=view.findViewById(R.id.byo);
        btn_pya=view.findViewById(R.id.pya);
        btn_pyu=view.findViewById(R.id.pyu);
        btn_pyo=view.findViewById(R.id.pyo);
        btn_a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraAActivity.class);
                startActivity(i);
            }
        });
        btn_e.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraEActivity.class);
                startActivity(i);
            }
        });
        btn_i.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraIActivity.class);
                startActivity(i);
            }
        });
        btn_o.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraOActivity.class);
                startActivity(i);
            }
        });
        btn_u.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraUActivity.class);
                startActivity(i);
            }
        });
        btn_ka.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraKaActivity.class);
                startActivity(i);
            }
        });
        btn_ke.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraKeActivity.class);
                startActivity(i);
            }
        });
        btn_ki.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraKiActivity.class);
                startActivity(i);
            }
        });
        btn_ko.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraKoActivity.class);
                startActivity(i);
            }
        });
        btn_ku.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraKuActivity.class);
                startActivity(i);
            }
        });
        btn_sa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraSaActivity.class);
                startActivity(i);
            }
        });
        btn_shi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraShiActivity.class);
                startActivity(i);
            }
        });
        btn_su.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraSuActivity.class);
                startActivity(i);
            }
        });
        btn_se.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraSeActivity.class);
                startActivity(i);
            }
        });
        btn_so.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraSoActivity.class);
                startActivity(i);
            }
        });
        btn_ta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraTaActivity.class);
                startActivity(i);
            }
        });
        btn_chi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraChiActivity.class);
                startActivity(i);
            }
        });
        btn_tsu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraTsuActivity.class);
                startActivity(i);
            }
        });
        btn_te.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraTeActivity.class);
                startActivity(i);
            }
        });
        btn_to.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraToActivity.class);
                startActivity(i);
            }
        });
        btn_na.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraNaActivity.class);
                startActivity(i);
            }
        });
        btn_ni.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraNiActivity.class);
                startActivity(i);
            }
        });
        btn_nu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraNuActivity.class);
                startActivity(i);
            }
        });
        btn_ne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraNeActivity.class);
                startActivity(i);
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraNoActivity.class);
                startActivity(i);
            }
        });
        btn_ha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraHaActivity.class);
                startActivity(i);
            }
        });
        btn_hi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraHiActivity.class);
                startActivity(i);
            }
        });
        btn_fu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraFuActivity.class);
                startActivity(i);
            }
        });
        btn_he.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraHeActivity.class);
                startActivity(i);
            }
        });
        btn_ho.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraHoActivity.class);
                startActivity(i);
            }
        });
        btn_ma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraMaActivity.class);
                startActivity(i);
            }
        });
        btn_mi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraMiActivity.class);
                startActivity(i);
            }
        });
        btn_mu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraMuActivity.class);
                startActivity(i);
            }
        });
        btn_me.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraMeActivity.class);
                startActivity(i);
            }
        });
        btn_mo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraMoActivity.class);
                startActivity(i);
            }
        });
        btn_ya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraYaActivity.class);
                startActivity(i);
            }
        });
        btn_yu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraYuActivity.class);
                startActivity(i);
            }
        });
        btn_yo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraYoActivity.class);
                startActivity(i);
            }
        });
        btn_ra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraRaActivity.class);
                startActivity(i);
            }
        });
        btn_ri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraRiActivity.class);
                startActivity(i);
            }
        });
        btn_ru.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraRuActivity.class);
                startActivity(i);
            }
        });
        btn_re.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraReActivity.class);
                startActivity(i);
            }
        });
        btn_ro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraRoActivity.class);
                startActivity(i);
            }
        });
        btn_wa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraWaActivity.class);
                startActivity(i);
            }
        });
        btn_wo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraWoActivity.class);
                startActivity(i);
            }
        });
        btn_n.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), HiraganaNActivity.class);
                startActivity(i);
            }
        });
        btn_ga.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ga);
                btn_ga.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_gi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.gi);
                btn_gi.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_gu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.gu);
                btn_gu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_ge.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ge);
                btn_ge.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.go);
                btn_go.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_za.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.za);
                btn_za.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_ji.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ji);
                btn_ji.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_zu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.zu);
                btn_zu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_ze.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ze);
                btn_ze.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_zo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.zo);
                btn_zo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_da.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.da);
                btn_da.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_ji2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ji);
                btn_ji2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_zu2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.zu);
                btn_zu2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_de.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.de);
                btn_de.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_do.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.do2);
                btn_do.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_ba.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ba);
                btn_ba.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_bi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.bi);
                btn_bi.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_bu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.bu);
                btn_bu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_be.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.be);
                btn_be.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_bo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.bo);
                btn_bo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_pa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.pa);
                btn_pa.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_pi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.pi);
                btn_pi.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_pu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.pu);
                btn_pu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_pe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.pe);
                btn_pe.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_po.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.po);
                btn_po.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_kya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.kya);
                btn_kya.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_kyu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.kyu);
                btn_kyu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_kyo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.kyo);
                btn_kyo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_sha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.sha);
                btn_sha.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_shu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.shu);
                btn_shu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_sho.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.sho);
                btn_sho.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_cha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.cha);
                btn_cha.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_chu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.chu);
                btn_chu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_cho.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.cho);
                btn_cho.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_nya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.nya);
                btn_nya.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_nyu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.nyu);
                btn_nyu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_nyo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.nyo);
                btn_nyo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_hya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.hya);
                btn_hya.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_hyu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.hyu);
                btn_hyu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_hyo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.hyo);
                btn_hyo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_mya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.mya);
                btn_mya.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_myu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.myu);
                btn_myu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_myo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.myo);
                btn_myo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_rya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.rya);
                btn_rya.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_ryu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ryu);
                btn_ryu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_ryo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ryo);
                btn_ryo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_gya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.gya);
                btn_gya.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_gyu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.gyu);
                btn_gyu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_gyo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.gyo);
                btn_gyo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_ja.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ja);
                btn_ja.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_ju.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.ju);
                btn_ju.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_jo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.jo);
                btn_jo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_bya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.bya);
                btn_bya.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_byu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.byu);
                btn_byu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_byo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.byo);
                btn_byo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_pya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.pya);
                btn_pya.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_pyu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.pyu);
                btn_pyu.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        btn_pyo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.pyo);
                btn_pyo.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mp.start();
                    }
                });
            }
        });
        return view;

    }

}
