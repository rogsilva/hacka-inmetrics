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
        		<h2 class="page-header">
                    Resultado da Busca
                </h2>
        	</div>
        </div>
        <!-- /.row -->
        <div class="row" >
       		 <div class="col-lg-1 text-capitalize" >
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
        	<div class="col-lg-1 text-capitalize">
        		<span style='float: left; margin-top: 30%'><h3><strong>${facebookName2}</strong></h3></span>
        	</div>
        	<div class="col-lg-5">
        		<div id="grafico3"></div>
        	</div>
        	<div class="col-lg-6">
        		<div id="grafico4"></div>
        	</div>
        </div>
        <div class="row">
        	<div class="col-lg-12 text-capitalize">
        		<div id="grafico5"></div>
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
    ['Task', 'Percent'],
    ['${twitter2.name}',     parseInt('${twitter2.likesPage}')],
    ['${facebook2.name}',     parseInt('${facebook2.likesPage}')]
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
    ['Task', 'Percent'],
    ['${twitter2.name}',     parseInt('${twitter2.likesPost}')],
    ['${facebook2.name}',     parseInt('${facebook2.likesPost}')]
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
    ['Task', 'Percent'],
    ['${twitter1.name}',     parseInt('${twitter1.likesPage}')],
    ['${facebook1.name}',     parseInt('${facebook1.likesPage}')]
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
	['Task', 'Percent'],
	['${twitter1.name}',     parseInt('${twitter1.likesPost}')],
	['${facebook1.name}',     parseInt('${facebook1.likesPost}')]
]);

  var options = {
    title: 'Recent Likes'
  };

  var chart = new google.visualization.PieChart(document.getElementById('grafico4'));

  chart.draw(data, options);
}

//Grafico5
 google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Busca', 'Posts', 'Pages'],
          ['${facebookName1}', parseInt('${facebook1.likesPost}'), parseInt('${facebook1.likesPage}')],
          ['${twitterName1}', parseInt('${twitter1.likesPost}'), parseInt('${twitter1.likesPage}')] ,
          ['${facebookName2}', parseInt('${facebook2.likesPost}'),parseInt('${facebook2.likesPage}')],
          ['${twitterName2}', parseInt('${twitter2.likesPost}'), parseInt('${twitter2.likesPage}')]
        ]);

        var options = {
          chart: {
            title: 'Comparação Geral',
            subtitle: '',
          },
          bars: 'horizontal', // Required for Material Bar Charts.
          hAxis: {format: 'decimal'},
          height: 400,
          colors: ['#1b9e77', '#d95f02']
        };

        var chart = new google.charts.Bar(document.getElementById('grafico5'));

        chart.draw(data, google.charts.Bar.convertOptions(options));

        var btns = document.getElementById('btn-group');

        btns.onclick = function (e) {

          if (e.target.tagName === 'BUTTON') {
            options.hAxis.format = e.target.id === 'none' ? '' : e.target.id;
            chart.draw(data, google.charts.Bar.convertOptions(options));
          }
        }
      }
</script>
<c:import url="includes/footer.jsp" />
    
