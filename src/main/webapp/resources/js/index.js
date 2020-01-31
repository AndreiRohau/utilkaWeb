

function getAllCars() {
	let thisForm = $("#getAllCarsForm")[0];
	let ajaxReq = $.ajax({
		url: thisForm.action,
		cache: false,
		contentType: false,
		processData: false,
		method: 'GET'
	});

	ajaxReq.done(function(data){
		$("#carsContainer").empty();
		if (data.length === 0) {
			alert("No content");
		} else {
			displayCars(data);
		}
	});

	ajaxReq.fail(function(data) {
		alert(data.responseText);
	});
}

function displayCars(data) {
	let tableCars = $("<table id='tableCars' name='tableCars' class='table table-bordered'></table>");
	let tHead = $("<thead><tr><td>ID</td><td>NAME</td><td>PRICE</td><td>EDIT</td><td>DELETE</td></tr></thead>");
	let tBody = $("<tbody></tbody>");
	tableCars.append(tHead);
	tableCars.append(tBody);

	for(let i in data){
		let carObj = data[i];
		let id = carObj['id'];
		let name = carObj['name'];
		let price = carObj['price'];
		let formEditId = "car_" + id;
		let formDeleteId = "car_delete_" + id;
		let editBtn = $("<input type=\"button\" class=\"btn btn-default\" name=\"editBtn\" value=\"update\" onclick=\"editCar(this)\" form=\"" + formEditId + "\"/>");
		let deleteBtn = $("<input type=\"button\" class=\"btn btn-default\" name=\"deleteBtn\" value=\"delete\" onclick=\"deleteCar(this, " + id + ")\" form=\"" + formDeleteId + "\"/>");

		let tRow = $("<tr></tr>");
		tBody.append(tRow);

		let formElementEdit = $("<form id=" + formEditId + " name=\"edit_" + formEditId + "\" action=\"car/edit/\" method=\"POST\"></form>");
		let tdId = $("<td></td>").append(formElementEdit.append("<input hidden type=\"number\" name=\"id\" form=\"" + formEditId + "\" value=\"" + id + "\"/>" + id));

		let tdName = $("<td></td>").append("<input type=\"text\" name=\"name\" form=\"" + formEditId + "\" value=\"" + name + "\"/>");
		let tdPrice = $("<td></td>").append("<input type=\"number\" class=\"price_input\" name=\"price\" form=\"" + formEditId + "\" value=\"" + price + "\"/>");
		let tdEditBtn = $("<td></td>").append(editBtn);

		let formElementDelete = $("<form id=" + formDeleteId + " name=\"delete_" + formDeleteId + "\" action=\"car/delete/\" method=\"GET\"></form>");
		let tdDeleteBtn = $("<td></td>").append(formElementDelete.append(deleteBtn));

		tRow.append(tdId);
		tRow.append(tdName);
		tRow.append(tdPrice);
		tRow.append(tdEditBtn);
		tRow.append(tdDeleteBtn);
	}
	$("#carsContainer").append(tableCars);
	countTotalPrice();
}

function editCar(element) {
	let thisForm = element.form;
	let ajaxReq = $.ajax({
		url: thisForm.action,
		data: new FormData(thisForm),
		cache: false,
		contentType: false,
		processData: false,
		method: 'POST'
	});

	ajaxReq.done(function(){
		console.log(" been updated.");
	});

	ajaxReq.fail(function(data) {
		alert(data.responseText);
	});
}
function deleteCar(element, id) {
	let thisForm = element.form;
	let ajaxReq = $.ajax({
		url: thisForm.action + id,
		data: new FormData(thisForm),
		cache: false,
		contentType: false,
		processData: false,
		method: 'GET'
	});

	ajaxReq.done(function(){
		console.log(" been deleted.");
		getAllCars();
	});

	ajaxReq.fail(function(data) {
		alert(data.responseText);
	});

}
function addCar() {
	let thisForm = $("#addCarForm")[0];
	let ajaxReq = $.ajax({
		url: thisForm.action,
		data: new FormData(thisForm),
		cache: false,
		contentType: false,
		processData: false,
		method: 'POST'
	});

	ajaxReq.done(function(){
		console.log(" been saved.");
		if ($.trim( $('#carsContainer').html() ).length) {
			getAllCars();
		}
	});

	ajaxReq.fail(function(data) {
		alert(data.responseText);
	});

	thisForm.reset();
}

function countTotalPrice() {
	let sum = 0;
	$(".price_input").each(function()
	{
		if(!isNaN(this.value) && this.value.length !== 0)
		{
			sum += parseFloat(this.value);
		}
	});
	let totalPriceDiv = $("#totalPrice");
	totalPriceDiv.empty();
	totalPriceDiv.append($("<h2></h2>").html(sum));
}