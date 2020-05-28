/*
    Leerlijn: Software Development Praktijk 1
    Docent: Frits Bosschert
    Student: Armand van Alphen
*/

Project gemaakt voor Novi hogeschool Software Development Praktijk 1
Dit document wordt 3maal gedeeld 
  1 in het project op github https://github.com/Armaniimus/NoviWerknemervandemaand
  2 in identiek project in het zip bestand geupload naar novi
  3 als apart bestand buiten het project in het zip bestand dat geupload wordt naar novi

####
# Technische details project
####
Primair test device tijdens bouw: Xiaomi Redmi Note 4

Min Sdk Version: Api level 22
Target Sdk Version: Api level 28
Compiled Sdk Version: Api level 28

voor meer info zie app/build.gradle in het project

####
# korte beschrijving functionaliteiten
####

Basis opbouw.
Het project is opgebouwt uit 3 tabbladen elk tabblad 
heeft de functionaliteit zoals beschreven in de intructie video van novi hieronder voor het gemak nog even opgesomt.

Tabblad1(MainActivity) bevat de volgende functionaliteiten
  1. foto inladen vanaf het toestel zelf
  2. foto maken met het toestel
  3. foto opslaan.
    - De foto wordt ook alleen in de app opgeslagen indien er op foto opslaan wordt gedrukt. 
    het betreft hier om een tijdelijke opslag om de foto te kunnen bewerken in tabblad 2.
    - Je wordt naar tabblad2 gebracht na het opslaan van de foto

Tabblad2(Tab2Activity) bevat de volgende functionaliteiten
  1. 5 items aan foto toevoegen
  2. storeImg
    - De store img functie is een permanente opslag van de foto in de app en slaat de foto op met de tekst Novi medewerker van de maand huidige maand
    waar de huidige maand weergegeven wordt met een numerieke datum
    - Indien niet op storeImg wordt gedrukt vervalt de bewerking indien je het tabblad verlaat.
    - Je wordt automatich naar tabblad 3 gebracht als je op storeImg drukt.
    - de StoreImg knop staat onder de foto je kan hier heen scrollen.

Tabblad3(Tab2Activity) bevat de volgende functionaliteiten
  1. foto selecteren
    - De foto kan je selecten door op de foto naar keus te drukken.
    - Je kunt zien dat de foto geselecteerd is door de blauwe rand.
  2. foto delen
    - Indien er geen foto geselecteerd is wordt er een waarschuwing weergegeven op het scherm als je hem probeert te delen.

####
# Domein classen
####

1. GetImg_Model
2. Logger
3. PermStorage_Model
4. RowFactory_Model
5. RowImgFactory_Model
6. Tab3GridView_Model
7. Tab3SelectNHandle_Model

####
# Controller classen
####
1. MainActivity
2. Tab2Activity
3. Tab3Activity

