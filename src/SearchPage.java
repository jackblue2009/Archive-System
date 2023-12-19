import java.awt.Color;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;


@SuppressWarnings("serial")
public class SearchPage extends JFrame
{
	JFrame frame = new JFrame();
	public static final int WIDTH = 1280, HEIGHT = 720;
	private JLabel title;
	private JLabel countLbl;
	private JTextField nameTxt;
	private JTextField fileNumTxt;
	private JTextField cprTxt;
	@SuppressWarnings("rawtypes")
	private JComboBox caseTypeTxt;
	private JProgressBar jProgress;
	
	//MENU BAR VARIABLE START
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem checkDBMenu;
	private JMenuItem updateDBMenu;
	private JMenuItem checkFileNum;
	private JMenuItem logsMenu;
	//MENU BAR VARIABLE END
	
	Connection connection = sqliteConnection.dbConnector();
	ResultSet rs, rs1, rs2;
	Statement smt, smt1;
	PreparedStatement pst, pst1, pst2;
	
	private JTable table = new JTable();
	private DefaultTableModel model = (DefaultTableModel)table.getModel();
	String column[] = {"عرض", "الصفة", "نوع الدعوى", "نوع القضية", "الرقم الشخصي للموكل", "اسم الخصم", "رقم الدعوى", "الاسم" };
	boolean searchDone = false;
	String copyright = "\u00a9";
	int searchCount = 0;
	
	
	@SuppressWarnings("null")
	public void DisplayData()
	{
		String txtName;
		long txtFileNum;
		int txtCpr;
		String txtCase;
		String content = "المحتوى";
		String query = "";
		
		
		try
		{
			txtName = nameTxt.getText();
			txtFileNum = Long.parseLong(fileNumTxt.getText());
			txtCpr = !cprTxt.getText().equals(null) ? Integer.parseInt(cprTxt.getText()) : 1;
			txtCase = caseTypeTxt.getSelectedItem().toString();
		}
		catch (NumberFormatException m)
		{
			txtFileNum = (long) 0;
			txtCpr = 1;
			txtName = "";
			txtCase = "";
			//fileNumTxt.setText("0");
			//cprTxt.setText("0");
		}
		
		try
		{
			if (!nameTxt.getText().isEmpty() && caseTypeTxt.getSelectedIndex() == 0 && cprTxt.getText().isEmpty() && fileNumTxt.getText().equals("0"))
			{
				query = "SELECT * FROM client WHERE name LIKE '"+nameTxt.getText()+"%' AND rule IS NULL;";
			
			}
		
			else if (caseTypeTxt.getSelectedIndex() == 0 && nameTxt.getText().isEmpty() && !cprTxt.getText().isEmpty() && fileNumTxt.getText().equals("0"))
			{
				query = "SELECT * FROM client WHERE cpr LIKE '"+txtCpr+"' AND rule IS NULL;";
			}
			else if (caseTypeTxt.getSelectedIndex() == 0 && nameTxt.getText().isEmpty() && cprTxt.getText().isEmpty() && !fileNumTxt.getText().equals("0"))
			{
				query = "SELECT * FROM client WHERE filenumber LIKE '"+Long.parseLong(fileNumTxt.getText())+"' AND rule IS NULL;";
			}
			else if (caseTypeTxt.getSelectedIndex() != 0 && nameTxt.getText().isEmpty() && cprTxt.getText().isEmpty() && fileNumTxt.getText().equals("0"))
			{
				query = "SELECT * FROM client WHERE mctype LIKE '"+caseTypeTxt.getSelectedItem().toString()+"' AND rule IS NULL;";
			}
			else
			{
				query = "SELECT * FROM client WHERE rule IS NULL;";
			}
		}
		catch (NumberFormatException x)
		{
			JOptionPane.showMessageDialog(null, "الرجاء إدخال رقم صحيح");
		}
		
		try
		{
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			int a=0;
			while (a <= 100)
			{
				jProgress.setValue(a + 10);
				
				Thread.sleep(25);
				a = a + 20;
			}
			
			while (rs.next())					
			{	////////ADD DATA TO THE TABLE BASED ON THE SELECTED FROM THE SQL QUERY ABOVE
				String name = rs.getString("name");
				String aName = rs.getString("aname");
				int cpr = rs.getInt("cpr");
				long fileNum = rs.getLong("filenumber");
				String mC = rs.getString("mctype");
				String sC = rs.getString("sctype");
				String type = rs.getString("type");
				//table.setModel(DbUtils.resultSetToTableModel(rs));
				model.setColumnIdentifiers(column);
				model.addRow(new Object[] {content, type, mC, sC, cpr, aName, fileNum, name});
					
				table.setModel(model);
				searchCount++;
			}
			if (model.getRowCount() <= 0)
			{
				countLbl.setText("لم يتم العثور على سجل");
				countLbl.setForeground(Color.RED);
				jProgress.setValue(0);
			}
			searchDone = true;
			
			if (searchCount >= 1)
			{
				countLbl.setText("تم العثور على "+searchCount+" سجل!"); //Order here messed up, I know cuz Arabic lang, just keep it like this.
				countLbl.setForeground(new Color(3,143,20));
			}
			searchCount = 0;
			////////////////////////////////////////////////
			///////////////////////////////////////////////
			///////////////////////////////////////////////
			DefaultTableCellRenderer cR = new DefaultTableCellRenderer();
			cR.setHorizontalAlignment(JLabel.CENTER);
			////CENTER ALL TEXT CELLS INSIDE THE TABLE (EXCLUDING THE TABLE HEADER)
			for (int i=0; i<table.getColumnCount(); i++)
			{
				table.getColumnModel().getColumn(i).setCellRenderer(cR);
				if (i == 7)
					table.getColumnModel().getColumn(i).setPreferredWidth(100);
				else if (i==4)
				{
					table.getColumnModel().getColumn(i).setPreferredWidth(70);
				}
				else
				{
					table.getColumnModel().getColumn(i).setPreferredWidth(50);
				}
			}
			for (int i=0; i<table.getRowCount(); i++)
			{
				AbstractAction view = new AbstractAction()
				{
					public void actionPerformed (ActionEvent e)
					{
						try
						{
							if (!Desktop.isDesktopSupported())
							{
								JOptionPane.showMessageDialog(null, "Desktop class is not supported");
							}
							Desktop desktop = Desktop.getDesktop();
							String sql = "SELECT d_path FROM document WHERE filenumber LIKE '"+table.getValueAt(table.getSelectedRow(), 6)+"';";
							pst1 = connection.prepareStatement(sql);
							rs1 = pst1.executeQuery();
							while (rs1.next())
							{
								String path = rs1.getString("d_path");
								File file = new File(path);
								//JOptionPane.showMessageDialog(null, path);
								if (path != null && file.exists())
									desktop.open(file);
								else if (!file.exists() || path == null)
									JOptionPane.showMessageDialog(null, "لا يوجد ملف");
							}
						}
						catch (Exception d)
						{
							JOptionPane.showMessageDialog(null, d.toString());
						}
					}
				};
				
				ButtonColumn btnColumn = new ButtonColumn(table, view, 0);
				btnColumn.setMnemonic(KeyEvent.VK_D);
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.toString());
			//JOptionPane.showMessageDialog(null, "Unable to load data: ");
		}
		
		
		try
		{	
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			JOptionPane.showMessageDialog(null, "لا يمكن البحث بدون إدخال أي بيانات");
		}
	}
	
