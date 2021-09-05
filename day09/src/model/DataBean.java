package model;

public class DataBean {
	private String[] dataList = { "apple", "banana", "kiwi", "home", "action" };

	private int data1 = 10;
	private int data2 = 20;

	public String[] getDataList() {
		return dataList;
	}

	public void setDataList(String[] dataList) {
		this.dataList = dataList;
	}

	public int getData1() {
		return data1;
	}

	public void setData1(int data1) {
		this.data1 = data1;
	}

	public int getData2() {
		return data2;
	}

	public void setData2(int data2) {
		this.data2 = data2;
	}
}
