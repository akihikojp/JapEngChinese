 $(function(){
    var contextPath = document.getElementById("contextPath").value;
    var searchLanguage = {};
    var languageMap = new Map();
    
        $.ajax({
            url: contextPath + 'getlanguage',
            dataType: "json",
            type: "get"
        })
        .done(function(searchLanguages){
        	for(lang of searchLanguages)
                if(lang.language == 'Japanese'){
                    languageMap.set('Japanese', lang);
                }else if(lang.language == 'English'){
                    languageMap.set('English', lang);
                }else if(lang.language == 'Chinese'){
                    languageMap.set('Chinese', lang);
            }
        	
        	
   
        	/**ここから!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        	
        	
            var defaultLanguage = $('#default_language')["0"].firstChild.data;
            let country = languageMap.get(defaultLanguage);
            $('#inputTextarea').text(country.text);

            $('#sampleSelect option').filter(function(index){
            	return $(this).text() === 'Strawberry'; // Strawberryを選択する場合
            }).prop('selected', true);
            
            $('.select-language').filther(function(index){
            	return $(this).text() === country.language;
            }).attr("checked", true);
            
            
//            if(country.language == this.$('.select-language').val()){
//            	this.$('.select-language').attr("checked", true);
//            }
          
            
            var color1 = document.getElementsByName("color1");
        	for (var i = 0; i < color1.length; i++){
        		if(color1[i].checked) //(color1[i].checked === true)と同じ
        			str = color1[i].value;
        	}
        	
        	
        	})
        ,function(){};

        
        $('input[name="selectedRadio"]:radio').change(function(){ 
            let selectedLanguage = $(this).val();
        switch (selectedLanguage){
            case 'Japanese':
              let japan = languageMap.get('Japanese');
            $('#inputTextarea').text(japan.text);
              break;
            case 'English':
            let english = languageMap.get('English');
            $('#inputTextarea').text(english.text);
              break;
            case 'Chinese':
            let chinese = languageMap.get('Chinese');
            $('#inputTextarea').text(chinese.text);
              break;
          }
    });
});