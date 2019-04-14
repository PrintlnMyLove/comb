package com.comb.pojogroup;



import java.io.Serializable;
import java.util.List;

import com.comb.pojo.TbGoods;
import com.comb.pojo.TbGoodsDesc;
import com.comb.pojo.TbItem;

/**
 * 商品的组合实体类
 * @author WangQingBang
 *
 */
public class Goods implements Serializable{
	
	private TbGoods goods; // 商品基本信息SPU
	private TbGoodsDesc goodsDesc; // 商品SPU扩展信息
	private List<TbItem> itemList; // SKU的列表信息
	public TbGoods getGoods() {
		return goods;
	}
	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}
	public TbGoodsDesc getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(TbGoodsDesc goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public List<TbItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<TbItem> itemList) {
		this.itemList = itemList;
	}
	
}
