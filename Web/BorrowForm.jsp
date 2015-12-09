<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="items" type="java.sql.ResultSet" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.css" type="text/css"
	media="screen" />
<style>
 body {
  font-family: Courier New;
  margin: 20px;
  background-image: url('lab.jpg'); 
	/*background-image: url('0001.png');*/
  color: #fff;
  }

label {
	padding-top: 8px;
	display: block;
	text-align: left;
}

input {
	margin-bottom: 15px;
}

.box {
	padding: 30px;
	background-color: rgba(0, 0, 0, 0.8);
	margin-top: 5%;
}

.checkbox {
	overflow-y: scroll;
	position:relative;
	height: 300px;
<<<<<<< HEAD
=======
}
.btn {
 background:    #fafafa;
border:        2px solid #73081a;
border-radius: 5px;
box-shadow:    1px 1px 0 0 #444;
color:         #000;
display:       inline-block;
padding:       8px 20px;
font-size:    20px;
text-align:    center;
text-shadow:   none;
>>>>>>> origin/master
}
</style>
<title>Borrow Form</title>
</head>
<body bgcolor="#DBFFFF">
	<div class="box">
		<center>
			<script type="text/javascript">
				document.write('<p>Current time is: <span id="date-time">',
						new Date().toLocaleString(), '<\/span>.<\/p>')
				if (document.getElementById)
					onload = function() {
						setInterval(
								"document.getElementById ('date-time').firstChild.data = new Date().toLocaleString()",
								50)
					}
			</script>
			<hr>
			<h2 class="text-center">ChemEng Inventory System</h2>
			<hr>
			<div class="row">
				<div class="col-md-7"
					style="border-right: 2px solid #555; padding: 20px;">
					<form action="borrowformcontinuation.html" method="post">
						<div class="row">
							<div class="col-md-5">
								<label>Enter Student's Last Name:</label>
							</div>
							<div class="col-md-6">
								<input type="text" name="lastName" required="required"
									class="form-control">
							</div>
						</div>
						<div class="row">
							<div class="col-md-5">
								<label>Enter Student's First Name: </label>
							</div>
							<div class="col-md-6">
								<input type="text" name="firstName" required="required"
									class="form-control">
							</div>
						</div>
						<div class="row">
							<div class="col-md-5">
								<label>Enter Student's Section: </label>
							</div>
							<div class="col-md-6">
								<input type="text" name="section" required="required"
									class="form-control">
							</div>
						</div>
						<hr>
						<div class="box">
							<h2>Rules and Regulations in Borrowing Laboratory Equipments</h2>
							<div align="left">
							<ul style="list-style-type:square">
								<li>Students who would like to borrow equipment must fill up first the borrow form.</li>
								<li> Upon receiving the item, handle with care and as much as possible do not cause any damage/defect.</li>
								<li> Borrowers are advised to check for any defect before returning the equipment.
								 If ever there is a damage, it should be reported immediately to the instructor</li>
							  	<li>All equipment/materials must be returned within or after the laboratory hour of your class.</li>
<<<<<<< HEAD
							  	<li> All users must observe and follow the Rules and Regulations in borrowing equipments in Chemical Engineering Laboratory</li>
=======
							  	<li> All users must observe and follow the Rules and Regulations in borrowing equipment from the
							  	 Chemical Engineering Laboratory</li>
>>>>>>> origin/master
							</ul>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-5">							
						<div class="col-md-12 text-center">
							<label>Items to Borrow:</label>
						</div>
						<div class="col-md-offset-2 col-md-8">
							<!-- dito ineenumerate ang mga available items -->
							<%
								if (items.next()) {
							%>
							<div class="checkbox">
								<label> <%
	 	if (items.getInt("totalnum") != 0) {
	 %>
									
										<input type="checkbox" name="borrowed"
											value=<%=items.getString("id")%>><%=items.getString("equipments")%></label>
								
								<%
									}
								%>
								<%
									while (items.next()) {
								%>
								<%
									if (items.getInt("totalnum") != 0) {
								%>
								<label>
									
										<input type="checkbox" name="borrowed"
											value=<%=items.getString("id")%>><%=items.getString("equipments")%>
									
								</label>
								

								<%
									}
										}
									} else {
								%>
								YOU HAVE NO ITEMS IN YOUR INVENTORY
								<%
									}
								%>
							</div>
<<<<<<< HEAD
							<input type="submit" value="Borrow" class="btn btn-primary">
						</div>
						
=======
							<input type="submit" value="Borrow" class="btn">
						</div>
					</form>
>>>>>>> origin/master
					</div>
				</div>
					<!--  
						    <div class="checkbox">
						      <label><input type="checkbox" value="">Option 2</label>
						    </div>
						    <div class="checkbox">
						      <label><input type="checkbox" value="">Option 3</label>
						    </div>
						  </form>
							<br><br>
							
							<p>Select Items you OWN</p>
							<form>
							<input type="checkbox" name="owns" value="Bike">Bike<br/>
							<input type="checkbox" name="owns" value="Car">car<br/>
							<input type="checkbox" name="owns" value="Refridgerator">Refrigerator<br/>
							<input type="checkbox" name="owns" value="Mobile">Mobile<br/>
							<input type="checkbox" name="owns" value="Tablet">Tablet<br/>
							<input type="checkbox" name="owns" value="Computer">Computer<br/>
							<input type="button" value="Get Values" onclick="getMultipleCheckbox(this.form.owns);"/>
							</form>
						<script type="text/javascript">
							function getMultipleCheckbox(inputdata) {
							    var selectedItems = [];
							    var count = 0;
							    for(var i=0;i<inputdata.length;i++) {
							        if(inputdata[i].checked) {
							            selectedItems[count] = inputdata[i].value;
							            count++;
							        }
							    }
							    for(var loop=0; loop< selectedItems.length; loop++) {
							        console.log(selectedItems[loop]);
							    }
							    return selectedItems;
							}
	</script> -->


					<!-- 
						<div class="row">
							<div class="col-md-5"><label>Enter Quantity of the item to be borrowed: </label></div>
							<div class="col-md-6"><input type="text" name="item_num" class="form-control"></div>
						</div>
						<br><br>
						<div class="col-md-12">
								<input type="submit" value="Borrow" class="btn btn-primary">
						</div>
					</div> -->

					<!--<div class="col-md-5">
					<h4>
						<strong>List of Laboratory Equipments Available</strong>
					</h4>
					<p>Option 1</p>
					<p>Option 2</p>
					<p>Option 3</p>
					<p>Option 4</p>
					<p>Option 5</p>
					<p>Option 6</p>
				</div> -->

<<<<<<< HEAD
				</div>
			</div>
=======

>>>>>>> origin/master
			<center>
				<form action="index.jsp">
					<div class="row">
						<div class="col-md-12">
							<input type="submit" value="BACK TO HOME" class="btn">
											</div>
						</div>
					</div>
				</form>
			</center>
</body>
</html>