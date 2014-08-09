(function(){
	var app = angular.module('store', []);
	var listOfToDos = [""];
	
	app.controller ('StoreController', function() {
		this.todoList = listOfToDos; 
	});
	
	app.controller ('GreetingController', function() {
		this.email = "ktran@bemach.com";
	});
	
	app.controller('TodoController', ['$log', '$http', function($log, $http) {
		this.todoList = listOfToDos;
		
		
		this.addTodo = function(todo) {
			this.todoList.push(todo);
			result = "";
			$log.log('calling service ...');
			$http.get('rest/hello/youhoo').success(function(data) {
				this.result = data;
				$log.log('service called ...' + this.result);
			});
			$log.log('addTodo is called. --> ' + todo);
		};
	}]);
}) ();
