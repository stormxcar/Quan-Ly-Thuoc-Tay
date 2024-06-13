package Gui;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.Dao_CTHoaDon;
import Dao.Dao_HoaDon;
import Dao.Dao_KhachHang;
import Dao.Dao_LoaiThuoc;
import Dao.Dao_NhanVien;
import Dao.Dao_Thuoc;
import Dao.Dao_nhaCungCap;
import Entity.CT_HoaDon;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.Thuoc;
import Entity.loaiThuoc;
import Entity.nhaCungCap;

import java.awt.LayoutManager;


import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;

public class Gui_HoaDon extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	private JTable tblThuoc;
//	private JTextField txtTongTien;
	private JTable tblChiTiet;
	private DefaultTableModel tblModelChiTiet = new DefaultTableModel();
//	private JComboBox cmbTim;
//	private JRadioButton radMaHD;
//	private DefaultComboBoxModel cboModetenKH = new DefaultComboBoxModel();
//	private DefaultComboBoxModel cboModetenNV = new DefaultComboBoxModel();
//	private List<String> listCTHD = new ArrayList<String>();
//	private DefaultComboBoxModel cboModema = new DefaultComboBoxModel();
//	private List<String> listma = new ArrayList<String>();
//	private DefaultComboBoxModel cboModeNgayLap = new DefaultComboBoxModel();
//	private List<String> listNgayLap = new ArrayList<String>();
	private JButton btnNhap;
	private JDialog dialog;
//	private JComponent txtTen;
	private JTextField txtTim;
	private Dao_HoaDon dao_hd = new Dao_HoaDon();
	private Dao_CTHoaDon dao_cthd = new Dao_CTHoaDon();
	private Dao_Thuoc dao_thuoc = new Dao_Thuoc();
	private Dao_KhachHang dao_kh = new Dao_KhachHang();
	private Dao_NhanVien dao_nhanvien = new Dao_NhanVien();
	private JButton btnMoi;
	private JButton btnTimKiem;
	private ImageIcon img;
	private Image im;

	private ImageIcon img2;
	private JButton btnThem;
	private nhaCungCap ncc;
	private Dao_nhaCungCap dao_ncc = new Dao_nhaCungCap();
	private Dao_LoaiThuoc dao_loai = new Dao_LoaiThuoc();
	private DefaultTableModel tblModelThuoc;
