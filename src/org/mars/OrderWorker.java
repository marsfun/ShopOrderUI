package org.mars;

import java.util.List;

import javax.swing.SwingWorker;

import org.mars.excel.GenDeliveryList;
import org.mars.page.DeliverBean;
import org.mars.page.ZpPage;
import org.mars.page.ZpPageImpl;

public class OrderWorker extends SwingWorker<Void, String> {

	private String start_date;
	private String end_date;
	private String user;
	private String password;
	private String folderPath;

	public OrderWorker(String start_date, String end_date, String user,
			char[] password, String folderPath) {
		this.start_date = start_date;
		this.end_date = end_date;
		this.user = user;
		this.password = new String(password);
		this.folderPath = folderPath;
	}

	protected Void doInBackground() throws Exception {
		System.out.println(" doInBackground !!! ");
		ZpPage page = new ZpPageImpl(this.user, this.password);
		if (!page.login()) {
			System.err.println("login error!");
			return null;
		}
		List<DeliverBean> list = page.getDataWithDatetime(this.start_date, this.end_date);
		GenDeliveryList gdl = new GenDeliveryList(this.start_date, this.end_date);
		gdl.genExcel(this.folderPath, list);
		return null;
	}

}
