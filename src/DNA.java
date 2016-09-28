import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * @author Tyler Newman
 * @since 2/19/16.
 *
 * Class: CSCI 230 Section 02
 * Assignment: Homework 3
 *
 *
 * Task:    To implement a doubly-linked list abstract data type that represents an entire DNA structure
 *          consisting of Nucleotide base pairs. Every Nucleotide object is connected to another Nucleotide
 *          and contains three things: a pointer to the next Nucleotide in the same helix (left or right), a
 *          pointer to the Nucleotide it is bonded with, and the base of the Nucleotide ('A', 'T', 'C',or 'G').
 *          'A' can only be paired with 'T' and 'C' can only be paired with 'G'. The overall number of base
 *          pairs in the DNA structure is represented by the instance variable numElements.
 *
 * Input:   The first input will always be an integer, and it specifies how many other lines of input will
 *          follow (how many methods will run). Then, for the number of times that was entered, another integer
 *          will be entered. This integer represents which method to call (each corresponds to a specific
 *          number value). After the method has been chosen, input is accepted based on the parameters for that
 *          method (either integers or Strings).
 *
 * Output:  The results of the methods that are run will be printed out to the console.
 *
 */
public class DNA
{

   private Nucleotide leftHelix = null;
   private Nucleotide rightHelix = null;

   private int numElements = 0;


   public static void main(String[] args)
   {
      DNA dna = new DNA();
      Scanner in = new Scanner(System.in);

      dna.getOverallInput(dna, in);
   }

   /**
    * Gets the very first input value (all input values are integers), which specifies how many
    * other methods (lines of input) will be run, then runs methods based on that initial input
    * value.
    *
    * @param in the Scanner object for getting user input
    */
   public void getOverallInput(DNA dna, Scanner in)
   {
      System.out.print("Enter the number of methods you will be running: ");
      int numberOfMethods = in.nextInt(); // gets very first input value

      // runs however many methods that has been specified in numberOfMethods
      for (int i=0; i<numberOfMethods; i++)
      {
         System.out.println("\n** METHODS **\n" +
                 "1: Insert a Base Pair at an Index\n" +
                 "2: Remove a Base Pair from an Index\n" +
                 "3: Print a Sequence Between Two Indices\n" +
                 "4: Clear DNA\n" +
                 "5: Check if DNA is Empty\n" +
                 "6: Print Length of DNA\n" +
                 "7: Find First Occurrence of a Base Pair\n" +
                 "8: Print Left Helix\n" +
                 "9: Print Right Helix\n" +
                 "10: Print Base Pair at an Index\n" +
                 "11: Insert a Sequence at an Index\n" +
                 "12: Find the Starting Index of a Sequence\n" +
                 "13: Remove a Sequence Between Two Indices\n");
         System.out.print("\nMethod " + (i+1) + ": ");
         // gets which method to run
         int method = in.nextInt();

         // then calls runMethod(), which chooses the method to run based on the input
         runMethod(dna, in, method);
      }

   }

