package GUI;


import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Phong_dao;
import dao.ThongTinDat_dao;
import entity.Phong;
import entity.ThongTinDat;
import entity.ThongTinTaiKhoan;

import javax.swing.JTabbedPane;

public class GUI_DatThuePhong2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public GUI_DatThuePhong2(ThongTinTaiKhoan tttk) throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1090, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1076, 603);
		contentPane.add(tabbedPane);
		tabbedPane.add("Thuê phòng",new GUI_ThuePhong2(tttk).tabThuePhong());
		tabbedPane.add("Đặt phòng",new GUI_DatPhong2(tttk).tabDatPhong());
		
	}
	public Component datThuePhong() {
		return contentPane;
	}
	

}
