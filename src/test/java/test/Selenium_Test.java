package test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Selenium_Test extends testPageObjectModel{
	
		WebDriverWait wait= new WebDriverWait(driver, 1000);
	
	
		//Anasayfa Kontrolü
		@Test
		public void test_1_1_WebSiteControl()
		{
			
			driver.get(siteUrl);
			//waitForPageLoad();
			Assert.assertTrue(driver.getTitle().equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
			System.out.println("Anasayfa Açıldı");
			
						
		}

		//Kullanıcı Giriş Sayfası Kontrolü
		@Test
		public void test_1_2_loginPageReadyControl()
		{			
//			wait.until(isClickableByXpath("//*[@id=\\\"nav-link-accountList\\\"]"));
			findByXpath("//*[@id=\"nav-link-accountList\"]").click();
			//findByXpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span").click();
			wait.until(isClickableById("continue"));
			Assert.assertTrue(findById("continue").getText().equals("Continue"));
			System.out.println("Sayfa giriş için hazır");
				

		}
		
		//Kullanıcı girişi kontrolü
		@Test
		public void test_1_3_loginControl()
		{
			wait.until(isClickableById("ap_email"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			findById("ap_email").sendKeys("seleniumtestcasejava@gmail.com");//Please enter the mail address
			findById("continue").click();
			wait.until(isClickableById("ap_password"));
			findById("ap_password").sendKeys("123456");//Please enter the password
			findById("signInSubmit").click(); //login button
			System.out.println("Kullanıcı Girişi Başarılı ");
			
		}
		
		//samsung için arama sonucu 
		@Test
		public void test_1_4_searchControl(){
			
			wait.until(isClickableById("twotabsearchtextbox"));
			findById("twotabsearchtextbox").sendKeys("samsung");
			findByClassName("nav-input").click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
			//wait.until(isClickableByClassName("pagination"));
			String resultOk=findByXpath("//*[@id=\"quartsPagelet\"]").getText();
			Assert.assertTrue(resultOk.contains("results for samsung"));
			System.out.println("Samsung için sonuç bulundu");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			
		}
		
		
		//samsung için çıkan sayfalardan 2. sayfanın tıklanması 
		@Test
		public void test_1_5_clickPageAndPageTwoOpenedControl(){
			
				
			findByXpath("//*[@id=\"pagn\"]/span[3]/a").click();
			//waitForPageLoad();
			
			Assert.assertTrue(findByXpath("/html/head/meta[3]").getAttribute("content").contains("Page 2"));
			System.out.println("2. Sayfa Gösterimde ...");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		}
		
		//2. sayfadaki üstten 3. ürünün favorilere eklenmesi
		@Test
		public void test_1_6_addThirdProductFavorite(){
			
			
			//Listede 3. Ürün Oluşana Kadar Bekle
			wait.until(isClickableById("result_18"));
			selectedProduct=getElementTextByXpath("//*[@id=\"result_18\"]/div/div/div/div[2]/div[1]/div[1]/a/h2");//3. ürünün adının alınması
			findByXpath("//*[@id=\"result_18\"]/div/div/div/div[2]/div[1]/div[1]/a/h2").click();//3. ürüne tıklanması
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
			findByXpath("//*[@id=\"add-to-wishlist-button-submit\"]").click(); //3. ürünün içindeki Add to List  butonuna tıklanması
			System.out.println("Favoriye Eklenen Ürün Adı : "+selectedProduct);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			
		}
		
		//istek listelerim/favorilerim linkine tıklanması
		@Test
		public void test_1_7_clickMyFavorite(){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", findByXpath("//*[@id=\"WLHUC_result_listName\"]/a"));
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		}

		//Favorilerimde daha önce eklenmiş ürünün onaylanma testi
		@Test
		public void test_1_8_clickedFavoriteConfirmation(){
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			List<WebElement> productTitles=findListByXpath("//*[@id=\"g-items\"]/li");//*[@id=\"resultsCol\"]/div/div/ul/li/div/div/div/div[2]/div/div/a
			for (WebElement productTitle : productTitles) {
				favoriesCount+=1;
				String watchesProduct=productTitle.getText();
				if (watchesProduct.contains(selectedProduct)) {
					System.out.println("Favoriye Eklenen Ürün Onaylandı.Ürünün Başlığı :"+selectedProduct+"\n");
					DeleteFavorite=favoriesCount;
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
					Assert.assertTrue(watchesProduct.contains(selectedProduct));
				}
			}
		}
		
		
		
		//Favorilerden aynı ürünün silinme testi
		@Test
		public void test_1_9_deleteSelectedProduct(){
			
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			findByXpath("//*[@id=\"a-autoid-7\"]/span").click();			
			waitForPageLoad();
			
			
		}
		
		//Silinen ürünün favorilerim listesinde bulunmadığının testi
		@Test
		public void test_2_1_checkDeletedFavorite(){
			
			
			List<WebElement> productTitles= findListByXpath("//*[@id=\"g-items\"]/li");
			for (WebElement productTitle : productTitles) {
				String watchesProduct=productTitle.getText();
				if (watchesProduct!=selectedProduct) {
					isThereProduct=true;
				}
			}
			Assert.assertFalse(isThereProduct);
			System.out.println("Favorilerim Sayfasında "+selectedProduct+" isimli ürün artık bulunmuyor ...");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		}
		
		
		
		
		
		
		
		
		
}
