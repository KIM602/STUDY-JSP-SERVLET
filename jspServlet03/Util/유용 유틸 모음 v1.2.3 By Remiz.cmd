@echo off
>nul 2>&1 "%SYSTEMROOT%\system32\cacls.exe" "%SYSTEMROOT%\system32\config\system"
if '%errorlevel%' NEQ '0' (
    echo Run as Administrator...
    goto UACPrompt
) else ( goto gotAdmin )
:UACPrompt
    echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\getadmin.vbs"
    set params = %*:"=""
    echo UAC.ShellExecute "cmd.exe", "/c %~s0 %params%", "", "runas", 1 >> "%temp%\getadmin.vbs"

    "%temp%\getadmin.vbs"
    rem del "%temp%\getadmin.vbs"
    exit /B
:gotAdmin

:main
cls
echo.
echo.
echo		[ ���� ��ƿ ���� v1.2.3 By Remiz ]
echo.
echo.
echo		1. Chrome 78.0.3904.97
echo.
echo		2. CCleaner 5.63 Pro
echo.
echo		3. �ܺ� 5.31
echo.
echo		4. īī���� 3.0.7.2319
echo.
echo		5. ���÷��̾� 1.7.20977
echo.
echo		6. ���÷��̾� ����Ų �����ϱ� (���� ��ġ �� ����)
echo.
echo		7. uTorrent 3.5.5.45395
echo.
echo		8. AdGuard 7.2.2936.0
echo.
echo		9. ���̹� ���� ������ 2.6.88.13
echo.
echo		0. Safevisit (���� ����Ʈ ��ȸ ����)
echo.
echo.
set menu=
set /p menu=���Ͻô� �۾� ��ȣ�� �Է� �� ����(Enter)Ű�� �����ּ��� : 
if "%menu%" == "1" goto chrome
if "%menu%" == "2" goto clr
if "%menu%" == "3" goto hv
if "%menu%" == "4" goto ka
if "%menu%" == "5" goto pp
if "%menu%" == "6" goto old
if "%menu%" == "7" goto ut
if "%menu%" == "8" goto ad
if "%menu%" == "9" goto wh
if "%menu%" == "0" goto sn

goto main

:chrome
start %~dp01mp\chrome\"chrome.exe"
pause
goto main

:clr
start %~dp01mp\clr\"clr.cmd"
pause
goto main

:hv
start %~dp01mp\hv\"hv.exe"
pause
goto main

:ka
start %~dp01mp\ka\"ka.exe"
pause
goto main

:pp
start %~dp01mp\pp\"pp.exe"
pause
goto main

:old
start %~dp01mp\pp\"old.dsf"
pause
goto main

:ut
start %~dp01mp\ut\"ut.cmd"
pause
goto main

:ad
start %~dp01mp\ad\"ad.cmd"
pause
goto main

:wh
start %~dp01mp\wh\"wh.exe"
pause
goto main

:sn
start %~dp01mp\sn\"sn.exe"
pause
goto main

:exit
exit