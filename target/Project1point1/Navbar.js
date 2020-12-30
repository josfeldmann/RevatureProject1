function makeNavbar(){
	document.getElementById("NAV").innerHTML = "<nav class=\"navbar navbar-light bg-success\"> <a class=\"navbar-brand\" href=\"#\">Generic Bank</a><button class = \"btn btn-primary\">Log Out</button></nav>";
}



function makeNavbarFolder(){
	document.getElementById("navarea").innerHTML = document.getElementById("navarea").innerHTML = "<nav class='navbar navbar-inverse'> <a href='../index.html' class='navbar-left'><img src='../images/logo.png'></a><div class='container-fluid'><div class='navbar-header'><button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#myNavbar'>Menu</button><a class='navbar-brand' href='../index.html'>UMD GDC</a></div>      <div class='collapse navbar-collapse float_right' id='myNavbar'>        <ul class='nav navbar-nav'>       <li><a href='../index.html'>Home</a></li>     <li><a href='../events.html'>Events</a></li>     <li><a href='../games.html'>Games</a></li>                          <li><a href='../index.html#contact'>Contact</a></li></ul></div></div></nav>";
}
