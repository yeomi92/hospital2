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
		app.algorithm.init();
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
arr=(function(){})();
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
	var selectSort=function(data,n) {
		var temp = 0;
		var result = "";
		console.log('n: '+n);
		for (i = 0; i < n*1; i++) {
			for (j = i + 1; j < 6; j++) {
				if (data[i] > data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		return data;
	};
	/*버블정렬*/
	var bubbleSort=function(data,n) {
		var temp = 0;
		var result = "";
		console.log('n: '+n);
		for (k = 0; k < n*1; k++) {
			for (i = 0; i <5; i++) {
				if (data[i] > data[i + 1]) {
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
				}
			}
		}
		return data;
	};
	/*삽입정렬*/
	var insertSort=function(data,n) {
		var temp = 0;
		var result = "";
		console.log('n: '+n);
		for (i = 1; i < n*1+1; i++) {
			for (k = 0; k <= i; k++) {
				if (data[i] < data[k]) {
					temp = data[i];
					data[i] = data[k];
					data[k] = temp;
				}
			}
		}
		return data;
	};
	var rank=function(data){
		var result="";
		var rank=[1,1,1,1,1,1];
		for(i=0;i<data.length;i++){
			for(k=0;k<data.length;k++){
				if(data[i]<data[k]){
					rank[i]++;
				}
			}
		}
		return rank;
	};
	var series=function(){
		$('#series').on('click',function() {
			var wrapper=app.component.getWrapper();
			wrapper.empty();
	         wrapper.append(app.algorithm.TABLE);
	         var arr = [{id:'aSeries', txt:'등차수열'},
	            {id:'swSeries', txt:'스위치수열'},
	            {id:'dSeries', txt:'계차수열'},
	            {id:'factorial', txt:'팩토리얼'},
	            {id:'fibonacci', txt:'피보나치'}];
	         var str = '';
	         $.each(arr, function(i,j){
	            str+='<li id="' + j.id + '" class="list-group-item"><a href="#">' + j.txt + '</a></li>';
	         });
	         var tableLeft = $('#tableLeft');
	         tableLeft.empty();
	         tableLeft.html(str);
	         var tableRight = $('#tableRight');   
	         tableRight.empty();
			app.component.inputText('inputText').attr('placeholder', 'start limit 공차 입력').appendTo(tableRight);
			app.component.aButton('aButton','btn-primary').html('등차수열의 합').appendTo(tableRight).on('click',function() {
				console.log($('#inputText').val());
				var result=app.algorithm.aSeries($('#inputText').val());
				app.component.divAlert('alert-primary').html('등차수열 결과<br>'+result).appendTo(tableRight);
			});
			$('#aSeries').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'start limit 공차 입력').appendTo(tableRight);
				app.component.aButton('aButton','btn-primary').html('등차수열의 합').appendTo(tableRight).on('click', function() {
					var result=app.algorithm.aSeries($('#inputText').val());
					app.component.divAlert('alert-primary').html('등차수열 결과<br>'+result).appendTo(tableRight);
				});
			});
			$('#swSeries').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(tableRight);
				app.component.aButton('aButton','btn-success').html('스위치수열의 합').appendTo(tableRight).on('click', function() {
					var result=app.algorithm.swSeries($('#inputText').val());
					app.component.divAlert('alert-success').html('스위치수열 결과: ' + result).appendTo(tableRight);
				});
			});
			$('#dSeries').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(tableRight);
				app.component.aButton('aButton','btn-info').html('계차수열의 합').appendTo(tableRight).on('click', function() {
					var result=app.algorithm.dSeries($('#inputText').val());
					app.component.divAlert('alert-info').html('계차수열 결과: ' + result).appendTo(tableRight);
				});
			});
			$('#factorial').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(tableRight);
				app.component.aButton('aButton','btn-warning').html('팩토리얼수열의 합').appendTo(tableRight).on('click',function() {
					var result=app.algorithm.factorial($('#inputText').val());
					app.component.divAlert('alert-warning').html('팩토리얼수열 결과: ' + result).appendTo(tableRight);
				});
			});
			$('#fibonacci').on('click',function() {
				$('#tableRight').empty();
				app.component.inputText('inputText').attr('placeholder', 'limit').appendTo(tableRight);
				app.component.aButton('aButton','btn-danger').html('피보나치수열의 합').appendTo(tableRight).on('click',function() {
					var result=app.algorithm.fibonacci($('#inputText').val());
					app.component.divAlert('btn-danger').html('피보나치수열 결과: ' + result).appendTo(tableRight);
				});
			});
		});
	};	
	var arr=function(){
		$('#array').on('click',function() {
			var wrapper=app.component.getWrapper();
			wrapper.empty();
	         wrapper.append(app.algorithm.TABLE);
	         var arr = [{id: 'selectSort', txt:'선택정렬'},
	            {id: 'bubbleSort', txt:'버블정렬'},
	            {id: 'insertSort', txt:'삽입정렬'},
	            {id: 'ranking', txt:'석차구하기'},
	            {id: 'binSearch', txt:'이분검색'},
	            {id: 'merge', txt:'병합'},
	            {id: 'stack', txt:'스택'}];
	         var str = '';
	         $.each(arr, function(i,j){
	            str+='<li id="' + j.id + '" class="list-group-item"><a href="#">' + j.txt + '</a></li>';
	         });
	         var tableLeft = $('#tableLeft');
	         tableLeft.empty();
	         tableLeft.html(str);
	         var tableRight = $('#tableRight');   
	         tableRight.empty();
	         var arr = randomGen(6);
	            tableRight.html(app.component.horList(arr,'default'));
	            app.component.inputText('inputText').attr('placeholder', '정렬 회전 수 입력').appendTo(tableRight);
				app.component.aButton('aButton','btn-primary').html('선택정렬').appendTo(tableRight).on('click',function() {
					var result=selectSort(arr);
					tableRight.append(app.component.horList(result,'default'));
				});
			$('#selectSort').on('click',function() {
				tableRight.empty();
				var arr = randomGen(6);
	            tableRight.html(app.component.horList(arr,'default'));
	            app.component.inputText('inputText').attr('placeholder', '정렬 회전 수 입력').appendTo(tableRight);
				app.component.aButton('aButton','btn-primary').html('선택정렬').appendTo(tableRight).on('click',function() {
					var result=selectSort(arr,$('#inputText').val());
					$('#aButton').remove();
					$('#inputText').remove();
					tableRight.append(app.component.horList(result,'default'));
				});
			});
			$('#bubbleSort').on('click',function() {
				tableRight.empty();
				var arr = randomGen(6);
	            tableRight.html(app.component.horList(arr,'default'));
	            app.component.inputText('inputText').attr('placeholder', '정렬 회전 수 입력').appendTo(tableRight);
				app.component.aButton('aButton','btn-primary').html('버블정렬').appendTo(tableRight).on('click',function() {
					var result=bubbleSort(arr,$('#inputText').val());
					tableRight.append(app.component.horList(result,'default'));
				});
			});
			$('#insertSort').on('click',function() {
				tableRight.empty();
				var arr = randomGen(6);
	            tableRight.html(app.component.horList(arr,'default'));
	            app.component.inputText('inputText').attr('placeholder', '정렬 회전 수 입력').appendTo(tableRight);
				app.component.aButton('aButton','btn-primary').html('삽입정렬').appendTo(tableRight).on('click',function() {
					var result=insertSort(arr,$('#inputText').val());
					tableRight.append(app.component.horList(result,'default'));
				});
			});
			$('#ranking').on('click',function() {
				tableRight.empty();
				var arr = randomGen(6);
	            tableRight.html(app.component.horList(arr,'default'));
				app.component.aButton('aButton','btn-primary').html('석차구하기').appendTo(tableRight).on('click',function() {
					var result=rank(arr);
					$('#aButton').remove();
					tableRight.append(app.component.horList(result,'default'));
				});
			});
		});
	};
	
	var randomGen = function(n){
	    var arr=[];
	    for(i=0;i<n;i++){
	       arr[i]=(Math.floor(Math.random()*45)+1);
	       for(k=i;k>0;k--){
				if(arr[i]==arr[k-1]){
					console.log('같으면 들어온다.'+arr[i]+', '+arr[k-1]);
					i--;
				}
	       }
	    }
	    return arr;
	};
	var horizontalTable = function(arr){
		var table='';
		table += '<table style="width:210px; height:280px; border-collapse: collapse; border: 1px solid black; margin: 0 auto"><tbody><tr><td>';
		$.each(arr, function(i,j){
		table += '<td>' + arr[i] + '</td>';
		});
		table += '</tr></tbody></table>';
		$('#table td').css('border', '1px solid black');
		return table;
	};
	var basic=function(){
		$('#basic').on('click',function(){
			var mtx = new Array(new Array(5), new Array(5),new Array(5), new Array(5),new Array(5));
			var jason=[
		        {
		            a : 1,
		            b : 2,
		            c : 3,
		            d : 4,
		            e : 5
		        },
		        {
		        	a : 6,
		            b : 7,
		            c : 8,
		            d : 9,
		            e : 10
		        },
		        {
		        	a : 11,
		            b : 12,
		            c : 13,
		            d : 14,
		            e : 15
		        },
		        {
		        	a : 16,
		            b : 17,
		            c : 18,
		            d : 19,
		            e : 20
		        },
		        {
		        	a : 21,
		            b : 22,
		            c : 23,
		            d : 24,
		            e : 25
		        }
		    ];
			$('#tableRight').html(app.component.panelTable(jason,'Basic','default'));
		});
	};
	
	var zigzag=function(){
		$('#zigzag').on('click',function(){
			var a=[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]];
			var k = 0; // 1씩 증가되는 숫자가 저장될 변수
	        var i = 0; // 배열의 행 위치를 지정해 주는 변수
	        var j = 0; // 배열의 열 위치를 지정해 주는 변수
	        var l = 0; // 배열의 열 시작 위치를 지정해 주는 변수
	        var m = 4; // 배열의 열 끝 위치를 지정해 주는 변수
	        var n = 0; // 증가 값을 지정해 주는 스위치 변수
	        var p = 0; // 열의 시작 위치(l)과 끝 위치(m)의 값을 바꿀 때 사용하는 임시 변수
			for(i=0;i<5;i++){
				if(n==0){
					for(j=l;j<=m;j++){
							k++;
							a[i][j]=k;
					}
				}else{
					for(j=l;j>=m;j--){
							k++;
							a[i][j]=k;
					}
				}
				p=l;
				l=m;
				m=p;
				if(n==0){
					n=1;
				}else{
					n=0;
				}
			}	
			var jason=[
		        {
		            a : a[0][0],
		            b : a[0][1],
		            c : a[0][2],
		            d : a[0][3],
		            e : a[0][4]
		        },
		        {
		        	a : a[1][0],
		            b : a[1][1],
		            c : a[1][2],
		            d : a[1][3],
		            e : a[1][4]
		        },
		        {
		        	a : a[2][0],
		            b : a[2][1],
		            c : a[2][2],
		            d : a[2][3],
		            e : a[2][4]
		        },
		        {
		        	a : a[3][0],
		            b : a[3][1],
		            c : a[3][2],
		            d : a[3][3],
		            e : a[3][4]
		        },
		        {
		        	a : a[4][0],
		            b : a[4][1],
		            c : a[4][2],
		            d : a[4][3],
		            e : a[4][4]
		        }
		    ];
			$('#tableRight').html(app.component.panelTable(jason,'Basic','default'));
		});
	};
	
	var diamond=function(){
		$('#diamond').on('click',function(){
			var a=[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]];
			var k=0;//1씩 증가하는 변수
			var i=0;//배열의 행위치
			var j=0;//배열의 열위치
			var s=2;//열의 시작 위치
			var e=2;//열의 끝 위치
			for(i=0;i<5;i++){
				for(j=s;j<=e;j++){
					k++;
					a[i][j]=k;
				}
				if(i>1){
					s++;
					e--;
				}else{
					s--;
					e++;
				}
			}
			var jason=[
		        {
		            a : a[0][0],
		            b : a[0][1],
		            c : a[0][2],
		            d : a[0][3],
		            e : a[0][4]
		        },
		        {
		        	a : a[1][0],
		            b : a[1][1],
		            c : a[1][2],
		            d : a[1][3],
		            e : a[1][4]
		        },
		        {
		        	a : a[2][0],
		            b : a[2][1],
		            c : a[2][2],
		            d : a[2][3],
		            e : a[2][4]
		        },
		        {
		        	a : a[3][0],
		            b : a[3][1],
		            c : a[3][2],
		            d : a[3][3],
		            e : a[3][4]
		        },
		        {
		        	a : a[4][0],
		            b : a[4][1],
		            c : a[4][2],
		            d : a[4][3],
		            e : a[4][4]
		        }
		    ];
			$('#tableRight').html(app.component.panelTable(jason,'Basic','default'));
		});
	};
	
	var sandGlass=function(){
		$('#sandGlass').on('click',function(){
			var a=[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]];
			var x = 5; // 입력 받은 배열의 크기가 저장될 변수, 즉 x가 5면 배열의 크기는 5행 5열
	        var m = 2; // 배열의 중간 행 번호가 저장될 변수, 즉 5행 5열의 배열인 경우 m은 3
	        var l = x; // 행에서 열의 시작 위치 또는 끝 위치를 지정해 주는 변수
	        var i = 0; // 배열의 행 위치를 지정해 주는 변수
	        var j = 0; // 배열의 열 위치를 지정해 주는 변수
	        var k = 0; // 1씩 증가되는 숫자가 저장될 변수
	        for(i=0;i<=m;i++){
	        	l--;
	        	for(j=i;j<=l;j++){
	        		k++;
	        		a[i][j]=k;
	        	}
	        }
	        for(i=m+1;i<x;i++){
	        	l--;
	        	for(j=l;j<=i;j++){
	        		k++;
	        		a[i][j]=k;
	        	}
	        }
	        var jason=[
		        {
		            a : a[0][0],
		            b : a[0][1],
		            c : a[0][2],
		            d : a[0][3],
		            e : a[0][4]
		        },
		        {
		        	a : a[1][0],
		            b : a[1][1],
		            c : a[1][2],
		            d : a[1][3],
		            e : a[1][4]
		        },
		        {
		        	a : a[2][0],
		            b : a[2][1],
		            c : a[2][2],
		            d : a[2][3],
		            e : a[2][4]
		        },
		        {
		        	a : a[3][0],
		            b : a[3][1],
		            c : a[3][2],
		            d : a[3][3],
		            e : a[3][4]
		        },
		        {
		        	a : a[4][0],
		            b : a[4][1],
		            c : a[4][2],
		            d : a[4][3],
		            e : a[4][4]
		        }
		    ];
			$('#tableRight').html(app.component.panelTable(jason,'Basic','default'));
		});
	};
	
	var snail=function(){
		$('#snail').on('click',function(){
			var a=[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]];
			var k = 0; // 1씩 증가되는 숫자가 저장될 변수
	        var i = 0; // 배열의 행 위치를 지정해 주는 변수
	        var n = 0; // 반복문의 반복 변수
	        var j = -1; // 배열의 열 위치를 지정해 주는 변수
	        var c = 1; // 행과 열의 증가 혹은 감소 여부가 지정될 변수, 즉 C가 -1이면 행이나 열을 감소하고, 1이면 행이나 열을 증가
	        var f = 5; // 각 회전에서 수행할 수행 횟수가 지정될 변수
	        while(1){
	        	for(n=1;n<=f;n++){
	        		k++;
	        		j+=c;
	        		a[i][j]=k;
	        	}
	        	f--;
	        	if(f<=0){
	        		break;
	        	}
	        	for(n=1;n<=f;n++){
	        		k++;
	        		i+=c;
	        		a[i][j]=k;
	        	}
	        	c*=-1;
	        }
	        var jason=[
		        {
		            a : a[0][0],
		            b : a[0][1],
		            c : a[0][2],
		            d : a[0][3],
		            e : a[0][4]
		        },
		        {
		        	a : a[1][0],
		            b : a[1][1],
		            c : a[1][2],
		            d : a[1][3],
		            e : a[1][4]
		        },
		        {
		        	a : a[2][0],
		            b : a[2][1],
		            c : a[2][2],
		            d : a[2][3],
		            e : a[2][4]
		        },
		        {
		        	a : a[3][0],
		            b : a[3][1],
		            c : a[3][2],
		            d : a[3][3],
		            e : a[3][4]
		        },
		        {
		        	a : a[4][0],
		            b : a[4][1],
		            c : a[4][2],
		            d : a[4][3],
		            e : a[4][4]
		        }
		    ];
			$('#tableRight').html(app.component.panelTable(jason,'Basic','default'));
		});
	};
	
	var magicSquare=function(){
		$('#magicSquare').on('click',function(){
			var a = new Array(new Array(5), new Array(5),new Array(5), new Array(5),new Array(5));
			var i = 0; // 배열의 행 위치를 지정해 주는 변수
	        var j = 2*1; // 배열의 열 위치를 지정해 주는 변수
	        var k = 0; // 1에서 25까지 1씩 증가되는 숫자가 저장될 변수
	        var nmg = 0; // k가 5의 배수인지를 확인하기 위해 계산한 후 나머지가 저장될 변수
	        for(k=1;k<=25;k++){
	        	console.log('i, j, k: '+i+', '+j+', '+k);	
	        	a[i][j]=k;
	        	nmg=k%5;
	        	console.log('nmg, i, k: '+nmg+', '+i+', '+k);	
	        	if(nmg==0){
	        		i++;
	        		continue;
	        	}
	        	i--;
	        	j++;
	        	if(i<0){
	        		i=4;
	        	}
	        	if(j>4){
	        		j=0;
	        	}
	        }
	        var jason=[
		        {
		            a : a[0][0],
		            b : a[0][1],
		            c : a[0][2],
		            d : a[0][3],
		            e : a[0][4]
		        },
		        {
		        	a : a[1][0],
		            b : a[1][1],
		            c : a[1][2],
		            d : a[1][3],
		            e : a[1][4]
		        },
		        {
		        	a : a[2][0],
		            b : a[2][1],
		            c : a[2][2],
		            d : a[2][3],
		            e : a[2][4]
		        },
		        {
		        	a : a[3][0],
		            b : a[3][1],
		            c : a[3][2],
		            d : a[3][3],
		            e : a[3][4]
		        },
		        {
		        	a : a[4][0],
		            b : a[4][1],
		            c : a[4][2],
		            d : a[4][3],
		            e : a[4][4]
		        }
		    ];
			$('#tableRight').html(app.component.panelTable(jason,'Basic','default'));
		});
	};
	
	var matrix=function(){
		$('#matrix').on('click', function() {
			var wrapper=app.component.getWrapper();
			wrapper.empty();
	         wrapper.append(app.algorithm.TABLE);
	         var arr = [{id: 'basic', txt:'기본 5X5'},
	            {id: 'zigzag', txt:'지그재그'},
	            {id: 'diamond', txt:'다이아몬드'},
	            {id: 'sandGlass', txt:'모래시계'},
	            {id: 'snail', txt:'달팽이'},
	            {id: 'magicSquare', txt:'마방진'}];
	         var str = '';
	         $.each(arr, function(i,j){ //i: index값, j: 객체값 / jsp는 오버라이딩해서 안쓰는 파라미터가 있더라도 그 자리는 채워줘야한다.
	            str+='<li id="' + j.id + '" class="list-group-item"><a href="#">' + j.txt + '</a></li>';
	         });
	         var tableLeft = $('#tableLeft');
	         tableLeft.empty();
	         tableLeft.html(str);
	         var tableRight = $('#tableRight');   
	         tableRight.empty();
	         basic();
	         zigzag();
	         diamond();
	         sandGlass();
	         snail();
	         magicSquare();
		});
	};
	var math=function(){
		$('#math').on('click', function() {
			var wrapper=app.component.getWrapper();
			wrapper.empty();
			wrapper.append(app.algorithm.TABLE);
			var arr=[{id:'determinePrime', txt:'소수판별'}
				,{id:'primeSum', txt:'소수의 합'}
				,{id:'primeCount', txt:'소수의 개수'}
				,{id:'lcmGcm', txt:'최대공약수/최소공배수'}
				,{id:'euclid', txt:'유클리드(해야함)'}
				,{id:'factorization', txt:'약수구하기'}
				,{id:'primeFactor', txt:'소인수분해(해야함)'}
				,{id:'multiplSum', txt:'배수의 합'}
				,{id:'approx', txt:'근사값구하기'}];
			var str='';
			$.each(arr, function(i,j){
				str+='<li id="'+j.id+'" class="list-group-item"><a href="#">'+j.txt+'</a></li>';
			});
			var tableLeft = $('#tableLeft');
	         tableLeft.empty();
	         tableLeft.html(str);
	         var tableRight = $('#tableRight');   
	         tableRight.empty();
	         determinePrime();
	         primeSum();
	         primeCount();
	         lcmGcm();
	         factorization();
	         primeFactor();
	         multiplSum();
	         approx();
		});
	};
	
	/*소수판별: 어떤 수 X가 2부터 X-1까지 차례대로 나누어 떨어지는지 검사*/
	var determinePrime=function(){
		$('#determinePrime').on('click',function(){
			var a=randomGen(1);
			var result='소수';
			for(var i=2;i<a;i++){
				if(a%i==0){
					result='소수 아님';
				}
			}
			$('#tableRight').html('소수판별수: '+a+'<br>결과: '+result);
		});
	};
	
	/*소수의합: 숫자2부터 입력받은 수 X까지 증가시키며 각각 소수판별 후 소수만 합계에 누적*/
	var primeSum=function(){
		$('#primeSum').on('click',function(){
			var a=randomGen(1);
			var sum=0;
			var sumStr=[];
			var ch=1;
			for(var i=2;i<=a;i++){
				for(var j=2;j<i;j++){
					if(i%j==0){
						ch=0;
						break;
					}
				}
				if(ch==1){
					sum+=i;
					sumStr.push(i);
				}
				ch=1;
			}
			$('#tableRight').html('소수를 구할 숫자 범위의 한계: '+a+'<br>소수의 합 결과: '+sum+'<br>소수들: '+sumStr);
		});
	};
	
	/*소수의개수: 숫자2부터 입력받은 수 X까지 증가시키며 각각 소수판별 후 소수만 개수에 누적*/
	var primeCount=function(){
		$('#primeCount').on('click',function(){
			var a=randomGen(1);
			var count=0;
			var countStr=[];
			var ch=1;
			for(var i=2;i<=a;i++){
				for(var j=2;j<i;j++){
					if(i%j==0){
						ch=0;
						break;
					}
				}
				if(ch==1){
					count++;
					countStr.push(i);
				}
				ch=1;
			}
			$('#tableRight').html('소수를 구할 숫자 범위의 한계: '+a+'<br>소수의 개수 결과: '+count+'<br>소수들: '+countStr);
		});
	};
	
	/*최대공약수,최소공배수*/
	var lcmGcm=function(){
		$('#lcmGcm').on('click',function(){
			var a=randomGen(1);
			var b=randomGen(1);
			var big=(a>b)?a:b;
			var small=(a>b)?b:a;
			var gcm=0,lcm=0;
			var temp=0;
			while(true){
				if(big%small==0){
					gcm=small;
					lcm=a*b/gcm;
					break;
				}else{
					temp=big;
					big=small;
					small=temp%small;
				}
			}
			$('#tableRight').html('두 수: '+a+', '+b+'<br>최대공약수: '+gcm+'<br>최소공배수: '+lcm);
		});
	};
	/*약수구하기*/
	var factorization=function(){
		$('#factorization').on('click',function(){
			var a=[];
			var b=randomGen(1);
			for(var i=0;i<=b;i++){
				if(b%i==0){
					a.push(i);
				}
			}
			$('#tableRight').html('약수를 구할 수: '+b+'<br>약수: '+a);
		});
	};
	/*소인수분해*/
	var primeFactor=function(){
		$('#primeFactor').on('click',function(){
			var a=[]; //소인수 저장될 배열
			var b=4; //소인수분해할 숫자
			var c=-1; //소인수 저장할 배열 a의 위치를 지정해주는 변수
			var d=2; //제수가 저장될 변수
			var e=2; //b의 제곱근이 저장될 변수
			var mok=0; //b를 d로 나눈 몫이 저장될 변수
			var nmg=0 //b를 d로 나눈 나머지가 저장도리 변수
			var result='';
			while(1){
				e=Math.sqrt(b);
				console.log('e: '+e);
				while(1){
					if(d>e){
						d=b;
						break;
					}
					mok=b/d;
					nmg=b-mok*d;
					if(nmg==0){
						break;
					}else{
						d++;
					}
				}
				c++;
				a[c]=d;
				if(b==d){
					break;
				}
				b=mok;
			}
			for(i=0;i<=c;i++){
				result+=a[i]+' ';
			}
			$('#tableRight').html('소인수분해할 수: 5<br>소인수 결과: '+result);
		});
	};
	
	var multiplSum=function(){
		$('#multiplSum').on('click',function(){
			app.component.inputText('inputText').attr('placeholder', '배수를 구하고 싶은 수와 범위를 입력하세요.').appendTo(tableRight);
			app.component.aButton('aButton','btn-primary').html('결과보기').appendTo(tableRight).on('click', function() {
				var a=$('#inputText').val().split(" ")[0]*1;
				var b=$('#inputText').val().split(" ")[1]*1;
				var n=b/a;
				console.log('n:'+n);
				var sum=0;
				var sumStr=[];
				for(var i=1;i<=n;i++){
					sum+=a*i;
					sumStr.push(a*i);
				}
				$('#tableRight').html('배수를 구하고 싶은 수: '+a+'<br>범위: 1~'+b+'<br>결과: '+sum+'<br>'+sumStr);
			});
		});
	};
	
	var approx=function(){
		$('#approx').on('click',function(){
			app.component.inputText('inputText').attr('placeholder', '1~45사이의 숫자를 입력하세요').appendTo(tableRight);
			app.component.aButton('aButton','btn-primary').html('결과보기').appendTo(tableRight).on('click', function() {
				var a=$('#inputText').val()*1;
				var b=randomGen(10);
				var l=0;
				var j=44;
				var m=0;
				for(var i=0;i<b.length;i++){
					if(a>b[i]){
						l=a-b[i];
					}else{
						l=b[i]-a;
					}
					if(l<=j){
						j=l;
						m=b[i];
					}
				}
				$('#tableRight').html('입력한 숫자: '+a+'<br>10개의 수: '+b+'<br>가장 가까운 수: '+m);
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
		insertSort: insertSort,
		randomGen: randomGen,
		horizontalTable: horizontalTable,
		arr: arr,
		basic: basic,
		zigzag: zigzag,
		diamond: diamond,
		sandGlass: sandGlass,
		snail: snail,
		magicSquare: magicSquare,
		matrix: matrix,
		math: math,
		lcmGcm: lcmGcm,
		factorization: factorization,
		primeFactor: primeFactor,
		multiplSum: multiplSum,
		approx: approx,
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
	    },
	    horList: function(arr,i){
	    	var type='';
	    	switch(i){
	    	case 'default': type='btn-default'; break;
	    	}
	    	var list='<div class="btn-group" role="group" aria-label="...">';
	    	$.each(arr,function(i,j){
	    		list+='<button id="list-button-"'+i+' type="button" class="btn "'+type+'">'+arr[i]+'</button>';
	    	});
	    	list+='</div>';
	    	return list;
	    },
	    panelTable: function(json,txt,type){
	    	var table=
	    		'<div class="panel panel-'+type+'">'
	    		+'<div class="panel-heading">행렬</div>'
	    		+'<table id="table">'
	    		+'<tr>'
	    		+'<th colspan="5">'+txt+'</th>'
	    		+'</tr>'
	    		+'<tbody>';
	    	$.each(json, function(i,j){
	    		table+='<tr><td style="width:20%">'+j.a+'</td><td style="width:20%">'+j.b+'</td><td style="width:20%">'+j.c+'</td><td style="width:20%">'+j.d+'</td><td style="width:20%">'+j.e+'</td></tr>';
	    	});
	    	table+='</tbody></table>';
	    	return table;
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
	
	
	
	
	
	
	