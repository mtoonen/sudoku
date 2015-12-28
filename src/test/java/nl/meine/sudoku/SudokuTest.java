/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.sudoku;

import java.util.HashSet;
import java.util.Set;
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
        Set<Sudoku> expResult = new HashSet<>();

        expResult.add(new Sudoku(grid2));
        expResult.add(new Sudoku(grid1));

        Set<Sudoku> result = new HashSet<>();
        instance.solve(result);
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult, result);
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

    /**
     * Test of isCorrect method, of class Sudoku.
     */
    @Test
    public void testIsCorrectShouldBeIncorrect() {
        System.out.println("isCorrect");

        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 1;
        grid[1][1] = 2;

        Sudoku instance = new Sudoku(grid);
        boolean actual = instance.isCorrect();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Test of isCorrect method, of class Sudoku.
     */
    @Test
    public void testIsCorrectShouldBeIncorrect2() {
        System.out.println("isCorrect");

        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 0;
        grid[1][1] = 2;

        Sudoku instance = new Sudoku(grid);
        boolean actual = instance.isCorrect();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Test of isCorrect method, of class Sudoku.
     */
    @Test
    public void testIsCorrectShouldBeCorrect() {
        System.out.println("isCorrect");

        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 2;
        grid[1][1] = 1;

        Sudoku instance = new Sudoku(grid);
        boolean actual = instance.isCorrect();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void testSubgridlengths() {

        int[][] gridCor1 = new int[4][4];
        int[][] gridCor2 = new int[9][9];
        Sudoku s1 = new Sudoku(gridCor1);
        assertEquals(2, s1.getSubgridLength());
        Sudoku s2 = new Sudoku(gridCor2);
        assertEquals(3, s2.getSubgridLength());

        int[][] gridIncCor1 = new int[2][2];
        Sudoku s3 = new Sudoku(gridIncCor1);
        assertEquals(-1, s3.getSubgridLength());

    }

    /**
     * Test of cloneArray method, of class Sudoku.
     */
    @Test
    public void testCloneArray() {
        System.out.println("cloneArray");
        int[][] src = null;
        int[][] expResult = null;
        int[][] result = Sudoku.cloneArray(src);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckSubgridCorrect() throws NoSuchMethodException{
        
        int[][] grid = new int[4][4];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 3;
        grid[0][3] = 4;
        
        grid[1][0] = 4;
        grid[1][1] = 3;
        grid[1][2] = 2;
        grid[1][3] = 1;
        
        grid[2][0] = 2;
        grid[2][1] = 4;
        grid[2][2] = 1;
        grid[2][3] = 3;
        
        grid[3][0] = 3;
        grid[3][1] = 1;
        grid[3][2] = 4;
        grid[3][3] = 2;

        Sudoku instance = new Sudoku(grid);
        int length = instance.getSubgridLength();
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                assertTrue(instance.checkSubgrid(row, col));
            }

        }
    }

    @Test
    public void testCheckSubgridIncorrect() throws NoSuchMethodException{

        int[][] grid = new int[4][4];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 3;
        grid[0][3] = 4;

        grid[1][0] = 4;
        grid[1][1] = 1;
        grid[1][2] = 2;
        grid[1][3] = 3;

        grid[2][0] = 3;
        grid[2][1] = 4;
        grid[2][2] = 1;
        grid[2][3] = 2;

        grid[3][0] = 4;
        grid[3][1] = 2;
        grid[3][2] = 3;
        grid[3][3] = 1;

        Sudoku instance = new Sudoku(grid);
        int length = instance.getSubgridLength();
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                assertFalse(instance.checkSubgrid(row, col));
            }
        }
    }
}
