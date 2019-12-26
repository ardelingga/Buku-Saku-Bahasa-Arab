package ard.dev.ku2ba

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import ard.dev.ku2ba.Java.Test3Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener{

    lateinit var navigationView: NavigationView
    lateinit var fragment: Fragment
    lateinit var fragmentManager: FragmentManager
    lateinit var fragmentTransaction: FragmentTransaction
    lateinit var tv_title_bar:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_home)

        tv_title_bar = findViewById(R.id.tv_title_bar);

//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
//
//        val toggle = ActionBarDrawerToggle(
//            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
//        drawer.addDrawerListener(toggle)


//        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null){
            val nama = "Sinonim"
            fragment = Test3Fragment()
            callFragment(fragment, nama)
        }
        navigationView.menu.getItem(0).isChecked = true

    }

    @SuppressLint("WrongConstant")
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        val id = p0.itemId
        when(id){
            R.id.nav_sinonim ->{
                val nama = "Sinonim"
                fragment = SinonimFragment()
                callFragment(fragment, nama)
            }
            R.id.nav_antonim -> {
                val nama = "Antonim"
                fragment = AntonimFragment()
                callFragment(fragment, nama)
            }
            R.id.nav_polisemi -> {
                val nama = "Polisemi"
                fragment = PolisemiFragment()
                callFragment(fragment, nama)
            }
            R.id.nav_kata_pengantar -> {
                val nama = "Kata Pengantar"
                fragment = KataPengantarFragment()
                callFragment(fragment, nama)
            }
            R.id.nav_tentang -> {
                val nama = "About"
                fragment = AboutFragment()
                callFragment(fragment, nama)
            }

        }

        val drawer:DrawerLayout = findViewById(R.id.drawer_layout)
        drawer.closeDrawer(Gravity.START)
        return true
    }
    private fun callFragment(newFragment:Fragment, name_title_bar:String) {
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()

        val fragmentStack = fragmentManager.findFragmentByTag(newFragment.javaClass.name)

        if (fragmentStack == null){
            fragmentTransaction.replace(R.id.nav_host_fragment, newFragment, newFragment.javaClass.name)
        }else{
            fragmentTransaction.replace(R.id.nav_host_fragment, newFragment)
        }

        tv_title_bar.text = name_title_bar
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
