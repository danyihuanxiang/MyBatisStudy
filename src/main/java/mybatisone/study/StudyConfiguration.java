package mybatisone.study;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class StudyConfiguration {
    public <T> T getMapper(Class clazz,StudySqlSession StudySqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new StudyMapperProxy(StudySqlSession));
    }

    /**
     * 伪解析XML
     * 只适合当前类做测试用
     */
    static class SchoolMapperXml{
        public static final String namespace="mybatisone.study.SchoolMapper";
        public static final Map<String,String> mapperMap=new HashMap<>();
        static {
            mapperMap.put("selectByPrimaryKey","select * from School where SchoolId =%d");
        }


    }
}
