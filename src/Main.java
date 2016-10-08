import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;

import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.TransferHandler;
import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;
	private static JButton btnAa, btnBa, btnCa, btnAb, btnBb, btnCb, btnAc, btnBc, btnCc;
	private static double seconds = 180;
	private JMenu mnOptions;
	private static JLabel label_2, label_4, label_5;
	private JLabel label_3;
	private static int score, moves, solved = 0;

	public Main() throws InterruptedException {
		setTitle("Fast Cubes");
		setForeground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setForeground(Color.WHITE);
		setJMenuBar(menuBar);

		mnOptions = new JMenu("Options");
		mnOptions.setForeground(Color.WHITE);
		menuBar.add(mnOptions);

		JLabel lblScore = new JLabel(" Score:  ");
		lblScore.setForeground(Color.WHITE);
		menuBar.add(lblScore);

		label_2 = new JLabel(Integer.toString(score));
		label_2.setForeground(Color.ORANGE);
		menuBar.add(label_2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 44, 0, 0, 0, 31, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		contentPane.add(list, gbc_list);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton button1 = new JButton("1");
		button1.setBackground(Color.ORANGE);
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.fill = GridBagConstraints.BOTH;
		gbc_button1.insets = new Insets(0, 0, 5, 0);
		gbc_button1.gridx = 0;
		gbc_button1.gridy = 0;
		panel.add(button1, gbc_button1);

		JButton button2 = new JButton("2");
		button2.setForeground(new Color(0, 0, 0));
		button2.setBackground(Color.ORANGE);
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.insets = new Insets(0, 0, 5, 0);
		gbc_button2.fill = GridBagConstraints.BOTH;
		gbc_button2.gridx = 0;
		gbc_button2.gridy = 1;
		panel.add(button2, gbc_button2);

		JButton button3 = new JButton("3");
		button3.setForeground(Color.BLACK);
		button3.setBackground(Color.ORANGE);
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.insets = new Insets(0, 0, 5, 0);
		gbc_button3.fill = GridBagConstraints.BOTH;
		gbc_button3.gridx = 0;
		gbc_button3.gridy = 2;
		panel.add(button3, gbc_button3);

		JButton button4 = new JButton("4");
		button4.setForeground(Color.BLACK);
		button4.setBackground(Color.ORANGE);
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.insets = new Insets(0, 0, 5, 0);
		gbc_button4.fill = GridBagConstraints.BOTH;
		gbc_button4.gridx = 0;
		gbc_button4.gridy = 3;
		panel.add(button4, gbc_button4);

		JButton button5 = new JButton("5");
		button5.setForeground(Color.BLACK);
		button5.setBackground(Color.ORANGE);
		GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.insets = new Insets(0, 0, 5, 0);
		gbc_button5.fill = GridBagConstraints.BOTH;
		gbc_button5.gridx = 0;
		gbc_button5.gridy = 4;
		panel.add(button5, gbc_button5);

		JButton button6 = new JButton("6");
		button6.setForeground(Color.BLACK);
		button6.setBackground(Color.ORANGE);
		GridBagConstraints gbc_button6 = new GridBagConstraints();
		gbc_button6.insets = new Insets(0, 0, 5, 0);
		gbc_button6.fill = GridBagConstraints.BOTH;
		gbc_button6.gridx = 0;
		gbc_button6.gridy = 5;
		panel.add(button6, gbc_button6);

		JButton button7 = new JButton("7");
		button7.setForeground(Color.BLACK);
		button7.setBackground(Color.ORANGE);
		GridBagConstraints gbc_button7 = new GridBagConstraints();
		gbc_button7.insets = new Insets(0, 0, 5, 0);
		gbc_button7.fill = GridBagConstraints.BOTH;
		gbc_button7.gridx = 0;
		gbc_button7.gridy = 6;
		panel.add(button7, gbc_button7);

		JButton button8 = new JButton("8");
		button8.setForeground(Color.BLACK);
		button8.setBackground(Color.ORANGE);
		GridBagConstraints gbc_button8 = new GridBagConstraints();
		gbc_button8.fill = GridBagConstraints.BOTH;
		gbc_button8.insets = new Insets(0, 0, 5, 0);
		gbc_button8.gridx = 0;
		gbc_button8.gridy = 7;
		panel.add(button8, gbc_button8);

		JButton button9 = new JButton("9");
		button9.setForeground(Color.BLACK);
		button9.setBackground(Color.ORANGE);
		GridBagConstraints gbc_button9 = new GridBagConstraints();
		gbc_button9.fill = GridBagConstraints.BOTH;
		gbc_button9.gridx = 0;
		gbc_button9.gridy = 8;
		panel.add(button9, gbc_button9);

		btnAa = new JButton("1");
		btnAa.setForeground(Color.WHITE);
		btnAa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAa.setTransferHandler(new ValueImportTransferHandler());
		btnAa.setEnabled(false);
		btnAa.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnAa = new GridBagConstraints();
		gbc_btnAa.fill = GridBagConstraints.BOTH;
		gbc_btnAa.insets = new Insets(0, 0, 5, 5);
		gbc_btnAa.gridx = 2;
		gbc_btnAa.gridy = 0;
		contentPane.add(btnAa, gbc_btnAa);

		btnBa = new JButton("2");
		btnBa.setForeground(Color.WHITE);
		btnBa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBa.setTransferHandler(new ValueImportTransferHandler());
		btnBa.setEnabled(false);
		btnBa.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnBa = new GridBagConstraints();
		gbc_btnBa.fill = GridBagConstraints.BOTH;
		gbc_btnBa.insets = new Insets(0, 0, 5, 5);
		gbc_btnBa.gridx = 3;
		gbc_btnBa.gridy = 0;
		contentPane.add(btnBa, gbc_btnBa);

		btnCa = new JButton("3");
		btnCa.setForeground(Color.WHITE);
		btnCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCa.setTransferHandler(new ValueImportTransferHandler());
		btnCa.setEnabled(false);
		btnCa.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnCa = new GridBagConstraints();
		gbc_btnCa.fill = GridBagConstraints.BOTH;
		gbc_btnCa.insets = new Insets(0, 0, 5, 5);
		gbc_btnCa.gridx = 4;
		gbc_btnCa.gridy = 0;
		contentPane.add(btnCa, gbc_btnCa);

		btnAb = new JButton("4");
		btnAb.setForeground(Color.WHITE);
		btnAb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAb.setTransferHandler(new ValueImportTransferHandler());
		btnAb.setEnabled(false);
		btnAb.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnAb = new GridBagConstraints();
		gbc_btnAb.fill = GridBagConstraints.BOTH;
		gbc_btnAb.insets = new Insets(0, 0, 5, 5);
		gbc_btnAb.gridx = 2;
		gbc_btnAb.gridy = 1;
		contentPane.add(btnAb, gbc_btnAb);

		btnBb = new JButton("5");
		btnBb.setForeground(Color.WHITE);
		btnBb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBb.setTransferHandler(new ValueImportTransferHandler());
		btnBb.setEnabled(false);
		btnBb.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnBb = new GridBagConstraints();
		gbc_btnBb.fill = GridBagConstraints.BOTH;
		gbc_btnBb.insets = new Insets(0, 0, 5, 5);
		gbc_btnBb.gridx = 3;
		gbc_btnBb.gridy = 1;
		contentPane.add(btnBb, gbc_btnBb);

		btnCb = new JButton("6");
		btnCb.setForeground(Color.WHITE);
		btnCb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCb.setTransferHandler(new ValueImportTransferHandler());
		btnCb.setEnabled(false);
		btnCb.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnCb = new GridBagConstraints();
		gbc_btnCb.fill = GridBagConstraints.BOTH;
		gbc_btnCb.insets = new Insets(0, 0, 5, 5);
		gbc_btnCb.gridx = 4;
		gbc_btnCb.gridy = 1;
		contentPane.add(btnCb, gbc_btnCb);

		btnAc = new JButton("7");
		btnAc.setForeground(Color.WHITE);
		btnAc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAc.setTransferHandler(new ValueImportTransferHandler());
		btnAc.setEnabled(false);
		btnAc.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnAc = new GridBagConstraints();
		gbc_btnAc.fill = GridBagConstraints.BOTH;
		gbc_btnAc.insets = new Insets(0, 0, 5, 5);
		gbc_btnAc.gridx = 2;
		gbc_btnAc.gridy = 2;
		contentPane.add(btnAc, gbc_btnAc);

		btnBc = new JButton("8");
		btnBc.setForeground(Color.WHITE);
		btnBc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBc.setTransferHandler(new ValueImportTransferHandler());
		btnBc.setEnabled(false);
		btnBc.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnBc = new GridBagConstraints();
		gbc_btnBc.fill = GridBagConstraints.BOTH;
		gbc_btnBc.insets = new Insets(0, 0, 5, 5);
		gbc_btnBc.gridx = 3;
		gbc_btnBc.gridy = 2;
		contentPane.add(btnBc, gbc_btnBc);

		btnCc = new JButton("9");
		btnCc.setForeground(Color.WHITE);
		btnCc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCc.setTransferHandler(new ValueImportTransferHandler());
		btnCc.setEnabled(false);
		btnCc.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnCc = new GridBagConstraints();
		gbc_btnCc.insets = new Insets(0, 0, 5, 5);
		gbc_btnCc.fill = GridBagConstraints.BOTH;
		gbc_btnCc.gridx = 4;
		gbc_btnCc.gridy = 2;
		contentPane.add(btnCc, gbc_btnCc);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(100);
		progressBar.setToolTipText("Progress Bar");
		progressBar.setForeground(Color.ORANGE);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.anchor = GridBagConstraints.WEST;
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridwidth = 3;
		gbc_progressBar.insets = new Insets(0, 0, 0, 5);
		gbc_progressBar.gridx = 2;
		gbc_progressBar.gridy = 3;
		contentPane.add(progressBar, gbc_progressBar);

		JLabel label = new JLabel("100");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 5;
		gbc_label.gridy = 3;
		contentPane.add(label, gbc_label);

		JLabel label_1 = new JLabel("%");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridx = 6;
		gbc_label_1.gridy = 3;
		contentPane.add(label_1, gbc_label_1);

		button1.setTransferHandler(new ValueExportTransferHandler(Integer.toString(1)));
		button1.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				TransferHandler handle = button.getTransferHandler();
				handle.exportAsDrag(button, e, TransferHandler.COPY);
			}
		});
		button2.setTransferHandler(new ValueExportTransferHandler(Integer.toString(2)));
		button2.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				TransferHandler handle = button.getTransferHandler();
				handle.exportAsDrag(button, e, TransferHandler.COPY);
			}
		});
		button3.setTransferHandler(new ValueExportTransferHandler(Integer.toString(3)));
		button3.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				TransferHandler handle = button.getTransferHandler();
				handle.exportAsDrag(button, e, TransferHandler.COPY);
			}
		});
		button4.setTransferHandler(new ValueExportTransferHandler(Integer.toString(4)));
		button4.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				TransferHandler handle = button.getTransferHandler();
				handle.exportAsDrag(button, e, TransferHandler.COPY);
			}
		});
		button5.setTransferHandler(new ValueExportTransferHandler(Integer.toString(5)));
		button5.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				TransferHandler handle = button.getTransferHandler();
				handle.exportAsDrag(button, e, TransferHandler.COPY);
			}
		});
		button6.setTransferHandler(new ValueExportTransferHandler(Integer.toString(6)));
		button6.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				TransferHandler handle = button.getTransferHandler();
				handle.exportAsDrag(button, e, TransferHandler.COPY);
			}
		});
		button7.setTransferHandler(new ValueExportTransferHandler(Integer.toString(7)));
		button7.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				TransferHandler handle = button.getTransferHandler();
				handle.exportAsDrag(button, e, TransferHandler.COPY);
			}
		});
		button8.setTransferHandler(new ValueExportTransferHandler(Integer.toString(8)));
		button8.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				TransferHandler handle = button.getTransferHandler();
				handle.exportAsDrag(button, e, TransferHandler.COPY);
			}
		});
		button9.setTransferHandler(new ValueExportTransferHandler(Integer.toString(9)));
		button9.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				TransferHandler handle = button.getTransferHandler();
				handle.exportAsDrag(button, e, TransferHandler.COPY);
			}
		});

		JMenuItem mntmStart = new JMenuItem("Start");
		mntmStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Aa = 1 + (int) (Math.random() * 9);
				int Ba = 1 + (int) (Math.random() * 9);
				int Ca = 1 + (int) (Math.random() * 9);
				int Ab = 1 + (int) (Math.random() * 9);
				int Bb = 1 + (int) (Math.random() * 9);
				int Cb = 1 + (int) (Math.random() * 9);
				int Ac = 1 + (int) (Math.random() * 9);
				int Bc = 1 + (int) (Math.random() * 9);
				int Cc = 1 + (int) (Math.random() * 9);
				btnAa.setText(String.valueOf(Aa));
				btnBa.setText(String.valueOf(Ba));
				btnCa.setText(String.valueOf(Ca));
				btnAb.setText(String.valueOf(Ab));
				btnBb.setText(String.valueOf(Bb));
				btnCb.setText(String.valueOf(Cb));
				btnAc.setText(String.valueOf(Ac));
				btnBc.setText(String.valueOf(Bc));
				btnCc.setText(String.valueOf(Cc));
				moves = 0;
				label_4.setText(Integer.toString(moves));
				solved = 0;
				label_5.setText(Integer.toString(solved));
				mnOptions.setEnabled(false);
				btnAa.setEnabled(true);
				btnBa.setEnabled(true);
				btnCa.setEnabled(true);
				btnAb.setEnabled(true);
				btnBb.setEnabled(true);
				btnCb.setEnabled(true);
				btnAc.setEnabled(true);
				btnBc.setEnabled(true);
				btnCc.setEnabled(true);
				label_2.setText("0");
				label.setText("0");
				progressBar.setValue(0);
				long t = System.currentTimeMillis();
				Thread t1 = new Thread(new Runnable() {
					public void run() {
						int finalGoal = 0;
						double addition = 100 / seconds;
						double goal = 0;
						String strGoal = "0";
						while (finalGoal < 100) {
							try {
								Thread.sleep(250);
								goal = goal + (addition / 4);
								strGoal = Integer.toString(finalGoal);
								finalGoal = (int) goal;
								progressBar.setValue(finalGoal);
								label.setText(strGoal);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.out.println("didn't work lol");
							}
							System.out.println(t);
						}
						if (finalGoal >= 100) {
							btnAa.setEnabled(false);
							btnBa.setEnabled(false);
							btnCa.setEnabled(false);
							btnAb.setEnabled(false);
							btnBb.setEnabled(false);
							btnCb.setEnabled(false);
							btnAc.setEnabled(false);
							btnBc.setEnabled(false);
							btnCc.setEnabled(false);
							mnOptions.setEnabled(true);
						}
					}
				});
				t1.start();
			}
		});
		mnOptions.add(mntmStart);

		JMenu mnGameLength = new JMenu("Game Length");
		mnOptions.add(mnGameLength);

		JMenuItem mntmMinutes_2 = new JMenuItem("2 minutes");
		mntmMinutes_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seconds = 120;
				label_3.setText("2");
			}
		});
		mnGameLength.add(mntmMinutes_2);

		JMenuItem mntmMinutesdefault = new JMenuItem("3 minutes (Default)");
		mntmMinutesdefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seconds = 180;
				label_3.setText("3");
			}
		});
		mnGameLength.add(mntmMinutesdefault);

		JMenuItem mntmMinutes = new JMenuItem("5 minutes");
		mntmMinutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seconds = 300;
				label_3.setText("5");
			}
		});
		mnGameLength.add(mntmMinutes);

		JMenuItem mntmMinutes_1 = new JMenuItem("10 minutes");
		mntmMinutes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seconds = 600;
				label_3.setText("10");
			}
		});
		mnGameLength.add(mntmMinutes_1);
		
		JMenu mnTheme = new JMenu("Theme");
		mnOptions.add(mnTheme);
		
		JMenuItem mntmOrange = new JMenuItem("Orange (Default)");
		mntmOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_2.setForeground(Color.ORANGE);
				label_3.setForeground(Color.ORANGE);
				label_4.setForeground(Color.ORANGE);
				label_5.setForeground(Color.ORANGE);
				button1.setBackground(Color.ORANGE);
				button2.setBackground(Color.ORANGE);
				button3.setBackground(Color.ORANGE);
				button4.setBackground(Color.ORANGE);
				button5.setBackground(Color.ORANGE);
				button6.setBackground(Color.ORANGE);
				button7.setBackground(Color.ORANGE);
				button8.setBackground(Color.ORANGE);
				button9.setBackground(Color.ORANGE);
				progressBar.setForeground(Color.ORANGE);
			}
		});
		mnTheme.add(mntmOrange);
		
		JMenuItem mntmGreen = new JMenuItem("Green");
		mntmGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_2.setForeground(Color.GREEN);
				label_3.setForeground(Color.GREEN);
				label_4.setForeground(Color.GREEN);
				label_5.setForeground(Color.GREEN);
				button1.setBackground(Color.GREEN);
				button2.setBackground(Color.GREEN);
				button3.setBackground(Color.GREEN);
				button4.setBackground(Color.GREEN);
				button5.setBackground(Color.GREEN);
				button6.setBackground(Color.GREEN);
				button7.setBackground(Color.GREEN);
				button8.setBackground(Color.GREEN);
				button9.setBackground(Color.GREEN);
				progressBar.setForeground(Color.GREEN);
			}
		});
		mnTheme.add(mntmGreen);

		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Help frame = new Help();
				frame.setVisible(true);
			}
		});
		mnOptions.add(mntmHelp);

		JSeparator separator = new JSeparator();
		mnOptions.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setForeground(Color.RED);
		mnOptions.add(mntmExit);

		JLabel lblMinutes = new JLabel("  Minutes:  ");
		lblMinutes.setForeground(Color.WHITE);
		menuBar.add(lblMinutes);

		label_3 = new JLabel("3");
		label_3.setForeground(Color.ORANGE);
		menuBar.add(label_3);

		JLabel lblMoves = new JLabel("  Moves:  ");
		lblMoves.setForeground(Color.WHITE);
		menuBar.add(lblMoves);

		label_4 = new JLabel("0");
		label_4.setForeground(Color.ORANGE);
		menuBar.add(label_4);

		JLabel lblSolved = new JLabel("  Solved:  ");
		lblSolved.setForeground(Color.WHITE);
		menuBar.add(lblSolved);

		label_5 = new JLabel("0");
		label_5.setForeground(Color.ORANGE);
		menuBar.add(label_5);

	}

	public static class ValueExportTransferHandler extends TransferHandler {

		public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
		private String value;

		public String getValue() {
			return value;
		}

		public ValueExportTransferHandler(String value) {
			this.value = value;
		}

		public int getSourceActions(JComponent c) {
			return DnDConstants.ACTION_COPY_OR_MOVE;
		}

		protected Transferable createTransferable(JComponent c) {
			Transferable t = new StringSelection(getValue());
			return t;
		}

		protected void exportDone(JComponent source, Transferable data, int action) {
			label_4.setText(Integer.toString(moves));
			super.exportDone(source, data, action);
			int Aa = Integer.parseInt(btnAa.getText());
			int Ba = Integer.parseInt(btnBa.getText());
			int Ca = Integer.parseInt(btnCa.getText());
			int Ab = Integer.parseInt(btnAb.getText());
			int Bb = Integer.parseInt(btnBb.getText());
			int Cb = Integer.parseInt(btnCb.getText());
			int Ac = Integer.parseInt(btnAc.getText());
			int Bc = Integer.parseInt(btnBc.getText());
			int Cc = Integer.parseInt(btnCc.getText());

			if (Aa == Ab && Ab == Ac && Ac == Ba && Ba == Bb && Bb == Bc && Bc == Ca && Ca == Cb && Cb == Cc) {
				score--;
				moves++;
				label_4.setText(Integer.toString(moves));
			} else {
				moves++;
				label_4.setText(Integer.toString(moves));
				if (btnAa.isEnabled() == true) {
					int var = Aa + Bb + Cc;
					if (Ac + Bb + Ca == var && Aa + Ab + Ac == var && Ba + Bb + Bc == var && Ca + Cb + Cc == var
							&& Aa + Ba + Ca == var && Ab + Bb + Cb == var && Ac + Bc + Cc == var) {
						score += 5 + (500 / seconds);
						solved++;
						label_5.setText(Integer.toString(solved));
						Aa = 1 + (int) (Math.random() * 9);
						Ba = 1 + (int) (Math.random() * 9);
						Ca = 1 + (int) (Math.random() * 9);
						Ab = 1 + (int) (Math.random() * 9);
						Bb = 1 + (int) (Math.random() * 9);
						Cb = 1 + (int) (Math.random() * 9);
						Ac = 1 + (int) (Math.random() * 9);
						Bc = 1 + (int) (Math.random() * 9);
						Cc = 1 + (int) (Math.random() * 9);
						btnAa.setText(String.valueOf(Aa));
						btnBa.setText(String.valueOf(Ba));
						btnCa.setText(String.valueOf(Ca));
						btnAb.setText(String.valueOf(Ab));
						btnBb.setText(String.valueOf(Bb));
						btnCb.setText(String.valueOf(Cb));
						btnAc.setText(String.valueOf(Ac));
						btnBc.setText(String.valueOf(Bc));
						btnCc.setText(String.valueOf(Cc));
					} else {
						score--;
					}
					label_2.setText(Integer.toString(score));

					int randomNum1 = 0 + (int) (Math.random() * 200);
					int randomNum2 = 0 + (int) (Math.random() * 200);
					int randomNum3 = 0 + (int) (Math.random() * 200);
					btnAa.setBackground(new Color(randomNum1, randomNum2, randomNum3));
					btnAb.setBackground(new Color(randomNum1, randomNum2, randomNum3));
					btnAc.setBackground(new Color(randomNum1, randomNum2, randomNum3));
					btnBa.setBackground(new Color(randomNum1, randomNum2, randomNum3));
					btnBb.setBackground(new Color(randomNum1, randomNum2, randomNum3));
					btnBc.setBackground(new Color(randomNum1, randomNum2, randomNum3));
					btnCa.setBackground(new Color(randomNum1, randomNum2, randomNum3));
					btnCb.setBackground(new Color(randomNum1, randomNum2, randomNum3));
					btnCc.setBackground(new Color(randomNum1, randomNum2, randomNum3));
					label_4.getText();
				}
			}
		}

	}

	public static class ValueImportTransferHandler extends TransferHandler {

		public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

		public ValueImportTransferHandler() {
		}

		public boolean canImport(TransferHandler.TransferSupport support) {
			return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
		}

		public boolean importData(TransferHandler.TransferSupport support) {
			boolean accept = false;
			if (canImport(support) && btnAa.isEnabled() == true) {
				try {
					Transferable tr = support.getTransferable();
					Object var = tr.getTransferData(SUPPORTED_DATE_FLAVOR);
					if (var instanceof String) {
						Component component = support.getComponent();
						if (component instanceof JButton) {
							((JButton) component).setText(var.toString());
							accept = true;
						}
					}
				} catch (Exception exp) {
					exp.printStackTrace();
				}
			}
			return accept;
		}
	}

	public boolean getMnOptionsEnabled() {
		return mnOptions.isEnabled();
	}

	public void setMnOptionsEnabled(boolean enabled) {
		mnOptions.setEnabled(enabled);
	}

	public String getLabel_3Text() {
		return label_3.getText();
	}

	public void setLabel_3Text(String text) {
		label_3.setText(text);
	}
}
