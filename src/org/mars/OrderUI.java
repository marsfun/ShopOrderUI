package org.mars;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.JDateComponentFactory;
import org.jdatepicker.JDatePicker;

public class OrderUI extends JFrame {

	private JPanel contentPane;
	private JPanel orderPane;
	private JPanel auditPane;

	private JLabel lbl_zpUser;
	private JLabel lbl_zpPasswd;
	private JTextField txt_zpUser;
	private JPasswordField txt_zpPasswd;

	// private JDatePanel jp;

	//
	//
	//
	private String order_title = "生成珍品订单功能";
	private String audit_title = "Excel对账功能";
	private JTextField txt_savePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUI frame = new OrderUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		initUI(contentPane);
	}

	private void initUI(JComponent parent) {
		orderPane = new JPanel();
		auditPane = new JPanel();
		orderPane.setLayout(null);
		orderPane.setBounds(41, 34, 313, 194);
		orderPane.setBorder(BorderFactory.createTitledBorder(order_title));

		/*
		 * jp = JDateComponentFactory.createJDatePanel(new UtilDateModel( new
		 * Date())); jp.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { try { jtextfield.setText(new
		 * SimpleDateFormat("yyyy-MM-dd") .format(jp.getModel().getValue())); //
		 * 如果选中日期后
		 * ，想消除JDialog，那么jp.addActionListener（new一个ActionListener的实现类，将this对象传递进去
		 * ）然后调用dispose()方法 } catch (Exception ex) { //
		 * 该日期控件点击Clear的时候会出异常，因为没有选中日期，如果要消除该异常，那么直接导入源代码，在源码里面改动。 //
		 * 这里直接简化操作，点击Clear出现异常，直接将jtextfield赋值为"" jtextfield.setText(""); } }
		 * }); orderPane.add((JPanel) jp);
		 */

		JPanel jPanel = new JPanel();
		final JDatePicker picker_begin = new JDateComponentFactory()
				.createJDatePicker();
		final JDatePicker picker_end = new JDateComponentFactory()
				.createJDatePicker();
		picker_begin.setTextEditable(true);
		picker_begin.setShowYearButtons(true);
		picker_end.setTextEditable(true);
		picker_end.setShowYearButtons(true);
		// picker.getModel().setSelected(true);
		jPanel.add((JComponent) picker_begin);
		jPanel.add((JComponent) picker_end);
		jPanel.setBounds(0, 0, 10, 10);
		JPanel DatePanel = new JPanel();
		DatePanel.setLayout(new BorderLayout());
		DatePanel.add(jPanel, BorderLayout.WEST);
		DatePanel.setBounds(5, 20, 480, 35);

		orderPane.add(DatePanel);

		lbl_zpUser = new JLabel("\u73CD\u54C1\u7528\u6237\u540D");
		lbl_zpUser.setBounds(10, 76, 69, 25);

		lbl_zpPasswd = new JLabel("\u73CD\u54C1\u5BC6\u7801");
		lbl_zpPasswd.setBounds(10, 111, 69, 25);

		txt_zpUser = new JTextField();
		txt_zpUser.setBounds(76, 76, 98, 25);
		txt_zpUser.setText("BJ05502");
		txt_zpPasswd = new JPasswordField();
		txt_zpPasswd.setBounds(76, 111, 98, 25);
		txt_zpPasswd.setText("bj66187131");
		orderPane.add(lbl_zpUser);
		orderPane.add(lbl_zpPasswd);
		orderPane.add(txt_zpUser);
		orderPane.add(txt_zpPasswd);

		auditPane.setLayout(null);
		auditPane.setBounds(41, 34, 313, 194);
		auditPane.setBorder(BorderFactory.createTitledBorder(audit_title));

		txt_savePath = new JTextField();
		txt_savePath.setBounds(76, 146, 316, 21);
		orderPane.add(txt_savePath);
		txt_savePath.setColumns(10);

		JLabel label = new JLabel("保存到");
		label.setBounds(10, 142, 69, 25);
		orderPane.add(label);

		JButton btn_select = new JButton();
		btn_select.setText("选择");
		btn_select.setBounds(402, 141, 62, 30);
		btn_select.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int ret = jfc.showSaveDialog(null);
				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = jfc.getSelectedFile();
					txt_savePath.setText(file.getPath());
				}

			}
		});
		orderPane.add(btn_select);

		/*
		 * JFileChooser jfc=new JFileChooser();
		 * jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		 * jfc.showDialog(new JLabel(), "select"); // File
		 * file=jfc.getSelectedFile(); jfc.setBounds(335, 111, 69, 25);
		 * orderPane.add(jfc);
		 */

		JButton btnNewButton = new JButton("\u751F\u6210\u8BA2\u5355");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("in "
						+ ((GregorianCalendar) picker_begin.getModel()
								.getValue()).getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String sdate = sdf.format(((GregorianCalendar) picker_begin
						.getModel().getValue()).getTime()) + " 00:00:00";
				String edate = sdf.format(((GregorianCalendar) picker_end
						.getModel().getValue()).getTime()) + " 23:59:59";
				System.out.println(sdate);
				System.out.println(edate);

				System.out.println(txt_savePath.getText());

				new OrderWorker(sdate, edate, txt_zpUser.getText(),
						txt_zpPasswd.getPassword(), txt_savePath.getText())
						.execute();
			}
		});
		btnNewButton.setBounds(233, 73, 131, 63);
		orderPane.add(btnNewButton);

		parent.add(orderPane);
		parent.add(auditPane);

	}
}
