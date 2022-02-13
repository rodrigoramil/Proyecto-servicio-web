@echo off

cd target\site\jacoco

start index.html

timeout /t 2 /nobreak > NUL

start Firefox localhost:1234/almacena?HolaMundo

exit

