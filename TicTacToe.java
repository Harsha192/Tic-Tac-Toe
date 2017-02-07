import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by New on 2016-09-09.
 * Author : H.R.H.G. Kosala (E/13/192)
 * Poblem : TicTacToe
 */

public class TicTacToe extends JFrame implements ActionListener{
    //JButtons declaration
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
    private JButton jb6;
    private JButton jb7;
    private JButton jb8;
    private JButton jb9;
    private JButton resetGame;

    //count for count the all times click the buttons
    private static int count = 0;

    //constructor
    public TicTacToe(){
        //Set the JFrame
        this.setLayout(null);
        this.setSize(350,410);
        this.setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the buttons on the JFrame
        jb1 = new JButton();
        jb1.setBounds(10,10,100,100);
        jb1.addActionListener(this);
        add(jb1);

        jb2 = new JButton();
        jb2.setBounds(120,10,100,100);
        jb2.addActionListener(this);
        add(jb2);

        jb3 = new JButton();
        jb3.setBounds(230,10,100,100);
        jb3.addActionListener(this);
        add(jb3);

        jb4 = new JButton();
        jb4.setBounds(10,120,100,100);
        jb4.addActionListener(this);
        add(jb4);

        jb5 = new JButton();
        jb5.setBounds(120,120,100,100);
        jb5.addActionListener(this);
        add(jb5);

        jb6 = new JButton();
        jb6.setBounds(230,120,100,100);
        jb6.addActionListener(this);
        add(jb6);

        jb7 = new JButton();
        jb7.setBounds(10,230,100,100);
        jb7.addActionListener(this);
        add(jb7);

        jb8 = new JButton();
        jb8.setBounds(120,230,100,100);
        jb8.addActionListener(this);
        add(jb8);

        jb9 = new JButton();
        jb9.setBounds(230,230,100,100);
        jb9.addActionListener(this);
        add(jb9);

        //resetGame button to reset the game
        resetGame = new JButton("Reset");
        resetGame.setBounds(120,340,100,30);
        resetGame.addActionListener(this);
        add(resetGame);

        //privent resize the window
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //check the which button is clicked an add action to each buttons
        if(e.getSource()==jb1){
            jb1.setText("X");
            jb1.setEnabled(false);
            this.setButton(); //this method is set click a button for computer selection
        }
        if(e.getSource()==jb2){
            jb2.setText("X");
            jb2.setEnabled(false);
            setButton();
        }
        if(e.getSource()==jb3 ){
            jb3.setText("X");
            jb3.setEnabled(false);
            setButton();
        }
        if(e.getSource()==jb4 ){
            jb4.setText("X");
            jb4.setEnabled(false);
            setButton();
        }
        if(e.getSource()==jb5 ){
            jb5.setText("X");
            jb5.setEnabled(false);
            setButton();
        }
        if(e.getSource()==jb6 ){
            jb6.setText("X");
            jb6.setEnabled(false);
            setButton();
        }
        if(e.getSource()==jb7){
            jb7.setText("X");
            jb7.setEnabled(false);
            setButton();
        }
        if(e.getSource()==jb8 ){
            jb8.setText("X");
            jb8.setEnabled(false);
            setButton();
        }
        if(e.getSource()==jb9){
            jb9.setText("X");
            jb9.setEnabled(false);
            setButton();
        }
        if (e.getSource()==resetGame){
            reset(""); //reset the window
        }
        count++;
        this.checkWin(); //each time button clicked, check a any player win or not
    }

    //this method to set a random number between 1-9 to picka button
    public int comChance(){
        Random rn = new Random();
        int num = rn.nextInt(10-1) +1;
        return num;
    }

