call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startChrome
echo.
echo GRADLEW BUILD has errors - breaking work
goto fail

:startChrome
cd "C:\Program Files (x86)\Google\Chrome\Application\"
start chrome.exe
start http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.