angular.module('greetingApp', [])
	.controller('main', function($scope, $http) {
	  
		$scope.greeting = '';
	  
		// IIFE example
		(function() {
			$http.get('/jersey/greetingEndpoint').success(function(data) {
				$scope.greeting = data;
			})
		}())
	  
	 $scope.changeMessage = function() {
			var params = {
					method: 'POST',
					url: '/jersey/greetingEndpoint',
					data: newMessage.value
			};

			$http(params).then(
				function(response) {
					$scope.greeting = response.data;
					console.log('Message changed successfully')
				}, function(response) {
					console.log('Failed updating message')
				}
			);
		}
	 
});
