/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author s.lugovskiy
 */
public class Constants {
    
    public String baseUrl = "http://master.hudson.sagl/";
   
 
    
    //database==========================================
    public String mysqlDatabaseName = "trunk_city";
    public String ipDB = "10.8.0.228";
    public String userDB = "root";
    public String passwordDB = "!QAZ1qaz";
    //==================================================
    
    //corporative site
    public String siteCOntrolPanelName = "Панель управления";
    public String siteAnaliticName = "Аналитика";
    public String siteLiveBaseName = "Live Product Base";
    public String recommendSystemName = "Система рекомендаций";
    public String dataManagementLink = "Data Management Platform";
    public String dynamicOptimization = "Dynamic Creative Optimization";
    public String emailPlatform = "E-mail платформа";
    public String blogUrl = "http://blog.cityads.ru/";
    
    //goods catalog
    public String goodsCatalogName ="Каталог товаров";
    public String goodsCatalogH1Name="Каталог товаров";
    public int goodsCardCountExpected = 20;
    public String downloadPricePlatformName = "Выгрузки прайс-площадок"; //выгрузки прайс площадок
    public String downloadPricePlatformH1Name = "Добавление фида";
    
    //goods category
    public String goodsCategoryName ="Категории";
    public String goodsCategoryH1Name ="Категории";
    
    //offer card
    public String offerTab1 = "Сводная";
    public String offerTab2 = "Условия";
    public String offerTab3 = "Доходность";
    public String offerTab4 = "Выплаты";
    public String offerTab5 = "Инструменты";
    public String offerTab6 = "Аналитика";
    public String offerTab7 = "Стабильность";
    public String popupInstrumentsName = "Инструменты по офферу";
   
    //payment and calculation
    public String paymentH1Name = "Начисления и выплаты";
    public String paymentName = "Начисления и выплаты";
    
    
    //price platform
    public String pricePlatformName = "Прайс площадка";
    public String pricePlatformH1Name = "Прайс площадка";
    
    //financial feed
    public String financialFeedName = "Финансовый фид";
    public String financialFeedH1Name = "Финансовый фид";
    public String feedAddName = "Добавление фида";
    
    //wm exchange course
    public String wmExchangeH1Name = "Курс обмена";
    public String wmExchangeName = "Курс обмена";
    public String wmExchangeTab1 ="RUB";
    public String wmExchangeTab2 ="USD";
    public String wmExchangeTab3 ="EUR";
    public String wmExchangeTab4 ="UAH";
    public String wmExchangeTab5 ="KZT";
    public String wmExchangeTab6 ="CNY";
    public String wmExchangeTab7 ="BRL";
            
    
     //wm links rotator
    public String wmlinksRotatorName = "Ротатор ссылок";
    public String wmlinksRotatorH1Name = "Ротатор ссылок";  
    public int wmLinksRotatorMaxBanners = 4;
    public int wmLinksRotatorMaxOffers = 3;//
    public String wmlinksEditorH1Name = "Редактор ссылок"; 
    public String singleOfferName = "003.RU";
    
    //wm teaser issue
    public String wmteaserIssueName = "Тизерная выдача";
    public String wmteaserIssueh1Name = "Тизерная выдача";
    public int minPrice = 1000;
    public int maxPrice = 5000;
    
    //wm opetation history 
    public String wmOperationHistoryH1Name = "История операций";
    public String wmOperationHistoryName = "История операций";
    
    //wm top offers
    public String wmTopOffersName="Топ офферов";
    public String wmTopOfferh1Name = "Рейтинги";
    
    
    //wm conversion postback
    public String wmConversionPostbackH1Name = "Conversion Postback";
    public String wmConversionPostbackAddH1Name = "Новый Postback";
     
   //wm my domain
    public String wmMyDomainsName = "Мои домены";
    public String wmMyDomainsh1Name = "Мои домены";
    public String wmMyDomainsNewDomain = "ya.ru";

    //wm svodnaya
    public String svodnayaTitle = "Сводная";
    public String newsTitle = "Новости";
    
    
    //wm offer list
    public String wmOfferListName = "Список офферов";
    public String wmOfferListh1Name = "Список офферов";
    
