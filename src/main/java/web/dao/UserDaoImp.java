package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    /*
    @PersistenceContext - Spring подставит потокобезопасный прокси, привязанный к текущей транзакции:
    Аннотация @PersistenceContext и Spring внедряет в компонент готовый EntityManager.
    По умолчанию бин с аннотацией @Repository в Spring имеет область видимости singleton, а сам EntityManager по спецификации JPA не является потокобезопасным.
    Spring решает это противоречие с помощью специального прокси.

    Источник: https://www.google.com/search?q=%D1%87%D1%82%D0%BE+%D0%B4%D0%B5%D0%BB%D0%B0%D0%B5%D1%82+%D0%B0%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F+PersistenceContext&client=firefox-b-d&hs=wtgB&sca_esv=486cc575cdbb3b6a&sxsrf=AKL5yDjkjU1vaYVtjjcre85IhwudOGO3zw%3A1795009901416&ei=ba39arKAGZ3ZwPAP7eiU6AI&biw=1270&bih=1039&uact=5&oq=%D1%87%D1%82%D0%BE+%D0%B4%D0%B5%D0%BB%D0%B0%D0%B5%D1%82+%D0%B0%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F+PersistenceContext&gs_lp=Egxnd3Mtd2l6LXNlcnAiOdGH0YLQviDQtNC10LvQsNC10YIg0LDQvdC90L7RgtCw0YbQuNGPIFBlcnNpc3RlbmNlQ29udGV4dDIJECEYChigARgqSOyAAVCHBliBd3ADeAGQAQCYAa4BoAH_GaoBBTEzLjE4uAEDyAEA-AEB-AECmAIZoAK2E8ICChAAGEcY1gQYsAPCAg4QABjkAhjWBBiwA9gBAcICFxAuGNwGGLgGGNoGGNgCGMgDGLAD2AEBwgIKEAAYgAQYigUYQ8ICBRAAGIAEwgIEECMYJ8ICCBAAGIAEGLQHwgIFECEYoAHCAgYQABgeGA3CAgUQABjvBcICBhAAGBYYHsICCBAAGIAEGKIEmAMAiAYBkAYPugYGCAEQARgJkgcFMTMuMTKgB4SqAbIHBTEwLjEyuAejE8IHBjAuNi4xOcgHWIAIAQ&sclient=gws-wiz-serp&mstk=AUtExfA9K2Py3QeB1GB45AcdMg6oGyNALqQIaZIvs0fIEACUG_ilmlbmSWUyBDdUdouiq6oQmtJGGoV03p5kgF4DLvwQW6xsXiCRpOHhHeYa0PptwDVsZG5bOc6ji5Ndwm7DqVc0nkMSVO-DDaXJ5cfXa_z9X4w1GW5XjUwVgDRHAjj1ZN9PhXDtoCTgpAPxL0KohdhLGEvHCYxDT6bJaq4aaFAuSjRD65Nlf5M2CbDS6MDaYvKueGcwBYXTv1Jjlk01wNdJw4Mez430uefAgSvchu-TCIg8KbiMbo_NOSUvz6K9CFyAf_FdiIBVPNRmx58ZyUMgtAOIrV6Lpw&csuir=1&udm=50&aioh=3&mtid=KZ3-arfoIs2g1fIP1eW1uA8#aof=1
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
