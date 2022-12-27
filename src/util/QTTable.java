package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class QTTable {
	public ArrayList<QTInfo> QTList = new ArrayList<QTInfo>();
	public static boolean flag = true;
	
	public void addQTInfo(QTInfo info) {
		QTList.add(info);
	}

	public void addQTInfo(int index, QTInfo info) {
		QTList.add(index, info);
	}

	public QTInfo get(int index) {
		return (QTInfo) QTList.get(index);
	}

	public QTInfo remove(int index) {
		return QTList.remove(index - 1);
	}

	public void clear() {
		QTList.clear();
		QTInfo.innerIdSeqen = QTInfo.START;
	}

	public void printQTTable() {
		// System.out.println(toString());
		Iterator<QTInfo> itr = QTList.iterator();
		try {
			File f = new File("test/resultYuYi.txt");
			if (f.exists()) {
				// System.out.print("文件存在");
			} else {
				System.out.print("文件不存在");
				f.createNewFile();// 不存在则创建
			}
			BufferedWriter output;
			output = new BufferedWriter(new FileWriter(f));
			while (itr.hasNext()) {
				QTInfo tmp = (QTInfo) itr.next();
				output.write(tmp.toString());
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public ArrayList<QTInfo> getQTList() {
	// // TODO Auto-generated method stub
	// return QTList;
	// }

}
