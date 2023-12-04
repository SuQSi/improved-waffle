package cugb.xg.javaee.jdbc.utils;

import java.util.ArrayList;
import java.util.List;

public class PageModel<T> {
	public PageModel(int pageSize,int pageNo,int totalrecords,ArrayList list){
		this.pageNO = pageNo;
		this.pageSize = pageSize;
		this.totalrecords = totalrecords;
		this.list = list;
	}
	//记录数目
	private int totalrecords;
	//每页记录数
	private int pageSize;
	//当前页号
	private int pageNO;
	//结果集
	private ArrayList<T> list;
	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPages(){
		return (totalrecords+pageSize-1)/pageSize;
	}
	
	/**
	 * 第一页
	 * @return
	 */
	public int getTop(){
		return 1;
	}
	
	/**
	 * 上一页
	 * @return
	 */
	public int getPrevPage(){
		if(pageNO <= 1){
			return 1;
		}
		return pageNO-1;
	}
	
	/**
	 * 下一页
	 * @return
	 */
	public int getNextPage(){
		if(pageNO >= getTotalPages()){
			return getTotalPages();
		}
		return pageNO+1;
	}
	
	/**
	 * 最后一页
	 * @return
	 */
	public int getBottom(){
		return getTotalPages();
	}
	
	public int getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNO() {
		return pageNO;
	}
	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(ArrayList<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageModel [totalrecords=" + totalrecords + ", pageSize=" + pageSize + ", pageNO=" + pageNO + ", list="
				+ list + "]";
	}

}