    //select a button for a chance of computer
    public void setButton(){
        int rndmNum = 0;
        int round=0;
        while (true){
            rndmNum= comChance();
            //check selected button already selected or not
            if (checkCliked(rndmNum) || count==4){
                if (preventWin(rndmNum)){
                    break;
                }else if(count==0|| count==3){
                    break;
                }else if(round>50){
                    break;
                }
            }
            round++; //check how many times loop done
        }
        //set 0 for button acording to a random number selection
        switch (rndmNum){
            case 1 :    jb1.setText("0");
                        jb1.setEnabled(false); //each time button was clicked it's disable to click again
                        break;
            case 2 :    jb2.setText("0");
                        jb2.setEnabled(false);
                        break;
            case 3 :    jb3.setText("0");
                        jb3.setEnabled(false);
                        break;
            case 4 :    jb4.setText("0");
                        jb4.setEnabled(false);
                        break;
            case 5 :    jb5.setText("0");
                        jb5.setEnabled(false);
                        break;
            case 6 :    jb6.setText("0");
                        jb6.setEnabled(false);
                        break;
            case 7 :    jb7.setText("0");
                        jb7.setEnabled(false);
                        break;
            case 8 :    jb8.setText("0");
                        jb8.setEnabled(false);
                        break;
            case 9 :    jb9.setText("0");
                        jb9.setEnabled(false);
                        break;
        }
        checkWin();
    }

    //check weather the button is clicked or not
    public boolean checkCliked(int rndmNum){
        boolean result = false;
        if (rndmNum==1 && jb1.getText().equals("")){
            result = true;
        }else if(rndmNum==2 && jb2.getText().equals("")){
            result = true;
        }else if(rndmNum==3 && jb3.getText().equals("")){
            result = true;
        }else if(rndmNum==4 && jb4.getText().equals("")){
            result = true;
        }else if(rndmNum==5 && jb5.getText().equals("")){
            result = true;
        }else if(rndmNum==6 && jb6.getText().equals("")){
            result = true;
        }else if(rndmNum==7 && jb7.getText().equals("")){
            result = true;
        }else if(rndmNum==8 && jb8.getText().equals("")){
            result = true;
        }else if(rndmNum==9 && jb9.getText().equals("")){
            result = true;
        }
        return result;
    }

    //check player win or not
    public void checkWin(){
        if (jb1.getText().equals("X") && jb2.getText().equals("X") && jb3.getText().equals("X")){
            this.reset(jb1.getText());
        }else if(jb4.getText().equals("X") && jb5.getText().equals("X") && jb6.getText().equals("X")){
            this.reset(jb4.getText());
        }else if(jb7.getText().equals("X") && jb8.getText().equals("X") && jb9.getText().equals("X")){
            this.reset(jb7.getText());
        }else if(jb1.getText().equals("X") && jb4.getText().equals("X") && jb7.getText().equals("X")){
            this.reset(jb1.getText());
        }else if(jb2.getText().equals("X") && jb5.getText().equals("X") && jb8.getText().equals("X")){
            this.reset(jb2.getText());
        }else if(jb3.getText().equals("X") && jb6.getText().equals("X") && jb9.getText().equals("X")){
            this.reset(jb3.getText());
        }else if(jb1.getText().equals("X") && jb5.getText().equals("X") && jb9.getText().equals("X")){
            this.reset(jb1.getText());
        }else if(jb3.getText().equals("X") && jb5.getText().equals("X") && jb7.getText().equals("X")){
            this.reset(jb3.getText());
        }else if(jb1.getText().equals("0") && jb2.getText().equals("0") && jb3.getText().equals("0")){
            this.reset(jb1.getText());
        }else if(jb4.getText().equals("0") && jb5.getText().equals("0") && jb6.getText().equals("0")){
            this.reset(jb4.getText());
        }else if(jb7.getText().equals("0") && jb8.getText().equals("0") && jb9.getText().equals("0")){
            this.reset(jb7.getText());
        }else if(jb1.getText().equals("0") && jb4.getText().equals("0") && jb7.getText().equals("0")){
            this.reset(jb1.getText());
        }else if(jb2.getText().equals("0") && jb5.getText().equals("0") && jb8.getText().equals("0")){
            this.reset(jb2.getText());
        }else if(jb3.getText().equals("0") && jb6.getText().equals("0") && jb9.getText().equals("0")){
            this.reset(jb3.getText());
        }else if(jb1.getText().equals("0") && jb5.getText().equals("0") && jb9.getText().equals("0")){
            this.reset(jb1.getText());
        }else if(jb3.getText().equals("0") && jb5.getText().equals("0") && jb7.getText().equals("0")){
            this.reset(jb3.getText());
        }else if(!jb1.getText().equals("")&& !jb5.getText().equals("")&& !jb9.getText().equals("")&& !jb3.getText().equals("")&& !jb7.getText().equals("")&&!jb2.getText().equals("")&&!jb8.getText().equals("")&&!jb4.getText().equals("")&&!jb6.getText().equals("")) {
            this.reset("");
        }
    }

