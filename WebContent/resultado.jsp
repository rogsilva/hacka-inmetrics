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
        </div>
        <div class="row">
        	<div class="col-lg-12">
        		<h2 class="page-header">
                    Resultado da Busca
                </h2>
        	</div>
        </div>
        <!-- /.row -->
        <div class="row">
        	<div class="col-lg-6">
        		<div id="grafico1"></div>
        	</div>
        	<div class="col-lg-6">
        		<div id="grafico2"></div>
        	</div>
        </div>
        <div class="row">
        	<div class="col-lg-6">
        		<div id="grafico3"></div>
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
google.setOnLoadCallback(drawSeriesChart);

function drawSeriesChart() {

  var data = google.visualization.arrayToDataTable([
    ['ID', 'Burger King', 'Fertility Rate', 'Region',     'Population'],
    ['CAN',    80.66,              1.67,      'North America',  33739900],
    ['DEU',    79.84,              1.36,      'Europe',         81902307],
    ['DNK',    78.6,               1.84,      'Europe',         5523095],
    ['EGY',    72.73,              2.78,      'Middle East',    79716203],
    ['GBR',    80.05,              2,         'Europe',         61801570],
    ['IRN',    72.49,              1.7,       'Middle East',    73137148],
    ['IRQ',    68.09,              4.77,      'Middle East',    31090763],
    ['ISR',    81.55,              2.96,      'Middle East',    7485600],
    ['RUS',    68.6,               1.54,      'Europe',         141850000],
    ['USA',    78.09,              2.05,      'North America',  307007000]
  ]);

  var options = {
    title: 'Correlation between life expectancy, fertility rate and population of some world countries (2010)',
    hAxis: {title: 'Life Expectancy'},
    vAxis: {title: 'Fertility Rate'},
    bubble: {textStyle: {fontSize: 11}}
  };

  var chart = new google.visualization.BubbleChart(document.getElementById('grafico1'));
  chart.draw(data, options);
}

//Mapa
google.setOnLoadCallback(drawMarkersMap);

      function drawMarkersMap() {
      var data = google.visualization.arrayToDataTable([
        ['City',   'Population', 'Area'],
        ['Rome',      2761477,    1285.31],
        ['Milan',     1324110,    181.76],
        ['Naples',    959574,     117.27],
        ['Turin',     907563,     130.17],
        ['Palermo',   655875,     158.9],
        ['Genoa',     607906,     243.60],
        ['Bologna',   380181,     140.7],
        ['Florence',  371282,     102.41],
        ['Fiumicino', 67370,      213.44],
        ['Anzio',     52192,      43.43],
        ['Sao Paulo',     150000,      43.43],
        ['Ciampino',  38262,      11]
      ]);

      var options = {
        region: 'BR',
        displayMode: 'markers',
        colorAxis: {colors: ['green', 'blue']}
      };

      var chart = new google.visualization.GeoChart(document.getElementById('grafico2'));
      chart.draw(data, options);
    };

//Barras
google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Fonte', 'like face', 'like posts face', 'like twitter', 'like twitter posts'],
          ['2014', 1000, 400, 200, 2999],
          ['2015', 1170, 460, 250, 1222],

        ]);

        var options = {
          chart: {
            title: 'Company Performance',
            subtitle: 'Sales, Expenses, and Profit: 2014-2017',
          },
          bars: 'horizontal', // Required for Material Bar Charts.
          hAxis: {format: 'decimal'},
          height: 400,
          colors: ['#1b9e77', '#d95f02', '#7570b3', '#7570b4']
        };

        var chart = new google.charts.Bar(document.getElementById('grafico3'));

        chart.draw(data, google.charts.Bar.convertOptions(options));

      }
</script>
<c:import url="includes/footer.jsp" />
    
