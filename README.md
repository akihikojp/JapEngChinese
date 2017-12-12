DBからの情報を取得する。
-jQueryバージョン
※テンプレはThymeleaf

```
・SQL再構成
Drop table languages;

CREATE TABLE `languages` (
  `id` int(11) NOT NULL,
  `language` LONGTEXT,
  `text` LONGTEXT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


Insert into languages (id,language,text) VALUES(1,'English','AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA');
Insert into languages (id,language,text) VALUES(2,'Japanese','ああああああああああああああああああああああああああああああああさああああああああああああああああああ');
Insert into languages (id,language,text) VALUES(3,'Chinese','亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜亜');

Drop table users;

CREATE TABLE `JapEngChi`.`users` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `default_language` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


Insert into users (id,name,default_language) VALUES(1,'Mr.Google','English');
Insert into users (id,name,default_language) VALUES(2,'山田山尾','Japanese');
Insert into users (id,name,default_language) VALUES(3,'習近平','Chinese');
Insert into users (id,name,default_language) VALUES(4,'Mr.Amazon','English');
Insert into users (id,name,default_language) VALUES(5,'村井村尾','Japanese');
Insert into users (id,name,default_language) VALUES(6,'鄧小平','Chinese');


```




```
jQueryで書いてみた
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
```