    //reset the game window
    public void reset(String player){
        int option=0;
        if (player.equals("")){
            option = JOptionPane.showConfirmDialog(null,"Match Drawn. \n Are you want to Exit or play a New Game","Message",JOptionPane.YES_NO_OPTION);
        }else if(player.equals("X")) {
            option = JOptionPane.showConfirmDialog(null,"You Won... \n Are you want to Exit or play a New Game","Message",JOptionPane.YES_NO_OPTION);
        }else if(player.equals("0")){
            option = JOptionPane.showConfirmDialog(null,"You Loss... \n Are you want to Exit or play a New Game","Message",JOptionPane.YES_NO_OPTION);
        }

        if (option==JOptionPane.YES_OPTION){
            System.exit(0);
        }else if(option==JOptionPane.NO_OPTION){
            /*each time player click a button butoon was clicked it was disable to click again
            when reset those are enable to click again*/
            jb1.setText("");
            jb1.setEnabled(true);
            jb2.setText("");
            jb2.setEnabled(true);
            jb3.setText("");
            jb3.setEnabled(true);
            jb4.setText("");
            jb4.setEnabled(true);
            jb5.setText("");
            jb5.setEnabled(true);
            jb6.setText("");
            jb6.setEnabled(true);
            jb7.setText("");
            jb7.setEnabled(true);
            jb8.setText("");
            jb8.setEnabled(true);
            jb9.setText("");
            jb9.setEnabled(true);
            count=-1;
        }
    }

    public boolean preventWin(int rndmNum){
        boolean result = false;
        if (((jb1.getText().equals("X") && jb2.getText().equals("X")) && rndmNum==3) || ((jb2.getText().equals("X")&&jb3.getText().equals("X"))&&rndmNum==1) || ((jb1.getText().equals("X")&&jb3.getText().equals("X"))&&rndmNum==2) ){
            result = true;
        }else if (((jb4.getText().equals("X") && jb5.getText().equals("X")) && rndmNum==6) || ((jb5.getText().equals("X")&&jb6.getText().equals("X"))&&rndmNum==4) || ((jb4.getText().equals("X")&&jb6.getText().equals("X"))&&rndmNum==5)){
            result=true;
        }else if (((jb7.getText().equals("X") && jb8.getText().equals("X")) && rndmNum==9) || ((jb8.getText().equals("X")&&jb9.getText().equals("X"))&&rndmNum==7)|| ((jb7.getText().equals("X")&&jb9.getText().equals("X"))&&rndmNum==8)){
            result=true;
        }else if (((jb1.getText().equals("X") && jb4.getText().equals("X")) && rndmNum==7) || ((jb4.getText().equals("X")&&jb7.getText().equals("X"))&&rndmNum==1) || ((jb1.getText().equals("X")&&jb7.getText().equals("X"))&&rndmNum==4)){
            result=true;
        }else if (((jb2.getText().equals("X") && jb5.getText().equals("X")) && rndmNum==8) || ((jb5.getText().equals("X")&&jb8.getText().equals("X"))&&rndmNum==2) || ((jb2.getText().equals("X")&&jb8.getText().equals("X"))&&rndmNum==5)){
            result=true;
        }else if (((jb3.getText().equals("X") && jb6.getText().equals("X")) && rndmNum==9) || ((jb6.getText().equals("X")&&jb9.getText().equals("X"))&&rndmNum==3)|| ((jb3.getText().equals("X")&&jb9.getText().equals("X"))&&rndmNum==6)){
            result=true;
        }else if (((jb1.getText().equals("X") && jb5.getText().equals("X")) && rndmNum==9) || ((jb5.getText().equals("X")&&jb9.getText().equals("X"))&&rndmNum==1)|| ((jb1.getText().equals("X")&&jb9.getText().equals("X"))&&rndmNum==5)){
            result=true;
        }else if (((jb3.getText().equals("X") && jb5.getText().equals("X")) && rndmNum==7) || ((jb5.getText().equals("X")&&jb7.getText().equals("X"))&&rndmNum==3) || ((jb3.getText().equals("X")&&jb7.getText().equals("X"))&&rndmNum==5)){
            result=true;
        }
        return  result;
    }
	
	
	
	public static void main(String args[]){
		TicTacToe gui = new TicTacToe();
		gui.setVisible(true);
	}
}
