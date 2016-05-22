#Your Dream Skateboard Builder

##Leírás
A Your Dream Skateboard Builder egy olyan Java alkalmazás, mely segítségével az alkalmazás adatbázisában meglévő gördeszka alkatrészekből összeállíthatsz magadnak egy teljesen egyedi gördeszkát, eltárolhatod, és akár meg is rendelheted! Az alkalmazás segít neked abban is, hogy a hibásan összeállított, azaz nem összeillő komponenesekből álló gördeszkát ne tudj létrehozni.

##Követelmény
A program lefordítható és működőképes minden olyan környezetben, ahol rendelkezésre állnak a következőek:
* JDK, minimum 1.8-as verziószámmal
* Apache Maven

##Program használata
A projekt mappájában add ki a következő parancsot:
```
mvn package
```
Ha ez sikerrel lefutot, a `target` mappán belül létrejövő `your-dream-skateboard-builder-1.0-jar-with-dependencies.jar` fájt futtatva használhatod a programot.

###Létrejövő állományok
A program futása során XML állományokat hozhat létre, melyek a felhasználó home könyvtárába kerülnek!

##Oldal generálása
A projekt oldalának legenerálásához és az ehhez tartozó jelentések megtekintéséhez add ki a következő parancsot a projekt mappájában:
```
mvn site
```
A legenerált oldal a `target` mappa alatt lévő `site` mappában lesz elérhető.