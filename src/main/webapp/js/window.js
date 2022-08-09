function open_window(win_name){
    document.getElementById("main").style = "filter: blur(5px);"
    var win = document.getElementById(win_name);
    win.style = "z-index:99999; display:inline-block;";
}
function close_window(win_name){
    var win = document.getElementById(win_name);
    win.style = "display:none; z-index:0;";
    document.getElementById("main").style = "filter: none;"
}