How to reproduce the bug:

1. Build the package:
     mvn package

2. Run it:
     ./run.sh

3- View out.pdf.

4. The original file empty.pdf was converted to out.pdf by.
   appending one character of text in the center of page 1.
   However, the text is not displayed as the font subset
   was not properly embedded in the output file.
