/*
 * This program should be placed in the Test Packages.
 */
package com.lab06.test.lab06;

import com.lab03.Matrix;
import com.lab06.src.lab06.DimensionMismatchException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 *
 * @author vanting
 */
public class MatrixUnitTest {

    Matrix matA;
    Matrix matB;
    Matrix matC;
        
    @Before
    public void setUp() {
        matA = new Matrix(new int[][]{{1,2,3},{4,5,6}}); 
        matB = new Matrix(new int[][]{{1,1,1},{2,2,2}});  
        matC = new Matrix(new int[][]{{1},{1},{1}});
    }
    
    @Test
    public void getElementTest() {
        int[][] expected = new int[][]{{1,2,3},{4,5,6}};
        for(int i=0; i<expected.length; i++)
            for(int j=0; j< expected[0].length; j++)
                assertEquals(expected[i][j], matA.getElement(i, j));
    }
    
    @Test
    public void addTest() {
        int[][] expected = new int[][]{{2,3,4},{6,7,8}};
        matA.add(matB);
        for(int i=0; i<expected.length; i++)
            for(int j=0; j< expected[0].length; j++)
                assertEquals(expected[i][j], matA.getElement(i, j));
    }
    
    //--------------------------- to be done by students
    
    @Test
    public void multiplyOnSuccessTest() throws DimensionMismatchException {
        int[][] expected = new int[][]{{6},{15}};
        Matrix result = matA.multiply(matC);
        for(int i=0; i<expected.length; i++)
            for(int j=0; j< expected[0].length; j++)
                assertEquals(expected[i][j], result.getElement(i, j));
    }
    
    @Test (expected = DimensionMismatchException.class)
    public void multiplyOnFailTest() throws DimensionMismatchException {
        
        Matrix result = matA.multiply(matB);    // throw expection
  
    }

}
