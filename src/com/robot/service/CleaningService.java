package com.robot.service;

import com.robot.model.FloorType;

public class CleaningService {

        public static boolean CLEAN_STATUS = false;
        private static final String CARPET_SERVICE = "Starting Carpet cleaning Service";
        private static final String TILES_SERVICE = "Starting Carpet cleaning Service";
        private static final String WOODEN_SERVICE = "Starting Carpet cleaning Service";
        private static final String MARBLE_SERVICE = "Starting Carpet cleaning Service";
        private String floorType;


        public boolean[][] visited;
        public CleaningService(int i , int j, String floorType){
            this.visited = new boolean[i][j];
            this.floorType = floorType;
        }

        public String identifyCleaningType(FloorType type){
            switch(type){
                case TILES:
                    return TILES_SERVICE;
                case WOODEN:
                    return WOODEN_SERVICE;
                case MARBLE:
                    return MARBLE_SERVICE;
                default:
                    return CARPET_SERVICE;
            }
        }

        public void cleanOneBlock(int[][] arr, int i, int j){
            System.out.println(String.format("Hello Mam for you %s Floor, I have completed %s this at position %s - %s", this.floorType, arr[i][j], i, j));
        }

        public void cleanTheRoom(int[][] arr, int i, int j){

            if(isValidBlock(arr, i, j)){
                this.visited[i][j] = true;
                cleanOneBlock(arr, i, j);

                //Check all 4 position UP, DOWN, LEFT, RIGHT and clean each block
                cleanTheRoom(arr,i+1, j);
                cleanTheRoom(arr, i-1, j);
                cleanTheRoom(arr, i, j+1);
                cleanTheRoom(arr, i, j-1);

                CLEAN_STATUS = true;
            }
        }

        private boolean isValidBlock(int[][] arr, int i, int j){
            if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || this.visited[i][j]){
                return false;
            }

            return true;
        }
}
