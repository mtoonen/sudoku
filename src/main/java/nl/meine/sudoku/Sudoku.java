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
    
    private int maxNum = -1;
    
    
    public Sudoku (int [][] grid){
        this.grid = grid;
        this.maxNum = this.grid.length;
    }
    
    protected Sudoku[] solve(){
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
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                int column = row[j];
                if(column == 0){
                    
                }
            }
        }
        
        Sudoku[] s = new Sudoku[0];
        return s;
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
}
