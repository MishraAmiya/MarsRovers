package com.marsrover.execute;

import com.marsrover.rover.Rover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by AMIYA on 10/6/2018.
 */
public class RunRover {

    public static void main(String[] args) {
        int maxx = 0;
        int maxy = 0;
        Rover rover = null;
        List<Rover> rovers = new ArrayList<>();
        int counter=0;
        try {
            Scanner scanner = new Scanner(new File("D:\\MarsRover\\src\\direction_input.txt"));
            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                System.out.println("First line is : " + firstLine);
                String[] coordinates = firstLine.split(" ");
                maxx = Integer.parseInt(coordinates[0]);
                maxy = Integer.parseInt(coordinates[1]);
                System.out.println("Maxx is : "+ maxx + " Maxy is: "+ + maxy);
            }
            while (scanner.hasNextLine()) {
                counter++;
                String line = scanner.nextLine();
                if(counter==1) {
                    String[] roverPosition = line.split(" ");
                    int x = Integer.parseInt(roverPosition[0]);
                    int y = Integer.parseInt(roverPosition[1]);
                    char direction = roverPosition[2].toString().charAt(0);
                    rover = new Rover(x, y, maxx, maxy, direction);
                }else
                {
                    int movecounter=0;
                    while(line.length()  != movecounter) {
                        char move = line.charAt(movecounter);
                        if (rover != null) {
                            rover = rover.setRoverPosition(rover, String.valueOf(move));
                        }
                        movecounter++;
                    }
                }
                //Handles if there is no moving instructions
                if(!scanner.hasNextLine() && counter != 2){
                    rovers.add(rover);
                }
                if(counter == 2){
                    counter=0;
                    rovers.add(rover);
                }
            }
            // printing rovers position
            for(Rover roverdetils : rovers) {
                System.out.println(roverdetils.getX() + " " + roverdetils.getY() + " " + roverdetils.getDirection());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
