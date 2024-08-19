package test;

import model.beans.Product;
import model.dao.ProductDao;
import model.dao.ProductDaoImpl;

public class DaoTest {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        ProductDao dao = new ProductDaoImpl();

        Product pro = dao.search(4);

        System.out.println(pro);
//
//        List<Product> a = dao.list(50,0);
//
//        for (Product ab: a) {
//            System.out.println(ab.toString());
//        }
//
//        UserDao dao1 = new UserDaoImpl();
//
//        boolean ca = dao1.registration("ab", "b", false);
//
//        System.out.println(ca);
//
//        Object d = dao1.login("NAGATA", "1234");
//        System.out.println(d.toString());


//        CartDao dao = new CartDaoImpl();


    }

}
