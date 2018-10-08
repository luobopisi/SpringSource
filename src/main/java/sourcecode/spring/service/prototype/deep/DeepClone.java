package sourcecode.spring.service.prototype.deep;


public class DeepClone {
    //对比浅复制和深度复制
    public static void test() {

        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

        try {
            //重写了复制方法 深度复制
            QiTianDaSheng clone = (QiTianDaSheng)qiTianDaSheng.clone();//
            System.out.println( qiTianDaSheng == clone); //false
            System.out.println( qiTianDaSheng.jinGuBang == clone.jinGuBang); //false 此处是深复制

        } catch (Exception e) {
            e.printStackTrace();
        }



        QiTianDaSheng q = new QiTianDaSheng();
        QiTianDaSheng n = q.copy(q);
        System.out.println(q.jinGuBang == n.jinGuBang);

    }
}
