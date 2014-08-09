<html ng-app="store">
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.min.js">
</script>
<script type="text/javascript" src="app.js"></script>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>

<body ng-controller="StoreController as storeCtrl">
  <p>Todo list:</p>
  <ul>
    <li ng-repeat="todo in storeCtrl.todoList">
      <em>todo: {{todo}}</em>
    </li>
  </ul>
  <form name="todoForm" ng-controller="TodoController as todoCtrl"
        ng-submit="todoCtrl.addTodo(todoCtrl.todoItem)" novalidate>
    <input name="todoEdit" ng-model="todoCtrl.todoItem"/>
    <input type="submit" value="Submit"/>
  </form>

</body>
</html>
