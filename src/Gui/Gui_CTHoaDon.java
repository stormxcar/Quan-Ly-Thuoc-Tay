package Gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ConnectDB.ConnectDB;
import Dao.Dao_CTHoaDon;
import Dao.Dao_HoaDon;
import Entity.CT_HoaDon;
import Entity.HoaDon;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class Gui_CTHoaDon extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel pnlMainContent;
	private JTable tblHoaDon;
	private JScrollPane srcHoaDon;
	private JTextField txtTimMa;
	private JTable tblCT_HoaDon;
	private DefaultTableModel model;
	private DefaultTableModel model_1;
	private JComboBox<Object> cmbTimMa;
	private JButton btnTimMa;
	private Dao_CTHoaDon dsCT;
	private ImageIcon img;
	private Image im;
	private ImageIcon img2;
	private JButton btnReStart;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_CTHoaDon frame = new Gui_CTHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui_CTHoaDon() {
		setTitle("Thông tin chi tiết hoá đơn ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		pnlMainContent = new JPanel();
		// contentPane.setBackground(new Color(240, 255, 255));
		pnlMainContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlMainContent);
		pnlMainContent.setLayout(null);

		JPanel pnlMain = new JPanel();
		pnlMain.setBackground(new Color(0, 100, 0));
		pnlMain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlMain.setBounds(10, 11, 976, 642);
		pnlMainContent.add(pnlMain);
		pnlMain.setLayout(null);

		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(0, 128, 64));
		pnlHeader.setBounds(0, 0, 976, 58);
		pnlHeader.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlMain.add(pnlHeader);
		pnlHeader.setLayout(null);

		JLabel lblTitle = new JLabel("THÔNG TIN CHI TIẾT HÓA ĐƠN");
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(316, 10, 359, 49);
		pnlHeader.add(lblTitle);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(0, 128, 64));
		pnlCenter.setBounds(10, 68, 956, 189);
		pnlMain.add(pnlCenter);
		pnlCenter.setLayout(null);

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00ECm Ki\u1EBFm H\u00F3a \u0110\u01A1n Theo M\u00E3", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnlTimKiem.setBackground(new Color(255, 255, 255));
		pnlTimKiem.setBounds(0, 0, 246, 179);
		pnlCenter.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		txtTimMa = new JTextField();
		txtTimMa.setBounds(10, 31, 226, 28);
		pnlTimKiem.add(txtTimMa);
		txtTimMa.setColumns(10);

		btnTimMa = new JButton("Tìm Kiếm");
		btnTimMa.setBackground(Color.WHITE);
		ImageIcon iconThem = new ImageIcon("./image/timKiem_HD.png");
		Image scaledIcon1 = iconThem.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThem = new ImageIcon(scaledIcon1);
		btnTimMa.setIcon(scaledIconThem);
		btnTimMa.setHorizontalTextPosition(JButton.RIGHT);
		btnTimMa.setVerticalTextPosition(JButton.CENTER);

		btnTimMa.addActionListener(this);
		changeColorButtonWhenEntered(btnTimMa);
		changeColorButtonWhenExited(btnTimMa);
		btnTimMa.setBounds(10, 133, 168, 36);
		pnlTimKiem.add(btnTimMa);
		img = new ImageIcon("./image/user.png");
		im = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnTimMa.setIcon(img2);

		String[] loai_tim = { "Nhân Viên", "Khách Hàng", "Hóa Đơn" };
		cmbTimMa = new JComboBox<>(loai_tim);
		cmbTimMa.setBackground(Color.WHITE);
		cmbTimMa.setBounds(10, 73, 226, 36);
		pnlTimKiem.add(cmbTimMa);

		btnReStart = new JButton("");
		btnReStart.setBounds(188, 133, 48, 36);
		pnlTimKiem.add(btnReStart);
		btnReStart.addActionListener(this);
		changeColorButtonWhenEntered(btnReStart);
		changeColorButtonWhenExited(btnReStart);
		img = new ImageIcon("./image/reset.png");
		im = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnReStart.setIcon(img2);

		JPanel pnlCT_HoaDon = new JPanel();
		pnlCT_HoaDon.setBackground(new Color(255, 255, 255));
		pnlCT_HoaDon.setBounds(256, 0, 700, 179);
		pnlCenter.add(pnlCT_HoaDon);
		pnlCT_HoaDon.setLayout(null);

		JScrollPane scrCT_HoaDon = new JScrollPane();
		scrCT_HoaDon.setBounds(10, 5, 680, 174);
		pnlCT_HoaDon.add(scrCT_HoaDon);

		tblCT_HoaDon = new JTable();
		tblCT_HoaDon.setFillsViewportHeight(true);
		scrCT_HoaDon.setViewportView(tblCT_HoaDon);

		model_1 = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã thuốc", "Tên Thuốc", "Đơn Giá", "Số Lượng", "Thành Tiền" });
		tblCT_HoaDon.setModel(model_1);
		tblCT_HoaDon.setRowHeight(20);
		scrCT_HoaDon.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JPanel pnlMainTable = new JPanel();
		pnlMainTable.setBackground(new Color(255, 255, 255));
		pnlMainTable.setBounds(10, 260, 956, 378);
		pnlMain.add(pnlMainTable);
		pnlMainTable.setLayout(null);
		JTableHeader header_font_1 = tblCT_HoaDon.getTableHeader();
		Font f_1 = new Font("Arial", Font.BOLD, 13);
		header_font_1.setFont(f_1);

		srcHoaDon = new JScrollPane();
		srcHoaDon.setBounds(6, 10, 940, 358);
		pnlMainTable.add(srcHoaDon);

		tblHoaDon = new JTable();
		tblHoaDon.setFillsViewportHeight(true);

		tblHoaDon.setRowHeight(20);
		srcHoaDon.setViewportView(tblHoaDon);
		srcHoaDon.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JTableHeader header_font = tblHoaDon.getTableHeader();
		Font f = new Font("Arial", Font.BOLD, 13);
		header_font.setFont(f);
		tblHoaDon.addMouseListener(this);

		ConnectDB.getInstance().getConnection();
