# REST-JDBC-SPOED
[logo]: https://i.imgur.com/8uOMzYm.png "Mubuntu logo" 

__OPGAVE: __**
De spoedgevallendienst van St Vincentius heeft een nieuw registratiesysteem nodig. 
Maak een standalone (dus niet met een servlet) REST WebService met het restlet.org framework 
die toelaat om registraties in te geven (5 punten). De registraties worden weggeschreven in een bestand op schijf. 
Maak een testclient met een main methode die een tweetal registraties aanmaakt (3 punten).

Een registratie bestaat uit :

    datum en uur interventie
    naam patiënt
    geboortedatum patiënt
    naam verpleegkundige
    diagnose
	
|Field		|type		|Null		|Key		|default	|extra		|
 -----------|:---------:|:---------:|:---------:|:---------:|----------:|
interventiedatum| datetime| NO| PRI | CURRENT_TIMESTAMP |       |		|
naam        | varchar(40)| NO   | PRI | NULL          |   	|
| geboortedatum       | date         | NO   |     | 1994-02-25        |       |
| naamVerpleegkundige | varchar(40)  | NO   |     | Jill Seghers      |       |
| diagnose            | varchar(100) | YES  |     | NULL              |       |
