/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import static org.junit.Assert.*;
import model.exceptions.WrongSizeException;

import org.junit.Before;
import org.junit.Test;

public class P3GameboardTest 
{
    private Gameboard gameboard;
    
    
    @Before public void setUp() throws WrongSizeException 
    {
        gameboard = new Gameboard(new Coordinate(7, 10));
    }

    @Test public void GettersTest()
    {
        int heightExpected = 7;
        int widthExpected = 10;
        
        assertTrue(heightExpected == gameboard.getHeight());
        assertTrue(widthExpected == gameboard.getWidth());
    }
    
    @Test public void putPieceTest()
    {
        Piece dummy = new I();
        
        gameboard.putPiece(new Coordinate(0,0), dummy);
        //gameboard.putPiece(new Coordinate(2,0), null);
        //gameboard.putPiece(null, dummy);
        //gameboard.putPiece(null, null);
        
        Piece toTest = gameboard.getCellContent(new Coordinate(1,0));
        assertTrue(dummy.equals(toTest));
        toTest = gameboard.getCellContent(new Coordinate(1,1));
        assertTrue(dummy.equals(toTest));
        toTest = gameboard.getCellContent(new Coordinate(1,2));
        assertTrue(dummy.equals(toTest));
        toTest = gameboard.getCellContent(new Coordinate(1,3));
        assertTrue(dummy.equals(toTest));
        toTest = gameboard.getCellContent(new Coordinate(2,1));
        assertFalse(dummy.equals(toTest));
        try {
        	toTest = gameboard.getCellContent(null);
        }catch(Exception e) {
        	
        }
       
        assertFalse(dummy.equals(toTest));
    }
    
    @Test public void ValidPlaceTest()
    {
       boolean validExpected = true;
       assertTrue(validExpected == gameboard.isPlaceValid(new Coordinate(0,0),PieceFactory.createPiece("I")));
       assertTrue(validExpected == gameboard.isPlaceValid(new Coordinate(-1,0), PieceFactory.createPiece("I")));
       assertFalse(validExpected == gameboard.isPlaceValid(new Coordinate(-5, 5), PieceFactory.createPiece("I")));
       assertFalse(validExpected == gameboard.isPlaceValid(new Coordinate(0,-1),PieceFactory.createPiece("I")));
       assertFalse(validExpected == gameboard.isPlaceValid(new Coordinate(0,10), PieceFactory.createPiece("I")));
       assertFalse(validExpected == gameboard.isPlaceValid(new Coordinate(10,0), PieceFactory.createPiece("I")));
       assertFalse(validExpected == gameboard.isPlaceValid(new Coordinate(10,10),PieceFactory.createPiece("I")));
       //assertFalse(validExpected == gameboard.isPlaceValid(null, new Piece()));
       //assertFalse(validExpected == gameboard.isPlaceValid(new Coordinate(0,0), null));
       
    }
    
    @Test public void FreePlaceTest()
    {
        Piece dummy = PieceFactory.createPiece("I");
        Piece toTest = PieceFactory.createPiece("I");
        gameboard.putPiece(new Coordinate(0,0), dummy);
        gameboard.putPiece(new Coordinate(1,0), dummy);
        gameboard.putPiece(new Coordinate(2,0), dummy);
        
        boolean freeExpected = true;
        assertTrue(freeExpected == gameboard.isPlaceFree(new Coordinate(0,0), dummy));
        assertTrue(freeExpected == gameboard.isPlaceFree(new Coordinate(3,0), dummy));
        
        //AQUI AÑADO YO LO DE FIJAR LA PIEZA DUMMY
        dummy.setFixed(true);
        assertFalse(freeExpected == gameboard.isPlaceFree(new Coordinate(0,0), toTest));
    }
    
    @Test public void RemoveTest()
    {
        Piece dummy = PieceFactory.createPiece("I");
        gameboard.putPiece(new Coordinate(0,0), dummy);
        assertTrue(gameboard.getCellContent(new Coordinate(1, 1)) == dummy);
        
      
        gameboard.removePiece(dummy);
        
        
        assertTrue(gameboard.getCellContent(new Coordinate(1, 1)) == null);
        
        
    }
    
    @Test public void toStringTest()
    {
        Piece dummy = PieceFactory.createPiece("I");
        
        String expected =   "··········\n" +
                            "··········\n" +
                            "··········\n" +
                            "··········\n" +
                            "··········\n" +
                            "··········\n" +
                            "··········\n";
        
        assertTrue(expected.equals(gameboard.toString()));
        
        gameboard.setCellContent(new Coordinate(1, 1), dummy);
        
        expected =  "··········\n" +
                    "·▒········\n" +
                    "··········\n" +
                    "··········\n" +
                    "··········\n" +
                    "··········\n" +
                    "··········\n";
        
        assertTrue(expected.equals(gameboard.toString()));
    }
}
