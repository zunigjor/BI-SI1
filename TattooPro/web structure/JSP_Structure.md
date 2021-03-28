**messagesSent.jsp**

*-popis:*

stránka, kde si aktuálně přihlášený uživatel prohlíží své odeslané zprávy a má možnost i odeslat novou jinému existujícímu uživateli

*-url:*

/myprofile/messages/sent

*-atributy:*

List < MessageDAO > sent

*-požadavky:*

forma na odeslání - username a messageText

výpis odeslaných zpráv

**messagesReceived.jsp**

*-popis:*

stránka, kde si aktuálně přihlášený uživatel prohlíží své přijaté zprávy a má možnost i odeslat novou jinému existujícímu uživateli

*-url:*

/myprofile/messages/received

*-atributy:*

List < MessageDAO > received

String msg 

*-požadavky:*

vypsat zprávu msg - obsahuje text o úspěšném odeslání zprávy

forma na odeslání - username a messageText

výpis přijatých zpráv


**usersRoot.jsp**

*-popis:*

rozcestník, ze kterého můžeme přejít na seznamy tatérů a zákazníků

*-url:*

/users

*-atributy:*

userUsername,

*-požadavky:*

tlačítka na přesměrování na "/users/artists" a "/users/customers" a zobrazeni daneho seznamu


**usersArtists.jsp** 

*-popis:*

seznam tatérů, možnost jít na jejich profily

*-url:*

/users/artists

*-atributy:*

List< TatooArtistDTO > artists

*-požadavky:*

vyhledani podle name/surname, zobrazeni seznamu



**usersCustomers.jsp** 

*-popis:*

seznam zákazníků

*-url:*

/users/customers

*-atributy:*

List< CustomerDTO > customers

*-požadavky:*

vyhledani podle username, zobrazeni seznamu



**usersArtistProfile.jsp**

*-popis:*

profil tatéra/zakaznika

*-url:*

/users/artist/{profile}

*-atributy:*

TatooArtistDTO artist

*-požadavky:*

zobrazeni detailu o uctu a moznost zmenit dane policko



**usersCustomerProfile.jsp**

*-popis:*

profil tatéra/zakaznika

*-url:*

/users/customer/{profile}

*-atributy:*

CustomerDTO customer

*-požadavky:*

zobrazeni detailu o uctu a moznost zmenit dane policko





**bad.jsp**

*-popis:*

chybova stranka, zobrazi chybu

*-url:*

/{nekde kde je chyba}/bad

*-atributy:*

String errorMsg - chybova hlaska

*-požadavky:* 

zobrazení chybové hlášky


**profile.jsp**

*-popis:*

místo, kde si customer edituje a prohlíží výhradně svůj profil

*-url:*

/myprofile

*-atributy:*

User user - aktuálně přihlášený uživatel

*-požadavky:*




**profile_artist.jsp**

*-popis:*

místo, kde si artist edituje a prohlíží výhradně svůj profil

*-url:*

/myprofile

*-atributy:*

User user - aktuálně přihlášený uživatel

*-požadavky:*


**login.jsp**

*-popis:*

misto, kde se přihlašují

*-url:*

/login

*-atributy:*

String errorMsg - string s chybovou hláškou (např.: špatné heslo)

String msg - string se zpravou "uspesne odhlaseni" 

*-požadavky:*

Bylo by cool, kdyby byla možnost přesměrování na "registration"

Vypsat obě zprávy


**register.jsp**

*-popis:* registrace uzivatele

*-url:*

 /register
 
*-atributy:* 

String errorMsg - string s chybovou hlaskou (např.: krátké heslo) 

*-požadavky:*

Vypsat ten errorMsg


**info.jsp**

*-popis:* info stranka, s kontakty, odkazy na wiki, git, dokumentaci;

*-url:* /info
