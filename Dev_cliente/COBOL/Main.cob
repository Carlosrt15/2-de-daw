       IDENTIFICATION DIVISION.
       PROGRAM-ID. SUMA-NUMEROS.

       DATA DIVISION.
       WORKING-STORAGE SECTION.
       77 NUM1        PIC 9(5) VALUE 0.
       77 NUM2        PIC 9(5) VALUE 0.
       77 RESULTADO   PIC 9(6) VALUE 0.

       PROCEDURE DIVISION.
           DISPLAY "=============================="
           DISPLAY "   PROGRAMA DE SUMA EN COBOL"
           DISPLAY "=============================="
           DISPLAY "Ingrese el primer numero: "
           ACCEPT NUM1
           DISPLAY "Ingrese el segundo numero: "
           ACCEPT NUM2

           ADD NUM1 TO NUM2 GIVING RESULTADO

           DISPLAY "------------------------------"
           DISPLAY "La suma de " NUM1 " + " NUM2 " es: " RESULTADO
           DISPLAY "------------------------------"

           STOP RUN.
