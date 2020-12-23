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

public class Tab2Fragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab2Fragment";
    Button btn_a, btn_i, btn_e, btn_o, btn_u, btn_ka, btn_ke, btn_ki, btn_ko, btn_ku, btn_sa, btn_shi, btn_su, btn_se, btn_so, btn_ta, btn_chi, btn_tsu, btn_te, btn_to;
    Button btn_na, btn_ni, btn_nu, btn_ne, btn_no, btn_ha, btn_hi, btn_fu, btn_he, btn_ho, btn_ma, btn_mi, btn_mu, btn_me, btn_mo, btn_ya, btn_yu, btn_yo, btn_ra;
    Button btn_ri, btn_ru, btn_re, btn_ro, btn_wa, btn_wo, btn_n, btn_ga, btn_gi, btn_gu, btn_ge, btn_go, btn_za, btn_ji, btn_zu, btn_ze, btn_zo, btn_da, btn_ji2, btn_zu2, btn_de, btn_do;
    Button btn_ba, btn_bi, btn_bu, btn_be, btn_bo, btn_pa, btn_pi, btn_pu, btn_pe, btn_po, btn_kya, btn_kyu, btn_kyo, btn_sha, btn_shu, btn_sho, btn_cha, btn_chu, btn_cho;
    Button btn_nya, btn_nyu, btn_nyo, btn_hya, btn_hyu, btn_hyo, btn_mya, btn_myu, btn_myo, btn_rya, btn_ryu, btn_ryo, btn_gya, btn_gyu, btn_gyo;
    Button btn_ja, btn_ju, btn_jo, btn_bya, btn_byu, btn_byo, btn_pya, btn_pyu, btn_pyo;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);
        btn_a=view.findViewById(R.id.kata_a);
        btn_e=view.findViewById(R.id.kata_e);
        btn_i=view.findViewById(R.id.kata_i);
        btn_o=view.findViewById(R.id.kata_o);
        btn_u=view.findViewById(R.id.kata_u);
        btn_ka=view.findViewById(R.id.kata_ka);
        btn_ke=view.findViewById(R.id.kata_ke);
        btn_ki=view.findViewById(R.id.kata_ki);
        btn_ko=view.findViewById(R.id.kata_ko);
        btn_ku=view.findViewById(R.id.kata_ku);
        btn_sa=view.findViewById(R.id.kata_sa);
        btn_shi=view.findViewById(R.id.kata_shi);
        btn_su=view.findViewById(R.id.kata_su);
        btn_se=view.findViewById(R.id.kata_se);
        btn_so=view.findViewById(R.id.kata_so);
        btn_ta=view.findViewById(R.id.kata_ta);
        btn_chi=view.findViewById(R.id.kata_chi);
        btn_tsu=view.findViewById(R.id.kata_tsu);
        btn_te=view.findViewById(R.id.kata_te);
        btn_to=view.findViewById(R.id.kata_to);
        btn_na=view.findViewById(R.id.kata_na);
        btn_ni=view.findViewById(R.id.kata_ni);
        btn_nu=view.findViewById(R.id.kata_nu);
        btn_ne=view.findViewById(R.id.kata_ne);
        btn_no=view.findViewById(R.id.kata_no);
        btn_ha=view.findViewById(R.id.kata_ha);
        btn_hi=view.findViewById(R.id.kata_hi);
        btn_fu=view.findViewById(R.id.kata_fu);
        btn_he=view.findViewById(R.id.kata_he);
        btn_ho=view.findViewById(R.id.kata_ho);
        btn_ma=view.findViewById(R.id.kata_ma);
        btn_mi=view.findViewById(R.id.kata_mi);
        btn_mu=view.findViewById(R.id.kata_mu);
        btn_me=view.findViewById(R.id.kata_me);
        btn_mo=view.findViewById(R.id.kata_mo);
        btn_ya=view.findViewById(R.id.kata_ya);
        btn_yu=view.findViewById(R.id.kata_yu);
        btn_yo=view.findViewById(R.id.kata_yo);
        btn_ra=view.findViewById(R.id.kata_ra);
        btn_ri=view.findViewById(R.id.kata_ri);
        btn_ru=view.findViewById(R.id.kata_ru);
        btn_re=view.findViewById(R.id.kata_re);
        btn_ro=view.findViewById(R.id.kata_ro);
        btn_wa=view.findViewById(R.id.kata_wa);
        btn_wo=view.findViewById(R.id.kata_wo);
        btn_n=view.findViewById(R.id.kata_n);
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
                Intent i= new Intent(getActivity(), KataAActivity.class);
                startActivity(i);
            }
        });
        btn_i.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataIActivity.class);
                startActivity(i);
            }
        });
        btn_u.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataUActivity.class);
                startActivity(i);
            }
        });
        btn_e.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataEActivity.class);
                startActivity(i);
            }
        });
        btn_o.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataOActivity.class);
                startActivity(i);
            }
        });
        btn_ka.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataKAActivity.class);
                startActivity(i);
            }
        });
        btn_ki.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataKiActivity.class);
                startActivity(i);
            }
        });
        btn_ku.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataKuActivity.class);
                startActivity(i);
            }
        });
        btn_ke.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataKeActivity.class);
                startActivity(i);
            }
        });
        btn_ko.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataKoActivity.class);
                startActivity(i);
            }
        });
        btn_sa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataSaActivity.class);
                startActivity(i);
            }
        });
        btn_shi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataShiActivity.class);
                startActivity(i);
            }
        });
        btn_su.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataSuActivity.class);
                startActivity(i);
            }
        });
        btn_se.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataSeActivity.class);
                startActivity(i);
            }
        });
        btn_so.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataSoActivity.class);
                startActivity(i);
            }
        });
        btn_ta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataTaActivity.class);
                startActivity(i);
            }
        });
        btn_chi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataChiActivity.class);
                startActivity(i);
            }
        });
        btn_tsu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataTsuActivity.class);
                startActivity(i);
            }
        });
        btn_te.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataTeActivity.class);
                startActivity(i);
            }
        });
        btn_to.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataToActivity.class);
                startActivity(i);
            }
        });
        btn_na.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataNaActivity.class);
                startActivity(i);
            }
        });
        btn_ni.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataNiActivity.class);
                startActivity(i);
            }
        });
        btn_nu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataNuActivity.class);
                startActivity(i);
            }
        });
        btn_ne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataNeActivity.class);
                startActivity(i);
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataNoActivity.class);
                startActivity(i);
            }
        });
        btn_ha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataHaActivity.class);
                startActivity(i);
            }
        });
        btn_hi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataHiActivity.class);
                startActivity(i);
            }
        });
        btn_fu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataFuActivity.class);
                startActivity(i);
            }
        });
        btn_he.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataHeActivity.class);
                startActivity(i);
            }
        });
        btn_ho.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataHoActivity.class);
                startActivity(i);
            }
        });
        btn_ma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataMaActivity.class);
                startActivity(i);
            }
        });
        btn_mi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataMiActivity.class);
                startActivity(i);
            }
        });
        btn_mu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataMuActivity.class);
                startActivity(i);
            }
        });
        btn_me.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataMeActivity.class);
                startActivity(i);
            }
        });
        btn_mo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataMoActivity.class);
                startActivity(i);
            }
        });
        btn_ya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataYaActivity.class);
                startActivity(i);
            }
        });
        btn_yu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataYuActivity.class);
                startActivity(i);
            }
        });
        btn_yo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataYoActivity.class);
                startActivity(i);
            }
        });
        btn_ra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataRaActivity.class);
                startActivity(i);
            }
        });
        btn_ri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataRiActivity.class);
                startActivity(i);
            }
        });
        btn_ru.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataRuActivity.class);
                startActivity(i);
            }
        });
        btn_re.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataReActivity.class);
                startActivity(i);
            }
        });
        btn_ro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataRoActivity.class);
                startActivity(i);
            }
        });
        btn_wa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataWaActivity.class);
                startActivity(i);
            }
        });
        btn_wo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KataWoActivity.class);
                startActivity(i);
            }
        });
        btn_n.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(getActivity(), KatakanaNActivity.class);
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
