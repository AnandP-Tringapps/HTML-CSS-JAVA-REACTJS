package com.Numpuzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class NumberPuzzle extends JPanel {

	// size and position of puzzle
	private int size;
	private int numbers;
	private int position;
	private static final Color FOREGROUND_COLOR = new Color(255, 255, 255); // color of puzzle

	// Random object to shuffle tiles

	private static final Random RANDOM = new Random();
	private int[] numberbox;
	private int numberbox_size;
	private int blankplaces;
	private int margin;
	private int boxsize;
	private boolean gameover;

	public NumberPuzzle(int size, int position, int margin) {
		this.size = size;
		this.position = position;
		this.margin = margin;

		numbers = size * size - 1; // blank does not count
		numberbox = new int[size * size];

		// calculate grid size and tile size
		boxsize = (position - 2 * margin);
		numberbox_size = boxsize / size;

		setPreferredSize(new Dimension(position, position + margin));
		setBackground(Color.GREEN);
		setForeground(FOREGROUND_COLOR);
		setFont(new Font("SansSerif", Font.BOLD, 20));

		gameover = true;

		// Mouse clicks on the JFrame
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent move) {
				if (gameover) {
					newGame();
				} else {
					// get position of the click
					int xaxismouse = move.getX() - margin;
					int yaxismouse = move.getY() - margin;

					if (xaxismouse < 0 || xaxismouse > boxsize || yaxismouse < 0 || yaxismouse > boxsize)
						return;

					int column1 = xaxismouse / numberbox_size; // get position in the grid
					int row1 = yaxismouse / numberbox_size;

					int column2 = blankplaces % size; // get position of the blank cell
					int row2 = blankplaces / size;
					int clickposition = row1 * size + column1;
					int dir = 0;

					if (column1 == column2 && Math.abs(row1 - row2) > 0)
						dir = (row1 - row2) > 0 ? size : -size;
					else if (row1 == row2 && Math.abs(column1 - column2) > 0)
						dir = (column1 - column2) > 0 ? 1 : -1;

					if (dir != 0) {

						do {
							int blankbox = blankplaces + dir;
							numberbox[blankplaces] = numberbox[blankbox];
							blankplaces = blankbox;
						} while (blankplaces != clickposition);

						numberbox[blankplaces] = 0;
					}

					gameover = issolved();
				}

				repaint();
			}
		});

		newGame();
	}

	private void newGame() {
		do {
			reset(); // reset in intial state
			shuffle();
		} while (!issolvable());

		gameover = false;
	}

	private void reset() {
		for (int i = 0; i < numberbox.length; i++) {
			numberbox[i] = (i + 1) % numberbox.length;
		}

		blankplaces = numberbox.length - 1;
	}

	// suffle the numbers in the game

	private void shuffle() {
		int number = numbers;

		while (number > 1) {
			int row = RANDOM.nextInt(number--);
			int tmp = numberbox[row];
			numberbox[row] = numberbox[number];
			numberbox[number] = tmp;
		}
	}

	private boolean issolvable() {
		int countbox = 0;

		for (int i = 0; i < numbers; i++) {
			for (int j = 0; j < i; j++) {
				if (numberbox[j] > numberbox[i])
					countbox++;
			}
		}

		return countbox % 2 == 0;
	}

	private boolean issolved() {
		if (numberbox[numberbox.length - 1] != 0) // for blank box
			return false;

		for (int i = numbers - 1; i >= 0; i--) {
			if (numberbox[i] != i + 1)
				return false;
		}

		return true;
	}

	private void boxgrid(Graphics2D complete) {
		for (int i = 0; i < numberbox.length; i++) {

			int row = i / size;
			int column = i % size;
			int xaxis = margin + column * numberbox_size;
			int yaxis = margin + row * numberbox_size;

			// check special case for blank box

			if (numberbox[i] == 0) {
				if (gameover) {
					complete.setColor(FOREGROUND_COLOR);
					drawcenter(complete, "\u2713", xaxis, yaxis);
				}

				continue;
			}

			// for other bpxes
			complete.setColor(getForeground());
			complete.fillRoundRect(xaxis, yaxis, numberbox_size, numberbox_size, 12, 12);
			complete.setColor(Color.BLUE);
			complete.drawRoundRect(xaxis, yaxis, numberbox_size, numberbox_size, 12, 12);
			complete.setColor(Color.BLACK);

			drawcenter(complete, String.valueOf(numberbox[i]), xaxis, yaxis);
		}
	}

	// To start new game

	private void startgame(Graphics2D box) {
		if (gameover) {
			box.setFont(getFont().deriveFont(Font.BOLD, 18));
			box.setColor(FOREGROUND_COLOR);
			String s = "Click to start new Number Puzzle Game!!";
			box.drawString(s, (getWidth() - box.getFontMetrics().stringWidth(s)) / 2, getHeight() - margin);
		}
	}

	private void drawcenter(Graphics2D center, String puzzle, int x, int y) {

		FontMetrics fm = center.getFontMetrics();
		int asc = fm.getAscent();
		int desc = fm.getDescent();
		center.drawString(puzzle, x + (numberbox_size - fm.stringWidth(puzzle)) / 2,
				y + (asc + (numberbox_size - (asc + desc)) / 2));
	}

	@Override
	protected void paintComponent(Graphics complete) {
		super.paintComponent(complete);
		Graphics2D g2D = (Graphics2D) complete;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		boxgrid(g2D);
		startgame(g2D);
	}

	// Title name on JFrame

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Number Puzzle Game using JAVA");
			frame.setResizable(false);
			frame.add(new NumberPuzzle(3, 400, 70), BorderLayout.CENTER);
			frame.pack();
			// center on the screen
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}

}
