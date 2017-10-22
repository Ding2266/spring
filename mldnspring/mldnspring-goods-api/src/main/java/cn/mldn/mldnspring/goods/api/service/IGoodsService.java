package cn.mldn.mldnspring.goods.api.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.mldnspring.goods.api.vo.Goods;

public interface IGoodsService {
	/**
	 * 进行商品信息的删除处理，调用IGoodsDAO.doEditDflag()方法
	 * @param gids 要删除的商品编号
	 * @return 如果没有商品或商品删除失败返回false；
	 * @throws Exception
	 */
	public boolean remove(Set<Long> gids) throws Exception ;
	/**
	 * 实现商品数据的修改处理，商品必须有标记，该操作执行如下处理：
	 * 1、实现商品数据的修改，调用IGoodsDAO.doEdit()
	 * 2、如果要想追加商品标记与商品对应关系，那么应该先删除已有的标签信息之后再重新保存
	 * 3、获取ID成功后要保存商品与商品标记间的数据表信息
	 * @param vo 要追加的商品信息
	 * @param tids 表示商品的标记信息
	 * @return 
	 * @throws Exception
	 */
	public boolean edit(Goods vo,Set<Long> tids) throws Exception ;
	/**
	 * 进行商品修改前的数据查询操作，该操作要执行如下的数据层方法调用：
	 * 1、调用IItemDAO.findAll()查询所有的商品分类信息。
	 * 2、调用ITagDAO.findAll()查询所有的商品标记信息。 
	 * 3、调用IGoodsDAO.findById()查询一个商品的具体信息。
	 * 4、调用IGoodsDAO.findGoodsTag()方法，查询该商品的所有标签，为了回填表单,
	 * @return 返回数据包含如下内容<br>
	 * key = allItems、value = 所有的商品分类。
	 * key = allTags、value = 所有的商品标签。
	 * key = goods、value = 要修改的商品信息
	 * @throws Exception SQL
	 */
	public Map<String,Object> preEdit(long gid) throws Exception;
	/**
	 * 进行商品信息的分页数据查询，如果没有查询列或查询关键字则进行整体查询
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return 返回的内容包含如下信息<br>
	 * 1、key = allGoods、value = 全部商品信息
	 * 2、key = allRecorders、value = 统计结果.
	 * 3、key = allItems、value = 全部的分类信息（Map集合）
	 * @throws Exception
	 */
	public Map<String,Object> list(String column,String keyWord,long currentPage,int lineSize) throws Exception ;
	/**
	 * 实现商品数据的追加处理，商品必须有标记，该操作执行如下处理：
	 * 1、实现商品数据的添加，调用IGoodsDAO.doCreate()
	 * 2、如果要想追加商品标记与商品对应关系，应该获取当前增长后的ID内容。
	 * 3、获取ID成功后要保存商品与商品标记间的数据表信息
	 * @param vo 要追加的商品信息
	 * @param tids 表示商品的标记信息
	 * @return 
	 * @throws Exception
	 */
	public boolean add(Goods vo,Set<Long> tids) throws Exception ;
	/**
	 * 进行商品添加前的数据查询操作，该操作要执行如下的数据层方法调用：
	 * 1、调用IItemDAO.findAll()查询所有的商品分类信息。
	 * 2、调用ITagDAO.findAll()查询所有的商品标记信息。 
	 * @return 返回数据包含如下内容
	 * key = allItems、value = 所有的商品分类。
	 * key = allTags、value = 所有的商品标签。
	 * @throws Exception SQL
	 */
	public Map<String,Object> preAdd() throws Exception;
}
