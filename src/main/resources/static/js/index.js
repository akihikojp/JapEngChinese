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
        	
        		//デフォルトで表示される。	
            let japan = languageMap.get('Japanese');
            $('#inputTextarea').text(japan.text);

        	
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