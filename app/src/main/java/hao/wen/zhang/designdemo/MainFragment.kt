package hao.wen.zhang.designdemo

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * 作者：ZWH
 * 创建日期： 2018/6/14 0014   下午 5:46
 * 描述说明：
 */
class MainFragment : Fragment() {
    var datas= arrayListOf<ItemBean>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setData()

        return View.inflate(activity,R.layout.fragment_main,null)
    }

    private fun setData() {
        datas.add(ItemBean("Abbaye de Belloc",R.mipmap.cheese_1))
        datas.add(ItemBean("Abertam",R.mipmap.cheese_2))
        datas.add(ItemBean("Afuega'l Pitu",R.mipmap.cheese_3))
        datas.add(ItemBean("American Cheese",R.mipmap.cheese_4))
        datas.add(ItemBean("Kikorangi",R.mipmap.cheese_5))
        datas.add(ItemBean("Allgauer Emmentaler",R.mipmap.cheese_4))
        datas.add(ItemBean("King Island Cape Wickham Brie",R.mipmap.cheese_3))
        datas.add(ItemBean("Kaseri",R.mipmap.cheese_3))
        datas.add(ItemBean("Kervella Affine",R.mipmap.cheese_3))
        datas.add(ItemBean("Kernhem",R.mipmap.cheese_2))
        datas.add(ItemBean("Kefalotyri",R.mipmap.cheese_1))
        datas.add(ItemBean("Kashta",R.mipmap.cheese_2))
        datas.add(ItemBean("Kenafa",R.mipmap.cheese_4))
        datas.add(ItemBean("Kadchgall",R.mipmap.cheese_3))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        mRecyclerView.layoutManager=LinearLayoutManager(activity)
        var adapter=MainFragAdapeter(R.layout.list_item,datas)
        mRecyclerView.adapter=adapter
        adapter.setOnItemClickListener{adapeter,view,position->

                val item =adapeter.data.get(position) as  ItemBean;
                val intent=Intent(activity,ItemDetailActivity::class.java)
                    intent.putExtra(ItemDetailActivity._DETAIL,item)
                startActivity(intent)



        }
    }

    class MainFragAdapeter(res:Int,datas:List<ItemBean>) : BaseQuickAdapter<ItemBean, BaseViewHolder>(res,datas) {
        override fun convert(helper: BaseViewHolder, item: ItemBean) {
            helper.setText(android.R.id.text1,item.name)
            Glide.with(helper.itemView.context)
                    .load(item.icon)
                    .into(helper.getView(R.id.avatar))
        }


    }
}