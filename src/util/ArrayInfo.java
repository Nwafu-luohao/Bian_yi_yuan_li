package util;

import java.util.ArrayList;

//import parser.Parser;

/**
 * 内情向量表(数组信息表)
 */
public class ArrayInfo {
	// 维数列表
	private ArrayList<Integer> demenList = new ArrayList<Integer>();
	private int demenSize = 0; // 维数

	public String getDemenString(){
		String str = "";
		for(int i=0;i<demenSize;i++){
			str+="[]";
		}
		return str;
	}
	
	public void addDemenInfo(int newDemen) {	
		if (newDemen <= 0 || newDemen >32767) {
			System.out.println("数组维数定义异常");
			newDemen = 1;
		}
		this.demenList.add(new Integer(newDemen));
		setDemenSize();
	}

	public int getDemenSize() {
		return demenSize;
	}

	public void setDemenSize(int demenSize) {
		this.demenSize = demenSize;
	}

	public void setDemenSize() {
		this.demenSize = demenList.size();
	}


	public ArrayList<Integer> getDemenList(){
		return this.demenList;
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < demenList.size(); i++) {
			str += (demenList.get(i) + ",");
		}
		if (str.endsWith(","))
			str = str.substring(0, str.length() - 1);
		str = "[" + str + "]";
		return str;
	}

	public boolean checkArray(ArrayList<Integer> intList) {
		boolean flag = true;
		if (this.demenSize == intList.size()) {
			for (int i = 0; i < demenSize; i++) {
				if (intList.get(i)<0 || intList.get(i)>=this.demenList.get(i)) {
					flag = false;
					break;
				}
			}
		} else{
			flag = false;
		}
		return flag;
	}

}
