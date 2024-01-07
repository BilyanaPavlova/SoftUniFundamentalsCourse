package Lec6_ClassesObjects.songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSongs = Integer.parseInt(sc.nextLine());

        List<Song> songs = new ArrayList<>();


        for (int i = 0; i < numSongs; i++) {

            String[] arr = sc.nextLine().split("_");

            String typeList = arr[0];
            String name = arr[1];
            String time = arr[2];

            songs.add(new Song(typeList, name, time));



        }


        String command = sc.nextLine();

        if (command.equals("all")){
            for (Song song :
                    songs) {
                System.out.printf("%s\n", song.getName());
            }
        } else{
            for (Song song :
                    songs) {
                if (command.equals(song.getTypeList())) {
                    System.out.printf("%s\n", song.getName());
                }
            }
        }


    }
    }

