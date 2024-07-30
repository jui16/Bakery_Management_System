import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class SalesReport extends JFrame {

	private JPanel contentPane;
	private JTable SaleTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesReport frame = new SalesReport();
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
	public SalesReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 715);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 112, 219));
		panel.setBounds(10, 10, 1054, 631);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("View Report");
		btnNewButton.setBackground(new Color(148, 0, 211));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					
		    		Class.forName("com.mysql.jdbc.Driver");  
		    	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery","root","16052001"); 
			        
		    	    String sql = "select * from Customers;";
		    	    PreparedStatement pst = con.prepareStatement(sql);
		    	    
		    	    ResultSet rs = pst.executeQuery();
		    	    
		    	    SaleTable.setModel(DbUtils.resultSetToTableModel(rs));
		    	    
		    	    
		    	    
			      }
				

				catch(Exception e2) {
					System.out.print(e2);
				}
			
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(646, 22, 161, 36);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 75, 1000, 532);
		panel.add(scrollPane);
		
		SaleTable = new JTable();
		scrollPane.setViewportView(SaleTable);
		SaleTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Customer Name", "Mobile", "Date", "Amount"
			}
		));
		
		JButton btnBack = new JButton("Back\r\n");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BakeryMain k2 = new BakeryMain();
				k2.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBack.setBackground(new Color(148, 0, 211));
		btnBack.setBounds(838, 22, 161, 36);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Sales Report");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
		lblNewLabel.setBounds(29, 10, 270, 45);
		panel.add(lblNewLabel);
		SaleTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		SaleTable.getColumnModel().getColumn(1).setPreferredWidth(95);
	}
}
