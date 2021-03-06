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
                        <i class="fa fa-fw fa-bar-chart-o"></i>  <a href="index.jsp">Social M�dia</a>
                    </li>
                    <li class="active">
                         Par�metros
                    </li>
                </ol>
            </div>
        </div>        
        <!-- /.row -->
        <form action="Controller" method="post" role="form" id="form-step2" class="horizontal-form">
        <input type="hidden" name="logica" value="Step2"/>
	        <div class="row">
	        	<div class="col-lg-12">
		        	<c:if test="${error != null}">
		        		<div class="alert alert-danger" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							  	<span aria-hidden="true">&times;</span>							  	
							</button>	        
							<p><strong>Erro: </strong>${error}</p>		
		        		</div>
	        		</c:if>
	        		
	        		<h2 class="page-header">
	                    Quando?
	                </h2>
	        	</div>
	        </div>
	        <div class="row">
	        	<div class="col-lg-6">
	        		<div class="input-group input-daterange">
        				<span class="input-group-addon">De</span>
					    <input type="text" class="form-control has-datepicker" value="">
					    <span class="input-group-addon">At�</span>
					    <input type="text" class="form-control has-datepicker" value="">
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
	        	<div class="col-lg-4">
	        		<h3>Termo 1</h3>
	        		<div class="form-group">
					    <label for="facebookName1">Facebook</label>
					    <input type="text" class="form-control" id="facebookName1" name="facebookName1" placeholder="Nome da p�gina">
				  	</div>
				  	<div class="form-group">
					    <label for="twitterName1">Twitter</label>
					    <input type="text" class="form-control" id="twitterName1" name="twitterName1" placeholder="Nome da p�gina">
				  	</div>
	        	</div>
	        	<div class="col-lg-4">
	        		<h3>Termo 2</h3>
	        		<div class="form-group">
					    <label for="facebookName2">Facebook</label>
					    <input type="text" class="form-control" id="facebookName2" name="facebookName2" placeholder="Nome da p�gina">
				  	</div>
				  	<div class="form-group">
					    <label for="twitterName2">Twitter</label>
					    <input type="text" class="form-control" id="twitterName2" name="twitterName2" placeholder="Nome da p�gina">
				  	</div>
	        	</div>
	        </div>
	        <hr>
	        <div class="row">
	        	<div class="col-lg-12">
	        		<button class="btn btn-success" type="submit">Avan�ar</button>
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
		$("#form-step2").on('submit', function(){
			$("#loading").show();
		});
		
		$(".has-datepicker").datepicker({
		    dateFormat: 'dd/mm/yy',
		    dayNames: ['Domingo','Segunda','Ter�a','Quarta','Quinta','Sexta','S�bado'],
		    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S�b','Dom'],
		    monthNames: ['Janeiro','Fevereiro','Mar�o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
		    nextText: 'Pr�ximo',
		    prevText: 'Anterior'
		});
		$('.has-datepicker').datepicker();
	});
</script>
        
<c:import url="includes/footer.jsp" />
    