   /**
    * Chooses and runs a method based on the integer given as a parameter.
    *
    * @param in the Scanner object used for getting user input
    * @param choice an integer representing a method to run
    */
   public void runMethod(DNA dna, Scanner in, int choice)
   {

      // method to run: void insert(int index, String basePair)
      if (choice == 1)
      {
         System.out.print("\nIndex at which to insert: ");
         int index = in.nextInt();  // gets which index to insert at
         System.out.print("\nBase pair to insert: ");
         String basePair = in.next();  // gets the basePair to insert

         dna.insert(index, basePair);

      }

      // method to run: String remove(int index)
      else if (choice == 2)
      {
         System.out.print("\nIndex to remove: ");
         // gets which index to remove
         int index = in.nextInt();

         // prints out the result of the method
         System.out.println("\nRESULT: " + dna.remove(index));

      }

      // method to run: void print(int startIndex, int endIndex)
      else if (choice == 3)
      {
         // gets indices for printing
         System.out.print("\nStart index: ");
         int startIndex = in.nextInt();

         System.out.print("\nEnd index: ");
         int endIndex = in.nextInt();

         System.out.print("\nRESULT: ");
         dna.print(startIndex, endIndex);

      }

      // method to run: void clear()
      else if (choice == 4) {
         // needs no parameters and doesn't return anything
         dna.clear();
         System.out.print("\nDNA cleared...");
      }

      // method to run: bool isEmpty()
      else if (choice == 5)
         // prints out the result of the method
         System.out.println("\nDNA is empty: " + dna.isEmpty());

      // method to run: int getLength()
      else if (choice == 6)
         // prints out the result of the method
         System.out.println("\nLength: " + dna.getLength());

      // method to run: int find(String basePair)
      else if (choice == 7)
      {
         // gets base pair to find
         System.out.print("\nBase pair to find: ");
         String basePair = in.next();

         // prints out the result of the method
         System.out.println("\nRESULT: " + dna.find(basePair));

      }

      // method to run: void printLeft()
      else if (choice == 8) {
         // needs no parameters and doesn't return anything
         System.out.println("\nLeft Helix:");
         dna.printLeft();
      }

      // method to run: void printRight()
      else if (choice == 9) {
         // needs no parameters and doesn't return anything
         System.out.println("\nRight Helix: ");
         dna.printRight();
      }

      // method to run: void printBasePair(int index, int helix)
      else if (choice == 10)
      {
         // gets which index to print and which helix to traverse
         System.out.print("\nIndex of base pair to print: ");
         int index = in.nextInt();
         System.out.print("\nHelix to traverse (0 = left | 1 = right): ");
         int helix = in.nextInt();

         dna.printBasePair(index, helix);

      }

      // method to run: void insertSequence(int index, String sequence)
      else if (choice == 11)
      {
         System.out.print("\nIndex at which to insert sequence: ");
         int index = in.nextInt();  // gets which index to insert at
         System.out.print("\nSequence to insert: ");
         String sequence = in.next();  // gets the sequence to insert

         dna.insertSequence(index, sequence);
      }

      // method to run: int findSequence(String subsequence)
      else if (choice == 12)
      {
         // gets the sequence to search for
         System.out.print("\nSequence to search for: ");
         String subsequence = in.next();

         // prints out the result of the method
         System.out.println("\nRESULT:" + dna.findSequence(subsequence));

      }

      // method to run: String removeSequence(int startIndex, int endIndex)
      else if (choice == 13)
      {
         // gets indices within which to remove
         System.out.print("\nStart index of sequence to remove: ");
         int startIndex = in.nextInt();
         System.out.print("\nEnd index of sequence to remove: ");
         int endIndex = in.nextInt();

         // prints out the result of the method
         System.out.println("\nRESULT: " + dna.removeSequence(startIndex, endIndex));

      }

   }


   /**
    * Creates and inserts a pair of Nucleotides that point to each other (across) into the DNA
    * structure at the specified index.
    *
    * @param index the position where the Nucleotide base pair will be placed
    * @param basePair a String with two letters representing the two Nucleotides' bases
    */
   public void insert(int index, String basePair)
   {
      // index is at invalid position
      if (index < 0 || index > numElements)
         throw new IndexOutOfBoundsException("Improper index value");

      else  // index is valid
      {
         // first, creates the Nucleotide base pair
         Nucleotide newLeft = new Nucleotide();
         Nucleotide newRight = new Nucleotide();

         // then sets their base and across values
         newLeft.base = basePair.charAt(0);
         newRight.base = basePair.charAt(1);
         newLeft.across = newRight;
         newRight.across = newLeft;

         // now, the Nucleotide base pair has been created and must be inserted at index


         if (index == 0) // special case for if it is being placed at the very beginning
         {
            // makes the new base pair point to the old start
            newLeft.next = leftHelix;
            newRight.next = rightHelix;

            // then it becomes the new start
            leftHelix = newLeft;
            rightHelix = newRight;
         }

         else  // it is not being added to the very beginning, so loops through
         {
            // initializes variables needed later for loop
            boolean inserted = false;  // has not been inserted yet
            int i = 0;  // current loop pointer for DNA structure
            Nucleotide currentNucleotide = leftHelix; // stores current Nucleotide in structure

            while (!inserted)
            {
               // position before desired index has been reached OR the next Nucleotide is null
               if (i == index - 1 || currentNucleotide.next == null)
               {
                  // saves current next Nucleotides for later
                  Nucleotide originalNext = currentNucleotide.next;
                  Nucleotide originalAcross = currentNucleotide.across.next;

                  // adds the new Nucleotide to the position after the current Nucleotide
                  currentNucleotide.next = newLeft;
                  currentNucleotide.across.next = newRight;

                  // adds saved original two next Nucleotides (along with entire list) to new base pair
                  newLeft.next = originalNext;
                  newRight.next = originalAcross;

                  inserted = true;  // has now been successfully inserted
               }

               currentNucleotide = currentNucleotide.next;  // goes to next Nucleotide
               i++;  // increments to next position
            }

         }

         numElements++; // adds one to overall elements since one pair has been added
      }

   }

