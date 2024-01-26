package edu.pasadena.cs.cs03b;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class TestDummy {

   @Test
   public void testDummy()
   {
     int iResult = (int)Tuition.futureTuition(10000, 0.05, 10);
     assertEquals(16288, iResult);

     iResult = (int)Tuition.totalTuition(10000, 0.05, 4, 10);
     assertEquals(70207, iResult);

     iResult = (int)Tuition.totalTuition(30000, 0.03, 3, 13);
     assertEquals(136172, iResult);

     String str_iResult = Addition.add(10, 2, "12", "79");
     assertEquals("91", str_iResult);

     str_iResult = Addition.add(2, 4, "1001", "0111");
     assertEquals("10000", str_iResult);

     str_iResult = Addition.add(16, 2, "B2", "5F");
     assertEquals("0x111", str_iResult);

     str_iResult = Addition.add(7, 5, "12626", "60613");
     assertEquals("103542", str_iResult);
   }
}
