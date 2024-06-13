package Gui;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;

public class Menu_QuanLi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  static JTabbedPane tabbedPane;
	private JFrame frameBaoCao, frameHoaDon;
	private JFrame frameNhanVien;
	private JFrame frameThuoc;
	private JFrame framechiTiet;
	private JFrame frameTrangChu;

	public Menu_QuanLi() {
//	        super("My Tabbed Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Tạo JTabbedPane
		tabbedPane = new JTabbedPane();
		
		frameTrangChu = new Gui_MenuQL();
		tabbedPane.addTab("Trang Chủ", frameTrangChu.getContentPane());
		// Tạo JFrame 1
		frameThuoc = new Gui_Thuoc();
		tabbedPane.addTab("Quản lí thuốc", frameThuoc.getContentPane());

		// Tạo JFrame 2
		frameHoaDon = new Gui_HoaDon();
		tabbedPane.addTab("Quản Lí Hóa Đơn", frameHoaDon.getContentPane());
		
		framechiTiet = new Gui_CTHoaDon();	
		tabbedPane.addTab("Chi Tiết Hóa Đơn", framechiTiet.getContentPane());
		// Tạo JFrame 3
		frameNhanVien = new Gui_NhanVien();
		tabbedPane.addTab("Quản Lí Nhân Viên", frameNhanVien.getContentPane());

		// Tạo JFrame 2
		frameBaoCao = new Gui_BaoCao();
		tabbedPane.addTab("Báo Cáo,Thống Kê", frameBaoCao.getContentPane());

		// Thêm JTabbedPane vào JFrame của bạn
		getContentPane().add(tabbedPane);
		// tabbedPane.setSelectedIndex(index);
		// Hiển thị JFrame
		setSize(1000, 730);

	}

	public static JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public static void main(String[] args) {
		new Menu_QuanLi().setVisible(true);
	}

}
