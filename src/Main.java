import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ListView;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class ContractObject
{
	String num;
	String path;
	
	ContractObject(String n, String p)
	{
		num = n;
		path = p;
	}
}

public class Main extends JFrame implements ActionListener {
	/*
	 * IMPORTANT NOTICE
	 * THIS IS THE MAIN FILE FOR THE FOLLOWING PROGRAM
	 * IT CONTAINS ALL THE PAGES (JPANELS), ALL IMPORTANT METHODS, ETC..
	 * DO NOT EDIT, TOUCH, AND/OR ADD ANYTHING WITHOUT PROPER AUTHORITY
	 * THIS IS HIGHLY CLASSIFIED
	 * 
	 * LEAD PROGRAMMER: ABDULRAHMAN BUCHEERI
	 * DEVELOPER: SOFT NINE NINE TECH CO.
	 * 
	 * FOR ANY INFORMATION, ASK YOUR ADMINISRATOR
	 * */
	public static final int WIDTH = 800, HEIGHT = 600;
	JFrame frame = new JFrame();
	private JPanel homePanel, addPanel, editPanel; ///// THREE MAIN MENU PANELS
	private JPanel felonPanel, civilPanel, conservativePanel, laborPanel; //// SUBMENUE PANELS
	private JPanel editField, distorPanel, tamyeezPanel, studiesPanel, contPanel, conMenuPanel, contSearchPanel;
	private JButton addPageBtn, searchPageBtn, felonPageBtn, civilPageBtn, conservativePageBtn, laborPageBtn, backBtn,
			editPageBtn;
	private JLabel headImg;
	private JLabel credits;
	
	private JButton addContPageBtn, addContBtn;
	
	/*JFrame fFrame = new JFrame();
	private JDialog felonDialog = new JDialog(fFrame, "إضافة بيانات", true);*/

	// FELON PAGE VARIABLES START
	JTextField felonNameTxt;
	JTextField felonAccusedNameTxt;
	JTextField felonFileNumTxt;
	JTextField felonCprTxt;
	@SuppressWarnings("rawtypes")
	JComboBox felonCaseType;
	@SuppressWarnings("rawtypes")
	JComboBox felonTypeList;
	JButton felonBrowseBtn, felonAddBtn;
	JFileChooser felonFileChooser;
	File felonSelectedSourceFile;
	String felonAttachedPath, felonAttachedName = "";
	String felonFilePath = null;
	// FELON PAGE VARIABLES END
	
	//CIVIL PAGE VARIABLES START
	private JTextField civilNameTxt;
	private JTextField civilAccusedNameTxt;
	private JTextField civilFileNumTxt;
	private JTextField civilCprTxt;
	@SuppressWarnings("rawtypes")
	private JComboBox civilCaseType;
	@SuppressWarnings("rawtypes")
	private JComboBox civilTypeList;
	private JButton civilBrowseBtn, civilAddBtn;
	private JFileChooser civilFileChooser;
	private File civilSelectedSourceFile;
	private String civilAttachedPath, civilAttachedName = "";
	private String civilFilePath = null;
	//CIVIL PAGE VARIABLES END
	
	//CONSERVATIVE PAGE VARIABLES START
	private JTextField conservativeNameTxt;
	private JTextField conservativeAccusedNameTxt;
	private JTextField conservativeFileNumTxt;
	private JTextField conservativeCprTxt;
	@SuppressWarnings("rawtypes")
	private JComboBox conservativeCaseType;
	@SuppressWarnings("rawtypes")
	private JComboBox conservativeTypeList;
	private JButton conservativeBrowseBtn, conservativeAddBtn;
	private JFileChooser conservativeFileChooser;
	private File conservativeSelectedSourceFile;
	private String conservativeAttachedPath, conservativeAttachedName = "";
	private String conservativeFilePath = null;
	//CONSERVATIVE PAGE VARIABLES END
	
	//LABOR PAGE VARIABLES START
	private JTextField laborNameTxt;
	private JTextField laborAccusedNameTxt;
	private JTextField laborFileNumTxt;
	private JTextField laborCprTxt;
	@SuppressWarnings("rawtypes")
	private JComboBox laborCaseType;
	@SuppressWarnings("rawtypes")
	private JComboBox laborTypeList;
	private JButton laborBrowseBtn, laborAddBtn;
	private JFileChooser laborFileChooser;
	private File laborSelectedSourceFile;
	private String laborAttachedPath, laborAttachedName = "";
	private String laborFilePath = null;
	//LABOR PAGE VARIABLES END
	
	//DISTOR PAGE VARIABLES START
	public String distorAttachedName = "", distorAttachedPath = "", distorFilePath = "";
	//DISTOR PAGE VARIABLES END
	
	//TAMYEEZ PAGE VARIABLES START
	public String tamyeezAttachedName = "", tamyeezAttachedPath = "", tamyeezFilePath = "";
	//TAMYEEZ PAGE VARIABLES END
	
	//CONTRACT PAGE VARIABLES START
	public String contAttachedName = "", contAttachedPath = "", contFilePath = "";
	//CONTRACT PAGE VARIABLES END
	
	//EDIT PAGE VARIABLES START
	private JTextField editFileNumTxt;		//THIS ONE FOR SEARCH
	private JTextField editNameTxt;
	private JTextField editFileNumberTxt;	//THIS ONE FOR EDIT
	private JTextField editAccusedTxt;
	private JTextField editCprTxt;
	@SuppressWarnings("rawtypes")
	private JComboBox fileCaseType;
	@SuppressWarnings("rawtypes")
	private JComboBox caseList;
	@SuppressWarnings("rawtypes")
	private JComboBox typeList;
	private int editItemCount = 0;
	//EDIT PAGE VARIABLES END
	
	//MENU BAR VARIABLE START
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu importMenu;
	private JMenuItem checkDBMenu;
	private JMenuItem updateDBMenu;		//This one for BACKUP database
	private JMenuItem addSheet;
	private JMenuItem addFile;
	private JMenuItem checkFileNum;
	private JMenuItem logsMenu;
	//MENU BAR VARIABLE END
	
	//MS EXCEL IMPORT DIALOUGE VARIABLES START
	JFrame sheetFrame = new JFrame();
	JDialog sheetDialog = new JDialog(sheetFrame, "Import MS Excel File", true);
	JButton addSheetBtn;
	JLabel addSheetLbl;
	private JFileChooser sheetFileChooser;
	private File sheetSelectedSourceFile;
	private String sheetAttachedPath, sheetAttachedName = "";
	private String sheetFilePath = null;
	//MS EXCEL IMPORT DIALOUGE VARIABLES END
	
	///////////////////IMPORT REFERENCE FILE DIALOGE VARIABLES
	JFrame addFileFrame = new JFrame();
	JDialog addFileDialog = new JDialog(addFileFrame, "Import Reference File", true);
	JLabel addFileLbl;
	private JFileChooser attachedFileChooser;
	private File attachedSelectedSourceFile;
	private String attachedPath, attachedName = "", attachedFilePath = null;
	//@SuppressWarnings("rawtypes")
	//JComboBox[] FileNumBoxList = new JComboBox[4];
	//JTextField[] filePathList = new JTextField[4];
	///////////////////IMPORT REFERENCE FILE DIALOGE VARIABLES

	ImageIcon imgIcon = new ImageIcon("img\\saad-alshamlan-logo2.png");
	Image img = imgIcon.getImage();
	ImageIcon helpImgIcon = new ImageIcon("img\\question-mark.png");
	Image helpImg = helpImgIcon.getImage();

	JPanel mainPanel = new JPanel(new CardLayout());
	CardLayout mainLayout = (CardLayout) mainPanel.getLayout();

	private JTable table = new JTable();
	@SuppressWarnings("unused")
	private DefaultTableModel model = (DefaultTableModel) table.getModel();
	String column[] = { "الاسم", "الرقم الشخصي للموكل", "رقم الملف", "نوع الدعوة", "نوع القضية" };
	String copyright = "\u00a9";

	Connection connection = sqliteConnection.dbConnector();
	ResultSet rs, rs1, rs2, rsCD;		//rs1 == DISPLAY || rs == UPDATE
	Statement smt, smt1, smtCD;
	PreparedStatement pst, pstClient, pstAttached, pst2, pst1, pst3, pst4, pstCD;

	static int current = 0; // This static integer created to keep track of current panel/page
	
	public static boolean isNumeric(String str)
	{
		try
		{
			Long.parseLong(str);
			return true;
		}
		catch (NumberFormatException h)
		{
			return false;
		}
	}
	
	public static boolean isInt(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch (NumberFormatException h)
		{
			return false;
		}
	}
	
