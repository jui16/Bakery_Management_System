import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesDashboard extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtcustname;
	private JTextField txtcustmob;
	private JComboBox comboBoxName;
	private JTable billtable;
	private JTextField txtcustid;
	private JLabel total;
	private JTextField total_cost;
	private JComboBox txtqty;
	private JTextField Finalamt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesDashboard frame = new SalesDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fillComboBox() {
		
		try {
			
    		Class.forName("com.mysql.jdbc.Driver");  
    	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery","root","16052001"); 
	        
    	    String sql = "select * from Products;";
    	    PreparedStatement pst = con.prepareStatement(sql);
    	    
    	    ResultSet rs = pst.executeQuery();
    	    
    	    
    	    while(rs.next()) {
    	    	
    	    	comboBoxName.addItem(rs.getString("ProductName"));
    	    	
    	    }
    	    
    	    
    	    
		}
		
		catch (Exception e3) {
			System.out.print(e3);
		}
	}
	

	/**
	 * Create the frame.
	 */
	public SalesDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1232, 677);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBorder(new TitledBorder(null, "Customer Details ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 64, 1161, 157);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCustomerName.setBounds(35, 101, 165, 24);
		panel.add(lblCustomerName);
		
		JLabel lblMobile = new JLabel("Mobile No");
		lblMobile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMobile.setBounds(607, 53, 165, 24);
		panel.add(lblMobile);
		
		txtcustname = new JTextField();
		txtcustname.setColumns(10);
		txtcustname.setBounds(197, 102, 352, 27);
		panel.add(txtcustname);
		
		txtcustmob = new JTextField();
		txtcustmob.setColumns(10);
		txtcustmob.setBounds(724, 53, 352, 27);
		panel.add(txtcustmob);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCustomerId.setBounds(35, 53, 165, 24);
		panel.add(lblCustomerId);
		
		txtcustid = new JTextField();
		txtcustid.setColumns(10);
		txtcustid.setBounds(197, 50, 352, 27);
		panel.add(txtcustid);
		
		JLabel lblNewLabel = new JLabel("Sales Dashboard");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 27));
		lblNewLabel.setBounds(511, 15, 329, 39);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBorder(new TitledBorder(null, "Sales Dashboard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(30, 241, 1161, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSelectProduct = new JLabel("Select Product");
		lblSelectProduct.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSelectProduct.setBounds(47, 36, 165, 24);
		panel_1.add(lblSelectProduct);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuantity.setBounds(507, 36, 165, 24);
		panel_1.add(lblQuantity);
		
		
		

		JButton btnNewButton = new JButton("Add item");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 50, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
				String custid = txtcustid.getText();
				String custname = txtcustname.getText();
				String custmob = txtcustmob.getText();
				String proname = comboBoxName.getSelectedItem().toString();
				String quantity = txtqty.getSelectedItem().toString();
			    String final_cost = total_cost.getText();
			    
			    if ( custid.length()<=0 || custname.length()<=0 || custmob.length()<=0 )
			    {
			    	JOptionPane.showMessageDialog(null, "Please enter all details for customer");
			    }
			    else {
			    
				DefaultTableModel model = new DefaultTableModel();
				model = (DefaultTableModel)billtable.getModel();
				model.addRow(new Object[] {
					
						custid,
						custname,
						custmob,
						proname,
						quantity,
						final_cost
					    
						
				});
				
					int sum = 0;
					for (int i = 0; i< billtable.getRowCount();i++) {
						
						sum = sum + Integer.parseInt(billtable.getValueAt(i,5).toString());
						
					}
					
					Finalamt.setText(Integer.toString(sum));
						
				}
			}
								
						
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(994, 29, 123, 38);
		panel_1.add(btnNewButton);
		
		comboBoxName = new JComboBox();
		comboBoxName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBoxName.setForeground(Color.BLACK);
		comboBoxName.setBounds(184, 37, 263, 25);
		panel_1.add(comboBoxName);
		
		txtqty = new JComboBox();
		txtqty.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String p_name = comboBoxName.getSelectedItem().toString();
				
				try {
					
		    		Class.forName("com.mysql.jdbc.Driver");  
		    	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery","root","16052001"); 
			        
		    	    String sql = "select Cost from Products where ProductName=?";
		    	    PreparedStatement pst = con.prepareStatement(sql);
		    	    pst.setString(1, p_name);
		    	    ResultSet rs = pst.executeQuery();
		    	    
		    	    
		    	    while(rs.next()) {
		    	    	
		    	    	int qty = Integer.parseInt(txtqty.getSelectedItem().toString());
		    	    	int price = Integer.parseInt(rs.getString("Cost"));   
		    	    	total_cost.setText(String.valueOf(qty*price));
		    	    	
		    	    	
		    	    }
		    	    
		    	    
		    	    
				}
				
				catch (Exception e3) {
					System.out.print(e3);
				}
				
				
				
				
			}
		});
		txtqty.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtqty.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		txtqty.setBounds(589, 37, 129, 25);
		panel_1.add(txtqty);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 89, 1070, 170);
		panel_1.add(scrollPane);
		
		billtable = new JTable();
		scrollPane.setViewportView(billtable);
		billtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CustomerId", "CustomerName", "Mobile", "Product", "Quantity", "Price"
			}
		));
		
		JLabel lblTotalCost = new JLabel("Total Cost :");
		lblTotalCost.setBackground(new Color(240, 240, 240));
		lblTotalCost.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotalCost.setBounds(140, 292, 123, 45);
		panel_1.add(lblTotalCost);
		
		total_cost = new JTextField();
		total_cost.setFont(new Font("Arial Black", Font.BOLD, 20));
		total_cost.setColumns(10);
		total_cost.setBounds(850, 34, 109, 24);
		panel_1.add(total_cost);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAmount.setBounds(775, 36, 165, 24);
		panel_1.add(lblAmount);
		
		Finalamt = new JTextField();
		Finalamt.setFont(new Font("Arial", Font.BOLD, 20));
		Finalamt.setBounds(283, 294, 141, 38);
		panel_1.add(Finalamt);
		Finalamt.setColumns(10);
		
		JButton btnSaveOrder = new JButton("Save Order");
		btnSaveOrder.setForeground(new Color(255, 255, 255));
		btnSaveOrder.setBackground(new Color(148, 0, 211));
		btnSaveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String custid = txtcustid.getText();
				String custname = txtcustname.getText();
				String custmob = txtcustmob.getText();
				String proname = comboBoxName.getSelectedItem().toString();
				String quantity = txtqty.getSelectedItem().toString();
			    String final_amount = Finalamt.getText();
				

			    if ( custid.length()<=0 || custname.length()<=0 || custmob.length()<=0 || proname.length()<=0 || quantity.length()<=0 )
			    {
			    	JOptionPane.showMessageDialog(null, "Please enter valid details");
			    }
			    
			    else {

				try {
		    		Class.forName("com.mysql.jdbc.Driver");  
		    	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery","root","16052001");  
		    		Statement stmt=con.createStatement();
		    		String sql = "insert into Customers(CustID,CustName,Date,Amount)values(" + "'" + custid + "'" + "," + "'" + custname + "'" + ","  + "NOW()" + "," + "'" + final_amount + "'" +  ");";
				    stmt.executeUpdate(sql);
				    
				    JOptionPane.showMessageDialog(null, "Order saved !");
				}
				
				catch(Exception e1) {
					System.out.print(e1);
				}
				
			    }
			    
			}
		});
		btnSaveOrder.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSaveOrder.setBounds(728, 295, 193, 38);
		panel_1.add(btnSaveOrder);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BakeryMain k3 = new BakeryMain();
				k3.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setBackground(new Color(148, 0, 211));
		btnBack.setBounds(950, 295, 161, 38);
		panel_1.add(btnBack);
		fillComboBox();
		
	}
}
