package model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class P2PieceTest 
{
    private Piece p1, p2;

    @Before public void setUp()
    {
        p1 = PieceFactory.createPiece("I");
        p2 = PieceFactory.createPiece("I");
    }
    
    @Test public void GettersTest()
    {
        boolean fixExpected = false;
        Rotation oriExpected = Rotation.D0;
        char blockExpected = '▒';
        
        assertTrue(fixExpected == p1.isFixed());
        assertTrue(oriExpected == p1.getOrientation());
        assertTrue(blockExpected == p1.getBlockSymbol());
    }
    
    @Test public void RotatesTest()
    {
        Rotation counterExpected = Rotation.D90;
        Rotation clockExpected = Rotation.D270;
        
        p1.rotateCounterclockwise();
        assertTrue(counterExpected == p1.getOrientation());
        
        p1.rotateClockwise();
        p1.rotateClockwise();
        assertTrue(clockExpected == p1.getOrientation());        
    }
    
    @Test public void AbsoluteCellsTest()
    {
        Set<Coordinate> cellsExpectedT1 = new HashSet<>();
        cellsExpectedT1.add(new Coordinate(1,0));
        cellsExpectedT1.add(new Coordinate(1,1));
        cellsExpectedT1.add(new Coordinate(1,2));
        cellsExpectedT1.add(new Coordinate(1,3));
        
        Set<Coordinate> gettedCellsT1 = p1.getAbsoluteCells(new Coordinate(0,0));
        
        assertTrue(cellsExpectedT1.equals(gettedCellsT1));
        
        Set<Coordinate> cellsExpectedT2 = new HashSet<>();
        cellsExpectedT2.add(new Coordinate(2,1));
        cellsExpectedT2.add(new Coordinate(2,2));
        cellsExpectedT2.add(new Coordinate(2,3));
        cellsExpectedT2.add(new Coordinate(2,4));
        
        Set<Coordinate> gettedCellsT2 = p2.getAbsoluteCells(new Coordinate(1,1));
        
        assertTrue(cellsExpectedT2.equals(gettedCellsT2));
        
        Set<Coordinate> cellsExpectedT3 = new HashSet<>();
        cellsExpectedT3.add(new Coordinate(2,1));
        cellsExpectedT3.add(new Coordinate(2,2));
        cellsExpectedT3.add(new Coordinate(2,3));
        cellsExpectedT3.add(new Coordinate(2,4));
        
        Set<Coordinate> gettedCellsT3 = p2.getAbsoluteCells(new Coordinate(2,1));
        
        assertFalse(cellsExpectedT3.equals(gettedCellsT3));
    }
    
    @Test public void toStringTest()
    {
        String lineExpected = "····\n▒▒▒▒\n····\n····\n";
        assertTrue(lineExpected.equals(p1.toString()));
        
        p1.rotateClockwise();
        lineExpected = "··▒·\n··▒·\n··▒·\n··▒·\n";
        assertTrue(lineExpected.equals(p1.toString()));
        
        p1.rotateClockwise();
        lineExpected = "····\n····\n▒▒▒▒\n····\n";
        assertTrue(lineExpected.equals(p1.toString()));
        
        p1.rotateClockwise();
        lineExpected = "·▒··\n·▒··\n·▒··\n·▒··\n";
        assertTrue(lineExpected.equals(p1.toString()));
    }
    
    @Test public void setFixedTest()
    {
        boolean fixedExpected = false;
        assertTrue(p1.isFixed() == fixedExpected);
        
        fixedExpected = true;
        p1.setFixed(true);
        assertTrue(p1.isFixed() == fixedExpected);
        
    }
}