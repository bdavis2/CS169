       identification division.
       program-id. hangman.
       environment division.
           input-output section.
           file-control.
               select answers assign to "hangman.txt"
               organization is line sequential.
               select graphic assign to "hangman-graphic.txt"
               organization is line sequential.
       data division.
           file section.
           fd answers.
           01 answers-file.
               05 hangman-word PIC X(10).
           fd graphic.
               01 graphic-file.
                   05 graphic-word PIC X(10).
       working-storage section.
           01 word                            pic X(10).

           01 word-length                     pic 99.
           01 guess                           pic X.
           01 past-guesses                    pic X(26).
           01 wrong-guesses                   pic 99 VALUE ZERO.
           01 word-group.
               05 word-table                  pic X(10) OCCURS 16 TIMES.
      *    value of word-table occurance depends on how many words exist in word bank
           01 hangman-graphic.
               05 graphic-text                pic X(10) occurs 57 times.
           01 graphic-pointer                  pic 99.
           01 FILLER.
               88  clear-to-no-guesses          VALUE ZERO.
               05  FILLER occurs 256 times.
                  10  FILLER                   PIC X.
                      88  letter-guessed       VALUE "1".
           01 FILLER                           pic X.
               88  done                         VALUE "Q".
               88  done-not                     VALUE "7".
           01 FILLER                           pic X.
               88  no-missing-letters           VALUE ":".
               88  missing-letter               VALUE "3".
           01 correct-guess                    pic X.
           01 i                                pic 999.
           01 temp                             pic 9.
           01 eof                              pic A.
           01 seed                             pic 9(7).
           01 tal-ctr                          pic 9.
           procedure division.


           MOVE 1                  TO i
           open input answers.
           perform until eof = 'Y'
               read answers into hangman-word
               at end move 'Y' to eof
               not at end
               move hangman-word to word-table(i)
                   add 1 to i
               end-read
           end-perform.
           close answers.

           move 'n' to eof.
           move 1                  to i
           open input graphic
               perform until eof = 'Y'
               read graphic into graphic-word
               at end move 'Y' to eof
               not at end
                   move graphic-word to graphic-text(i)
                   add 1 to i
               end-read
           end-perform.
           close graphic.
           move 1 to graphic-pointer.
           move function current-date (9:7) to seed
           compute i = function mod(seed, 16) + 1
               move word-table(i)               to word
               inspect word-table(i) tallying
                           word-length for characters before space

               set clear-to-no-guesses    TO TRUE
               set done-not               TO TRUE

               display "word length: " word-length


               perform until done
               move 0 to tal-ctr

                   accept guess
                   SET letter-guessed
                       ( function ord ( guess ) )
                                  TO TRUE
               inspect word tallying tal-ctr for all guess
               SET no-missing-letters TO TRUE
               move 'N' to correct-guess

               MOVE ZERO              TO i

               perform word-length TIMES
                   add 1              TO i
                   if letter-guessed ( function ord ( word ( i : 1 ) ) )
                       display word ( i : 1 ) with no advancing
                   else
                       SET missing-letter TO TRUE
                       display "_" with no advancing
                   end-if
               end-perform
               if tal-ctr = 0
                   add 1 to wrong-guesses
                   display " "
                   add 7 to graphic-pointer
                   STRING past-guesses DELIMITED BY SPACE
                       guess DELIMITED BY SIZE
                       INTO past-guesses
                   END-STRING
               ELSE
                   display " "
               end-if
               subtract wrong-guesses from 7 giving temp
               perform  test after varying i from graphic-pointer by
                                         1 until i = graphic-pointer + 6
                   display graphic-text (i)
                   end-perform
               display " "
               display "gueses remaining:" temp
               display "past guesses:" past-guesses

               if no-missing-letters
                   SET done      TO TRUE
                   display "You Win!"
               end-if

               if wrong-guesses > 6
                   SET done TO TRUE
                   display "You Lose! Word was:" word
               end-if
               end-perform
           goback.
           END PROGRAM hangman.