    //wm rotator bannerov
    public String rotatorBannerovTitle ="Ротатор баннеров";
    public String rotatorBannerovAddTitle ="Добавление ротатора";

    //wm for login
    public String wmLoginName = "e898@cityads.ru";
    public String wmAnotherLoginName = "e893@cityads.ru";
    
    //webmaster profile
    public String wmProfileName = "webmasterName1";
    public String wmProfileSkype = "testSkypeName";
    public String wmprofileIcq = "346776456";
    public String wmProfileMobile = "12312312312312";
    public String wmProfiletop20Nick = "top20 asdfasdfasdf";
    public String wmProfileTab2CurrencyName ="WEBMONEY 123321";
    public String wmProfileTab2CountNumber ="Z123123123123";
    public String individualTargetWMName = "e898@cityads.ru";
    public String wmProfileExternalCountName = "wmProfileExternalCountName";
    public String wmProfileCurrency ="USD";
    
    
    //wm statistic
    public String wmStatisticNameByOffers = "По офферам";
    public String wmStatisticNameH1ByOffers = "По офферам";
    public String statHits = "Хиты";
    
    //manager kampanii
    public String campaignName ="Домашние деньги: Займы";
    
    //manager individual target
    
    public String targetId = "q1";
    public String targetname = "q1";
    public Double targetPPA = 10.0;
    public String targetSimplePrx = "337990395"; 
    public String postbackIpADress;
    public String currencySelectId = "1";
    public String targetParameterValue ="10";
    public String targetParameterType = "Кол-во загрузок";
    
    
    
    //manager zayavki na schet
    public String reklName = "A101";
    public String accountIdSelectValue ="1024";
    public String summFull = "100";
    public String documentNumber = "123123";
    public String secondSum = "100";
    public String targetCount = "3";
    
    
    //wm banner rotator
    public String width = "240";
    public String height = "400";
    public  String wmPassword = "12345";
    public String subAccount = "САБАКАУНЬТ";
    
    
    //wm Coupons And Promocodes
    public String promocodesName = "Купоны и промокоды";
    public String promocodesh1Name = "Купоны и промокоды";
    
    //smart banners
    public String smartBannersName = "Динамические баннеры";
    public String smartBannersH1Name = "Динамические баннеры";
    
    
    //registration
    public final String tempMailUrl = "http://mailinator.com/";
    public final String regPassword = "12345678";
    
    public String getCurrentDate(){
        int i= 0;
        Date j = new Date();
        j.getTime();
        i++;
        DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        String newDate = df.format(j);  
        return newDate;
    }
    public String getMyInternalIp(){
           try{ 
            InetAddress i = InetAddress.getLocalHost();
            String ip = (i.getHostAddress());
            return ip;
           }
           catch(Exception e){
            return null;    
           }
    }
    //generates random int number between 100 and 10000 for order_id
    public String getRandomIntNumber(){  
        Random rand = new Random();
        int min = 100;
        int max = 10000;
        String randomNum = Integer.toString(rand.nextInt((max - min)));
        return randomNum;
        
    }  
    
    
    public String getRandomIcqNumber(){  
        Random rand = new Random();
        int min = 146776456;
        int max = 346776456;
        String randomNum = Integer.toString(rand.nextInt((max - min)));
        return randomNum;
        
    } 


    public String getRandomPhoneNumber(){
        Random rand = new Random();
        int min = 1234567891;
        int max = 1934567891;
        String randomNumber = Integer.toString(rand.nextInt((max - min)))+"9";
        return randomNumber;
    }

    public String getRandomString(){
        Random rng = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] text = new char[10];
        for (int i = 0; i < 10; i++)
        {
        text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
        }
    
    public String getRandomStringForMonkey(){
        Random rng = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int min = 9;
        int max = 15;
        Random rand2 = new Random();
        int stringLenght = rand2.nextInt((max - min) + 1) + min;
        char[] text = new char[stringLenght];
        for (int i = 0; i < stringLenght; i++)
        {
        text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
        }
    
    
    //========================Manager===============================
    //==============================================================
    
        public String mgrLogin = "dkrivitski@gameleads.ru";
        public String mgrSvodnayaName = "Сводная"    ;
        public String managerOtcherPeriod="01.01.1970 - 18.10.2013";
}
