package util;

import java.util.ArrayList;


public class StatementType {

	public VariableTable varTable = null; // 声明语句使用
	public Variable      var = null;			// 赋值语句使用
	
	// return  break 
	
	public void setVariableTable(VariableTable variableTable) {
		this.varTable = variableTable;
	}
	public void setVariable(Variable var) {
		this.var = var;
	}
	
}