//	private JTextField txtMaKH;
	private JTextField txtTenKh;
	private JTextField txtSDTKH;
	private JTextField txtDCKh;
	private JTextField txtemailKh;
	private KhachHang kh=null;
	private int soThuoc;
	private String maNV = Gui_DangNhap.getMaNV();
	private JTextField txt_Tien;
	private double Tongtien = 0;
	private JButton btn_XemHD;
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Gui_HoaDon() {
		setType(Type.POPUP);
		setResizable(false);
		this.setSize(1000, 700);
		setForeground(new Color(176, 224, 230));
		setBackground(new Color(176, 224, 230));
		setTitle(" Quản lý nhà thuốc ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlThongTinHD = new JPanel();
		pnlThongTinHD.setBackground(Color.WHITE);
		pnlThongTinHD.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin Kh\u00E1ch h\u00E0ng", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(255, 0, 0)));
		pnlThongTinHD.setBounds(10, 52, 375, 118);
		contentPane.add(pnlThongTinHD);
		pnlThongTinHD.setLayout(null);

		JLabel lblNhanVien = new JLabel("Khách Hàng:");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNhanVien.setBounds(26, 46, 122, 30);
		pnlThongTinHD.add(lblNhanVien);

		btnNhap = new JButton("Nhập");
		btnNhap.setBackground(Color.WHITE);
		btnNhap.setBounds(194, 48, 112, 33);
		pnlThongTinHD.add(btnNhap);
		btnNhap.addActionListener(this);
		changeColorButtonWhenEntered(btnNhap);
		changeColorButtonWhenExited(btnNhap);
		img = new ImageIcon("./image/user.png");
		im = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnNhap.setIcon(img2);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 2), "Tim ki\u1EBFm",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		pnlChucNang.setBackground(Color.WHITE);
		pnlChucNang.setBounds(10, 591, 595, 62);
		contentPane.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(Color.WHITE);
		pnlTimKiem.setBounds(10, 10, 572, 41);
		pnlChucNang.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(429, 11, 136, 30);
		pnlTimKiem.add(btnTimKiem);
		btnTimKiem.setBackground(Color.white);
		btnTimKiem.addActionListener(this);
		changeColorButtonWhenEntered(btnTimKiem);
		changeColorButtonWhenExited(btnTimKiem);
		img = new ImageIcon("./image/search.png");
		im = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnTimKiem.setIcon(img2);

		JLabel lblNhpThngTin = new JLabel("Nhập thông tin tìm kiếm:");
		lblNhpThngTin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNhpThngTin.setBounds(10, 10, 162, 30);
		pnlTimKiem.add(lblNhpThngTin);

		txtTim = new JTextField();
		txtTim.setBounds(167, 14, 252, 26);
		pnlTimKiem.add(txtTim);
		txtTim.setColumns(10);
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		pnlTitle.setBackground(new Color(0, 128, 64));
		pnlTitle.setBounds(0, 0, 1300, 53);
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(null);

		JLabel lblQunLNhn = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblQunLNhn.setBackground(new Color(0, 128, 64));
		lblQunLNhn.setForeground(new Color(255, 255, 255));
		lblQunLNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblQunLNhn.setBounds(10, -3, 965, 47);
		pnlTitle.add(lblQunLNhn);

		btn_XemHD = new JButton("Xem Hóa Đơn");
		btn_XemHD.setBackground(Color.WHITE);
		btn_XemHD.setBounds(788, 9, 184, 33);
		pnlTitle.add(btn_XemHD);
		changeColorButtonWhenEntered(btn_XemHD);
		changeColorButtonWhenExited(btn_XemHD);
		img = new ImageIcon("./image/anh2-1695.jpg");
		im = img.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btn_XemHD.setIcon(img2);
		btn_XemHD.addActionListener(this);

		JPanel pnlThuoc = new JPanel();
		pnlThuoc.setLayout(null);
		pnlThuoc.setForeground(Color.BLACK);
		pnlThuoc.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách Thuốc  ",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnlThuoc.setBackground(Color.WHITE);
		pnlThuoc.setBounds(10, 290, 964, 291);
		contentPane.add(pnlThuoc);

		JScrollPane scrDanhSach = new JScrollPane();
		scrDanhSach.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrDanhSach.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrDanhSach.setBounds(12, 25, 952, 256);
		pnlThuoc.add(scrDanhSach);
		String[] col = { "Mã thuốc ", "Tên thuốc ", "Ngày hết hạn", "Ngày nhập", "Loại thuốc", " TênNCC",
				"Số lượng tồn", "Đơn giá" };
		tblModelThuoc = new DefaultTableModel(col, 0);
		tblThuoc = new JTable(tblModelThuoc);
		tblThuoc.setFillsViewportHeight(true);
		tblThuoc.addMouseListener(this);
		scrDanhSach.setViewportView(tblThuoc);

		JPanel pnlChiTiet = new JPanel();
		pnlChiTiet.setBackground(Color.WHITE);
		pnlChiTiet.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin chi tiết hoá đơn ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		pnlChiTiet.setBounds(395, 52, 579, 226);
		contentPane.add(pnlChiTiet);
		pnlChiTiet.setLayout(null);

		JScrollPane scrChiTiet = new JScrollPane();
		scrChiTiet.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrChiTiet.setBounds(10, 22, 559, 199);
		pnlChiTiet.add(scrChiTiet);
		String[] col2 = { "Mã Thuốc", "Tên thuốc ", "Số lượng", "Đơn giá", "Thành tiền" };
		tblModelChiTiet = new DefaultTableModel(col2, 0);
		tblChiTiet = new JTable(tblModelChiTiet);
		tblChiTiet.setFillsViewportHeight(true);
		scrChiTiet.setViewportView(tblChiTiet);

		JPanel pnL_TongTien = new JPanel();
		pnL_TongTien.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		pnL_TongTien.setBackground(new Color(255, 255, 255));
		pnL_TongTien.setBounds(10, 181, 375, 98);
		contentPane.add(pnL_TongTien);
		pnL_TongTien.setLayout(null);

		JLabel lblTien = new JLabel("Tổng Tiền: ");
		lblTien.setBounds(29, 44, 118, 22);
		lblTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnL_TongTien.add(lblTien);

		txt_Tien = new JTextField();
		txt_Tien.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		txt_Tien.setBackground(Color.WHITE);
		txt_Tien.setEnabled(false);
		txt_Tien.setBounds(132, 26, 214, 43);
		pnL_TongTien.add(txt_Tien);
		txt_Tien.setColumns(10);

		JPanel pnl_ChucNang = new JPanel();
		pnl_ChucNang.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		pnl_ChucNang.setBackground(new Color(255, 255, 255));
		pnl_ChucNang.setBounds(615, 594, 359, 59);
		contentPane.add(pnl_ChucNang);
		pnl_ChucNang.setLayout(null);

		btnMoi = new JButton("Làm mới");
		btnMoi.setBounds(10, 11, 167, 37);
		pnl_ChucNang.add(btnMoi);
		changeColorButtonWhenEntered(btnMoi);
		changeColorButtonWhenExited(btnMoi);
		btnMoi.setBackground(Color.white);
		img = new ImageIcon("./image/exit.png");
		im = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnMoi.setIcon(img2);
		btnThem = new JButton("Thêm HD");
		btnThem.setBounds(187, 11, 151, 37);
		pnl_ChucNang.add(btnThem);
		changeColorButtonWhenEntered(btnThem);
		changeColorButtonWhenExited(btnThem);
		img = new ImageIcon("./image/add.png");
		im = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnThem.setIcon(img2);
		btnThem.setBackground(Color.white);
		btnMoi.addActionListener(this);
		btnThem.addActionListener(this);
		loadDL();
	}

	public KhachHang model(String ma) {
		dao_kh = new Dao_KhachHang();
		dialog = new JDialog(this, "Thêm mới", true);
		dialog.setSize(350, 300);
		dialog.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel pTen = new JPanel();
		JLabel lblTen = new JLabel("Tên:");
		pTen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		lblTen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));
		txtTenKh = new JTextField(16);
		pTen.add(lblTen);
		pTen.add(txtTenKh);
		panel.add(pTen);

		JPanel pSDT = new JPanel();
		JLabel lblSDT = new JLabel("Số Điện Thoại:  ");
		lblSDT.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		pSDT.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		txtSDTKH = new JTextField(16);
		pSDT.add(lblSDT);
		pSDT.add(txtSDTKH);
		panel.add(pSDT);

		JPanel pDC = new JPanel();
		JLabel lblDC = new JLabel("Địa Chỉ:");
		lblDC.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 45));
		pDC.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
		txtDCKh = new JTextField(16);
		pDC.add(lblDC);
		pDC.add(txtDCKh);
		panel.add(pDC);

		JPanel pEmail = new JPanel();
		JLabel lblemail = new JLabel("Email:");
		lblemail.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 55));
		pEmail.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
		txtemailKh = new JTextField(16);
		pEmail.add(lblemail);
		pEmail.add(txtemailKh);
		panel.add(pEmail);

		// Tạo JButton để lưu dữ liệu
		JButton btnSave = new JButton("Lưu");
		btnSave.setPreferredSize(new Dimension(100, 30));
		btnSave.setMargin(new Insets(0, 50, 0, 50));
