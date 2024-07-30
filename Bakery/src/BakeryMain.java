import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BakeryMain extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BakeryMain frame1 = new BakeryMain();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BakeryMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1147, 719);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Admin Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(23, 33, 437, 626);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AddProduct add_pro = new AddProduct();
				add_pro.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(87, 82, 231, 39);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton.setBackground(new Color(153, 50, 204));
		panel.add(btnNewButton);
		
		JButton btnProductReport = new JButton("Product Report");
		btnProductReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductReport preport = new ProductReport();
				preport.setVisible(true);
				dispose();
			}
		});
		btnProductReport.setForeground(new Color(255, 255, 255));
		btnProductReport.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnProductReport.setBackground(new Color(153, 50, 204));
		btnProductReport.setBounds(87, 163, 231, 39);
		panel.add(btnProductReport);
		
		JButton btnAddSales = new JButton("Add Sales");
		btnAddSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				SalesDashboard sales = new SalesDashboard();
				sales.setVisible(true);
				dispose();
			}
		});
		btnAddSales.setForeground(new Color(255, 255, 255));
		btnAddSales.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnAddSales.setBackground(new Color(153, 50, 204));
		btnAddSales.setBounds(87, 238, 231, 39);
		panel.add(btnAddSales);
		
		JButton btnSalesReport = new JButton("Sales Report\r\n");
		btnSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SalesReport Sale1 = new SalesReport();
				Sale1.setVisible(true);
				dispose();
			}
		});
		btnSalesReport.setForeground(new Color(255, 255, 255));
		btnSalesReport.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnSalesReport.setBackground(new Color(153, 50, 204));
		btnSalesReport.setBounds(87, 311, 231, 39);
		panel.add(btnSalesReport);
		
		JButton btnAbout = new JButton("Exit");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAbout.setForeground(new Color(255, 255, 255));
		btnAbout.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnAbout.setBackground(new Color(153, 50, 204));
		btnAbout.setBounds(87, 388, 231, 39);
		panel.add(btnAbout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(490, 115, 619, 544);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\TE\\Java\\eclipse-workspace\\Bakery_Management_System\\Bakery\\src\\image.jpg"));
		lblNewLabel_1.setBounds(0, -17, 622, 561);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Bakery Management System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 52));
		lblNewLabel.setBounds(490, 37, 660, 55);
		contentPane.add(lblNewLabel);
	}
}
