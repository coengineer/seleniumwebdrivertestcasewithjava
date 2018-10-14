# SeleniumWebDriverTestCasewithJava

Test Koşturulan Ortam Bilgileri Aşağıdaki Gibidir.

Selenium Web Driver 		: 3.14.0
IDE                 		: Eclips Python 4.8 64-bit sürümü
OS                  		: "windows 10", version: "10.0", arch: "amd64"
Browser             		: Chrome 69.0.3497.100 (64 bit) Sürümü 
Kullanılan Dil      		: Java
Junit version       		: 4.12
Java version				: 10.0.2
Maven-plugin version		: 3.8.0

---------------------------------------------------------------------------------------------------------------
--Ayarlamalar--

Chrome ayarlamasin için aşağıdaki linkte bulunan size uygun chromedriver.exe dosyasını indirin 
http://chromedriver.chromium.org/downloads

testBaseClass.java içerisinde aşağıda bulunan kodu bulun ve indirdiğiniz driver'ın yolunu gösterin ve kaydedin.
System.setProperty("webdriver.chrome.driver", "Driver Yolu");

Firefox ayarlaması için aşağıda linkte bulunan size uygun driver'ı indirin ;
https://github.com/mozilla/geckodriver/releases

testBaseClass.java içerisinde aşağıda bulunan kodu bulun ve indirdiğiniz driver'ın yolunu gösterin ve kaydedin.

System.setProperty("webdriver.gecko.driver", "Driver Yolu");

Selenium_Test.java dosyasını Junit ile çalıştırın.
Test Koşturma işlemi başlayacak ...
---------------------------------------------------------------------------------------------------------------
--Test Senaryosu--
1.  http://www.amazon.com sitesine gelecek ve anasayfanin acildigini onaylayacak,
2. Login ekranini acip, bir kullanici ile login olacak ( daha once siteye uyeligi varsa o olabilir )
3. Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak,
4. Gelen sayfada samsung icin sonuc bulundugunu onaylayacak,
5. Arama sonuclarindan 2. sayfaya tiklayacak ve acilan sayfada 2.sayfanin su an gosterimde oldugunu onaylayacak,
6. Ustten 3. urunun icindeki 'Add to List' butonuna tiklayacak,
7. Ekranin en ustundeki 'List' linkine tiklayacak içerisinden Wish listi seçecek,
8. Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak,
9. Favorilere alinan bu urunun yanindaki 'Delete' butonuna basarak, favorilerimden cikaracak,
10. Sayfada bu urunun artik favorilere alinmadigini onaylayacak.