//		btnSave.setPreferredSize(pmaKH.getPreferredSize());
		changeColorButtonWhenEntered(btnSave);
		changeColorButtonWhenExited(btnSave);
		btnSave.setBackground(Color.white);
		img = new ImageIcon("./image/exit.png");
		im = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnSave.setIcon(img2);
		kh = new KhachHang();
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Lưu dữ liệu vào database
				Object o = e.getSource();
				if (o.equals(btnSave)) {

					if (txtemailKh.getText().equals("") || txtDCKh.getText().equals("") || txtTenKh.getText().equals("")
							|| txtSDTKH.getText().equals(""))

						JOptionPane.showMessageDialog(panel, "Cần điền đủ thông tin");

					else {
						if (regexx()) {
							kh.setMaKH(ma);
							kh.setTenKH(txtTenKh.getText());
							kh.setSdt(txtSDTKH.getText());
							kh.setDiaChi(txtDCKh.getText());
							kh.setEmail(txtemailKh.getText());
							dialog.dispose();
						}

					}
				}
				// Thực hiện lưu dữ liệu vào database ở đây
				// Đóng JDialog

			}
		});

		// Thêm JButton vào JPanel
		panel.add(btnSave);

		// Thêm JPanel vào JDialog
		dialog.getContentPane().add(panel);

		// Hiển thị JDialog
		dialog.setVisible(true);
