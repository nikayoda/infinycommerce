<div class="subheader show-for-large-up">
	<div class="row full-width-row">
		<div class="small-12 medium-6 columns">
			<p><span style="font-size: large;"><a href="https://infinycommerce.ge/"><span style="color: #ffffff; font-size: 15px;">ჩემი ანგარიში /</span></a> <a href="https://infinycommerce.ge/my-account/"><span style="color: #ffffff; font-size: 15px;">ááááá áá¨á /</span></a><a href="https://infinycommerce.ge/order/"><span style="color: #ffffff; font-size: 15px; "> áááááá</span></a></span></p>
		</div>
		<div class="small-12 medium-6 columns text-right">
			<nav class="subheader-menu">
				<p style="text-align: center;"></p><p> </p><p><span style="font-size: 15px; color: #ffffff;">032 2 044 144 / +995 577 103 124</span></p> &nbsp; <p></p> <a href="https://www.facebook.com/infinycommerceofficial/"><img src="https://infinycommerce.ge/wp-content/uploads/2019/01/facebook.png" width="30" height="30"></a>&nbsp; <a href="https://www.instagram.com/infinycommerceofficial/"><img src="https://infinycommerce.ge/wp-content/uploads/2019/01/instagram.png" width="30" height="30"> &nbsp; </a><a href="https://www.youtube.com/channel/UCjbUrp-2xtcqkJvXGrvijaA/videos"><img src="https://infinycommerce.ge/wp-content/uploads/2019/01/youtube-1.png" width="30" height="30"> &nbsp; &nbsp; </a><a href="https://infinycommerce.ge/my-account/#"><span style="color: #ffffff; " font-size:="" 10px;"="">á¨áá¡ááá</span></a> <p></p>
			</nav>
		</div>
	</div>
</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resources/images/logo-infinycommerce.png" alt="" class="logo"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/about">á©áááá¡ á¨áá¡áá®áá</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/show/all/products">View
						products</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/contact">Contact</a></li>

				<security:authorize
					access="hasAuthority('MANAGER') and isAuthenticated()">

					<li class="nav-item"><a class="nav-link" style="text-shadow:1px 1px 1px red;"
						href="${pageContext.request.contextPath}/manage/products">! Product
							Management !</a></li>

				</security:authorize>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="!isAuthenticated()">


					<li><a href="${pageContext.request.contextPath }/signup"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="${pageContext.request.contextPath }/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>


				</security:authorize>

				<security:authorize access="isAuthenticated()">


					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><span class="glyphicon glyphicon-user"></span>
							${accountModel.getFirstName() } </a>
						<ul class="dropdown-menu">
						
						<security:authorize access="hasAuthority('CUSTOMER')">
							<li><a href="${pageContext.request.contextPath }/cart/show"><span
									class="glyphicon glyphicon-shopping-cart"></span>
									<span class="badge">${accountModel.getCart().getCartLines() }</span> <span style="position: absolute; right:1em;">&#36;${accountModel.getCart().getTotal()}</span>
									</a></li>
							<li role="separator" class="divider"></li>


<li><sf:form method="post"
									action="${pageContext.request.contextPath }/profile/show">
									<button type="submit" class="btn btn-default"
										style="background-color: transparent; color: black; border: none;">
										<span class="glyphicon glyphicon-user"></span> Your profile
									</button>
								</sf:form></li>
								</security:authorize>
							<li><sf:form method="post"
									action="${pageContext.request.contextPath }/logout">
									<button type="submit" class="btn btn-default"
										style="background-color: transparent; color: black; border: none;">
										<span class="glyphicon glyphicon-log-out"></span> Logout
									</button>
								</sf:form></li>



						</ul></li>



					<!-- 	<li class="dropdown">
				<a href="javascript:void(0)"
					class="btn btn-default dropdown-toggle"
					id="drodownMenu1"
					data-toggle="dropdown">
					
					Hello Michal!
					<span class="caret"></span>
					</a>
					
					<ul class="dropdown-menu">
					<li>
					<a href="javascript:void(0)">
					<span class="glyphicon glyphicon-shopping-cat"></span>
					</a>
					</li>
					</ul>
				</li> -->

				</security:authorize>
			</ul>
		</div>
	</div>
</nav>