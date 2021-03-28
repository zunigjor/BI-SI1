**/register**

*-popis:*

registrace uživatele

*-atributy:*

text uname - uživatelské jméno

password pass - heslo

text email - email

checkbox isart - zaškrtnut, pokud je uživatel tatér

**/login**

*-popis:*

přihlášení uživatele, stará se o to spring

*-atributy:*

password password - heslo

text username - jméno

**/myprofile/messages/new**

*-popis:*

vytvoření nové zprávy (mezi uživateli)

*-atributy:*

text username - jméno adresáta

text messageText - text zprávy

**/myprofile/artist/edit/profile**

*-popis:*

uprava profilu tatera, bez hesla

*-atributy:*
(form name="editProf")

text email - email

number exp - yearsOfExpierience

number price - pricePerHour

**/myprofile/artist/edit/password**

*-popis:*

uprava profilu tatera, jenom heslo

*-atributy:*

(form name="editPass")

password pass - heslo

**/myprofile/customer/edit/profile**

*-popis:*

uprava profilu customera, bez hesla

*-atributy:*
(form name="editProfCust")

text email - email

**/myprofile/customer/edit/password**

*-popis:*

uprava profilu customer, jenom heslo

*-atributy:*

(form name="editPassCust")

password pass - heslo

**/myprofile/artist/edit/picture**

*-popis:*

uprava profilu tatera, jenom profile picture

*-atributy:*
(form name="editProfPic")

file myImage - mime type picture

**/myprofile/customer/edit/picture**

*-popis:*

uprava profilu customer, jenom profile picture

*-atributy:*

(form name="editProfPicCust")

file myImage - mime type picture



