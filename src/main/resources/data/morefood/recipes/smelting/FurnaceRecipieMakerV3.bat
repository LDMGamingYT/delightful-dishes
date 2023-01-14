@echo off

FOR /F "tokens=* USEBACKQ" %%F IN (`cd`) DO (
SET dir=%%F
)

title Easily Create Smelting Recipies v3 - By LDM Gaming

echo.
echo Easily Create Smelting Recipies v3 - By LDM Gaming
echo Contact me on my Discord Server: https://http://bit.ly/LDMVerse
echo.

echo The files will be created in %dir%
pause
goto ask_meta

:ask_meta
echo.
set /p name="What is your recipe called? (This name will not be shown in-game.) "
set /p raw_item="What item are you going to cook? (e.g. minecraft:porkchop) "
set /p cooked_item="What is the output item? (e.g. minecraft:cooked_porkchop) "

:ask_type
set init=""
echo.
echo c - Cooking (Furnace, Smoker, Campfire)
echo b - Blasting (Furnace, Blast Furnace)
echo s - Smelting (Furnace)
echo a - Campfire Cooking (Campfire)
set /p init=""

if %init%==c goto cooking
if %init%==C goto cooking
if %init%==b goto blasting
if %init%==B goto blasting
if %init%==s goto smelting
if %init%==S goto smelting
if %init%==a goto campfire_only
if %init%==A goto campfire_only

echo You didn't type a correct response.
goto ask_type

:cooking
(
echo {
echo     "type": "minecraft:smoking",
echo     "ingredient": {
echo         "item": "%raw_item%"
echo     },
echo     "result": "%cooked_item%",
echo     "experience": 0.35,
echo     "cookingtime": 100
echo }
)>%name%_smoking.json
goto campfire

:blasting
(
echo {
echo     "type": "minecraft:blasting",
echo     "ingredient": {
echo         "item": "%raw_item%"
echo     },
echo     "result": "%cooked_item%",
echo     "experience": 0.35,
echo     "cookingtime": 100
echo }
)>%name%_blasting.json
goto smelting

:campfire
(
echo {
echo     "type": "minecraft:campfire_cooking",
echo     "ingredient": {
echo         "item": "%raw_item%"
echo     },
echo     "result": "%cooked_item%",
echo     "experience": 0.35,
echo     "cookingtime": 600
echo }
)>%name%_campfire.json
goto smelting

:campfire_only
(
echo {
echo     "type": "minecraft:campfire_cooking",
echo     "ingredient": {
echo         "item": "%raw_item%"
echo     },
echo     "result": "%cooked_item%",
echo     "experience": 0.35,
echo     "cookingtime": 600
echo }
)>%name%_campfire.json
goto finish

:smelting
(
echo {
echo     "type": "minecraft:smelting",
echo     "ingredient": {
echo         "item": "%raw_item%"
echo     },
echo     "result": "%cooked_item%",
echo     "experience": 0.35,
echo     "cookingtime": 200
echo }
)>%name%_smelting.json
goto finish

:finish
echo Done! Documents created in %dir%
pause