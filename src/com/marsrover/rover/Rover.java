package com.marsrover.rover;

import com.marsrover.directions.Directions;

/**
 * Created by AMIYA on 10/4/2018.
 */
public class Rover {
    int x = 0;
    int y = 0;
    int maxx=0;
    int maxy=0;
    char direction = '\0';
    public Rover(int x,int y,int maxx,int maxy, char direction){
        this.x = x;this.y = y; this.maxx=maxx;this.maxy=maxy;
        this.direction=direction;
    }

     // need to handle validation like boundary condition of Rectangle before moving the Rover
    public Rover setRoverPosition(Rover rover,String userMove){
        switch (rover.direction) {
            case 'N' :
                if(userMove.equalsIgnoreCase("L")){
                  rover.setDirection('W');
                }else if(userMove.equalsIgnoreCase("R")){
                    rover.setDirection('E');
                }else if(userMove.equalsIgnoreCase("M")){
                    rover.setY(rover.getY() + 1);
                }
                break;
            case 'S' :
                if(userMove.equalsIgnoreCase("L")){
                    rover.setDirection('E');
                }else if(userMove.equalsIgnoreCase("R")){
                    rover.setDirection('W');
                }else if(userMove.equalsIgnoreCase("M")){
                    rover.setY(rover.getY() - 1);
                }
                break;
            case 'E' :
                if(userMove.equalsIgnoreCase("L")){
                    rover.setDirection('N');
                }else if(userMove.equalsIgnoreCase("R")){
                    rover.setDirection('S');
                }else if(userMove.equalsIgnoreCase("M")){
                    rover.setX(rover.getX() + 1);
                }
                break;
            case 'W' :
                if(userMove.equalsIgnoreCase("L")){
                    rover.setDirection('S');
                }else if(userMove.equalsIgnoreCase("R")){
                    rover.setDirection('N');
                }else if(userMove.equalsIgnoreCase("M")){
                    rover.setX(rover.getX() - 1);
                }
                break;
            default: return rover;
        }
        return rover;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (x != rover.x) return false;
        if (y != rover.y) return false;
        return direction == rover.direction;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (int) direction;
        return result;
    }
}