   /**
    * Deletes an entire Nucleotide base pair (in both leftHelix and rightHelix) from the overall
    * DNA structure. The resulting helices will each be one Nucleotide shorter.
    *
    * @param index the position of the base pair to remove
    * @return a String representing the base pair that was removed
    */
   public String remove(int index)
   {
      // if index is at an invalid position
      if (index < 0 || index >= numElements)
         throw new IndexOutOfBoundsException("Improper index value");

      else  // index is valid
      {
         String result = "";

         // stores current Nucleotide base pair
         Nucleotide currentNucleotide = leftHelix;

         // stores previous Nucleotide in list for later (pair before current index)
         Nucleotide previousNucleotide = null;


         boolean deleted = false;   // will be true when the Nucleotide base pair has been removed
         int i = 0;  // stores index of current Nucleotide to increment

         // now steps through DNA structure to findSequence index to delete, ends when either the item has
         // been deleted OR the end of the list has been reached
         while (!deleted && i < numElements)
         {
            if (i == index)
            {
               Nucleotide nextNucleotide = currentNucleotide.next;

               if (i == 0) // needs to set leftHelix if index is 0
                  // start is now Nucleotide after deleted one
                  leftHelix = nextNucleotide;

               else
                  // previous Nucleotide's next is now Nucleotide after deleted index
                  previousNucleotide.next = nextNucleotide;

               // adds both deleted Nucleotides' bases to return later
               result += currentNucleotide.base.toString();
               result += currentNucleotide.across.base.toString();

               // sets the result's values to null so that it points nowhere
               currentNucleotide.next = null;
               currentNucleotide.across.next = null;
               deleted = true;
               numElements--; // decrement numElements by 1
            }

            i++;  // increments the current Nucleotide index
            previousNucleotide = currentNucleotide;   // previous now switches to current
            currentNucleotide = currentNucleotide.next;   // grabs and saves next Nucleotide in the leftHelix
         }

         return result;
      }
   }

   /**
    * Outputs the DNA structure within the given indices from left to right, pair-by-pair.
    *
    * @param startIndex where the method will begin printing
    * @param endIndex where the method will stop printing (excluded from output)
    */
   public void print(int startIndex, int endIndex)
   {
      // if index is at an invalid position
      if ((startIndex < 0 || startIndex >= numElements)
              ||(endIndex < 0 || endIndex > numElements))
         throw new IndexOutOfBoundsException("Improper indices");

      else if (startIndex >= endIndex)
         throw new InvalidParameterException("The start index is greater than or equal to the end index");

      else  // indices are valid
      {
         // begins at start of DNA structure
         Nucleotide currentNucleotide = leftHelix;

         int i = 0;  // index loop is currently on

         while (i < endIndex)
         {
            if (i >= startIndex) // Nucleotide is within printing indices
            {
               // print both current Nucleotide and Nucleotide across
               System.out.print(currentNucleotide.base);
               System.out.print(currentNucleotide.across.base);
            }

            // got to next Nucleotide and increment i
            currentNucleotide = currentNucleotide.next;
            i++;
         }
         System.out.println();   // adds a line at the end to signal end of output
      }
   }

   /**
    * Clears the entire DNA structure (does not deallocate the memory).
    */
   public void clear()
   {
      leftHelix = null;
      rightHelix = null;

      numElements = 0;
   }

   /**
    * Returns false if there are any base pairs and true if there are none.
    *
    * @return whether any base pairs exist in the DNS structure
    */
   public boolean isEmpty()
   {
      return (numElements == 0);
   }

   /**
    * Returns the overall number of base pairs in the DNA structure.
    *
    * @return the number of Nucleotides in the leftHelix (same as rightHelix)
    */
   public int getLength()
   {
      return numElements;
   }

