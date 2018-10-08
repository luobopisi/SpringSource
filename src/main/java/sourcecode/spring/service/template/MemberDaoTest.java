package sourcecode.spring.service.template;


import sourcecode.spring.service.template.dao.MemberDao;

/**
 * Created by Tom on 2018/3/11.
 */
public class MemberDaoTest {

    public static void test() {

        MemberDao memberDao = new MemberDao();
        memberDao.query();

    }
}
