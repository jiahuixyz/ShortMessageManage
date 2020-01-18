package com.message.pojo;

import java.util.List;

public class Page {

	private int pageRow;//ÿҳ�ж��ټ�¼
	private int totalPage;//��ҳ��
	private int totalRow;//�ܼ�¼
	private int index;//��ǰҳ
	
	List<Message> listMessage;

	public Page(int pageRow, int totalPage, int totalRow, int index, List<Message> listMessage) {
		super();
		this.pageRow = pageRow;
		this.totalPage = totalPage;
		this.totalRow = totalRow;
		this.index = index;
		this.listMessage = listMessage;
	}

	public Page() {
		super();
	}

	public int getPageRow() {
		int temp=totalRow%pageRow;
		if(temp==0) {
			totalPage=totalRow/pageRow;
		}else {
			totalPage=totalRow/pageRow+1;
		}
		return totalPage;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<Message> getListMessage() {
		return listMessage;
	}

	public void setListMessage(List<Message> listMessage) {
		this.listMessage = listMessage;
	}
	
}