   /**
    * Finds and returns the index of the Nucleotide pair that matches the given basePair
    * String, (-1 if it doesn't exist).
    *
    * @param basePair two characters representing a Nucleotide base pair
    * @return the index of the Nucleotide base pair, -1 if non-existent
    */
   public int find(String basePair)
   {
      int result = -1;

      // get the two bases needed to be found
      Character leftBase = basePair.charAt(0);
      Character rightBase = basePair.charAt(1);

      boolean found = false;  // will be true when/if basePair is found
      int i = 0;  // starts at first position
      Nucleotide currentNucleotide = leftHelix;

      while (!found && i < numElements && currentNucleotide != null)
      {
         if (currentNucleotide.base == leftBase)   // are left bases the same?
         {
            if (currentNucleotide.across.base == rightBase) // are right bases also the same?
            {
               result = i;
               found = true;
            }
         }

         // increments i and goes to next Nucleotide in DNA structure
         i++;
         currentNucleotide = currentNucleotide.next;
      }

      return result;
   }

   /**
    * Outputs the base pairs of the entire leftHelix (excludes rightHelix completely).
    */
   public void printLeft()
   {
      // only looking at the leftHelix bases
      Nucleotide current = leftHelix;

      for (int i = 0; i< numElements; i++)
      {
         System.out.print(current.base);
         current = current.next; // goes to next Nucleotide
      }
      System.out.println();   // adds a line at the end to signal end of output
   }

   /**
    * Outputs the base pairs of the entire rightHelix (excludes leftHelix completely).
    */
   public void printRight()
   {
      // only looking at the rightHelix bases
      Nucleotide current = rightHelix;

      for (int i = 0; i< numElements; i++)
      {
         System.out.print(current.base);
         current = current.next; // goes to next Nucleotide
      }
      System.out.println();   // adds a line at the end to signal end of output
   }

   /**
    * Goes through a specified helix (either left or right) and prints out the base at the
    * given index value along with the base directly across from it (on the opposite helix).
    *
    * @param index the position of the first base to print out
    * @param helix indicates which helix to traverse (0 = leftHelix, 1 = rightHelix)
    */
   public void printBasePair(int index, int helix)
   {
      // if index is at an invalid position
      if (index < 0 || index >= numElements)
         throw new IndexOutOfBoundsException("Invalid index value");

      Nucleotide current;

      if (helix == 0)   // 0 means traversing leftHelix
         current = leftHelix;

      else if (helix == 1) // 1 means traversing rightHelix
         current = rightHelix;

      else  // any other helix value throws an exception
         throw new InvalidParameterException("Invalid helix value. Should be either 0 or 1");

      int i=0;
      boolean found = false;

      // stops looping through helix when index has been found OR end of list has been
      // reached OR current Nucleotide is null
      while (!found && i < numElements && current != null)
      {
         if (i == index)   // has the index been found?
         {
            // prints both current Nucleotide AND Nucleotide across from it
            System.out.print(current.base);
            System.out.print(current.across.base);
            found = true;
         }

         // goes to next Nucleotide (if not null) and increments current index
         current = current.next;
         i++;
      }
      System.out.println();   // adds a line at the end to signal end of output

   }


   /* BONUS METHODS BELOW */

