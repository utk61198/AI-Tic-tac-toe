package tictactoe;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TTTgame extends JFrame {

    int index1 = 0;
    int index2 = 0;
    int move_count = 0;

    private class Node extends JButton {

        char value;
        int label;
        boolean used;

    }

    Node[] node = new Node[9];
    JPanel board_panel = new JPanel(new GridLayout(3, 3));
    ArrayList computer_list = new ArrayList<Integer>();
    ArrayList human_list = new ArrayList<Integer>();

    public TTTgame() {

        this.setLayout(null);
        this.setSize(500, 300);
        for (int i = 0; i < 9; i++) {
            node[i] = new Node();

        }

        node[0].label = 2;
        node[1].label = 7;
        node[2].label = 6;
        node[3].label = 9;
        node[4].label = 5;
        node[5].label = 1;
        node[6].label = 4;
        node[7].label = 3;
        node[8].label = 8;

        for (int i = 0; i < 9; i++) {
            board_panel.add(node[i]);
        }
        node[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                human_list.add(node[0].label);
                node[0].setText("O");
                node[0].value = 'O';
                node[0].used = true;
                move_count++;
                playGame();

            }
        });
        node[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                human_list.add(node[1].label);
                node[1].setText("O");
                node[1].value = 'O';
                node[1].used = true;
                move_count++;

                playGame();

            }
        });
        node[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                human_list.add(node[2].label);
                node[2].setText("O");
                node[2].value = 'O';
                node[2].used = true;
                move_count++;

                playGame();

            }
        });
        node[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                human_list.add(node[3].label);
                node[3].setText("O");
                node[3].value = 'O';
                node[3].used = true;
                move_count++;

                playGame();

            }
        });

        node[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                human_list.add(node[4].label);
                node[4].setText("O");
                node[4].value = 'O';
                node[4].used = true;
                move_count++;

                playGame();

            }
        });
        node[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                human_list.add(node[5].label);
                node[5].setText("O");
                node[5].value = 'O';
                node[5].used = true;
                move_count++;

                playGame();

            }
        });

        node[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                human_list.add(node[6].label);
                node[6].setText("O");
                node[6].value = 'O';
                node[6].used = true;
                move_count++;

                playGame();

            }
        });
        node[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                human_list.add(node[7].label);
                node[7].setText("O");
                node[7].value = 'O';
                node[7].used = true;
                move_count++;

                playGame();

            }
        });
        node[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                human_list.add(node[8].label);
                node[8].setText("O");
                node[8].value = 'O';
                node[8].used = true;
                move_count++;

                playGame();

            }
        });

        board_panel.setBounds(0, 10, 200, 200);
        this.add(board_panel);
        this.setVisible(true);
        startGame();
        System.out.print(computer_list);
    }

    public void startGame() {
        String answer = JOptionPane.showInputDialog(this, "press 1 if you want to play first or press 0");
        if (Integer.parseInt(answer) == 0) {

            node[4].setText("X");
            node[4].value = 'X';
            node[4].used = true;
            computer_list.add(node[4].label);
            move_count++;

        }

    }

    public void playGame() {

        ArrayList<ArrayList<Integer>> computer_options = subset(computer_list);
        ArrayList<ArrayList<Integer>> human_options = subset(human_list);
        boolean flag = true;
        if (move_count < 3) {
            if (move_count == 1) {
                if (node[4].used == false) {
                    node[4].setText("X");
                    node[4].value = 'X';
                    node[4].used = true;
                    computer_list.add(node[4].label);
                    flag = false;
                    move_count++;

                } else if (node[0].used == false && node[8].used == false) {
                    node[0].setText("X");
                    node[0].value = 'X';
                    node[0].used = true;
                    computer_list.add(node[0].label);
                    flag = false;
                    move_count++;
                } else if (node[2].used == false && node[6].used == false) {

                    node[2].setText("X");
                    node[2].value = 'X';
                    node[2].used = true;
                    computer_list.add(node[2].label);
                    flag = false;
                    move_count++;

                }
            } else if (node[0].used == false && node[8].used == false) {
                node[0].setText("X");
                node[0].value = 'X';
                node[0].used = true;
                computer_list.add(node[0].label);
                flag = false;
                move_count++;
            } else if (node[2].used == false && node[6].used == false) {

                node[2].setText("X");
                node[2].value = 'X';
                node[2].used = true;
                computer_list.add(node[2].label);
                flag = false;
                move_count++;

            }
        } else {
            for (int i = 0; i < computer_options.size(); i++) {
                if (flag) {
                    ArrayList<Integer> temp_list = computer_options.get(i);
                    int sum = temp_list.get(0) + temp_list.get(1);
                    System.out.println(15 - sum);

                    if (!checkPresent(sum) && ((15 - sum) > 0 && (15 - sum) <= 9)) {

                        int node_index = checkNode(sum);
                        node[node_index].setText("X");
                        node[node_index].value = 'X';
                        node[node_index].used = true;
                        computer_list.add(node[node_index].label);
                        move_count++;
                        flag = false;

                    }
                }

            }

            if (flag) {

                for (int i = 0; i < human_options.size(); i++) {
                    if (flag) {
                        ArrayList<Integer> temp_list = human_options.get(i);
                        int sum = temp_list.get(0) + temp_list.get(1);
                        System.out.println(15 - sum);
                        if (!checkPresent(sum) && ((15 - sum) > 0 && (15 - sum) <= 9)) {

                            int node_index = checkNode(sum);
                            node[node_index].setText("X");
                            node[node_index].value = 'X';
                            node[node_index].used = true;
                            computer_list.add(node[node_index].label);
                            move_count++;
                            flag = false;

                        }

                    }
                }

            }

        }
        
        if(flag){
            for(int i=0;i<9;i++){
                if(node[i].used==false){
                    node[i].setText("X");
                    node[i].value='X';
                    node[i].used=true;
                    computer_list.add(node[i].label);
                    move_count++;
                    flag=false;
                    break;
                
                }
            }
            
        }
    }

    public boolean checkPresent(int sum) {
        boolean check = false;

        for (int i = 0; i < 9; i++) {
            if ((15 - sum) == node[i].label) {
                if (node[i].used == true) {
                    check = true;
                }

            }

        }
        return check;

    }

    public int checkNode(int sum) {

        int node_index = -1;
        for (int i = 0; i < 9; i++) {
            if (node[i].label == 15 - sum) {
                node_index = i;

            }
        }

        return node_index;

    }

    public ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> list) {

        ArrayList<ArrayList<Integer>> subset_list = new ArrayList<>();
        if (list.size() == 1) {
            ArrayList<Integer> temp_list = new ArrayList<Integer>();

            temp_list.add(list.get(0));
            temp_list.add(0);
            subset_list.add(temp_list);

        } else {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    ArrayList<Integer> temp_list = new ArrayList<Integer>();
                    temp_list.add(list.get(i));
                    temp_list.add(list.get(j));
                    subset_list.add(temp_list);

                }

            }
        }
        return subset_list;

    }

    public void humanTurn() {

    }

    public void computerTurn() {
    }

    public boolean gameCompleted() {
        boolean flag = true;
        for (int i = 0; i < 9; i++) {
            if (node[i].used == false) {
                flag = false;
            }
        }
        return flag;

    }

    public static void main(String[] args) {
        TTTgame obj = new TTTgame();
        obj.setVisible(true);

    }

}
