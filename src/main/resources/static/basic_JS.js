function changeDisplayItemID( ID, display ){
    var item = document.getElementById(ID);
    item.style.display = display;
}

function messageRespond( ID, display, ID2, recipient ){
    changeDisplayItemID( ID, display );
    document.getElementById(ID2).value = recipient;
}

function displayMessage( ID, text ) {
    document.getElementById(ID).innerHTML = text;
}

// function removeMessages() {
//     const table = document.getElementById("mess_table");
//     while( table.firstChild ){
//         table.removeChild(table.lastChild);
//     }
// }

function equalHTML( sourceID, targetID ) {
    var source = document.getElementById( sourceID );
    var target = document.getElementById( targetID );
    target.innerHTML = source.innerHTML;
}