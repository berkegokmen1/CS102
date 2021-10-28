package gui;

import gui.shapes.Balloon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BalloonsGamePanel extends JPanel {

  public static Random R;
  public static final Dimension SCREEN_SIZE = Toolkit
    .getDefaultToolkit()
    .getScreenSize();

  private final BalloonsGamePanel THIS_PANEL = this;

  private final int TIMER_MS = 33;
  private final int RANDOM_NUMBER_BALLOONS = 15;
  private final int DOT_RADIUS = 4;

  private BalloonContainer balloons;
  private Timer timer;

  private ActionListener timerListener;
  private MouseListener burstListener;

  private JLabel label;
  private JLabel elapsedTimeLabel;

  private double elapsedTime; // in seconds

  private int points;

  private class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (elapsedTime >= 60) {
        int option = JOptionPane.showConfirmDialog(
          null,
          ("Score:" + points) + "\n" + "Play Again?",
          "Balloon Game",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.QUESTION_MESSAGE
        );

        if (option == JOptionPane.YES_OPTION) {
          timer.stop();
          THIS_PANEL.setupGame();
        } else if (
          option == JOptionPane.NO_OPTION || option == JOptionPane.CLOSED_OPTION
        ) {
          timer.stop();
          System.exit(0);
        }
      } else {
        elapsedTime += TIMER_MS * (1.0 / 1000);
        elapsedTimeLabel.setText("Elapsed time: " + (int) elapsedTime);

        balloons.grow();

        // Returnes the number of 'hitted' balloons, not 'selected'
        int n = balloons.removeSelected();

        if (n >= 2) {
          points += 1;
          label.setText("Points: " + points);
        }

        if (balloons.size() <= 20) {
          THIS_PANEL.createRandomBalloon();
        }

        THIS_PANEL.repaint();
      }
    }
  }

  private class BurstListener implements MouseListener {

    @Override
    public void mousePressed(MouseEvent e) {
      balloons.selectAllAt(e.getX(), e.getY());
      THIS_PANEL.putDot(THIS_PANEL.getGraphics(), e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
  }

  public BalloonsGamePanel() {
    super();
    setSize(SCREEN_SIZE);
    setupGame();
  }

  private void setupGame() {
    if (label != null) {
      this.remove(label);
    }
    if (elapsedTimeLabel != null) {
      this.remove(elapsedTimeLabel);
    }

    balloons = new BalloonContainer();
    timerListener = new TimerListener();
    burstListener = new BurstListener();
    timer = new Timer(TIMER_MS, timerListener);
    R = new Random();
    label = new JLabel("Points: 0");
    label.setForeground(Color.BLACK);
    elapsedTimeLabel = new JLabel("Elapsed time: 0");
    elapsedTimeLabel.setForeground(Color.BLACK);

    points = 0;

    this.add(label);
    this.add(elapsedTimeLabel);

    this.addMouseListener(burstListener);

    this.createRandomBalloons();

    elapsedTime = 0;
    timer.start();
  }

  private void createRandomBalloon() {
    int x = R.nextInt(this.getWidth());
    int y = R.nextInt(this.getHeight());

    Balloon balloon = new Balloon(x, y);

    balloons.add(balloon);
  }

  private void createRandomBalloons() {
    for (int i = 1; i <= RANDOM_NUMBER_BALLOONS; i++) {
      this.createRandomBalloon();
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    balloons.draw(g);
  }

  public void putDot(Graphics g, int x, int y) {
    g.setColor(Color.RED);
    g.drawOval(x - DOT_RADIUS, y - DOT_RADIUS, DOT_RADIUS * 2, DOT_RADIUS * 2);
  }
}
