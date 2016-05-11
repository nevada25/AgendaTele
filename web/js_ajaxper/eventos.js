/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function soloNumero(vnum,nent,nfra) {
    if (event.keyCode !== 46 && ((event.keyCode < 48) || (event.keyCode > 57))) return false;
    if (event.keyCode == 46 && (vnum.indexOf(".") !== -1)) return false;
    if (event.keyCode !== 46 && vnum.length >= nent && vnum.indexOf(".") == -1) return false;
    var auxn = vnum.split(".");
    if (auxn[1] && auxn[1].length >= nfra) return false;
    return true;
}


