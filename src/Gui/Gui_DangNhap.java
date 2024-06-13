package Gui;

import java.awt.Image;


import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Entity.NhanVien;
import Entity.TaiKhoan;

import ConnectDB.ConnectDB;
import Dao.Dao_NhanVien;
import Dao.Dao_TaiKhoan;
import java.security.NoSuchAlgorithmException;

import javax.swing.JPasswordField;

public class Gui_DangNhap extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon img, img2;
	private JPanel pnform = new JPanel();
	private JTextField txtTk;
	private JPasswordField txtMK;
	private JButton btnDangNhap;
	private Dao_TaiKhoan dao_taiKhoan;
	private Dao_NhanVien dao_NhanVien;
	private ImageIcon imgnen;
	private ImageIcon imgNen;
	private Image im;
	private static String maNV;

	public static String getMaNV() {
		if (maNV == null)
			new Gui_DangNhap();
		return maNV;
	}

	public Gui_DangNhap() {
		try {
			ConnectDB.getInstance().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao_taiKhoan = new Dao_TaiKhoan();
		setSize(1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		imgnen = new ImageIcon("./image/benh_vien.jpg");
		Image imnen = imgnen.getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
		imgNen = new ImageIcon(imnen);
		getContentPane().setLayout(null);
		setVisible(true);
		pnform.setLocation(0, 0);
		pnform.setSize(984, 661);
		pnform.setLayout(null);
		getContentPane().add(pnform, BorderLayout.SOUTH);

		JPanel pn_DangNhap = new JPanel();
		pn_DangNhap.setBackground(new Color(255, 255, 255));
		pn_DangNhap.setBounds(567, 173, 320, 332);

		pn_DangNhap.setLayout(null);
		pnform.add(pn_DangNhap);
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setBackground(Color.CYAN);
		btnDangNhap.setBounds(41, 256, 258, 34);
		pn_DangNhap.add(btnDangNhap);
		changeColorButtonWhenEntered(btnDangNhap);
		changeColorButtonWhenExited(btnDangNhap);
		img = new ImageIcon("./image/khoa.jpg");
		im = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);

		btnDangNhap.addActionListener(this);
		img = new ImageIcon("./image/khoa.jpg");
		im = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		img2 = new ImageIcon(im);
		btnDangNhap.setIcon(img2);

		changeColorButtonWhenEntered(btnDangNhap);
		changeColorButtonWhenExited(btnDangNhap);
		txtTk = new JTextField();
		txtTk.setBounds(41, 117, 258, 34);
		pn_DangNhap.add(txtTk);
		txtTk.setColumns(10);
		txtTk.setText("kha123");

		JLabel lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setForeground(new Color(107, 142, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(41, 44, 258, 34);
		pn_DangNhap.add(lblNewLabel);

		JLabel lblTaiKhoan = new JLabel("Tên tài khoản:");
		lblTaiKhoan.setBounds(41, 89, 258, 34);
		pn_DangNhap.add(lblTaiKhoan);

		JLabel lblMtKhu = new JLabel("Mật khẩu: ");
		lblMtKhu.setBounds(41, 162, 258, 34);
		pn_DangNhap.add(lblMtKhu);

		JLabel lblQunMtKhu = new JLabel("Quên mật khẩu");
		lblQunMtKhu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQunMtKhu.setBounds(155, 301, 144, 34);
		pn_DangNhap.add(lblQunMtKhu);

		txtMK = new JPasswordField();
		txtMK.setBounds(41, 186, 258, 34);
		pn_DangNhap.add(txtMK);
		txtMK.setText("123456");

		JLabel lblHinh = new JLabel("");
		lblHinh.setBounds(10, 0, 974, 661);
		pnform.add(lblHinh);
		lblHinh.setIcon(imgNen);

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

	public void xoaTrang() {
		txtMK.setText("");
		txtTk.setText("");
	}

	public void xuatTK() {
		String tentk = txtTk.getText();
		TaiKhoan tk = dao_taiKhoan.gettaiKhoan(tentk);
		tk.toString();
		
		System.out.println(tk.toString());
	}

	@SuppressWarnings("deprecation")
	public boolean DangNhap() throws HeadlessException, NoSuchAlgorithmException {
		String mk = txtMK.getText();
		String tentk = txtTk.getText();
		TaiKhoan tk = null;

		if (mk.equals("") || tentk.equals("")) {
			JOptionPane.showMessageDialog(this, "Điền đầy đủ thông tin");
			return false;
		}
		tk = dao_taiKhoan.gettaiKhoan(tentk);

		if (tk == null) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy tên tài khoản!!");
			return false;
		} else {
			dao_NhanVien = new Dao_NhanVien();
			NhanVien nv = dao_NhanVien.getNhanVientheoMa(tk.getMaNV());
			if (mk.equals(tk.getMk())) {
				maNV = nv.getMaNhanVien();
				xoaTrang();
				this.setVisible(false);
				if (nv.getChucVu().getMaChucVu().equals("CV002"))
					new Menu_QuanLi().setVisible(true);
				else
					new Menu_NhanVien().setVisible(true);
				return true;
			} else {
				JOptionPane.showMessageDialog(this, "Sai mật khẩu!!" +txtMK.getText());
				return false;
			}
		}
	}
	public boolean REGEXTaiKhoan() {
		String ten = txtTk.getText().trim();
		@SuppressWarnings("deprecation")
		String mk = txtMK.getText().trim();

		if (!(ten.length() > 5)) {
			JOptionPane.showMessageDialog(this, "tài khoản phải có 5 kí tự trở lên");
			return false;
		}
		if (!(mk.length() > 6)) {
			JOptionPane.showMessageDialog(this, "mật khẩu phải nhập 6 kí tự trở lên");
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object sc = e.getSource();
		if (sc.equals(btnDangNhap))
			try {
				DangNhap();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}

//	public static String hashString(String message) throws NoSuchAlgorithmException {
//		MessageDigest digest = MessageDigest.getInstance("SHA-256");
//		byte[] hash = digest.digest(message.getBytes());
//		BigInteger hashInt = new BigInteger(1, hash);
//		String hashString = hashInt.toString(16);
//
//		// Thêm số 0 vào đầu nếu chuỗi hash chưa đầy đủ 64 ký tự
//		while (hashString.length() < 64) {
//			hashString = "0" + hashString;
//		}
//		hashString = hashString.substring(0, 32);
//		return hashString;
//	}

}
