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
	//��¼��Ŀ
	private int totalrecords;
	//ÿҳ��¼��
	private int pageSize;
	//��ǰҳ��
	private int pageNO;
	//�����
	private ArrayList<T> list;
	/**
	 * ��ҳ��
	 * @return
	 */
	public int getTotalPages(){
		return (totalrecords+pageSize-1)/pageSize;
	}
	
	/**
	 * ��һҳ
	 * @return
	 */
	public int getTop(){
		return 1;
	}
	
	/**
	 * ��һҳ
	 * @return
	 */
	public int getPrevPage(){
		if(pageNO <= 1){
			return 1;
		}
		return pageNO-1;
	}
	
	/**
	 * ��һҳ
	 * @return
	 */
	public int getNextPage(){
		if(pageNO >= getTotalPages()){
			return getTotalPages();
		}
		return pageNO+1;
	}
	
	/**
	 * ���һҳ
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
