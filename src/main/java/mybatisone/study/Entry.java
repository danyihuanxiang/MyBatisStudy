package mybatisone.study;

public class Entry {
    public static void main(String[] args) {
        StudySqlSession studySqlSession=new StudySqlSession(new StudySimpleExecutor(),new StudyConfiguration());
        SchoolMapper mapper = studySqlSession.getMapper(SchoolMapper.class);
        System.out.println(mapper.selectByPrimaryKey(1));
    }
}
