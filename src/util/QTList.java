package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class QTList {
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
		QTInfo.size = 0;
	}

	public void printQTTable(char[] buffer, FileWriter fos) {
		// System.out.println(toString());
		Iterator<QTInfo> itr = QTList.iterator();
		try {
			while (itr.hasNext()) {
				QTInfo tmp = (QTInfo) itr.next();
				String st = new String(tmp.toString());
				buffer = st.toCharArray();
				System.out.println(st.toCharArray());
				fos.write(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void printQTTable() {
//	Iterator<QTInfo> itr = QTList.iterator();
//	try {
//		while (itr.hasNext()) {
//			QTInfo tmp = (QTInfo) itr.next();
//			String st = new String(tmp.toString());
//			System.out.println(st.toCharArray());
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//}

}
