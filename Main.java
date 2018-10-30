package com.company;

import java.sql.Array;
import java.util.Scanner;
import java.util.Set;

public class Main {

   public static int[][] map=new int[100][100];//карта на 100 ячеек


    public static void main(String[] args) {
    Ships Ship1=new Ships();
    Scanner in=new Scanner(System.in);
    System.out.println("Enter the vertical and the horisontal cordinates of the Ship's tail");
    Ship1.SetCoord(in.nextInt(),in.nextInt());//    //Ввод координат хвоста/////////////направление только на запад.
    System.out.println("Enter the size of the ship");
    Ship1.SetSize(in.nextInt());//Ввод размера корабля
    int record=0;

	Ship1.SetLoc();

	while(!(Ship1.G())){//пока игра не закончена
	    record++;
	    System.out.println("Horisontal and Vertical Shoot:  ");//ввод выстрела///////
	    int myShotHor=in.nextInt();/////////
        int myShotVer=in.nextInt();
	    Ship1.IsDead(myShotHor,myShotVer);

    }
    System.out.println("Your record is "+record);
    }


    public static class Ships{
        private int size=0;//размер корабля
        private int coordOftileHor=0;//координаты хвоста корабля Горизонталь|||  пока нет //(куда он будет направлен(8-север. 2-юг. 6-западю 4-восток))
        private int coordOftileVer=0;//Вертикаль
        private String checkYouSelf; //состояние корабля
        private int DeadShoots=0;
        private boolean GameIsOver=false;

        public void SetLoc(){
            for(int i=coordOftileHor; i<coordOftileHor+size;i++){
                map[coordOftileVer][i]=1;//ячейки где есть корабль==1
            }
        }

        public void SetCheck(String sh){//ввод состояния корабля
            checkYouSelf=sh;
            System.out.println(checkYouSelf);
        }


        public void IsDead(int ShotVer,int ShotHor){
            if (map[ShotVer][ShotHor] == 2) {//Если ты сюда уже стрелял
            System.out.println("Ты уже сюда стрелял. Поэтому МИМО");
            }
            else {
                if (map[ShotVer][ShotHor] == 1) {//Если в ячейке есть корабль

                    DeadShoots++;


                    if (DeadShoots == size) {//Если кол-во попадпний == размеру корабля
                        SetCheck("Убил");
                        GameIsOver = true;
                    } else
                        SetCheck("Попал");

                    map[ShotVer][ShotHor] = 2;//место куда ты уже попал отмечено 2
                } else
                    SetCheck("Мимо");
            }

        }

        public void SetSize(int sz){
            size=sz;
        }

        public void SetCoord(int coVer,int coHor){
            coordOftileHor=coHor;
            coordOftileVer=coVer;
        }

        public boolean G(){
            return GameIsOver;
        }

    }
}
