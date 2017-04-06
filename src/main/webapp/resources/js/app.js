var app=app||{}; //namespace pattern
/*************************************************************************************
 * Model-logic
 * app.context=(function(){    //META-INFO같은 것
 * app.session=(function(){
 * app.util=(function(){
 * app.algorithm=(function(){
 * app.oop=(function(){
 *************************************************************************************/
app.context=(function(){
	//android의 context와 같은 기능
	var init=function(context){
		app.session.init(context); //templatemethod pattern
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		app.algorithm.series();
		app.component.init();
		app.oop.init();
	};
	var setContentView=function(){
		
	};
	return{
		init: init,
		setContentView: setContentView,
		onCreate: onCreate
	}
})();
app.session=(function(){
	//hook(설정값이 다 설정됬다.)
	var init=function(context){
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img');
	};
	var getContextPath=function(){return sessionStorage.getItem('context');};
	var getJavaScriptPath=function(){return sessionStorage.getItem('js');};
	var getStylePath=function(){return sessionStorage.getItem('css');};
	var getImagePath=function(){return sessionStorage.getItem('img');};
	return{
		init: init,
		getContextPath: getContextPath,
		getJavaScriptPath: getJavaScriptPath,
		getStylePath: getStylePath,
		getImagePath: getImagePath
	};
})();

//util
app.util=(function(){})();

series=(function(){})();

aSeries=function(){};

