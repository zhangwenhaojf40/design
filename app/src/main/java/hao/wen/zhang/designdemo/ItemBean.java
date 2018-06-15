package hao.wen.zhang.designdemo;

import java.io.Serializable;

/**
 * 作者：ZWH
 * 创建日期： 2018/6/15 0015   上午 10:18
 * 描述说明：
 */

public class ItemBean implements Serializable{
    public String name;
    public int icon;

    public ItemBean(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }
}
