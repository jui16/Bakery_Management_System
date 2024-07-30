import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class AddProduct extends JFrame {
    

	private JPanel contentPane;
	private JTextField txtpname;
	private JTextField txtpcost;
	private JTextField txtpcname;
	private JTextField txtpid;
	DefaultTableModel model;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	public AddProduct() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 715);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 112, 219));
		panel.setBounds(181, 125, 743, 481);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtpname = new JTextField();
		txtpname.setBackground(new Color(230, 230, 250));
		txtpname.setBounds(224, 103, 352, 27);
		panel.add(txtpname);
		txtpname.setColumns(10);
		
		JButton btnNewButton = new JButton("Save Product");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(148, 0, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String pid,pname,pcost,pcname,ptype;
				pid = txtpid.getText();
				pname = txtpname.getText();
				pcost = txtpcost.getText();
				pcname = txtpcname.getText();
				
				
				if( pid.length()<=0 || pname.length()<=0 || pcost.length()<=0 || pcname.length()<=0)
				{
					JOptionPane.showMessageDialog(null, "Please enter all values");
				}
				
				else {
				
				
					try {
			    		Class.forName("com.mysql.jdbc.Driver");  
			    	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery","root","16052001");  
			    		Statement stmt=con.createStatement();
			    		String sql = "insert into Products(ID,ProductName,Cost,Company)values(" + "'" + pid + "'" + "," + "'" + pname + "'" + "," + "'" + pcost +"'" + "," + "'" + pcname + "'" +  ");";
					    stmt.executeUpdate(sql);
					    
					    JOptionPane.showMessageDialog(null, "Product saved !");
					}
					
					catch(Exception e1) {
						System.out.print(e1);
					}
				
			}	
				
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(165, 331, 197, 41);
		panel.add(btnNewButton);
		
		JLabel Pid = new JLabel("Product Name");
		Pid.setForeground(new Color(255, 255, 255));
		Pid.setBackground(new Color(0, 0, 0));
		Pid.setBounds(49, 106, 165, 24);
		panel.add(Pid);
		Pid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblCostPerUnit = new JLabel("Cost Per Unit");
		lblCostPerUnit.setForeground(new Color(255, 255, 255));
		lblCostPerUnit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCostPerUnit.setBounds(49, 142, 165, 24);
		panel.add(lblCostPerUnit);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setForeground(new Color(255, 255, 255));
		lblCompanyName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCompanyName.setBounds(49, 176, 165, 24);
		panel.add(lblCompanyName);
		
		txtpcost = new JTextField();
		txtpcost.setBackground(new Color(230, 230, 250));
		txtpcost.setColumns(10);
		txtpcost.setBounds(224, 139, 352, 27);
		panel.add(txtpcost);
		
		txtpcname = new JTextField();
		txtpcname.setBackground(new Color(230, 230, 250));
		txtpcname.setColumns(10);
		txtpcname.setBounds(224, 177, 352, 27);
		panel.add(txtpcname);
		
		JButton btnCancel = new JButton("Back\r\n");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(148, 0, 211));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BakeryMain k = new BakeryMain();
				k.setVisible(true);
				dispose();
				
				
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCancel.setBounds(421, 331, 197, 41);
		panel.add(btnCancel);
		model = new DefaultTableModel();
		Object[] column = {"ID","Name","Cost","Company","Type"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setForeground(new Color(255, 250, 250));
		lblProductId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblProductId.setBounds(49, 64, 165, 24);
		panel.add(lblProductId);
		
		txtpid = new JTextField();
		txtpid.setBackground(new Color(230, 230, 250));
		txtpid.setColumns(10);
		txtpid.setBounds(224, 66, 352, 27);
		panel.add(txtpid);
		
		JLabel lblNewLabel = new JLabel("Product Management");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
		lblNewLabel.setBounds(409, 49, 366, 36);
		contentPane.add(lblNewLabel);
	}
}
