package Gui;


import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.Dao_CTHoaDon;
import Dao.Dao_HoaDon;
import Dao.Dao_LoaiThuoc;
import Dao.Dao_Thuoc;
import Dao.Dao_nhaCungCap;
import Entity.HoaDon;
import Entity.Thuoc;
import Entity.loaiThuoc;
import Entity.nhaCungCap;

import com.toedter.calendar.JDateChooser;

public class Gui_BaoCao extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSachMoi;
	private JButton btnSapHet;
	private JButton btnHetHan;
	private JButton btnDoanhThu;
	private JTable tbl_ThongKe;
	private ImageIcon img;
	private ImageIcon img2;
	private Image im;
	private DefaultTableModel dfm;
	private nhaCungCap ncc;
	private Dao_Thuoc dao_Thuoc = new Dao_Thuoc();
	private Dao_nhaCungCap dao_ncc = new Dao_nhaCungCap();
	private Dao_LoaiThuoc dao_loai = new Dao_LoaiThuoc();
	private Dao_HoaDon dao_hd = new Dao_HoaDon();
	private Dao_CTHoaDon dao_cthd = new Dao_CTHoaDon();
	private JDateChooser dateStar;
	private JPanel pn_Table;
	private JScrollPane jcro;
	private String ngayChon;

	public Gui_BaoCao() {

		getContentPane().setLayout(null);

		JPanel pn_Main = new JPanel();
		pn_Main.setBackground(new Color(0, 100, 0));
		pn_Main.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 0), 2),
				"Th\u1ED1ng K\u00EA - B\u00E1o C\u00E1o", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		pn_Main.setBounds(0, 0, 984, 661);
		getContentPane().add(pn_Main);
		pn_Main.setLayout(null);

		JPanel pn_Date = new JPanel();
		pn_Date.setBackground(new Color(255, 255, 255));
		pn_Date.setBorder(new LineBorder(new Color(0, 255, 0), 3));
		pn_Date.setBounds(343, 24, 631, 171);
		pn_Main.add(pn_Date);
		pn_Date.setLayout(null);

		dateStar = new JDateChooser();
		dateStar.setBackground(Color.WHITE);
		dateStar.setForeground(new Color(0, 100, 0));
		dateStar.setBounds(339, 80, 188, 58);
		pn_Date.add(dateStar);
		formatDateChooser(dateStar);
		JLabel lbl_Star = new JLabel("Ngày Bắt Đầu");
		lbl_Star.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Star.setForeground(Color.GREEN);
		lbl_Star.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_Star.setBounds(251, 11, 338, 58);
		pn_Date.add(lbl_Star);

		btnDoanhThu = new JButton("Doanh Thu");
		btnDoanhThu.setBackground(Color.WHITE);
		btnDoanhThu.setBounds(80, 24, 167, 45);
		pn_Date.add(btnDoanhThu);
		changeColorButtonWhenEntered(btnDoanhThu);
		changeColorButtonWhenExited(btnDoanhThu);
		img = new ImageIcon("./image/doanhthu.jfif");
		im = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnDoanhThu.setIcon(img2);

		btnSachMoi = new JButton("Thuốc Mới");
		btnSachMoi.setBackground(Color.WHITE);
		btnSachMoi.setBounds(80, 115, 167, 45);
		pn_Date.add(btnSachMoi);
		changeColorButtonWhenEntered(btnSachMoi);
		changeColorButtonWhenExited(btnSachMoi);
		img = new ImageIcon("./image/vienthuoc.jpg");
		im = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnSachMoi.setIcon(img2);
		btnSachMoi.addActionListener(this);
		btnDoanhThu.addActionListener(this);

		JPanel pn_ChucNang = new JPanel();
		pn_ChucNang.setBackground(new Color(255, 255, 255));
		pn_ChucNang.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255), 4),
				"Lo\u1EA1i Th\u1ED1ng K\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		pn_ChucNang.setBounds(10, 24, 323, 171);
		pn_Main.add(pn_ChucNang);
		pn_ChucNang.setLayout(null);
		img = new ImageIcon("./image/doanhthu.jfif");
		im = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		img = new ImageIcon("./image/thuoc.png");
		im = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);

		btnSapHet = new JButton("Sắp Hết");
		btnSapHet.setBackground(Color.WHITE);
		btnSapHet.setBounds(62, 115, 167, 45);
		pn_ChucNang.add(btnSapHet);
		changeColorButtonWhenEntered(btnSapHet);
		changeColorButtonWhenExited(btnSapHet);
		img = new ImageIcon("./image/Thuốc.jfif");
		im = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnSapHet.setIcon(img2);

		btnHetHan = new JButton("Sắp hết hạn");
		btnHetHan.setBackground(Color.WHITE);
		btnHetHan.setBounds(62, 30, 167, 45);
		pn_ChucNang.add(btnHetHan);
		changeColorButtonWhenEntered(btnHetHan);
		changeColorButtonWhenExited(btnHetHan);
		img = new ImageIcon("./image/loThuoc.png");
		im = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnHetHan.setIcon(img2);
		btnHetHan.addActionListener(this);
		btnSapHet.addActionListener(this);

		pn_Table = new JPanel();
		pn_Table.setBackground(new Color(255, 255, 255));
		pn_Table.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		pn_Table.setBounds(10, 206, 964, 444);
		pn_Main.add(pn_Table);
		pn_Table.setLayout(null);

		tbl_ThongKe = new JTable();
		tbl_ThongKe.setFillsViewportHeight(true);
		jcro = new JScrollPane();
		jcro.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jcro.setBounds(0, 0, 964, 444);
		pn_Table.add(jcro);
		jcro.setViewportView(tbl_ThongKe);
		this.setSize(1000, 700);
		DoanhThu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void formatButton(JButton btn, String img) {
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBorder(new LineBorder(Color.cyan, 2, true));
		btn.setBackground(Color.blue);
		btn.setMargin(new Insets(2, 0, 2, 14));
		btn.setFocusable(false);
		btn.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		((JTextField) dC.getDateEditor().getUiComponent()).setEnabled(false);
		;
		((JTextField) dC.getDateEditor().getUiComponent()).setHorizontalAlignment((int) CENTER_ALIGNMENT);
		dC.setBorder(new LineBorder(new Color(122, 138, 153), 3));
		dC.setDateFormatString("d-M-y");
		dC.setDate(new Date(System.currentTimeMillis()));
		dC.setMaxSelectableDate(new Date(System.currentTimeMillis()));
		((JTextField) dC.getDateEditor().getUiComponent()).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dC.getCalendarButton().doClick();
			}
		});
	}

	public void sapHet() {
		tbl_ThongKe.setModel(dfm = new DefaultTableModel(new Object[][] {}, new String[] { "mã thuốc", "tên thuốc",
				"số lượng tồn", "tên loại", "ngày hết hạn", "tên nhà cung cấp", "sdt NCC", "địa chỉ NCC" }));
		ArrayList<Thuoc> list = dao_Thuoc.getalltbThuocSapHet();

		for (Thuoc thuoc : list) {
			if (thuoc.isHienthi() == true) {
				loaiThuoc loai = dao_loai.gettheoMa(thuoc.getLoaiThuoc().getMaLoai());
				ncc = dao_ncc.getNCCtheoMa(thuoc.getTenNCC().getMaNCC());
				dfm.addRow(new Object[] { thuoc.getMa(), thuoc.getTen(), thuoc.getSoLuongTon(), loai.getTenLoai(),
						thuoc.getNhh(), ncc.getTenNCC(), ncc.getSoDienThoai(), ncc.getDiaChi() });
			}
		}
	}

	public void HetHan() {
		tbl_ThongKe.setModel(dfm = new DefaultTableModel(new Object[][] {}, new String[] { "mã thuốc", "tên thuốc",
				"số lượng tồn", "tên loại", "ngày hết hạn", "tên nhà cung cấp", "sdt NCC", "địa chỉ NCC" }));
		ArrayList<Thuoc> list = dao_Thuoc.getalltbThuocSapHetHan();

		for (Thuoc thuoc : list) {
			if (thuoc.isHienthi() == true) {
				ncc = dao_ncc.getNCCtheoMa(thuoc.getTenNCC().getMaNCC());
				loaiThuoc loai = dao_loai.gettheoMa(thuoc.getLoaiThuoc().getMaLoai());
				dfm.addRow(new Object[] { thuoc.getMa(), thuoc.getTen(), thuoc.getSoLuongTon(), loai.getTenLoai(),
						thuoc.getNhh(), ncc.getTenNCC(), ncc.getSoDienThoai(), ncc.getDiaChi() });
			}
		}
	}

	public void Moi() {
		tbl_ThongKe.setModel(dfm = new DefaultTableModel(new Object[][] {}, new String[] { "mã thuốc", "tên thuốc",
				"số lượng tồn", "tên loại", "ngày nhập", "tên nhà cung cấp", "sdt NCC", "địa chỉ NCC" }));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ngayChon = dateFormat.format(dateStar.getDate());
			ArrayList<Thuoc> list = dao_Thuoc.getalltbThuocMoi(ngayChon);
			for (Thuoc thuoc : list) {
				if (thuoc.isHienthi() == true) {
					loaiThuoc loai = dao_loai.gettheoMa(thuoc.getLoaiThuoc().getMaLoai());
					ncc = dao_ncc.getNCCtheoMa(thuoc.getTenNCC().getMaNCC());
					dfm.addRow(new Object[] { thuoc.getMa(), thuoc.getTen(), thuoc.getSoLuongTon(), loai.getTenLoai(),
							thuoc.getNgayNhap(), ncc.getTenNCC(), ncc.getSoDienThoai(), ncc.getDiaChi() });
				}
			}
		
	}

	public void DoanhThu() {
		Locale locale = new Locale("vi", "VN");
		NumberFormat cur = NumberFormat.getCurrencyInstance(locale);
		tbl_ThongKe.setModel(dfm = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Hóa Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Ngày Lập", "Thành Tiền" }));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ngayChon = dateFormat.format(dateStar.getDate());
		ArrayList< HoaDon> list = dao_hd.getallHoaDontheoNgay(ngayChon);
		for(HoaDon hd :list) {
			dfm.addRow(new Object[] {hd.getMaHD(),hd.getMaNV(),hd.getMaKH(),hd.getNgayLap(),cur.format(dao_cthd.gettienHoaDontheoMa(hd.getMaHD()))});
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnSapHet))
			sapHet();
		else if (o.equals(btnDoanhThu))
			DoanhThu();
		else if (o.equals(btnHetHan))
			HetHan();
		else if (o.equals(btnSachMoi))
			Moi();

	}
}
