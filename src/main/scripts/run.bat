@echo off

SETLOCAL

if NOT DEFINED JAVA_HOME goto err

set SCRIPT_DIR=%~dp0
for %%I in ("%SCRIPT_DIR%..") do set APP_HOME=%%~dpfI

REM ***** JAVA options *****

set APP_CLASSPATH=.;%APP_HOME%/lib/*
set APP_PARAMS=-Dapp.path.home="%APP_HOME%"

echo init...
echo APP_HOME: %APP_HOME%
echo APP_CLASSPATH : %APP_CLASSPATH%
echo APP_PARAMS: %APP_PARAMS%
echo init ok!

"%JAVA_HOME%\bin\java" %APP_PARAMS% -cp "%APP_CLASSPATH%" "com.changong28.maven.HelloWorld"
goto finally

:err
echo JAVA_HOME environment variable must be set!
pause

:finally

ENDLOCAL