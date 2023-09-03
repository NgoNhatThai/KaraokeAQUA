package GUI;

import java.awt.Component;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import connectDB.MyConnection;
import dao.BieuDo_dao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("unused")
public class GUI_BieuDoThongKe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ChartPanel chartPanel;
	private Connection con= MyConnection.getInstance().getConnection();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_BieuDoThongKe frame = new GUI_BieuDoThongKe();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUI_BieuDoThongKe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(835, 365));
        contentPane.add(chartPanel);
//        frame = new JFrame();
//        frame.add(chartPanel);
//        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
//        frame.setSize(600, 400);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        frame.setVisible(true);
	}
	 public static JFreeChart createChart() {
	        JFreeChart barChart = ChartFactory.createBarChart(
	                "BIỂU ĐỒ DOANH THU 2022",
	                "Quý", "Doanh thu",
	                createDataset(), PlotOrientation.VERTICAL, false, false, false);
	        return barChart;
	    }

	    private static CategoryDataset createDataset() {
	        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        BieuDo_dao bieuDo_dao= new BieuDo_dao();
	        dataset.addValue(bieuDo_dao.loadDoanhThuQuy1(), "Doanh thu", "Quý 1");
	        dataset.addValue(bieuDo_dao.loadDoanhThuQuy2(), "Doanh thu", "Quý 2");
	        dataset.addValue(bieuDo_dao.loadDoanhThuQuy3(), "Doanh thu", "Quý 3");
	        dataset.addValue(bieuDo_dao.loadDoanhThuQuy4(), "Doanh thu", "Quý 4");
	        return dataset;
	    }

//	    public static void main(String[] args) {
//	        ChartPanel chartPanel = new ChartPanel(createChart());
//	        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
//	        JFrame frame = new JFrame();
//	        frame.add(chartPanel);
//	        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
//	        frame.setSize(600, 400);
//	        frame.setLocationRelativeTo(null);
//	        frame.setResizable(false);
//	        frame.setVisible(true);
//	    }
	    
	  
	  
	  public Component loadChart() {
		  return contentPane;
	  }

}
