package gridApp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gridApp.controller.MovePieceController;
import gridApp.controller.ResetController;
import gridApp.controller.SelectPieceController;
import gridApp.model.Model;
import gridApp.model.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GridPuzzleApp extends JFrame {

	private JPanel contentPane;
	PuzzlePanel panel;
	
	Model aModel;
	JButton upBut, rightBut, leftBut, downBut, resetBut;
	public PuzzlePanel getPuzzlePanel() {return panel;}
	public JButton getUpBut() {return upBut;}
	public JButton getRightBut() {return rightBut;}
	public JButton getLeftBut() {return leftBut;}
	public JButton getDownBut() {return downBut;}
	public JButton getResetBut() {return resetBut;}




	/**
	 * Create the frame.
	 */
	public GridPuzzleApp(Model m) {
		super();
		this.aModel = m;
		
		setTitle("Grid Puzzle App");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 629, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(aModel);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectPieceController(aModel,GridPuzzleApp.this).process(me.getPoint());
			}
			
		}
		);
		
		JLabel moveLabel = new JLabel("Winning # is");
		
		JLabel actualMoves = new JLabel(""+m.getaPuzzle().getWinNum());
		
		resetBut = new JButton("Reset");
		resetBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(aModel,GridPuzzleApp.this).reset();
			}
		});
		
		upBut = new JButton("^");
		upBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(aModel,GridPuzzleApp.this).move(MoveType.Up);
			}
		});
		
		downBut = new JButton("v");
		downBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(aModel,GridPuzzleApp.this).move(MoveType.Down);
			}
		});
		
		leftBut = new JButton("<");
		leftBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(aModel,GridPuzzleApp.this).move(MoveType.Left);
			}
		});
		
		rightBut = new JButton(">");
		rightBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(aModel,GridPuzzleApp.this).move(MoveType.Right);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(60)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(8)
												.addComponent(leftBut)
												.addGap(34)
												.addComponent(rightBut))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(moveLabel)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(actualMoves, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(106)
										.addComponent(upBut)
										.addGap(37)))
								.addGap(59))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(downBut)
								.addGap(97)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(resetBut)))
					.addGap(59))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(moveLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(actualMoves))
							.addGap(49)
							.addComponent(upBut)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rightBut, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(leftBut, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(downBut, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetBut)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		UpdateButtons.enableButtons(this, new ArrayList<MoveType>());
	}
}
