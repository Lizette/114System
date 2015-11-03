<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.css" type="text/css" media="screen" />
<style>
 body {
  font-family: 'Arial', sans-serif;
  margin: 20px;
  background-image: url('lab.jpg');
  color: #fff;
  }
  
  label {
  	padding-top: 8px;
  }
  
  input {
  	margin-bottom: 15px;
  }
  
  .box {
  	padding: 30px;
  	background-color: rgba(0,0,0,0.8);
  	margin-top: 5%;
  }
</style>
<title>Home</title>
</head>
<body bgcolor="#DBFFFF">
	<div class="box">
	<hr>
	<h2 class="text-center">ChemEng Inventory System</h2>
	<hr>
	<div class="row">hi
		<div class="col-md-7" style="border-right: 2px solid #555; padding: 20px;">
			<form action="process.html" method="post">
				<div class="row">
					<div class="col-md-5"><label>Enter Student's Last Name:</label></div>
					<div class="col-md-6"><input type="text" name="lastName" class="form-control"></div>
				</div>
				<div class="row">
					<div class="col-md-5"><label>Enter Student's First Name: </label></div>
					<div class="col-md-6"><input type="text" name="firstName" class="form-control"></div>
				</div>
				<div class="row">
					<div class="col-md-5"><label>Enter Student's Section: </label></div>
					<div class="col-md-6"><input type="text" name=section class="form-control"></div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<label>Items to Borrow:</label>
					</div>
					<div class="col-md-6">
					<form role="form">
					    <div class="checkbox">
					      <label><input type="checkbox" value="">Option 1</label>
					    </div>
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
</script>
						
					</div>
					
					<div class="row">
						<div class="col-md-5"><label>Enter Quantity of the item to be borrowed: </label></div>
						<div class="col-md-6"><input type="text" name="item_num" class="form-control"></div>
					</div>
					<br><br>
					<div class="col-md-12">
							<input type="submit" value="Borrow" class="btn btn-primary">
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-5">
			<h4><strong>List of Laboratory Equipments Available</strong></h4>
			<p>Option 1</p>
			<p>Option 2</p>
			<p>Option 3</p>
			<p>Option 4</p>
			<p>Option 5</p>
			<p>Option 6</p>
		</div>
	</div>
	
	</div>

</body>
</html>