# projectX

# 1 - Kullanılan Teknolojiler :

 -Java 1.8
 
 -Spring Framework 5.2.2
 
 -Hibernate 4.3.1
 
 -MySql
 
 -Apache Tomcat 8.5.37
 
 -Apache Maven 3.6.0

# 2 - Kurulum :

 -db.sql dosyası herhangi bir veri tabanı sisteminde çalıştırılarak tablolar oluşturulabilir.
 
 -/src/main/resources/hibernate.cfg.xml dosyası veri tabanına göre modifiye edilmelidir.
 
 -Proje derlendikten sonra istenilen bir sunucuya yüklendiğinde çalışır hale gelecektir.

 
 # 3 - Kullanımı :
 
  -Bu projede 4 adet servis bulunmaktadır;
  
   3.1 - /web/PhoneBook/getNumbers :
   
    -Parametre almadan çalışır.
    
    -Number tablosundaki kayıtları JSON formatında döner.
    
   3.2 - /web/PhoneBook/getPeople :
   
    -Parametre almadan çalışır.
    
    -Person tablosundaki kayıtları ve her kayıt için Number tablosundaki foreign key bağlantısına sahip olan kayıtları JSON formatında döner.
    
   3.3 - web/PhoneBook/addPerson?name=:name
   
    - "name" parametresini alır.
    
    - Person tablosuna yeni bir kayıt atar
    
   3.4 - web/PhoneBook/addNumber?personId=:personId&number=:number
   
    - "personId" ve "number" parametrelerini alır.
    
    - Number tablosuna yeni bir kayıt atar. "personId" parametresi Person tablosunda bir kayıda denk düşmelidir.
    
   # 4 - Curl ile yapılabilecek örnekler : 
    
    - curl http://"serverIp":"serverPort"/web/PhoneBook/getPeople
    
    - curl http://"serverIp":"serverPort"/web/PhoneBook/getNumbers 
    
    - curl -X POST "http://"serverIp":"serverPort"/web/PhoneBook/addPerson?name=test"
    
    - curl -X POST "http://"serverIp":"serverPort"/web/PhoneBook/addNumber?personId=1&number=8378"
    
