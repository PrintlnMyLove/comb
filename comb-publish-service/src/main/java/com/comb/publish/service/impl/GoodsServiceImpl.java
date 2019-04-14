package com.comb.publish.service.impl;



import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.comb.mapper.TbBrandMapper;
import com.comb.mapper.TbGoodsDescMapper;
import com.comb.mapper.TbGoodsMapper;
import com.comb.mapper.TbItemCatMapper;
import com.comb.mapper.TbItemMapper;
import com.comb.mapper.TbTeamUserMapper;
import com.comb.pojo.TbBrand;
import com.comb.pojo.TbGoods;
import com.comb.pojo.TbGoodsDesc;
import com.comb.pojo.TbGoodsExample;

import com.comb.pojo.TbItem;
import com.comb.pojo.TbItemCat;
import com.comb.pojo.TbItemExample;
import com.comb.pojo.TbItemExample.Criteria;
import com.comb.pojo.TbTeamUser;
import com.comb.pojogroup.Goods;
import com.comb.publish.service.GoodsService;
import com.comb.search.service.ItemSearchService;

import entity.PageResult;

/**
 * 服务实现层
 * @author WangQingBang
 *
 */
@Service(timeout=60000)
@Transactional	//事务注解
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private TbGoodsMapper goodsMapper;
	@Autowired
	private TbGoodsDescMapper goodsDescMapper;
	@Autowired
	private TbTeamUserMapper teamUserMapper;
	@Autowired
	private TbBrandMapper brandMapper;
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemCatMapper itemCatMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<TbGoods> findAll() {
		return goodsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
//	@Override
//	public PageResult findPage(int pageNum, int pageSize) {
//		PageHelper.startPage(pageNum, pageSize);		
//		Page<TbGoods> page=   (Page<TbGoods>) goodsMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
//	}

	/**
	 * 增加
	 */
	@Override
	public void add(Goods goods) {
		goods.getGoods().setAuditStatus("0"); //使其状态为未审核
		goods.getGoods().setIsMarketable("0");
		goodsMapper.insert(goods.getGoods());	//插入商品活动基本信息
		
		goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());//将商品基本表的id给扩展表
		goodsDescMapper.insert(goods.getGoodsDesc());	//插入
		setItemList(goods);
	}
	private void setItemList(Goods goods){
		if("1".equals(goods.getGoods().getIsEnableSpec())){
			
			System.out.println("开始保存item");
			// 启用规格
			// 保存SKU列表的信息:
			for(TbItem item:goods.getItemList()){
				// 设置SKU的数据：
				// item.setTitle(title);
				String title = goods.getGoods().getGoodsName();
				Map<String,String> map = JSON.parseObject(item.getSpec(), Map.class);
				//Map<String,String> map = item.getSpec();
				for (String key : map.keySet()) {
					title+= " "+map.get(key);
				}
				item.setTitle(title);
				
				setValue(goods,item);
				
				itemMapper.insert(item);
				System.out.println("插入成功"+item.getTitle());
			}
		}else{
			// 没有启用规格
			TbItem item = new TbItem();
			
			item.setTitle(goods.getGoods().getGoodsName());
			
			item.setPrice(goods.getGoods().getPrice());
			
			item.setNum(999);
			
			item.setStatus("0");
			
			item.setIsDefault("1");
			item.setSpec("{}");
			//item.setSpec(new HashMap());
			setValue(goods,item);
			itemMapper.insert(item);
		}
	}
	//修改
	private void setValue(Goods goods,TbItem item){
		//图片
		List<Map> imageList = JSON.parseArray(goods.getGoodsDesc().getItemImages(),Map.class);
		if(imageList.size()>0){
			item.setImage((String)imageList.get(0).get("url"));
		}
		
		// 保存三级分类的ID:
		item.setCategoryid(goods.getGoods().getCategory3Id());
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		// 设置商品ID
		item.setGoodsId(goods.getGoods().getId());
		item.setSellerId(goods.getGoods().getSellerId());
		//分类
		TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(goods.getGoods().getCategory3Id());
		item.setCategory(itemCat.getName());
		//品牌名称
		TbBrand brand = brandMapper.selectByPrimaryKey(goods.getGoods().getBrandId());
		item.setBrand(brand.getName());
		//商家名称
		TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(goods.getGoods().getSellerId());
		item.setLeader(teamUser.getNickName());
		
	}
	
	
	/**
	 * 修改
	 */
	@Override
	public void update(Goods goods){
		goods.getGoods().setAuditStatus("0"); //使其状态为未审核
		goods.getGoods().setIsMarketable("0");
		//更新基本表信息
		goodsMapper.updateByPrimaryKey(goods.getGoods());
		//更新扩展表数据
		goodsDescMapper.updateByPrimaryKey(goods.getGoodsDesc());
		//删除原有的SKU列表
		TbItemExample example1 = new TbItemExample();
		com.comb.pojo.TbItemExample.Criteria criteria1 = example1.createCriteria();
		criteria1.andGoodsIdEqualTo(goods.getGoods().getId());
		itemMapper.deleteByExample(example1);
		//
		setItemList(goods);
		
		TbItemExample example = new TbItemExample();
		com.comb.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(goods.getGoods().getId());
		List<TbItem> itemList = itemMapper.selectByExample(example);
		for(TbItem item : itemList) {
			item.setStatus("0");
			itemMapper.updateByPrimaryKey(item);
		}
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Goods findOne(Long id){
		Goods goods = new Goods();
		//商品基本表
		TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
		goods.setGoods(tbGoods);
		//商品的扩展表
		TbGoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(id);
		goods.setGoodsDesc(goodsDesc);
		
		//读取SKU列表
		
		TbItemExample example = new TbItemExample();
		com.comb.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(id);
		List<TbItem> itemList = itemMapper.selectByExample(example);
		goods.setItemList(itemList);
		return goods;
	}

	/**
	 * 批量删除,采用逻辑删除
	 */
	@Reference(timeout=100000)
	private ItemSearchService itemSearchService;
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			TbGoods goods = goodsMapper.selectByPrimaryKey(id);
			//表示逻辑删除
			goods.setIsDelete("1");
			itemSearchService.deleteByGoodsIds(Arrays.asList(ids));
			goodsMapper.updateByPrimaryKey(goods);
			
			TbItemExample example = new TbItemExample();
			com.comb.pojo.TbItemExample.Criteria criteria = example.createCriteria();
			criteria.andGoodsIdEqualTo(id);
			List<TbItem> itemList = itemMapper.selectByExample(example);
			for(TbItem item : itemList) {
				item.setStatus("0");
				itemMapper.updateByPrimaryKey(item);
			}
		}		
	}
	
	
		@Override
	public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbGoodsExample example=new TbGoodsExample();
		TbGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteIsNull();//指定条件为未删除
		
		if(goods!=null){			
						if(goods.getSellerId()!=null && goods.getSellerId().length()>0){
				criteria.andSellerIdEqualTo(goods.getSellerId());	//这里需要精确查询
			}
			if(goods.getGoodsName()!=null && goods.getGoodsName().length()>0){
				criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
			}
			if(goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0){
				criteria.andAuditStatusLike("%"+goods.getAuditStatus()+"%");
			}
			if(goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0){
				criteria.andIsMarketableLike("%"+goods.getIsMarketable()+"%");
			}
			if(goods.getCaption()!=null && goods.getCaption().length()>0){
				criteria.andCaptionLike("%"+goods.getCaption()+"%");
			}
			if(goods.getSmallPic()!=null && goods.getSmallPic().length()>0){
				criteria.andSmallPicLike("%"+goods.getSmallPic()+"%");
			}
			if(goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0){
				criteria.andIsEnableSpecLike("%"+goods.getIsEnableSpec()+"%");
			}
			if(goods.getIsDelete()!=null && goods.getIsDelete().length()>0){
				criteria.andIsDeleteLike("%"+goods.getIsDelete()+"%");
			}
	
		}
		
		Page<TbGoods> page= (Page<TbGoods>)goodsMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	@Override
	public void updateStatus(Long[] ids, String status) {
		for (Long id : ids) {
			TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
			
			tbGoods.setAuditStatus(status);
			goodsMapper.updateByPrimaryKey(tbGoods);
			
			
		}
	}

	@Override
	public void updateMarketable(Long[] ids, String status) throws Exception  {
		for(Long id : ids) {
			TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
			if(!"1".equals(tbGoods.getAuditStatus())) {
				throw new Exception();
			}
			tbGoods.setIsMarketable(status);
			goodsMapper.updateByPrimaryKey(tbGoods);
			
			TbItemExample example = new TbItemExample();
			com.comb.pojo.TbItemExample.Criteria criteria = example.createCriteria();
			criteria.andGoodsIdEqualTo(tbGoods.getId());
			List<TbItem> itemList = itemMapper.selectByExample(example);
			for(TbItem item : itemList) {
				item.setStatus(status);
				itemMapper.updateByPrimaryKey(item);
			}
			
		}
		
	}
	
	/**
	 * 根据SPU的ID集合查询SKU列表
	 * @param goodsIds
	 * @param status
	 * @return
	 */
	public List<TbItem>	findItemListByGoodsIdListAndStatus(Long []goodsIds,String status){
		
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status);//状态
		criteria.andGoodsIdIn( Arrays.asList(goodsIds));//指定条件：SPUID集合
		
		return itemMapper.selectByExample(example);
	}
}