//algorithm
app.algorithm=(function(){
	/*알고리즘 수열*/
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		series();
		arr();
		matrix();
		math();
		appl();
		
	};
	var setContentView=function(){};
	/*등차수열*/
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
	/*스위치수열*/
	var swSeries=function(limit) {
		$('#tableRight').empty();
		var result = 0;
		var resultStr = "";
		var sw = 1;
		for (i = 1; i <= limit; i++) {
			result += (sw * i);
			sw *= -1;
		}
		return result;
		
	};
	/*계차수열*/
	var dSeries=function(limit) {
		$('#tableRight').empty();
		var temp = 1;
		var result = 0;
		for (i = 0; i <= limit; i++) {
			temp += i;
			result += temp;
		}
		return result;
	};
	/*팩토리얼수열*/
	var factorial=function(limit) {
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
		return result;
	};
	/*피보나치수열*/
	var fibonacci=function(limit) {
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
		return result;
	};
	/*선택정렬*/
	var selectSort=function(limit, n) {
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
	/*버블정렬*/
	var bubbleSort=function(limit, n) {
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
	/*삽입정렬*/
	var inserSort=function(limit) {
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
	var series=function(){
		$('#series').on('click',function() {
			alert('test');
			var wrapper=app.component.getWrapper();
			wrapper.empty();
			wrapper.append(app.algorithm.TABLE);
			$('#tableLeft').html(app.algorithm.SERIES_MENU);
			console.log('tableLeft: '+$('#tableLeft'));
			app.component.inputText('inputText').attr('placeholder', 'start limit 공차 입력').appendTo($('#tableRight'));
			app.component.aButton('aButton','btn-primary').html('등차수열의 합').appendTo($('#tableRight')).on('click',function() {
				console.log($('#inputText').val());
				var result=app.algorithm.aSeries($('#inputText').val());
				app.component.divAlert('alert-primary').html('등차수열 결과<br>'+result).appendTo($('#tableRight'));
			});
			$('#aSeries').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'start limit 공차 입력').appendTo($('#tableRight'));
				app.component.aButton('aButton','btn-primary').html('등차수열의 합').appendTo($('#tableRight')).on('click', function() {
					var result=app.algorithm.aSeries($('#inputText').val());
					app.component.divAlert('alert-primary').html('등차수열 결과<br>'+result).appendTo($('#tableRight'));
				});
			});
			$('#swSeries').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'limit').appendTo($('#tableRight'));
				app.component.aButton('aButton','btn-success').html('스위치수열의 합').appendTo($('#tableRight')).on('click', function() {
					var result=app.algorithm.swSeries($('#inputText').val());
					app.component.divAlert('alert-success').html('스위치수열 결과: ' + result).appendTo($('#tableRight'));
				});
			});
			$('#dSeries').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'limit').appendTo($('#tableRight'));
				app.component.aButton('aButton','btn-info').html('계차수열의 합').appendTo($('#tableRight')).on('click', function() {
					var result=app.algorithm.dSeries($('#inputText').val());
					app.component.divAlert('alert-info').html('계차수열 결과: ' + result).appendTo($('#tableRight'));
				});
			});
			$('#factorial').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'limit').appendTo($('#tableRight'));
				app.component.aButton('aButton','btn-warning').html('팩토리얼수열의 합').appendTo($('#tableRight')).on('click',function() {
					var result=app.algorithm.factorial($('#inputText').val());
					app.component.divAlert('alert-warning').html('팩토리얼수열 결과: ' + result).appendTo($('#tableRight'));
				});
			});
			$('#fibonacci').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'limit').appendTo($('#tableRight'));
				app.component.aButton('aButton','btn-danger').html('피보나치수열의 합').appendTo($('#tableRight')).on('click',function() {
					var result=app.algorithm.fibonacci($('#inputText').val());
					app.component.divAlert('btn-danger').html('피보나치수열 결과: ' + result).appendTo($('#tableRight'));
				});
			});
		});
	};
	var arr=function(){
		$('#array').on('click',function() {
			alert('arr');
			var wrapper=app.component.getWrapper();
			wrapper.empty();
			wrapper.append(app.algorithm.TABLE);
			var tableLeft=$('#tableLeft');
			var tableRight=$('#tableRight');				
			$('#tableLeft').empty();
			$('#tableRight').empty();
			app.algorithm.ARRAY_MENU().appendTo(tableLeft);
			app.component.inputText('inputText').attr('placeholder', '10개 숫자').appendTo(tableRight);
			app.component.inputText('inputText2').attr('placeholder', '회전수').appendTo(tableRight);
			app.component.aButton('aButton','btn-primary').html('선택정렬').appendTo(tableRight).on('click',function() {selectSort($('#inputText').val(), $('#inputText2').val());});
			$('#selectSort').on('click',function() {
				tableRight.empty();
				app.component.inputText('inputText').attr('placeholder', '10개의 숫자값을 입력하세요.').appendTo(tableRight);
				app.component.inputText('inputText2').attr('placeholder', '회전수').appendTo(tableRight);
				app.component.aButton('aButton','btn-primary').html('선택정렬').appendTo(tableRight).on('click',function() {selectSort($('#inputText').val(), $('#inputText2').val());});
			});
			$('#bubbleSort').on('click',function() {
				tableRight.empty();
				app.component.inputText('inputText').attr('placeholder', '10개의 숫자값을 입력하세요.').appendTo(tableRight);
				app.component.inputText('inputText2').attr('placeholder', '회전수').appendTo(tableRight);
				app.component.aButton('aButton','btn-primary').html('버블정렬').appendTo(tableRight).on('click',function() {bubbleSort($('#inputText').val(), $('#inputText2').val());});
			});
			$('#insertSort').on('click',function() {
				tableRight.empty();
				app.component.inputText('inputText').attr('placeholder', '10개의 숫자값을 입력하세요.').appendTo(tableRight);
				app.component.aButton('aButton','btn-primary').html('삽입정렬').appendTo(tableRight).on('click', function() {inserSort($('#inputText').val());});
			});
		});
	};
	var matrix=function(){
		$('#matrix').on('click', function() {
			app.component.wrapper.empty();
			app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(wrapper);
			app.component.aButton('aButton','btn-primary').html('매트릭스').appendTo(wrapper).on('click', function() {
				aSeries(inputText.val());
			});
		});
	};
	var math=function(){
		$('#math').on('click', function() {
			app.component.wrapper.empty();
			app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(wrapper);
			app.component.aButton('aButton','btn-primary').html('math').appendTo(wrapper).on('click', function() {
				aSeries(inputText.val());
			});
		});
	};
	var appl=function(){
		$('#application').on('click', function() {
			app.component.wrapper.empty();
			app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(wrapper);
			app.component.aButton('aButton','btn-primary').html('응용').appendTo(wrapper).on('click', function() {
				aSeries(inputText.val());
			});
		});
	};
	return {
		init: init,
		aSeries: aSeries,
		swSeries: swSeries,
		dSeries: dSeries,
		factorial: factorial,
		fibonacci: fibonacci,
		series: series,
		selectSort: selectSort,
		bubbleSort: bubbleSort,
		inserSort: inserSort,
		arr: arr,
		matrix: matrix,
		math: math,
		appl: appl
	};
})();
app.oop=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		encap();
	};
	var encap=function(){
		$('#Encap').on('click',function(){
			var wrapper=app.component.getWrapper();
			wrapper.empty();
			$('#tableLeft').empty();
			$('#tableRight').empty();
			wrapper.append(app.algorithm.TABLE);
			$('#tableLeft').html(app.oop.OOP_MENU);
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
	};
	var setContentView=function(){};
	return {
		init: init,
		encap: encap,
		inherit: function(){},
		poly: function(){}
	};
})();

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

