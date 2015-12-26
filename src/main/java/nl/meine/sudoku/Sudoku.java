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
        Sudoku[] s = new Sudoku[0];
        return s;
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
        return false;
    }
}
