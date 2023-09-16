import model.*;

import java.util.LinkedList;
import java.util.List;

public class TestResumeData {

    private static String ach1 = "Организация команды и успешная реализация \" +\n" +
            "\"Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, \" +\n" +
            "\"система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + \" +\n" +
            "\"Vaadin проект для комплексных DIY смет";
    private static String ach2 = "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
            "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". " +
            "Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.";
    private static String ach3 = "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, " +
            "DuoSecurity, Google Authenticator, Jira, Zendesk.";
    private static String ach4 = "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
            "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
            "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.";
    private static String ach5 = "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), " +
            "Commet, HTML5, Highstock для алгоритмического трейдинга.";
    private static String ach6 = "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов " +
            "(SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
            "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).";
    private static String ach7 = "Реализация протоколов по приему платежей всех основных платежных системы России " +
            "(Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.";


    private static String q1 = "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2";
    private static String q2 = "Version control: Subversion, Git, Mercury, ClearCase, Perforce";
    private static String q3 = "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB";
    private static String q4 = "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy";
    private static String q5 = "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts";
    private static String q6 = "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot)," +
            " JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).";
    private static String q7 = "Python: Django.";
    private static String q8 = "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js";
    private static String q9 = "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka";
    private static String q10 =  "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB," +
            " RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, " +
            "HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.";
    private static String q11 = "Инструменты: Maven + plugin development, Gradle, настройка Ngnix";
    private static String q12 = "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer";
    private static String q13 = "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования";
    private static String q14 = "Родной русский, английский \"upper intermediate\"";


    public static void main(String[] args) {
        Resume resume = new Resume("uuid1","Григорий Кислин");

        resume.setContact(ContactType.PHONE , "+7(921) 855-0482");
        resume.setContact(ContactType.MAIL , "gkislin@yandex.ru");
        resume.setContact(ContactType.MESSENGER , "skype:grigory.kislin");
        resume.setContact(ContactType.LINKEDIN , "https://www.linkedin.com/in/gkislin");
        resume.setContact(ContactType.GITHUB , "https://github.com/gkislin");
        resume.setContact(ContactType.STACKOVERFLOW , "https://stackoverflow.com/users/548473");
        resume.setContact(ContactType.HOME_PAGE , "http://gkislin.ru/");


        List<String> achievementList = new LinkedList<>();
        achievementList.add(ach1);
        achievementList.add(ach2);
        achievementList.add(ach3);
        achievementList.add(ach4);
        achievementList.add(ach5);
        achievementList.add(ach6);
        achievementList.add(ach7);

        List<String> qualificationsList = new LinkedList<>();
        qualificationsList.add(q1);
        qualificationsList.add(q2);
        qualificationsList.add(q3);
        qualificationsList.add(q4);
        qualificationsList.add(q5);
        qualificationsList.add(q6);
        qualificationsList.add(q7);
        qualificationsList.add(q8);
        qualificationsList.add(q9);
        qualificationsList.add(q10);
        qualificationsList.add(q11);
        qualificationsList.add(q12);
        qualificationsList.add(q13);
        qualificationsList.add(q14);



        resume.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.setSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям "));
        resume.setSection(SectionType.ACHIEVEMENT, new ListSection(achievementList));
        resume.setSection(SectionType.QUALIFICATIONS, new ListSection(qualificationsList));
        resume.setSection(SectionType.EXPERIENCE, new CompanySection());
        resume.setSection(SectionType.EDUCATION, new CompanySection());

        resume.addExperience("Java Online Projects",
                "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок.", new Period(10, 2013));
        resume.addExperience("Wrike", "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                        "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.", new Period(10,2014,1,2016));
        resume.addExperience("RIT Center", "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), " +
                        "миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                        "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
                        "Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. " +
                        "Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat, WSO2, xcmis, OpenCmis, Bonita, " +
                        "Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python", new Period(4,2012,10,2014));
        resume.addExperience("Luxoft (Deutsche Bank)", "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). " +
                        "Реализация клиентской и серверной части CRM. " +
                        "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. " +
                        "JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.", new Period(12,2010,4,2012));
        resume.addExperience("Yota", "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                        "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)",
                        new Period(6,2008,12,2010));
        resume.addExperience("Enkata", "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).",
        new Period(3,2007, 6,2008));
        resume.addExperience("Siemens AG", "Разработчик ПО",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).", new Period(1,2005,2,2007));
        resume.addExperience("Alcatel","Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).",new Period(9,1997,1,2005));

        resume.addEducation("Coursera","'Functional Programming Principles in Scala' by Martin Odersky",
                new Period(3,2013,5,2013));
        resume.addEducation("Luxoft","Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'",
                new Period(3,2011,4,2011));
        resume.addEducation("Siemens AG","3 месяца обучения мобильным IN сетям (Берлин)", new Period(1,2005,4,2005));
        resume.addEducation("Alcatel","6 месяцев обучения цифровым телефонным сетям (Москва)", new Period(9,1997,3,1998));
        resume.addEducation("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "Аспирантура (программист С, С++)", new Period(9,1993,7,1996));
        resume.addEducation("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "Инженер (программист Fortran, C)", new Period(9,1987,7,1993));
        resume.addEducation("Заочная физико-техническая школа при МФТИ","Закончил с отличием", new Period(9,1984 ,6,1987));


        System.out.println(resume);
    }
}