	////THE FOLLOWING FUNCTION IS USED TO ADD RECORD INTO THE DATABASE UNDER CLIENT TABLE UNDER THE FELONY CASE TYPE
	public void AddRecord(String name, String aName, long fileNum, int cpr, String mCType, String sCType, String type, String dName, String dPath, String ruling) {
		try
		{
			Client client = new Client (name, aName, fileNum, cpr, mCType, sCType, type, ruling);
			String query = "INSERT INTO client(name, cpr, filenumber, mctype, sctype, aname, type, rule) VALUES(?,?,?,?,?,?,?,?);";
			String sql = "INSERT INTO document(filenumber, d_name, d_path) VALUES(?,?,?);";
			pstClient = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstAttached = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstClient.setString(1, client.getName());
			pstClient.setInt(2, client.getCPR());
			pstClient.setLong(3, client.getFileNumber());
			pstClient.setString(4, client.getMainCase());
			pstClient.setString(5, client.getSubCase());
			pstClient.setString(6, client.getAccusedName());
			pstClient.setString(7, client.getType());
			pstClient.setString(8, client.getRuling());
			pstClient.executeUpdate();
			if (dName != null && dPath != null)
			{
				pstAttached.setLong(1, client.getFileNumber());
				pstAttached.setString(2, dName);
				pstAttached.setString(3, dPath);
				pstAttached.executeUpdate();
			}
			WriteLogs("A new record has been added under filenumber: "+fileNum);
			//JOptionPane.showMessageDialog(null, "تمت إضافة البيانات");
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void DisplayRecord()
	{
		try
		{
			String query = "SELECT name, cpr, filenumber, mctype, sctype, aname, type, rule FROM client WHERE filenumber = '"+Long.parseLong(editFileNumTxt.getText())+"';";
			pst = connection.prepareStatement(query);
			rs1 = pst.executeQuery();
			
			while (rs1.next())
			{
				String name, cpr, mCase, sCase, aName, type, ruling;
				long fileNum;
				name = rs1.getString("name");
				cpr = rs1.getString("cpr");
				fileNum = rs1.getLong("filenumber");
				mCase = rs1.getString("mctype");
				sCase = rs1.getString("sctype");
				aName = rs1.getString("aname");
				type = rs1.getString("type");
				ruling = rs1.getString("rule");
				editNameTxt.setText(name);
				editFileNumberTxt.setText(String.valueOf(fileNum));
				editCprTxt.setText(cpr);
				editAccusedTxt.setText(aName);
				fileCaseType.setSelectedItem(mCase);
				caseList.setSelectedItem(sCase);
				typeList.setSelectedItem(type);
				/*switch (mCase)
				{
				case "جنائي":
					caseList.setModel(new DefaultComboBoxModel(new String[] {"القتل", "المخدرات", "اعتداء", "السرقة", "القذف", "اختلاس", "غسيل أموال", "أخرى"}));
					break;
				case "مدني":
					caseList.setModel(new DefaultComboBoxModel(new String[] {"إيجار", "تعويض", "مطالبات مالية", "إفلاس", "تحكيم", "أخرى"}));
					break;
				case "شرعي":
					caseList.setModel(new DefaultComboBoxModel(new String[] {"طلاق", "نــفــقــة", "حضانة", "أخرى"}));
					break;
				case "عمالي":
					caseList.setModel(new DefaultComboBoxModel(new String[] {"تعويض", "مستحقات", "إعادة إلى الخدمة", "وقف قرار الفصل", "أخرى"}));
					break;
				default:
					caseList.setModel(new DefaultComboBoxModel(new String[] {"لا يوجد أي بيانات"}));
					break;
				}*/
				//caseList.setModel(new DefaultComboBoxModel (new String[] {"القتل", "المخدرات", "اعتداء", "السرقة", "القذف", "اختلاس", "غسيل أموال", 
				//		"=========", "إيجار", "تعويض", "مطالبات مالية", "إفلاس", "تحكيم", "=========", "طلاق", "نــفــقــة", "حضانة", "=========", "تعويض", "مستحقات", "إعادة إلى الخدمة", "وقف قرار الفصل"}));
				typeList.setModel(new DefaultComboBoxModel (new String[] {"المدّعي", "المدّعي عليه", "المستأنف", "المستأنف عليه", "الطاعن", "المطعون ضده", "متهم"}));
				//JOptionPane.showMessageDialog(null, mCase);
				editItemCount = editItemCount + 1;
				/*if (rs1.last())
				{
					size = rs1.getRow();
					rs1.beforeFirst();
				}*/
			}
			if (editItemCount <= 0)
			{
				JOptionPane.showMessageDialog(null, "الرقم الذي أدخلته غير موجود");
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	
	public void UpdateRecord()
	{
		try
		{
			long fileNum = Long.parseLong(editFileNumTxt.getText());
			smt = connection.createStatement();
			String sql = "SELECT * FROM client;";
			rs = smt.executeQuery(sql);
			String query = "SELECT * FROM document WHERE filenumber = '"+fileNum+"'";
			Statement selFileSmt = connection.createStatement();
			ResultSet selFileRs = selFileSmt.executeQuery(query);
			while (rs.next())
			{
				pst2 = connection.prepareStatement("UPDATE client SET name = '"+editNameTxt.getText()+"', "
						+ "cpr = '"+editCprTxt.getText()+"', filenumber = '"+Long.parseLong(editFileNumberTxt.getText())+"', mctype = '"+fileCaseType.getSelectedItem().toString()+"',"
								+ " sctype = '"+caseList.getSelectedItem().toString()+"', "
								+ "aname = '"+editAccusedTxt.getText()+"', type = '"+typeList.getSelectedItem().toString()+"' "
										+ "WHERE filenumber = '"+fileNum+"'");
				while (selFileRs.next())
				{
					File doc = new File(selFileRs.getString("d_path"));
					String docName = selFileRs.getString("d_name");
					String extension = docName.substring(docName.lastIndexOf("."), docName.length());
					File newDoc = new File("files\\Client_"+Long.parseLong(editFileNumberTxt.getText())+extension);
					if (doc.exists())
					{
						if (doc.renameTo(newDoc))
							JOptionPane.showMessageDialog(null, "تم تغيير اسم الملف");
						
						pst1 = connection.prepareStatement("UPDATE document SET filenumber = '"+Long.parseLong(editFileNumberTxt.getText())+"', "
								+ "d_name = '"+"Client_"+Long.parseLong(editFileNumberTxt.getText())+extension+"', "
										+ "d_path = '"+newDoc+"' WHERE filenumber = '"+fileNum+"'");
						pst1.executeUpdate();
					}
					//End of SelFileRs loop
				}
				selFileSmt.close();
				selFileRs.close();
				pst2.executeUpdate();
				
			}
			JOptionPane.showMessageDialog(null, "تم تحديث البيانات");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				smt.close();
				rs.close();
				pst2.close();
			}
			catch (SQLException x)
			{
				x.printStackTrace();
			}
		}
	}
	
	public void DeleteDocument()
	{
		long fileNum = Long.parseLong(editFileNumTxt.getText());
		
		
		try
		{
			pst4 = connection.prepareStatement("SELECT d_path FROM document WHERE filenumber = '"+fileNum+"'");
			rs2 = pst4.executeQuery();
			
			String fileName = "";
			if (rs2.next())
			{
				fileName = rs2.getString("d_path");
				File file = new File(fileName);
				if(file.delete())
				{
					JOptionPane.showMessageDialog(null, "تم حذف الملف");
					System.out.println("File deleted!");
				}
				else
				{
					System.out.println("File not found!");
				}
			}
			
			pst3 = connection.prepareStatement("DELETE FROM document WHERE filenumber = '"+fileNum+"'");
			pst3.executeUpdate();
			
			pstCD = connection.prepareStatement("DELETE FROM client WHERE filenumber = '"+fileNum+"'");
			pstCD.executeUpdate();
			
			
			JOptionPane.showMessageDialog(null, "تم حذف البيانات");
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.toString());
		}
		finally
		{
			try
			{
				pst3.close();
				pstCD.close();
				rs2.close();
				pst4.close();
				
			}
			catch (SQLException a)
			{
				a.printStackTrace();
			}
		}
	}
	
	public void WriteLogs(String message)
	{
		File logFile = new File("logs.txt");
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatDT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatedDT = dateTime.format(formatDT);
		if (!logFile.exists())
		{
			try
			{
				
				PrintWriter printLine = new PrintWriter(logFile);
				printLine.printf("["+formatedDT+"]"+"--"+message+"\n");
				printLine.close();
			}
			catch (IOException t)
			{
				t.printStackTrace();
			}
		}
		else
		{
			try
			{
				
				Writer printLine = new BufferedWriter(new FileWriter(logFile,true));
				printLine.append("["+formatedDT+"]"+"--"+message+"\n");
				printLine.close();
			}
			catch (IOException t)
			{
				t.printStackTrace();
			}
		}
	}
	
	public void CaptureCam()
	{
		try
		{
		LocalTime now = LocalTime.now();
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("HH_mm_ss");
		String time = now.format(dtFormat);
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		File file = new File("captures\\"+time+".png");
		if (!file.exists())
			ImageIO.write(webcam.getImage(), "PNG", file);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "resource"})
	public void AddFromSheet()
	{
		String oldFileNum = "";
		String newFileNum = "";
		String editFileNum = "";
		String oldCprNum = "";
		String newCprNum = "";
		String editCprNum = "";
		long fileNum = 0;
		try
		{
			FileInputStream file = new FileInputStream(sheetAttachedPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			workbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int row = sheet.getLastRowNum();
			//JOptionPane.showMessageDialog(null, row);
			int sheetCount = 0;
			for(int i=2; i <= row; i++)
			{
				int cprNum = 0;
				oldCprNum = "";
				/*for (int j=0; j < 7; j++)
				{
					try
					{
						if (sheet.getRow(i).getCell(j).getCellTypeEnum() == CellType.NUMERIC)
						{
							String cellNum = sheet.getRow(i).getCell(j).toString();
							String newNum = cellNum.substring(0, cellNum.length() - 2);
							String editNum = "";
							for(int s=0; s < newNum.length(); s++)
							{
								if (newNum.charAt(s) == '.')
								{
									StringBuilder sb = new StringBuilder(newNum);
									sb.deleteCharAt(s);
									editNum = sb.toString();
								}
							}
							System.out.print(editNum + "\t");
						}
						else if (sheet.getRow(i).getCell(j).getCellTypeEnum() == CellType.STRING)
						{
							System.out.print(sheet.getRow(i).getCell(j) + "\t");
						}
					}
					catch(NullPointerException b)
					{
						System.out.print("\t");
					}
				}*/
				oldFileNum = sheet.getRow(i).getCell(4).toString();
				//newFileNum = oldFileNum.substring(0, oldFileNum.length() - 3);
				for (int s=0; s < oldFileNum.length(); s++)
				{
					if (oldFileNum.charAt(s) == 'E')
					{
						StringBuilder sb = new StringBuilder(oldFileNum);
						String h = sb.substring(0, oldFileNum.charAt(s));
						//newFileNum = oldFileNum.substring(0, oldFileNum.charAt(s)+1);
						//newFileNum = oldFileNum.substring(0, oldFileNum.charAt(s));
						System.out.println("Char:/t"+h+"\t"+s);
					}
				}
				editFileNum = newFileNum;
				for(int s=0; s < newFileNum.length(); s++)
				{
					if (newFileNum.charAt(s) == '.')
					{
						StringBuilder sb = new StringBuilder(newFileNum);
						sb.deleteCharAt(s);
						editFileNum = sb.toString();
					}
				}
				//fileNum = isNumeric(editFileNum) ? Long.parseLong(editFileNum) : Long.valueOf(editFileNum);
				//System.out.println(newFileNum);
				/////////////////////////////////////////////////////////
				Cell cprCell = sheet.getRow(i).getCell(3);
				if (cprCell == null || cprCell.getCellTypeEnum() == CellType.BLANK)
				{
					cprNum = 0;
					
				}
				else
				{
					oldCprNum = cprCell.toString();
					newCprNum = oldCprNum.substring(0, oldCprNum.length() - 2);
					editCprNum = "";
					for(int s=0; s < newCprNum.length(); s++)
					{
						if (newCprNum.charAt(s) == '.')
						{
							StringBuilder sb = new StringBuilder(newCprNum);
							sb.deleteCharAt(s);
							editCprNum = sb.toString();
						}
					}
					cprNum = Integer.parseInt(editCprNum);
				}
				//System.out.println(cprNum);
				//CODE BELOW TO CHECK IF FILENUMBER EXIST ALREADY IN CLIENT TABLE IN DATABASE
				String q = "SELECT * FROM client WHERE filenumber = '"+fileNum+"'";
				PreparedStatement qPt = connection.prepareStatement(q);
				ResultSet qRS = qPt.executeQuery();
				if (qRS.next())
				{
					//System.out.println(qRS.getRow() + "\tFILE NUMBER EXISTS");
					continue;
				}
				//System.out.println(fileNum);
				//CODE BELOW TO ADD FROM SHEET TO DATABASE
				/*AddRecord(sheet.getRow(i).getCell(6).toString(), sheet.getRow(i).getCell(5).toString(),
						fileNum, cprNum, sheet.getRow(i).getCell(0).toString(),
						sheet.getRow(i).getCell(2).toString(),
						sheet.getRow(i).getCell(1).toString(), null, null, null);*/
				sheetCount++;
			}
			if (sheetCount > 0)
			{
				CaptureCam();
				JOptionPane.showMessageDialog(null, "تمت إضافة البيانات");
				WriteLogs("Added data from MS Excel Sheet");
				sheetDialog.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No new data to be inserted. Action Denied!");
				sheetDialog.dispose();
			}
		}
		catch (Exception r)
		{
			r.printStackTrace();
			//JOptionPane.showMessageDialog(null, r.toString());
			sheetDialog.dispose();
		}
	}
	
	public void AddFromDir()
	{
		try
			{
			File folder = new File(attachedPath);
			File[] listOfFiles = folder.listFiles();
			int filesCount = 0;
			for (int i=0; i < listOfFiles.length; i++)
			{
				String fileName = listOfFiles[i].getName();
				String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				String fNameWithoutExt = fileName.replaceFirst("[.][^.]+$", "");
				
				long fileNum = isNumeric(fNameWithoutExt) ? Long.parseLong(fNameWithoutExt) : 0;
				
				String sql = "SELECT * FROM document WHERE filenumber = '"+fileNum+"'";
				PreparedStatement checkfNumPsd = connection.prepareStatement(sql);
				ResultSet checkfNumRs = checkfNumPsd.executeQuery();
				
				if (checkfNumRs.next() || fileNum == 0)
				{
					continue;
				}
				
				String q = "SELECT * FROM client WHERE filenumber = '"+fileNum+"'";
				PreparedStatement checkCFNumPsd = connection.prepareStatement(q);
				ResultSet checkCFNumRs = checkCFNumPsd.executeQuery();
				
				if (!checkCFNumRs.next())
				{
					continue;
				}
				
				File docFile = new File("files\\Client_"+fileName);
				
				String query = "INSERT INTO document(filenumber, d_name, d_path) VALUES(?,?,?);";
				PreparedStatement addFilesPsd = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				addFilesPsd.setLong(1, fileNum);
				addFilesPsd.setString(2, fileName);
				addFilesPsd.setString(3, docFile.toString());
				addFilesPsd.executeUpdate();
				
				if (!docFile.exists())
				{
					InputStream inStream = null;
					OutputStream outStream = null;
					File source = new File(listOfFiles[i].toString());
					File dest = new File(docFile.toString());
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
				}
				//System.out.println(listOfFiles[i] + "\n");
				filesCount++;
			}
			if (filesCount > 0)
				JOptionPane.showMessageDialog(null, "New document files has been added to records");
			else
				JOptionPane.showMessageDialog(null, "No new files to add. Request Denied!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static <T> T getValueOrDefault(T value, T defaultValue)
	{
		return value == null || value.toString().isEmpty() ? defaultValue : value;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Main(int window, int height) {
		super();
	    this.addComponentListener( new ComponentAdapter() {
	        @Override
	        public void componentShown( ComponentEvent e ) {
	        	Main.this.requestFocusInWindow();
	        }
	    });
		frame = this;
		this.setResizable(false);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		//BUILD THE FILE MENU
		fileMenu = new JMenu("Settings");
		fileMenu.setForeground(Color.WHITE);
		importMenu = new JMenu("Import");
		importMenu.setForeground(Color.WHITE);
		checkDBMenu  = new JMenuItem("Check Database Connection");
		checkDBMenu.addActionListener(this);
		updateDBMenu = new JMenuItem("Backup Database");
		updateDBMenu.addActionListener(this);
		addSheet = new JMenuItem("Import Data From MS Excel Sheet");
		addSheet.addActionListener(this);
		addFile = new JMenuItem("Import Reference File");
		addFile.addActionListener(this);
		checkFileNum = new JMenuItem("Check File Number");
		checkFileNum.addActionListener(this);
		logsMenu = new JMenuItem("Logs");
		logsMenu.addActionListener(this);
		fileMenu.add(checkDBMenu);
		fileMenu.add(updateDBMenu);
		fileMenu.add(checkFileNum);
		fileMenu.add(logsMenu);
		importMenu.add(addSheet);
		importMenu.add(addFile);
		
		menuBar.add(fileMenu);
		menuBar.add(importMenu);
		frame.setJMenuBar(menuBar);

		homePanel = new JPanel();
		addPanel = new JPanel();
		editPanel = new JPanel();
		felonPanel = new JPanel();
		civilPanel = new JPanel();
		conservativePanel = new JPanel();
		laborPanel = new JPanel();
		distorPanel = new JPanel();
		tamyeezPanel = new JPanel();
		studiesPanel = new JPanel();
		contPanel = new JPanel();
		conMenuPanel = new JPanel();
		contSearchPanel = new JPanel();

		addPageBtn = new JButton();
		searchPageBtn = new JButton();
		editPageBtn = new JButton();
		felonPageBtn = new JButton();
		civilPageBtn = new JButton();
		conservativePageBtn = new JButton();
		laborPageBtn = new JButton();
		backBtn = new JButton();
		addContPageBtn = new JButton();
		addContBtn = new JButton();

		addPageBtn.addActionListener(this);
		searchPageBtn.addActionListener(this);
		editPageBtn.addActionListener(this);
		felonPageBtn.addActionListener(this);
		civilPageBtn.addActionListener(this);
		conservativePageBtn.addActionListener(this);
		laborPageBtn.addActionListener(this);
		backBtn.addActionListener(this);
		addContPageBtn.addActionListener(this);
		addContBtn.addActionListener(this);
		
		///////////////////////////////IMPORT SHEET JDIALOG
		sheetDialog.setSize(new Dimension(400,300));
		sheetDialog.setResizable(false);
		sheetDialog.setLocationRelativeTo(null);
		sheetDialog.setLayout(null);
		sheetDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addSheetBtn = new JButton("Import");
		addSheetBtn.setBounds(120, 200, 150, 50);
		addSheetBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		addSheetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent w)
			{
				AddFromSheet();
			}
		});
		sheetDialog.add(addSheetBtn);
		addSheetLbl = new JLabel();
		addSheetLbl.setBounds(120, 100, 150, 40);
		addSheetLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		sheetDialog.add(addSheetLbl);
		/////////////////////////////IMPORT SHEET JDIALOG
		
		/////////////////////////////IMPORT REFERENCE FILE JDIALOG
		addFileDialog.setSize(new Dimension(400,300));
		addFileDialog.setResizable(false);
		addFileDialog.setLocationRelativeTo(null);
		addFileDialog.setLayout(null);
		addFileDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel addFileTitle = new JLabel("Select a directory:");
		addFileTitle.setBounds(15, 10, 380, 50);
		addFileTitle.setFont(new Font("Arial", Font.BOLD, 20));
		addFileDialog.add(addFileTitle);
		JButton fileImportBtn = new JButton("Import");
		fileImportBtn.setBounds(120, 200, 150, 50);
		fileImportBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		fileImportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent w)
			{
				AddFromDir();
			}
		});
		addFileDialog.add(fileImportBtn);
		addFileLbl = new JLabel();
		addFileLbl.setBounds(120, 100, 150, 40);
		addFileLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		addFileDialog.add(addFileLbl);
		/////////////////////////////IMPORT REFERENCE FILE JDIALOG

		headImg = new JLabel();
		credits = new JLabel("Powered by NineNine Soft Tech"+copyright);

		/////// THIS IS THE MAIN PANEL THAT CONTAINS ALL SUB PANELS/ CARDS
		mainPanel.setBounds(0, 0, 800, 600);
		mainPanel.add(homePanel, "homePage");
		mainPanel.add(addPanel, "addPage");
		mainPanel.add(editPanel, "editPage");
		mainPanel.add(felonPanel, "felonPage");
		mainPanel.add(civilPanel, "civilPage");
		mainPanel.add(conservativePanel, "conservativePage");
		mainPanel.add(laborPanel, "laborPage");
		mainPanel.add(distorPanel, "distorPage");
		mainPanel.add(tamyeezPanel, "tamyeezPage");
		mainPanel.add(studiesPanel, "studiesPage");
		mainPanel.add(conMenuPanel, "contractsPage");
		mainPanel.add(contPanel, "contractsAddPage");
		mainPanel.add(contSearchPanel, "contractsSearchPage");

		getContentPane().add(mainPanel);
		
		//BACK BUTTON SETUP
		backBtn.setBounds(600, 50, 100, 50);
		backBtn.setText("رجوع");
		backBtn.setFont(new Font("Arial", Font.BOLD, 24));
		backBtn.setBorder(new RoundedBorder(20));
		backBtn.setBackground(new Color(173,177,178));
		backBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					repaint();
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		//BACK BUTTON SETUP

		HomePage();
	}
	//END OF MAIN
	
	//START OF HOME PAGE
	public void HomePage() {
		current = 1;
		homePanel.setLayout(null);
		homePanel.setBounds(0, 0, 800, 600);
		searchPageBtn.setBounds(300, 350, 150, 50);
		searchPageBtn.setText("بحث");
		searchPageBtn.setFont(new Font("Arial", Font.BOLD, 24));
		searchPageBtn.setBorder(new RoundedBorder(20));
		searchPageBtn.setBackground(new Color(142,221,249));
		/*searchPageBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered (MouseEvent e)
			{
				searchPageBtn.setBackground(new Color(104,164,186));
				searchPageBtn.setForeground(Color.BLACK);
			}
			public void mouseExited (MouseEvent e)
			{
				searchPageBtn.setBackground(new Color(142,221,249));
				searchPageBtn.setForeground(Color.BLACK);
			}
		});*/
		searchPageBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					repaint();
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		homePanel.add(searchPageBtn);
		addPageBtn.setBounds(500, 350, 150, 50);
		addPageBtn.setText("إضافة");
		addPageBtn.setFont(new Font("Arial", Font.BOLD, 24));
		addPageBtn.setBorder(new RoundedBorder(20));
		addPageBtn.setBackground(new Color(142,221,249));
		addPageBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		homePanel.add(addPageBtn);
		addContPageBtn.setBounds(500, 425, 150, 50);
		addContPageBtn.setText("العقود");
		addContPageBtn.setFont(new Font("Arial", Font.BOLD, 24));
		addContPageBtn.setBorder(new RoundedBorder(20));
		addContPageBtn.setBackground(new Color(255, 71, 71));
		addContPageBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		homePanel.add(addContPageBtn);
		editPageBtn.setBounds(100, 350, 150, 50);
		editPageBtn.setText("تعديل");
		editPageBtn.setFont(new Font("Arial", Font.BOLD, 24));
		editPageBtn.setBorder(new RoundedBorder(20));
		editPageBtn.setBackground(new Color(142,221,249));
		editPageBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		homePanel.add(editPageBtn);
		Image newImg = img.getScaledInstance(230, 208, java.awt.Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(newImg);
		headImg.setIcon(imgIcon);
		headImg.setBounds(250, 100, 250, 250);
		homePanel.add(headImg);
		credits.setBounds(250, 500, 340, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		homePanel.add(credits);
	}
	//END OF HOME PAGE
	
	//START OF ADD
	public void AddPage() {
		current = 2;
		addPanel.setLayout(null);
		addPanel.setBounds(0, 0, 800, 600);
		felonPageBtn.setBounds(50, 300, 150, 50);
		felonPageBtn.setText("جنائي");
		felonPageBtn.setFont(new Font("Arial", Font.BOLD, 24));
		felonPageBtn.setBorder(new RoundedBorder(20));
		felonPageBtn.setBackground(new Color(173,177,178));
		felonPageBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		addPanel.add(felonPageBtn);
		civilPageBtn.setBounds(230, 300, 150, 50);
		civilPageBtn.setText("مدني");
		civilPageBtn.setFont(new Font("Arial", Font.BOLD, 24));
		civilPageBtn.setBorder(new RoundedBorder(20));
		civilPageBtn.setBackground(new Color(173,177,178));
		civilPageBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		addPanel.add(civilPageBtn);
		conservativePageBtn.setBounds(410, 300, 150, 50);
		conservativePageBtn.setText("شرعي");
		conservativePageBtn.setFont(new Font("Arial", Font.BOLD, 24));
		conservativePageBtn.setBorder(new RoundedBorder(20));
		conservativePageBtn.setBackground(new Color(173,177,178));
		conservativePageBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		addPanel.add(conservativePageBtn);
		laborPageBtn.setBounds(590, 300, 150, 50);
		laborPageBtn.setText("عمالي");
		laborPageBtn.setFont(new Font("Arial", Font.BOLD, 24));
		laborPageBtn.setBorder(new RoundedBorder(20));
		laborPageBtn.setBackground(new Color(173,177,178));
		laborPageBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		addPanel.add(laborPageBtn);
		JButton distorRuleBtn = new JButton("أحكام دستورية");
		distorRuleBtn.setBounds(410, 400, 150, 50);
		distorRuleBtn.setFont(new Font("Arial", Font.BOLD, 22));
		distorRuleBtn.setBorder(new RoundedBorder(20));
		distorRuleBtn.setBackground(new Color(0,183,255));
		distorRuleBtn.setForeground(Color.WHITE);
		distorRuleBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		distorRuleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				mainLayout.show(mainPanel, "distorPage");
				DistorPage();
			}
		});
		addPanel.add(distorRuleBtn);
		JButton tamyeezRuleBtn = new JButton("أحكام تمييز");
		tamyeezRuleBtn.setBounds(590, 400, 150, 50);
		tamyeezRuleBtn.setFont(new Font("Arial", Font.BOLD, 22));
		tamyeezRuleBtn.setBorder(new RoundedBorder(20));
		tamyeezRuleBtn.setBackground(new Color(0,183,255));
		tamyeezRuleBtn.setForeground(Color.WHITE);
		tamyeezRuleBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		tamyeezRuleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				mainLayout.show(mainPanel, "tamyeezPage");
				TamyeezPage();
			}
		});
		addPanel.add(tamyeezRuleBtn);
		JButton studiesBtn = new JButton("دراسات");
		studiesBtn.setBounds(50, 400, 150, 50);
		studiesBtn.setFont(new Font("Arial", Font.BOLD, 22));
		studiesBtn.setBorder(new RoundedBorder(20));
		studiesBtn.setBackground(new Color(255,71,71));
		studiesBtn.setForeground(Color.WHITE);
		studiesBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		studiesBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainLayout.show(mainPanel, "studiesPage");
				StudiesPage();
			}
				});
		addPanel.add(studiesBtn);
		headImg.setBounds(250, 50, 250, 250);
		addPanel.add(headImg);
		addPanel.add(backBtn);
		/*JButton testBtn = new JButton("Test");  //I kept this for testing purposes
		testBtn.setBounds(250, 400, 100, 50);
		testBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent z)
			{
				//Do Nothing Here
			}
		});
		addPanel.add(testBtn);*/
		credits.setBounds(250, 500, 340, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		addPanel.add(credits);
	}
	//END OF ADD PAGE
	
	//START OF EDIT PAGE
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void EditPage()
	{
		current = 3;
		editPanel.setLayout(null);
		editPanel.setBounds(0, 0, 800, 600);
		editPanel.revalidate();
		editPanel.repaint();
		editPanel.add(backBtn);
		editField = new JPanel();
		editField.setLayout(null);
		editField.setBounds(0, 160, 800, 350);
		editField.setBorder(new LineBorder(Color.BLACK, 1));
		editPanel.add(editField);
		JLabel fileNumLbl = new JLabel("رقم الدعوة");
		fileNumLbl.setBounds(450,100,150,50);
		fileNumLbl.setFont(new Font("Arial", Font.PLAIN, 20));
		editPanel.add(fileNumLbl);
		editFileNumTxt = new JTextField();
		editFileNumTxt.setBounds(270, 110, 150, 33);
		editFileNumTxt.setColumns(10);
		if (!editFileNumTxt.getText().equals(null))
			editFileNumTxt.setText(null);
		editFileNumTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					DisplayRecord();
					if (editItemCount > 0)
					{
						editField.setVisible(true);
					}
				}
			}
		});
		editPanel.add(editFileNumTxt);
		JButton searchBtn = new JButton("ابحث");
		searchBtn.setBounds(180, 110, 75, 33);
		searchBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DisplayRecord();
				if (editItemCount > 0)
				{
					editField.setVisible(true);
				}
			}
		});
		editPanel.add(searchBtn);
		//START OF EDIT FIELD
		JLabel nameLbl = new JLabel("اسم الموكل");
		nameLbl.setBounds(600, 10, 150, 50);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 17));
		editField.add(nameLbl);
		editNameTxt = new JTextField();
		editNameTxt.setBounds(430, 15, 150, 33);
		editNameTxt.setColumns(10);
		editNameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		editNameTxt.setText("");
		editField.add(editNameTxt);
		JLabel cprLbl = new JLabel("الرقم الشخصي للموكل");
		cprLbl.setBounds(270, 10, 150, 50);
		cprLbl.setFont(new Font("Arial", Font.BOLD, 17));
		editField.add(cprLbl);
		editCprTxt = new JTextField();
		editCprTxt.setBounds(95, 15, 150, 33);
		editCprTxt.setColumns(10);
		editCprTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		editCprTxt.setText("");
		editField.add(editCprTxt);
		JLabel fileNumberLbl = new JLabel("رقم الدعوة");
		fileNumberLbl.setBounds(600, 80, 150, 50);
		fileNumberLbl.setFont(new Font("Arial", Font.BOLD, 17));
		editField.add(fileNumberLbl);
		editFileNumberTxt = new JTextField();
		editFileNumberTxt.setBounds(430, 85, 150, 33);
		editFileNumberTxt.setColumns(10);
		editFileNumberTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		editFileNumberTxt.setText("");
		editField.add(editFileNumberTxt);
		JLabel accusedLbl = new JLabel("اسم الخصم");
		accusedLbl.setBounds(270, 80, 150, 50);
		accusedLbl.setFont(new Font("Arial", Font.BOLD, 17));
		editField.add(accusedLbl);
		editAccusedTxt = new JTextField();
		editAccusedTxt.setBounds(95, 85, 150, 33);
		editAccusedTxt.setColumns(10);
		editAccusedTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		editAccusedTxt.setText("");
		editField.add(editAccusedTxt);
		JLabel fileLbl = new JLabel("نوع الدعوة");
		fileLbl.setBounds(600, 150, 150, 50);
		fileLbl.setFont(new Font("Arial", Font.BOLD, 17));
		editField.add(fileLbl);
		fileCaseType = new JComboBox();
		caseList = new JComboBox();
		JLabel caseLbl = new JLabel();
		fileCaseType.setBounds(430, 155, 150, 33);
		fileCaseType.setModel(new DefaultComboBoxModel(new String[] {"", "جنائي", "مدني", "شرعي", "عمالي", "تحكيم"}));
		fileCaseType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent t)
			{
				//int state = t.getStateChange();
				if (t.getItem().toString() == "جنائي")
				{
					caseLbl.setText("نوع القضية");
					caseList.setModel(new DefaultComboBoxModel(new String[] {"", "القتل", "المخدرات", "اعتداء", "السرقة", "القذف", "اختلاس", "غسيل أموال", "أخرى"}));
					caseList.setVisible(true);
				}
				else if (t.getItem().toString() == "مدني")
				{
					caseLbl.setText("نوع القضية");
					caseList.setModel(new DefaultComboBoxModel(new String[] {"", "إيجار", "تعويض", "مطالبات مالية", "إفلاس", "تحكيم", "أخرى"}));
					caseList.setVisible(true);
				}
				else if (t.getItem().toString() == "شرعي")
				{
					caseLbl.setText("نوع القضية");
					caseList.setModel(new DefaultComboBoxModel (new String[] {"نوع الدعوى", "طلاق", "نــفــقــة", "حضانة", "أخرى"}));
					caseList.setVisible(true);
				}
				else if (t.getItem().toString() == "عمالي")
				{
					caseLbl.setText("نوع القضية");
					caseList.setModel(new DefaultComboBoxModel(new String[] {"", "تعويض", "مستحقات", "إعادة إلى الخدمة", "وقف قرار الفصل", "أخرى"}));
					caseList.setVisible(true);
				}
				else if (t.getItem().toString() == "تحكيم")
				{
					caseLbl.setText("نوع القضية");
					caseList.setModel(new DefaultComboBoxModel(new String[] {"", "أخرى"}));
					caseList.setVisible(true);
				}
				else if (t.getItem().toString() == "نوع الدعوى")
				{
					caseLbl.setText("");
					caseList.setVisible(false);
				}
			}
		});
		editField.add(fileCaseType);
		///////////////////////
		caseLbl.setBounds(270, 150, 150, 50);
		caseLbl.setFont(new Font("Arial", Font.BOLD, 17));
		editField.add(caseLbl);
		///////////////////////
		caseList.setBounds(95, 155, 150, 33);
		editField.add(caseList);
		JLabel typeLbl = new JLabel("الصفة");
		typeLbl.setBounds(600, 220, 150, 50);
		typeLbl.setFont(new Font("Arial", Font.BOLD, 17));
		editField.add(typeLbl);
		typeList = new JComboBox();
		typeList.setBounds(430, 225, 150, 33);
		editField.add(typeList);
		JButton updateBtn = new JButton("تحديث");
		updateBtn.setBounds(400, 305, 100, 40);
		updateBtn.setFont(new Font("Arial", Font.BOLD, 18));
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				UpdateRecord();
				WriteLogs("A record with filenumber: "+editFileNumberTxt.getText()+", has been updated!");
				editItemCount = 0;
				editFileNumTxt.setText(null);
				editNameTxt.setText(null);
				editCprTxt.setText(null);
				editFileNumberTxt.setText(null);
				editAccusedTxt.setText(null);
				fileCaseType.setSelectedIndex(0);
				caseList.setSelectedIndex(0);
				typeList.setSelectedIndex(0);
				editField.setVisible(false);
			}
		});
		editField.add(updateBtn);
		JButton deleteBtn = new JButton("حذف");
		deleteBtn.setBounds(250, 305, 100, 40);
		deleteBtn.setFont(new Font("Arial", Font.BOLD, 18));
		deleteBtn.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e)
			{
				if (editItemCount >=1)
				{
					int input = JOptionPane.showConfirmDialog(null, "هل أنت متأكد؟");
					if (input == 0)
					{
						DeleteDocument();
						WriteLogs("A record with filenumber: "+editFileNumberTxt.getText()+", has been deleted!");
						editItemCount = 0;
						editFileNumTxt.setText(null);
						editNameTxt.setText(null);
						editCprTxt.setText(null);
						editFileNumberTxt.setText(null);
						editAccusedTxt.setText(null);
						fileCaseType.setSelectedIndex(0);
						caseList.setSelectedIndex(0);
						typeList.setSelectedIndex(0);
						editField.setVisible(false);
					}
					else
					{
						return;
					}
				}
			}
		});
		editField.add(deleteBtn);
		editField.setVisible(false);
		//EDIT OF EDIT FIELD
		credits.setBounds(250, 500, 340, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		editPanel.add(credits);
	}
	//END OF EDIT PAGE
	
	//START OF FELON PAGE
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void FelonPage()
	{
		current = 4;
		felonPanel.setLayout(null);
		felonPanel.setBounds(0, 0, 800, 600);
		JLabel title = new JLabel("جنائي");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(313, 30, 175, 62);
		felonPanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		felonPanel.add(validateInput);
		felonPanel.add(backBtn);
		JLabel nameLbl = new JLabel("اسم الموكل");
		nameLbl.setBounds(680, 205, 150, 33);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		felonPanel.add(nameLbl);
		JLabel fileNumLbl = new JLabel("رقم الدعوى");
		fileNumLbl.setBounds(680, 255, 150, 33);
		fileNumLbl.setFont(new Font("Arial", Font.BOLD, 20));
		felonPanel.add(fileNumLbl);
		JLabel accusedLbl = new JLabel("اسم الخصم");
		accusedLbl.setBounds(270, 205, 150, 33);
		accusedLbl.setFont(new Font("Arial", Font.BOLD, 20));
		felonPanel.add(accusedLbl);
		JLabel cprLbl = new JLabel("الرقم الشخصي");
		cprLbl.setBounds(270, 255, 150, 33);
		cprLbl.setFont(new Font("Arial", Font.BOLD, 20));
		felonPanel.add(cprLbl);
		felonNameTxt = new JTextField();
		felonNameTxt.setColumns(10);
		felonNameTxt.setBounds(460, 200, 200, 33);
		felonNameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		felonNameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		felonNameTxt.setBorder(new LineBorder (Color.BLACK, 2));
		felonPanel.add(felonNameTxt);
		felonAccusedNameTxt = new JTextField();
		felonAccusedNameTxt.setColumns(10);
		felonAccusedNameTxt.setBounds(50, 200, 200, 33);
		felonAccusedNameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		felonAccusedNameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		felonAccusedNameTxt.setBorder(new LineBorder(Color.BLACK, 2));
		felonAccusedNameTxt.revalidate();
		felonPanel.add(felonAccusedNameTxt);
		felonFileNumTxt = new JTextField();
		felonFileNumTxt.setColumns(10);
		felonFileNumTxt.setBounds(460, 250, 200, 33);
		felonFileNumTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		felonFileNumTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		felonFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
		felonPanel.add(felonFileNumTxt);
		felonCprTxt = new JTextField();
		felonCprTxt.setColumns(10);
		felonCprTxt.setBounds(50, 250, 200, 33);
		felonCprTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		felonCprTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		felonCprTxt.setBorder(new LineBorder(Color.BLACK, 2));
		felonPanel.add(felonCprTxt);
		felonCaseType = new JComboBox();
		felonCaseType.setModel(new DefaultComboBoxModel (new String[] {"نوع الدعوى", "القتل", "المخدرات", "اعتداء", "السرقة", "القذف", "اختلاس", "غسيل أموال", "أخرى"}));
		felonCaseType.setBounds(460, 300, 200, 33);
		felonCaseType.setFont(new Font("Arial", Font.PLAIN, 18));
		felonCaseType.setBorder(new LineBorder(Color.BLACK, 1));
		felonPanel.add(felonCaseType);
		felonTypeList = new JComboBox();
		felonTypeList.setModel(new DefaultComboBoxModel (new String[] {"الصفة", "المدّعي", "المدّعي عليه", "المستأنف", "المستأنف عليه", "الطاعن", "المطعون ضده", "متهم"}));
		felonTypeList.setBounds(50, 300, 200, 33);
		felonTypeList.setFont(new Font("Arial", Font.PLAIN, 18));
		felonTypeList.setBorder(new LineBorder(Color.BLACK, 1));
		felonPanel.add(felonTypeList);
		JLabel fileAttached = new JLabel("");
		fileAttached.setBounds(85, 370, 210, 50);
		fileAttached.setFont(new Font("Arial", Font.PLAIN, 18));
		fileAttached.setHorizontalAlignment(SwingConstants.CENTER);
		//fileAttached.setBorder(new LineBorder(Color.BLACK, 1));
		felonPanel.add(fileAttached);
		felonBrowseBtn = new JButton();
		felonBrowseBtn.setBounds(300, 370, 150, 50);
		felonBrowseBtn.setText("إرفاق ملف");
		felonBrowseBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		felonBrowseBtn.setBorder(new RoundedBorder(20));
		felonBrowseBtn.setBackground(new Color(173,177,178));
		felonBrowseBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		felonBrowseBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed (ActionEvent e)
			{
				felonFileChooser = new JFileChooser(new File("F:\\Documents Archive"));  //PATH HERE DEPENDS ON THE EXISTANCE OF THAT DIRECTORY
				felonFileChooser.setFileSelectionMode(felonFileChooser.FILES_ONLY);
				felonFileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose PDF, JPEG, JPG or PNG", "jpeg", "jpg", "pdf", "png");
				felonFileChooser.setFileFilter(filter);
				int rVal = felonFileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION)
				{
					felonSelectedSourceFile = felonFileChooser.getSelectedFile();
					felonAttachedPath = felonSelectedSourceFile.toString();
					felonAttachedName = felonSelectedSourceFile.getName();
					fileAttached.setText(felonAttachedName);
					felonFilePath = felonSelectedSourceFile.getAbsolutePath();
				}
			}
		});
		felonPanel.add(felonBrowseBtn);
		felonAddBtn = new JButton();
		felonAddBtn.setBounds(300, 440, 150, 50);
		felonAddBtn.setText("إضافة");
		felonAddBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		felonAddBtn.setBorder(new RoundedBorder(20));
		felonAddBtn.setBackground(new Color(173,177,178));
		felonAddBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		felonAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				if ((!felonFileNumTxt.getText().isEmpty() || !felonFileNumTxt.getText().equals(fileNumLbl.getText())) && felonAttachedName != "")
				{
					String faName = "";
					String fType = "";
					String cName = "";
					String cCase = "";
					int cCpr = 0;
					
					if (felonNameTxt.getText().isEmpty())
					{
						cName = "غير متوفر";
					}
					else
					{
						cName = felonNameTxt.getText();
					}
					
					if (felonCprTxt.getText().isEmpty())
					{
						cCpr = 0;
					}
					else
					{
						cCpr = Integer.parseInt(felonCprTxt.getText());
					}
					
					if (felonAccusedNameTxt.getText().isEmpty())
					{
						faName = "غير متوفر";
					}
					else
					{
						faName = felonAccusedNameTxt.getText();
					}
					
					if (felonCaseType.getSelectedIndex() == 0)
					{
						cCase = "غير متوفر";
					}
					else
					{
						cCase = felonCaseType.getSelectedItem().toString();
					}
					
					if (felonTypeList.getSelectedIndex() != 0)
					{
						fType = felonTypeList.getSelectedItem().toString();
					}
					else
					{
						fType = "غير متوفر";
					}
					
					String extension = felonAttachedName.substring(felonAttachedName.lastIndexOf("."), felonAttachedName.length());
					String fileName = "Client_" + felonFileNumTxt.getText() + extension;
					try
					{
						InputStream inStream = null;
						OutputStream outStream = null;
						File source = new File(felonFilePath);
						File dest = new File("files\\", fileName);
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
	                    
	                    //JOptionPane.showMessageDialog(null, "تم نسخ الملف المرفق");
					}
					catch (IOException t)
					{
						t.printStackTrace();
					}
					 
					AddRecord(cName, faName, Long.parseLong(felonFileNumTxt.getText()), cCpr, "جنائي", 
							cCase, fType, fileName, "files\\" + fileName, null);
					JOptionPane.showMessageDialog(null, "تمت إضافة البيانات");
					CaptureCam();
					felonFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
					felonNameTxt.setText("");
					felonAccusedNameTxt.setText("");
					felonFileNumTxt.setText("");
					felonCprTxt.setText("");
					felonCaseType.setSelectedIndex(0);
					felonTypeList.setSelectedIndex(0);
					fileAttached.setText("");
					validateInput.setText("");
				}
				else
				{
					felonFileNumTxt.setBorder(new LineBorder(Color.RED, 2));
					felonNameTxt.setText("");
					felonAccusedNameTxt.setText("");
					felonFileNumTxt.setText("");
					felonCprTxt.setText("");
					felonCaseType.setSelectedIndex(0);
					felonTypeList.setSelectedIndex(0);
					validateInput.setText("الرجاء إدخال رقم ملف/إرفاق ملف");
				}
				felonFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
			}
		});
		felonPanel.add(felonAddBtn);
		credits.setBounds(250, 500, 340, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		felonPanel.add(credits);
	}
	//END OF FELON PAGE
	
	//START OF CIVIL
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void CivilPage()
	{
		current = 5;
		civilPanel.setLayout(null);
		JLabel title = new JLabel("مدني");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(313, 30, 175, 62);
		civilPanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		validateInput.setText("");
		civilPanel.add(validateInput);
		civilPanel.add(backBtn);
		JLabel nameLbl = new JLabel("اسم الموكل");
		nameLbl.setBounds(680, 205, 150, 33);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		civilPanel.add(nameLbl);
		JLabel fileNumLbl = new JLabel("رقم الدعوى");
		fileNumLbl.setBounds(680, 255, 150, 33);
		fileNumLbl.setFont(new Font("Arial", Font.BOLD, 20));
		civilPanel.add(fileNumLbl);
		JLabel accusedLbl = new JLabel("اسم الخصم");
		accusedLbl.setBounds(270, 205, 150, 33);
		accusedLbl.setFont(new Font("Arial", Font.BOLD, 20));
		civilPanel.add(accusedLbl);
		JLabel cprLbl = new JLabel("الرقم الشخصي");
		cprLbl.setBounds(270, 255, 150, 33);
		cprLbl.setFont(new Font("Arial", Font.BOLD, 20));
		civilPanel.add(cprLbl);
		civilNameTxt = new JTextField();
		civilNameTxt.setColumns(10);
		civilNameTxt.setBounds(460, 200, 200, 33);
		civilNameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		civilNameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		civilNameTxt.setBorder(new LineBorder (Color.BLACK, 2));
		civilPanel.add(civilNameTxt);
		civilAccusedNameTxt = new JTextField();
		civilAccusedNameTxt.setColumns(10);
		civilAccusedNameTxt.setBounds(50, 200, 200, 33);
		civilAccusedNameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		civilAccusedNameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		civilAccusedNameTxt.setBorder(new LineBorder(Color.BLACK, 2));
		civilPanel.add(civilAccusedNameTxt);
		civilFileNumTxt = new JTextField();
		civilFileNumTxt.setColumns(10);
		civilFileNumTxt.setBounds(460, 250, 200, 33);
		civilFileNumTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		civilFileNumTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		civilFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
		civilPanel.add(civilFileNumTxt);
		civilCprTxt = new JTextField();
		civilCprTxt.setColumns(10);
		civilCprTxt.setBounds(50, 250, 200, 33);
		civilCprTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		civilCprTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		civilCprTxt.setBorder(new LineBorder(Color.BLACK, 2));
		civilPanel.add(civilCprTxt);
		civilCaseType = new JComboBox();
		civilCaseType.setModel(new DefaultComboBoxModel (new String[] {"نوع الدعوى", "إيجار", "تعويض", "مطالبات مالية", "إفلاس", "تحكيم", "أخرى"}));
		civilCaseType.setBounds(460, 300, 200, 33);
		civilCaseType.setFont(new Font("Arial", Font.PLAIN, 18));
		civilCaseType.setBorder(new LineBorder(Color.BLACK, 1));
		civilPanel.add(civilCaseType);
		civilTypeList = new JComboBox();
		civilTypeList.setModel(new DefaultComboBoxModel (new String[] {"الصفة", "المدّعي", "المدّعي عليه", "المستأنف", "المستأنف عليه", "الطاعن", "المطعون ضده", "المطلوب  ضده","الطالب"}));
		civilTypeList.setBounds(50, 300, 200, 33);
		civilTypeList.setFont(new Font("Arial", Font.PLAIN, 18));
		civilTypeList.setBorder(new LineBorder(Color.BLACK, 1));
		civilPanel.add(civilTypeList);
		JLabel fileAttached = new JLabel("");
		fileAttached.setBounds(85, 370, 210, 50);
		fileAttached.setFont(new Font("Arial", Font.PLAIN, 18));
		fileAttached.setHorizontalAlignment(SwingConstants.CENTER);
		//fileAttached.setBorder(new LineBorder(Color.BLACK, 1));
		civilPanel.add(fileAttached);
		civilBrowseBtn = new JButton();
		civilBrowseBtn.setBounds(300, 370, 150, 50);
		civilBrowseBtn.setText("إرفاق ملف");
		civilBrowseBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		civilBrowseBtn.setBorder(new RoundedBorder(20));
		civilBrowseBtn.setBackground(new Color(173,177,178));
		civilBrowseBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		civilBrowseBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed (ActionEvent e)
			{
				civilFileChooser = new JFileChooser(new File("F:\\Documents Archive"));  //PATH HERE DEPENDS ON THE EXISTANCE OF THAT DIRECTORY
				civilFileChooser.setFileSelectionMode(civilFileChooser.FILES_ONLY);
				civilFileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose PDF, JPEG, JPG or PNG", "jpeg", "jpg", "pdf", "png");
				civilFileChooser.setFileFilter(filter);
				int rVal = civilFileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION)
				{
					civilSelectedSourceFile = civilFileChooser.getSelectedFile();
					civilAttachedPath = civilSelectedSourceFile.toString();
					civilAttachedName = civilSelectedSourceFile.getName();
					fileAttached.setText(civilAttachedName);
					civilFilePath = civilSelectedSourceFile.getAbsolutePath();
				}
			}
		});
		civilPanel.add(civilBrowseBtn);
		civilAddBtn = new JButton();
		civilAddBtn.setBounds(300, 440, 150, 50);
		civilAddBtn.setText("إضافة");
		civilAddBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		civilAddBtn.setBorder(new RoundedBorder(20));
		civilAddBtn.setBackground(new Color(173,177,178));
		civilAddBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		civilAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				if ((!civilFileNumTxt.getText().isEmpty() || !civilFileNumTxt.getText().equals(fileNumLbl.getText())) && civilAttachedName != "")
				{
					String extension = civilAttachedName.substring(civilAttachedName.lastIndexOf("."), civilAttachedName.length());
					String fileName = "Client_" + civilFileNumTxt.getText() + extension;
					
					String faName = "";
					String fType = "";
					String cName = "";
					String cCase = "";
					int cCpr = 0;
					
					if (civilNameTxt.getText().isEmpty())
					{
						cName = "غير متوفر";
					}
					else
					{
						cName = civilNameTxt.getText();
					}
					
					if (civilCprTxt.getText().isEmpty())
					{
						cCpr = 0;
					}
					else
					{
						cCpr = Integer.parseInt(civilCprTxt.getText());
					}
					
					if (civilCaseType.getSelectedIndex() == 0)
					{
						cCase = "غير متوفر";
					}
					else
					{
						cCase = civilCaseType.getSelectedItem().toString();
					}
					
					if (civilAccusedNameTxt.getText().isEmpty())
					{
						faName = "غير متوفر";
					}
					else
					{
						faName = civilAccusedNameTxt.getText();
					}
					
					if (civilTypeList.getSelectedIndex() != 0)
					{
						fType = civilTypeList.getSelectedItem().toString();
					}
					else
					{
						fType = "غير متوفر";
					}
					
					try
					{
						InputStream inStream = null;
						OutputStream outStream = null;
						File source = new File(civilFilePath);
						File dest = new File("files\\", fileName);
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
	                    
	                    //JOptionPane.showMessageDialog(null, "تم نسخ الملف المرفق");
					}
					catch (IOException t)
					{
						t.printStackTrace();
					}
					 //Changed Int to Long in the FileNum as requires more
					AddRecord(cName, faName, Long.parseLong(civilFileNumTxt.getText()), cCpr, "مدني", 
							cCase, fType, fileName, "files\\" + fileName, null);
					JOptionPane.showMessageDialog(null, "تمت إضافة البيانات");
					CaptureCam();
					civilFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
					civilNameTxt.setText("");
					civilAccusedNameTxt.setText("");
					civilFileNumTxt.setText("");
					civilCprTxt.setText("");
					civilCaseType.setSelectedIndex(0);
					civilTypeList.setSelectedIndex(0);
					fileAttached.setText("");
					validateInput.setText("");
				}
				else
				{
					civilFileNumTxt.setBorder(new LineBorder(Color.RED, 2));
					civilNameTxt.setText("");
					civilAccusedNameTxt.setText("");
					civilFileNumTxt.setText("");
					civilCprTxt.setText("");
					civilCaseType.setSelectedIndex(0);
					civilTypeList.setSelectedIndex(0);
					validateInput.setText("الرجاء إدخال رقم ملف/إرفاق ملف");
				}
				civilFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
			}
		});
		civilPanel.add(civilAddBtn);
		credits.setBounds(250, 500, 340, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		civilPanel.add(credits);
	}
	//END OF CIVIL PAGE
	
	//START OF CONSERVATIVE	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void ConservativePage()
	{
		current = 6;
		conservativePanel.setLayout(null);
		JLabel title = new JLabel("شرعي");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(313, 30, 175, 62);
		conservativePanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		validateInput.setText("");
		conservativePanel.add(validateInput);
		conservativePanel.add(backBtn);
		JLabel nameLbl = new JLabel("اسم الموكل");
		nameLbl.setBounds(680, 205, 150, 33);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		conservativePanel.add(nameLbl);
		JLabel fileNumLbl = new JLabel("رقم الدعوى");
		fileNumLbl.setBounds(680, 255, 150, 33);
		fileNumLbl.setFont(new Font("Arial", Font.BOLD, 20));
		conservativePanel.add(fileNumLbl);
		JLabel accusedLbl = new JLabel("اسم الخصم");
		accusedLbl.setBounds(270, 205, 150, 33);
		accusedLbl.setFont(new Font("Arial", Font.BOLD, 20));
		conservativePanel.add(accusedLbl);
		JLabel cprLbl = new JLabel("الرقم الشخصي");
		cprLbl.setBounds(270, 255, 150, 33);
		cprLbl.setFont(new Font("Arial", Font.BOLD, 20));
		conservativePanel.add(cprLbl);
		conservativeNameTxt = new JTextField();
		conservativeNameTxt.setColumns(10);
		conservativeNameTxt.setBounds(460, 200, 200, 33);
		conservativeNameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		conservativeNameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		conservativeNameTxt.setBorder(new LineBorder (Color.BLACK, 2));
		conservativePanel.add(conservativeNameTxt);
		conservativeAccusedNameTxt = new JTextField();
		conservativeAccusedNameTxt.setColumns(10);
		conservativeAccusedNameTxt.setBounds(50, 200, 200, 33);
		conservativeAccusedNameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		conservativeAccusedNameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		conservativeAccusedNameTxt.setBorder(new LineBorder(Color.BLACK, 2));
		conservativePanel.add(conservativeAccusedNameTxt);
		conservativeFileNumTxt = new JTextField();
		conservativeFileNumTxt.setColumns(10);
		conservativeFileNumTxt.setBounds(460, 250, 200, 33);
		conservativeFileNumTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		conservativeFileNumTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		conservativeFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
		conservativePanel.add(conservativeFileNumTxt);
		conservativeCprTxt = new JTextField();
		conservativeCprTxt.setColumns(10);
		conservativeCprTxt.setBounds(50, 250, 200, 33);
		conservativeCprTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		conservativeCprTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		conservativeCprTxt.setBorder(new LineBorder(Color.BLACK, 2));
		conservativePanel.add(conservativeCprTxt);
		conservativeCaseType = new JComboBox();
		conservativeCaseType.setModel(new DefaultComboBoxModel (new String[] {"نوع الدعوى", "طلاق", "نــفــقــة", "حضانة", "أخرى"}));
		conservativeCaseType.setBounds(460, 300, 200, 33);
		conservativeCaseType.setFont(new Font("Arial", Font.PLAIN, 18));
		conservativeCaseType.setBorder(new LineBorder(Color.BLACK, 1));
		conservativePanel.add(conservativeCaseType);
		conservativeTypeList = new JComboBox();
		conservativeTypeList.setModel(new DefaultComboBoxModel (new String[] {"الصفة", "المدّعي", "المدّعي عليه", "المستأنف", "المستأنف عليه", "الطاعن", "المطعون ضده"}));
		conservativeTypeList.setBounds(50, 300, 200, 33);
		conservativeTypeList.setFont(new Font("Arial", Font.PLAIN, 18));
		conservativeTypeList.setBorder(new LineBorder(Color.BLACK, 1));
		conservativePanel.add(conservativeTypeList);
		JLabel fileAttached = new JLabel("");
		fileAttached.setBounds(85, 370, 210, 50);
		fileAttached.setFont(new Font("Arial", Font.PLAIN, 18));
		fileAttached.setHorizontalAlignment(SwingConstants.CENTER);
		//fileAttached.setBorder(new LineBorder(Color.BLACK, 1));
		conservativePanel.add(fileAttached);
		conservativeBrowseBtn = new JButton();
		conservativeBrowseBtn.setBounds(300, 370, 150, 50);
		conservativeBrowseBtn.setText("إرفاق ملف");
		conservativeBrowseBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		conservativeBrowseBtn.setBorder(new RoundedBorder(20));
		conservativeBrowseBtn.setBackground(new Color(173,177,178));
		conservativeBrowseBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		conservativeBrowseBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed (ActionEvent e)
			{
				conservativeFileChooser = new JFileChooser(new File("F:\\Documents Archive"));  //PATH HERE DEPENDS ON THE EXISTANCE OF THAT DIRECTORY
				conservativeFileChooser.setFileSelectionMode(conservativeFileChooser.FILES_ONLY);
				conservativeFileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose PDF, JPEG, JPG or PNG", "jpeg", "jpg", "pdf", "png");
				conservativeFileChooser.setFileFilter(filter);
				int rVal = conservativeFileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION)
				{
					conservativeSelectedSourceFile = conservativeFileChooser.getSelectedFile();
					conservativeAttachedPath = conservativeSelectedSourceFile.toString();
					conservativeAttachedName = conservativeSelectedSourceFile.getName();
					fileAttached.setText(conservativeAttachedName);
					conservativeFilePath = conservativeSelectedSourceFile.getAbsolutePath();
				}
			}
		});
		conservativePanel.add(conservativeBrowseBtn);
		conservativeAddBtn = new JButton();
		conservativeAddBtn.setBounds(300, 440, 150, 50);
		conservativeAddBtn.setText("إضافة");
		conservativeAddBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		conservativeAddBtn.setBorder(new RoundedBorder(20));
		conservativeAddBtn.setBackground(new Color(173,177,178));
		conservativeAddBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		conservativeAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				if ((!conservativeFileNumTxt.getText().isEmpty() || !conservativeFileNumTxt.getText().equals(fileNumLbl.getText())) && conservativeAttachedName != "")
				{
					InputStream inStream = null;
					OutputStream outStream = null;
					String extension = conservativeAttachedName.substring(conservativeAttachedName.lastIndexOf("."), conservativeAttachedName.length());
					String fileName = "Client_" + conservativeFileNumTxt.getText() + extension;
					
					try
					{
						File source = new File(conservativeFilePath);
						File dest = new File("files\\", fileName);
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
	                    
	                    //JOptionPane.showMessageDialog(null, "تم نسخ الملف المرفق");
					}
					catch (IOException t)
					{
						t.printStackTrace();
					}
					
					String faName = "";
					String fType = "";
					String cName = "";
					String cCase = "";
					int cCpr = 0;
					
					if (conservativeNameTxt.getText().isEmpty())
					{
						cName = "غير متوفر";
					}
					else
					{
						cName = conservativeNameTxt.getText();
					}
					
					if (conservativeCprTxt.getText().isEmpty())
					{
						cCpr = 0;
					}
					else
					{
						cCpr = Integer.parseInt(conservativeCprTxt.getText());
					}
					
					if (conservativeCaseType.getSelectedIndex() == 0)
					{
						cCase = "غير متوفر";
					}
					else
					{
						cCase = conservativeCaseType.getSelectedItem().toString();
					}
					
					if (conservativeAccusedNameTxt.getText().isEmpty())
					{
						faName = "غير متوفر";
					}
					else
					{
						faName = conservativeAccusedNameTxt.getText();
					}
					
					if (conservativeTypeList.getSelectedIndex() != 0)
					{
						fType = conservativeTypeList.getSelectedItem().toString();
					}
					else
					{
						fType = "غير متوفر";
					}
					
					AddRecord(cName, faName, Long.parseLong(conservativeFileNumTxt.getText()), 
							cCpr, "شرعي", cCase, fType, fileName, "files\\" + fileName, null);
					JOptionPane.showMessageDialog(null, "تمت إضافة البيانات");
					CaptureCam();
					conservativeFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
					conservativeNameTxt.setText("");
					conservativeAccusedNameTxt.setText("");
					conservativeFileNumTxt.setText("");
					conservativeCprTxt.setText("");
					conservativeCaseType.setSelectedIndex(0);
					conservativeTypeList.setSelectedIndex(0);
					fileAttached.setText("");
					validateInput.setText("");
				}
				else
				{
					conservativeFileNumTxt.setBorder(new LineBorder(Color.RED, 2));
					conservativeNameTxt.setText("");
					conservativeAccusedNameTxt.setText("");
					conservativeFileNumTxt.setText("");
					conservativeCprTxt.setText("");
					conservativeCaseType.setSelectedIndex(0);
					conservativeTypeList.setSelectedIndex(0);
					validateInput.setText("الرجاء إدخال رقم ملف/إرفاق ملف");
				}
				conservativeFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
			}
		});
		conservativePanel.add(conservativeAddBtn);
		credits.setBounds(250, 500, 340, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		conservativePanel.add(credits);
	}
	//END OF CONSERVATIVE PAGE
	
	//START OF LABOR
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void LaborPage()
	{
		current = 7;
		laborPanel.setLayout(null);
		JLabel title = new JLabel("عمالي");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(313, 30, 175, 62);
		laborPanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		validateInput.setText("");
		laborPanel.add(validateInput);
		laborPanel.add(backBtn);
		JLabel nameLbl = new JLabel("اسم الموكل");
		nameLbl.setBounds(680, 205, 150, 33);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		laborPanel.add(nameLbl);
		JLabel fileNumLbl = new JLabel("رقم الدعوى");
		fileNumLbl.setBounds(680, 255, 150, 33);
		fileNumLbl.setFont(new Font("Arial", Font.BOLD, 20));
		laborPanel.add(fileNumLbl);
		JLabel accusedLbl = new JLabel("اسم الخصم");
		accusedLbl.setBounds(270, 205, 150, 33);
		accusedLbl.setFont(new Font("Arial", Font.BOLD, 20));
		laborPanel.add(accusedLbl);
		JLabel cprLbl = new JLabel("الرقم الشخصي");
		cprLbl.setBounds(270, 255, 150, 33);
		cprLbl.setFont(new Font("Arial", Font.BOLD, 20));
		laborPanel.add(cprLbl);
		laborNameTxt = new JTextField();
		laborNameTxt.setColumns(10);
		laborNameTxt.setBounds(460, 200, 200, 33);
		laborNameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		laborNameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		laborNameTxt.setBorder(new LineBorder (Color.BLACK, 2));
		laborPanel.add(laborNameTxt);
		laborAccusedNameTxt = new JTextField();
		laborAccusedNameTxt.setColumns(10);
		laborAccusedNameTxt.setBounds(50, 200, 200, 33);
		laborAccusedNameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		laborAccusedNameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		laborAccusedNameTxt.setBorder(new LineBorder(Color.BLACK, 2));
		laborPanel.add(laborAccusedNameTxt);
		laborFileNumTxt = new JTextField();
		laborFileNumTxt.setColumns(10);
		laborFileNumTxt.setBounds(460, 250, 200, 33);
		laborFileNumTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		laborFileNumTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		laborFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
		laborPanel.add(laborFileNumTxt);
		laborCprTxt = new JTextField();
		laborCprTxt.setColumns(10);
		laborCprTxt.setBounds(50, 250, 200, 33);
		laborCprTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		laborCprTxt.setFont(new Font("Arial", Font.PLAIN, 18));
		laborCprTxt.setBorder(new LineBorder(Color.BLACK, 2));
		laborPanel.add(laborCprTxt);
		laborCaseType = new JComboBox();
		laborCaseType.setModel(new DefaultComboBoxModel (new String[] {"نوع الدعوى", "تعويض", "مستحقات", "إعادة إلى الخدمة", "وقف قرار الفصل", "أخرى"}));
		laborCaseType.setBounds(460, 300, 200, 33);
		laborCaseType.setFont(new Font("Arial", Font.PLAIN, 18));
		laborCaseType.setBorder(new LineBorder(Color.BLACK, 1));
		laborTypeList = new JComboBox();
		laborTypeList.setModel(new DefaultComboBoxModel (new String[] {"الصفة", "المدّعي", "المدّعي عليه", "المستأنف", "المستأنف عليه", "الطاعن", "المطعون ضده"}));
		laborTypeList.setBounds(50, 300, 200, 33);
		laborTypeList.setFont(new Font("Arial", Font.PLAIN, 18));
		laborTypeList.setBorder(new LineBorder(Color.BLACK, 1));
		laborPanel.add(laborTypeList);
		laborPanel.add(laborCaseType);
		JLabel fileAttached = new JLabel("");
		fileAttached.setBounds(85, 370, 210, 50);
		fileAttached.setFont(new Font("Arial", Font.PLAIN, 18));
		fileAttached.setHorizontalAlignment(SwingConstants.CENTER);
		//fileAttached.setBorder(new LineBorder(Color.BLACK, 1));
		laborPanel.add(fileAttached);
		laborBrowseBtn = new JButton();
		laborBrowseBtn.setBounds(300, 370, 150, 50);
		laborBrowseBtn.setText("إرفاق ملف");
		laborBrowseBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		laborBrowseBtn.setBorder(new RoundedBorder(20));
		laborBrowseBtn.setBackground(new Color(173,177,178));
		laborBrowseBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed (ActionEvent e)
			{
				laborFileChooser = new JFileChooser(new File("F:\\Documents Archive"));  //PATH HERE DEPENDS ON THE EXISTANCE OF THAT DIRECTORY
				laborFileChooser.setFileSelectionMode(laborFileChooser.FILES_ONLY);
				laborFileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose PDF, JPEG, JPG or PNG", "jpeg", "jpg", "pdf", "png");
				laborFileChooser.setFileFilter(filter);
				int rVal = laborFileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION)
				{
					laborSelectedSourceFile = laborFileChooser.getSelectedFile();
					laborAttachedPath = laborSelectedSourceFile.toString();
					laborAttachedName = laborSelectedSourceFile.getName();
					fileAttached.setText(laborAttachedName);
					laborFilePath = laborSelectedSourceFile.getAbsolutePath();
				}
			}
		});
		laborBrowseBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		laborPanel.add(laborBrowseBtn);
		laborAddBtn = new JButton();
		laborAddBtn.setBounds(300, 440, 150, 50);
		laborAddBtn.setText("إضافة");
		laborAddBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		laborAddBtn.setBorder(new RoundedBorder(20));
		laborAddBtn.setBackground(new Color(173,177,178));
		laborAddBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		laborAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				if ((!laborFileNumTxt.getText().isEmpty() || !laborFileNumTxt.getText().equals(fileNumLbl.getText())) && laborAttachedName != "")
				{
					InputStream inStream = null;
					OutputStream outStream = null;
					String extension = laborAttachedName.substring(laborAttachedName.lastIndexOf("."), laborAttachedName.length());
					String fileName = "Client_" + laborFileNumTxt.getText() + extension;
					try
					{
						File source = new File(laborFilePath);
						File dest = new File("files\\", fileName);
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
	                    
	                    //JOptionPane.showMessageDialog(null, "تم نسخ الملف المرفق");
					}
					catch (IOException t)
					{
						t.printStackTrace();
					}
					
					String faName = "";
					String fType = "";
					String cName = "";
					String cCase = "";
					int cCpr = 0;
					
					if (laborNameTxt.getText().isEmpty())
					{
						cName = "غير متوفر";
					}
					else
					{
						cName = laborNameTxt.getText();
					}
					
					if (laborCprTxt.getText().isEmpty())
					{
						cCpr = 0;
					}
					else
					{
						cCpr = Integer.parseInt(laborCprTxt.getText());
					}
					
					if (laborCaseType.getSelectedIndex() == 0)
					{
						cCase = "غير متوفر";
					}
					else
					{
						cCase = laborCaseType.getSelectedItem().toString();
					}
					
					if (laborAccusedNameTxt.getText().isEmpty())
					{
						faName = "غير متوفر";
					}
					else
					{
						faName = laborAccusedNameTxt.getText();
					}
					
					if (laborTypeList.getSelectedIndex() != 0)
					{
						fType = laborTypeList.getSelectedItem().toString();
					}
					else
					{
						fType = "غير متوفر";
					}
					 
					AddRecord(cName, faName, Long.parseLong(laborFileNumTxt.getText()), cCpr, "عمالي", 
							cCase, fType, fileName, "files\\" + fileName, null);
					JOptionPane.showMessageDialog(null, "تمت إضافة البيانات");
					CaptureCam();
					laborFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
					laborFileNumTxt.setText("");
					laborNameTxt.setText("");
					laborAccusedNameTxt.setText("");
					laborFileNumTxt.setText("");
					laborCprTxt.setText("");
					laborCaseType.setSelectedIndex(0);
					laborTypeList.setSelectedIndex(0);
					fileAttached.setText("");
					validateInput.setText("");
				}
				else
				{
					laborFileNumTxt.setBorder(new LineBorder(Color.RED, 2));
					laborNameTxt.setText("");
					laborAccusedNameTxt.setText("");
					laborFileNumTxt.setText("");
					laborCprTxt.setText("");
					laborCaseType.setSelectedIndex(0);
					laborTypeList.setSelectedIndex(0);
					validateInput.setText("الرجاء إدخال رقم ملف/إرفاق ملف");
				}
				laborFileNumTxt.setBorder(new LineBorder(Color.BLACK, 2));
			}
		});
		laborPanel.add(laborAddBtn);
		credits.setBounds(250, 500, 340, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		laborPanel.add(credits);
	}
	//END OF LABOR PAGE
	
	//START OF DISTOR
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void DistorPage()
	{
		current = 8;
		distorPanel.setLayout(null);
		JLabel title = new JLabel("أحكام دستورية");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(250, 45, 215, 62);
		distorPanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		validateInput.setText("");
		distorPanel.add(validateInput);
		distorPanel.add(backBtn);
		JLabel nameLbl = new JLabel("اسم الموكل");
		nameLbl.setBounds(680, 205, 150, 33);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		distorPanel.add(nameLbl);
		JLabel fileNumLbl = new JLabel("رقم الدعوى");
		fileNumLbl.setBounds(680, 255, 150, 33);
		fileNumLbl.setFont(new Font("Arial", Font.BOLD, 20));
		distorPanel.add(fileNumLbl);
		JLabel accusedLbl = new JLabel("اسم الخصم");
		accusedLbl.setBounds(270, 205, 150, 33);
		accusedLbl.setFont(new Font("Arial", Font.BOLD, 20));
		distorPanel.add(accusedLbl);
		JLabel cprLbl = new JLabel("الرقم الشخصي");
		cprLbl.setBounds(270, 255, 150, 33);
		cprLbl.setFont(new Font("Arial", Font.BOLD, 20));
		distorPanel.add(cprLbl);
		JLabel fileTypeLbl = new JLabel("نوع الدعوى");
		fileTypeLbl.setBounds(680, 305, 150, 33);
		fileTypeLbl.setFont(new Font("Arial", Font.BOLD, 20));
		distorPanel.add(fileTypeLbl);
		JLabel caseType = new JLabel();
		caseType.setBounds(270, 305, 150, 33);
		caseType.setFont(new Font("Arial", Font.BOLD, 20));
		caseType.setText("");
		distorPanel.add(caseType);
		JLabel typeLbl = new JLabel("الصفة");
		typeLbl.setBounds(680, 355, 150, 33);
		typeLbl.setFont(new Font("Arial", Font.BOLD, 20));
		distorPanel.add(typeLbl);
		JTextField nameField = new JTextField();
		nameField.setBounds(420, 205, 200, 33);
		nameField.setColumns(10);
		nameField.setHorizontalAlignment(SwingConstants.RIGHT);
		nameField.setBorder(new LineBorder(Color.BLACK, 2));
		distorPanel.add(nameField);
		JTextField aNameField = new JTextField();
		aNameField.setBounds(20, 205, 200, 33);
		aNameField.setColumns(10);
		aNameField.setHorizontalAlignment(SwingConstants.RIGHT);
		aNameField.setBorder(new LineBorder(Color.BLACK, 2));
		distorPanel.add(aNameField);
		JTextField fileNumField = new JTextField();
		fileNumField.setBounds(420, 255, 200, 33);
		fileNumField.setColumns(10);
		fileNumField.setBorder(new LineBorder(Color.BLACK, 2));
		distorPanel.add(fileNumField);
		JTextField cprField = new JTextField();
		cprField.setBounds(20, 255, 200, 33);
		cprField.setColumns(10);
		cprField.setBorder(new LineBorder(Color.BLACK, 2));
		distorPanel.add(cprField);
		String[] fileTypeList = {"نوع الدعوى", "جنائي", "مدني", "عمالي", "تحكيم"};
		//String[] caseTypeList = new String[10];
		JComboBox fileTypeField = new JComboBox();
		JComboBox caseTypeField = new JComboBox();
		fileTypeField.setBounds(420, 305, 200, 33);
		fileTypeField.setModel(new DefaultComboBoxModel(fileTypeList));
		fileTypeField.setFont(new Font("Arial", Font.PLAIN, 18));
		fileTypeField.setBorder(new LineBorder(Color.BLACK, 1));
		fileTypeField.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent t)
			{
				//int state = t.getStateChange();
				if (t.getItem().toString() == "جنائي")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "القتل", "المخدرات", "اعتداء", "السرقة", "القذف", "اختلاس", "غسيل أموال", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "مدني")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "إيجار", "تعويض", "مطالبات مالية", "إفلاس", "تحكيم", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "عمالي")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "تعويض", "مستحقات", "إعادة إلى الخدمة", "وقف قرار الفصل", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "تحكيم")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "نوع الدعوى")
				{
					caseType.setText("");
					caseTypeField.setVisible(false);
				}
			}
		});
		distorPanel.add(fileTypeField);
		caseTypeField.setBounds(20, 305, 200, 33);
		//caseTypeField.setModel(new DefaultComboBoxModel(caseTypeList));
		caseTypeField.setFont(new Font("Arial", Font.PLAIN, 18));
		caseTypeField.setBorder(new LineBorder(Color.BLACK, 1));
		caseTypeField.setVisible(false);
		distorPanel.add(caseTypeField);
		String[] typeList = {"الصفة", "المدّعي", "المدّعي عليه", "المستأنف", "المستأنف عليه", "الطاعن", "المطعون ضده"};
		JComboBox typeField = new JComboBox();
		typeField.setBounds(420, 355, 200, 33);
		typeField.setModel(new DefaultComboBoxModel(typeList));
		typeField.setFont(new Font("Arial", Font.PLAIN, 18));
		typeField.setBorder(new LineBorder(Color.BLACK, 1));
		distorPanel.add(typeField);
		JLabel fileAttached = new JLabel();
		fileAttached.setBounds(200, 394, 210, 50);
		fileAttached.setFont(new Font("Arial", Font.PLAIN, 18));
		fileAttached.setHorizontalAlignment(SwingConstants.CENTER);
		distorPanel.add(fileAttached);
		JButton browseBtn = new JButton("إرفاق");
		browseBtn.setBounds(20, 400, 150, 35);
		browseBtn.setFont(new Font("Arial", Font.BOLD, 18));
		browseBtn.setBorder(new RoundedBorder(20));
		browseBtn.setBackground(new Color(173,177,178));
		browseBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		browseBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed (ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser(new File("F:\\Documents Archive"));  //PATH HERE DEPENDS ON THE EXISTANCE OF THAT DIRECTORY
				fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose PDF, JPEG, JPG or PNG", "jpeg", "jpg", "pdf", "png");
				fileChooser.setFileFilter(filter);
				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					distorAttachedPath = selectedFile.toString();
					distorAttachedName = selectedFile.getName();
					fileAttached.setText(distorAttachedName);
					distorFilePath = selectedFile.getAbsolutePath();
				}
			}
		});
		distorPanel.add(browseBtn);
		JButton addBtn = new JButton("إضافة");
		addBtn.setBounds(20, 440, 150, 35);
		addBtn.setFont(new Font("Arial", Font.BOLD, 18));
		addBtn.setBorder(new RoundedBorder(20));
		addBtn.setBackground(new Color(173,177,178));
		addBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				if ((!fileNumField.getText().isEmpty() || !fileNumField.getText().equals(fileNumLbl.getText())) && distorAttachedName != "")
				{
					InputStream inStream = null;
					OutputStream outStream = null;
					String extension = distorAttachedName.substring(distorAttachedName.lastIndexOf("."), distorAttachedName.length());
					String fileName = "Client_" + fileNumField.getText() + extension;
					try
					{
						File source = new File(distorFilePath);
						File dest = new File("files\\", fileName);
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
	                    
	                    //JOptionPane.showMessageDialog(null, "تم نسخ الملف المرفق");
	                    //////////////////////////////////////////
	                    //////////////////////////////////////////
	                    //////////////////////////////////////////
	                    String faName = "";
						String fType = "";
						String cName = "";
						String mCase = "";
						String cCase = "";
						int cCpr = 0;
						
						if (nameField.getText().isEmpty())
						{
							cName = "غير متوفر";
						}
						else
						{
							cName = nameField.getText();
						}
						
						if (cprField.getText().isEmpty())
						{
							cCpr = 0;
						}
						else
						{
							cCpr = Integer.parseInt(cprField.getText());
						}
						
						if (fileTypeField.getSelectedIndex() == 0)
						{
							mCase = "غير متوفر";
						}
						else
						{
							mCase = fileTypeField.getSelectedItem().toString();
						}
						
						if (caseTypeField.getSelectedIndex() == 0)
						{
							cCase = "غير متوفر";
						}
						else
						{
							cCase = caseTypeField.getSelectedItem().toString();
						}
						
						if (aNameField.getText().isEmpty())
						{
							faName = "غير متوفر";
						}
						else
						{
							faName = aNameField.getText();
						}
						
						if (typeField.getSelectedIndex() != 0)
						{
							fType = typeField.getSelectedItem().toString();
						}
						else
						{
							fType = "غير متوفر";
						}
						 
						AddRecord(cName, faName, Long.parseLong(fileNumField.getText()), cCpr, mCase, 
								cCase, fType, fileName, "files\\" + fileName, "دستوري");
						JOptionPane.showMessageDialog(null, "تمت إضافة البيانات");
						CaptureCam();
						fileNumField.setBorder(new LineBorder(Color.BLACK, 2));
						fileNumField.setText("");
						nameField.setText("");
						aNameField.setText("");
						fileNumField.setText("");
						cprField.setText("");
						fileTypeField.setSelectedIndex(0);
						typeField.setSelectedIndex(0);
						fileAttached.setText("");
						validateInput.setText("");
					}
					catch (Exception x)
					{
						JOptionPane.showMessageDialog(null, "هناك خطأ! لم تتم العملية");
					}
				}
				else
				{
					fileNumField.setBorder(new LineBorder(Color.RED, 2));
					nameField.setText("");
					aNameField.setText("");
					fileNumField.setText("");
					cprField.setText("");
					fileTypeField.setSelectedIndex(0);
					typeField.setSelectedIndex(0);
					validateInput.setText("الرجاء إدخال رقم ملف/إرفاق ملف");
				}
				fileNumField.setBorder(new LineBorder(Color.BLACK, 2));
			}
		});
		distorPanel.add(addBtn);
		credits.setBounds(250, 500, 340, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		distorPanel.add(credits);
	}
	//END OF DISTOR
	
	//START OF TAMYEEZ
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void TamyeezPage()
	{
		current = 9;
		tamyeezPanel.setLayout(null);
		JLabel title = new JLabel("أحكام تمييز");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(250, 45, 215, 62);
		tamyeezPanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		validateInput.setText("");
		tamyeezPanel.add(validateInput);
		tamyeezPanel.add(backBtn);
		JLabel nameLbl = new JLabel("اسم الموكل");
		nameLbl.setBounds(680, 205, 150, 33);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		tamyeezPanel.add(nameLbl);
		JLabel fileNumLbl = new JLabel("رقم الدعوى");
		fileNumLbl.setBounds(680, 255, 150, 33);
		fileNumLbl.setFont(new Font("Arial", Font.BOLD, 20));
		tamyeezPanel.add(fileNumLbl);
		JLabel accusedLbl = new JLabel("اسم الخصم");
		accusedLbl.setBounds(270, 205, 150, 33);
		accusedLbl.setFont(new Font("Arial", Font.BOLD, 20));
		tamyeezPanel.add(accusedLbl);
		JLabel cprLbl = new JLabel("الرقم الشخصي");
		cprLbl.setBounds(270, 255, 150, 33);
		cprLbl.setFont(new Font("Arial", Font.BOLD, 20));
		tamyeezPanel.add(cprLbl);
		JLabel fileTypeLbl = new JLabel("نوع الدعوى");
		fileTypeLbl.setBounds(680, 305, 150, 33);
		fileTypeLbl.setFont(new Font("Arial", Font.BOLD, 20));
		tamyeezPanel.add(fileTypeLbl);
		JLabel caseType = new JLabel();
		caseType.setBounds(270, 305, 150, 33);
		caseType.setFont(new Font("Arial", Font.BOLD, 20));
		caseType.setText("");
		tamyeezPanel.add(caseType);
		JLabel typeLbl = new JLabel("الصفة");
		typeLbl.setBounds(680, 355, 150, 33);
		typeLbl.setFont(new Font("Arial", Font.BOLD, 20));
		tamyeezPanel.add(typeLbl);
		JTextField nameField = new JTextField();
		nameField.setBounds(420, 205, 200, 33);
		nameField.setColumns(10);
		nameField.setHorizontalAlignment(SwingConstants.RIGHT);
		nameField.setBorder(new LineBorder(Color.BLACK, 2));
		tamyeezPanel.add(nameField);
		JTextField aNameField = new JTextField();
		aNameField.setBounds(20, 205, 200, 33);
		aNameField.setColumns(10);
		aNameField.setHorizontalAlignment(SwingConstants.RIGHT);
		aNameField.setBorder(new LineBorder(Color.BLACK, 2));
		tamyeezPanel.add(aNameField);
		JTextField fileNumField = new JTextField();
		fileNumField.setBounds(420, 255, 200, 33);
		fileNumField.setColumns(10);
		fileNumField.setBorder(new LineBorder(Color.BLACK, 2));
		tamyeezPanel.add(fileNumField);
		JTextField cprField = new JTextField();
		cprField.setBounds(20, 255, 200, 33);
		cprField.setColumns(10);
		cprField.setBorder(new LineBorder(Color.BLACK, 2));
		tamyeezPanel.add(cprField);
		String[] fileTypeList = {"نوع الدعوى", "جنائي", "مدني", "عمالي", "تحكيم"};
		String[] caseTypeList = {};
		JComboBox fileTypeField = new JComboBox();
		JComboBox caseTypeField = new JComboBox();
		fileTypeField.setBounds(420, 305, 200, 33);
		fileTypeField.setModel(new DefaultComboBoxModel(fileTypeList));
		fileTypeField.setFont(new Font("Arial", Font.PLAIN, 18));
		fileTypeField.setBorder(new LineBorder(Color.BLACK, 1));
		fileTypeField.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent t)
			{
				//int state = t.getStateChange();
				if (t.getItem().toString() == "جنائي")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "القتل", "المخدرات", "اعتداء", "السرقة", "القذف", "اختلاس", "غسيل أموال", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "مدني")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "إيجار", "تعويض", "مطالبات مالية", "إفلاس", "تحكيم", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "عمالي")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "تعويض", "مستحقات", "إعادة إلى الخدمة", "وقف قرار الفصل", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "تحكيم")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "نوع الدعوى")
				{
					caseType.setText("");
					caseTypeField.setVisible(false);
				}
			}
		});
		tamyeezPanel.add(fileTypeField);
		caseTypeField.setBounds(20, 305, 200, 33);
		//caseTypeField.setModel(new DefaultComboBoxModel(caseTypeList));
		caseTypeField.setFont(new Font("Arial", Font.PLAIN, 18));
		caseTypeField.setBorder(new LineBorder(Color.BLACK, 1));
		caseTypeField.setVisible(false);
		tamyeezPanel.add(caseTypeField);
		String[] typeList = {"الصفة", "المدّعي", "المدّعي عليه", "المستأنف", "المستأنف عليه", "الطاعن", "المطعون ضده"};
		JComboBox typeField = new JComboBox();
		typeField.setBounds(420, 355, 200, 33);
		typeField.setModel(new DefaultComboBoxModel(typeList));
		typeField.setFont(new Font("Arial", Font.PLAIN, 18));
		typeField.setBorder(new LineBorder(Color.BLACK, 1));
		tamyeezPanel.add(typeField);
		JLabel fileAttached = new JLabel();
		fileAttached.setBounds(200, 394, 210, 50);
		fileAttached.setFont(new Font("Arial", Font.PLAIN, 18));
		fileAttached.setHorizontalAlignment(SwingConstants.CENTER);
		tamyeezPanel.add(fileAttached);
		JButton browseBtn = new JButton("إرفاق");
		browseBtn.setBounds(20, 400, 150, 35);
		browseBtn.setFont(new Font("Arial", Font.BOLD, 18));
		browseBtn.setBorder(new RoundedBorder(20));
		browseBtn.setBackground(new Color(173,177,178));
		browseBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		browseBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed (ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser(new File("F:\\Documents Archive"));  //PATH HERE DEPENDS ON THE EXISTANCE OF THAT DIRECTORY
				fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose PDF, JPEG, JPG or PNG", "jpeg", "jpg", "pdf", "png");
				fileChooser.setFileFilter(filter);
				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					tamyeezAttachedPath = selectedFile.toString();
					tamyeezAttachedName = selectedFile.getName();
					fileAttached.setText(tamyeezAttachedName);
					tamyeezFilePath = selectedFile.getAbsolutePath();
				}
			}
		});
		tamyeezPanel.add(browseBtn);
		JButton addBtn = new JButton("إضافة");
		addBtn.setBounds(20, 440, 150, 35);
		addBtn.setFont(new Font("Arial", Font.BOLD, 18));
		addBtn.setBorder(new RoundedBorder(20));
		addBtn.setBackground(new Color(173,177,178));
		addBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				if ((!fileNumField.getText().isEmpty() || !fileNumField.getText().equals(fileNumLbl.getText())) && tamyeezAttachedName != "")
				{
					InputStream inStream = null;
					OutputStream outStream = null;
					String extension = tamyeezAttachedName.substring(tamyeezAttachedName.lastIndexOf("."), tamyeezAttachedName.length());
					String fileName = "Client_" + fileNumField.getText() + extension;
					try
					{
						File source = new File(tamyeezFilePath);
						File dest = new File("files\\", fileName);
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
	                    
	                    //JOptionPane.showMessageDialog(null, "تم نسخ الملف المرفق");
	                    //////////////////////////////////////////
	                    //////////////////////////////////////////
	                    //////////////////////////////////////////
	                    String faName = "";
						String fType = "";
						String cName = "";
						String mCase = "";
						String cCase = "";
						int cCpr = 0;
						
						if (nameField.getText().isEmpty())
						{
							cName = "غير متوفر";
						}
						else
						{
							cName = nameField.getText();
						}
						
						if (cprField.getText().isEmpty())
						{
							cCpr = 0;
						}
						else
						{
							cCpr = Integer.parseInt(cprField.getText());
						}
						
						if (fileTypeField.getSelectedIndex() == 0)
						{
							mCase = "غير متوفر";
						}
						else
						{
							mCase = fileTypeField.getSelectedItem().toString();
						}
						
						if (caseTypeField.getSelectedIndex() == 0)
						{
							cCase = "غير متوفر";
						}
						else
						{
							cCase = caseTypeField.getSelectedItem().toString();
						}
						
						if (aNameField.getText().isEmpty())
						{
							faName = "غير متوفر";
						}
						else
						{
							faName = aNameField.getText();
						}
						
						if (typeField.getSelectedIndex() != 0)
						{
							fType = typeField.getSelectedItem().toString();
						}
						else
						{
							fType = "غير متوفر";
						}
						 
						AddRecord(cName, faName, Long.parseLong(fileNumField.getText()), cCpr, mCase, 
								cCase, fType, fileName, "files\\" + fileName, "تمييز");
						JOptionPane.showMessageDialog(null, "تمت إضافة البيانات");
						CaptureCam();
						fileNumField.setBorder(new LineBorder(Color.BLACK, 2));
						fileNumField.setText("");
						nameField.setText("");
						aNameField.setText("");
						fileNumField.setText("");
						cprField.setText("");
						fileTypeField.setSelectedIndex(0);
						typeField.setSelectedIndex(0);
						fileAttached.setText("");
						validateInput.setText("");
					}
					catch (Exception x)
					{
						JOptionPane.showMessageDialog(null, "هناك خطأ! لم تتم العملية");
					}
				}
				else
				{
					fileNumField.setBorder(new LineBorder(Color.RED, 2));
					nameField.setText("");
					aNameField.setText("");
					fileNumField.setText("");
					cprField.setText("");
					fileTypeField.setSelectedIndex(0);
					typeField.setSelectedIndex(0);
					validateInput.setText("الرجاء إدخال رقم ملف/إرفاق ملف");
				}
				fileNumField.setBorder(new LineBorder(Color.BLACK, 2));
			}
		});
		tamyeezPanel.add(addBtn);
		credits.setBounds(250, 500, 340, 50);
		credits.setFont(new Font("Arial", Font.PLAIN, 18));
		tamyeezPanel.add(credits);
	}
	//END OF TAMYEEZ
	
	//START OF STUDIES
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void StudiesPage()
	{
		current = 10;
		studiesPanel.setLayout(null);
		JLabel title = new JLabel("دراسات");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(250, 45, 215, 62);
		studiesPanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		validateInput.setText("");
		studiesPanel.add(validateInput);
		studiesPanel.add(backBtn);
		JLabel nameLbl = new JLabel("اسم الموكل");
		nameLbl.setBounds(680, 205, 150, 33);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		studiesPanel.add(nameLbl);
		JLabel cprLbl = new JLabel("الرقم الشخصي");
		cprLbl.setBounds(270, 205, 150, 33);
		cprLbl.setFont(new Font("Arial", Font.BOLD, 20));
		studiesPanel.add(cprLbl);
		JLabel fileTypeLbl = new JLabel("نوع الدعوى");
		fileTypeLbl.setBounds(680, 305, 150, 33);
		fileTypeLbl.setFont(new Font("Arial", Font.BOLD, 20));
		studiesPanel.add(fileTypeLbl);
		JLabel caseType = new JLabel();
		caseType.setBounds(270, 305, 150, 33);
		caseType.setFont(new Font("Arial", Font.BOLD, 20));
		caseType.setText("");
		studiesPanel.add(caseType);
		//////////////////////////////////////////////////////////////////////////
		JTextField nameField = new JTextField();
		nameField.setBounds(420, 205, 200, 33);
		nameField.setColumns(10);
		nameField.setHorizontalAlignment(SwingConstants.RIGHT);
		nameField.setBorder(new LineBorder(Color.BLACK, 2));
		studiesPanel.add(nameField);
		JTextField cprField = new JTextField();
		cprField.setBounds(20, 205, 200, 33);
		cprField.setColumns(10);
		cprField.setHorizontalAlignment(SwingConstants.RIGHT);
		cprField.setBorder(new LineBorder(Color.BLACK, 2));
		studiesPanel.add(cprField);
		String[] fileTypeList = {"نوع الدعوى", "جنائي", "مدني", "عمالي", "شرعي","تحكيم"};
		String[] caseTypeList = {};
		JComboBox fileTypeField = new JComboBox();
		JComboBox caseTypeField = new JComboBox();
		fileTypeField.setBounds(420, 305, 200, 33);
		fileTypeField.setModel(new DefaultComboBoxModel(fileTypeList));
		fileTypeField.setFont(new Font("Arial", Font.PLAIN, 18));
		fileTypeField.setBorder(new LineBorder(Color.BLACK, 1));
		fileTypeField.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent t)
			{
				//int state = t.getStateChange();
				if (t.getItem().toString() == "جنائي")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "القتل", "المخدرات", "اعتداء", "السرقة", "القذف", "اختلاس", "غسيل أموال", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "مدني")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "إيجار", "تعويض", "مطالبات مالية", "إفلاس", "تحكيم", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "عمالي")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "تعويض", "مستحقات", "إعادة إلى الخدمة", "وقف قرار الفصل", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "شرعي")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "طلاق", "نــفــقــة", "حضانة", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "تحكيم")
				{
					caseType.setText("نوع القضية");
					caseTypeField.setModel(new DefaultComboBoxModel(new String[] {"", "أخرى"}));
					caseTypeField.setVisible(true);
				}
				else if (t.getItem().toString() == "نوع الدعوى")
				{
					caseType.setText("");
					caseTypeField.setVisible(false);
				}
			}
		});
		studiesPanel.add(fileTypeField);
		caseTypeField.setBounds(20, 305, 200, 33);
		//caseTypeField.setModel(new DefaultComboBoxModel(caseTypeList));
		caseTypeField.setFont(new Font("Arial", Font.PLAIN, 18));
		caseTypeField.setBorder(new LineBorder(Color.BLACK, 1));
		caseTypeField.setVisible(false);
		studiesPanel.add(caseTypeField);
		JLabel fileAttached = new JLabel();
		fileAttached.setBounds(200, 394, 210, 50);
		fileAttached.setFont(new Font("Arial", Font.PLAIN, 18));
		fileAttached.setHorizontalAlignment(SwingConstants.CENTER);
		studiesPanel.add(fileAttached);
		JButton browseBtn = new JButton("إرفاق");
		browseBtn.setBounds(20, 400, 150, 35);
		browseBtn.setFont(new Font("Arial", Font.BOLD, 18));
		browseBtn.setBorder(new RoundedBorder(20));
		browseBtn.setBackground(new Color(173,177,178));
		browseBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		studiesPanel.add(browseBtn);
		JButton addBtn = new JButton("إضافة");
		addBtn.setBounds(20, 440, 150, 35);
		addBtn.setFont(new Font("Arial", Font.BOLD, 18));
		addBtn.setBorder(new RoundedBorder(20));
		addBtn.setBackground(new Color(173,177,178));
		addBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		studiesPanel.add(addBtn);
	}
	//END OF STUDIES
	
	//START OF CONTRACTS PAGE
	public void ContractPage()
	{
		current = 11;
		conMenuPanel.setLayout(null);
		JLabel title = new JLabel("عـــقــــود");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(250, 45, 215, 62);
		conMenuPanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		validateInput.setText("");
		conMenuPanel.add(validateInput);
		conMenuPanel.add(backBtn);
		///////////////////////////////////////////
		JButton addContractBtn = new JButton("إضافة");
		addContractBtn.setBounds(235, 200, 300, 35);
		addContractBtn.setFont(new Font("Arial", Font.BOLD, 18));
		addContractBtn.setBorder(new RoundedBorder(20));
		addContractBtn.setBackground(new Color(74,239,247));
		addContractBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		addContractBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mainLayout.show(mainPanel, "contractsAddPage");
				ContractAddPage();
			}
		});
		conMenuPanel.add(addContractBtn);
		JButton searchContractBtn = new JButton("بحث");
		searchContractBtn.setBounds(235, 250, 300, 35);
		searchContractBtn.setFont(new Font("Arial", Font.BOLD, 18));
		searchContractBtn.setBorder(new RoundedBorder(20));
		searchContractBtn.setBackground(new Color(92,247,74));
		searchContractBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		searchContractBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mainLayout.show(mainPanel, "contractsSearchPage");
				ContractSearchPage();
			}
		});
		conMenuPanel.add(searchContractBtn);
	}
	//END OF CONTRACTS PAGE
	
	//START OF CONTRACT
	public void ContractAddPage()
	{
		current = 12;
		contPanel.setLayout(null);
		JLabel title = new JLabel("إضـــافة عـــقــد جــديــد");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(250, 45, 300, 62);
		contPanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		validateInput.setText("");
		contPanel.add(validateInput);
		contPanel.add(backBtn);
		JLabel nameLbl = new JLabel("رقم العقد");
		nameLbl.setBounds(650, 205, 150, 33);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		contPanel.add(nameLbl);
		JLabel fileTypeLbl = new JLabel("إرفاق ملف");
		fileTypeLbl.setBounds(650, 305, 150, 33);
		fileTypeLbl.setFont(new Font("Arial", Font.BOLD, 20));
		contPanel.add(fileTypeLbl);
		//////////////////////////////////////////////////////////////////////////
		JTextField nameField = new JTextField();
		nameField.setBounds(320, 205, 250, 33);
		nameField.setColumns(10);
		nameField.setFont(new Font("Arial", Font.PLAIN, 18));
		nameField.setHorizontalAlignment(SwingConstants.RIGHT);
		nameField.setBorder(new LineBorder(Color.BLACK, 2));
		contPanel.add(nameField);
		JLabel fileAttached = new JLabel();
		fileAttached.setBounds(150, 300, 210, 50);
		fileAttached.setFont(new Font("Arial", Font.PLAIN, 18));
		fileAttached.setHorizontalAlignment(SwingConstants.CENTER);
		contPanel.add(fileAttached);
		JButton browseBtn = new JButton("إرفاق");
		browseBtn.setBounds(380, 305, 150, 35);
		browseBtn.setFont(new Font("Arial", Font.BOLD, 18));
		browseBtn.setBorder(new RoundedBorder(20));
		browseBtn.setBackground(new Color(173,177,178));
		browseBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		browseBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed (ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser(new File("F:\\Documents Archive"));  //PATH HERE DEPENDS ON THE EXISTANCE OF THAT DIRECTORY
				fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose PDF, JPEG, JPG or PNG", "jpeg", "jpg", "pdf", "png");
				fileChooser.setFileFilter(filter);
				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					contAttachedPath = selectedFile.toString();
					contAttachedName = selectedFile.getName();
					fileAttached.setText(contAttachedName);
					contFilePath = selectedFile.getAbsolutePath();
				}
			}
		});
		contPanel.add(browseBtn);
		JButton addBtn = new JButton("إضافة");
		addBtn.setBounds(380, 405, 150, 35);
		addBtn.setFont(new Font("Arial", Font.BOLD, 18));
		addBtn.setBorder(new RoundedBorder(20));
		addBtn.setBackground(new Color(173,177,178));
		addBtn.setUI(new BasicButtonUI() {
			@Override
			public void update(Graphics g, JComponent c)
			{
				if (c.isOpaque())
				{
					Color fillColor = c.getBackground();
					
					AbstractButton button = (AbstractButton) c;
					ButtonModel model = button.getModel();
					
					if (model.isPressed())
						fillColor = fillColor.darker();
					else if (model.isRollover())
						fillColor = fillColor.brighter();
					
					g.setColor(fillColor);
					g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
				}
				paint(g, c);
			}
		});
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				if (!nameField.getText().isEmpty() && contAttachedName != "")
				{
					InputStream inStream = null;
					OutputStream outStream = null;
					String extension = contAttachedName.substring(contAttachedName.lastIndexOf("."), contAttachedName.length());
					String fileName = "Contract_" + nameField.getText() + extension;
					try
					{
						File dir = new File("contracts");
						if (!dir.exists())
							dir.mkdir();
						File source = new File(contFilePath);
						File dest = new File("contracts\\", fileName);
						
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
	                    //JOptionPane.showMessageDialog(null, "تم نسخ الملف المرفق");
	                    //////////////////////////////////////////
	                    //////////////////////////////////////////
	                    //////////////////////////////////////////
	                    
	                    LocalDateTime dateTime = LocalDateTime.now();
	            		DateTimeFormatter formatDT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	            		String formatedDT = dateTime.format(formatDT);
	                    
	                    ResultSet rSet;
	                    //
	                    PreparedStatement pStmt;
	                    String sql = "INSERT INTO contract(c_num, c_path, c_date) VALUES(?,?,?);";
	                    pStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	                    //
	                    pStmt.setString(1, nameField.getText());
	                    pStmt.setString(2, "contracts\\"+fileName);
	                    pStmt.setString(3, formatedDT);
	                    pStmt.executeUpdate();
	                    WriteLogs("A New Contract Has been added with name: " + nameField.getText());
						JOptionPane.showMessageDialog(null, "تمت إضافة البيانات");
						CaptureCam();
						nameField.setText(null);
						fileAttached.setText(null);
						contAttachedName = "";
						validateInput.setText("");
					}
					catch (Exception x)
					{
						//x.printStackTrace();
						JOptionPane.showMessageDialog(null, "هناك خطأ! لم تتم العملية");
					}
				}
				else
				{
					validateInput.setText("الرجاء إكمال البيانات المطلوبة");
				}
			}
		});
		contPanel.add(addBtn);
	}
	//END OF CONTRACT
	
	//START OF SEARCH CONTRACT
	public void ContractSearchPage()
	{
		current = 13;
		contSearchPanel.setLayout(null);
		JLabel title = new JLabel("بـــحـــث الـــعـــقـــود");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(250, 45, 300, 62);
		contSearchPanel.add(title);
		JLabel validateInput = new JLabel();
		validateInput.setBounds(150, 140, 450, 50);
		validateInput.setFont(new Font("Arial", Font.PLAIN, 20));
		validateInput.setHorizontalAlignment(SwingConstants.CENTER);
		validateInput.setForeground(Color.RED);
		validateInput.setText("");
		contSearchPanel.add(validateInput);
		contSearchPanel.add(backBtn);
		//////////////////////////////////////////////////////////////
		JLabel nameLbl = new JLabel("الاسم");
		nameLbl.setBounds(650, 150, 150, 33);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		contSearchPanel.add(nameLbl);
		JTextField nameField = new JTextField();
		nameField.setBounds(280, 150, 250, 33);
		nameField.setColumns(10);
		nameField.setFont(new Font("Arial", Font.PLAIN, 18));
		nameField.setHorizontalAlignment(SwingConstants.RIGHT);
		nameField.setBorder(new LineBorder(Color.BLACK, 2));
		contSearchPanel.add(nameField);
		///////////////////////////////////////////////////////////////
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String column[] = {"عرض", "رقم العقد"};
		JButton searchBtn = new JButton("أبحث");
		searchBtn.setBounds(150, 150, 100, 33);
		searchBtn.setFont(new Font("Arial", Font.BOLD, 20));
		searchBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					model.setRowCount(0);
					String txtNum = nameField.getText();
					String content = "المحتوى";
					String sql = "";
					
					if (!nameField.getText().isEmpty())
						sql = "SELECT * FROM contract WHERE c_num LIKE '"+txtNum+"%'";
					else
						sql = "SELECT * FROM contract";
					PreparedStatement pSt = connection.prepareStatement(sql);
					ResultSet rS = pSt.executeQuery();
					
					int count = 0;
					while (rS.next())
					{
						String name = rS.getString("c_num");
						String path = rS.getString("c_path");
						model.setColumnIdentifiers(column);
						model.addRow(new Object[] {content, name});
						table.setModel(model);
						count++;
						//JOptionPane.showMessageDialog(null, count);
					}
					if (count <= 0)
					{
						JOptionPane.showMessageDialog(null, "لم يتم العثور على أي بيانات");
					}
					
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
						@SuppressWarnings("serial")
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
									String sql = "SELECT c_path FROM contract WHERE c_num = '"+table.getValueAt(table.getSelectedRow(), 1)+"';";
									PreparedStatement pSt = connection.prepareStatement(sql);
									ResultSet rS = pSt.executeQuery();
									while (rS.next())
									{
										String path = rS.getString("c_path");
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
				catch (Exception x)
				{
					x.printStackTrace();
				}
			}
		});
		contSearchPanel.add(searchBtn);
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(5 , 200, 735, 280); //Width was 770 => 368
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//table.setEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 21));				////For setting up the Table Header (column) font
		table.getTableHeader().setPreferredSize(new Dimension(50,50));
		table.setIntercellSpacing(new Dimension(5,5));
		contSearchPanel.add(scrollPane);
	}
	//END OF SEARCH CONTRACT
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == checkDBMenu)
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
		
		if (e.getSource() == updateDBMenu)
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
		
		if (e.getSource() == addSheet)
		{
			JOptionPane.showMessageDialog(null, "This feature is temporarily under maintanence.");
			/*sheetFileChooser = new JFileChooser(new File(System.getProperty("user.home"), "Desktop"));
			sheetFileChooser.setFileSelectionMode(sheetFileChooser.FILES_ONLY);
			sheetFileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose Sheet File", "xls", "xlsx", "csv");
			sheetFileChooser.setFileFilter(filter);
			int rVal = sheetFileChooser.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION)
			{
				sheetSelectedSourceFile = sheetFileChooser.getSelectedFile();
				sheetAttachedPath = sheetSelectedSourceFile.toString();
				sheetAttachedName = sheetSelectedSourceFile.getName();
				addSheetLbl.setText(sheetAttachedName);
				sheetFilePath = sheetSelectedSourceFile.getAbsolutePath();
				sheetDialog.setVisible(true);
			}*/
		}
		
		if (e.getSource() == addFile)
		{
			attachedFileChooser = new JFileChooser(new File(System.getProperty("user.home"), "Desktop"));
			attachedFileChooser.setFileSelectionMode(attachedFileChooser.DIRECTORIES_ONLY);
			int rVal = attachedFileChooser.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION)
			{
				attachedSelectedSourceFile = attachedFileChooser.getSelectedFile();
				attachedPath = attachedSelectedSourceFile.toString();
				attachedName = attachedSelectedSourceFile.getName();
				addFileLbl.setText(attachedName);
				attachedFilePath = attachedSelectedSourceFile.getAbsolutePath();
				addFileDialog.setVisible(true);
			}
		}
		
		if (e.getSource() == logsMenu)
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
		
		if (e.getSource() == checkFileNum)
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
		
		if (e.getSource() == addPageBtn)
		{
			mainLayout.show(mainPanel, "addPage");
			AddPage();
		}
		
		if (e.getSource() == addContPageBtn)
		{
			mainLayout.show(mainPanel, "contractsPage");
			ContractPage();
		}

		if (e.getSource() == backBtn && (current == 2 || current == 3 || current == 11))
		{
			if (current == 3)
			{
				editFileNumTxt.setText("");
				editPanel.revalidate();
				editPanel.repaint();
				editField.setVisible(false);
			}
			mainLayout.show(mainPanel, "homePage");
			HomePage();
		}
		
		else if (e.getSource() == backBtn && (current == 12 || current == 13))
		{
			mainLayout.show(mainPanel, "contractsPage");
			ContractPage();
		}
		
		else if (e.getSource() == backBtn && (current >= 4 && current <= 10))
		{
			mainLayout.show(mainPanel, "addPage");
			if (current == 4)
			{
				felonNameTxt.setText(null);
				felonAccusedNameTxt.setText(null);
				felonFileNumTxt.setText(null);
				felonCprTxt.setText(null);
				felonCaseType.setSelectedIndex(0);
				felonTypeList.setSelectedIndex(0);
			}
			else if (current == 5)
			{
				civilNameTxt.setText("");
				civilAccusedNameTxt.setText("");
				civilFileNumTxt.setText("");
				civilCprTxt.setText("");
				civilCaseType.setSelectedIndex(0);
				civilTypeList.setSelectedIndex(0);
			}
			else if (current == 6)
			{
				conservativeNameTxt.setText("");
				conservativeAccusedNameTxt.setText("");
				conservativeFileNumTxt.setText("");
				conservativeCprTxt.setText("");
				conservativeCaseType.setSelectedIndex(0);
				conservativeTypeList.setSelectedIndex(0);
			}
			else if (current == 7)
			{
				laborNameTxt.setText("");
				laborAccusedNameTxt.setText("");
				laborFileNumTxt.setText("");
				laborCprTxt.setText("");
				laborCaseType.setSelectedIndex(0);
				laborTypeList.setSelectedIndex(0);
			}
			AddPage();
		}

		if (e.getSource() == searchPageBtn)
		{
			//mainLayout.show(mainPanel, "searchPage");	OUTDATED
			SearchPage sp = new SearchPage(1280,720);
			sp.setTitle("Alshamlan Attorney & Legal Consultations");
			sp.setVisible(true);
			sp.setLocationRelativeTo(null);
			sp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		if (e.getSource() == editPageBtn)
		{
			mainLayout.show(mainPanel, "editPage");
			EditPage();
		}

		if (e.getSource() == felonPageBtn)
		{
			mainLayout.show(mainPanel, "felonPage");
			FelonPage();
		}
		
		if (e.getSource() == civilPageBtn)
		{
			mainLayout.show(mainPanel, "civilPage");
			CivilPage();
		}
		
		if (e.getSource() == conservativePageBtn)
		{
			mainLayout.show(mainPanel, "conservativePage");
			ConservativePage();
		}
		
		if (e.getSource() == laborPageBtn)
		{
			mainLayout.show(mainPanel, "laborPage");
			LaborPage();
		}
	}

	public static void main(String[] args) throws IOException {
		Main window = new Main(WIDTH,HEIGHT);
		window.setTitle("Alshamlan Attorney & Legal Consultants");
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//UN-COMMENT THE CODE BELOW IF YOU WANT THIS APPLICATION TO ALWAYS BE THE TOP WINDOW ON THE MONITOR (ON TOP OF ALL OTHER OPEN WINDOWS)
		//window.setAlwaysOnTop(true);
	}
}
