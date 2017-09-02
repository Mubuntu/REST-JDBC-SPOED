# REST-JDBC-SPOED
![logo]: https://i.imgur.com/8uOMzYm.png "Mubuntu logo" 
in deze opgave maak ik gebruik van database om de waarden in uit te lezen (via JDBC) en het restlet framework om waarden via een webservice in te geven.
---
####OPGAVE:
De spoedgevallendienst van St Vincentius heeft een nieuw registratiesysteem nodig. 
Maak een standalone (dus niet met een servlet) REST WebService met het restlet.org framework 
die toelaat om registraties in te geven (5 punten). De registraties worden weggeschreven in een bestand op schijf. 
Maak een testclient met een main methode die een tweetal registraties aanmaakt (3 punten).
---
Een registratie bestaat uit :

    datum en uur interventie
    naam patiënt
    geboortedatum patiënt
    naam verpleegkundige
    diagnose
---
|description table: 
	
|Field		|type		|Null		|Key		|default	|extra		|
 -----------|:---------:|:---------:|:---------:|:---------:|----------:|
interventiedatum| datetime| NO| PRI | CURRENT_TIMESTAMP |       |		|
naam        | varchar(40)| NO   | PRI | NULL          |   	|
| geboortedatum       | date         | NO   |     | 1994-02-25        |   |
| naamVerpleegkundige | varchar(40)  | NO   |     | Jill Seghers      |       |
| diagnose            | varchar(100) | YES  |     | NULL              |       |

|TABEL: repositories: 

tabel: 

| interventiedatum    | naam           | geboortedatum | naamVerpleegkundige | diagnose                                                  |
+---------------------+----------------+---------------+---------------------+-----------------------------------------------------------+
| 2014-07-05 14:20:02 | kimberly maes  | 1994-08-08    | brit bregies        | is aangereden geweest tegen 100km/u, twee benen gebroken. |
| 2017-09-02 00:48:31 | patrick frison | 1994-02-25    | kimberly maes       | allergische reactie op tandpasta                          |
| 2011-05-25 14:20:02 | tim celis      | 1994-03-25    | sonia kempen        | viel door een raam|
> creatie tabel
```SQL
create table registratie(interventiedatum TIMESTAMP not null default current_timestamp,
                          naam Varchar(40)not null, 
                          geboortedatum DATETIME not null default '1994-02-25',
                          naamVerpleegkundige varchar(40) not null default 'Jill Seghers',
                          diagnose varchar(40),
                          primary key (naam, interventiedatum));
```
---
```SQL
insert into registratie values ('2011-05-25 14:20:02', 'tim celis', '1994-03-25', 'sonia kempen', 'viel door een glazen ruit'),
('2017-09-02 00:48:31','patrick frison','1994-02-25','kimberly maes', 'allergische reactie op tandpasta'),
('2011-05-25 14:20:02', 'tim celis', '1994-03-25', 'sonia kempen', 'viel door een glazen ruit');

```