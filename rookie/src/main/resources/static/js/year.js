/* 
 * https://oshiete.goo.ne.jp/qa/5515633.htmls
 */
onload = function() {
    var select = document.getElementById("year");
 
    var thisYear = (new Date()).getFullYear();
    var years = [ thisYear, thisYear - 1 ];
 
    for ( var i in years) {
        var option = document.createElement("option");
        option.value = years[i];
        option.appendChild(document.createTextNode(years[i]));
        select.appendChild(option);
    }
}