package org.mars;

import java.util.List;

import javax.swing.JButton;
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
	private OrderUI ui;
	public OrderWorker(OrderUI ui,String start_date, String end_date, String user,
			char[] password, String folderPath) {
		this.ui = ui;
		this.start_date = start_date;
		this.end_date = end_date;
		this.user = user;
		this.password = new String(password);
		this.folderPath = folderPath;
	}

	/*public OrderWorker(OrderUI ui2, String sdate, String edate, String text,
			char[] password2, String text2) {
		this.ui = ui2;
		this.start_date = start_date;
		this.end_date = end_date;
		this.user = text;
		this.password = new String(password2);
		this.folderPath = folderPath;
	}*/

	protected Void doInBackground() throws Exception {
		System.out.println(" doInBackground !!! ");
		ZpPage page = new ZpPageImpl(this.user, this.password);
		if (!page.login()) {
			publish("login error...");
			System.err.println("login error!");
			return null;
		}
		publish("login success...");
		List<DeliverBean> list = page.getDataWithDatetime(this.start_date, this.end_date);
		publish("parse data success...");
		GenDeliveryList gdl = new GenDeliveryList(this.start_date, this.end_date);
		gdl.genExcel(this.folderPath, list);
		publish("gen excel success...");
		return null;
	}

	@Override
	protected void done() {
		super.done();
		this.ui.getBtn_gen().setEnabled(true);
	}

	@Override
	protected void process(List<String> chunks) {
		super.process(chunks);
		System.out.println(chunks.size());
		for(String str:chunks){
			System.out.println(str);
		}
		if(chunks.size()>0){
			this.ui.getProcess().setText(chunks.get(chunks.size()-1));
		}
	}
	
	

}