//		updateComboBox();
		updateTableData_HoaDon();
		updateTableData_CT_HoaDon();
	}

	public void updateTableData_HoaDon() {
		Dao_HoaDon dsHD = new Dao_HoaDon();
		dsCT = new Dao_CTHoaDon();
		List<HoaDon> list = dsHD.getallHoaDon();

		model = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã Hoá Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Ngày Lập", "Tổng Tiền" });
		int stt = 1;
		Locale locale = new Locale("vi", "VN");
		NumberFormat cur = NumberFormat.getCurrencyInstance(locale);
		for (HoaDon hd : list) {
			ArrayList<CT_HoaDon> ds = dsCT.getallCTHoaDonTheoMaHoaDon(hd.getMaHD());
			double TongTien = 0;
			for (CT_HoaDon cthoadon : ds) {
				TongTien = TongTien + (cthoadon.getDonGia() * cthoadon.getSoLuong());

			}
			String[] datarow = { stt + "", hd.getMaHD() + "", hd.getMaNV() + "", hd.getMaKH() + "",
					hd.getNgayLap() + "", cur.format(TongTien) + "" };
			model.addRow(datarow);
			stt++;
		}
		tblHoaDon.setModel(model);
	}

	public void updateTableData_CT_HoaDon() {
		Dao_CTHoaDon ds = new Dao_CTHoaDon();
		List<CT_HoaDon> List = ds.getallCTHoaDon();
		Locale locale = new Locale("vi", "VN");
		for (CT_HoaDon ct : List) {
			int stt = tblCT_HoaDon.getRowCount() + 1;
			String tenThuoc = ds.getTenThuoc(ct.getMaThuoc());
			double ThanhTien = ct.getDonGia() * ct.getSoLuong();
			NumberFormat cur = NumberFormat.getCurrencyInstance(locale);

			String[] rowData = { stt + "", ct.getMaThuoc() + "", tenThuoc + "", ct.getDonGia() + "",
					ct.getSoLuong() + "", cur.format(ThanhTien) + "" };
			model_1.addRow(rowData);
		}
		tblCT_HoaDon.setModel(model_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		Locale locale = new Locale("vi", "VN");
		NumberFormat cur = NumberFormat.getCurrencyInstance(locale);
		if (o.equals(btnTimMa) && CheckValidate()) {
			Dao_HoaDon dsHD = new Dao_HoaDon();
			if (cmbTimMa.getSelectedItem().equals("Nhân Viên")) {
				ArrayList<HoaDon> list = dsHD.getallHoaDonTheoMaNhanVien(txtTimMa.getText());
				model = new DefaultTableModel(new Object[][] {},
						new String[] { "STT", "Mã Hoá Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Ngày Lập", "Tổng Tiền" });

				for (HoaDon hd : list) {
					ArrayList<CT_HoaDon> ds = dsCT.getallCTHoaDonTheoMaHoaDon(hd.getMaHD());
					double TongTien = 0;
					for (CT_HoaDon cthoadon : ds) {
						TongTien = TongTien + (cthoadon.getDonGia() * cthoadon.getSoLuong());
					}
					int stt = tblHoaDon.getRowCount() + 1;
					String[] datarow = { stt + "", hd.getMaHD() + "", hd.getMaNV() + "", hd.getMaKH() + "",
							hd.getNgayLap() + "" ,cur.format(TongTien) + ""};
					model.addRow(datarow);

				}
				tblHoaDon.setModel(model);
			} else if (cmbTimMa.getSelectedItem().equals("Khách Hàng")) {
				ArrayList<HoaDon> list = dsHD.getallHoaDonTheoMaKhachHang(txtTimMa.getText());
				model = new DefaultTableModel(new Object[][] {},
						new String[] { "STT", "Mã Hoá Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Ngày Lập", "Tổng Tiền" });

				for (HoaDon hd : list) {
					ArrayList<CT_HoaDon> ds = dsCT.getallCTHoaDonTheoMaHoaDon(hd.getMaHD());
					double TongTien = 0;
					for (CT_HoaDon cthoadon : ds) {
						TongTien = TongTien + (cthoadon.getDonGia() * cthoadon.getSoLuong());

					}
					int stt = tblHoaDon.getRowCount() + 1;
					String[] datarow = { stt + "", hd.getMaHD() + "", hd.getMaNV() + "", hd.getMaKH() + "",
							hd.getNgayLap() + "",cur.format(TongTien) + "" };
					model.addRow(datarow);

				}
				tblHoaDon.setModel(model);
			} else if (cmbTimMa.getSelectedItem().equals("Hóa Đơn")) {
				ArrayList<HoaDon> list = dsHD.getallHoaDonTheoMaHoaDon(txtTimMa.getText());
				model = new DefaultTableModel(new Object[][] {},
						new String[] { "STT", "Mã Hoá Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Ngày Lập", "Tổng Tiền" });

				for (HoaDon hd : list) {
					ArrayList<CT_HoaDon> ds = dsCT.getallCTHoaDonTheoMaHoaDon(hd.getMaHD());
					double TongTien = 0;
					for (CT_HoaDon cthoadon : ds) {
						TongTien = TongTien + (cthoadon.getDonGia() * cthoadon.getSoLuong());

					}
					int stt = tblHoaDon.getRowCount() + 1;
					String[] datarow = { stt + "", hd.getMaHD() + "", hd.getMaNV() + "", hd.getMaKH() + "",
							hd.getNgayLap() + "",cur.format(TongTien) + "" };
					model.addRow(datarow);

				}
				tblHoaDon.setModel(model);
			}
		}
		if (o.equals(btnReStart)) {
			updateTableData_HoaDon();
			updateTableData_CT_HoaDon();
		}
	}

	public boolean CheckValidate() {
		String maNV = txtTimMa.getText().trim();
		String maKH = txtTimMa.getText().trim();
		String maHD = txtTimMa.getText().trim();

		if (maHD.isEmpty() || maKH.isEmpty() || maNV.isEmpty()) {
			txtTimMa.requestFocus();
			showMessage("Vui Lòng Nhập Mã Muốn Tìm Kiếm !");
			return false;
		}

		if ((!(maNV.length() >= 0 && maNV.matches("^[NV]{2}\\d{5}$")))
				&& (cmbTimMa.getSelectedItem().equals("Nhân Viên"))) {
			showMessage("Vui lòng nhập lại mã nhân viên muốn tìm kiếm !");
			txtTimMa.requestFocus();
			return false;
		}
		if ((!(maKH.length() >= 0 && maKH.matches("^[KH]{2}\\d{5}$")))
				&& (cmbTimMa.getSelectedItem().equals("Khách Hàng"))) {
			txtTimMa.requestFocus();
			showMessage("Vui lòng nhập lại mã khách hàng muốn tìm kiếm !");
			return false;
		}
		if ((!(maHD.length() >= 0 && maHD.matches("^[HD]{2}\\d{5}$")))
				&& (cmbTimMa.getSelectedItem().equals("Hóa Đơn"))) {
			txtTimMa.requestFocus();
			showMessage("Vui lòng nhập lại mã hóa đơn muốn tìm kiếm !");
			return false;
		}

		return true;
	}

	public void showMessage(String mess) {
		JOptionPane.showMessageDialog(this, mess, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblHoaDon.getSelectedRow();
		String ma = model.getValueAt(row, 1).toString();
		Dao_CTHoaDon ds = new Dao_CTHoaDon();
		List<CT_HoaDon> List = ds.getallCTHoaDonTheoMaHoaDon(ma);
		DefaultTableModel model_CT = new DefaultTableModel();
		model_CT = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã thuốc", "Tên Thuốc", "Đơn Giá", "Số Lượng", "Thành Tiền" });

		Locale locale = new Locale("vi", "VN");
		NumberFormat cur = NumberFormat.getCurrencyInstance(locale);
		for (CT_HoaDon ct : List) {
			int stt = tblCT_HoaDon.getRowCount() + 1;
			String tenThuoc = ds.getTenThuoc(ct.getMaThuoc());
			double ThanhTien = ct.getDonGia() * ct.getSoLuong();
			String[] rowData = { stt + "", ct.getMaThuoc() + "", tenThuoc + "", ct.getDonGia() + "",
					ct.getSoLuong() + "", cur.format(ThanhTien) + "" };
			model_CT.addRow(rowData);
		}
		tblCT_HoaDon.setModel(model_CT);
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

	public void changeColorButtonWhenEntered(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btn.isEnabled()) {
					btn.setBackground(Color.white);
					btn.setBorder(new LineBorder(Color.green, 2, true));
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
					btn.setBackground(Color.CYAN);
					btn.setBorder(new LineBorder(Color.blue, 2, true));
				}
			}
		});
	}
}