   /**
    * Puts the sequence given (starting with the leftHelix) into the DNA structure beginning at
    * the specified index.
    *
    * @param index the starting index where the specified sequence will be placed
    * @param sequence a String representing a list of Nucleotides (starting with the leftHelix)
    */
   public void insertSequence(int index, String sequence)
   {
      // if index is at an invalid position
      if (index < 0 || index > numElements)
         throw new IndexOutOfBoundsException("Improper index value");

      else
      {
         boolean inserted = false;  // knows if the sequence has been successfully inserted
         Nucleotide currentNucleotide = leftHelix; // begin iterating at very first Nucleotide

         // creates first two Nucleotides in specified sequence
         Nucleotide firstNextNucleotide = new Nucleotide();
         Nucleotide firstAcrossNucleotide = new Nucleotide();

         // sets their respective base values
         firstNextNucleotide.base = sequence.charAt(0);
         firstAcrossNucleotide.base = sequence.charAt(1);

         // sets their across values equal to one another
         firstNextNucleotide.across = firstAcrossNucleotide;
         firstAcrossNucleotide.across = firstNextNucleotide;

         // keeps track of the previous Nucleotide that was looked at while in the loop
         Nucleotide previousNextNucleotide = new Nucleotide();
         Nucleotide previousAcrossNucleotide = new Nucleotide();

         // creates the sequence to insertSequence, starting at third Nucleotide and iterating by 2
         for (int i = 2; i < sequence.length(); i += 2)
         {
            // creates next two Nucleotides in specified sequence
            Nucleotide newNextNucleotide = new Nucleotide();
            Nucleotide newAcrossNucleotide = new Nucleotide();

            // sets their respective base values
            newNextNucleotide.base = sequence.charAt(i);
            newAcrossNucleotide.base = sequence.charAt(i + 1);

            // sets their across values equal to one another
            newNextNucleotide.across = newAcrossNucleotide;
            newAcrossNucleotide.across = newNextNucleotide;

            // if it is second time creating a Nucleotide pair
            if (i == 2) {
               // sets first Nucleotides' next values accordingly
               firstNextNucleotide.next = newNextNucleotide;
               firstAcrossNucleotide.next = newAcrossNucleotide;
            }

            // it is not second time AND not last time creating a Nucleotide pair
            else if (i != sequence.length() - 1)
            {
               // sets Nucleotides' next values accordingly (not first one though)
               previousNextNucleotide.next = newNextNucleotide;
               previousAcrossNucleotide.next = newAcrossNucleotide;
            }

            // save current Nucleotide for later use
            previousNextNucleotide = newNextNucleotide;
            previousAcrossNucleotide = newAcrossNucleotide;

         }

         // Now, the Nucleotide sequence has been created and the last two Nucleotides have been saved in
         // previousNextNucleotide and previousAcrossNucleotide to be used later, along with the first two
         // Nucleotides in firstNextNucleotide and firstAcrossNucleotide

         if (index == 0)   // is index at very beginning
         {
            Nucleotide originalLeft = leftHelix; // original leftHelix to use later
            Nucleotide originalRight = rightHelix; // original rightHelix to use later

            // put beginning of sequence at beginning of DNA structure
            leftHelix = firstNextNucleotide;
            rightHelix = firstAcrossNucleotide;

            // put original DNA structure at end of sequence
            previousNextNucleotide.next = originalLeft;
            previousAcrossNucleotide.next = originalRight;

         }
         else  // index is not at beginning
         {
            int i = 0;  // the current index

            // while the sequence has not been inserted
            while (!inserted) {
               // if i is the Nucleotide before the intended insertSequence position OR currentNucleotide doesn't point anywhere
               if (i == index - 1 || currentNucleotide.next == null)
               {
                  Nucleotide originalNext = currentNucleotide.next;  // Nucleotide originally pointed to by next
                  Nucleotide originalAcross = currentNucleotide.across.next;  // Nucleotide originally pointed to by across

                  // puts beginning of sequence next to currentNucleotide
                  currentNucleotide.next = firstNextNucleotide;
                  currentNucleotide.across.next = firstAcrossNucleotide;

                  // puts rest of DNA structure at end of sequence
                  previousNextNucleotide.next = originalNext;
                  previousAcrossNucleotide.next = originalAcross;

                  inserted = true;
               }

               // go to the next Nucleotide and increment i
               currentNucleotide = currentNucleotide.next;
               i++;
            }

         }

         // keep track of numElements
         numElements += sequence.length() / 2;
      }

   }

   /**
    * Returns to the user the starting index (for the Nucleotide in the leftHelix) of the
    * specified subsequence within the overall DNA structure, and -1 if it does not exist.
    *
    * @param subsequence the sequence of base pairs the method will be searching for
    * @return the starting index of the subsequence in the DNA structure (-1 if non-existent)
    */
   public int findSequence(String subsequence)
   {
      int result = -1;  // store the result to return later

      if (!subsequence.isEmpty())   // only iterate if subsequence contains items
      {

         boolean found = false;  // tells whether the subsequence has been successfully found or not

         Nucleotide currentNucleotide = leftHelix;  // current Nucleotide that loop is looking at
         Character subsequenceStartBase = subsequence.charAt(0); // first base in subsequence

         int i = 0;  // index of the current Nucleotide's position

         // while subsequence has not been found AND there are enough positions left to fit subsequence
         while (!found && i <= numElements - (subsequence.length() / 2))
         {
            if (currentNucleotide.base == subsequenceStartBase)   // are the bases the same?
            {
               boolean stillIdentical = true;   // tells if the sequences are still the same

               // obtains next bonded base in both DNA structure and subsequence
               Nucleotide nextNucleotide = currentNucleotide.across;
               Character subsequenceNext = subsequence.charAt(1);

               int j = 2;  // iterates over the subsequence
               int k = i;  // iterates over the DNA structure starting at the current position

               // while the bases are still the same AND the length of the subsequence has not
               // been reached AND the length of the DNA structure has not been reached
               while (stillIdentical && j <= subsequence.length() && k < numElements)
               {

                  if (subsequenceNext != nextNucleotide.base)
                     // they are NOT identical anymore
                     stillIdentical = false;

                  else if (j == subsequence.length())
                     // they ARE identical AND the entire subsequence has been traversed
                     found = true;

                  if (j % 2 == 1)
                     // if subsequence iterator is odd, use across method to get bonded Nucleotide
                     nextNucleotide = nextNucleotide.across;

                  else {
                     // if subsequence iterator is even, use next method to get next non-bonded Nucleotide
                     nextNucleotide = nextNucleotide.across.next;
                     k++;  // only increment DNA iterator when next is used (to match numElements)
                  }

                  // get next base in subsequence if it exists
                  if (j < subsequence.length())
                     subsequenceNext = subsequence.charAt(j);
                  j++;  // always increment subsequence iterator
               }

               if (found)   // has the subsequence been found?
                  result = i; // result is equal to index where second while loop began iterating
            }

            // increment the DNA structure iterator and look at next Nucleotide
            i++;
            currentNucleotide = currentNucleotide.next;
         }

      }

      return result;
   }

