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
                </ol>
            </div>
        </div>        
        <!-- /.row -->
        <form action="#" method="post" role="form" class="horizontal-form">
	        <div class="row">
	        	<div class="col-lg-12">
	        		<h2 class="page-header">
	                    Quando?
	                </h2>
	        	</div>
	        </div>
	        <div class="row">
	        	<div class="col-lg-6">
	        		<div class="input-group input-daterange">
        				<span class="input-group-addon">De</span>
					    <input type="text" class="form-control has-datepicker" value="2012-04-05">
					    <span class="input-group-addon">Até</span>
					    <input type="text" class="form-control has-datepicker" value="2012-04-19">
					</div>
	        	</div>	        	
	        </div>
	        <div class="row">
	        	<div class="col-lg-12">
	        		<h2 class="page-header">
	                    Quem?
	                </h2>
	        	</div>
	        </div>
	        <div class="row">
	        	<div class="col-lg-6">
	        		<div class="form-group">
					    <label for="facebookName">Facebook</label>
					    <input type="text" class="form-control" id="facebookName" name="facebookName" placeholder="Nome da página">
				  	</div>
	        	</div>
	        	<div class="col-lg-6">
	        		<div class="form-group">
					    <label for="twitterName">Twitter</label>
					    <input type="text" class="form-control" id="twitterName" name="twitterName" placeholder="Nome da página">
				  	</div>
	        	</div>
	        </div>
	        <div class="row">
	        	<div class="col-lg-12">
	        		<button class="btn btn-success" type="submit">Avançar</button>
	        	</div>
	        </div>
		</form>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- /#page-wrapper -->
<link rel="stylesheet" href="assets/css/jquery-ui.min.css"/>
<script src="assets/js/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".has-datepicker").datepicker({
		    dateFormat: 'dd/mm/yy',
		    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
		    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
		    nextText: 'Próximo',
		    prevText: 'Anterior'
		});
		$('.has-datepicker').datepicker();
	});
</script>
<!--

//-->
</script>
        
<c:import url="includes/footer.jsp" />
    
