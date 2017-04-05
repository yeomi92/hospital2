<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a id="hospital" href="#">Hospital<span
							class="sr-only">(current)</span></a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Algorithm<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a id="series" href="#">Series</a></li>
							<li><a id="array" href="#">Array</a></li>
							<li><a id="matrix" href="#">Matrix</a></li>
							<li><a id="math" href="#">Math</a></li>
							<li><a id="application" href="#">Application</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">OOP<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a id="Encap" href="#">Encapsulation</a></li>
							<li><a id="Inherit" href="#">Inheritance</a></li>
							<li><a id="poly" href="#">Polymorphism</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div id="wrapper">
		<button type="button" class="btn btn-default">click me</button>
	</div>





</body>
<script>
	var app=app||{}; //namespace pattern
	app.context=(function(){})(); //declaration 보다 먼저 실행
	app.component=(function(){
		return{
			body: $('body'),
		    wrapper: $('#wrapper'),
		    div: function(id){
		    	return $(id);
		    },
		    aButton: function(id,type){
		    	return $('<a id="'+id+'" href="#" class="btn '+type+'" role="button">Button</a>');
		    },
		    bButton: function(id,type){
		    	return $('<button id="'+id+'" type="button" class="btn '+type+'">Button</button>');
		    },
		    inputText: function(id){
		    	return $('<input id="'+id+'" type="text" class="form-control" placeholder="example" aria-describedby="basic-addon1">');
		    },
		    divAlert: function(){
		    	return $('<div class="alert alert-danger" role="alert">example</div>');
		    },
		    seriesMenu: function(){
		    	return  $('<ul class="list-group">'
		    			+ '<li id="aSeries" class="list-group-item"><a href="#">등차수열</a></li>'
		    			+ '<li id="swSeries" class="list-group-item"><a href="#">스위치수열</a></li>'
		    			+ '<li id="dSeries" class="list-group-item"><a href="#">계차수열</a></li>'
		    			+ '<li id="factorial" class="list-group-item"><a href="#">팩토리얼수열</a></li>'
		    			+ '<li id="fibonaci" class="list-group-item"><a href="#">피보나치수열</a></li></ul>');
		    },
		    arrayMenu: function(){
		    	return  $('<ul class="list-group">'
		    			+ '<li id="selectSort" class="list-group-item"><a href="#">선택정렬</a></li>'
						+ '<li id="bubbleSort" class="list-group-item"><a href="#">버블정렬</a></li>'
						+ '<li id="insertSort" class="list-group-item"><a href="#">삽입정렬</a></li></ul>');
		    },
		    oopMenu: function(){
		    	return $('<ul class="list-group">'
		    			+ '<li id="selectSort" class="list-group-item"><a href="#">캡슐화</a></li>'
		    			+ '<li id="bubbleSort" class="list-group-item"><a href="#">상속</a></li>'
		    			+ '<li id="insertSort" class="list-group-item"><a href="#">다형성</a></li></ul>');
		    }		
		};
	})();
	app.algorithm=(function(){
		var aSeries=function(inputVal) {
			$('#tableRight').empty();
			var arr=inputVal.split(" ");
			var start=arr[0]*1;
			var limit=arr[1]*1;
			var diff=arr[2]*1;
			console.log('inputVal:'+start+", "+limit+", "+diff);
			var result = 0;
			var resultStr="";
			for (i=start;i<=limit;i+=diff) {
				result += i;
				resultStr+=i+(((i+diff)>limit)?"=":"+");
			}
			return resultStr+result;
		};
		return {
			aSeries: aSeries,
			series: function(){
				$('#series').on('click',function() {
					app.component.wrapper.empty();
					$('#tableLeft').empty();
					$('#tableRight').empty();
					table.appendTo(app.component.wrapper);
					app.component.seriesMenu().appendTo($('#tableLeft'));
					app.component.inputText('inputText').attr('placeholder', 'start limit 공차 입력').appendTo($('#tableRight'));
					app.component.aButton('aButton','btn-primary').html('등차수열의 합').appendTo($('#tableRight')).on('click',function() {
						console.log($('#inputText').val());
						var result=app.algorithm.aSeries($('#inputText').val());
						app.component.divAlert().html('등차수열 결과<br>'+result).appendTo($('#tableRight'));
					});
					$('#aSeries').on('click',function() {
						$('#tableRight').empty();
						app.component.inputText('inputText').attr('placeholder', 'start limit 공차 입력').appendTo($('#tableRight'));
						app.component.aButton('aButton','btn-primary').html('등차수열의 합').appendTo($('#tableRight')).on('click', function() {aSeries($('#inputText').val());});
					});
					$('#swSeries').on('click',function() {
						$('#tableRight').empty();
						app.component.inputText('inputText').attr('placeholder', 'limit').appendTo($('#tableRight'));
						app.component.aButton('aButton','btn-primary').html('스위치수열의 합').appendTo($('#tableRight')).on('click', function() {swSeries($('#inputText').val());});
					});
					$('#dSeries').on('click',function() {
						$('#tableRight').empty();
						app.component.inputText('inputText').attr('placeholder', 'limit').appendTo($('#tableRight'));
						app.component.aButton('aButton','btn-primary').html('계차수열의 합').appendTo($('#tableRight')).on('click', function() {dSeries($('#inputText').val());});
					});
					$('#factorial').on('click',function() {
						$('#tableRight').empty();
						app.component.inputText('inputText').attr('placeholder', 'limit').appendTo($('#tableRight'));
						app.component.aButton('aButton','btn-primary').html('팩토리얼수열의 합').appendTo($('#tableRight')).on('click',function() {factorial($('#inputText').val());});
					});
					$('#fibonaci').on('click',function() {
						$('#tableRight').empty();
						app.component.inputText('inputText').attr('placeholder', 'limit').appendTo($('#tableRight'));
						app.component.aButton('aButton','btn-primary').html('피보나치수열의 합').appendTo($('#tableRight')).on('click',function() {fibonaci($('#inputText').val());});
					});
				});
			},
			arr: function(){
				$('#array').on('click',function() {
					app.component.wrapper.empty();
					var tableLeft=$('#tableLeft');
					var tableRight=$('#tableRight');				
					$('#tableLeft').empty();
					$('#tableRight').empty();
					table.appendTo(app.component.wrapper);
					app.component.arrayMenu().appendTo(tableLeft);
					app.component.inputText('inputText').attr('placeholder', '10개 숫자').appendTo(tableRight);
					app.component.inputText('inputText2').attr('placeholder', '회전수').appendTo(tableRight);
					app.component.aButton('aButton','btn-primary').html('선택정렬').appendTo(tableRight).on('click',function() {selectSort(inputText.val(), inputText2.val());});
					$('#selectSort').on('click',function() {
						tableRight.empty();
						app.component.inputText('inputText').attr('placeholder', '10개의 숫자값을 입력하세요.').appendTo(tableRight);
						app.component.inputText('inputText2').attr('placeholder', '회전수').appendTo(tableRight);
						app.component.aButton('aButton','btn-primary').html('선택정렬').appendTo(tableRight).on('click',function() {selectSort(inputText.val(), inputText2.val());});
					});
					$('#bubbleSort').on('click',function() {
						tableRight.empty();
						app.component.inputText('inputText').attr('placeholder', '10개의 숫자값을 입력하세요.').appendTo(tableRight);
						app.component.inputText('inputText2').attr('placeholder', '회전수').appendTo(tableRight);
						app.component.aButton('aButton','btn-primary').html('버블정렬').appendTo(tableRight).on('click',function() {bubbleSort(inputText.val(), inputText2.val());});
					});
					$('#insertSort').on('click',function() {
						tableRight.empty();
						app.component.inputText('inputText').attr('placeholder', '10개의 숫자값을 입력하세요.').appendTo(tableRight);
						app.component.aButton('aButton','btn-primary').html('삽입정렬').appendTo(tableRight).on('click', function() {inserSort(inputText.val());});
					});
				});
			},
			matrix: function(){
				$('#matrix').on('click', function() {
					app.component.wrapper.empty();
					app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(wrapper);
					app.component.aButton('aButton','btn-primary').html('매트릭스').appendTo(wrapper).on('click', function() {
						aSeries(inputText.val());
					});
				});
			},
			math: function(){
				$('#math').on('click', function() {
					app.component.wrapper.empty();
					app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(wrapper);
					app.component.aButton('aButton','btn-primary').html('math').appendTo(wrapper).on('click', function() {
						aSeries(inputText.val());
					});
				});
			},
			appl: function(){
				$('#application').on('click', function() {
					app.component.wrapper.empty();
					app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(wrapper);
					app.component.aButton('aButton','btn-primary').html('응용').appendTo(wrapper).on('click', function() {
						aSeries(inputText.val());
					});
				});
			}
		};
	})();
	app.oop=(function(){
		return {
			encap: function(){
				$('#Encap').on('click',function(){
					app.component.wrapper.empty();
					$('#tableLeft').empty();
					$('#tableRight').empty();
					table.appendTo(app.component.wrapper);
					app.component.oopMenu().appendTo($('#tableLeft'));
					app.component.inputText('inputText1').attr('placeholder','이름').appendTo($('#tableRight'));
					app.component.inputText('inputText2').attr('placeholder','나이').appendTo($('#tableRight'));
					app.component.inputText('inputText3').attr('placeholder','성별').appendTo($('#tableRight'));
					app.component.inputText('inputText4').attr('placeholder','직업').appendTo($('#tableRight'));
					app.component.aButton('aButton','btn-primary').html('완료').appendTo($('#tableRight')).on('click',function(){
						app.person.setName($('#inputText1').val());
						app.person.setAge($('#inputText2').val());
						app.person.setGen($('#inputText3').val());
						app.person.setJob($('#inputText4').val());
						var spec=app.person.toString();
						$('#tableRight').empty();
						app.component.divAlert().html('정보<br>'+spec).appendTo($('#tableRight'));
						
					});
				});
			},
			inherit: function(){},
			poly: function(){}
		};
	})();
	var table =  $('<div style="width:100%"><table style="margin: 0 auto; width:500px; height:300px; border-collapse: collapse; border: 1px solid black;"><tr><td id="tableLeft" style="width:50%; border: 1px solid black;"></td><td id="tableRight"></td></tr></table></div>');
	
	app.component.wrapper.empty();
	app.component.inputText('inputText').attr('placeholder', 'input user name').appendTo(app.component.wrapper);
	app.component.aButton('aButton','btn-primary').html('click').appendTo(app.component.wrapper).on('click', function() {
		alert('test');
		var name = $('#inputText').val();
		app.component.wrapper.empty();
		app.component.divAlert.html('Hello ' + name + '!!').appendTo(app.component.wrapper);
	});
	app.algorithm.series();
	app.oop.encap();

	

	

	

	

	
	
	

	/*
	알고리즘 클래스
	*/
	function aSeries(inputVal) {
		$('#tableRight').empty();
		var arr=inputVal.split(" ");
		var start=arr[0]*1;
		var limit=arr[1]*1;
		var diff=arr[2]*1;
		console.log('inputVal:'+start+", "+limit+", "+diff);
		var result = 0;
		var resultStr="";
		for (i=start;i<=limit;i+=diff) {
			result += i;
			resultStr+=i+(((i+diff)>limit)?"=":"+");
		}
		divAlert.html('등차수열 결과<br>'+resultStr+result).appendTo($('#tableRight'));
	}
	function swSeries(limit) {
		$('#tableRight').empty();
		var result = 0;
		var resultStr = "";
		var sw = 1;
		for (i = 1; i <= limit; i++) {
			result += (sw * i);
			sw *= -1;
		}
		divAlert.html('스위치수열 결과: ' + result).appendTo($('#tableRight'));
	}
	function dSeries(limit) {
		$('#tableRight').empty();
		var temp = 1;
		var result = 0;
		for (i = 0; i <= limit; i++) {
			temp += i;
			result += temp;
		}
		divAlert.html('계차수열 결과: ' + result).appendTo($('#tableRight'));
	}
	function factorial(limit) {
		$('#tableRight').empty();
		var result = 0;
		var str = "";
		for (i = 1; i <= limit; i++) {
			var temp = 1;
			for (k = 1; k <= i; k++) {
				temp *= k;
			}
			result += temp;
		}
		divAlert.html('팩토리얼수열 결과: ' + result).appendTo($('#tableRight'));
	}
	function fibonaci(limit) {
		$('#tableRight').empty();
		var a = 1;
		var b = 1;
		var c = 0;
		var result = 2;
		for (i = 1; i <= limit - 2; i++) {
			c = a + b;
			result += c;
			a = b;
			b = c;
		}
		divAlert.html('피보나치수열 결과: ' + result).appendTo($('#tableRight'));
	}
	function selectSort(limit, n) {
		$('#tableRight').empty();
		var data = [];
		var temp = 0;
		var result = "";
		for (i = 0; i <= 9; i++) {
			data[i] = limit.split(" ")[i] * 1;
		}
		for (i = 0; i < n; i++) {
			for (j = i + 1; j <= 9; j++) {
				if (data[i] > data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		for (i = 0; i <= 9; i++) {
			result += data[i] + " ";
		}
		divAlert.html('선택정렬 결과<br>' + result).appendTo($('#tableRight'));
	}
	function bubbleSort(limit, n) {
		$('#tableRight').empty();
		var data = [];
		var temp = 0;
		var result = "";
		for (i = 0; i <= 9; i++) {
			data[i] = limit.split(" ")[i] * 1;
		}
		for (k = 0; k < n; k++) {
			for (i = 0; i <= 8; i++) {
				if (data[i] > data[i + 1]) {
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
				}
			}
		}
		for (i = 0; i <= 9; i++) {
			result += data[i] + " ";
		}
		divAlert.html('버블정렬 결과<br>' + result).appendTo($('#tableRight'));
	}
	function inserSort(limit) {
		$('#tableRight').empty();
		var data = [];
		var temp = 0;
		var result = "";
		for (i = 0; i <= 9; i++) {
			data[i] = limit.split(" ")[i] * 1;
		}
		for (i = 1; i < 10; i++) {
			for (k = 0; k <= i; k++) {
				if (data[i] < data[k]) {
					temp = data[i];
					data[i] = data[k];
					data[k] = temp;
				}
			}
		}
		for (i = 0; i <= 9; i++) {
			result += data[i] + " ";
		}
		divAlert.html('삽입정렬 결과<br>' + result).appendTo($('#tableRight'));
	}
	/*
		객체지향적 자바 스크립트
		js객체생성법 
		1. constructor
		2. declaration
		3. expression
		
	*/
	app.person=(function(){
		var _name,_age,_gen,_job;
		return {
			setName: function(name){this._name=name},
			setAge:function(age){this._age=age},
			setGen: function(gen){this._gen=gen},
			setJob: function(job){this._job=job},
			getName: function(){return this._name;},
			getAge: function(){return this._age;},
			getGen: function(){return this._gen;},
			getJob: function(){return this._job;},
			toString: function(){
				return this._name+", "+this._age+", "+this._gen+", "+this._job;
			}
		};
	})();
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
</script>
</html>