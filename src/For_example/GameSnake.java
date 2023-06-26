package For_example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameSnake {

    final String TITLE_OF_PROGRAM = "Classic Game Snake";
    final String GAME_OVER_MSG = "GAME OVER";
    final int POINT_RADIUS = 20; // in pix
    final int FILLED_WIDTH = 20; //in point
    final int FILLED_HEIGHT = 20; // in point
    final int START_LOCATION = 300;
    final int START_SNAKE_SIZE = 6;
    final int START_SNAKE_X = 10;
    final int START_SNAKE_Y = 10;
    final int SHOW_DEALAY = 150;
    final int LEFT = 37;
    final int UP = 38;
    final int RIGHT = 39;
    final int DOWN = 40;
    final int SPACE = 0;
    final int START_DIRECTION = RIGHT;
    final Color SNAKE_COLOR = Color.green;
    final Color FOOD_COLOR = Color.BLACK;
    final Color POISON_COLOR = Color.red;
    Snake snake;
    Food food;
    //Poison poison;
    JFrame frame;
    JFrame frameSt;
    Canvas canvasPanel;
    Start start;
    Random random = new Random();
    boolean gameOver = false;


    ///////////////////////////////////////////MAIN////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        //����� ���� ������
        new GameSnake().st();
        //����� ���� ����
        new GameSnake().go();
    }

    ///////////////////////////////////////////////////GO//////////////////////////////////////////////////////

