var timeout    = 500;
var closetimer = 0;
var ddmenuitem = 0;

var newDiv;
var parentDiv;
var parent;
var subMenuName;
var baseurl = "http://localhost:8080/MDR";

function jsddm_open()
{  jsddm_canceltimer();
   jsddm_close();
   ddmenuitem = $(this).find('ul').css('visibility', 'visible');}

function jsddm_close()
{  if(ddmenuitem) ddmenuitem.css('visibility', 'hidden');}

function jsddm_timer()
{  closetimer = window.setTimeout(jsddm_close, timeout);}

function jsddm_canceltimer()
{  if(closetimer)
   {  window.clearTimeout(closetimer);
      closetimer = null;}}



document.onclick = jsddm_close;
	
	function createMenu(element){
		/* Creating the parent <ul> element for the menu*/
		newDiv = $('<ul></ul>');
		newDiv.attr("id","jsddm");
		newDiv.appendTo(element);
		parent = newDiv;
		
		/*Creating submenu 1*/
		subMenuName = "search";
		parentDiv = createMenuName(parent,subMenuName); 
				
		/*element 1 of submenu1*/
		newDiv = createLi("data element","#");
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu1*/
		newDiv = createLi("value domain","#");
		newDiv.appendTo(parentDiv);
		
		/*element 3 of submenu1*/
		newDiv = createLi("vocabulary term","#");
		newDiv.appendTo(parentDiv);
		
		/*##########submenu ends##################################################*/
		
		/*Creating submenu 2*/
		subMenuName = "browse";
		parentDiv = createMenuName(parent,subMenuName);
				
		/*element 1 of submenu2*/
		newDiv = createLi("data element", baseurl + "/dataelement/browse"); 
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu2*/
		newDiv = createLi("value domain", baseurl + "/valuedomain/browse");
		newDiv.appendTo(parentDiv);
		
		/*element 3 of submenu2*/
		newDiv = createLi("classification scheme", baseurl + "/classificationscheme/browse");
		newDiv.appendTo(parentDiv);
		
		/*##########submenu ends##################################################*/
		
		/*Creating submenu 3*/
		subMenuName = "discover";
		parentDiv = createMenuName(parent,subMenuName);
		/*element 1 of submenu1*/
		newDiv = createLi("data element","#"); 
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu1*/
		newDiv = createLi("value domain","#");
		newDiv.appendTo(parentDiv);
		
		/*##########submenu ends##################################################*/
		
				
		/*Creating submenu 4*/
		subMenuName = "background";
		parentDiv = createMenuName(parent,subMenuName);
		/*element 1 of submenu4*/
		newDiv = createLi("ISO 11179","#"); 
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu4*/
		newDiv = createLi("Other Relevant Papers","#");
		newDiv.appendTo(parentDiv);
		
		/*##########submenu ends##################################################*/
		
		/*Creating submenu 5*/
		subMenuName = "create";
		parentDiv = createMenuName(parent,subMenuName);
		/*element 1 of submenu5*/
		newDiv = createLi("data element", baseurl + "/dataelement"); 
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu5*/
		newDiv = createLi("value domain", baseurl + "/createValueDomain");
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu5*/
		newDiv = createLi("classification scheme", baseurl + "/addClassificationScheme");
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu5*/
		newDiv = createLi("model","model");
		newDiv.appendTo(parentDiv);
		
		
		/*##########submenu ends##################################################*/
		 /*Creating submenu 6*/
		subMenuName = "administer";
		parentDiv = createMenuName(parent,subMenuName);
		/*element 1 of submenu6*/
		newDiv = createLi("links","#"); 
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu6*/
		newDiv = createLi("ebXMLRepository","#");
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu6*/
		newDiv = createLi("UML","#");
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu6*/
		newDiv = createLi("federation","#");
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu6*/
		newDiv = createLi("organisation","#");
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu6*/
		newDiv = createLi("person", baseurl + "/person");
		newDiv.appendTo(parentDiv);
		
		/*element 2 of submenu6*/
		newDiv = createLi("people", baseurl + "/listpeople");
		newDiv.appendTo(parentDiv);
		
		/*##########submenu ends##################################################*/
		
		$('#jsddm > li').bind('mouseover', jsddm_open)
		$('#jsddm > li').bind('mouseout',  jsddm_timer)
	}
	
	function createMenuName(thisParent,name){
		var newDiv = createLi(name,"#");
		newDiv.appendTo(thisParent);
		var parentDiv = newDiv;
		newDiv = $('<ul></ul>');  
		newDiv.appendTo(parentDiv);
		//parentDiv = newDiv;
		return newDiv;
	}
	
	
	function createLi(name,url){
		var parentDiv;
		var newDiv;
		parentDiv = $('<li></li>');
		newDiv = $('<a>' +name+ '</a>');
		newDiv.attr('href',url);
		newDiv.appendTo(parentDiv);
		return parentDiv;
	}
