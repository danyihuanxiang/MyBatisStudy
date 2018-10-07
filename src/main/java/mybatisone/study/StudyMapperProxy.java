package mybatisone.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudyMapperProxy implements InvocationHandler {
    private StudySqlSession studeySqlSession;

    public StudyMapperProxy(StudySqlSession studeySqlSession) {
        this.studeySqlSession = studeySqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(StudyConfiguration.SchoolMapperXml.namespace)){
            String sql = StudyConfiguration.SchoolMapperXml.mapperMap.get(method.getName());
          return    studeySqlSession.selectOne(sql,String.valueOf(args[0]));

        }
        return null;
    }
}
