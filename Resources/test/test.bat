::Letisztítja a képernyő, hogy csak a lényeg kerüljön kiírásra
@ECHO OFF

:: belemásolja a "testName" változóba a begépelt szöveget
:readinput

set /p testFileName= Adjon meg egy tesztet, amit futtatni szeretne(pl.: test1.txt): 

IF "%testFileName%" == "q" (
		GOTO :end
) ELSE (
		IF NOT EXIST %testFileName% ECHO File not found!
		
		for /f "tokens=*" %%a in (%testFileName%) do (
				echo line=%%a
		)
		
		GOTO readinput
)

:: Kiírj a standard inputra egy file tartalmát
::TYPE test.txt

:: Ez a parancs kilistázza a két fájl közti különbségeket
::FC /L test.txt test2.txt

:: Megállítja a futást hogy ne záródjon be rögtön a program
::pause

:end
