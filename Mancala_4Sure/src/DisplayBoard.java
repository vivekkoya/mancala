package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DisplayBoard implements ChangeListener {

	private JFrame frame;
	private Pit[] gpc_top, gpc_bottom;
	private Pit lh, rh;
	private final BoardData data;

	private void show() {
		this.frame.pack();
		this.frame.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				DisplayBoard window = new DisplayBoard();
				window.show();

			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayBoard() {
		data = new BoardData(4);
		gpc_top = new Pit[6];
		gpc_bottom = new Pit[6];
		lh = new Pit();
		rh = new Pit();
		frame = new JFrame();
		data.addListener(this);
		initialize();

	}

	public Pit[] getBottom() {
		return this.gpc_bottom;
	}

	public Pit[] getTop() {
		return this.gpc_top;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame.setBounds(100, 100, 450, 300);
		// frame.se`
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		// gridBagLayout.columnWidths = new int[] { 0, 8 };
		// gridBagLayout.rowHeights = new int[] { 0, 1 };
		// gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		// gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_leftouter = new GridBagConstraints();
		gbc_leftouter.fill = GridBagConstraints.VERTICAL;
		gbc_leftouter.gridx = 0;
		gbc_leftouter.gridy = 0;
		gbc_leftouter.gridheight = 2;
		gbc_leftouter.weighty = 2;
		GridBagConstraints gbc_rightouter = new GridBagConstraints();
		gbc_rightouter.fill = GridBagConstraints.VERTICAL;
		gbc_rightouter.gridx = 7;
		gbc_rightouter.gridy = 0;
		gbc_rightouter.gridheight = 2;
		gbc_rightouter.weighty = 2;
		GridBagConstraints gbc_innertop = new GridBagConstraints(), gbc_innerbottom = new GridBagConstraints();
		// Set constraints to gbc_leftouter
		// panel.add(new JButton("Left holder"));
		lh = new Pit("Left holder");
		lh.setPreferredSize(new Dimension(250, 400));
		frame.getContentPane().add(lh, gbc_leftouter);

		for (int i = 1; i < 7; i++) {
			JPanel panel = new JPanel();
			panel.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
			gbc_innertop.gridx = i;
			gbc_innertop.gridy = 0;
			gbc_innertop.insets = new Insets(0, 5, 0, 5);
			gbc_innertop.gridheight = 1;
			gbc_innertop.weighty = 1;
			// top pits
			int y = i - 1;
			gpc_top[y] = new Pit();
			gpc_top[y].addActionListener((e) -> {
				data.turn(5 - y);
			});
			frame.getContentPane().add(gpc_top[i - 1], gbc_innertop);
			gpc_bottom[y] = new Pit();
			gpc_bottom[y].addActionListener((e) -> {
				data.turn(y);
			});
			gbc_innerbottom.gridx = i;
			gbc_innerbottom.gridy = 1;
			gbc_innerbottom.insets = new Insets(0, 5, 0, 5);
			gbc_innerbottom.gridheight = 1;
			gbc_innerbottom.weighty = 1;
			// bottom pits
			frame.getContentPane().add(gpc_bottom[i - 1], gbc_innerbottom);
		}
		// Set constraints to gbc_leftouter
		// panel.add(new JButton("Right holder"));
		rh = new Pit("Right holder");
		rh.setPreferredSize(new Dimension(250, 400));
		frame.getContentPane().add(rh, gbc_rightouter);
		updateMarbles();
		disableButtons();
		/**
		 * @see SetColor in progress
		 */
		lh.setEnabled(false);
//		lh.setBorderPainted(true);
		lh.setColor(new Color(255, 0, 0));

		rh.setEnabled(false);

		gbc_innerbottom.fill = GridBagConstraints.HORIZONTAL;
		gbc_innerbottom.gridx = 0;
		gbc_innerbottom.gridy = 2;
		gbc_innertop.insets = new Insets(0, 2, 0, 2);
		gbc_innerbottom.gridheight = 1;
		gbc_innerbottom.weighty = 1;
		JButton reset = new JButton("undo");
//		reset.addActionListener((ActionListener) new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// trigger undo logic in BoardData
//
//			}
//		});
		// reset.addActionListener(new actionListener());
		frame.getContentPane().add(reset, gbc_innerbottom);

		// GridBagConstraints gbc_panel = new GridBagConstraints();
		// gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		// gbc_panel.gridx = 0;
		// gbc_panel.gridy = 0;
		// frame.getContentPane().add(panel, gbc_panel);
	}

//	public void populate() {
//		for (Pit i : gpc_bottom) {
//			i.setMarbles(4);
//		}
//
//	}
	/**
	 * @See link count of marbles from data to view
	 */
	void updateMarbles() {
		for (int i = 0; i < 6; i++) {
			// gpc_bottom[i].setMarbles(4);
			gpc_bottom[i].setMarbles(data.getBoard().get(0).get(i));
			// gpc_top[i].setMarbles(4);
			gpc_top[i].setMarbles(data.getBoard().get(1).get(5 - i));
		}
	}

	public void disableButtons() {

		if (data.getTurn() == true) {
			for (int i = 0; i < gpc_top.length; i++) {
				System.out.println(gpc_top[i] + "top");
				gpc_top[i].setEnabled(false);
				gpc_bottom[i].setEnabled(true);
				System.out.println("REACHED");
			}
		} else if (data.getTurn() == false) {
			for (int i = 0; i < gpc_bottom.length; i++) {
				gpc_bottom[i].setEnabled(false);
				gpc_top[i].setEnabled(true);
				System.out.println("REACHED");
			}
		}

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		disableButtons();
		this.updateMarbles();
	}

	// lh.setMarbles(2);

}