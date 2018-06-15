package hao.wen.zhang.designdemo

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.includ_main.*

class MainActivity : AppCompatActivity() {
    var adapter=MainAdapter(supportFragmentManager)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDrawer()
        setTitle()
        addData()
        setAdapter()
        addListen()

    }

    private fun setDrawer() {


    }

    private fun addListen() {
        mFloatingActionButton.setOnClickListener{
                v->
                Snackbar.make(v,"Fuck  Now",Snackbar.LENGTH_LONG).show()
        }
        mNavigaView.setNavigationItemSelectedListener (object: NavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.nav_home->showToast("Home")
                    R.id.nav_messages->showToast("Message")
                    R.id.nav_friends->showToast("Friends")
                    R.id.nav_discussion->showToast("Discussion")
                    R.id.sub1->showToast("Sub 1")
                    R.id.sub2->showToast("Sub 2")
                }
                return true
            }

        })

    }

    private fun setAdapter() {
        mViewPage.adapter=adapter
        mTabLayout.setupWithViewPager(mViewPage)
    }

    private fun addData() {
        adapter.addFragment(fragment = MainFragment(),titl = "Category 1")
        adapter.addFragment(fragment = MainFragment(),titl = "Category 2")
        adapter.addFragment(fragment = MainFragment(),titl = "Category 3")
    }

    private fun setTitle() {

        setSupportActionBar(mToolbar)
        val actionBar = supportActionBar
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class MainAdapter(fm :FragmentManager) :FragmentPagerAdapter(fm){
        var fragments=ArrayList<Fragment>()
        var titls=ArrayList<String>()
        override fun getItem(position: Int): Fragment =fragments.get(position)

        override fun getCount(): Int =fragments.size
        override fun getPageTitle(position: Int): CharSequence? {
            return titls.get(position)
        }
        fun addFragment(fragment:Fragment,titl:String){
            fragments.add(fragment)
            titls.add(titl)}
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.sample_actions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home->mDrawerLayout.openDrawer(Gravity.START)

        }
        return super.onOptionsItemSelected(item);
    }

    fun showToast(msg:String) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}
