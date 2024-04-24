package com.example.mascotas

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
//import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
//import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private var currentTitle: CharSequence? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            //R.id.nav_item_one -> Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show()
            R.id.nav_item_one -> {
                replaceFragmen(PerfilesFragment())
                updateToolbarTitle(getString(R.string.nav_item_one_title))
            }
            //R.id.nav_item_two -> Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show()
            R.id.nav_item_two -> {
                replaceFragmen(MascotasFragment())
                updateToolbarTitle(getString(R.string.nav_item_two_title))
            }
            R.id.nav_item_three -> {
                //Toast.makeText(this, "item 3", Toast.LENGTH_SHORT).show()
                replaceFragmen(TipsFragment())
                updateToolbarTitle(getString(R.string.nav_item_three_title))
            }
            R.id.nav_item_four -> {
                replaceFragmen(NavegadorFragment())
                updateToolbarTitle(getString(R.string.nav_item_four_title))
            }
            R.id.nav_item_five -> {
                replaceFragmen(FormularioFragment())
                updateToolbarTitle(getString(R.string.nav_item_five_title))
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    private fun replaceFragmen(fragment: Fragment){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
    private fun updateToolbarTitle(title: String) {
        currentTitle = title
        supportActionBar?.title = currentTitle
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}