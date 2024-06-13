package Gui;

import javax.swing.JFrame;


import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import Dao.Dao_LoaiThuoc;
import Dao.Dao_Thuoc;
import Dao.Dao_nhaCungCap;
import Entity.Thuoc;
import Entity.loaiThuoc;
import Entity.nhaCungCap;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import ConnectDB.ConnectDB;

import java.awt.SystemColor;

public class Gui_Thuoc extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel pAll;
	private JLabel lblTiltle;
	private JPanel pTable;
	private DefaultTableModel dm;
	private JTable table;
	private JScrollPane pane;
	private Dao_Thuoc dsThuoc;
	private Dao_LoaiThuoc lt;
	private Dao_nhaCungCap ncc;

	private JTextField txtTim;
	private JPanel pInput;
	private JTextField txtMaThuoc;
	private JTextField txtTenThuoc;
	private JTextField txtSoLuongNhap;
	private JTextField txtSoLuongTon;
	private JTextField txtGiaNhap;

	private JComboBox<String> cbbNCC;

	private JComboBox<String> cbbLoai;

	private JButton btnLamMoi;

	private JButton btnThem;

	private JButton btnXoa;

	private JButton btnCapNhap;

	private JButton btnTim;
	private JDateChooser txtNgayNhap;
	private JDateChooser txtNgaySanXuat;
	private JDateChooser txtNgayHetHan;
	private loaiThuoc loai;
	private nhaCungCap maNCC;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Gui_Thuoc() {
		dsThuoc = new Dao_Thuoc();
		setSize(1000, 699);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setResizable(false);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		pAll = new JPanel();
		pAll.setBackground(new Color(0, 153, 102));
		pAll.setBorder(new LineBorder(new Color(0, 153, 51), 0));

		setContentPane(pAll);
		pAll.setLayout(null);

		JPanel pTitle = new JPanel();
		pTitle.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		pTitle.setBackground(new Color(0, 153, 102));
		pTitle.setBounds(-12, -5, 1012, 40);
		pAll.add(pTitle);
		pTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblTiltle = new JLabel("THÔNG TIN THUỐC");
		lblTiltle.setForeground(new Color(255, 250, 250));
		lblTiltle.setFont(new Font("Tahoma", Font.BOLD, 20));
		pTitle.add(lblTiltle);

		pTable = new JPanel();
		pTable.setBounds(10, 107, 966, 341);
		pAll.add(pTable);
		String headCols[] = { "Mã thuốc", "Tên thuốc", "Loại thuốc", "Giá nhập", "Ngày nhập", "Ngày sản xuất",
				"Ngày hết hạn", "Số lượng nhập", "Số lượng tồn", "Nhà cung cấp" };

		dm = new DefaultTableModel(headCols, 0);

		pTable.setLayout(null);
		table = new JTable(dm);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setRowHeight(30);
		pane = new JScrollPane(table);
		pane.setBounds(0, 0, 966, 341);
		pTable.add(pane);
		JTableHeader header_font = table.getTableHeader();
		Font f = new Font("Tahoma", Font.LAYOUT_LEFT_TO_RIGHT, 12);
		header_font.setFont(f);
		JPanel pEven = new JPanel();
		pEven.setBackground(new Color(0, 153, 102));
		pEven.setBounds(10, 50, 966, 47);
		pAll.add(pEven);
		pEven.setLayout(null);

		JLabel lblTim = new JLabel("Tìm thuốc theo mã :");
		lblTim.setForeground(new Color(255, 255, 255));
		lblTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTim.setBounds(506, 9, 155, 13);
		pEven.add(lblTim);

		btnTim = new JButton("");
		btnTim.setForeground(SystemColor.activeCaptionText);
		btnTim.setBackground(new Color(255, 255, 255));
		btnTim.setBounds(896, 1, 49, 30);
		ImageIcon iconTim = new ImageIcon("./image/search.png");
		Image scaledIcon1 = iconTim.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIconTim = new ImageIcon(scaledIcon1);
		btnTim.setIcon(scaledIconTim);
		pEven.add(btnTim);

		JLabel lblBngDanhSch = new JLabel("BẢNG DANH SÁCH THUỐC:");
		lblBngDanhSch.setForeground(Color.WHITE);
		lblBngDanhSch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBngDanhSch.setBounds(0, 25, 175, 22);
		pEven.add(lblBngDanhSch);

		txtTim = new JTextField();
		txtTim.setBounds(632, 1, 265, 30);
		pEven.add(txtTim);
		txtTim.setColumns(10);

		pInput = new JPanel();
		pInput.setBackground(new Color(0, 153, 102));
		pInput.setBounds(10, 460, 966, 190);
		pAll.add(pInput);
		pInput.setLayout(null);

		JLabel lblMaThuoc = new JLabel("Mã thuốc :");
		lblMaThuoc.setBounds(10, 30, 115, 15);
		lblMaThuoc.setForeground(new Color(255, 255, 255));
		lblMaThuoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		pInput.add(lblMaThuoc);

		txtMaThuoc = new JTextField();
		txtMaThuoc.setBounds(116, 25, 175, 25);
		txtMaThuoc.setColumns(10);
		txtMaThuoc.setEnabled(false);
		pInput.add(txtMaThuoc);

		JLabel lblTim_1_1 = new JLabel("Ngày nhập:");
		lblTim_1_1.setForeground(new Color(255, 255, 255));
		lblTim_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTim_1_1.setBounds(333, 30, 115, 15);
		pInput.add(lblTim_1_1);

		cbbLoai = new JComboBox<String>();
		cbbLoai.setBounds(756, 25, 200, 25);
		pInput.add(cbbLoai);

		txtTenThuoc = new JTextField();
		txtTenThuoc.setColumns(10);
		txtTenThuoc.setBounds(116, 60, 175, 25);
		pInput.add(txtTenThuoc);

		JLabel lblTenThuoc = new JLabel("Tên thuốc :");
		lblTenThuoc.setForeground(new Color(255, 255, 255));
		lblTenThuoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenThuoc.setBounds(10, 65, 115, 15);
		pInput.add(lblTenThuoc);

		JLabel lblSoLuongNhap = new JLabel("Số lượng nhập :");
		lblSoLuongNhap.setForeground(new Color(255, 255, 255));
		lblSoLuongNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoLuongNhap.setBounds(10, 100, 115, 15);
		pInput.add(lblSoLuongNhap);

		txtSoLuongNhap = new JTextField();
		txtSoLuongNhap.setColumns(10);
		txtSoLuongNhap.setBounds(116, 95, 175, 25);
		pInput.add(txtSoLuongNhap);

		JLabel lblSoLuongTon = new JLabel("Số lượng tồn:");
		lblSoLuongTon.setForeground(new Color(255, 255, 255));
		lblSoLuongTon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoLuongTon.setBounds(10, 135, 115, 15);
		pInput.add(lblSoLuongTon);

		txtSoLuongTon = new JTextField();
		txtSoLuongTon.setColumns(10);
		txtSoLuongTon.setBounds(116, 130, 175, 25);
		pInput.add(txtSoLuongTon);

		JLabel lblTim_1_1_1 = new JLabel("Ngày sản xuất:");
		lblTim_1_1_1.setForeground(new Color(255, 255, 255));
		lblTim_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTim_1_1_1.setBounds(333, 64, 115, 15);
		pInput.add(lblTim_1_1_1);

		JLabel lblTim_1_1_1_1 = new JLabel("Ngày hết hạn:");
		lblTim_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblTim_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTim_1_1_1_1.setBounds(333, 100, 115, 15);
		pInput.add(lblTim_1_1_1_1);

		JLabel lblTim_1_1_1_1_1 = new JLabel("Giá nhập:");
		lblTim_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblTim_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTim_1_1_1_1_1.setBounds(333, 135, 115, 15);
		pInput.add(lblTim_1_1_1_1_1);

		JLabel lblTim_1_1_1_2 = new JLabel("Nhà cung cấp:");
		lblTim_1_1_1_2.setForeground(new Color(255, 255, 255));
		lblTim_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTim_1_1_1_2.setBounds(665, 65, 115, 15);
		pInput.add(lblTim_1_1_1_2);

		JLabel lblTim_1_1_1_2_1 = new JLabel("Loại thuốc:");
		lblTim_1_1_1_2_1.setForeground(new Color(255, 255, 255));
		lblTim_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTim_1_1_1_2_1.setBounds(665, 30, 115, 15);
		pInput.add(lblTim_1_1_1_2_1);

		cbbNCC = new JComboBox<String>();
		cbbNCC.setBounds(756, 60, 200, 25);
		pInput.add(cbbNCC);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(437, 130, 200, 25);
		pInput.add(txtGiaNhap);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setForeground(new Color(0, 0, 0));
		btnLamMoi.setBackground(new Color(255, 255, 255));
		btnLamMoi.setBounds(665, 95, 120, 30);
		ImageIcon iconLamMoi = new ImageIcon("./image/reset.png");
		Image scaledIcon2 = iconLamMoi.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIconLamMoi = new ImageIcon(scaledIcon2);
		btnLamMoi.setIcon(scaledIconLamMoi);
		pInput.add(btnLamMoi);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setBounds(836, 95, 120, 30);
		ImageIcon iconThem = new ImageIcon("./image/add (1).png");
		Image scaledIcon3 = iconThem.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThem = new ImageIcon(scaledIcon3);
		btnThem.setIcon(scaledIconThem);
		pInput.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setBackground(new Color(255, 255, 255));
		btnXoa.setBounds(665, 130, 120, 30);
		ImageIcon iconXoa = new ImageIcon("./image/delete.png");
		Image scaledIcon4 = iconXoa.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIconXoa = new ImageIcon(scaledIcon4);
		btnXoa.setIcon(scaledIconXoa);
		pInput.add(btnXoa);

		btnCapNhap = new JButton("Sửa");
		btnCapNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCapNhap.setForeground(new Color(0, 0, 0));
		btnCapNhap.setBackground(new Color(255, 255, 255));
		btnCapNhap.setBounds(836, 130, 120, 30);
		ImageIcon iconCapNhap = new ImageIcon("./image/update.png");
		Image scaledIcon5 = iconCapNhap.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIconCapNhap = new ImageIcon(scaledIcon5);
		btnCapNhap.setIcon(scaledIconCapNhap);
		pInput.add(btnCapNhap);

		// hover dđổi màu btn
		changeColorButtonWhenEntered(btnTim);
		changeColorButtonWhenExited(btnTim);
		changeColorButtonWhenEntered(btnThem);
		changeColorButtonWhenExited(btnThem);
		changeColorButtonWhenEntered(btnLamMoi);
		changeColorButtonWhenExited(btnLamMoi);
		changeColorButtonWhenEntered(btnXoa);
		changeColorButtonWhenExited(btnXoa);
		changeColorButtonWhenEntered(btnCapNhap);
		changeColorButtonWhenExited(btnCapNhap);

		txtNgayNhap = new JDateChooser();
		txtNgayNhap.setBounds(437, 25, 200, 25);
		txtNgayNhap.setEnabled(false);
		pInput.add(txtNgayNhap);
		formatDateChooser(txtNgayNhap);

		txtNgaySanXuat = new JDateChooser();
		txtNgaySanXuat.setBounds(437, 60, 200, 25);
		pInput.add(txtNgaySanXuat);
		formatDateChooser(txtNgaySanXuat);
		txtNgayHetHan = new JDateChooser();
		txtNgayHetHan.setBounds(437, 95, 200, 25);
		pInput.add(txtNgayHetHan);
		formatDateChooserNgayHetHan(txtNgayHetHan);

		try {
			
			ConnectDB.getInstance().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lt = new Dao_LoaiThuoc();
		ncc = new Dao_nhaCungCap();
		dsThuoc = new Dao_Thuoc();
		DocDuLieuDatabaseVaoTable();
		DocDuLieuVaoCBB();

		btnTim.addActionListener(this);
		btnCapNhap.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		table.addMouseListener(this);
		lamMoi();

	}

	public void changeColorButtonWhenEntered(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btn.isEnabled()) {
					btn.setBackground(Color.GREEN);
				}
			}
		});
	}

	/*
	 * Đổi màu cho button khi trỏ chuột ra khỏi button
	 */
	public void changeColorButtonWhenExited(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if (btn.isEnabled()) {
					btn.setBackground(Color.WHITE);
				}
			}
		});
	}

	/**
	 * Định dạng cho DateChooser
	 * 
	 * @param dC : dateChooser cần định dạng
	 */
	public void formatDateChooser(JDateChooser dC) {
		dC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dC.setOpaque(false);
		((JTextField) dC.getDateEditor().getUiComponent()).setEditable(false);
		dC.setBorder(new LineBorder(new Color(122, 138, 153)));
		dC.setDateFormatString("y-M-d");
		dC.setDate(new Date(System.currentTimeMillis()));
		dC.setMaxSelectableDate(new Date(System.currentTimeMillis()));
		((JTextField) dC.getDateEditor().getUiComponent()).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dC.getCalendarButton().doClick();
			}
		});
	}
	public void formatDateChooserNgayHetHan(JDateChooser dC) {
		dC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dC.setOpaque(false);
		((JTextField) dC.getDateEditor().getUiComponent()).setEditable(false);
		dC.setBorder(new LineBorder(new Color(122, 138, 153)));
		dC.setDateFormatString("y-M-d");
		
		((JTextField) dC.getDateEditor().getUiComponent()).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dC.getCalendarButton().doClick();
			}
		});
	}

	// Sự kiện//////////////////////////////////////////////////////////////////////
	public void lamMoi() {
		txtMaThuoc.setText("");
		txtTenThuoc.setText("");
		txtGiaNhap.setText("");
		txtSoLuongNhap.setText("");
		txtSoLuongTon.setText("");
		txtNgayNhap.setDate(new Date(System.currentTimeMillis()));
		txtNgaySanXuat.setDate(null);
		txtNgayHetHan.setDate(null);
		txtTim.setText("");
		cbbLoai.setSelectedIndex(0);
		cbbNCC.setSelectedIndex(0);
		txtMaThuoc.requestFocus();
		dm.setRowCount(0);
		DocDuLieuDatabaseVaoTable();
	}

	public void tim() {
		String tim = txtTim.getText().trim();
		List<Thuoc> list = dsThuoc.getThuocTheoMa(txtTim.getText());
		if (tim.isEmpty())
			showMessage( "Vui lòng nhập mã thuốc cần tìm!!!");
		else if(!(tim.length()>0&&tim.matches("^(TT)\\d{5}$")))
			showMessage("Mã thuốc phải gồm 7 ký tự,bắt đầu bằng TT và theo sau là 5 số :\nVD(TT00000)");
		else if (list.size() == 0) {
			showMessage( "Không tìm thấy :" + tim);
		} else {
			loaiThuoc loai = new loaiThuoc();
			nhaCungCap tenNCC = new nhaCungCap();
			dm.getDataVector().removeAllElements();
			for (Thuoc thuoc : list) {
				if (thuoc.isHienthi() == true) {
					loai = lt.getLoaiThuocTheoMa(thuoc.getLoaiThuoc().getMaLoai());
					tenNCC = ncc.getNhaCCTheoMa(thuoc.getTenNCC().getMaNCC());
					dm.addRow(new Object[] { thuoc.getMa(), thuoc.getTen(), loai.getTenLoai(), thuoc.getGiaNhap(),
							thuoc.getNgayNhap(), thuoc.getNsx(), thuoc.getNhh(), thuoc.getSoLuongNhap(),
							thuoc.getSoLuongTon(), tenNCC.getTenNCC() });
				}
			}
		}
		table.setModel(dm);

	}

	private void xoa() {
		// TODO Auto-generated method stub

		int r = table.getSelectedRow();
		if(r<0)
		{
			showMessage("Vui lòng chọn dòng cần xóa!!");
		}
		int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa thuốc này..",
				"Xóa", JOptionPane.YES_NO_OPTION);
		if(option ==JOptionPane.YES_OPTION){
			if(r>=0) {
			String maThuoc = (String) table.getValueAt(r, 0);
			if (dsThuoc.deleteThuoc(maThuoc)) {

				dm.removeRow(r);
				dm.setRowCount(0);
				DocDuLieuDatabaseVaoTable();
				JOptionPane.showMessageDialog(this, "Xóa thuốc thành công!!!");

			}
		}}
	}

	private void sua() {
		// TODO Auto-generated method stub
		
		int row = table.getSelectedRow();
		if(row ==-1)
		{
			showMessage("Vui lòng chọn dòng cần sửa!!");
		}
		if (row >= 0) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngayNhap = dateFormat.format(txtNgayNhap.getDate());
			String ngaySX = dateFormat.format(txtNgaySanXuat.getDate());
			String ngayHH = dateFormat.format(txtNgayHetHan.getDate());
				Thuoc t = reverSPFromTextFieldUpdate();
				if(validData()) {
					if (dsThuoc.updateThuoc(t)) {
						
						table.setValueAt(txtTenThuoc.getText(), row, 1);
						table.setValueAt(cbbLoai.getSelectedItem().toString(), row, 2);
						table.setValueAt(txtGiaNhap.getText(), row, 3);
						table.setValueAt(ngayNhap, row, 4);
						table.setValueAt(ngaySX, row, 5);
						table.setValueAt(ngayHH, row, 6);
						table.setValueAt(txtSoLuongNhap.getText(), row, 7);
						table.setValueAt(txtSoLuongTon.getText(), row,8);
						table.setValueAt(cbbNCC.getSelectedItem().toString(), row, 9);
						
						JOptionPane.showMessageDialog(this, "Sửa thành công!!!");
					} else {
						showMessage( "Sửa không thành công!!");
					}
				}
				
			
		}
		
	}
	public boolean validData() {
		if ( txtTenThuoc.getText()=="" || txtGiaNhap.getText().equals("") || txtSoLuongNhap.getText().equals("")|| txtSoLuongTon.getText()=="" 
				||txtNgayNhap.getDate().equals("")||txtNgaySanXuat.getDate().equals("")||txtNgayHetHan.getDate().equals("")) {
			
			showMessage("Vui lòng điền đầy đủ thông tin còn thiếu.");
			return false;
		}
		String tenThuoc = txtTenThuoc.getText().trim();
		double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		int soLuongNhap = Integer.parseInt(txtSoLuongNhap.getText());
		int soLuongTon = Integer.parseInt(txtSoLuongTon.getText());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String ngayNhap = dateFormat.format(txtNgayNhap.getDate());
		String ngaySX = dateFormat.format(txtNgaySanXuat.getDate());
		String ngayHH = dateFormat.format(txtNgayHetHan.getDate());

		
		if (!(tenThuoc.length() > 0 && tenThuoc.matches("^[\\p{L}\\p{N} ]+$"))) {
			showMessage("Tên thuốc không được chứa kí tự đặc biệt!! Ví dụ : Aspirin; Aspirin 11");
			txtTenThuoc.selectAll();
			txtTenThuoc.requestFocus();
			return false;
		}
		if (!(giaNhap > 0)) {
			showMessage("Nhập sai Giá nhập(Giá nhập > 0) . Vui Lòng Nhập Lại !!");
			txtGiaNhap.selectAll();
			txtGiaNhap.requestFocus();
			return false;
		}
		if (!(soLuongNhap > 0)) {
			showMessage("Nhập sai Số lượng nhập( Số lượng nhập > 0) . Vui Lòng Nhập Lại !!");
			txtSoLuongNhap.selectAll();
			txtSoLuongNhap.requestFocus();
			return false;
		}
		if (!(soLuongTon > 0)) {
			showMessage("Nhập sai Số lượng nhập( Số lượng nhập > 0) . Vui Lòng Nhập Lại !!");
			txtSoLuongTon.selectAll();
			txtSoLuongTon.requestFocus();
			return false;
		}
		if(ngaySX.compareTo(ngayHH)>0) {
			showMessage("Ngày sản xuất phải trước ngày hết hạn!!");
			txtNgayHetHan.setDate(null);
			txtNgayHetHan.requestFocus();
			return false;
		}
		return true;
	}

	private void them() {
		// TODO Auto-generated method stub

		if (validData()) {
			dsThuoc = new Dao_Thuoc();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			int stt = table.getRowCount() + 1;
			Thuoc t = reverSPFromTextField();
			loai = new loaiThuoc();
			maNCC = new nhaCungCap();
			loai = lt.getLoaiThuocTheoTen(t.getLoaiThuoc().getTenLoai());
			maNCC = ncc.getNhaCCTheoTen(t.getTenNCC().getTenNCC());
			String ngayNhap = dateFormat.format(txtNgayNhap.getDate());
			String ngaySX = dateFormat.format(txtNgaySanXuat.getDate());
			String ngayHH = dateFormat.format(txtNgayHetHan.getDate());
		
			if (dsThuoc.createThuoc(t)) {
//				String loaiThuoc = cbbLoai.getSelectedItem().toString();
//				String nhaCC = cbbNCC.getSelectedItem().toString();
				
				
				String[] data = { sinhMa(new Dao_Thuoc().getalltbThuoc().size()), txtTenThuoc.getText() + "", cbbLoai.getSelectedItem().toString() + "",
						txtGiaNhap.getText() + "", ngayNhap + "", ngaySX + "", ngayHH + "",
						txtSoLuongNhap.getText() + "", txtSoLuongTon.getText() + "",cbbNCC.getSelectedItem().toString()  + "" };
				dm.addRow(data);
				JOptionPane.showMessageDialog(this, "Thêm thuốc Thành Công !");
				table.setRowSelectionInterval(stt - 1, stt - 1);
			} else {
				showMessage( "Thêm không thành công!!");
			}
		}

	}


	public void showMessage(String mess) {
		JOptionPane.showMessageDialog(this, mess, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaThuoc.setText(table.getValueAt(row, 0).toString());
		txtTenThuoc.setText(table.getValueAt(row, 1).toString());
		cbbLoai.setSelectedItem(table.getValueAt(row, 2).toString());
		txtGiaNhap.setText(table.getValueAt(row, 3).toString());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(dm.getValueAt(row, 4).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtNgayNhap.setDate(date);
		Date date1 = null;
		try {
			date1 = format.parse(dm.getValueAt(row, 5).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtNgaySanXuat.setDate(date1);
		Date date2 = null;
		try {
			date2 = format.parse(dm.getValueAt(row, 6).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtNgayHetHan.setDate(date2);
		txtSoLuongNhap.setText(table.getValueAt(row, 7).toString());
		txtSoLuongTon.setText(table.getValueAt(row, 8).toString());
		cbbNCC.setSelectedItem(table.getValueAt(row, 9).toString());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnLamMoi))
			
			lamMoi();
		else if (o.equals(btnXoa)) {
			xoa();
		} else if (o.equals(btnTim)) {
			tim();
		} else if (o.equals(btnCapNhap)) {
			sua();
		} else if (o.equals(btnThem)) {
			them();
		}
	}

	// đọc dữ liệu vào table
	public void DocDuLieuDatabaseVaoTable() {

		List<Thuoc> list = dsThuoc.getalltbThuoc();
		loaiThuoc loai = new loaiThuoc();
		nhaCungCap tenNCC = new nhaCungCap();
		for (Thuoc thuoc : list) {
			if (thuoc.isHienthi() == true) {
				loai = lt.getLoaiThuocTheoMa(thuoc.getLoaiThuoc().getMaLoai());
				tenNCC = ncc.getNhaCCTheoMa(thuoc.getTenNCC().getMaNCC());
				dm.addRow(new Object[] { thuoc.getMa(), thuoc.getTen(), loai.getTenLoai(), thuoc.getGiaNhap(),
						thuoc.getNgayNhap(), thuoc.getNsx(), thuoc.getNhh(), thuoc.getSoLuongNhap(),
						thuoc.getSoLuongTon(), tenNCC.getTenNCC() });
				
			}
			
		}

	}

	public void DocDuLieuVaoCBB() {
		List<nhaCungCap> listncc = ncc.getallNhaCungCap();
		for (nhaCungCap t : listncc) {
			cbbNCC.addItem(t.getTenNCC());
		}
		List<loaiThuoc> listlt = lt.getallLoaiThuoc();
		for (loaiThuoc t : listlt) {
			cbbLoai.addItem(t.getTenLoai());
		}
	}

	public Thuoc reverSPFromTextFieldUpdate() {
		String ma = txtMaThuoc.getText().trim();
		String tenThuoc = txtTenThuoc.getText().toString();
		double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		Date ngayNhap = txtNgayNhap.getDate();
		Date ngaySX = txtNgaySanXuat.getDate();
		Date ngayHH = txtNgayHetHan.getDate();
		int soLuongNhap = Integer.parseInt(txtSoLuongNhap.getText());
		int soLuongTon = Integer.parseInt(txtSoLuongTon.getText());
		String loai = cbbLoai.getSelectedItem().toString();
		String NCC = cbbNCC.getSelectedItem().toString();
		Boolean hienThi = true;

		return new Thuoc(ma, tenThuoc, ngaySX, ngayHH, ngayNhap,giaNhap , new loaiThuoc(loai), new nhaCungCap(NCC), hienThi, soLuongTon, soLuongNhap);
	}
	public Thuoc reverSPFromTextField() {
		String ma = sinhMa(new Dao_Thuoc().getalltbThuoc().size()+1);
		String tenThuoc = txtTenThuoc.getText().toString();
		double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		Date ngayNhap = txtNgayNhap.getDate();
		Date ngaySX = txtNgaySanXuat.getDate();
		Date ngayHH = txtNgayHetHan.getDate();
		int soLuongNhap = Integer.parseInt(txtSoLuongNhap.getText());
		int soLuongTon = Integer.parseInt(txtSoLuongTon.getText());
		String loai1 = cbbLoai.getSelectedItem().toString();
		String NCC = cbbNCC.getSelectedItem().toString();
		Boolean hienThi = true;
		loaiThuoc loai = lt.getLoaiThuocTheoTen(loai1);
		nhaCungCap nhaNCC = ncc.getNhaCCTheoTen(NCC);
		System.out.println(loai.toString());
		System.out.println(nhaNCC.toString());
		return new Thuoc(ma, tenThuoc, ngaySX, ngayHH, ngayNhap,giaNhap , loai, nhaNCC, hienThi, soLuongTon, soLuongNhap);
	}

	public String sinhMa(int i) {
		if(i<10&&i>0)
			return "TT0000"+i;
		else if(i>=10&&i<100)
			return "TT000"+i;
		else if(i>=100&&i<1000)
			return "TT00"+i;
		else if(i>=1000&&i<10000)
			return "TT0"+i;
		else if(i>=10000&&i<100000)
			return "TT"+i;
		else return null;
	}
}
