import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

public class ProductReport extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JButton btnNewButton;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JButton btnBack;
	private JLabel lblProductReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductReport frame = new ProductReport();
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
	public ProductReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 715);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(255,255,255));
		btnNewButton = new JButton("View Report");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 50, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			

				try {
					
		    		Class.forName("com.mysql.jdbc.Driver");  
		    	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery","root","16052001"); 
			        
		    	    String sql = "select * from Products;";
		    	    PreparedStatement pst = con.prepareStatement(sql);
		    	    
		    	    ResultSet rs = pst.executeQuery();
		    	    
		    	    table_1.setModel(DbUtils.resultSetToTableModel(rs));
		    	    
		    	    
		    	    
			      }
				

				catch(Exception e2) {
					System.out.print(e2);
				}
			
			}
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(649, 28, 197, 41);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 91, 1024, 487);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Product Name", "Cost", "Company"
			}
		));
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BakeryMain k1 = new BakeryMain();
				k1.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBackground(new Color(153, 50, 204));
		btnBack.setBounds(869, 28, 197, 41);
		contentPane.add(btnBack);
		
		lblProductReport = new JLabel("Product Report\r\n");
		lblProductReport.setForeground(Color.WHITE);
		lblProductReport.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
		lblProductReport.setBounds(47, 24, 270, 45);
		contentPane.add(lblProductReport);
	}

}
