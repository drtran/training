<html ng-app="store">
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.min.js">
</script>
<script type="text/javascript" src="app.js"></script>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>

<body ng-controller="StoreController as storeCtrl">
  <form name="todoForm" ng-controller="TodoController as todoCtrl"
        ng-submit="storeCtrl.addTodo(todoCtrl.todoItem)" novalidate>
  <p>Todo list:{{storeCtrl.result}}</p>
  <ul>
    <li ng-repeat="todo in storeCtrl.todoList">
      <em>todo: {{todo}}</em>
    </li>
  </ul>
    <input name="todoEdit" ng-model="todoCtrl.todoItem"/>
    <input name="hidden" type="hidden" ng-model="storeCtrl.result"/>
    <input type="submit" value="Submit"/>
  </form>

</body>
</html>