/*************************************************************************************
 * View
 * app.component=(function(){   //부품공장
 * app.navi=(function(){   //common 네비게이션
 * app.patient=(function(){  //환자 네비게이션
 *************************************************************************************/
app.component=(function(){
	var _body,_wrapper;
	var setBody=function(body){this._body=body;}
	var getBody=function(){return this._body;}
	var setWrapper=function(wrapper){this._wrapper=wrapper;}
	var getWrapper=function(){return this._wrapper;}
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
	};
	var setContentView=function(){
		app.component.setWrapper($('#wrapper'));
		app.component.setBody($('body'));
	};
	return{
		init: init,
		setBody: setBody,
		getBody: getBody,
		setWrapper: setWrapper,
		getWrapper: getWrapper,
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
	    divAlert: function(type){
	    	return $('<div class="alert '+type+'" role="alert">example</div>');
	    }	
	};
})();
app.navi=(function(){})();
app.patient=(function(){})();
app.algorithm.TABLE='<div style="width:100%">'
	+'<table style="margin: 0 auto; width:500px; height:300px; border-collapse: collapse; border: 1px solid black;">'
	+'<tr><td id="tableLeft" style="width:50%; border: 1px solid black;"></td>'
	+'<td id="tableRight"></td></tr></table></div>';
app.algorithm.SERIES_MENU='<ul class="list-group">'
	+ '<li id="aSeries" class="list-group-item"><a href="#">등차수열</a></li>'
	+ '<li id="swSeries" class="list-group-item"><a href="#">스위치수열</a></li>'
	+ '<li id="dSeries" class="list-group-item"><a href="#">계차수열</a></li>'
	+ '<li id="factorial" class="list-group-item"><a href="#">팩토리얼수열</a></li>'
	+ '<li id="fibonacci" class="list-group-item"><a href="#">피보나치수열</a></li></ul>';
app.algorithm.ARRAY_MENU='<ul class="list-group">'
	+ '<li id="selectSort" class="list-group-item"><a href="#">선택정렬</a></li>'
	+ '<li id="bubbleSort" class="list-group-item"><a href="#">버블정렬</a></li>'
	+ '<li id="insertSort" class="list-group-item"><a href="#">삽입정렬</a></li></ul>';
app.oop.OOP_MENU='<ul class="list-group">'
	+ '<li id="selectSort" class="list-group-item"><a href="#">캡슐화</a></li>'
	+ '<li id="bubbleSort" class="list-group-item"><a href="#">상속</a></li>'
	+ '<li id="insertSort" class="list-group-item"><a href="#">다형성</a></li></ul>';





/*************************************************************************************
 * Controller
 * app.controller=(function(){
 *************************************************************************************/
app.controller=(function(){})();
	
	
	
	
	
	
	