//����� ����
    void go() {
        //�������� ���� ����
        frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(FILLED_WIDTH * POINT_RADIUS + 13, FILLED_HEIGHT * POINT_RADIUS + 36);
        frame.setLocation(START_LOCATION, START_LOCATION);
        frame.setResizable(false);
        frame.toBack();
        //������� ������ � ���� ����
        canvasPanel = new Canvas();
        canvasPanel.setBackground(Color.gray);
        //�������������
        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
        //������������ ��������
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });

        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION); //������� ����� ������
        food = new Food(); //������� ����� ����� � ����

        while (!gameOver) { //���� ���� �� ��������
            snake.move(); //������ ����
            if (food.isEaten()) food.next();  //���� ����� ������� - ������� ����� �����

            canvasPanel.repaint(); //����������� � ������� ����� ����� � ������

            try {
                Thread.sleep(SHOW_DEALAY); //�������� �������� ������
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//����� ���� �����
    void st() {
        //�������� ����
        frameSt = new JFrame("Game SNAKE");
        frameSt.setVisible(true);
        frameSt.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameSt.setSize(FILLED_WIDTH * POINT_RADIUS + 13, FILLED_HEIGHT * POINT_RADIUS + 36);
        frameSt.setResizable(false);
        frameSt.setLocation(START_LOCATION, START_LOCATION);
        frameSt.toFront();
        //������� ������ � ���� ����
        start = new Start();
        start.setBackground(Color.gray);

        frameSt.getContentPane().add(BorderLayout.CENTER, start);
    }


    /////////////////////////////////////////SNAKE/////////////////////////////////////////////////////


    class Snake {
        //������� ������ ������
        ArrayList<Point> snake = new ArrayList<>();
        int direction;

        //��������� ������ �������������� ����.
        public Snake(int x, int y, int length, int direction) {
            for (int i = 0; i < length; i++) {
                Point point = new Point(x - i, y);
                snake.add(point);
            }
            this.direction = direction;
        }
        //����� �������� �� ����� �� ���� ���� �� ����
        boolean isInsideSnake(int x, int y) {
            for (Point point : snake) {
                if ((point.getX() == x) && (point.getY() == y))
                    return true;
            }
            return false;
        }
        //����� ���������, �������� �� ���������� ����� ����
        boolean isFood(Point food) {
            return ((snake.get(0).getX() == food.getX()) && (snake.get(0).getY() == food.getY()));
        }

        //����� ��������
        void move() {
            //�������� ��������� ������ ����� � ������ ������
            int x = snake.get(0).getX();
            int y = snake.get(0).getY();
            //�������� ��� ������� �� �������
            if (direction == LEFT) {
                x--;
            }
            if (direction == RIGHT) {
                x++;
            }
            if (direction == UP) {
                y--;
            }
            if (direction == DOWN) {
                y++;
            }
            //������� ������ ���� ��� �� ��������� � ������� ����
            if (x > FILLED_WIDTH - 1) {
                x = 0;
            }
            if (x < 0) {
                x = FILLED_WIDTH - 1;
            }
            if (y > FILLED_WIDTH - 1) {
                y = 0;
            }
            if (y < 0) {
                y = FILLED_HEIGHT - 1;
            }

            //����� ����, �������� ������
            gameOver = isInsideSnake(x, y);

            //��������� � ������ ����� ��������� �����
            snake.add(0, new Point(x, y));

            if (isFood(food)) { //���� ����� ��� ���?
                food.eat(); // ����
                frame.setTitle(TITLE_OF_PROGRAM + " : " + snake.size()); //������ ����� ������ � ���������
            } else {
                snake.remove(snake.size() - 1); //���� ��������� ����� ������
            }
        }

        void setDirection(int direction) {
            if ((direction >= LEFT) && (direction <= DOWN)) {
                if (Math.abs(this.direction - direction) != 2) {
                    this.direction = direction;
                }
            }
        }

        void paint(Graphics g) {
            for (Point point : snake) {
                point.paint(g);
            }
        }
    }


    ////////////////////////////////////////////////////FOOD/////////////////////////////////////////////


    class Food extends Point {

        public Food() {
            super(-1, -1);
            this.color = FOOD_COLOR;
        }

        void eat() {
            this.setXY(-1, -1);
        }
        //���� ����� ���� �������
        boolean isEaten() {
            return this.getX() == -1;
        }
        //������ ��������� ��������� ����� ���
        void next() {
            int x, y;
            do {
                x = random.nextInt(FILLED_WIDTH);
                y = random.nextInt(FILLED_HEIGHT);
            } while (snake.isInsideSnake(x, y));
            this.setXY(x, y);
        }
    }


    ////////////////////////////////////////////POINT/////////////////////////////////////////////////////


    class Point {
        int x, y;
        Color color = SNAKE_COLOR;

        public Point(int x, int y) {
            this.setXY(x, y);
        }

        void paint(Graphics g) {
            g.setColor(color);
            g.fillRect(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    /////////////////////////////////////////////���� ����////////////////////////////////////////////////


    public class Canvas extends JPanel {

        @Override
        public void paint(Graphics q) {
            super.paint(q);
            snake.paint(q);
            food.paint(q);
            q.setColor(Color.DARK_GRAY);
            for (int i = 0; i < 400; i += 20) {
                for (int j = 0; j < 400; j += 20) {
                    q.drawRect(i, j, POINT_RADIUS, POINT_RADIUS);
                    q.drawRect(j, i, POINT_RADIUS, POINT_RADIUS);
                }
            }
            if (gameOver) {
                q.setColor(Color.red);
                q.setFont(new Font("Arial", Font.BOLD, 38));
                FontMetrics fm = q.getFontMetrics();
                q.drawString(GAME_OVER_MSG, (FILLED_WIDTH * POINT_RADIUS - fm.stringWidth(GAME_OVER_MSG)) / 2,
                        (FILLED_HEIGHT * POINT_RADIUS) / 2);
            }
        }
    }


    /////////////////////////////////////////////���� �����////////////////////////////////////////////////


    public class Start extends JPanel {

        @Override
        public void paint(Graphics q) {

            JButton button = new JButton("Start game!");
            frameSt.add(button);
            button.setBounds(150, 220, 100, 30);
            button.setVisible(true);

            super.paint(q);
            q.setColor(Color.green);
            q.setFont(new Font("Arial", Font.BOLD, 38));
            FontMetrics start = q.getFontMetrics();
            q.drawString("SNAKE", (FILLED_WIDTH * POINT_RADIUS - start.stringWidth("SNAKE")) / 2,
                    (FILLED_HEIGHT * POINT_RADIUS) / 2);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frameSt.toBack();
                }
            });
        }
    }
}
