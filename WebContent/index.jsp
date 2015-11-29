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
        <div class="row">
        	<div class="col-lg-12">
        		<h2 class="page-header">
                    O quê?
                </h2>
        	</div>
        </div>
        <!-- /.row -->
        <form action="#" method="post" role="form" class="horizontal-form">
	        <div class="row">
	        	<div class="col-lg-6">
	        		<h3>Quais sites?</h3>
	        		<div class="checkbox">
					    <label>
					      <input name="facebook" value="1" type="checkbox"><img src="assets/images/icon-facebook.png" width="30" alt="Facebook"/> Facebook
					    </label>
				  	</div>
				  	<div class="checkbox">
					    <label>
					      <input name="instagram" disabled="disabled" type="checkbox"><img src="assets/images/icon-instagram.png" width="30" alt="Instagram"/> Instagram
					    </label>
				  	</div>
				  	<div class="checkbox">
					    <label>
					      <input name="twitter" value="1" type="checkbox"><img src="assets/images/icon-twitter.png" width="30" alt="Twitter"/> Twitter
					    </label>
				  	</div>
				  	<div class="checkbox">
					    <label>
					      <input name="bovespa" disabled="disabled" type="checkbox"><img src="assets/images/icon-bovespa.png" width="30" alt="Bovespa"/> Bovespa
					    </label>
				  	</div>
	        	</div>
	        	<div class="col-lg-6">
	        		<h3>Quais dados?</h3>
	        		
	        		<div class="checkbox">
					    <label>
					      <input name="curtidas" value="1" type="checkbox"> Curtidas
					    </label>
				  	</div>
				  	<div class="checkbox">
					    <label>
					      <input name="compartilhamentos" value="1" type="checkbox"> Compartilhamentos
					    </label>
				  	</div>
				  	<div class="checkbox">
					    <label>
					      <input name="seguidores" value="1" type="checkbox"> Seguidores
					    </label>
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
        
<c:import url="includes/footer.jsp" />
    
