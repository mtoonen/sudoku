/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.sudoku;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meine Toonen <meinetoonen@b3partners.nl>
 */
public class SudokuTest {
    
    public SudokuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of solve method, of class Sudoku.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        int[][] grid1 = new int[2][2];
        grid1[0][0] = 1;
        grid1[0][1] = 2;
        grid1[1][0] = 2;
        grid1[1][1] = 1;

        int[][] grid2 = new int[2][2];
        grid2[0][0] = 2;
        grid2[0][1] = 1;
        grid2[1][0] = 1;
        grid2[1][1] = 2;

        Sudoku instance = new Sudoku(new int[2][2]);

        Sudoku[] expResult = new Sudoku[2];
        expResult[0] = new Sudoku(grid1);
        expResult[1] = new Sudoku(grid2);

        Sudoku[] result = instance.solve();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of checkrow method, of class Sudoku.
     */
    @Test
    public void testCheckrowCorrect() {
        System.out.println("checkrow");

        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 2;
        grid[1][1] = 1;

        int row = 0;
        Sudoku instance = new Sudoku(grid);
        boolean expResult = true;
        
        boolean result = instance.checkrow(row);
        assertEquals(expResult, result);
    }
 
    /**
     * Test of checkrow method, of class Sudoku.
     */
    @Test
    public void testCheckrowCorrectIncompleterow() {
        System.out.println("checkrow");

        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 0;
        grid[1][0] = 2;
        grid[1][1] = 1;

        int row = 0;
        Sudoku instance = new Sudoku(grid);
        boolean expResult = true;
        
        boolean result = instance.checkrow(row);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkrow method, of class Sudoku.
     */
    @Test
    public void testCheckrowIncorrect() {
        System.out.println("checkrow");

        int[][] grid = new int[2][2];
        grid[0][0] = 2;
        grid[0][1] = 2;
        grid[1][0] = 2;
        grid[1][1] = 1;

        int row = 0;
        Sudoku instance = new Sudoku(grid);
        boolean expResult = false;
        
        boolean result = instance.checkrow(row);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkrow method, of class Sudoku.
     */
    @Test
    public void testCheckcolumnCorrect() {
        System.out.println("checkrow");

        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 2;
        grid[1][1] = 1;

        int column = 0;
        Sudoku instance = new Sudoku(grid);
        boolean expResult = true;
        
        boolean result = instance.checkcolumn(column);
        assertEquals(expResult, result);
    }
 
    /**
     * Test of checkrow method, of class Sudoku.
     */
    @Test
    public void testCheckcolumnCorrectIncompletecolumn() {
        System.out.println("checkrow");

        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 0;
        grid[1][0] = 2;
        grid[1][1] = 1;

        int row = 0;
        Sudoku instance = new Sudoku(grid);
        boolean expResult = true;
        
        boolean result = instance.checkcolumn(row);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkrow method, of class Sudoku.
     */
    @Test
    public void testCheckcolumnIncorrect() {
        System.out.println("checkrow");

        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 1;
        grid[1][1] = 2;

        int column = 0;
        Sudoku instance = new Sudoku(grid);
        boolean expResult = false;
        
        boolean result = instance.checkcolumn(column);
        assertEquals(expResult, result);
    }

    
}