//		System.out.println(kh.toString());
		return kh;

	}

	public void loadDL() {
		ArrayList<Thuoc> list = dao_thuoc.getalltbThuoc();
		Locale locale = new Locale("vi", "VN");
		NumberFormat cur = NumberFormat.getCurrencyInstance(locale);
		for (Thuoc thuoc : list) {
			if (thuoc.isHienthi() == true) {
				ncc = dao_ncc.getNCCtheoMa(thuoc.getTenNCC().getMaNCC());
				loaiThuoc loai = dao_loai.gettheoMa(thuoc.getLoaiThuoc().getMaLoai());
				tblModelThuoc.addRow(new Object[] { thuoc.getMa(), thuoc.getTen(), thuoc.getNhh(), thuoc.getNgayNhap(),
						loai.getTenLoai(), ncc.getTenNCC(), thuoc.getSoLuongTon(), cur.format(thuoc.giaBan()) });
			}
		}
	}

	public void formatButton(JButton btn, String img) {
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBorder(new LineBorder(Color.green, 2, true));
		btn.setBackground(Color.white);
		btn.setMargin(new Insets(2, 0, 2, 30));
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

	public String sinhMaKH(int i) {
		if (i < 10 && i > 0)
			return "KH0000" + i;
		else if (i >= 10 && i < 100)
			return "KH000" + i;
		else if (i >= 100 && i < 1000)
			return "KH00" + i;
		else if (i >= 1000 && i < 10000)
			return "KH0" + i;
		else if (i >= 10000 && i < 100000)
			return "KH" + i;
		else
			return null;
	}

	public String sinhMaHD(int i) {
		if (i < 10 && i > 0)
			return "HD0000" + i;
		else if (i >= 10 && i < 100)
			return "HD000" + i;
		else if (i >= 100 && i < 1000)
			return "HD00" + i;
		else if (i >= 1000 && i < 10000)
			return "HD0" + i;
		else if (i >= 10000 && i < 100000)
			return "HD" + i;
		else
			return null;
	}

	public void reset() {
		txtTim.setText("");
		kh = null;
		String[] col2 = { "Mã Thuốc", "Tên thuốc ", "Số lượng", "Đơn giá", "Thành tiền" };
		tblModelChiTiet = new DefaultTableModel(col2, 0);
		tblChiTiet.setModel(tblModelChiTiet);
		txt_Tien.setText("");
		Tongtien = 0;
		String[] col = { "Mã thuốc ", "Tên thuốc ", "Ngày hết hạn", "Ngày nhập", "Loại thuốc", " TênNCC",
				"Số lượng tồn", "Đơn giá" };
		tblModelThuoc = new DefaultTableModel(col, 0);
		tblThuoc.setModel(tblModelThuoc);
		loadDL();
	}

	public void Them() {
		if (tblChiTiet.getRowCount() == 0)
			JOptionPane.showMessageDialog(this, "Cần tạo hóa đơn!!");

		else {
			String maHD = sinhMaHD(dao_hd.getsoDong() + 1);
//		System.out.println(maHD);
			HoaDon hd = null;
			if (kh == null)
				kh = dao_kh.getKhachHangtheoMa("0838383838");
			else {
				if (dao_kh.getKhachHangtheoMa(kh.getSdt()) == null)
					dao_kh.creat(kh);
				else {
					int hoi = JOptionPane.showConfirmDialog(this,
							"sdt này đã được dùng bạn có muốn sử dụng thông tin cũ?");
					if (hoi == JOptionPane.YES_OPTION)
						kh = dao_kh.getKhachHangtheoMa(kh.getSdt());
					else
						kh = dao_kh.getKhachHangtheoMa("0838383838");
				}
			}

			hd = new HoaDon(maHD, maNV, kh.getMaKH());
//			System.out.println(kh.toString());
//			System.out.println(hd.toString());
			dao_hd.creat(hd);
			for (int i = 0; i < tblChiTiet.getRowCount(); i++) {
				try {
					CT_HoaDon cthd = new CT_HoaDon();
					cthd.setMaHD(maHD);
					String ma = tblModelChiTiet.getValueAt(i, 0).toString();
					cthd.setMaThuoc(ma);
					int soThuoc = Integer.parseInt(tblModelChiTiet.getValueAt(i, 2).toString());
					cthd.setSoLuong(soThuoc);
//					 System.out.println(soThuoc);
					Double dgia = dao_thuoc.getThuoctheoMa(tblModelChiTiet.getValueAt(i, 0).toString()).giaBan();
					cthd.setDonGia(dgia);
//					System.out.println(cthd.toString());
					dao_cthd.creat(cthd);
//					boolean update = dao_thuoc.updatesoThuoc(soThuoc, ma);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					JOptionPane.showMessageDialog(this, "Thêm thất bại!!");
				}
			}
			String[] col = { "Mã thuốc ", "Tên thuốc ", "Ngày hết hạn", "Ngày nhập", "Loại thuốc", " TênNCC",
					"Số lượng tồn", "Đơn giá" };
			tblModelThuoc = new DefaultTableModel(col, 0);
			tblThuoc.setModel(tblModelThuoc);
			loadDL();
			reset();
			JOptionPane.showMessageDialog(this, "Thêm thành công!!");
		}
	}

	public boolean TimKiem() {
		String Tim = txtTim.getText();
		if (Tim.length() <= 0) {
			JOptionPane.showMessageDialog(this, "Cần nhập mã thuốc cần tìm");
			return false;
		}

		else if (!Tim.matches("[T]{2}\\d{5}+$")) {
			JOptionPane.showMessageDialog(this, "nhập sai định dạng (chữ 'TT' đầu và 5 số theo sau)");
			txtTim.selectAll();
			txtTim.requestFocus();
			return false;
		} else {
			String[] col = { "Mã thuốc ", "Tên thuốc ", "Ngày hết hạn", "Ngày nhập", "Loại thuốc", " TênNCC",
					"Số lượng tồn", "Đơn giá" };
			tblModelThuoc = new DefaultTableModel(col, 0);
			tblThuoc.setModel(tblModelThuoc);
			if (txtTim.getText().equals("")) {
				loadDL();
			} else {
				ArrayList<Thuoc> list = dao_thuoc.getalltbThuoctheoMa(txtTim.getText());
				Locale locale = new Locale("vi", "VN");
				NumberFormat cur = NumberFormat.getCurrencyInstance(locale);
				if (list.size() == 0) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy thuốc");
					txtTim.requestFocus();
				} else {
					for (Thuoc thuoc : list) {
						if (thuoc.isHienthi() == true) {
							ncc = dao_ncc.getNCCtheoMa(thuoc.getTenNCC().getMaNCC());
							loaiThuoc loai = dao_loai.gettheoMa(thuoc.getLoaiThuoc().getMaLoai());
							tblModelThuoc.addRow(new Object[] { thuoc.getMa(), thuoc.getTen(), thuoc.getNhh(),
									thuoc.getNgayNhap(), loai.getTenLoai(), ncc.getTenNCC(), thuoc.getSoLuongTon(),
									cur.format(thuoc.giaBan()) });
							return true;
						}
					}
				}
			}
		}

		return true;
	}

	public boolean regexx() {
		String Ten = txtTenKh.getText();
		String sdt = txtSDTKH.getText();
		String diachi = txtDCKh.getText();
		String email = txtemailKh.getText();
		if (!(Ten.length() > 0 && Ten.matches(
				"^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][a-záàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịúùủũụưứừửữựýỳỷỹỵđ]*\\\\s?)+$"))) {
			JOptionPane.showMessageDialog(this, "Nhập sai Tên Nhân Viên . Vui Lòng Nhập Lại ! Ví dụ :Trần Văn An");
			txtTenKh.selectAll();
			txtTenKh.requestFocus();
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("^[0]\\d{9}$"))) {
			JOptionPane.showMessageDialog(this,
					"Nhập sai định dạng Số Điện Thoại. Vui Lòng Nhập Lại ! Ví dụ : 0987654321");
			txtSDTKH.selectAll();
			txtSDTKH.requestFocus();
			return false;
		}
		if (!(email.length() > 0 && email.matches("^[a-zA-Z]+[a-zA-Z0-9]*@[a-zA-Z]+\\.com$"))) {
			JOptionPane.showMessageDialog(this,
					"Nhập sai định dạng Email. Vui Lòng Nhập Lại ! Ví dụ : nguyenkha234@gmail.com");
			txtemailKh.selectAll();
			txtemailKh.requestFocus();
			return false;
		}
		if (!(diachi.length() > 0 && diachi.matches("^.*$"))) {
			JOptionPane.showMessageDialog(this,
					"Vui Lòng Nhập Lại Địa Chỉ ! Ví dụ : 208 Lê Đức thọ, Phường 6, Gò Vấp, TP HCM");
			txtDCKh.selectAll();
			txtDCKh.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnNhap)) {
			model(sinhMaKH(dao_kh.getsoKhachHang() + 1));
		} else if (o.equals(btnMoi))
			reset();
		else if (o.equals(btnThem))
			Them();
		else if (o.equals(btnTimKiem))
			TimKiem();
		else if (o.equals(btn_XemHD)) {
			NhanVien nv = dao_nhanvien.getNhanVientheoMa(maNV);
			if (nv.getChucVu().getMaChucVu().equals("CV002")) {
				JTabbedPane jtabb = Menu_QuanLi.getTabbedPane();
				jtabb.setSelectedIndex(3);
			}
			else {
				JTabbedPane jtabb = Menu_NhanVien.getTabbedPane();
				jtabb.setSelectedIndex(3);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String soLuong = JOptionPane.showInputDialog("Nhập số lượng:");
		Locale locale = new Locale("vi", "VN");
		NumberFormat cur = NumberFormat.getCurrencyInstance(locale);

		try {
			soThuoc = Integer.parseInt(soLuong);
			// System.out.println(soThuoc);
			int so = Integer.parseInt(tblModelThuoc.getValueAt(tblThuoc.getSelectedRow(), 6).toString());
			// System.out.println(so);
			if (soThuoc > so)
				JOptionPane.showMessageDialog(this, "Số lượng tồn không đủ");
			else {
				int n = 0;
				n = tblThuoc.getSelectedRow();
				String ten = tblModelThuoc.getValueAt(n, 1).toString();
				// System.out.println(ten);
				String ma = tblModelThuoc.getValueAt(n, 0).toString();
				Double dgia = dao_thuoc.getThuoctheoMa(ma).giaBan();
				Double tien = soThuoc * dgia;
				String[] rowData = { ma, ten, soLuong + "", cur.format(dgia) + "", cur.format(tien) };
				tblModelChiTiet.addRow(rowData);
				Tongtien = Tongtien + tien;
				txt_Tien.setText(cur.format(Tongtien));
			}
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Chọn thuốc và nhập đúng số");
		}
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
}
