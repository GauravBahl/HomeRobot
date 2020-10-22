package com.robot.runner;

import com.robot.model.FloorType;
import com.robot.model.RoomDimensions;
import com.robot.service.CleaningService;

public class StartRobot {

    public static void main(String[] args) {

        RoomDimensions dimensions = new RoomDimensions(4,4);

        // I am going to create a factory pattern here.
        // Cleaning Factory will call, respective Clearing Service
        // based on the floor type
        CleaningService cleaningService = new CleaningService(dimensions.getX(), dimensions.getY(), FloorType.CARPET.name());

        // We will optimise to run on any shape of room,
        // right now the room is square or rectangle
        //This is a 4*4 room for testing
        //We are starting for the carpet type floor

        int [][] room = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };


        System.out.println(CleaningService.CLEAN_STATUS);

        // You can start the cleaning service from an position
        // That means I can put the cleaning robot at any position - Yay !!
        cleaningService.cleanTheRoom(room,2,1);
        System.out.println(CleaningService.CLEAN_STATUS);

    }




}
