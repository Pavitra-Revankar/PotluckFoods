<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Checkout</title>
<style>
	<%@include file="checkout.css"%>
</style>
</head>
<script>
	function phoneValidation(){
		var phone = documnent.getElementById("phone").value;
		var pattern = /^[6-9]\d{9}$/;
		
		if(!pattern.test(phone)){
			alert("Invalid Phone Number");
			return false;
		}
		return true;
		
	}
	
</script>
<body>
<img src="images/bg4.jpg"></img>
<div class="address">

<%
	String address =(String) request.getAttribute("address");
	
	if(address==null){
	
%>
		<form action="CallOrderConfirmServlet" onsubmit="return phoneValidation()">
		
			<h2>Enter Address Details</h2>
			<fieldset>
				<legend>Receiver's Name</legend>
				<input type="text" name="name" value="<%=(String)session.getAttribute("username") %>" required></input>
			</fieldset>	<br />
			
			<fieldset>
				<legend><label for="phone">Contact Number</label></legend>
				<!--  <input type="phone" name="phone" pattern= "[6-9]{1}[0-9]{9} "oninput="if(this.value.length>6) this.value = this.value.slice(0,10)"required></input>-->
				
				<input type="phone" name="phone" id="phone"  required></input>
			</fieldset><br />
			
			<hr style="border-top:dotted 1px" / ><br />
			
			<input type="text" name="flat" placeholder="Flat/ House no / Floor / Building" class="input1"  required></input><br /><br />
			
			<fieldset>
				<legend>Area / Sector / Locality</legend>
				<input type="text" name="area"  class="input"  required></input>
			</fieldset><br />
			
			<input type="text" name="landmark" placeholder="NearBy landmark(optional)" class="input1"></input><br/>
			
			<fieldset>
				<legend>City</legend>
				<input type="text" name="city" placeholder="Shivamogga" class="input"  required></input><br /><br />
				<input type="text" name="pincode" placeholder="577201" class="input" required maxlength="6" oninput="if(this.value.length>6) this.value = this.value.slice(0,6)" ></input><br /><br />
				<input type="text" name="state" placeholder="Karnataka" class="input" required ></input>
			</fieldset><br />
		
<%
	}
	else if(address!=null){
		String[] addr = address.split(",");
		request.setAttribute("flat", addr[0]);
		request.setAttribute("area", addr[1]);
		request.setAttribute("city", addr[2]);
		request.setAttribute("pincode", addr[3]);
		request.setAttribute("state", addr[4]);
		
		
%>

<form action="CallOrderConfirmServlet">

		
			<h2>Enter Address Details</h2>
			<fieldset>
				<legend>Receiver's Name</legend>
				<input type="text" name="name" value="<%=(String)session.getAttribute("username")%>" required></input>
			</fieldset>	<br />
			
			<fieldset>
				<legend>Contact Number</legend>
				<input type="number" name="phone" required></input>
			</fieldset><br />
			
			<hr style="border-top:dotted 1px" / ><br />
			
			<input type="text" name="flat" placeholder="Flat/ House no / Floor / Building" class="input1" value = "<%= (String) request.getAttribute("flat")%>" required></input><br /><br />
			
			<fieldset>
				<legend>Area / Sector / Locality</legend>
				<input type="text" name="area"  class="input"  value = "<%=(String)request.getAttribute("area")%>" required></input>
			</fieldset><br />
			
			<input type="text" name="landmark" placeholder="NearBy landmark(optional)" class="input1"></input><br/>
			
			<fieldset>
				<legend>City</legend>
				<input type="text" name="city" placeholder="Shivamogga" class="input" value="<%=request.getAttribute("city")%>" required></input><br /><br />
				<input type="text" name="pincode" placeholder="577201" class="input" required maxlength="6" oninput="if(this.value.length>6) this.value = this.value.slice(0,6)" value="<%=(String)request.getAttribute("pincode")%>"></input><br /><br />
				<input type="text" name="state" placeholder="Karnataka" class="input" required value="<%=(String)request.getAttribute("state")%>"></input>
			</fieldset><br />
		



<%} %>
	
	<h2>Payment</h2>
		<fieldset>
			<legend>Payment mode</legend>
			<input type="radio" name = "payment" id="cod" value="COD" checked> <label for="cod" >Cash On Deliver</label><br>
			<input type="radio" name = "payment" id="upi" value="UPI"> <label for="upi">UPI</label><br>
			<input type="radio" name = "payment" id="card" value="Debit/Credit"> <label for="card">Debit/Credit Card</label>
		</fieldset>
	<br />
	<input type="submit" class = "confirm" value="Confirm" style="width:300px; height:40px; font-size:20px; font-weight:bold;background-color:#488AC7">
		
	</form>	
</div>


</body>
</html>