@ECHO OFF
color 0B
mode con:cols=100 lines=15
@cls
echo.
echo.
echo.
@echo.  
@echo.  
@echo.  
@echo                                   백그라운드에서 설치중 잠시 기다려주세요!
@echo                                      설치 완료후 창은 자동으로 닫힙니다~  
@echo.  
@echo.  
@echo off
"%~dp0AdGuard.v7.2.2936.0.exe" /qn INSTALLDESKTOPSHORTCUT=1
exit