   /**
    * Deletes an entire sequence from the DNA structure beginning at the startIndex and going
    * up to the endIndex (excluded). The method returns a String representing all of the base
    * pairs that were removed.
    *
    * @param startIndex points to the first base pairs to delete
    * @param endIndex points to the base pair after the last one to delete
    * @return a String that contains every base pair that was removed
    */
   public String removeSequence(int startIndex, int endIndex)
   {
      // if indices are at an invalid position(s)
      if ((startIndex < 0 || startIndex >= numElements)
              || (endIndex < 0 || endIndex > numElements))
         throw new IndexOutOfBoundsException("Improper indices");

      else  // indices are valid
      {
         String result = "";

         int i = 0;  // stores current loop index to be used later (already took care of 0, so it starts at 1)


         if (startIndex == 0) // needs special case for removing first pair
         {
            while (i < endIndex)
            {
               // saves Nucleotide originally pointed to
               Nucleotide originalNext = leftHelix.next;

               result += leftHelix.base.toString() + rightHelix.base.toString(); // adds bases of first Nucleotides to result

               if (originalNext != null)  // only if not at end of list
               {
                  leftHelix = originalNext;
                  rightHelix = originalNext.across;
               }

               numElements--; // have deleted an item
               i++;
            }

         }
         else  // index does not start at 0
         {
            i = 0;   // starts at 0 since list has not been changed
            Nucleotide currentNucleotide = leftHelix; // stores Nucleotide loop is currently on

            while (i < endIndex - 1)
            {
               if (i >= startIndex - 1) // i starts at position before removing bounds
               {
                  // gets Nucleotides to remove
                  Nucleotide nucleotideToRemove = currentNucleotide.next;

                  // adds bases to result to return later
                  result += nucleotideToRemove.base.toString() + nucleotideToRemove.across.base.toString();

                  // stores rest of DNA structure AFTER position to be removed so that it is saved
                  Nucleotide restOfStructure = nucleotideToRemove.next;

                  // sets removed Nucleotides' pointers to null so it doesn't point anywhere anymore
                  nucleotideToRemove.next = null;
                  nucleotideToRemove.across.next = null;

                  if (restOfStructure != null)  // only if not at the end
                  {
                     // removes the Nucleotides, preserving the rest of the DNA structure
                     currentNucleotide.next = restOfStructure;
                     currentNucleotide.across.next = restOfStructure.across;
                  }

                  numElements--; // decrements numElements by one because one pair has been deleted
               } else  // only advance if a Nucleotide has not been removed
                  currentNucleotide = currentNucleotide.next;
               i++;
            }
         }

         return result;
      }
   }


   /**
    * A class that represents a Nucleotide (Node) in the overall DNA structures (linked-list).
    * Each Nucleotide exists either in the leftHelix or the rightHelix.
    *
    * Every Nucleotide has a character representing it's base ('A', 'G', 'C', or 'T'). They
    * bond with other Nucleotides in the same position on the opposite helix based on the
    * following rules:
    *
    *    1) A with T
    *    2) C with G
    *
    * Each Nucleotide points to the both next Nucleotide in the same helix (next) and the
    * Nucleotide it is bonded with (across).
    */
   private class Nucleotide
   {
      private Nucleotide next, across;
      private Character base;
   }

}
