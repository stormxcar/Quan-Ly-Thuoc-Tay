package Gui;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;

import ConnectDB.ConnectDB;
import Dao.Dao_ChucVu;
import Dao.Dao_NhanVien;
import Dao.Dao_TaiKhoan;
import Entity.ChucVu;
import Entity.NhanVien;
import Entity.TaiKhoan;

public class Gui_NhanVien extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtemail;
	private JTextField txtDiaChi;
	private JTextField txtCCCD;
	private JTextField txtMaChucVu;
	private JTable table;
	private JTextField txtTimMa;
	private JComboBox<Object> cbbChucVu;

	private DefaultTableModel tablemodel;
	private JDateChooser dateChooser;
	private JRadioButton rad_Nam;
	private JRadioButton rad_nu;
	private ButtonGroup group;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnReset;
	private JButton btnThoat;
	private JButton btnTim;

	Dao_NhanVien dsnv = new Dao_NhanVien();
	Dao_TaiKhoan dsTK = new Dao_TaiKhoan();
	Dao_ChucVu dsCV = new Dao_ChucVu();
	private JDialog dialog;
	private int i;
	private int count = 1;
	private JTextField txtmk;
	private JTextField txtTenTK;
	public Gui_NhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 548);
		setSize(1000, 700);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 128, 0), 4));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnThongTin = new JPanel();
		pnThongTin.setBackground(new Color(255, 255, 255));
		pnThongTin.setBounds(12, 58, 970, 185);
		contentPane.add(pnThongTin);
		pnThongTin.setLayout(null);

		// Mã Nhân Viên
		JLabel lblMa = new JLabel("Mã Nhân Viên:");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMa.setBounds(25, 10, 121, 19);
		pnThongTin.add(lblMa);
		txtMa = new JTextField();
		txtMa.setBounds(137, 12, 190, 19);
		txtMa.setEditable(false);
		pnThongTin.add(txtMa);
		txtMa.setColumns(10);
		// Họ
		JLabel lblHo = new JLabel("Họ:");
		lblHo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHo.setBounds(25, 39, 45, 19);
		pnThongTin.add(lblHo);
		txtHo = new JTextField();
		txtHo.setBounds(137, 39, 190, 19);
		pnThongTin.add(txtHo);
		txtHo.setColumns(10);
		// Tên
		JLabel lblTen = new JLabel("Tên:");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen.setBounds(25, 68, 45, 13);
		pnThongTin.add(lblTen);
		txtTen = new JTextField();
		txtTen.setBounds(137, 69, 190, 19);
		pnThongTin.add(txtTen);
		txtTen.setColumns(10);
		// Ngày Sinh
		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgaySinh.setBounds(25, 95, 98, 13);
		pnThongTin.add(lblNgaySinh);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(137, 96, 190, 19);
		pnThongTin.add(dateChooser);
		formatDateChooser(dateChooser);

		// Giới Tính
		JLabel lblGioitinh = new JLabel("Giới Tính:");
		lblGioitinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGioitinh.setBounds(25, 123, 81, 13);
		pnThongTin.add(lblGioitinh);
		rad_Nam = new JRadioButton("Nam");
		rad_Nam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rad_Nam.setBounds(134, 121, 53, 21);
		pnThongTin.add(rad_Nam);
		rad_nu = new JRadioButton("Nữ");
		rad_nu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rad_nu.setBounds(202, 120, 53, 21);
		pnThongTin.add(rad_nu);
		group = new ButtonGroup();
		group.add(rad_Nam);
		group.add(rad_nu);
		// Số Điện Thoại
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoDienThoai.setBounds(370, 6, 106, 26);
		pnThongTin.add(lblSoDienThoai);
		txtSDT = new JTextField();
		txtSDT.setBounds(480, 12, 186, 19);
		pnThongTin.add(txtSDT);
		txtSDT.setColumns(10);
		// Email
		JLabel lblemail = new JLabel("Email:");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblemail.setBounds(370, 42, 45, 13);
		pnThongTin.add(lblemail);
		txtemail = new JTextField();
		txtemail.setBounds(480, 41, 186, 19);
		pnThongTin.add(txtemail);
		txtemail.setColumns(10);
		// Địa chỉ
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiaChi.setBounds(25, 150, 81, 19);
		pnThongTin.add(lblDiaChi);
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(137, 150, 529, 19);
		pnThongTin.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		// Mã chức vụ
		JLabel lblMaChucVu = new JLabel("Nhập Mã Chức Vụ:");
		lblMaChucVu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaChucVu.setBounds(370, 92, 148, 19);
		pnThongTin.add(lblMaChucVu);
		txtMaChucVu = new JTextField();
		txtMaChucVu.setBounds(370, 122, 295, 19);
		pnThongTin.add(txtMaChucVu);
		txtMaChucVu.setColumns(10);
		// Căn Cước công dân
		JLabel lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCCCD.setBounds(370, 70, 81, 13);
		pnThongTin.add(lblCCCD);
		txtCCCD = new JTextField();
		txtCCCD.setBounds(480, 67, 186, 19);
		pnThongTin.add(txtCCCD);
		txtCCCD.setColumns(10);

		// Panel chứa ảnh nhân viên
		JPanel pnImage = new JPanel();
		pnThongTin.add(pnImage);
		pnImage.setBorder(new LineBorder(new Color(0, 64, 128)));
		pnImage.setBounds(759, 15, 98, 107);
		pnImage.setLayout(null);

		JLabel lblUser = new JLabel();
		lblUser.setBounds(0, 0, 98, 107);
		pnImage.add(lblUser);
		ImageIcon icon = new ImageIcon("./image/user.png");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(lblUser.getWidth(), lblUser.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		lblUser.setIcon(scaledIcon);

		// Chức vụ
		JLabel lblChucVu = new JLabel("Chức Vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChucVu.setBounds(695, 143, 73, 26);
		pnThongTin.add(lblChucVu);
		cbbChucVu = new JComboBox<>();
		cbbChucVu.setBounds(786, 142, 140, 27);
		cbbChucVu.setEnabled(false);
		pnThongTin.add(cbbChucVu);

		JPanel pnThaoTac = new JPanel();
		pnThaoTac.setBackground(new Color(255, 255, 255));
		pnThaoTac.setBorder(new LineBorder(new Color(0, 64, 128), 2));
		pnThaoTac.setBounds(10, 253, 966, 57);
		contentPane.add(pnThaoTac);
		pnThaoTac.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.WHITE);
		btnThem.setToolTipText("Thêm Nhân Viên");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		ImageIcon iconThem = new ImageIcon("./image/thuoc.png");
		Image scaledIcon1 = iconThem.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThem = new ImageIcon(scaledIcon1);
		btnThem.setIcon(scaledIconThem);
		btnThem.setHorizontalTextPosition(JButton.RIGHT);
		btnThem.setVerticalTextPosition(JButton.CENTER);
		btnThem.setBounds(70, 10, 130, 35);
		pnThaoTac.add(btnThem, BorderLayout.WEST);

		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setToolTipText("Xóa Nhân Viên");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		ImageIcon iconThem2 = new ImageIcon("./image/exit.png");
		Image scaledIcon2 = iconThem2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThem2 = new ImageIcon(scaledIcon2);
		btnXoa.setIcon(scaledIconThem2);
		btnXoa.setHorizontalTextPosition(JButton.RIGHT);
		btnXoa.setVerticalTextPosition(JButton.CENTER);
		btnXoa.setBounds(243, 10, 130, 35);
		pnThaoTac.add(btnXoa, BorderLayout.WEST);

		btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.WHITE);
		btnSua.setToolTipText("Sửa Nhân Viên");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		ImageIcon iconThem3 = new ImageIcon("./image/medical.png");
		Image scaledIcon3 = iconThem3.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThem3 = new ImageIcon(scaledIcon3);
		btnSua.setIcon(scaledIconThem3);
		btnSua.setHorizontalTextPosition(JButton.RIGHT);
		btnSua.setVerticalTextPosition(JButton.CENTER);
		btnSua.setBounds(419, 10, 130, 35);
		pnThaoTac.add(btnSua, BorderLayout.WEST);

		btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.setToolTipText("Làm Mới Thông Tin ");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		ImageIcon iconThem4 = new ImageIcon("./image/medicine.png");
		Image scaledIcon4 = iconThem4.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThem4 = new ImageIcon(scaledIcon4);
		btnReset.setIcon(scaledIconThem4);
		btnReset.setHorizontalTextPosition(JButton.RIGHT);
		btnReset.setVerticalTextPosition(JButton.CENTER);
		btnReset.setBounds(595, 10, 130, 35);
		pnThaoTac.add(btnReset, BorderLayout.WEST);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.WHITE);
		btnThoat.setToolTipText("Thoát Chương Trình");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		ImageIcon iconThem5 = new ImageIcon("./image/thoat.png");
		Image scaledIcon5 = iconThem5.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThem5 = new ImageIcon(scaledIcon5);
		btnThoat.setIcon(scaledIconThem5);
		btnThoat.setHorizontalTextPosition(JButton.RIGHT);
		btnThoat.setVerticalTextPosition(JButton.CENTER);
		btnThoat.setBounds(777, 10, 130, 35);
		pnThaoTac.add(btnThoat, BorderLayout.WEST);

		JPanel pnBang = new JPanel();
		pnBang.setBackground(new Color(255, 255, 255));
		pnBang.setBounds(10, 370, 966, 280);
		contentPane.add(pnBang);
		pnBang.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.EAST);
		tabbedPane.setBounds(0, 22, 965, 270);
		pnBang.add(tabbedPane);

		String[] header = "STT ; Mã Nhân Viên ; Họ ; Tên ; Ngày Sinh ; Giới Tính ; CCCD ; Số Điện Thoại ; Email ; Địa chỉ ; Chức Vụ "
				.split(";");
		tablemodel = new DefaultTableModel(header, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa bất kỳ ô nào trên bảng
			}
		};
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tablemodel));
		table.setFillsViewportHeight(true);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		table.setBorder(new LineBorder(new Color(0, 128, 128)));
		table.setRowHeight(25);
		table.setToolTipText("table");
		table.addMouseListener(this);

		JTableHeader header_font = table.getTableHeader();
		Font f = new Font("Arial", Font.BOLD, 13);
		header_font.setFont(f);
		tabbedPane.addTab("Nhân Viên", null, scroll, null);

		pnBang.add(tabbedPane);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBackground(new Color(0, 100, 0));
		pnTieuDe.setBounds(0, 0, 997, 48);
		contentPane.add(pnTieuDe);
		pnTieuDe.setLayout(null);

		JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(341, 5, 247, 43);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnTieuDe.add(lblTitle);

		JPanel pnLine = new JPanel();
		pnLine.setBackground(new Color(0, 0, 160));
		pnLine.setBounds(0, 48, 986, 5);
		contentPane.add(pnLine);

		JPanel pnThongBao = new JPanel();
		pnThongBao.setBackground(new Color(255, 255, 255));
		pnThongBao.setBounds(12, 311, 964, 48);
		contentPane.add(pnThongBao);
		pnThongBao.setLayout(null);

		JLabel lblTimMa = new JLabel("Nhập mã nhân viên:");
		lblTimMa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTimMa.setBounds(195, 10, 137, 30);
		pnThongBao.add(lblTimMa);

		txtTimMa = new JTextField();
		txtTimMa.setBounds(334, 11, 369, 31);
		pnThongBao.add(txtTimMa);
		txtTimMa.setColumns(10);

		btnTim = new JButton("Tìm Kiếm");
		btnTim.setBackground(Color.WHITE);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 13));
		ImageIcon iconThem6 = new ImageIcon("./image/search.png");
		Image scaledIcon6 = iconThem6.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThem6 = new ImageIcon(scaledIcon6);
		btnTim.setIcon(scaledIconThem6);
		btnTim.setHorizontalTextPosition(JButton.RIGHT);
		btnTim.setVerticalTextPosition(JButton.CENTER);
		btnTim.setBounds(713, 10, 150, 30);
		pnThongBao.add(btnTim, BorderLayout.WEST);

		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnReset.addActionListener(this);
		btnThoat.addActionListener(this);

		changeColorButtonWhenEntered(btnThoat);
		changeColorButtonWhenExited(btnThoat);
		changeColorButtonWhenEntered(btnTim);
		changeColorButtonWhenExited(btnTim);
		changeColorButtonWhenEntered(btnThem);
		changeColorButtonWhenExited(btnThem);
		changeColorButtonWhenEntered(btnXoa);
		changeColorButtonWhenExited(btnXoa);
		changeColorButtonWhenEntered(btnReset);
		changeColorButtonWhenExited(btnReset);
		changeColorButtonWhenEntered(btnSua);
		changeColorButtonWhenExited(btnSua);

		ConnectDB.getInstance().getConnection();
		updateComboBox();
		updateTableData();

	}

	private void updateComboBox() {
		Dao_ChucVu ds = new Dao_ChucVu();
		List<ChucVu> list = ds.DocTuBang();

		for (ChucVu chucV : list) {
			cbbChucVu.addItem(chucV.getTenChucVu());
		}
	}

	private void updateTableData() {
		Dao_NhanVien ds = new Dao_NhanVien();
		List<NhanVien> list = ds.docTuBang();
		String cv = null;
		for (NhanVien nv : list) {
			count++;
			if (nv.isHienThi()) {

				if (nv.getChucVu().toString().equalsIgnoreCase("CV001")) {
					cv = "Nhân Viên Bán Hàng";
				} else {
					cv = "Người Quản lý";
				}
				int stt = table.getRowCount() + 1;
				String[] rowData = { stt + "", nv.getMaNhanVien() + "", nv.getHo() + "", nv.getTen() + "",
						nv.getNgaySinh() + "", nv.getGioiTinh() + "", nv.getCCCD() + "", nv.getSDT() + "",
						nv.getEmail() + "", nv.getDiaChi() + "", cv + "" };
				tablemodel.addRow(rowData);
			}
		}
		table.setModel(tablemodel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMa.setText(tablemodel.getValueAt(row, 1).toString());
		txtHo.setText(tablemodel.getValueAt(row, 2).toString());
		txtTen.setText(tablemodel.getValueAt(row, 3).toString());

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(tablemodel.getValueAt(row, 4).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dateChooser.setDate(date);
		String gt = tablemodel.getValueAt(row, 5).toString().trim();
		if (gt.equalsIgnoreCase("Nam")) {
			rad_Nam.setSelected(true);
			rad_nu.setSelected(false);
		} else {
			rad_Nam.setSelected(false);
			rad_nu.setSelected(true);
		}
		txtCCCD.setText(tablemodel.getValueAt(row, 6).toString());
		txtSDT.setText(tablemodel.getValueAt(row, 7).toString());
		txtemail.setText(tablemodel.getValueAt(row, 8).toString());
		txtDiaChi.setText(tablemodel.getValueAt(row, 9).toString());
		if (tablemodel.getValueAt(row, 10).toString().equalsIgnoreCase("Nhân Viên Bán Hàng")) {
			txtMaChucVu.setText("CV001");
		} else {
			txtMaChucVu.setText("CV002");
		}
		if (tablemodel.getValueAt(row, 10).equals("Nhân Viên Bán Hàng")) {
			cbbChucVu.setSelectedIndex(0);
		} else {
			cbbChucVu.setSelectedIndex(1);
		}
//	    // Duyệt qua tất cả các dòng và gán giá trị cho cột STT
//	    int count = 1;
//	    for (int i = 0; i < tablemodel.getRowCount(); i++) {
//	        tablemodel.setValueAt(count++, i, 0);
//	    }
	}

	public void ThemActions() {
		if (validData()) {

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			int stt = table.getRowCount() + 1;
			NhanVien nv = reverSPFromTextFile();
			String ngayChon = dateFormat.format(dateChooser.getDate());
			String cv = null;
			if (txtMaChucVu.getText().equalsIgnoreCase("CV001")) {
				cv = "Nhân Viên Bán Hàng";
			} else {
				cv = "Người Quản lý";
			}
			String gt = (group.getSelection() == rad_Nam.getModel()) ? "Nam" : "Nữ";
			if (dsnv.createNV(nv)) {
				String[] data = { stt + "", sinhMa(count), txtHo.getText() + "", txtTen.getText() + "", ngayChon + "",
						gt + "", txtCCCD.getText() + "", txtSDT.getText() + "", txtemail.getText() + "",
						txtDiaChi.getText() + "", cv + "" };
				tablemodel.addRow(data);

				JOptionPane.showMessageDialog(this, "Thêm Nhân Viên Thành Công !");
				table.setRowSelectionInterval(stt - 1, stt - 1);
				int kv = HienThiModal(sinhMa(count));
				if (kv == 1) {
					count++;
					JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công !");
				} else if (kv == 0) {
					int row = tablemodel.getRowCount() - 1;
					if (row >= 0) {
						String ma = (String) table.getValueAt(row, 1);
						if (dsnv.deleteNV(ma)) {
							tablemodel.removeRow(row);
							ResetActions();
						}
						JOptionPane.showMessageDialog(this, "Thêm Nhân viên thất bại!");
					} else
						JOptionPane.showMessageDialog(this, "Xóa thất bại ! Vui Lòng thử lại !");
				}
			} else {
				System.out.println(count);
				JOptionPane.showMessageDialog(this, "Trùng mã nhân viên ! Vui lòng nhập lại !");
			}
		}
	}

	private NhanVien reverSPFromTextFile() {
//		String ma = sinhMa(table.getRowCount() + 1);
		String ma = sinhMa(count);
		String Ho = txtHo.getText().toString();
		String Ten = txtTen.getText().toString();
		String sdt = txtSDT.getText().toString();
		String email = txtemail.getText().toString();
		String CCCD = txtCCCD.getText().toString();
		String diachi = txtDiaChi.getText().toString();
		String chucVu = txtMaChucVu.getText().toString();
		Date ngaysinh = dateChooser.getDate();
		String gt = (group.getSelection() == rad_Nam.getModel()) ? "Nam" : "Nữ";
		Boolean hienThi = true;

		return new NhanVien(ma, Ho, Ten, sdt, email, CCCD, diachi, new ChucVu(chucVu), gt, ngaysinh, hienThi);
	}

	public boolean validData() {
//		String ma = txtMa.getText().trim();
		String Ho = txtHo.getText().trim();
		String Ten = txtTen.getText().trim();
		String sdt = txtSDT.getText().trim();
		String email = txtemail.getText().trim();
		String CCCD = txtCCCD.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String maChucVu = txtMaChucVu.getText().trim();
		ButtonModel selected = group.getSelection();

		if (selected == null || Ho.isEmpty() || Ten.isEmpty() || sdt.isEmpty() || email.isEmpty() || CCCD.isEmpty()
				|| diachi.isEmpty() || maChucVu.isEmpty() || dateChooser.getDate() == null) {
			showMessage("Vui lòng điền đầy đủ thông tin còn thiếu.");
			return false;
		}
		if (!(Ho.length() > 0 && Ho.matches("^[\\p{L}\\p{N} ]+$"))) {
			showMessage("Nhập sai Họ Nhân Viên . Vui Lòng Nhập Lại ! Ví dụ : Nguyễn Văn");
			txtHo.selectAll();
			txtHo.requestFocus();
			return false;
		}
		if (!(Ten.length() > 0 && Ten.matches("^[\\p{L}\\p{N} ]+$"))) {
			showMessage("Nhập sai Tên Nhân Viên . Vui Lòng Nhập Lại ! Ví dụ : An");
			txtTen.selectAll();
			txtTen.requestFocus();
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("^[0]\\d{9}$"))) {
			showMessage("Nhập sai định dạng Số Điện Thoại. Vui Lòng Nhập Lại ! Ví dụ : 0987654321");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		if (!(email.length() > 0 && email.matches("^[a-zA-Z]+[a-zA-Z0-9]*@[a-zA-Z]+\\.com$"))) {
			showMessage("Nhập sai định dạng Email. Vui Lòng Nhập Lại ! Ví dụ : nguyenkha234@gmail.com");
			txtemail.selectAll();
			txtemail.requestFocus();
			return false;
		}
		if (!(CCCD.length() > 0 && CCCD.matches("^\\d{12}$"))) {
			showMessage("Nhập sai định dạng Số Căn Cước Công Dân. Vui Lòng Nhập Lại ! Ví dụ : 098765432198");
			txtCCCD.selectAll();
			txtCCCD.requestFocus();
			return false;
		}
		if (!(diachi.length() > 0 && diachi.matches("^.*$"))) {
			showMessage("Vui Lòng Nhập Lại Địa Chỉ ! Ví dụ : 208 Lê Đức thọ, Phường 6, Gò Vấp, TP HCM");
			txtDiaChi.selectAll();
			txtDiaChi.requestFocus();
			return false;
		}
		if (!(maChucVu.length() > 0 && maChucVu.matches("[C][V](00)(1|2)"))) {
			showMessage("Nhập sai định dạng Mã Chức Vụ. Vui Lòng Nhập Lại ! Ví dụ : CV001 hoặc CV002");
			txtMaChucVu.selectAll();
			txtMaChucVu.requestFocus();
			return false;
		}
		return true;
	}

	public void showMessage(String mess) {
		JOptionPane.showMessageDialog(this, mess, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}

	public void ResetActions() {
		txtMa.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtemail.setText("");
		txtCCCD.setText("");
		txtMaChucVu.setText("");
		dateChooser.setDate(null);
		group.clearSelection();

		txtMa.requestFocus();

	}

	public void ThoatActions() {
		int select = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không ?", "Thoát",
				JOptionPane.YES_NO_OPTION);
		if (select == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem))
			ThemActions();
		else if (o.equals(btnReset))
			ResetActions();
		else if (o.equals(btnThoat))
			ThoatActions();
		else if (o.equals(btnSua)) {
			int row = table.getSelectedRow();
//			String gt = (group.getSelection() == rad_Nam.getModel()) ? "Nam" : "Nữ";
			
				if(row >= 0) {
					NhanVien nv = reverSPFromTextFileToEdit();
					if(validData()) {
						if(dsnv.updateNV(nv)) {
							String[] header = "STT ; Mã Nhân Viên ; Họ ; Tên ; Ngày Sinh ; Giới Tính ; CCCD ; Số Điện Thoại ; Email ; Địa chỉ ; Chức Vụ "
									.split(";");
							tablemodel = new DefaultTableModel(header, 0) {
								/**
								 * 
								 */
								private static final long serialVersionUID = 1L;

								@Override
								public boolean isCellEditable(int row, int column) {
									return false; // Không cho phép chỉnh sửa bất kỳ ô nào trên bảng
								}
							};
							table.setModel(tablemodel);
							updateTableData();
							
							JOptionPane.showMessageDialog(this, "Sửa Thành Công !");
						}else {
							JOptionPane.showMessageDialog(this, "Sửa không thành công !");
						}
					}
						
					}
			
			// xóa tài khoản trc khi xóa nhân viên
		} else if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tài khoản của nhân viên này không?",
					"Xóa", JOptionPane.YES_NO_OPTION);
//			if(row == -1) {
//				JOptionPane.showMessageDialog(null, "Bạn cần chọn hàng cần xóa !");
//			}
			if (option == JOptionPane.YES_OPTION) {
				if (row >= 0) {
					String ma = (String) table.getValueAt(row, 1);
//		            NhanVien nv = dsnv.getNhanVientheoMa(ma);
					if (dsTK.deleteTK(ma)) {
						if (dsnv.deleteNV(ma)) {
							tablemodel.removeRow(row);
							JOptionPane.showMessageDialog(this, "Xóa nhân viên và tài khoản thành công !");
						} else {
							JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại! Vui Lòng thử lại !");
						}
					} else {
						JOptionPane.showMessageDialog(this, "Xóa tài khoản thất bại !");
					}
				} else {
					JOptionPane.showMessageDialog(this, "LỖi xảy ra trong quá trình xóa ! Vui lòng thử lại !");
				}
			}
		} else if (o.equals(btnTim)) {
			Dao_NhanVien ds = new Dao_NhanVien();

			String maNV_Tim = txtTimMa.getText();
			NhanVien nv = ds.getNhanVientheoMa(maNV_Tim);
			if (maNV_Tim.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập mã nhân viên muốn tìm kiếm !");
			} else if (nv == null) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên cần tìm có mã " + maNV_Tim);
			} else {
				nv.getChucVu().getMaChucVu();
				nv = ds.getNhanVientheoMa(maNV_Tim);
				txtMa.setText(nv.getMaNhanVien());
				txtHo.setText(nv.getHo());
				txtTen.setText(nv.getTen());
				dateChooser.setDate(nv.getNgaySinh());
				group.getSelection();
				txtCCCD.setText(nv.getCCCD());
				txtSDT.setText(nv.getSDT());
				txtemail.setText(nv.getEmail());
				txtDiaChi.setText(nv.getDiaChi());
				txtMaChucVu.setText(nv.getChucVu().getMaChucVu());
				if (txtMaChucVu.getText().equals("CV001")) {
					cbbChucVu.setSelectedIndex(0);
				} else {
					cbbChucVu.setSelectedIndex(1);
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < model.getRowCount(); i++) {
					String Ma = String.valueOf(model.getValueAt(i, 1));
					if (Ma.equalsIgnoreCase(maNV_Tim)) {
						table.setRowSelectionInterval(i, i);
						break;
					}
				}
				JOptionPane.showMessageDialog(this, "Tìm thấy nhân viên cần tìm có mã " + maNV_Tim);
			}
		}

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
		((JTextField) dC.getDateEditor().getUiComponent()).setHorizontalAlignment((int) CENTER_ALIGNMENT);
		dC.setBorder(new LineBorder(new Color(122, 138, 153)));
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

	// Sinh mã tự động cho mã Nhân viên
	public String sinhMa(int i) {
		if (i < 10 && i > 0)
			return "NV0000" + i;
		else if (i >= 10 && i < 100)
			return "NV000" + i;
		else if (i >= 100 && i < 1000)
			return "NV00" + i;
		else if (i >= 1000 && i < 10000)
			return "NV0" + i;
		else if (i >= 10000 && i < 100000)
			return "NV" + i;
		else
			return null;
	}

	public boolean ValidTaiKhoan() {
		String ten = txtTenTK.getText().trim();
		String mk = txtmk.getText().trim();

		if (!(ten.length() > 5 && ten.matches("[a-zA-Z]{6,}\\d+"))) {
			showMessage("Vui lòng tạo lại tài khoản ! có 5 kí tự chữ số trở lên");
			return false;
		}
		if (!(mk.length() > 6 && mk.matches("^[\\p{L}\\p{N} ]+$"))) {
			showMessage("Vui lòng tạo lại mật khẩu ! có 6 kí tự bất kì trở lên");
			return false;
		}
		return true;
	}



	private NhanVien reverSPFromTextFileToEdit() {
		String ma = txtMa.getText().trim().toString();
		String Ho = txtHo.getText().toString();
		String Ten = txtTen.getText().toString();
		String sdt = txtSDT.getText().toString();
		String email = txtemail.getText().toString();
		String CCCD = txtCCCD.getText().toString();
		String diachi = txtDiaChi.getText().toString();
		String chucVu = txtMaChucVu.getText().toString();
		Date ngaysinh = dateChooser.getDate();
		String gt = (group.getSelection() == rad_Nam.getModel()) ? "Nam" : "Nữ";
		Boolean hienThi = true;

		return new NhanVien(ma, Ho, Ten, sdt, email, CCCD, diachi, new ChucVu(chucVu), gt, ngaysinh, hienThi);
	}


	

	// định dạng cho các button
	public void formatButton(JButton btn, String diaChi) {
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

	public int HienThiModal(String maNV) {
		dialog = new JDialog(this, "", true);
	    dialog.setSize(300, 200);
	    // Lấy kích thước của JFrame
        Dimension frameSize = contentPane.getSize();
        // Lấy kích thước của dialog
        Dimension dialogSize = dialog.getSize();
        // Tính toán vị trí cần thiết để hiển thị dialog giữa JFrame
        int x = contentPane.getLocationOnScreen().x + (frameSize.width - dialogSize.width) / 2;
        int y = contentPane.getLocationOnScreen().y + (frameSize.height - dialogSize.height) / 2;
        dialog.setLocation(x, y);
	    JPanel panel = new JPanel();
	    panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));

	    JPanel pTen = new JPanel();
	    JLabel lblTen = new JLabel("Tên tài khoản:");
	    txtTenTK = new JTextField(22);
	    pTen.add(lblTen);
	    pTen.add(txtTen);
	    panel.add(pTen);

	    JPanel pmk = new JPanel();
	    JLabel lblmk = new JLabel("Mật khẩu:");

	    txtmk = new JTextField(22);
	    pmk.add(lblmk);
	    pmk.add(txtmk); 
	    panel.add(pmk);
	    
	    // Tạo JButton để lưu dữ liệu
	    JButton btnSave = new JButton("TẠO");
	  
	    btnSave.setPreferredSize(new Dimension(200 , 30));
	    ImageIcon iconThem7 = new ImageIcon("./image/add.png");
		Image scaledIcon7 = iconThem7.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThem7 = new ImageIcon(scaledIcon7);
		btnSave.setIcon(scaledIconThem7);
		btnSave.setHorizontalTextPosition(JButton.RIGHT);
		btnSave.setVerticalTextPosition(JButton.CENTER);
	    btnSave.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 60)); 
	    btnSave.addActionListener(new ActionListener() {
	       
			@Override
	        public void actionPerformed(ActionEvent e) {
	            // Lưu dữ liệu vào database
				dialog.addWindowListener(new WindowAdapter() {
			         public void windowClosing(WindowEvent windowEvent) {
			            i =0;
			        
			         }
			      });
	            // Thực hiện lưu dữ liệu vào database ở đây
	        	Dao_TaiKhoan tk = new Dao_TaiKhoan();
	        	Object o = e.getSource();
	        	if(o.equals(btnSave)) {
	        		TaiKhoan TK = new TaiKhoan();
	        	    TK.setTenTK(txtTen.getText());
	        	    try {
						TK.setMk(hashString(txtmk.getText()));
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        	    TK.setMaNV(maNV);
	        	    	i = 0;
	        	    if(tk.createTK(TK)) {
	        	    	i = 1;
	        	    }else {
	        	    	i = 0;
	        	    }
	        	}
	            // Đóng JDialog
	            dialog.dispose();
	        }
	    });
	    panel.add(btnSave , BorderLayout.WEST);
	    panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	    dialog.getContentPane().add(panel);
	    dialog.setVisible(true);
	    return i;
	}

	public static String hashString(String message) throws NoSuchAlgorithmException {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(message.getBytes());
	        BigInteger hashInt = new BigInteger(1, hash);
	        String hashString = hashInt.toString(16);

	        // Thêm số 0 vào đầu nếu chuỗi hash chưa đầy đủ 64 ký tự
	        while (hashString.length() < 64) {
	            hashString = "0" + hashString;
	        }
	        hashString = hashString.substring(0, 32);
	        return hashString;
	    }
}
