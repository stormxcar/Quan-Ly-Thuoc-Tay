package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gui_MenuNV extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon imageIcon;
	private JTextField line;
	private JButton btn_QLyHoaDon;
	private JButton btn_QLiThuoc;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Gui_MenuNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 700);
		imageIcon = new ImageIcon("./image/nhathuoc.jpg");
		contentPane = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				// Draw the image onto the JPanel
				g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btn_QLiThuoc = new JButton("Quản lý thuốc");
		btn_QLiThuoc.setForeground(new Color(224, 255, 255));
		btn_QLiThuoc.setBackground(new Color(60, 179, 113));
		btn_QLiThuoc.setBounds(199, 227, 213, 134);
		btn_QLiThuoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		ImageIcon icon1 = new ImageIcon("./image/medicine.png");
		Image scaledIcon1 = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThuoc = new ImageIcon(scaledIcon1);
		btn_QLiThuoc.setIcon(scaledIconThuoc);
		contentPane.add(btn_QLiThuoc);

		btn_QLyHoaDon = new JButton("Quản lý hóa đơn");
		btn_QLyHoaDon.setForeground(new Color(224, 255, 255));
		btn_QLyHoaDon.setBackground(new Color(60, 179, 113));
		btn_QLyHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_QLyHoaDon.setBounds(516, 227, 213, 134);
		ImageIcon icon2 = new ImageIcon("./image/bill.png");
		Image scaledIcon2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIconHoaDon = new ImageIcon(scaledIcon2);
		btn_QLyHoaDon.setIcon(scaledIconHoaDon);
		contentPane.add(btn_QLyHoaDon);
		ImageIcon icon3 = new ImageIcon("./image/staff.png");
		Image scaledIcon3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIconNhanVien = new ImageIcon(scaledIcon3);
		ImageIcon icon4 = new ImageIcon("./image/statistical-analysis.png");
		Image scaledIcon4 = icon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIconThongKe = new ImageIcon(scaledIcon4);

		JLabel lblTitle = new JLabel("QUẢN LÝ THUỐC TÂY");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(10, 30, 964, 35);
		contentPane.add(lblTitle);

		line = new JTextField();
		line.setForeground(Color.WHITE);
		line.setBackground(Color.WHITE);
		line.setEnabled(false);
		line.setBounds(369, 65, 246, 4);
		contentPane.add(line);
		line.setColumns(10);

		changeColorButtonWhenEntered(btn_QLiThuoc);
		changeColorButtonWhenEntered(btn_QLyHoaDon);
		changeColorButtonWhenExited(btn_QLyHoaDon);
		changeColorButtonWhenExited(btn_QLiThuoc);

		btn_QLiThuoc.addActionListener(this);
		btn_QLyHoaDon.addActionListener(this);
	}

	public void changeColorButtonWhenEntered(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if (btn.isEnabled()) {
					btn.setForeground(Color.BLACK);
					btn.setBackground(Color.WHITE);
				}
			}
		});
	}

	/*
	 * Đổi màu cho button khi trỏ chuột ra khỏi button
	 */
	public void changeColorButtonWhenExited(JButton btn) {
	}

	public static void main(String[] args) {

		try {
			new Gui_MenuNV().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		JTabbedPane jtab = Menu_NhanVien.getTabbedPane();

		if (o.equals(btn_QLiThuoc)) {
			jtab.setSelectedIndex(1);
		} else if (o.equals(btn_QLyHoaDon)) {
			jtab.setSelectedIndex(2);
		}
//			else if(o.equals(btn_QlyNhanVien)) {
//				jtabb.setSelectedIndex(4);
//			}
//			else if(o.equals(btn_ThongKe)) {
//				jtabb.setSelectedIndex(5);
//			}
	}

}
