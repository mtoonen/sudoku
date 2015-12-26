/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Meine Toonen <meinetoonen@b3partners.nl>
 */
public class Sudoku {

    // The actual grid of the sudoku. First array is row, second is column
    private int [][] grid;
    
    private int subgridLength = -1;
    private int maxNum = -1;
    
    
    public Sudoku (int [][] grid){
        this.grid = grid;
        this.maxNum = this.grid.length;
        double maxnumSqrt = Math.sqrt(maxNum);
        if ((maxnumSqrt == Math.floor(maxnumSqrt)) && !Double.isInfinite(maxnumSqrt)) {
            subgridLength = (int)maxnumSqrt;
        }
    }
    
    protected void solve(Set<Sudoku> solutions){
        /*
        solve:
            Vind 0
                zo ja,
                    maak een Sudoku object met alle mogelijke waardes en check if correct
                        zo ja, doe solve op nieuwe object
                        zo nee, discard
                    ga verder met volgende 0
                zo nee, check if correct
                    zo ja, voeg toe aan oplossingen
                    zo nee, discard
        
        */
        for (int rownum = 0; rownum < grid.length; rownum++) {
            int[] row = grid[rownum];
            for (int colnum = 0; colnum < row.length; colnum++) {
                int curNum = row[colnum];
                if(curNum == 0){
                    for (int num = 1; num <= maxNum; num++) {
                        int [][] clone =cloneArray(grid);
                        clone[rownum][colnum] = num;
                        Sudoku s = new Sudoku(clone);
                        s.solve(solutions);
                    }
                }
            }
        }
        
        if(isCorrect()){
            solutions.add(this);
        }
    }
    
    protected boolean isCorrect(){
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            Set<Integer> nums = new HashSet<>(maxNum);
            for (int j = 0; j < row.length; j++) {
                int num = row[j];
                if(num == 0){
                    return false;
                }else if(nums.contains(num)){
                    return false;
                }else{
                    nums.add(num);
                }
            }
        }
        for (int col = 0; col < maxNum; col++) {
            Set<Integer> nums = new HashSet<>(maxNum);
            for (int i = 0; i < grid.length; i++) {
                int num = grid[i][col];
                if(num == 0 ){
                    return false;
                }else if(nums.contains(num)){
                    return false;
                }else{
                    nums.add(num);
                }
                
            }
            
        }
        return true;
    }
    
    protected boolean checkrow(int rownum){
        int[] row = grid[rownum];
        Set<Integer> nums = new HashSet<>(maxNum);
        for (int num : row) {
            if(! nums.contains(num) || num == 0){
                nums.add(num);
            }else{
                return false;
            }
        }
        return true;
    }
    
    protected boolean checkcolumn(int column){
        Set<Integer> nums = new HashSet<>(maxNum);
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int num = row[column];
            if(! nums.contains(num) || num == 0){
                nums.add(num);
            }else{
                return false;
            }
            
        }
        return true;
    }
    
    /**
     * Clones the provided array
     *
     * @param src
     * @return a new clone of the provided array
     */
    public static int[][] cloneArray(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }
    
    @Override
    public String toString(){
        StringBuilder allrows = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                int num = row[j];
                allrows.append(num);
            }
        }
        return allrows.toString();
    }
    
    @Override
    public int hashCode() {
        String allrows = toString();
        final int prime = 31;
        int result = 1;
        result = prime * result ;
        result = prime * result + ((allrows == null) ? 0 : allrows.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.toString().equals(obj.toString())) {
            return true;
        }
        return false;
    }

    public int getSubgridLength() {
        return subgridLength;
    }
    
    
}
