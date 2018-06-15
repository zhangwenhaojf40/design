package hao.wen.zhang.designdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_item_detail.*

/**
 * 作者：ZWH
 * 创建日期： 2018/6/15 0015   下午 1:10
 * 描述说明：
 */
class ItemDetailActivity : AppCompatActivity() {
    companion object {

        val _DETAIL="_detail"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(mToolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val item= intent.getSerializableExtra(_DETAIL) as ItemBean
        collToolBar.title=item.name
        mIvTop.setImageResource(item.icon)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home->finish()
            R.id.action_settings->Toast.makeText(this,"Who are you ?",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

}