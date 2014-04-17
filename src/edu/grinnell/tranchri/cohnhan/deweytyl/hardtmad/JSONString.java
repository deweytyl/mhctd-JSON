package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.Queue;

/**
 * JSONString Class
 * 
 * @implements JSONValue
 * 
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
 */

public class JSONString
    implements
      JSONValue
{
  // +--------+----------------------------------------
  // | Fields |
  // +--------+

  String contents;

  // +--------------+----------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * JSONString constructor
   * 
   * @param str
   */
  public JSONString(String str)
  {
    this.contents = str;
  } // JSONSring(String)

  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+

  /**
   * Returns character representation of type of JSONString object
   */
  @Override
  public char type()
  {
    return 's';
  } // type()

  /**
   * Returns value of JSONString object
   */
  @Override
  public Object value()
  {
    return this.contents;
  } // value()

  /**
   * Returns a JSON representation of this object in a String
   */
  @Override
  public String toJSONData()
  {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Returns a Java String representation of a JSONString object
   */
  @Override
  public String toString()
  {
    return this.contents;
  } // toString()

  /**
   * Given a JSON string return a JSONString object.
   * 
   * @param str
   * @return JSONString
   * @throws Exception
   *           when str is not correct JSON syntax
   */
  public static JSONString parseString(Queue<Character> charQueue)
    throws Exception
  {
    // Make empty string
    StringBuilder val = new StringBuilder();

    char ch = charQueue.poll();

    // Until we hit the end of the string
    while ((ch = charQueue.poll()) != '\"')
      {
        // Handle escape characters
        if (ch == '\\')
          {
            switch (charQueue.peek())
              {
                case '\\':
                case '\"':
                case '/':
                  // if character immediately following \ is
                  // \,", or / add it to val
                  val.append(charQueue.poll());
                  break;
                case 'b':
                  // Remove b from queue and add the escape
                  // character \b to val
                  charQueue.poll();
                  val.append('\b');
                  break;
                case 'f':
                  // Remove f from queue and add the escape
                  // character \f to val
                  charQueue.poll();
                  val.append('\f');
                  break;
                case 'n':
                  // Remove n from queue and add the escape
                  // character \n to val
                  charQueue.poll();
                  val.append('\n');
                  break;
                case 'r':
                  // Remove r from queue and add the escape
                  // character \r to val
                  charQueue.poll();
                  val.append('\r');
                  break;
                case 't':
                  // Remove t from queue and add the escape
                  // character \t to val
                  charQueue.poll();
                  val.append('\t');
                  break;
                  // Otherwise it is not a valid escape character,
                  // throw an exception
                default:
                  throw new Exception("Invalid Escape Character in String");
              } // switch
          } // if
        else
          {
            // If not an escape character, add to val
            val.append(ch);
          }
      } // while

    return new JSONString(val.toString());
  } // parseString(String)
} // class JSONString
