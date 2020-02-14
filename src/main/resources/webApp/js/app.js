app = (function () {
    var dataList;

    return {
        setData: function () {
            dataList = document.getElementById("data").value;
            
        },

        showResultCalculation: function (result) {
            $("#lista").empty();
            
            var datos = JSON.parse(result);
            var lista = "Mean : " +datos.mean;

            $("#lista").append(lista);
            
        },

        showHello: function (result) {
            $("#lista").empty();
            
            var datos = JSON.parse(result);
            var lista = "Mean : " +datos.lista;

            $("#lista").append(lista);
            
        },

        calculate: function () {           
            app.setData();
            //document.getElementById("funcionesTxt").innerHTML = "function app";
            api.getResult(dataList, app.showResultCalculation);
            
        }
    };
})();

api = (function () {

    
    return {      
        getResult: function (dataList, callback) {
            //alert( "Load was performed." );
            $.get( '/calculator/'+dataList, function( data ) {
        	    callback(data);
        		
        		});
        	
        },
        getHello: function (dataList, callback) {
            //alert( "Load was performed." );
            $.get( '/hello'+dataList, function( data ) {
        	    callback(data);
        		
        		});
        	
        }
    };

})();