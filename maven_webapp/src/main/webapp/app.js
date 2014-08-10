(function(){
	var app = angular.module('store', []);
	var listOfToDos = [""];
	
	app.controller ('StoreController', ['$log', '$http', function($scope, $log, $http) {
		this.todoList = listOfToDos; 
		this.result = $scope.result;
		
		this.addTodo = function(todo) {
			$log.log('calling service ...');
			$http.get('rest/helloworld/youhoo').success(function(data) {
				$scope.result = data.msg;
				$log.log('service called ...' + $scope.result);
			});
			$log.log('addTodo is called. --> ' + todo);
		};

	}]);
	
	app.controller ('GreetingController', function() {
		this.email = "ktran@bemach.com";
	});
	
	app.controller('TodoController', ['$log', '$http', function($log, $http) {
		this.todoList = listOfToDos;
		this.result = "default";
		
		this.addTodo = function(todo) {
			this.todoList.push(todo);
			
			$log.log('calling service ...');
			$http.get('rest/helloworld/youhoo').success(function(data) {
				this.result = data.msg;
				$log.log('service called ...' + this.result);
			});
			$log.log('addTodo is called. --> ' + todo);
		};
	}]);
	
	app.service('SharedData', function() {
		var property = 'default';

        return {
            getProperty: function () {
                return property;
            },
            setProperty: function(value) {
                property = value;
            }
        };
	});
}) ();
