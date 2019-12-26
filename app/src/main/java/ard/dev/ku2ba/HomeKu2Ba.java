package ard.dev.ku2ba;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;
import ard.dev.ku2ba.Java.Test3Fragment;

public class HomeKu2Ba extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    ProgressBar loadingProgresBar;

    Fragment newFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    TextView tv_title_bar;

    ImageView btn_search, btn_close_searh;

    int startingPosition = 1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tv_title_bar = findViewById(R.id.tv_title_bar);
        btn_search = findViewById(R.id.iv_search);
        btn_close_searh = findViewById(R.id.iv_close_search);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            String name_action_bar = "Sinonim";
            int id_menu_pertama = 1;
            newFragment = new SinonimFragment();
            callFragment(newFragment, id_menu_pertama, name_action_bar);
        }
        navigationView.getMenu().getItem(0).setChecked(true);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newFragment instanceof SinonimFragment) {
                    SinonimFragment.ly_search.setVisibility(View.VISIBLE);
                    btn_search.setVisibility(View.GONE);
                    btn_close_searh.setVisibility(View.VISIBLE);
                }else if (newFragment instanceof AntonimFragment) {
                    AntonimFragment.ly_search.setVisibility(View.VISIBLE);
                    btn_search.setVisibility(View.GONE);
                    btn_close_searh.setVisibility(View.VISIBLE);
                }else if (newFragment instanceof PolisemiFragment) {
                    PolisemiFragment.ly_search.setVisibility(View.VISIBLE);
                    btn_search.setVisibility(View.GONE);
                    btn_close_searh.setVisibility(View.VISIBLE);
                }
            }
        });

        btn_close_searh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newFragment instanceof SinonimFragment) {
                    SinonimFragment.et_search.setText("");
                    SinonimFragment.ly_search.setVisibility(View.GONE);
                    btn_search.setVisibility(View.VISIBLE);
                    btn_close_searh.setVisibility(View.GONE);
                }else if (newFragment instanceof AntonimFragment) {
                    AntonimFragment.et_search.setText("");
                    AntonimFragment.ly_search.setVisibility(View.GONE);
                    btn_search.setVisibility(View.VISIBLE);
                    btn_close_searh.setVisibility(View.GONE);
                }else if (newFragment instanceof PolisemiFragment) {
                    PolisemiFragment.et_search.setText("");
                    PolisemiFragment.ly_search.setVisibility(View.GONE);
                    btn_search.setVisibility(View.VISIBLE);
                    btn_close_searh.setVisibility(View.GONE);
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        newFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if (newFragment instanceof AboutFragment) {
            panggilFragmentPesanan();
        }else if (newFragment instanceof KataPengantarFragment) {
            panggilFragmentPesanan();
        }else if (newFragment instanceof PolisemiFragment) {
            panggilFragmentPesanan();
        }else if (newFragment instanceof AntonimFragment) {
            panggilFragmentPesanan();
        }
        else if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else{
            finish();
            this.overridePendingTransition(R.anim.no_animation, R.anim.slide_down);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        String name_action_bar;

        if (id == R.id.nav_sinonim) {
            name_action_bar = "Sinonim";
            newFragment = new SinonimFragment();

            callFragment(newFragment, 1, name_action_bar);

            btn_search.setVisibility(View.VISIBLE);
            btn_close_searh.setVisibility(View.GONE);
        } else if (id == R.id.nav_antonim) {
            name_action_bar = "Antonim";
            newFragment = new AntonimFragment();
            callFragment(newFragment, 2, name_action_bar);

            btn_search.setVisibility(View.VISIBLE);
            btn_close_searh.setVisibility(View.GONE);
            SinonimFragment.ly_search.setVisibility(View.GONE);
        } else if (id == R.id.nav_polisemi) {
            name_action_bar = "Polisemi";
            newFragment = new PolisemiFragment();
            callFragment(newFragment, 3, name_action_bar);

            btn_search.setVisibility(View.VISIBLE);
            btn_close_searh.setVisibility(View.GONE);
//            AntonimFragment.ly_search.setVisibility(View.GONE);
        }else if (id == R.id.nav_kata_pengantar) {
            name_action_bar = "Kata Pengantar";
            newFragment = new KataPengantarFragment();
            callFragment(newFragment, 4, name_action_bar);

            btn_search.setVisibility(View.GONE);
            btn_close_searh.setVisibility(View.GONE);
        } else if (id == R.id.nav_tentang) {
            name_action_bar = "Tentang Aplikasi";
            newFragment = new AboutFragment();
            callFragment(newFragment, 4, name_action_bar);

            btn_search.setVisibility(View.GONE);
            btn_close_searh.setVisibility(View.GONE);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showDialog() {
        loadingProgresBar.setVisibility(View.VISIBLE);
    }

    private void hideDialog() {
        loadingProgresBar.setVisibility(View.GONE);
    }

    private void callFragment(Fragment newFragment, int id_menu, String name_action_bar) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragmentStack = fragmentManager.findFragmentByTag(newFragment.getClass().getName());

//        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);

//        if (id_menu > startingPosition){
//            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
////            System.out.println("Lebih besar");
//            startingPosition = id_menu;
//        }else if (id_menu < startingPosition){
//            fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
////            System.out.println("Lebih kecil");
//            startingPosition = id_menu;
//        }

        if (fragmentStack == null){
            fragmentTransaction.replace(R.id.nav_host_fragment, newFragment, newFragment.getClass().getName());
        }else {
            fragmentTransaction.replace(R.id.nav_host_fragment, fragmentStack);
        }

        tv_title_bar.setText(name_action_bar);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    private void panggilFragmentPesanan(){
        String name_action_bar = "Sinonim";

        newFragment = new SinonimFragment();
        callFragment(newFragment, 1, name_action_bar);
        MenuItem menuItem = navigationView.getMenu().getItem(0);
        menuItem.setChecked(true);
    }

    private void panggilFragment(Fragment newFragment, String name_toolbar){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newFragment);
        fragmentTransaction.commit();
    }

}
