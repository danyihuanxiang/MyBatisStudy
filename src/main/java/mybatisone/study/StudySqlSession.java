package mybatisone.study;



public class StudySqlSession {
  private StudyExexutor studyExexutor;
  private StudyConfiguration studyConfiguration;

    public StudySqlSession(StudyExexutor studyExexutor, StudyConfiguration studyConfiguration) {
        this.studyExexutor = studyExexutor;
        this.studyConfiguration = studyConfiguration;
    }
       public <T> T getMapper(Class clazz){
            return    studyConfiguration.getMapper(clazz,this);
       }

       public <T> T selectOne(String statement,String paramerer){
            return    studyExexutor.query(statement,paramerer);
       }
}
