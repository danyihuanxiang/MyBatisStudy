package mybatisone.study;

public interface StudyExexutor {

    <T> T query(String statement, String paramerer);
}
