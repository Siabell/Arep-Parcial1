app = (function () {
    var dataList;

    return {
        setData: function () {
            dataList = document.getElementById("data").value;
            
        },

        showResultCalculation: function (result) {
            $("#lista").empty();
            
            var datos = JSON.parse(result);
            //alert(datos);
            var lista = "Lista ordenada: " +datos.lista;

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
        	
        }
    };

})();