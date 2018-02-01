/**
 * Author : BFL
 * Date : 2013-03-28 11:49:15
 * Depends : jquery.1.3.0.min.js and above
 * getParameter: 
 * get the parameters from url,then return the list of parameters or the parameter with the given name
 * usage: jQuery.getParameter() or jQuery.getParameter('paramName')
 * 
 */
(function($){
	$.extend({
		getParameter : function(parameterName){
			var url1 = window.location.search;
			var url=decodeURI(url1);
			var returnValue;
			var str;
			if(url.indexOf('?') != -1){
				str = '{';
				var params = url.substring(url.indexOf('?')+1);
				var paramName = '';
				var paramValue = '';
				if(params.indexOf('&')){
					params = params.split('&');
					for(var i=0;i<params.length;i++){
						var param = params[i];
						paramName = param.split('=')[0];
						paramValue = param.split('=')[1];
						str = str + '"'+paramName+'":"'+paramValue+'",';
					}
					str = str.substring(0, str.length-1);
				}else{
					paramName = params.split('=')[0];
					paramValue = params.split('=')[1];
					str = str + '"'+paramName+'":"'+paramValue+'"';
				}
				eval('var str='+str + '}');
				if(parameterName){
					returnValue = str[parameterName];
					
				}else{
					returnValue = str;
				}
			}else{
				returnValue = str;
			}
			
			return returnValue;
		}
	});
})(jQuery);