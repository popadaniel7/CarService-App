package carservice.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import carservice.connection.mysql_connection;
import net.proteanit.sql.DbUtils;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;



public class CarService extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField nameField;
	private JTextField licenceField;
	private JTextField carField;
	private JTextField modelField;
	private JTextField mechanicField;
	private JTextField priceField;
	private JTextField partsField;
	private JTextField removeField;
	private JTextField searchField;
	private JTextField namefield;
	private JTextField licencefield;
	private JTextField carfield;
	private JTextField modelfield;
	private JTextField mechanicfield;
	private JTextField pricefield;
	private JTextField partsfield;
	//private int auxID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarService frame = new CarService();
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
	public CarService() {
		setTitle("Auto Car Service");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Auto Car Service");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 400, 48);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 60, 710, 610);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Customer", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel.setBounds(10, 60, 325, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		name.setBounds(10, 25, 110, 20);
		panel.add(name);
		
		JLabel licence_plate = new JLabel("Licence Plate:");
		licence_plate.setFont(new Font("Tahoma", Font.BOLD, 15));
		licence_plate.setBounds(10, 50, 110, 20);
		panel.add(licence_plate);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Car:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 75, 110, 20);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Model:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 100, 110, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		nameField = new JTextField();
		nameField.setBounds(130, 25, 90, 20);
		panel.add(nameField);
		nameField.setColumns(10);
		
		licenceField = new JTextField();
		licenceField.setBounds(130, 50, 90, 20);
		panel.add(licenceField);
		licenceField.setColumns(10);
		
		carField = new JTextField();
		carField.setBounds(130, 75, 90, 20);
		panel.add(carField);
		carField.setColumns(10);
		
		modelField = new JTextField();
		modelField.setBounds(130, 100, 90, 20);
		panel.add(modelField);
		modelField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActionListener(e);
				loadButtonActionListener(e);
			}
		});
		btnNewButton.setBounds(5, 210, 90, 25);
		panel.add(btnNewButton);
		
		JLabel mech = new JLabel("Mechanic:");
		mech.setFont(new Font("Tahoma", Font.BOLD, 15));
		mech.setBounds(10, 125, 110, 20);
		panel.add(mech);
		
		JLabel pric = new JLabel("Price:");
		pric.setFont(new Font("Tahoma", Font.BOLD, 15));
		pric.setBounds(10, 150, 110, 20);
		panel.add(pric);
		
		JLabel pts = new JLabel("Parts changed:");
		pts.setFont(new Font("Tahoma", Font.BOLD, 15));
		pts.setBounds(10, 175, 111, 20);
		panel.add(pts);
		
		mechanicField = new JTextField();
		mechanicField.setBounds(130, 125, 90, 20);
		panel.add(mechanicField);
		mechanicField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(130, 150, 90, 20);
		panel.add(priceField);
		
		partsField = new JTextField();
		partsField.setColumns(10);
		partsField.setBounds(130, 175, 90, 20);
		panel.add(partsField);
		
		JButton loadButton = new JButton("Load");
		loadButton.setBounds(105, 210, 90, 25);
		panel.add(loadButton);
		loadButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitButtonActionListener(e);
			}
		});
		exitButton.setBounds(205, 210, 90, 25);
		panel.add(exitButton);
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("Customer ID:");
		lblNewLabel_4.setBounds(10, 250, 110, 20);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		removeField = new JTextField();
		removeField.setBounds(130, 250, 90, 20);
		panel.add(removeField);
		removeField.setColumns(10);
		
		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(228, 246, 90, 25);
		panel.add(removeButton);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeButtonActionListener(e);
				loadButtonActionListener(e);
			}
		});
		removeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadButtonActionListener(e);
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Search Customer", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 370, 325, 300);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Customer ID:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(10, 25, 110, 20);
		panel_3.add(lblNewLabel_4_1);
		
		searchField = new JTextField();
		searchField.setColumns(10);
		searchField.setBounds(130, 25, 90, 20);
		panel_3.add(searchField);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchButtonActionListener(e);
			}
		});
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchButton.setBounds(10, 50, 90, 25);
		panel_3.add(searchButton);
		
		JLabel name_1 = new JLabel("Name:");
		name_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		name_1.setBounds(10, 100, 110, 20);
		panel_3.add(name_1);
		
		JLabel licence_plate_1 = new JLabel("Licence Plate:");
		licence_plate_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		licence_plate_1.setBounds(10, 125, 110, 20);
		panel_3.add(licence_plate_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Car:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_2.setBounds(10, 150, 110, 20);
		panel_3.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Model:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(10, 175, 110, 20);
		panel_3.add(lblNewLabel_1_1_1_1_1);
		
		JLabel mech_1 = new JLabel("Mechanic:");
		mech_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		mech_1.setBounds(10, 200, 110, 20);
		panel_3.add(mech_1);
		
		JLabel pric_1 = new JLabel("Price:");
		pric_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		pric_1.setBounds(10, 225, 110, 20);
		panel_3.add(pric_1);
		
		JLabel pts_1 = new JLabel("Parts changed:");
		pts_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		pts_1.setBounds(9, 250, 111, 20);
		panel_3.add(pts_1);
		
		namefield = new JTextField();
		namefield.setColumns(10);
		namefield.setBounds(130, 100, 90, 20);
		panel_3.add(namefield);
		
		licencefield = new JTextField();
		licencefield.setColumns(10);
		licencefield.setBounds(130, 125, 90, 20);
		panel_3.add(licencefield);
		
		carfield = new JTextField();
		carfield.setColumns(10);
		carfield.setBounds(130, 150, 90, 20);
		panel_3.add(carfield);
		
		modelfield = new JTextField();
		modelfield.setColumns(10);
		modelfield.setBounds(130, 175, 90, 20);
		panel_3.add(modelfield);
		
		mechanicfield = new JTextField();
		mechanicfield.setColumns(10);
		mechanicfield.setBounds(130, 200, 90, 20);
		panel_3.add(mechanicfield);
		
		pricefield = new JTextField();
		pricefield.setColumns(10);
		pricefield.setBounds(130, 225, 90, 20);
		panel_3.add(pricefield);
		
		partsfield = new JTextField();
		partsfield.setColumns(10);
		partsfield.setBounds(130, 250, 90, 20);
		panel_3.add(partsfield);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButtonActionListener(e);
				loadButtonActionListener(e);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(10, 75, 90, 25);
		panel_3.add(btnNewButton_1);
		idreset();
	}
	
	private void addActionListener(ActionEvent e)
    {
        String Name = nameField.getText();
        String LicencePlate = licenceField.getText();
        String Car = carField.getText();
        String Model = modelField.getText();
        String Mechanic = mechanicField.getText();
        String Price = priceField.getText();
        String PartsChanged = partsField.getText();
        
        try {
            PreparedStatement ps = mysql_connection.createConnection().prepareStatement("INSERT INTO carservice(`Name`,`Licence Plate`, `Car`, `Model`, `Mechanic`, `Price`, `Parts Changed`) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, Name);
            ps.setString(2, LicencePlate);
            ps.setString(3, Car);
            ps.setString(4, Model);
            ps.setString(5, Mechanic);
            ps.setString(6, Price);
            ps.setString(7, PartsChanged);
            ps.executeUpdate();
            ps.close();
            nameField.setText("");
            licenceField.setText("");
            carField.setText("");
            modelField.setText("");
            mechanicField.setText("");
            priceField.setText("");
            partsField.setText("");
            nameField.requestFocus();
            JOptionPane.showMessageDialog(this,"Customer added");
            idreset();
            
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
	private void loadButtonActionListener(ActionEvent e)
	{
		try {
			Statement st = mysql_connection.createConnection().createStatement();
			ResultSet srs = st.executeQuery("SELECT * from carservice");
			table.setModel(DbUtils.resultSetToTableModel(srs));
			srs = st.getResultSet();
			st.close();
			JOptionPane.showMessageDialog(this,"Table loaded");
			idreset();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private void removeButtonActionListener(ActionEvent e)
	{
		try {
			PreparedStatement ps = mysql_connection.createConnection().prepareStatement("DELETE from carservice where ID = ?");
			ps.setInt(1, Integer.parseInt(removeField.getText()));
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(this,"Customer removed");
			idreset();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private void searchButtonActionListener(ActionEvent e)
	{
		try {
			PreparedStatement Ps = mysql_connection.createConnection().prepareStatement("SELECT `Name`,`Licence Plate`,`Car`,`Model`,`Mechanic`,`Price`,`Parts Changed` from carservice where ID = ?");
			Ps.setInt(1, Integer.parseInt(searchField.getText())); 
			ResultSet srh = Ps.executeQuery();
			srh.next();
			String Name = srh.getString("Name");
			String LicencePlate = srh.getString("Licence Plate");
			String Car = srh.getString("Car");
			String Model = srh.getString("Model");
			String Mechanic = srh.getString("Mechanic");
			String Price = srh.getString("Price");
			String PartsChanged = srh.getString("Parts Changed");
			namefield.setText(Name);
            licencefield.setText(LicencePlate);
            carfield.setText(Car);
            modelfield.setText(Model);
            mechanicfield.setText(Mechanic);
            pricefield.setText(Price);
            partsfield.setText(PartsChanged);
            JOptionPane.showMessageDialog(this,"Customer found");
            idreset();
            Ps.close();
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}
	
	private void editButtonActionListener(ActionEvent e)
	{
		String Name = namefield.getText();
        String LicencePlate = licencefield.getText();
        String Car = carfield.getText();
        String Model = modelfield.getText();
        String Mechanic = mechanicfield.getText();
        String Price = pricefield.getText();
        String PartsChanged = partsfield.getText();
		try {
			PreparedStatement ps = mysql_connection.createConnection().prepareStatement("UPDATE carservice SET `Name` = ? , `Licence Plate` = ? , `Car` = ? , `Model` = ? , `Mechanic` = ? , `Price` = ? , `Parts Changed` = ? where ID = ?");
			 	ps.setString(1, Name);
	            ps.setString(2, LicencePlate);
	            ps.setString(3, Car);
	            ps.setString(4, Model);
	            ps.setString(5, Mechanic);
	            ps.setString(6, Price);
	            ps.setString(7, PartsChanged);
	            ps.setInt(8, Integer.parseInt(searchField.getText()));
	            JOptionPane.showMessageDialog(this,"Customer Edited");
	            idreset();
	            ps.executeUpdate();
	            ps.close();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	private void exitButtonActionListener(ActionEvent e)
	{
		this.dispose();
	}
	
	private void idreset()
	{
		try {
			Statement s = mysql_connection.createConnection().createStatement();
			String s1 = "SET  @num := 0;";
			String s2 = "UPDATE carservice SET id = @num := (@num+1);";
			String s3 = "ALTER TABLE carservice AUTO_INCREMENT =1;";
			s.addBatch(s1);
			s.addBatch(s2);
			s.addBatch(s3);
			s.executeBatch();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