	public void DisplayDistTamData()
	{
		try
		{
			String content = "المحتوى";
			////////////////////////////////
			String sql = "SELECT * FROM client WHERE rule IS NOT NULL";
			PreparedStatement psd12 = connection.prepareStatement(sql);
			ResultSet rs12 = psd12.executeQuery();
			
			int a=0;
			while (a <= 100)
			{
				jProgress.setValue(a + 10);
				
				Thread.sleep(25);
				a = a + 20;
			}
			
			while (rs12.next())					
			{	////////ADD DATA TO THE TABLE BASED ON THE SELECTED FROM THE SQL QUERY ABOVE
				String name = rs12.getString("name");
				String aName = rs12.getString("aname");
				int cpr = rs12.getInt("cpr");
				long fileNum = rs12.getLong("filenumber");
				String mC = rs12.getString("mctype") +"/"+ rs12.getString("rule");
				String sC = rs12.getString("sctype");
				String type = rs12.getString("type");
				//table.setModel(DbUtils.resultSetToTableModel(rs));
				model.setColumnIdentifiers(column);
				model.addRow(new Object[] {content, type, mC, sC, cpr, aName, fileNum, name});
					
				table.setModel(model);
				searchCount++;
			}
			if (model.getRowCount() <= 0)
			{
				countLbl.setText("لم يتم العثور على سجل");
				countLbl.setForeground(Color.RED);
				jProgress.setValue(0);
			}
			searchDone = true;
			
			if (searchCount >= 1)
			{
				countLbl.setText("تم العثور على "+searchCount+" سجل!"); //Order here messed up, I know cuz Arabic lang, just keep it like this.
				countLbl.setForeground(new Color(3,143,20));
			}
			searchCount = 0;
			////////////////////////////////////
			///////////////////////////////////
			/////////////////////////////////
			//////////////////////////////////////
			/////////////////////////////////
			///////////////////////////////////////
			DefaultTableCellRenderer cR = new DefaultTableCellRenderer();
			cR.setHorizontalAlignment(JLabel.CENTER);
			////CENTER ALL TEXT CELLS INSIDE THE TABLE (EXCLUDING THE TABLE HEADER)
			for (int i=0; i<table.getColumnCount(); i++)
			{
				table.getColumnModel().getColumn(i).setCellRenderer(cR);
				if (i == 7)
					table.getColumnModel().getColumn(i).setPreferredWidth(100);
				else if (i==4)
				{
					table.getColumnModel().getColumn(i).setPreferredWidth(70);
				}
				else
				{
					table.getColumnModel().getColumn(i).setPreferredWidth(50);
				}
			}
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			for (int i=0; i<table.getRowCount(); i++)
			{
				AbstractAction view = new AbstractAction()
				{
					public void actionPerformed (ActionEvent e)
					{
						try
						{
							if (!Desktop.isDesktopSupported())
							{
								JOptionPane.showMessageDialog(null, "Desktop class is not supported");
							}
							Desktop desktop = Desktop.getDesktop();
							String sql = "SELECT d_path FROM document WHERE filenumber LIKE '"+table.getValueAt(table.getSelectedRow(), 6)+"';";
							pst1 = connection.prepareStatement(sql);
							rs1 = pst1.executeQuery();
							while (rs1.next())
							{
								String path = rs1.getString("d_path");
								File file = new File(path);
								//JOptionPane.showMessageDialog(null, path);
								if (path != null && file.exists())
									desktop.open(file);
								else if (!file.exists() || path == null)
									JOptionPane.showMessageDialog(null, "لا يوجد ملف");
							}
						}
						catch (Exception d)
						{
							JOptionPane.showMessageDialog(null, d.toString());
						}
					}
				};
							
			ButtonColumn btnColumn = new ButtonColumn(table, view, 0);
			btnColumn.setMnemonic(KeyEvent.VK_D);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SearchPage(int width, int height)
	{
		frame = this;
		setResizable(false);
		this.setPreferredSize(new Dimension(width,height));
		this.setMaximumSize(new Dimension(width,height));
		this.setMinimumSize(new Dimension(width,height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		//BUILD THE FILE MENU
		fileMenu = new JMenu("Settings");
		fileMenu.setForeground(Color.WHITE);
		checkDBMenu  = new JMenuItem("Check Database Connection");
		checkDBMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (connection != null)
				{
					JOptionPane.showMessageDialog(null, "Connection Successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Connection Failed");
				}
			}
		});
		checkFileNum = new JMenuItem("Check File Number");
		checkFileNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					long usrFileNum = Long.parseLong(JOptionPane.showInputDialog(null, "Enter a file number:"));
					PreparedStatement _pst;
					ResultSet _rs;
					int count = 0;
					String sql = "SELECT * FROM client WHERE filenumber = '"+usrFileNum+"'";
					_pst = connection.prepareStatement(sql);
					_rs = _pst.executeQuery();
					while (_rs.next())
					{
						count++;
					}
					if (count >= 1)
						JOptionPane.showMessageDialog(null, count+" "+" of records under ["+usrFileNum+"] exist.");
					else
						JOptionPane.showMessageDialog(null, "No records exist under the entered number.");
				}
				catch (NumberFormatException n)
				{
					JOptionPane.showMessageDialog(null, "You entered an invalid characters.");
				}
				catch (SQLException s)
				{
					s.printStackTrace();
				}
			}
		});
		updateDBMenu = new JMenuItem("Backup Database");
		updateDBMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				LocalDate date = LocalDate.now();
				String dirName = "Database-"+date;
				File directory = new File("backup\\"+dirName);
				
				if (!directory.exists())
				{
					directory.mkdir();
					
					InputStream inStream = null;
					OutputStream outStream = null;
					String fileName = "archive-db.db";
					try
					{
						File source = new File("archive-db.db");
						File dest = new File(directory+"\\", fileName);
						inStream = new FileInputStream(source);
						outStream = new FileOutputStream(dest);
						
						byte[] buffer = new byte[1024];
						
						int length;
		                while ((length = inStream.read(buffer)) > 0)
		                {
		                	outStream.write(buffer, 0, length);
		                }
		                
		                if(inStream != null)
		                	inStream.close();
		                if(outStream != null)
		                	outStream.close();
		                
		                JOptionPane.showMessageDialog(null, "Database backed up successfully!");
					}
					catch (IOException t)
					{
						t.printStackTrace();
					}
				}
			}
		});
		logsMenu = new JMenuItem("Logs");
		logsMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				File logPath = new File ("logs.txt");
				Desktop desktop = Desktop.getDesktop();
				if (logPath.exists())
				{
					try
					{
						desktop.open(logPath);
					}
					catch (IOException i)
					{
						i.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "لا يوجد ملف تسجيلات");
				}
			}
		});
		fileMenu.add(checkDBMenu);
		fileMenu.add(updateDBMenu);
		fileMenu.add(checkFileNum);
		fileMenu.add(logsMenu);
		
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		
		//THE CODE BELOW IS FOR THE TITLE OF THIS CONTENT SECTION
		title = new JLabel("البحث");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(540,11,175,62);
		getContentPane().add(title);
		
		jProgress = new JProgressBar();
		jProgress.setBounds(25, 11, 300, 70);
		jProgress.setValue(0);
		jProgress.setStringPainted(true);
		getContentPane().add(jProgress);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(null);
		upperPanel.setBounds(25, 86, 1225, 100);
		upperPanel.setBorder(new LineBorder(Color.BLACK, 1));
		getContentPane().add(upperPanel);
		
		JLabel nameLbl = new JLabel("الاسم");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameLbl.setBounds(1076, 13, 70, 34);
		upperPanel.add(nameLbl);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(876, 21, 150, 22);
		upperPanel.add(nameTxt);
		nameTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed (KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					model.setRowCount(0);				//Resets table to ZERO rows
					DisplayData();
					//TEXTFIELDS RESET CODES START
					cprTxt.setText("");
					fileNumTxt.setText("0");
					nameTxt.setText("");
					caseTypeTxt.setSelectedIndex(0);
					//TEXTFIELDS RESET CODES END
				}
			}
		});
		nameTxt.setColumns(10);
		
		JLabel fileNumLbl = new JLabel("رقم الدعوى");
		fileNumLbl.setHorizontalAlignment(SwingConstants.CENTER);
		fileNumLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fileNumLbl.setBounds(676, 13, 95, 34);
		upperPanel.add(fileNumLbl);
		
		fileNumTxt = new JTextField("0");
		fileNumTxt.setColumns(10);
		fileNumTxt.setBounds(476, 21, 150, 22);
		fileNumTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed (KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					model.setRowCount(0);				//Resets table to ZERO rows
					DisplayData();
					//TEXTFIELDS RESET CODES START
					cprTxt.setText("");
					fileNumTxt.setText("0");
					nameTxt.setText("");
					caseTypeTxt.setSelectedIndex(0);
					//TEXTFIELDS RESET CODES END
				}
			}
		});
		upperPanel.add(fileNumTxt);
		
		JLabel cprLbl = new JLabel("رقم الشخصي");
		cprLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cprLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cprLbl.setBounds(276, 13, 125, 34);
		upperPanel.add(cprLbl);
		
		cprTxt = new JTextField();
		cprTxt.setColumns(10);
		cprTxt.setBounds(76, 21, 150, 22);
		cprTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed (KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					model.setRowCount(0);				//Resets table to ZERO rows
					DisplayData();
					//TEXTFIELDS RESET CODES START
					cprTxt.setText("");
					fileNumTxt.setText("0");
					nameTxt.setText("");
					caseTypeTxt.setSelectedIndex(0);
					//TEXTFIELDS RESET CODES END
				}
			}
		});
		upperPanel.add(cprTxt);
		
		JLabel caseTypeLbl = new JLabel("نوع الدعوى");
		caseTypeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		caseTypeLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		caseTypeLbl.setBounds(1067, 53, 95, 34);
		upperPanel.add(caseTypeLbl);
		
		caseTypeTxt = new JComboBox();
		caseTypeTxt.setModel(new DefaultComboBoxModel(new String[] {"", "جنائي", "مدني", "شرعي", "عمالي"}));
		caseTypeTxt.setBounds(876, 60, 150, 22);
		caseTypeTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed (KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					model.setRowCount(0);				//Resets table to ZERO rows
					DisplayData();
					//TEXTFIELDS RESET CODES START
					cprTxt.setText("");
					fileNumTxt.setText("0");
					nameTxt.setText("");
					caseTypeTxt.setSelectedIndex(0);
					//TEXTFIELDS RESET CODES END
				}
			}
		});
		upperPanel.add(caseTypeTxt);
		
		JButton searchBtn = new JButton("ابحث");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);				//Resets table to ZERO rows
				DisplayData();
				//TEXTFIELDS RESET CODES START
				cprTxt.setText("");
				fileNumTxt.setText("0");
				nameTxt.setText("");
				caseTypeTxt.setSelectedIndex(0);
				//TEXTFIELDS RESET CODES END
			}
		});
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchBtn.setBounds(476, 60, 150, 35);
		upperPanel.add(searchBtn);
		JButton searchVIPBtn = new JButton("ابحث الأحكام الدستوري/التمييز");
		searchVIPBtn.setBounds(225, 60, 220, 35);
		searchVIPBtn.setFont(new Font("Tahome", Font.PLAIN, 18));
		searchVIPBtn.setBackground(new Color(51,153,255));
		searchVIPBtn.setForeground(Color.WHITE);
		searchVIPBtn.setBorder(new LineBorder(Color.WHITE, 2));
		searchVIPBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				model.setRowCount(0);
				DisplayDistTamData();
				//TEXTFIELDS RESET CODES START
				cprTxt.setText("");
				fileNumTxt.setText("0");
				nameTxt.setText("");
				caseTypeTxt.setSelectedIndex(0);
				//TEXTFIELDS RESET CODES END
			}
		});
		upperPanel.add(searchVIPBtn);
		//////////////////////////////////////
		countLbl = new JLabel();
		countLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		countLbl.setHorizontalAlignment(SwingConstants.LEFT);
		countLbl.setBounds(25, 60, 300, 33);
		//countLbl.setBorder(new LineBorder(Color.BLACK, 1));
		upperPanel.add(countLbl);
		
		///////////////////////////////////////////TABLE CODE STARTS HERE
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(25 , 212, 1225, 410); //Width was 770 => 368
		getContentPane().add(scrollPane);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		//table.setEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 21));				////For setting up the Table Header (column) font
		table.getTableHeader().setPreferredSize(new Dimension(50,50));
		
		table.setIntercellSpacing(new Dimension(5,5));
		
 		//String column[] = {"الاسم", "الرقم الشخصي", "رقم الملف", "نوع الدعوة", "نوع القضية"};
		///////////////////////////////////////////TABLE CODE ENDS HERE
		
		JLabel credits = new JLabel();
		credits.setBounds(440, 610, 300, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		credits.setText("Powered by NineNine Soft Tech"+copyright);
		getContentPane().add(credits);
		
		JLabel resultLbl = new JLabel("");
		resultLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		resultLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultLbl.setBounds(12, 491, 200, 40);
		//resultLbl.setText(totalCol);
		getContentPane().add(resultLbl);
		
	}

	public static void main(String[] args)
	{
		SearchPage window = new SearchPage(WIDTH,HEIGHT);
		window.setTitle("Alshamlan Attorney & Legal Consultations");
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);

	}
}
