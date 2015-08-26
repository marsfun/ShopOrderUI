package org.mars;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class OrderUI extends JFrame {

	private JPanel contentPane;
	private JPanel orderPane;
	private JPanel auditPane;
	
	private JLabel lbl_zpUser;
	private JLabel lbl_zpPasswd;
	private JTextField txt_zpUser;
	private JPasswordField txt_zpPasswd;
	
	//
	//
	//
	private String order_title="生成珍品订单功能";
	private String audit_title="Excel对账功能";
	

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		initUI(contentPane);
	}
	
	private void initUI(JComponent parent){
		orderPane = new JPanel();
		auditPane = new JPanel();
		orderPane.setLayout(null);
		orderPane.setBounds(41, 34, 313, 194);
		orderPane.setBorder(BorderFactory.createTitledBorder(order_title));
		
		lbl_zpUser = new JLabel("登录名");
		lbl_zpUser.setBounds(26, 61, 69, 15);
		
		lbl_zpPasswd = new JLabel("密码");
		lbl_zpPasswd.setBounds(26, 86, 69, 15);
		
		txt_zpUser = new JTextField("user");
		txt_zpUser.setBounds(75, 61, 69, 15);
		txt_zpPasswd = new JPasswordField();
		txt_zpPasswd.setBounds(75, 86, 69, 15);
		orderPane.add(lbl_zpUser);
		orderPane.add(lbl_zpPasswd);
		orderPane.add(txt_zpUser);
		orderPane.add(txt_zpPasswd);
		
		auditPane.setLayout(null);
		auditPane.setBounds(41, 34, 313, 194);
		auditPane.setBorder(BorderFactory.createTitledBorder(audit_title));
		
		parent.add(orderPane);
		parent.add(auditPane);
		
	}

}
