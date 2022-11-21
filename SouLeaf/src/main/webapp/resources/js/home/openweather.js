
$( document ).ready(function() {  
	let weatherIcon = { '01' : 'fas fa-sun', '02' : 'fas fa-cloud-sun', '03' : 'fas fa-cloud', '04' : 'fas fa-cloud-meatball', '09' : 'fas fa-cloud-sun-rain', '10' : 'fas fa-cloud-showers-heavy', '11' : 'fas fa-poo-storm', '13' : 'far fa-snowflake', '50' : 'fas fa-smog' }; 
  let weatherText = { '01' : '맑음', '02' : '구름조금', '03' : '흐림', '04' : '구름 많음', '09' : '가끔 비', '10' : '비', '11' : '번개를 동반한 비', '13' : '눈', '50' : '안개 낀' }; 
  $.ajax({ url:'http://api.openweathermap.org/data/2.5/weather?q=seoul&APPID=493227ed81dda9925c44ec2f77ae948a&units=metric', dataType:'json', type:'GET', success:function(data){ var $Icon = (data.weather[0].icon).substr(0,2); var $Temp = Math.round(data.main.temp) + 'º'; var $city = data.name; var $cityko = '서울특별시'; $('.CurrIcon').append('<small><i class="' + weatherIcon[$Icon] +'"></i></small>');$('.CurrText').append('<small>' + weatherText[$Icon] +'</small>'); $('.CurrTemp').prepend('<small>'+$Temp+'</small>'); $('.City').append('<small>'+$cityko+'<small>'); } })
});


