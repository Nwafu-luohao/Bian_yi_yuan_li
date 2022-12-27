package util;

import java.util.ArrayList;

import test.Token;

public class Variable {

	private String type; // 参数类型
	private String name; // 参数名
	private int line;
	private int column;
	private int elementSize;// 元素占字节的个数，在声明语句结束时赋值
	private ArrayInfo arrayInfo = null; // 内情向量表，只有数组变量才有这个引用
	private ArrayList<Integer> arrayInfoVar = null; // 数组变量使用时的下标
//	private String address = null;

	public Variable() {

	}

	public Variable(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public Variable(String type, Token token) {
		this.type = type;
		this.name = token.image;
		this.line = token.endLine;
		this.column = token.endColumn;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getLine() {
		return this.line;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getColumn() {
		return this.column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setArrayInfo(ArrayInfo arrayInfo) {
		this.arrayInfo = arrayInfo;
	}

	public void setArrayInfoVar(ArrayList<Integer> intList) {
		this.arrayInfoVar = intList;
	}

	public ArrayList<Integer> getArrayInfoVar() {
		return this.arrayInfoVar;
	}
//
//	public void setElementSize(String type) {
//		this.elementSize = FundamentalTypeInfo.sizeof(type);
//	}

	public void setElementSize(int size) {
		this.elementSize = size;
	}

	public int getElementSize() {
		return elementSize;
	}

	public boolean checkArray(Variable info, ArrayList<Integer> intList) {
		boolean flag = true;
		if (this.name.equals(info.getName()))
			if (checkDemen(intList)) {
				flag = true;
			}
		return flag;
	}

	public String toString() {
		String str = null;
		if (this.arrayInfo == null) {
			str = this.type + " " + this.name;
		} else {
			str = this.type + " " + this.name + this.arrayInfo;
		}
		return str;
	}

	public void printInfo() {
		System.out.println("new Variable:" + toString());
	}

	public boolean checkDemen(ArrayList<Integer> intList) {
		boolean flag = false;
		if (this.arrayInfo.checkArray(intList))
			flag = true;
		else
			System.out.println("数组" + this.name + "下标异常");
		return flag;
	}

//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getAddress() {
//		return this.address;
//	}

	public ArrayInfo getArrayInfo() {
		return this.arrayInfo;
	}

}
