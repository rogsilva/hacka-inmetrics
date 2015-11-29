<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="includes/libs.jsp" %>

<c:import url="includes/header.jsp" />
<c:import url="includes/menu.jsp" />       

<div id="page-wrapper">

    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="row">
            <div class="col-lg-12">                
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-fw fa-bar-chart-o"></i>  <a href="index.jsp">Social Mídia</a>
                    </li>
                    <li class="active">
                         Parâmetros
                    </li>
                    <li class="active">
                         Resultado
                    </li>
                </ol>
            </div>
            
            
            <!-- 
            
            <div><h1>twitter1.name = ${twitter1.name}</h1></div>
            <div><h1>twitter1.likesPage = ${twitter1.likesPage}</h1></div>
            <div><h1>twitter1.likesPost = ${twitter1.likesPost}</h1></div>
            
            <div><h1>twitter2.name = ${twitter2.name}</h1></div>
            <div><h1>twitter2.likesPage = ${twitter2.likesPage}</h1></div>
            <div><h1>twitter2.likesPost = ${twitter2.likesPost}</h1></div>
            
            
            
            <div><h1>facebook1.name = ${facebook1.name}</h1></div>
            <div><h1>facebook1.likesPage = ${facebook1.likesPage}</h1></div>
            <div><h1>facebook1.likesPost = ${facebook1.likesPost}</h1></div>
            
            <div><h1>facebook2.name = ${facebook2.name}</h1></div>
            <div><h1>facebook2.likesPage = ${facebook2.likesPage}</h1></div>
            <div><h1>facebook2.likesPost = ${facebook2.likesPost}</h1></div>
            
             -->
            
            
            
        </div>
        <div class="row">
        	<div class="col-lg-12">
        		<h2 class="page-header">
                    Resultado da Busca
                </h2>
        	</div>
        </div>
        <!-- /.row -->
        <div class="row" >
       		 <div class="col-lg-1" >
        		<span style='float: left; margin-top: 30%'><h3><strong>${facebookName1}</strong></h3></span>
        	</div>
        	<div class="col-lg-5">
        		<div id="grafico1"></div>
        	</div>
        	<div class="col-lg-6">
        		<div id="grafico2"></div>
        	</div>
        </div>
        <div class="row">
        	<div class="col-lg-1 centered">
        		<span style='float: left; margin-top: 30%'><h3><strong>${facebookName2}</strong></h3></span>
        	</div>
        	<div class="col-lg-5">
        		<div id="grafico3"></div>
        	</div>
        	<div class="col-lg-6">
        		<div id="grafico4"></div>
        	</div>
        </div>
   
        </div>
        <!-- /.row -->
        
    </div>
    <!-- /.container-fluid -->

</div>
<!-- /#page-wrapper -->
<script type="text/javascript" src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
<script type="text/javascript" src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['geochart']}]}"></script>
<script type="text/javascript" src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['bar']}]}"></script>
<script>



//Grafico 1
google.setOnLoadCallback(drawChart1);
function drawChart1() {

  var data = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['${twitter2.name}',     ${twitter2.likesPage}],
    ['${facebook2.name}',     ${facebook2.likesPage}]
  ]);

  var options = {
    title: 'Followers'
  };

  var chart = new google.visualization.PieChart(document.getElementById('grafico1'));

  chart.draw(data, options);
}

//Grafico 2
google.setOnLoadCallback(drawChart2);
function drawChart2() {

  var data = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['${twitter2.name}',     ${twitter2.likesPost}],
    ['${facebook2.name}',     ${facebook2.likesPost}]
  ]);

  var options = {
    title: 'Recent Likes'
  };

  var chart = new google.visualization.PieChart(document.getElementById('grafico2'));

  chart.draw(data, options);
}

//Grafico 3
google.setOnLoadCallback(drawChart3);
function drawChart3() {

  var data = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['${twitter1.name}',     ${twitter1.likesPage}],
    ['${facebook1.name}',     ${facebook1.likesPage}]
  ]);

  var options = {
    title: 'Followers'
  };

  var chart = new google.visualization.PieChart(document.getElementById('grafico3'));

  chart.draw(data, options);
}

//Grafico 4
google.setOnLoadCallback(drawChart4);
function drawChart4() {

	var data = google.visualization.arrayToDataTable([
	['Task', 'Hours per Day'],
	['${twitter1.name}',     ${twitter1.likesPost}],
	['${facebook1.name}',     ${facebook1.likesPost}]
]);

  var options = {
    title: 'Recent Likes'
  };

  var chart = new google.visualization.PieChart(document.getElementById('grafico4'));

  chart.draw(data, options);
}


</script>
<c:import url="includes/footer.jsp" />
    
