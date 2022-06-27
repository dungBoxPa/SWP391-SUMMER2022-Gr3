window.onload = function() {
    var patharr = location.pathname.split("/");
    var fileName = patharr[1];
    var options = document.getElementById('options');
    var links = options.getElementsByTagName("a");
    // alert(links.length);
    for (i = 1; i < links.length; i++) {
        if (links[i].getAttribute("href").indexOf(fileName) > -1) {
            links[i].parentNode.className = 'current';
        }
    }
}