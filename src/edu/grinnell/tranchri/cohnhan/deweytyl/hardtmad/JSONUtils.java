package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Do whatever you want with either of these classes.
 * 
 * Maybe we could make a JSONValueParser object. Up to us. We should talk about
 * it later, but for now let's just write static methods.
 */
public class JSONUtils
{

  public static Object parseValue(String valStr)
  {
    // TODO Method Stub
    return null;
  } // parseValue(String)
  
  public static ArrayList<Object> parseArray(String arrStr)
  {
    ArrayList<Object> array = new ArrayList<Object>();
    String[] strs = (arrStr.substring(1, arrStr.length() - 1)).split(",");
    for (String str : strs)
      {
        array.add(parseValue(str));
      } // for
    
    return array;
  } // parseArray(String)
  
  public static BigDecimal parseNumber(String str)
  {
    return null;
  } // parseNumber(String)
  
} // class JSONUtils
